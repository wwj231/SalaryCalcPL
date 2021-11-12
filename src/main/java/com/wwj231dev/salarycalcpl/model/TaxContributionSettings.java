package com.wwj231dev.salarycalcpl.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class TaxContributionSettings {

    //Employee
    private BigDecimal socialInsuranceRetirementRate;
    private BigDecimal socialInsurancePensionRate;
    private BigDecimal socialInsuranceSickLeaveRate;
    private BigDecimal socialRetirementPensionYearlyBaseLimit;

    private BigDecimal healthcareInsuranceRate;
    private BigDecimal healthcareInsuranceTaxAllowanceRate;

    private BigDecimal capitalBuildingPlanEmployeeRate;
    private BigDecimal capitalBuildingPlanEmployerRate;

    private Map<Boolean, BigDecimal> monthlyCostsOfGettingIncome = new LinkedHashMap<>();

    private Map<Integer, BigDecimal> taxRateThresholds = new LinkedHashMap<>();
    private Map<Integer, BigDecimal> taxRateThresholdsRates = new LinkedHashMap<>();
    private Map<Integer, BigDecimal> taxFreeThresholds = new LinkedHashMap<>();
    private Map<Integer, BigDecimal> taxFreeThresholdsValues = new LinkedHashMap<>();

    public TaxContributionSettings() {

    }

    public TaxContributionSettings(final BigDecimal socialInsuranceRetirementRate, final BigDecimal socialInsurancePensionRate, final BigDecimal socialInsuranceSickLeaveRate, final BigDecimal socialRetirementPensionYearlyBaseLimit, final BigDecimal healthcareInsuranceRate, final BigDecimal healthcareInsuranceTaxAllowanceRate, final BigDecimal capitalBuildingPlanEmployeeRate, final BigDecimal capitalBuildingPlanEmployerRate, final Map<Boolean, BigDecimal> monthlyCostsOfGettingIncome, final Map<Integer, BigDecimal> taxRateThresholds, final Map<Integer, BigDecimal> taxRateThresholdsRates, final Map<Integer, BigDecimal> taxFreeThresholds, final Map<Integer, BigDecimal> taxFreeThresholdsValues) {
        this.socialInsuranceRetirementRate = socialInsuranceRetirementRate;
        this.socialInsurancePensionRate = socialInsurancePensionRate;
        this.socialInsuranceSickLeaveRate = socialInsuranceSickLeaveRate;
        this.socialRetirementPensionYearlyBaseLimit = socialRetirementPensionYearlyBaseLimit;
        this.healthcareInsuranceRate = healthcareInsuranceRate;
        this.healthcareInsuranceTaxAllowanceRate = healthcareInsuranceTaxAllowanceRate;
        this.capitalBuildingPlanEmployeeRate = capitalBuildingPlanEmployeeRate;
        this.capitalBuildingPlanEmployerRate = capitalBuildingPlanEmployerRate;
        this.monthlyCostsOfGettingIncome = monthlyCostsOfGettingIncome;
        this.taxRateThresholds = taxRateThresholds;
        this.taxRateThresholdsRates = taxRateThresholdsRates;
        this.taxFreeThresholds = taxFreeThresholds;
        this.taxFreeThresholdsValues = taxFreeThresholdsValues;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TaxContributionSettings that = (TaxContributionSettings) o;
        return Objects.equals(getSocialInsuranceRetirementRate(), that.getSocialInsuranceRetirementRate()) && Objects.equals(getSocialInsurancePensionRate(), that.getSocialInsurancePensionRate()) && Objects.equals(getSocialInsuranceSickLeaveRate(), that.getSocialInsuranceSickLeaveRate()) && Objects.equals(getSocialRetirementPensionYearlyBaseLimit(), that.getSocialRetirementPensionYearlyBaseLimit()) && Objects.equals(getHealthcareInsuranceRate(), that.getHealthcareInsuranceRate()) && Objects.equals(getHealthcareInsuranceTaxAllowanceRate(), that.getHealthcareInsuranceTaxAllowanceRate()) && Objects.equals(getCapitalBuildingPlanEmployeeRate(), that.getCapitalBuildingPlanEmployeeRate()) && Objects.equals(getCapitalBuildingPlanEmployerRate(), that.getCapitalBuildingPlanEmployerRate()) && Objects.equals(getMonthlyCostsOfGettingIncome(), that.getMonthlyCostsOfGettingIncome()) && Objects.equals(getTaxRateThresholds(), that.getTaxRateThresholds()) && Objects.equals(getTaxRateThresholdsRates(), that.getTaxRateThresholdsRates()) && Objects.equals(getTaxFreeThresholds(), that.getTaxFreeThresholds()) && Objects.equals(getTaxFreeThresholdsValues(), that.getTaxFreeThresholdsValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSocialInsuranceRetirementRate(), getSocialInsurancePensionRate(), getSocialInsuranceSickLeaveRate(), getSocialRetirementPensionYearlyBaseLimit(), getHealthcareInsuranceRate(), getHealthcareInsuranceTaxAllowanceRate(), getCapitalBuildingPlanEmployeeRate(), getCapitalBuildingPlanEmployerRate(), getMonthlyCostsOfGettingIncome(), getTaxRateThresholds(), getTaxRateThresholdsRates(), getTaxFreeThresholds(), getTaxFreeThresholdsValues());
    }

    @Override
    public String toString() {
        return "TaxContributionSettings{" +
                "socialInsuranceRetirementRate=" + socialInsuranceRetirementRate +
                ", socialInsurancePensionRate=" + socialInsurancePensionRate +
                ", socialInsuranceSickLeaveRate=" + socialInsuranceSickLeaveRate +
                ", socialRetirementPensionYearlyBaseLimit=" + socialRetirementPensionYearlyBaseLimit +
                ", healthcareInsuranceRate=" + healthcareInsuranceRate +
                ", healthcareInsuranceTaxAllowanceRate=" + healthcareInsuranceTaxAllowanceRate +
                ", capitalBuildingPlanEmployeeRate=" + capitalBuildingPlanEmployeeRate +
                ", capitalBuildingPlanEmployerRate=" + capitalBuildingPlanEmployerRate +
                ", monthlyCostsOfGettingIncome=" + monthlyCostsOfGettingIncome +
                ", taxRateThresholds=" + taxRateThresholds +
                ", taxRateThresholdsRates=" + taxRateThresholdsRates +
                ", taxFreeThresholds=" + taxFreeThresholds +
                ", taxFreeThresholdsValues=" + taxFreeThresholdsValues +
                '}';
    }

    public BigDecimal getSocialInsuranceRetirementRate() {
        return socialInsuranceRetirementRate;
    }

    public void setSocialInsuranceRetirementRate(final BigDecimal socialInsuranceRetirementRate) {
        this.socialInsuranceRetirementRate = socialInsuranceRetirementRate;
    }

    public BigDecimal getSocialInsurancePensionRate() {
        return socialInsurancePensionRate;
    }

    public void setSocialInsurancePensionRate(final BigDecimal socialInsurancePensionRate) {
        this.socialInsurancePensionRate = socialInsurancePensionRate;
    }

    public BigDecimal getSocialInsuranceSickLeaveRate() {
        return socialInsuranceSickLeaveRate;
    }

    public void setSocialInsuranceSickLeaveRate(final BigDecimal socialInsuranceSickLeaveRate) {
        this.socialInsuranceSickLeaveRate = socialInsuranceSickLeaveRate;
    }

    public BigDecimal getHealthcareInsuranceRate() {
        return healthcareInsuranceRate;
    }

    public void setHealthcareInsuranceRate(final BigDecimal healthcareInsuranceRate) {
        this.healthcareInsuranceRate = healthcareInsuranceRate;
    }

    public Map<Integer, BigDecimal> getTaxRateThresholdsRates() {
        return taxRateThresholdsRates;
    }

    public void setTaxRateThresholdsRates(final Map<Integer, BigDecimal> taxRateThresholdsRates) {
        this.taxRateThresholdsRates = taxRateThresholdsRates;
    }

    public Map<Integer, BigDecimal> getTaxFreeThresholdsValues() {
        return taxFreeThresholdsValues;
    }

    public void setTaxFreeThresholdsValues(final Map<Integer, BigDecimal> taxFreeThresholdsValues) {
        this.taxFreeThresholdsValues = taxFreeThresholdsValues;
    }

    public BigDecimal getHealthcareInsuranceTaxAllowanceRate() {
        return healthcareInsuranceTaxAllowanceRate;
    }

    public void setHealthcareInsuranceTaxAllowanceRate(final BigDecimal healthcareInsuranceTaxAllowanceRate) {
        this.healthcareInsuranceTaxAllowanceRate = healthcareInsuranceTaxAllowanceRate;
    }

    public BigDecimal getSocialRetirementPensionYearlyBaseLimit() {
        return socialRetirementPensionYearlyBaseLimit;
    }

    public void setSocialRetirementPensionYearlyBaseLimit(final BigDecimal socialRetirementPensionYearlyBaseLimit) {
        this.socialRetirementPensionYearlyBaseLimit = socialRetirementPensionYearlyBaseLimit;
    }

    public BigDecimal getCapitalBuildingPlanEmployeeRate() {
        return capitalBuildingPlanEmployeeRate;
    }

    public void setCapitalBuildingPlanEmployeeRate(final BigDecimal capitalBuildingPlanEmployeeRate) {
        this.capitalBuildingPlanEmployeeRate = capitalBuildingPlanEmployeeRate;
    }

    public BigDecimal getCapitalBuildingPlanEmployerRate() {
        return capitalBuildingPlanEmployerRate;
    }

    public void setCapitalBuildingPlanEmployerRate(final BigDecimal capitalBuildingPlanEmployerRate) {
        this.capitalBuildingPlanEmployerRate = capitalBuildingPlanEmployerRate;
    }

    public Map<Boolean, BigDecimal> getMonthlyCostsOfGettingIncome() {
        return monthlyCostsOfGettingIncome;
    }

    public void setMonthlyCostsOfGettingIncome(final Map<Boolean, BigDecimal> monthlyCostsOfGettingIncome) {
        this.monthlyCostsOfGettingIncome = monthlyCostsOfGettingIncome;
    }

    public Map<Integer, BigDecimal> getTaxRateThresholds() {
        return taxRateThresholds;
    }

    public void setTaxRateThresholds(final Map<Integer, BigDecimal> taxRateThresholds) {
        this.taxRateThresholds = taxRateThresholds;
    }

    public Map<Integer, BigDecimal> getTaxFreeThresholds() {
        return taxFreeThresholds;
    }

    public void setTaxFreeThresholds(final Map<Integer, BigDecimal> taxFreeThresholds) {
        this.taxFreeThresholds = taxFreeThresholds;
    }

    public void updateTaxContributionSettings(TaxContributionSettings newTaxContributionSettings) {
        this.socialInsuranceRetirementRate = newTaxContributionSettings.getSocialInsuranceRetirementRate();
        this.socialInsurancePensionRate = newTaxContributionSettings.getSocialInsurancePensionRate();
        this.socialInsuranceSickLeaveRate = newTaxContributionSettings.getSocialInsuranceSickLeaveRate();
        this.socialRetirementPensionYearlyBaseLimit = newTaxContributionSettings.getSocialRetirementPensionYearlyBaseLimit();
        this.healthcareInsuranceRate = newTaxContributionSettings.getHealthcareInsuranceRate();
        this.healthcareInsuranceTaxAllowanceRate = newTaxContributionSettings.getHealthcareInsuranceTaxAllowanceRate();
        this.capitalBuildingPlanEmployeeRate = newTaxContributionSettings.getCapitalBuildingPlanEmployeeRate();
        this.capitalBuildingPlanEmployerRate = newTaxContributionSettings.getCapitalBuildingPlanEmployerRate();
        this.monthlyCostsOfGettingIncome = newTaxContributionSettings.getMonthlyCostsOfGettingIncome();
        this.taxRateThresholds = newTaxContributionSettings.getTaxRateThresholds();
        this.taxRateThresholdsRates = newTaxContributionSettings.getTaxRateThresholdsRates();
        this.taxFreeThresholds = newTaxContributionSettings.getTaxFreeThresholds();
        this.taxFreeThresholdsValues = newTaxContributionSettings.getTaxFreeThresholdsValues();
    }
}
