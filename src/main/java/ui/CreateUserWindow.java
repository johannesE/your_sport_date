/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import JaxB_SportServer.User;
import ServiceP_SportServer.UserService;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.Window;
import nasreldin_johannes.CurrentUser;

/**
 * Creates a Window with a Form that allows user creation.
 * @author Johannes Eifert
 */
public class CreateUserWindow extends Window implements Button.ClickListener{
    String username;
    String uri;
    String email;
    String password;
    String realname;
    boolean visible;
    public Form form;
    public User userbean;
    private Button commit;
    Window window; 

    
    /** Window is created by using the constructor */
    public CreateUserWindow(){
        
        setModal(true);
        center();
        setWidth("50%");
        setHeight("70%");
        form = createForm();
        this.addComponent(form);
        commit = new Button("Commit", form, "commit");
        commit.addListener(this);
        this.addComponent(commit);
        userbean = CurrentUser.getInstance().getCybercoach();
    }
    
    /** creates the form */
    private Form createForm(){
        Form _form = new Form();
        _form.setFormFieldFactory(new UserCreationFormFactory());
        _form.setCaption("User creation");
        _form.setDescription("Enter your desired details below");
        userbean = CurrentUser.getInstance().getCybercoach();
        userbean.setPublicvisible(1);
        BeanItem useritems = new BeanItem(userbean);
        _form.setItemDataSource(useritems);
        _form.setFormFieldFactory(new UserCreationFormFactory());
        return _form;
    }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()==commit){
            form.commit();
            CurrentUser.getInstance().createUser(userbean);
            this.getParent().removeWindow(this);
            //window.addWindow(new LoginWindow());
        }
    }
    
    
}
