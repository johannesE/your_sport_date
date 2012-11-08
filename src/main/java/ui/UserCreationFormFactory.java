/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.vaadin.data.Item;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;

/**
 *
 * @author Johannes Eifert
 */
public class UserCreationFormFactory implements FormFieldFactory {

       public Field createField(Item item, Object propertyId,
                             Component uiContext) {
        // Identify the fields by their Property ID.
        String pid = (String) propertyId;
        if ("realname".equals(pid)) {
            return new TextField("Your real name", "name");
        } else if ("username".equals(pid)) {
            return new TextField("Your desired user name", "username");
        } else if("password".equals(pid)){
            return new TextField("Enter a new Password", "password");
        } else if ("email".equals(pid)){
            return new TextField("Your email address", "asdf@gmail.com");
        } else if ("publicvisible".equals(pid)){
            return new TextField("Make the account visible for the public (1)", "1");
        }
                        
        
        
        return null; // Invalid field (property) name.
    }
    
}
