/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
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
    this.addComponent(loginUserButton = new Button("Login", this));
    this.addComponent(createUserButton = new Button("Create a new User", this));
    }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()==loginUserButton){
            
        }
        else if (e.getButton()==createUserButton){
            window.addComponent(new CreateUserWindow());
            
        }
    }
    
}
