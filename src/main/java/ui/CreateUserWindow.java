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
    public User userbean = CurrentUser.getInstance().getCybercoach();
    private Button commit;

    
    /** Window is created by using the constructor */
    public CreateUserWindow(){
        
        setModal(true);
        center();
        setWidth("50%");
        setHeight("70%");
        this.addComponent(form = createForm());
        commit = new Button("Commit", form, "commit");
        commit.addListener(this);
        this.addComponent(commit);
    }
    
    /** creates the form */
    private Form createForm(){
        form = new Form();
        form.setFormFieldFactory(new UserCreationFormFactory());
        form.setCaption("User creation");
        form.setDescription("Enter your desired details below");
        userbean = CurrentUser.getInstance().getCybercoach();
        userbean.setPublicvisible(1);
        BeanItem useritems = new BeanItem(userbean);
        form.setItemDataSource(useritems);
        form.setFormFieldFactory(new UserCreationFormFactory());
        return form;
    }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()==commit){
            form.commit();
            CurrentUser.getInstance().createUser(userbean);
            this.getParent().removeWindow(this);
        }
    }
    
    
}
