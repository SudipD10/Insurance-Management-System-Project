package InsuranceProject.Module;

import InsuranceProject.Main.Customer;

import java.util.*;

public class CustomerManagementModule {
    public static final Map<Integer, Customer> customerMap = new HashMap<>();
    public static  Customer getCustomerDetailsFromCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t              Please enter your details as asked: \n");
        System.out.print("\t                Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("\t                Address: ");
        String address = scanner.nextLine();
        System.out.print("\t                Phone number : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("\t                Email : ");
        String email = scanner.nextLine();
        System.out.print("\t                Id : ");
        Integer id = scanner.nextInt();
        return new Customer(id, fullName, address,phoneNumber, email);
    }
    public static Customer createCustomer() {
        Customer customer = getCustomerDetailsFromCustomer();
        customerMap.put(customer.getId(), customer);
        System.out.println("\t          Customer created successfully.");
        System.out.println("\t          Please note your ID for future reference in a secure place\n");
        return customer;
    }
    public static void displayCustomerDetails(Customer customer){
        System.out.println("\t              Customer Details: ");
        System.out.println("\t              Full Name : "+customer.getFullName());
        System.out.println("\t              Address : "+ customer.getAddress());
        System.out.println("\t              Phone Number : "+customer.getPhoneNumber());
        System.out.println("\t              Email : "+customer.getEmail());
    }


    public static Customer findCustomer(int id){
        return  customerMap.get(id);
    }

    public static Customer updateCustomer(Customer customer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t              Please inter your id to update your details: ");
        Integer id = scanner.nextInt();
        customer = findCustomer(id);
        displayCustomerDetails(customer);
        //System.out.println("Now pls enter the updated details :");
        Customer updatedCustomer = createCustomer();
        return updatedCustomer;
    }
    public static void showCustomerMenu(){
        System.out.println();System.out.println();
        System.out.println("\t                  Customers Menu");
        System.out.println("\t                      1. Create a new account.");
        System.out.println("\t                      2. Read Account detail.");
        System.out.println("\t                      3. Update your Account details.");
        System.out.println("\t                      4. Delete your account information.\n");
    }
    public static Customer getCustomerDetailsFromId(){
        System.out.println("\t              Please enter your customer Id");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        Customer cust = findCustomer(id);
        displayCustomerDetails(cust);
        return cust;
    }

    public static void deleteCustomer(){
        Customer custToDelete = getCustomerDetailsFromId();
        custToDelete.setAddress("");
        custToDelete.setEmail("");
        custToDelete.setFullName("");
        custToDelete.setPhoneNumber("");
        //custToDelete.setId(Integer.valueOf(""));
        System.out.println("\t              Customer details deleted successfully. ");
    }
}
