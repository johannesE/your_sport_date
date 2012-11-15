/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ServiceP_SportServer.UserService;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Johannes Eifert
 */
public class Startpopup extends Window implements Button.ClickListener{
    Button createUserButton;
    Button loginUserButton;
    Window window;
    UserService u;
    
    public Startpopup(Window window, UserService u){
    this.u=u;
    this.window = window;
    setModal(true);
    center();
    setWidth("20%");
    setHeight("15%");
    HorizontalLayout hl = new HorizontalLayout();
    hl.addComponent(loginUserButton = new Button("Login", this));
    hl.addComponent(createUserButton = new Button("Create a new User", this));
    this.addComponent(hl);
    loginUserButton.setIcon(new ThemeResource("icons/32/folder-add.png"));
    }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()==loginUserButton){
            
        }
        else if (e.getButton()==createUserButton){
            window.removeWindow(this);
            window.addWindow(new CreateUserWindow(u));
            
        }
    }
    
}
