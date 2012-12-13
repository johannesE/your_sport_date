/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.vaadin.ui.Window;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;


/**
 *
 * @author Nasreldin
 */
public class LoginWindow extends Window{
    private Window window;
    private Button btnLogin = new Button("Login");
    private TextField login = new TextField ( "Username");
    private TextField password = new TextField ( "Password");
    
    
      public void authenticate( String login, String password) throws Exception
    {
        if (  "username".equals(login) && "querty".equals( password ) ) 
        {
            loadProtectedResources();
            return;
        }
       
       throw new Exception("Login failed!");

    }

    private void loadProtectedResources ()
    {
        window = new Window("Your SportDate Finder");
        //setMainWindow(window);//must be add window
        
         
    }

        /*private void setMainWindow(Window window) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
	*/
    

    public LoginWindow ()
    {
        super("Authentication Required !");
        setName ("login");
        initUI();
    }

    private void initUI ()
    {
        password.setSecret ( true );

        addComponent ( new Label ("Please login in order to use the application") );
        addComponent ( new Label () );
        addComponent ( login );
        addComponent ( password );
        addComponent ( btnLogin );
    }
}
