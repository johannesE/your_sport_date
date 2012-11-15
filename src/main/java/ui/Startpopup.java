/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ServiceP_SportServer.UserService;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

/**
 * This Object is called on startup or when ever a user wants to change his status.
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
    //Setting the icons. Usually I would copy them locally, but here I trust in resilience of the icons online.
    loginUserButton.setIcon(new ExternalResource("http://www.feuerwehr-ostrau.de/templates/rt_kinetic_j15/images/icons/icon-key.png"));
    createUserButton.setIcon(new ExternalResource("http://images01.uboot.com/images/pix/icons/user--plus.png"));
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
