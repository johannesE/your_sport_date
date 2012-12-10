/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import nasreldin_johannes.MyVaadinApplication;

/**
 *
 * @author Nasreldin
 */

    public class LoginWindow extends Window
{
    private Button btnLogin = new Button("Login");
    private TextField login = new TextField ( "Username");
    private TextField password = new TextField ( "Password");


    public LoginWindow ()
    {
        super("Authentication Required !");
        setName("login");
        initUI();
    }

    private void initUI ()
    {
        password.setSecret ( true );

        addComponent ( new Label ("Please login in order to use the Sport coach application") );
        addComponent ( new Label () );
        addComponent ( login );
        addComponent ( password );
        addComponent ( btnLogin );
        
        btnLogin.addListener ( new Button.ClickListener()
        {
            public void buttonClick ( Button.ClickEvent event )
            {
                try
                {
                    MyVaadinApplication.getInstance().authenticate((String)login.getValue (), 
                            (String)password.getValue ());
                    open ( new ExternalResource (MyVaadinApplication.getInstance().getURL ()));//the loging 
                }
                catch ( Exception e )
                {
                    showNotification ( e.toString ());
                }
            }
        });
    }
}

