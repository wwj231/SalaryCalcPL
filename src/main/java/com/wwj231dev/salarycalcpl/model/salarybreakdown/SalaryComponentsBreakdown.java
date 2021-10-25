package com.wwj231dev.salarycalcpl.model.salarybreakdown;

import java.math.BigDecimal;
import java.util.Objects;

public class SalaryComponentsBreakdown {
    private BigDecimal bruttoSalary;
    private BigDecimal socialInsuranceRetirementContribution;
    private BigDecimal socialInsurancePensionContribution;
    private BigDecimal socialInsuranceSickLeaveContribution;
    private BigDecimal socialInsuranceComponentsSum;
    private BigDecimal healthcareInsuranceContribution;
    private BigDecimal healthcareInsuranceTaxAllowance;
    private BigDecimal capitalBuildingPlanEmployeeContribution;
    private BigDecimal capitalBuildingPlanEmployerContribution;
    private BigDecimal income;
    private BigDecimal incomeTax;
    private BigDecimal nettoSalary;

    private SalaryComponentsBreakdown() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private BigDecimal bruttoSalary;
        private BigDecimal socialInsuranceRetirementContribution;
        private BigDecimal socialInsurancePensionContribution;
        private BigDecimal socialInsuranceSickLeaveContribution;
        private BigDecimal socialInsuranceComponentsSum;
        private BigDecimal healthcareInsuranceContribution;
        private BigDecimal healthcareInsuranceTaxAllowance;
        private BigDecimal capitalBuildingPlanEmployeeContribution;
        private BigDecimal capitalBuildingPlanEmployerContribution;
        private BigDecimal income;
        private BigDecimal incomeTax;
        private BigDecimal nettoSalary;

        public Builder bruttoSalary(BigDecimal bruttoSalary){
            this.bruttoSalary = bruttoSalary;
            return this;
        }

        public Builder socialInsuranceRetirementContribution(BigDecimal socialInsuranceRetirementContribution){
            this.socialInsuranceRetirementContribution = socialInsuranceRetirementContribution;
            return this;
        }

        public Builder socialInsurancePensionContribution(BigDecimal socialInsurancePensionContribution){
            this.socialInsurancePensionContribution = socialInsurancePensionContribution;
            return this;
        }

        public Builder socialInsuranceSickLeaveContribution(BigDecimal socialInsuranceSickLeaveContribution){
            this.socialInsuranceSickLeaveContribution = socialInsuranceSickLeaveContribution;
            return this;
        }

        public Builder socialInsuranceComponentsSum(BigDecimal socialInsuranceComponentsSum){
            this.socialInsuranceComponentsSum = socialInsuranceComponentsSum;
            return this;
        }

        public Builder healthcareInsuranceContribution(BigDecimal healthcareInsuranceContribution){
            this.healthcareInsuranceContribution = healthcareInsuranceContribution;
            return this;
        }

        public Builder healthcareInsuranceTaxAllowance(BigDecimal healthcareInsuranceTaxAllowance){
            this.healthcareInsuranceTaxAllowance = healthcareInsuranceTaxAllowance;
            return this;
        }

        public Builder capitalBuildingPlanEmployeeContribution(BigDecimal capitalBuildingPlanEmployeeContribution){
            this.capitalBuildingPlanEmployeeContribution = capitalBuildingPlanEmployeeContribution;
            return this;
        }

        public Builder capitalBuildingPlanEmployerContribution(BigDecimal capitalBuildingPlanEmployerContribution){
            this.capitalBuildingPlanEmployerContribution = capitalBuildingPlanEmployerContribution;
            return this;
        }

        public Builder income(BigDecimal income){
            this.income = income;
            return this;
        }

        public Builder incomeTax(BigDecimal incomeTax){
            this.incomeTax = incomeTax;
            return this;
        }

        public Builder nettoSalary(BigDecimal nettoSalary){
            this.nettoSalary = nettoSalary;
            return this;
        }

        public SalaryComponentsBreakdown build(){
            if(bruttoSalary == null){
                throw new IllegalStateException("bruttoMonthlySalary cannot be empty");
            }
            if(socialInsuranceRetirementContribution == null){
                throw new IllegalStateException("socialInsuranceRetirementContribution cannot be empty");
            }
            if(socialInsurancePensionContribution == null){
                throw new IllegalStateException("socialInsurancePensionContribution cannot be empty");
            }
            if(socialInsuranceSickLeaveContribution == null){
                throw new IllegalStateException("socialInsuranceSickLeaveContribution cannot be empty");
            }
            if(socialInsuranceComponentsSum == null){
                throw new IllegalStateException("socialInsuranceTotal cannot be empty");
            }
            if(healthcareInsuranceContribution == null){
                throw new IllegalStateException("healthcareInsuranceContribution cannot be empty");
            }
            if(healthcareInsuranceTaxAllowance == null){
                throw new IllegalStateException("healthcareMonthlyInsuranceTaxAllowance cannot be empty");
            }
            if(capitalBuildingPlanEmployeeContribution == null){
                throw new IllegalStateException("capitalBuildingPlanEmployeeContribution cannot be empty");
            }
            if(capitalBuildingPlanEmployerContribution == null){
                throw new IllegalStateException("capitalBuildingPlanEmployerContribution cannot be empty");
            }
            if(income == null){
                throw new IllegalStateException("Income cannot be empty");
            }
            if(incomeTax == null){
                throw new IllegalStateException("incomeTax cannot be empty");
            }
            if(nettoSalary == null){
                throw new IllegalStateException("nettoMonthlySalary cannot be empty");
            }

            SalaryComponentsBreakdown monthlySalaryComponentsBreakdown =  new SalaryComponentsBreakdown();
            monthlySalaryComponentsBreakdown.bruttoSalary = this.bruttoSalary;
            monthlySalaryComponentsBreakdown.socialInsuranceRetirementContribution = this.socialInsuranceRetirementContribution;
            monthlySalaryComponentsBreakdown.socialInsurancePensionContribution = this.socialInsurancePensionContribution;
            monthlySalaryComponentsBreakdown.socialInsuranceSickLeaveContribution = this.socialInsuranceSickLeaveContribution;
            monthlySalaryComponentsBreakdown.socialInsuranceComponentsSum = this.socialInsuranceComponentsSum;
            monthlySalaryComponentsBreakdown.healthcareInsuranceContribution = this.healthcareInsuranceContribution;
            monthlySalaryComponentsBreakdown.healthcareInsuranceTaxAllowance = this.healthcareInsuranceTaxAllowance;
            monthlySalaryComponentsBreakdown.capitalBuildingPlanEmployeeContribution = this.capitalBuildingPlanEmployeeContribution;
            monthlySalaryComponentsBreakdown.capitalBuildingPlanEmployerContribution = this.capitalBuildingPlanEmployerContribution;
            monthlySalaryComponentsBreakdown.income = this.income;
            monthlySalaryComponentsBreakdown.incomeTax = this.incomeTax;
            monthlySalaryComponentsBreakdown.nettoSalary = this.nettoSalary;
            return monthlySalaryComponentsBreakdown;
        }

        public BigDecimal getBruttoSalary() {
            return bruttoSalary;
        }

        public BigDecimal getSocialInsuranceRetirementContribution() {
            return socialInsuranceRetirementContribution;
        }

        public BigDecimal getSocialInsurancePensionContribution() {
            return socialInsurancePensionContribution;
        }

        public BigDecimal getSocialInsuranceSickLeaveContribution() {
            return socialInsuranceSickLeaveContribution;
        }

        public BigDecimal getSocialInsuranceComponentsSum() {
            return socialInsuranceComponentsSum;
        }

        public BigDecimal getHealthcareInsuranceContribution() {
            return healthcareInsuranceContribution;
        }

        public BigDecimal getHealthcareInsuranceTaxAllowance() {
            return healthcareInsuranceTaxAllowance;
        }

        public BigDecimal getCapitalBuildingPlanEmployeeContribution() {
            return capitalBuildingPlanEmployeeContribution;
        }

        public BigDecimal getCapitalBuildingPlanEmployerContribution() {
            return capitalBuildingPlanEmployerContribution;
        }

        public BigDecimal getIncome() {
            return income;
        }

        public BigDecimal getIncomeTax() {
            return incomeTax;
        }

        public BigDecimal getNettoSalary() {
            return nettoSalary;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Builder builder = (Builder) o;
            return Objects.equals(getBruttoSalary(), builder.getBruttoSalary()) && Objects.equals(getSocialInsuranceRetirementContribution(), builder.getSocialInsuranceRetirementContribution()) && Objects.equals(getSocialInsurancePensionContribution(), builder.getSocialInsurancePensionContribution()) && Objects.equals(getSocialInsuranceSickLeaveContribution(), builder.getSocialInsuranceSickLeaveContribution()) && Objects.equals(getSocialInsuranceComponentsSum(), builder.getSocialInsuranceComponentsSum()) && Objects.equals(getHealthcareInsuranceContribution(), builder.getHealthcareInsuranceContribution()) && Objects.equals(getHealthcareInsuranceTaxAllowance(), builder.getHealthcareInsuranceTaxAllowance()) && Objects.equals(getCapitalBuildingPlanEmployeeContribution(), builder.getCapitalBuildingPlanEmployeeContribution()) && Objects.equals(getCapitalBuildingPlanEmployerContribution(), builder.getCapitalBuildingPlanEmployerContribution()) && Objects.equals(getIncome(), builder.getIncome()) && Objects.equals(getIncomeTax(), builder.getIncomeTax()) && Objects.equals(getNettoSalary(), builder.getNettoSalary());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getBruttoSalary(), getSocialInsuranceRetirementContribution(), getSocialInsurancePensionContribution(), getSocialInsuranceSickLeaveContribution(), getSocialInsuranceComponentsSum(), getHealthcareInsuranceContribution(), getHealthcareInsuranceTaxAllowance(), getCapitalBuildingPlanEmployeeContribution(), getCapitalBuildingPlanEmployerContribution(), getIncome(), getIncomeTax(), getNettoSalary());
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "bruttoSalary=" + bruttoSalary +
                    ", socialInsuranceRetirementContribution=" + socialInsuranceRetirementContribution +
                    ", socialInsurancePensionContribution=" + socialInsurancePensionContribution +
                    ", socialInsuranceSickLeaveContribution=" + socialInsuranceSickLeaveContribution +
                    ", socialInsuranceComponentsSum=" + socialInsuranceComponentsSum +
                    ", healthcareInsuranceContribution=" + healthcareInsuranceContribution +
                    ", healthcareMonthlyInsuranceTaxAllowance=" + healthcareInsuranceTaxAllowance +
                    ", capitalBuildingPlanEmployeeContribution=" + capitalBuildingPlanEmployeeContribution +
                    ", capitalBuildingPlanEmployerContribution=" + capitalBuildingPlanEmployerContribution +
                    ", income=" + income +
                    ", incomeTax=" + incomeTax +
                    ", nettoSalary=" + nettoSalary +
                    '}';
        }
    }

    public BigDecimal getBruttoSalary() {
        return bruttoSalary;
    }

    public BigDecimal getSocialInsuranceRetirementContribution() {
        return socialInsuranceRetirementContribution;
    }

    public BigDecimal getSocialInsurancePensionContribution() {
        return socialInsurancePensionContribution;
    }

    public BigDecimal getSocialInsuranceSickLeaveContribution() {
        return socialInsuranceSickLeaveContribution;
    }

    public BigDecimal getSocialInsuranceComponentsSum() {
        return socialInsuranceComponentsSum;
    }

    public BigDecimal getHealthcareInsuranceContribution() {
        return healthcareInsuranceContribution;
    }

    public BigDecimal getCapitalBuildingPlanEmployeeContribution() {
        return capitalBuildingPlanEmployeeContribution;
    }

    public BigDecimal getCapitalBuildingPlanEmployerContribution() {
        return capitalBuildingPlanEmployerContribution;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public BigDecimal getNettoSalary() {
        return nettoSalary;
    }

    public BigDecimal getHealthcareInsuranceTaxAllowance() {
        return healthcareInsuranceTaxAllowance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SalaryComponentsBreakdown that = (SalaryComponentsBreakdown) o;
        return Objects.equals(getBruttoSalary(), that.getBruttoSalary()) && Objects.equals(getSocialInsuranceRetirementContribution(), that.getSocialInsuranceRetirementContribution()) && Objects.equals(getSocialInsurancePensionContribution(), that.getSocialInsurancePensionContribution()) && Objects.equals(getSocialInsuranceSickLeaveContribution(), that.getSocialInsuranceSickLeaveContribution()) && Objects.equals(getSocialInsuranceComponentsSum(), that.getSocialInsuranceComponentsSum()) && Objects.equals(getHealthcareInsuranceContribution(), that.getHealthcareInsuranceContribution()) && Objects.equals(getHealthcareInsuranceTaxAllowance(), that.getHealthcareInsuranceTaxAllowance()) && Objects.equals(getCapitalBuildingPlanEmployeeContribution(), that.getCapitalBuildingPlanEmployeeContribution()) && Objects.equals(getCapitalBuildingPlanEmployerContribution(), that.getCapitalBuildingPlanEmployerContribution()) && Objects.equals(income, that.income) && Objects.equals(getIncomeTax(), that.getIncomeTax()) && Objects.equals(getNettoSalary(), that.getNettoSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBruttoSalary(), getSocialInsuranceRetirementContribution(), getSocialInsurancePensionContribution(), getSocialInsuranceSickLeaveContribution(), getSocialInsuranceComponentsSum(), getHealthcareInsuranceContribution(), getHealthcareInsuranceTaxAllowance(), getCapitalBuildingPlanEmployeeContribution(), getCapitalBuildingPlanEmployerContribution(), income, getIncomeTax(), getNettoSalary());
    }

    @Override
    public String toString() {
        return "SalaryComponentsBreakdown{" +
                "bruttoSalary=" + bruttoSalary +
                ", socialInsuranceRetirementContribution=" + socialInsuranceRetirementContribution +
                ", socialInsurancePensionContribution=" + socialInsurancePensionContribution +
                ", socialInsuranceSickLeaveContribution=" + socialInsuranceSickLeaveContribution +
                ", socialInsuranceComponentsSum=" + socialInsuranceComponentsSum +
                ", healthcareInsuranceContribution=" + healthcareInsuranceContribution +
                ", healthcareMonthlyInsuranceTaxAllowance=" + healthcareInsuranceTaxAllowance +
                ", capitalBuildingPlanEmployeeContribution=" + capitalBuildingPlanEmployeeContribution +
                ", capitalBuildingPlanEmployerContribution=" + capitalBuildingPlanEmployerContribution +
                ", income=" + income +
                ", incomeTax=" + incomeTax +
                ", nettoSalary=" + nettoSalary +
                '}';
    }
}