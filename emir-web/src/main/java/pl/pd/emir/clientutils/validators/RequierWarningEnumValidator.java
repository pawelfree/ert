/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pd.emir.clientutils.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import pl.pd.emir.bean.BeanHelper;
import pl.pd.emir.client.utils.ValidatorHelper;

@FacesValidator("pl.pd.emir.clientutils.validators.RequierWarningEnumValidator")
public class RequierWarningEnumValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null || value.toString().equals(BeanHelper.getMessage("commons.errFieldsValue"))) {
            FacesMessage msg = ValidatorHelper.getFacesMessageRequierWarn(ValidatorHelper.getComponentName(component), ValidatorHelper.getComponentNameDetail(component));
            context.addMessage(component.getClientId(context), msg);
        }
    }
}
