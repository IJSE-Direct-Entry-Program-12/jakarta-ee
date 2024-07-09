import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Positive
    private int id;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$", message = "${validatedValue += 'something'} is invalid name")
    private String name;
    @NotBlank(message = "address can't be empty or null")
    @Length(min = 3)
    private String address;
}
