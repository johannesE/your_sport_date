/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

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
    
    public Startpopup(Window window){
    this.window = window;
    setModal(true);
    center();
    setWidth("40%");
    setHeight("40%");
    HorizontalLayout hl = new HorizontalLayout();
    hl.addComponent(loginUserButton = new Button("Login", this));
    hl.addComponent(createUserButton = new Button("Create a new User", this));
    this.addComponent(hl);
    }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()==loginUserButton){
            
        }
        else if (e.getButton()==createUserButton){
            window.removeWindow(this);
            window.addWindow(new CreateUserWindow());
            
        }
    }
    
}
