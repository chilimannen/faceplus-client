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
 * Password validator.
 */

@FacesValidator("com.rduda.Controller.Validator.Password")
public class Password implements Validator {
    private static final int MIN_LENGTH = 9;
    private static final String[] blacklist = {
            "password",
            "123456789",
            "face+",
            "faceplus"
    };

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String password = o.toString();

        if (password.length() < MIN_LENGTH)
            throw new ValidatorException(
                    new FacesMessage("May not be shorter than " + MIN_LENGTH + " characters"));

        for (String forbidden : blacklist) {
            if (password.toLowerCase().contains(forbidden)) {
                throw new ValidatorException(
                        new FacesMessage("May not contain \"" + forbidden + "\""));
            }
        }
    }
}
