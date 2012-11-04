/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import JaxB_SportServer.User;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Form;
import com.vaadin.ui.Window;
import java.util.Vector;

/**
 * Creates a Window with a Form that allows user creation.
 * @author Johannes Eifert
 */
public class CreateUserWindow extends Window{
    String username;
    String uri;
    String email;
    String password;
    String realname;
    boolean visible;
    
    /** Window is created by using the constructor */
    public CreateUserWindow(){
        setModal(true);
        center();
        setWidth("50%");
        setHeight("50%");
        this.addComponent(createform());
    }
    
    /** creates the form */
    private Form createform(){
        Form form = new Form();
        form.setCaption("User creation");
        form.setDescription("Enter your desired details below");
        User userbean = new User();
        BeanItem useritems = new BeanItem(userbean);
        form.setItemDataSource(useritems);
        Vector order = new Vector();
        order.add("username");
        order.add("uri");
        order.add("publicvisible");
        form.setVisibleItemProperties(order);
        return form;
    }
    
    
}
