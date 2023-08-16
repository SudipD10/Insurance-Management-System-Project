package Main;


public class Policy {
    private Integer policyId;
    private String policyType;
    private Integer policyAmount;
    private String policyNumber;
    private Customer customer;


    public Policy(){

    }
    public Policy(Integer policyId, String policyType, Integer policytAmount, String policyNumber, Customer customer) {
        this.policyId = policyId;
        this.policyType = policyType;
        this.policyAmount = policytAmount;
        this.policyNumber = policyNumber;
        this.customer = customer;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Integer getPolicytAmount() {
        return policyAmount;
    }

    public void setPolicytAmount(Integer policytAmount) {
        this.policyAmount = policytAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId='" + policyId + '\'' +
                ", policyType='" + policyType + '\'' +
                ", policytAmount='" + policyAmount + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", customer=" + customer +
                '}';
    }
}
