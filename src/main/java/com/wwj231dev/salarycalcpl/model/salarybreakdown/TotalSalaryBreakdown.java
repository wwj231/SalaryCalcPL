package com.wwj231dev.salarycalcpl.model.salarybreakdown;

import java.time.Month;
import java.util.Map;
import java.util.Objects;

public class TotalSalaryBreakdown {
    private Map<Month, SalaryComponentsBreakdown> salaryComponentsBreakdownByMonthMap;
    private SalaryComponentsBreakdown totalSalaryBreakdown;

    public TotalSalaryBreakdown(final Map<Month, SalaryComponentsBreakdown> salaryComponentsBreakdownByMonthMap, final SalaryComponentsBreakdown totalSalaryBreakdown) {
        this.salaryComponentsBreakdownByMonthMap = salaryComponentsBreakdownByMonthMap;
        this.totalSalaryBreakdown = totalSalaryBreakdown;
    }

    public Map<Month, SalaryComponentsBreakdown> getSalaryComponentsBreakdownByMonthMap() {
        return salaryComponentsBreakdownByMonthMap;
    }

    public void setSalaryComponentsBreakdownByMonthMap(final Map<Month, SalaryComponentsBreakdown> salaryComponentsBreakdownByMonthMap) {
        this.salaryComponentsBreakdownByMonthMap = salaryComponentsBreakdownByMonthMap;
    }

    public SalaryComponentsBreakdown getTotalSalaryBreakdown() {
        return totalSalaryBreakdown;
    }

    public void setTotalSalaryBreakdown(final SalaryComponentsBreakdown totalSalaryBreakdown) {
        this.totalSalaryBreakdown = totalSalaryBreakdown;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TotalSalaryBreakdown that = (TotalSalaryBreakdown) o;
        return getSalaryComponentsBreakdownByMonthMap().equals(that.getSalaryComponentsBreakdownByMonthMap()) && getTotalSalaryBreakdown().equals(that.getTotalSalaryBreakdown());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalaryComponentsBreakdownByMonthMap(), getTotalSalaryBreakdown());
    }

    @Override
    public String toString() {
        return "TotalSalaryBreakdown{" +
                "salaryComponentsBreakdownByMonthMap=" + salaryComponentsBreakdownByMonthMap +
                ", totalSalaryBreakdown=" + totalSalaryBreakdown +
                '}';
    }
}