package lk.ijse.dep12.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;
        if (password.length() < 6) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password must be at least 6 characters")
                    .addConstraintViolation();
            return false;
        }
        if (!password.matches(".*[0-9].*")) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*[a-z].*")) return false;
        Set<Character> characterSet = new HashSet<>();
        for (char c : password.toCharArray()) characterSet.add(c);
        if (characterSet.size() != password.length()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password must not contain repeated characters")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
