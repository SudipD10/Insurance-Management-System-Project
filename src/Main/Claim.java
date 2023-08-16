package Main;

import java.util.Objects;

public class Claim {
    private Integer claimId;
    private boolean doesPolicyExist;
    private Double claimAmount;
    private Customer customer;
    private Policy policy;

    public Claim() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return doesPolicyExist == claim.doesPolicyExist && Objects.equals(claimId, claim.claimId) && Objects.equals(claimAmount, claim.claimAmount) && Objects.equals(customer, claim.customer) && Objects.equals(policy, claim.policy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claimId, doesPolicyExist, claimAmount, customer, policy);
    }

    public Claim(Integer claimId, boolean doesPolicyExist, double claimAmount, Customer customer, Policy policy) {
        this.claimId = claimId;
        this.doesPolicyExist = doesPolicyExist;
        this.claimAmount = claimAmount;
        this.customer = customer;
        this.policy = policy;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public boolean isDoesPolicyExist() {
        return doesPolicyExist;
    }

    public boolean setDoesPolicyExist(boolean doesPolicyExist) {
        this.doesPolicyExist = doesPolicyExist;
        return doesPolicyExist;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", doesPolicyExist=" + doesPolicyExist +
                ", claimAmount=" + claimAmount +
                ", customer=" + customer +
                ", policy=" + policy +
                '}';
    }
}
