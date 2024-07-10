import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class EmployeeValidation {

    public static void main(String[] args) {
        saveEmployee();
        updateEmployee();
    }

    public static void saveEmployee(){
        try (ValidatorFactory vf = Validation.buildDefaultValidatorFactory()) {
            Validator validator = vf.getValidator();
            Employee employee = new Employee(null, "Kasun Sampath", "Panadura");
            Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
            if (constraintViolations.isEmpty()) {
                System.out.println("Employee added successfully");
            }else{
                System.out.println("Save failed. Validation failed");
                constraintViolations.forEach(System.out::println);
            }
        }
    }

    public static void updateEmployee(){
        try (ValidatorFactory vf = Validation.buildDefaultValidatorFactory()) {
            Validator validator = vf.getValidator();
            Employee employee = new Employee("E-001", "Kasun Sampath", "Panadura");
            Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee, Update.class);
            if (constraintViolations.isEmpty()) {
                System.out.println("Employee updated successfully");
            }else{
                System.out.println("Update failed. Validation failed");
                constraintViolations.forEach(System.out::println);
            }
        }
    }
}
