import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = DobValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dob {
    String message() default "18ath 60ath athara ekek wenna oni";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
