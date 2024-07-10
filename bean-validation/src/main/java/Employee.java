import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @NotBlank(message = "Employee id can't be null or empty", groups = Update.class)
    @Pattern(regexp = "^E-\\d{3}$", message = "Invalid employee id")
    private String id;
    @NotBlank(message = "Employee name can't be null or empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid employee name")
    private String name;
    @NotBlank(message = "Employee address can't be null or empty")
    @Length(min = 3, message = "Invalid employee address")
    private String address;
}
