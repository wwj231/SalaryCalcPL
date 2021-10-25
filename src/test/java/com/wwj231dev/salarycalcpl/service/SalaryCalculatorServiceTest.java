package com.wwj231dev.salarycalcpl.service;

import com.wwj231dev.salarycalcpl.model.SalaryInputData;
import com.wwj231dev.salarycalcpl.model.salarybreakdown.SalaryComponentsBreakdown;
import com.wwj231dev.salarycalcpl.model.salarybreakdown.TotalSalaryBreakdown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCalculatorServiceTest {

    Map<Month, BigDecimal> bruttoMonthlySalaryMap = new LinkedHashMap<>();
    SalaryInputData salaryInputData;
    SalaryCalculatorService salaryCalculatorService;
    TotalSalaryBreakdown totalSalaryBreakdownToCompare;
    SalaryComponentsBreakdown salaryComponentsBreakdownToCompare;
    SalaryComponentsBreakdown salaryTotalComponentsBreakdownToCompare;
    Map<Month, SalaryComponentsBreakdown> salaryComponentsBreakdownByMonthMapToCompare = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {

    }

    @Test
    void breakdownSalaryTest1() {

        //Input
        for (int i = 1; i <= 12; i++) {
            bruttoMonthlySalaryMap.put(Month.of(i), BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP));
        }
        salaryInputData = new SalaryInputData(bruttoMonthlySalaryMap, false, false, false);

        //To Compare
        salaryComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(292.80).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(45.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(73.50).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(411.30).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(232.98).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(200.62).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(2288.70).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(145.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(2210.72).setScale(2, RoundingMode.HALF_UP))
                .build();

        for (int i = 1; i <= 12; i++) {
            salaryComponentsBreakdownByMonthMapToCompare.put(Month.of(i), salaryComponentsBreakdownToCompare);
        }
        salaryTotalComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(36000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(3513.60).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(540.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(882.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(4935.60).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(2795.76).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(2407.44).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(27464.40).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(1740.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(26528.64).setScale(2, RoundingMode.HALF_UP))
                .build();

        totalSalaryBreakdownToCompare = new TotalSalaryBreakdown(salaryComponentsBreakdownByMonthMapToCompare, salaryTotalComponentsBreakdownToCompare);

        //Test
        salaryCalculatorService = new SalaryCalculatorService();

        assertEquals(totalSalaryBreakdownToCompare, salaryCalculatorService.breakdownSalary(salaryInputData));

    }

    @Test
    void breakdownSalaryTest2() {

        //Input
        for (int i = 1; i <= 12; i++) {
            bruttoMonthlySalaryMap.put(Month.of(i), BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP));
        }
        salaryInputData = new SalaryInputData(bruttoMonthlySalaryMap, false, false, true);

        //To Compare
        salaryComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(292.80).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(45.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(73.50).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(411.30).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(232.98).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(200.62).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.ZERO.setScale(2))
                .capitalBuildingPlanEmployerContribution(BigDecimal.ZERO.setScale(2))
                .income(BigDecimal.valueOf(2338.70).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(153.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(2202.72).setScale(2, RoundingMode.HALF_UP))
                .build();

        for (int i = 1; i <= 12; i++) {
            salaryComponentsBreakdownByMonthMapToCompare.put(Month.of(i), salaryComponentsBreakdownToCompare);
        }
        salaryTotalComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(36000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(3513.60).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(540.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(882.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(4935.60).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(2795.76).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(2407.44).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.ZERO.setScale(2))
                .capitalBuildingPlanEmployerContribution(BigDecimal.ZERO.setScale(2))
                .income(BigDecimal.valueOf(28064.40).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(1836.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(26432.64).setScale(2, RoundingMode.HALF_UP))
                .build();

        totalSalaryBreakdownToCompare = new TotalSalaryBreakdown(salaryComponentsBreakdownByMonthMapToCompare, salaryTotalComponentsBreakdownToCompare);

        //Test
        salaryCalculatorService = new SalaryCalculatorService();

        assertEquals(totalSalaryBreakdownToCompare, salaryCalculatorService.breakdownSalary(salaryInputData));

    }

    @Test
    void breakdownSalaryTest3() {

        //Input
        for (int i = 1; i <= 12; i++) {
            bruttoMonthlySalaryMap.put(Month.of(i), BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP));
        }
        salaryInputData = new SalaryInputData(bruttoMonthlySalaryMap, true, false, false);

        //To Compare
        salaryComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(292.80).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(45.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(73.50).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(411.30).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(232.98).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(200.62).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(2288.70).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(2355.72).setScale(2, RoundingMode.HALF_UP))
                .build();

        for (int i = 1; i <= 12; i++) {
            salaryComponentsBreakdownByMonthMapToCompare.put(Month.of(i), salaryComponentsBreakdownToCompare);
        }
        salaryTotalComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(36000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(3513.60).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(540.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(882.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(4935.60).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(2795.76).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(2407.44).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(27464.40).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(28268.64).setScale(2, RoundingMode.HALF_UP))
                .build();

        totalSalaryBreakdownToCompare = new TotalSalaryBreakdown(salaryComponentsBreakdownByMonthMapToCompare, salaryTotalComponentsBreakdownToCompare);

        //Test
        salaryCalculatorService = new SalaryCalculatorService();

        assertEquals(totalSalaryBreakdownToCompare, salaryCalculatorService.breakdownSalary(salaryInputData));

    }

    @Test
    void breakdownSalaryTest4() {

        //Input
        for (int i = 1; i <= 12; i++) {
            bruttoMonthlySalaryMap.put(Month.of(i), BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP));
        }
        salaryInputData = new SalaryInputData(bruttoMonthlySalaryMap, false, true, false);

        //To Compare
        salaryComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(3000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(292.80).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(45.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(73.50).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(411.30).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(232.98).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(200.62).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(60.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(45.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(2333.70).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(152.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(2143.72).setScale(2, RoundingMode.HALF_UP))
                .build();

        for (int i = 1; i <= 12; i++) {
            salaryComponentsBreakdownByMonthMapToCompare.put(Month.of(i), salaryComponentsBreakdownToCompare);
        }
        salaryTotalComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(36000.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(3513.60).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(540.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(882.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(4935.60).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(2795.76).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(2407.44).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(720.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(540.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(28004.40).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(1824.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(25724.64).setScale(2, RoundingMode.HALF_UP))
                .build();

        totalSalaryBreakdownToCompare = new TotalSalaryBreakdown(salaryComponentsBreakdownByMonthMapToCompare, salaryTotalComponentsBreakdownToCompare);

        //Test
        salaryCalculatorService = new SalaryCalculatorService();

        assertEquals(totalSalaryBreakdownToCompare, salaryCalculatorService.breakdownSalary(salaryInputData));
    }

    @Test
    void breakdownSalaryTest5() {

        //Input
        for (int i = 1; i <= 12; i++) {
            bruttoMonthlySalaryMap.put(Month.of(i), BigDecimal.valueOf(8600.00).setScale(2, RoundingMode.HALF_UP));
        }
        salaryInputData = new SalaryInputData(bruttoMonthlySalaryMap, false, false, false);

        //To Compare
        salaryComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(8600.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(839.36).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(129.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(210.70).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(1179.06).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(667.88).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(575.12).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(7120.94).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(592.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(6161.06).setScale(2, RoundingMode.HALF_UP))
                .build();

        for (int i = 1; i <= 12; i++) {
            salaryComponentsBreakdownByMonthMapToCompare.put(Month.of(i), salaryComponentsBreakdownToCompare);
        }

        salaryTotalComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(103200.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(10072.32).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(1548.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(2528.40).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(14148.72).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(8014.56).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(6901.44).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(85451.28).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(7104.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(73932.72).setScale(2, RoundingMode.HALF_UP))
                .build();

        totalSalaryBreakdownToCompare = new TotalSalaryBreakdown(salaryComponentsBreakdownByMonthMapToCompare, salaryTotalComponentsBreakdownToCompare);

        //Test
        salaryCalculatorService = new SalaryCalculatorService();

        assertEquals(totalSalaryBreakdownToCompare, salaryCalculatorService.breakdownSalary(salaryInputData));

    }

    @Test
    void breakdownSalaryTest6() {

        //Input
        for (int i = 1; i <= 12; i++) {
            bruttoMonthlySalaryMap.put(Month.of(i), BigDecimal.valueOf(8700.00).setScale(2, RoundingMode.HALF_UP));
        }
        salaryInputData = new SalaryInputData(bruttoMonthlySalaryMap, false, false, false);

        //To Compare
        salaryComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(8700.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(849.12).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(130.50).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(213.15).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(1192.77).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(675.65).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(581.81).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(7207.23).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(601.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(6230.58).setScale(2, RoundingMode.HALF_UP))
                .build();

        for (int i = 1; i <= 11; i++) {
            salaryComponentsBreakdownByMonthMapToCompare.put(Month.of(i), salaryComponentsBreakdownToCompare);
        }

        salaryComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(8700.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(849.12).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(130.50).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(213.15).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(1192.77).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(675.65).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(581.81).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(7207.23).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(744.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(6087.58).setScale(2, RoundingMode.HALF_UP))
                .build();

        salaryComponentsBreakdownByMonthMapToCompare.put(Month.of(12), salaryComponentsBreakdownToCompare);

        salaryTotalComponentsBreakdownToCompare = SalaryComponentsBreakdown.builder()
                .bruttoSalary(BigDecimal.valueOf(104400).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceRetirementContribution(BigDecimal.valueOf(10189.44).setScale(2, RoundingMode.HALF_UP))
                .socialInsurancePensionContribution(BigDecimal.valueOf(1566.00).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceSickLeaveContribution(BigDecimal.valueOf(2557.80).setScale(2, RoundingMode.HALF_UP))
                .socialInsuranceComponentsSum(BigDecimal.valueOf(14313.24).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceContribution(BigDecimal.valueOf(8107.80).setScale(2, RoundingMode.HALF_UP))
                .healthcareInsuranceTaxAllowance(BigDecimal.valueOf(6981.72).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployeeContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .capitalBuildingPlanEmployerContribution(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP))
                .income(BigDecimal.valueOf(86486.76).setScale(2, RoundingMode.HALF_UP))
                .incomeTax(BigDecimal.valueOf(7355.00).setScale(2, RoundingMode.HALF_UP))
                .nettoSalary(BigDecimal.valueOf(74623.96).setScale(2, RoundingMode.HALF_UP))
                .build();

        totalSalaryBreakdownToCompare = new TotalSalaryBreakdown(salaryComponentsBreakdownByMonthMapToCompare, salaryTotalComponentsBreakdownToCompare);

        //Test
        salaryCalculatorService = new SalaryCalculatorService();

        assertEquals(totalSalaryBreakdownToCompare, salaryCalculatorService.breakdownSalary(salaryInputData));

    }
}