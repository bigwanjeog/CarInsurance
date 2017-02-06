/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author RENAUD
 */
public class ValidatorBean {

    public static <T> boolean validatorBean(T object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);

        if (constraintViolations.size() > 0) {
            Logger logger = Logger.getLogger(ValidatorBean.class.getName());
            for (ConstraintViolation<T> contraintes : constraintViolations) {
                String erreur = contraintes.getRootBeanClass().getSimpleName() + "." + contraintes.getPropertyPath() + " " + contraintes.getMessage();
                logger.log(Level.WARNING, "Erreur : " + erreur);
            }
            return false;
        } else {
            return true;
        }
    }
}
