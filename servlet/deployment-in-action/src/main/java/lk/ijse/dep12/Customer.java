package lk.ijse.dep12;

public class Customer {

    static {
        System.out.println("Customer class object is being initialized");
        System.out.println("Customer: " + Customer.class.getClassLoader());
    }
}
