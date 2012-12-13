/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import nasreldin_johannes.CurrentUser;
import nasreldin_johannes.MyVaadinApplication;
/**
 *
 * @author Nasreldin
 */
public class LoginWindow extends Window implements Button.ClickListener{
    private Button commit;
    CurrentUser userbean;
    Form form;
    private String username;
    private String password;
    
    
    public LoginWindow (){
        super("Authentication Required");
        setName ("login");
        center();
        setModal(true);
        setWidth("50%");
        form = createForm();
        addComponent(form);
        commit = new Button("Commit", form, "commit");
        commit.addListener(this);
        addComponent(commit);
    }
    
    public void authenticate( String login, String password){

    }



    private void setMainWindow() {
        MyVaadinApplication.getInstance().buildMainLayout();

    }
	
    
    private Form createForm() {
        Form _form = new Form();
        _form.setCaption("User login");
        _form.setDescription("Enter your desired details below");
        _form.addField("username", new TextField("Username", username));
        _form.addField("password", new TextField("Password", password ));
        return _form;
    }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()==commit){
            form.commit();
            System.out.println(form.getItemProperty("username").toString());
            System.out.println(form.getItemProperty("password").toString());
            
            CurrentUser currentUser = CurrentUser.getInstance();
            
            if(currentUser.loginUser(form.getField("username").toString(),
                    form.getField("password").toString())){
                
                this.getParent().removeWindow(this);
                MyVaadinApplication.getInstance().setLoggedin(true);
                MyVaadinApplication.getInstance().setMainComponent(new Label("You logged in Successfully"));
            }
        }
        
    }
}
