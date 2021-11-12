package com.wwj231dev.salarycalcpl.service;

import com.wwj231dev.salarycalcpl.model.SalaryInputData;
import com.wwj231dev.salarycalcpl.model.TaxContributionSettings;
import com.wwj231dev.salarycalcpl.model.salarybreakdown.SalaryComponentsBreakdown;
import com.wwj231dev.salarycalcpl.model.salarybreakdown.SocialInsuranceComponents;
import com.wwj231dev.salarycalcpl.model.salarybreakdown.TotalSalaryBreakdown;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class SalaryCalculatorService {

    private static final BigDecimal NUMBER_OF_MONTHS = BigDecimal.valueOf(12L);
    private static final Logger logger = LoggerFactory.getLogger(SalaryCalculatorService.class);

    private TaxContributionSettings taxContributionSettings;

    public SalaryCalculatorService() {
    }

    public TotalSalaryBreakdown breakdownSalary(final SalaryInputData salaryInputData) {
        logger.info("SalaryCalculatorService.breakdownSalary, data received : [{}]", salaryInputData);
        Map<Month, BigDecimal> bruttoMonthlySalaryMap = salaryInputData.getBruttoMonthlySalaryMap();
        Map<Month, SalaryComponentsBreakdown.Builder> salaryComponentsBreakdownByMonthBuilderMap = new LinkedHashMap<>();
        Map<Month, SalaryComponentsBreakdown> salaryComponentsBreakdownByMonthMap = new LinkedHashMap<>();

        BigDecimal totalBruttoSalary = BigDecimal.ZERO;
        BigDecimal totalSocialInsuranceRetirementContribution = BigDecimal.ZERO;
        BigDecimal totalSocialInsurancePensionContribution = BigDecimal.ZERO;
        BigDecimal totalSocialInsuranceSickLeaveContribution = BigDecimal.ZERO;
        BigDecimal totalSocialInsuranceComponentsSum = BigDecimal.ZERO;
        BigDecimal totalHealthcareInsuranceContribution = BigDecimal.ZERO;
        BigDecimal totalHealthcareInsuranceTaxAllowance = BigDecimal.ZERO;
        BigDecimal totalCapitalBuildingPlanEmployeeContribution = BigDecimal.ZERO.setScale(2);
        BigDecimal totalCapitalBuildingPlanEmployerContribution = BigDecimal.ZERO.setScale(2);
        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalIncomeUpToDate = BigDecimal.ZERO;
        BigDecimal totalIncomeTax = BigDecimal.ZERO;
        BigDecimal totalNettoSalary = BigDecimal.ZERO;

        for (int i = 1; i <= 12; i++) {
            BigDecimal bruttoMonthlySalary = bruttoMonthlySalaryMap.get(Month.of(i));
            if(bruttoMonthlySalary != null) {
                totalBruttoSalary = totalBruttoSalary.add(bruttoMonthlySalary);

                //Calculating social insurance Contribution
                SocialInsuranceComponents monthlySocialInsuranceComponents = calculateSocialInsurance(bruttoMonthlySalary, totalBruttoSalary);
                totalSocialInsuranceRetirementContribution = totalSocialInsuranceRetirementContribution.add(monthlySocialInsuranceComponents.getSocialInsuranceRetirementContribution());
                totalSocialInsurancePensionContribution = totalSocialInsurancePensionContribution.add(monthlySocialInsuranceComponents.getSocialInsurancePensionContribution());
                totalSocialInsuranceSickLeaveContribution = totalSocialInsuranceSickLeaveContribution.add(monthlySocialInsuranceComponents.getSocialInsuranceSickLeaveContribution());
                totalSocialInsuranceComponentsSum = totalSocialInsuranceComponentsSum.add(monthlySocialInsuranceComponents.getSocialInsuranceComponentsSum());

                //Calculating healthcare insurance contribution and tax allowance
                BigDecimal healthcareMonthlyInsuranceContribution = calculateHealthcareInsuranceContribution(bruttoMonthlySalary, monthlySocialInsuranceComponents.getSocialInsuranceComponentsSum());
                BigDecimal healthcareMonthlyInsuranceTaxAllowance = calculateHealthcareInsuranceTaxAllowance(bruttoMonthlySalary, monthlySocialInsuranceComponents.getSocialInsuranceComponentsSum());
                totalHealthcareInsuranceContribution = totalHealthcareInsuranceContribution.add(healthcareMonthlyInsuranceContribution);
                totalHealthcareInsuranceTaxAllowance = totalHealthcareInsuranceTaxAllowance.add(healthcareMonthlyInsuranceTaxAllowance);

                //Calculating employee capital building plan
                BigDecimal capitalBuildingPlanMonthlyEmployeeContribution = BigDecimal.ZERO.setScale(2);
                BigDecimal capitalBuildingPlanMonthlyEmployerContribution = BigDecimal.ZERO.setScale(2);

                if (salaryInputData.isEmployeeCapitalBuildingPlan()) {
                    capitalBuildingPlanMonthlyEmployeeContribution = calculateCapitalBuildingPlanEmployeeContribution(bruttoMonthlySalary);
                    capitalBuildingPlanMonthlyEmployerContribution = calculateCapitalBuildingPlanEmployerContribution(bruttoMonthlySalary);
                    totalCapitalBuildingPlanEmployeeContribution = totalCapitalBuildingPlanEmployeeContribution.add(capitalBuildingPlanMonthlyEmployeeContribution);
                    totalCapitalBuildingPlanEmployerContribution = totalCapitalBuildingPlanEmployerContribution.add(capitalBuildingPlanMonthlyEmployerContribution);
                }

                //Calculating monthly income
                BigDecimal monthlyIncome = calculateIncome(bruttoMonthlySalary, monthlySocialInsuranceComponents.getSocialInsuranceComponentsSum(), salaryInputData.isWorkResidency(), capitalBuildingPlanMonthlyEmployerContribution);
                totalIncome = totalIncome.add(monthlyIncome);

                salaryComponentsBreakdownByMonthBuilderMap.put(Month.of(i), SalaryComponentsBreakdown.builder()
                        .bruttoSalary(bruttoMonthlySalary)
                        .socialInsuranceRetirementContribution(monthlySocialInsuranceComponents.getSocialInsuranceRetirementContribution())
                        .socialInsurancePensionContribution(monthlySocialInsuranceComponents.getSocialInsurancePensionContribution())
                        .socialInsuranceSickLeaveContribution(monthlySocialInsuranceComponents.getSocialInsuranceSickLeaveContribution())
                        .socialInsuranceComponentsSum(monthlySocialInsuranceComponents.getSocialInsuranceComponentsSum())
                        .healthcareInsuranceContribution(healthcareMonthlyInsuranceContribution)
                        .healthcareInsuranceTaxAllowance(healthcareMonthlyInsuranceTaxAllowance)
                        .capitalBuildingPlanEmployeeContribution(capitalBuildingPlanMonthlyEmployeeContribution)
                        .capitalBuildingPlanEmployerContribution(capitalBuildingPlanMonthlyEmployerContribution)
                        .income(monthlyIncome)
                );
            }
        }


        for (Month month : salaryComponentsBreakdownByMonthBuilderMap.keySet()) {
            SalaryComponentsBreakdown.Builder salaryComponentsBreakdownByMonthBuilder = salaryComponentsBreakdownByMonthBuilderMap.get(month);
            totalIncomeUpToDate = totalIncomeUpToDate.add(salaryComponentsBreakdownByMonthBuilder.getIncome());
            //Calculating income tax
            BigDecimal incomeTax = calculateIncomeTax(salaryComponentsBreakdownByMonthBuilder.getIncome(), totalIncome, totalIncomeUpToDate,
                    salaryComponentsBreakdownByMonthBuilder.getHealthcareInsuranceTaxAllowance(), salaryInputData.isTaxExemptionForYoung());
            totalIncomeTax = totalIncomeTax.add(incomeTax);

            //Calculating netto salary
            BigDecimal nettoMonthlySalary = calculateNettoMonthlySalary(salaryComponentsBreakdownByMonthBuilder.getBruttoSalary(), salaryComponentsBreakdownByMonthBuilder.getSocialInsuranceComponentsSum(),
                    salaryComponentsBreakdownByMonthBuilder.getHealthcareInsuranceContribution(), salaryComponentsBreakdownByMonthBuilder.getCapitalBuildingPlanEmployeeContribution(), incomeTax);
            totalNettoSalary = totalNettoSalary.add(nettoMonthlySalary);
            salaryComponentsBreakdownByMonthMap.put(month, salaryComponentsBreakdownByMonthBuilder.incomeTax(incomeTax).nettoSalary(nettoMonthlySalary).build());
        }

        SalaryComponentsBreakdown totalSalaryComponentsBreakdown = SalaryComponentsBreakdown.builder()
                .bruttoSalary(totalBruttoSalary)
                .socialInsuranceRetirementContribution(totalSocialInsuranceRetirementContribution)
                .socialInsurancePensionContribution(totalSocialInsurancePensionContribution)
                .socialInsuranceSickLeaveContribution(totalSocialInsuranceSickLeaveContribution)
                .socialInsuranceComponentsSum(totalSocialInsuranceComponentsSum)
                .healthcareInsuranceContribution(totalHealthcareInsuranceContribution)
                .healthcareInsuranceTaxAllowance(totalHealthcareInsuranceTaxAllowance)
                .capitalBuildingPlanEmployeeContribution(totalCapitalBuildingPlanEmployeeContribution)
                .capitalBuildingPlanEmployerContribution(totalCapitalBuildingPlanEmployerContribution)
                .income(totalIncome)
                .incomeTax(totalIncomeTax)
                .nettoSalary(totalNettoSalary)
                .build();

        logger.info("SalaryCalculatorService.breakdownSalary, salary breakdown done");

        return new TotalSalaryBreakdown(salaryComponentsBreakdownByMonthMap, totalSalaryComponentsBreakdown);
    }

    private SocialInsuranceComponents calculateSocialInsurance(final BigDecimal bruttoMonthlySalary, final BigDecimal bruttoTotalSalary) {
        BigDecimal socialInsuranceRetirementContribution;
        BigDecimal socialInsurancePensionContribution;
        BigDecimal socialInsuranceSickLeaveContribution;
        BigDecimal socialInsuranceMonthlyTotal;

        if (bruttoTotalSalary.compareTo(taxContributionSettings.getSocialRetirementPensionYearlyBaseLimit()) <= 0) {
            socialInsuranceRetirementContribution = calculateSocialInsuranceComponentContribution(bruttoMonthlySalary, taxContributionSettings.getSocialInsuranceRetirementRate());
            socialInsurancePensionContribution = calculateSocialInsuranceComponentContribution(bruttoMonthlySalary, taxContributionSettings.getSocialInsurancePensionRate());
        } else {
            BigDecimal socialInsuranceContributionYearlyLimitCheck = bruttoTotalSalary.subtract(bruttoMonthlySalary);
            if (socialInsuranceContributionYearlyLimitCheck.compareTo(taxContributionSettings.getSocialRetirementPensionYearlyBaseLimit()) > 0) {
                socialInsuranceRetirementContribution = BigDecimal.ZERO;
                socialInsurancePensionContribution = BigDecimal.ZERO;
            } else {
                socialInsuranceRetirementContribution = calculateSocialInsuranceComponentContribution(socialInsuranceContributionYearlyLimitCheck, taxContributionSettings.getSocialInsuranceRetirementRate(), taxContributionSettings.getSocialRetirementPensionYearlyBaseLimit());
                socialInsurancePensionContribution = calculateSocialInsuranceComponentContribution(socialInsuranceContributionYearlyLimitCheck, taxContributionSettings.getSocialInsurancePensionRate(), taxContributionSettings.getSocialRetirementPensionYearlyBaseLimit());
            }
        }
        socialInsuranceSickLeaveContribution = calculateSocialInsuranceComponentContribution(bruttoMonthlySalary, taxContributionSettings.getSocialInsuranceSickLeaveRate());
        socialInsuranceMonthlyTotal = calculateSocialInsuranceMonthlyTotal(socialInsuranceRetirementContribution, socialInsurancePensionContribution, socialInsuranceSickLeaveContribution);
        return new SocialInsuranceComponents(socialInsuranceRetirementContribution, socialInsurancePensionContribution, socialInsuranceSickLeaveContribution, socialInsuranceMonthlyTotal);
    }

    private BigDecimal calculateSocialInsuranceComponentContribution(final BigDecimal bruttoSalary, final BigDecimal socialInsuranceRate) {
        return bruttoSalary.multiply(socialInsuranceRate).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateSocialInsuranceComponentContribution(final BigDecimal yearlyLimitCheck, final BigDecimal socialInsuranceRate, final BigDecimal socialInsuranceYearlyBaseLimit) {
        return socialInsuranceYearlyBaseLimit
                .subtract(yearlyLimitCheck)
                .multiply(socialInsuranceRate).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateSocialInsuranceMonthlyTotal(final BigDecimal... args) {
        return Arrays.stream(args).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateHealthcareInsuranceContribution(final BigDecimal bruttoSalary, final BigDecimal socialInsuranceMonthlyTotal) {
        return bruttoSalary.subtract(socialInsuranceMonthlyTotal).multiply(taxContributionSettings.getHealthcareInsuranceRate()).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateHealthcareInsuranceTaxAllowance(final BigDecimal bruttoSalary, final BigDecimal socialInsuranceMonthlyTotal) {
        return bruttoSalary.subtract(socialInsuranceMonthlyTotal).multiply(taxContributionSettings.getHealthcareInsuranceTaxAllowanceRate()).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateCapitalBuildingPlanEmployeeContribution(BigDecimal bruttoSalary) {
        return bruttoSalary.multiply(taxContributionSettings.getCapitalBuildingPlanEmployeeRate()).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateCapitalBuildingPlanEmployerContribution(BigDecimal bruttoSalary) {
        return bruttoSalary.multiply(taxContributionSettings.getCapitalBuildingPlanEmployerRate()).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateIncome(final BigDecimal bruttoMonthlySalary, final BigDecimal socialInsuranceTotal, final boolean workResidency, final BigDecimal capitalBuildingPlanEmployerContribution) {
        return bruttoMonthlySalary.subtract(socialInsuranceTotal).subtract(taxContributionSettings.getMonthlyCostsOfGettingIncome().get(workResidency)).add(capitalBuildingPlanEmployerContribution).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateIncomeTax(final BigDecimal monthlyIncome, final BigDecimal totalIncome, final BigDecimal totalIncomeUpToDate, final BigDecimal healthcareInsuranceTaxAllowance, final boolean isTaxExemptionForYoung) {
        BigDecimal incomeTax;
        Map<Integer, BigDecimal> taxRateThresholdsRatesMap = taxContributionSettings.getTaxRateThresholdsRates();
        Map<Integer, BigDecimal> taxRateThresholdsMap = taxContributionSettings.getTaxRateThresholds();


        if (totalIncomeUpToDate.compareTo(taxRateThresholdsMap.get(1)) <= 0) {
            if (isTaxExemptionForYoung) {
                return BigDecimal.ZERO.setScale(2);
            } else {
                incomeTax = monthlyIncome.multiply(taxRateThresholdsRatesMap.get(1))
                        .subtract(calculateTaxFreeValue(totalIncome)).subtract(healthcareInsuranceTaxAllowance).setScale(0, RoundingMode.HALF_UP);
                return incomeTax.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO.setScale(2) : incomeTax.setScale(2);
            }
        }

        BigDecimal taxIncomeThresholdCheck = totalIncomeUpToDate.subtract(monthlyIncome);
        if (taxIncomeThresholdCheck.compareTo(taxRateThresholdsMap.get(1)) > 0) {
            return monthlyIncome.multiply(taxRateThresholdsRatesMap.get(2))
                    .subtract(calculateTaxFreeValue(totalIncome)).subtract(healthcareInsuranceTaxAllowance).setScale(0, RoundingMode.HALF_UP).setScale(2);
        } else {
            if (isTaxExemptionForYoung){
                incomeTax = totalIncomeUpToDate.subtract(taxRateThresholdsMap.get(1)).multiply(taxRateThresholdsRatesMap.get(2))
                        .subtract(calculateTaxFreeValue(totalIncome)).subtract(healthcareInsuranceTaxAllowance).setScale(0, RoundingMode.HALF_UP);
                return incomeTax.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO.setScale(2) : incomeTax.setScale(2);
            } else {
                incomeTax = totalIncomeUpToDate.subtract(taxRateThresholdsMap.get(1)).multiply(taxRateThresholdsRatesMap.get(2));
                return incomeTax.add(taxRateThresholdsMap.get(1).subtract(taxIncomeThresholdCheck).multiply(taxRateThresholdsRatesMap.get(1))).subtract(calculateTaxFreeValue(totalIncome)).subtract(healthcareInsuranceTaxAllowance).setScale(0, RoundingMode.HALF_UP).setScale(2);
            }
        }

    }

    private BigDecimal calculateTaxFreeValue(final BigDecimal predictedYearlyIncome) {

        Map<Integer, BigDecimal> taxFreeThresholdsValuesMap = taxContributionSettings.getTaxFreeThresholdsValues();
        Map<Integer, BigDecimal> taxFreeThresholdsMap = taxContributionSettings.getTaxFreeThresholds();

        if (predictedYearlyIncome.compareTo(taxFreeThresholdsMap.get(1)) <= 0) {
            return taxFreeThresholdsValuesMap.get(1);
        }
        if (predictedYearlyIncome.compareTo(taxFreeThresholdsMap.get(2)) <= 0) {
            return calculateTaxFreeValueForIntermedium(predictedYearlyIncome, taxFreeThresholdsMap.get(1), BigDecimal.valueOf(834.88), BigDecimal.valueOf(5000L));
        }
        if (predictedYearlyIncome.compareTo(taxFreeThresholdsMap.get(3)) <= 0) {
            return taxFreeThresholdsValuesMap.get(3);
        }
        if (predictedYearlyIncome.compareTo(taxFreeThresholdsMap.get(4)) <= 0) {
            return calculateTaxFreeValueForIntermedium(predictedYearlyIncome, taxFreeThresholdsMap.get(3), taxFreeThresholdsValuesMap.get(3), BigDecimal.valueOf(41472.00));
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal calculateTaxFreeValueForIntermedium(final BigDecimal predictedYearlyIncome, final BigDecimal toSubtract, final BigDecimal base, final BigDecimal toDivide) {
        return base.subtract(predictedYearlyIncome.subtract(toSubtract).multiply(base.multiply(NUMBER_OF_MONTHS)).divide(toDivide, RoundingMode.HALF_UP).divide(NUMBER_OF_MONTHS, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP));
    }

    private BigDecimal calculateNettoMonthlySalary(final BigDecimal bruttoSalary, final BigDecimal socialInsuranceContributionSum,
                                                   final BigDecimal healthcareInsuranceContribution, final BigDecimal capitalBuildingPlanEmployeeContribution,
                                                   final BigDecimal incomeTax) {
        return bruttoSalary.subtract(socialInsuranceContributionSum)
                .subtract(healthcareInsuranceContribution)
                .subtract(incomeTax)
                .subtract(capitalBuildingPlanEmployeeContribution)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Autowired
    public void setTaxContributionSettings(final TaxContributionSettings taxContributionSettings) {
        this.taxContributionSettings = taxContributionSettings;
    }
}
