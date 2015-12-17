package com.rduda.Controller.Validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Robin on 2015-11-11.
 *
 * Username validator.
 */

@FacesValidator("com.rduda.Controller.Validator.Username")
public class Username implements Validator {
    private final static int MIN_LENGTH = 5;
    private final static int MAX_LENGTH = 64;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String username = o.toString();

        if (username.length() < MIN_LENGTH)
            throw new ValidatorException(
                    new FacesMessage("May not be shorter than " + MIN_LENGTH + " characters"));

        if (username.length() > MAX_LENGTH)
            throw new ValidatorException(new FacesMessage("May not be longer than " + MAX_LENGTH ));
    }
}
