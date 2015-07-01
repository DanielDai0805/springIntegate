package spring.context;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by dc on 2015/6/29.
 */
public class UserLoginValidator implements Validator {
    private static final int MINIMUM_PASSWORD_LENGTH = 6;
    public boolean supports(Class<?> clazz) {
        return UserLogin.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","field.required");
        UserLogin userLogin = (UserLogin) target;
        if(userLogin.getPassword()!=null &&userLogin.getPassword().trim().length()<MINIMUM_PASSWORD_LENGTH){
            errors.rejectValue("password", "field.min.length",
                                    new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},"The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
        }
    }
}
