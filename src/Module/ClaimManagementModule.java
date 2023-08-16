package Module;

import InsuranceProject.entity.Claim;
import InsuranceProject.entity.Customer;
import InsuranceProject.entity.Policy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static InsuranceProject.module.CustomerManagementModule.findCustomer;
import static InsuranceProject.module.PolicyManagementModule.policyMap;

public class ClaimsManagementModule {
    public static final Map<Integer, Claim> claimMap = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void claimMenu() {
        System.out.println("\t              Claim Menu");
        System.out.println("\t                 1. Create Claim");
        System.out.println("\t                 2. View Claim Details ");
        System.out.println("\t                 3. Update Claim");
        System.out.println("\t                 4. Delete Claim\n");
    }

    public static void createClaim() {

        Claim claim = new Claim();
        System.out.println("\t             pls enter your customer Id:  ");
        Integer id = scanner.nextInt();
        claim.setClaimId(id);
        Policy policy = policyMap.get(id);
        Customer customer = findCustomer(id);
        if(policy ==null && customer ==null){
            System.out.println("You do not have a account and policy , pls create those first ");
            System.exit(-1);
        }
        boolean policyExists = false;
        if (policy != null) {
            policyExists = claim.setDoesPolicyExist(true);
        }
        System.out.println("\t              pls enter claim amount");
        Double claimAmount = scanner.nextDouble();
        claim = new Claim(id, policyExists, claimAmount, customer, policy);
        claimMap.put(id, claim);
        System.out.println("Claim created");
    }
    public static void showClaimDetails(){
        System.out.println("Pls enter your customer ID ");
        Integer id = scanner.nextInt();
        Claim claim = claimMap.get(id);
        System.out.println(claim);

    }
    public static void updateClaimDetails(){
        System.out.println("Update Claim page - only claim amount can be updated.  ");
        System.out.println("Pls enter your customer ID ");
        Integer id = scanner.nextInt();
        Policy policy = policyMap.get(id);
        Customer customer = findCustomer(id);
        System.out.println("Enter the new claim amount");
        int claimAmount = scanner.nextInt();
        Claim claim = new Claim(id,true,claimAmount,customer,policy);

    }
    public static void deleteClaim(){
        System.out.println("Pls enter your customer ID ");
        Integer id = scanner.nextInt();
        Claim deletedClaim = claimMap.remove(id);
        System.out.println("Claim Deleted => "+claimMap);


    }

}
