package com.wwj231dev.salarycalcpl.model;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Map;
import java.util.Objects;

public class SalaryInputData {
    private Map<Month, BigDecimal> bruttoMonthlySalaryMap;
    private boolean isTaxExemptionForYoung;
    private boolean isEmployeeCapitalBuildingPlan;
    private boolean isWorkResidency;

    public SalaryInputData(final Map<Month, BigDecimal> bruttoMonthlySalaryMap, final boolean isTaxExemptionForYoung, final boolean isEmployeeCapitalBuildingPlan, final boolean isWorkResidency) {
        this.bruttoMonthlySalaryMap = bruttoMonthlySalaryMap;
        this.isTaxExemptionForYoung = isTaxExemptionForYoung;
        this.isEmployeeCapitalBuildingPlan = isEmployeeCapitalBuildingPlan;
        this.isWorkResidency = isWorkResidency;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SalaryInputData that = (SalaryInputData) o;
        return isTaxExemptionForYoung() == that.isTaxExemptionForYoung() && isEmployeeCapitalBuildingPlan() == that.isEmployeeCapitalBuildingPlan() && isWorkResidency() == that.isWorkResidency() && getBruttoMonthlySalaryMap().equals(that.getBruttoMonthlySalaryMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBruttoMonthlySalaryMap(), isTaxExemptionForYoung(), isEmployeeCapitalBuildingPlan(), isWorkResidency());
    }

    @Override
    public String toString() {
        return "SalaryInputData{" +
                "bruttoMonthlySalaryMap=" + bruttoMonthlySalaryMap +
                ", isTaxExemptionForYoung=" + isTaxExemptionForYoung +
                ", isEmployeeCapitalBuildingPlan=" + isEmployeeCapitalBuildingPlan +
                ", isWorkResidency=" + isWorkResidency +
                '}';
    }

    public Map<Month, BigDecimal> getBruttoMonthlySalaryMap() {
        return bruttoMonthlySalaryMap;
    }

    public void setBruttoMonthlySalaryMap(final Map<Month, BigDecimal> bruttoMonthlySalaryMap) {
        this.bruttoMonthlySalaryMap = bruttoMonthlySalaryMap;
    }

    public boolean isTaxExemptionForYoung() {
        return isTaxExemptionForYoung;
    }

    public void setTaxExemptionForYoung(final boolean taxExemptionForYoung) {
        this.isTaxExemptionForYoung = taxExemptionForYoung;
    }

    public boolean isWorkResidency() {
        return isWorkResidency;
    }

    public void setWorkResidency(final boolean workResidency) {
        this.isWorkResidency = workResidency;
    }

    public boolean isEmployeeCapitalBuildingPlan() {
        return isEmployeeCapitalBuildingPlan;
    }

    public void setEmployeeCapitalBuildingPlan(final boolean employeeCapitalBuildingPlan) {
        isEmployeeCapitalBuildingPlan = employeeCapitalBuildingPlan;
    }

}
