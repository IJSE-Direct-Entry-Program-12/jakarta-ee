package lk.ijse.dep12.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = ProfilePictureValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProfilePicture {
    String message() default "Not an image or unsupported image type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
