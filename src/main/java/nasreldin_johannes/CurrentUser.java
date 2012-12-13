/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.User;
import ServiceP_SportServer.UserService;
import com.vaadin.Application.CustomizedSystemMessages;
import database.DatabaseService;
import database.UserTable;

/**
 *
 * @author Johannes Eifert
 */
public class CurrentUser{
    private static CurrentUser instance;
    public String password = "";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String username = "";
    private UserService u;
    
    private CurrentUser(){
        u = UserService.getInstance();
        
        if (getCybercoach()==null){
            setCybercoach(new User());
        }
        
    }
    
    
    
    public synchronized static CurrentUser getInstance() {
        if (instance == null) 
        {
            instance = new CurrentUser();
        }
        return instance;
    }
    
    User cybercoach = null;

    public User getCybercoach() {
        return cybercoach;
    }

    public void setCybercoach(User cybercoach) {
        this.cybercoach = cybercoach;
    }
    
    public void createUser(User _user){
        
        UserTable localuser = new UserTable(getCybercoach().getUsername(),
                getCybercoach().getPassword());
        
        if( ! DatabaseService.getInstance().isUser(localuser) && ! u.isUser(_user)){
            
            _user.setUri(u.BASE_URI+_user.getUsername());
            setCybercoach(_user);
            u.createUserXML(getCybercoach());
        
            DatabaseService.getInstance().createUser(localuser); //create local user
            
        } else { 
            System.out.println("Username already taken, please try again");
            MyVaadinApplication main = new MyVaadinApplication();
            main.init();
        }
    }

    public boolean loginUser(String _username, String _password) {
        setPassword(_password);
        setUsername(_username);
        
        UserTable localuser = new UserTable(getUsername(),
                getPassword());
        if( ! DatabaseService.getInstance().isUser(localuser)){
            return false;
        }
        return true;
        
    }
    
}
