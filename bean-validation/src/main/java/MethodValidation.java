import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.executable.ExecutableValidator;
import org.hibernate.validator.constraints.Length;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidation {

    public static void main(String[] args) {
        try (ValidatorFactory vf = Validation.buildDefaultValidatorFactory()) {
            ExecutableValidator validator = vf.getValidator().forExecutables();

            MethodValidation instance = new MethodValidation();

            Method method = MethodValidation.class
                    .getDeclaredMethod("printCustomer", int.class, String.class, String.class);
            Object[] arguments = {-5, "Kasun", "Galle"};

            Set<ConstraintViolation<MethodValidation>> constraintViolations =
                    validator.validateParameters(instance, method, arguments);
            if (constraintViolations.isEmpty()) {
                method.invoke(instance, arguments);
            }else{
                System.out.println("Validation failed");
                constraintViolations.forEach(System.out::println);
            }
            //instance.printCustomer(-5, "Kasun123", "Galle");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printCustomer(@Positive int id,
                              @NotBlank(message = "Customer name can't be empty or null")
                              @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid customer name")
                              String name,
                              @NotBlank(message = "Customer address can't be empty or null")
                              @Length(min = 3, message = "Invalid customer address")
                              String address) {
        System.out.printf("id=%d, name=%s, address=%s\n", id, name, address);
    }
}
