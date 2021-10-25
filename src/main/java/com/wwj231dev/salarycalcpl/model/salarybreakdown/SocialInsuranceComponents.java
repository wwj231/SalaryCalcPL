package com.wwj231dev.salarycalcpl.model.salarybreakdown;

import java.math.BigDecimal;
import java.util.Objects;

public class SocialInsuranceComponents {
    private BigDecimal socialInsuranceRetirementContribution;
    private BigDecimal socialInsurancePensionContribution;
    private BigDecimal socialInsuranceSickLeaveContribution;
    private BigDecimal socialInsuranceComponentsSum;

    public SocialInsuranceComponents(final BigDecimal socialInsuranceRetirementContribution, final BigDecimal socialInsurancePensionContribution,
                                     final BigDecimal socialInsuranceSickLeaveContribution, final BigDecimal socialInsuranceComponentsSum) {
        this.socialInsuranceRetirementContribution = socialInsuranceRetirementContribution;
        this.socialInsurancePensionContribution = socialInsurancePensionContribution;
        this.socialInsuranceSickLeaveContribution = socialInsuranceSickLeaveContribution;
        this.socialInsuranceComponentsSum = socialInsuranceComponentsSum;
    }

    @Override
    public String toString() {
        return "SocialInsuranceComponents{" +
                "socialInsuranceRetirementContribution=" + socialInsuranceRetirementContribution +
                ", socialInsurancePensionContribution=" + socialInsurancePensionContribution +
                ", socialInsuranceSickLeaveContribution=" + socialInsuranceSickLeaveContribution +
                ", socialInsuranceTotal=" + socialInsuranceComponentsSum +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SocialInsuranceComponents that = (SocialInsuranceComponents) o;
        return getSocialInsuranceRetirementContribution().equals(that.getSocialInsuranceRetirementContribution()) && getSocialInsurancePensionContribution().equals(that.getSocialInsurancePensionContribution()) && getSocialInsuranceSickLeaveContribution().equals(that.getSocialInsuranceSickLeaveContribution()) && getSocialInsuranceComponentsSum().equals(that.getSocialInsuranceComponentsSum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSocialInsuranceRetirementContribution(), getSocialInsurancePensionContribution(), getSocialInsuranceSickLeaveContribution(), getSocialInsuranceComponentsSum());
    }

    public BigDecimal getSocialInsuranceRetirementContribution() {
        return socialInsuranceRetirementContribution;
    }

    public void setSocialInsuranceRetirementContribution(final BigDecimal socialInsuranceRetirementContribution) {
        this.socialInsuranceRetirementContribution = socialInsuranceRetirementContribution;
    }

    public BigDecimal getSocialInsurancePensionContribution() {
        return socialInsurancePensionContribution;
    }

    public void setSocialInsurancePensionContribution(final BigDecimal socialInsurancePensionContribution) {
        this.socialInsurancePensionContribution = socialInsurancePensionContribution;
    }

    public BigDecimal getSocialInsuranceSickLeaveContribution() {
        return socialInsuranceSickLeaveContribution;
    }

    public void setSocialInsuranceSickLeaveContribution(final BigDecimal socialInsuranceSickLeaveContribution) {
        this.socialInsuranceSickLeaveContribution = socialInsuranceSickLeaveContribution;
    }

    public BigDecimal getSocialInsuranceComponentsSum() {
        return socialInsuranceComponentsSum;
    }

    public void setSocialInsuranceComponentsSum(final BigDecimal socialInsuranceComponentsSum) {
        this.socialInsuranceComponentsSum = socialInsuranceComponentsSum;
    }
}
