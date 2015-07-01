package spring.context;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by dc on 2015/6/29.
 */
public class CustomerValidator implements Validator {
    private Validator addressValidator;

    public CustomerValidator(Validator addressValidator) {
        if(addressValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is "+
                    "required and must not be null.");
        }
        if(!addressValidator.supports(Address.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must support the validation of [Address] instances.");
        }
        this.addressValidator = addressValidator;
    }

    /**
     * this validator validates Customer instance , and subclasses of Customer too
     * @param clazz
     * @return
     */
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"firstname","field.required");
        ValidationUtils.rejectIfEmpty(errors,"lastname","field.required");
        final Customer customer = (Customer) target;
        try{
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator, customer.getAddress(), errors);
        }finally {
            errors.popNestedPath();
        }

    }
}
