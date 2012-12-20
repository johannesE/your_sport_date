/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.User;
import ServiceP_SportServer.UserService;
import com.vaadin.ui.Label;
import database.DatabaseService;
import database.UserTable;

/**
 *
 * @author Johannes Eifert
 */
public class CurrentUser{
    private static CurrentUser instance;
    public String password = "";
    public String username = "";
    private UserService u;
    User cybercoach = null;

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
    


    public User getCybercoach() {
        return cybercoach;
    }

    public void setCybercoach(User cybercoach) {
        this.cybercoach = cybercoach;
    }
    
    public void createUser(User _user){
        
        UserTable localuser = new UserTable(getCybercoach().getUsername(),
                getCybercoach().getPassword());
        
        //if the user is a new user
        if( ! DatabaseService.getInstance().isUser(localuser) && ! u.isUser(_user)){
            
            _user.setUri(u.BASE_URI+_user.getUsername());
            setCybercoach(_user);
            u.createUserXML(getCybercoach());
        
            DatabaseService.getInstance().createUser(localuser); //create local user
            
            MyVaadinApplication.getInstance().setLoggedin(true);
            MyVaadinApplication.getInstance().setMainComponent(new Label("You logged in Successfully"));
            
        } else { 
            System.out.println("Username already taken, please try again");
            MyVaadinApplication.getInstance().init();
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
        
        
        updateCybercoach(username, password);
        return true;
        
    }

    public void updateCybercoach(String username, String password) {
        cybercoach.setUsername(username);
        cybercoach.setPassword(password);
        User upUser = u.updateUserData(cybercoach);
        
        cybercoach = upUser;
        
    }

    void removeMe() {
       u.deleteUser(cybercoach);
       
       UserTable _user = new UserTable(getUsername(), getPassword());
       if(!DatabaseService.getInstance().isUser(_user)){
           System.out.println("Something weird happened with your user"); return;
       }
       _user = DatabaseService.getInstance().getUser(_user); //to update the id in the table
       DatabaseService.getInstance().deleteUser(_user);
    }
    
}
