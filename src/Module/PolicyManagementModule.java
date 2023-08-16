package Module;

import InsuranceProject.entity.Customer;
import InsuranceProject.entity.Policy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import static InsuranceProject.module.CustomerManagementModule.createCustomer;

public class PolicyManagementModule {
    public static final Map<Integer, Policy> policyMap = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    public static Policy policy = new Policy();

    public static void showPolicyMenu() {
        System.out.println();
        System.out.println();
        System.out.println("\t              Welcome to Policy Sections, please select one from the following");
        System.out.println("\t              1. Create a new policy.");
        System.out.println("\t              2. Review policy detail.");
        System.out.println("\t              3. Update your Policy details.");
        System.out.println("\t              4. Cancel your Policy.\n");
    }

    public static void createPolicyMenu() {
        System.out.println("\t              Lets create your policy. Do you already have an account with us? press Y/N ");
        String input = scanner.nextLine();
        // scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            createPolicy();
        } else if (input.equalsIgnoreCase("N")) {

            System.out.println("\t          You will need a customer account first to create a policy\n");
            createCustomer();
        } else {
            System.out.println("\t          Wrong input");
        }
    }

    public static void createPolicy() {
        System.out.print("\t                pls enter your Customer Id to begin with: ");
        Integer id = scanner.nextInt();
        Customer customer = CustomerManagementModule.customerMap.get(id);
        policy.setCustomer(customer);
        policy.setPolicyId(id);
        System.out.print("\t                Pls enter the type of policy : ");
        String policyType = scanner.nextLine();
        scanner.nextLine();
        policy.setPolicyType(policyType);
        System.out.print("\t                Enter the coverage amount: ");
        policy.setPolicytAmount(scanner.nextInt());
        policy.setPolicyNumber(String.valueOf(UUID.randomUUID()));
        policyMap.put(id, policy);
        System.out.println("\t              Policy created Successfully for " + customer.getFullName() + "\n");

    }

    public static void showPolicyDetails() {
        System.out.println("\t              Pls enter the customer ID: ");
        Integer id = scanner.nextInt();
        policy = policyMap.get(id);
        System.out.println("\t              Here are the details:\n");
        System.out.println("\t              Policy Id = " + policy.getPolicyId());
        System.out.println("\t              Policy Type = " + policy.getPolicyType());
        System.out.println("\t              Policy Amount = " + policy.getPolicytAmount());
        System.out.println("\t              Policy Number = " + policy.getPolicyNumber() + "\n");

    }
    public static void updatePolicyDetails(){
        System.out.println("\t              Policy Update Page \n");
        showPolicyDetails();
        System.out.println("\t              update Policy Type and Policy Amount only for now here");
        System.out.print("\t                Enter Policy Type: ");
        String policyType = scanner.nextLine();
        System.out.println("\t              Enter Policy Amount");
        policy.setPolicyType(policyType);
        Integer policyAmount = scanner.nextInt();
        policy.setPolicytAmount(policyAmount);
        System.out.println("\t              Update Successful");
    }
    public static void deletePolicy(){
        System.out.println("\t              Policy Delete Page \n");
        System.out.print("\t                Please enter your Customer Id: ");
        Integer id = scanner.nextInt();
        policyMap.remove(id);
        System.out.println("\t           Policy deleted Successfully");

    }

}
