package lk.ijse.dep12.validation;

import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProfilePictureValidator implements ConstraintValidator<ProfilePicture, Part> {
    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part != null) {
            return part.getContentType().startsWith("image/");
        }else{
            return true;
        }
    }
}
