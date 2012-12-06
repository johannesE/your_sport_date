/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.User;
import ServiceP_SportServer.UserService;
import database.DatabaseService;
import database.UserTable;

/**
 *
 * @author Johannes Eifert
 */
public class CurrentUser{
    private static CurrentUser instance;
    public String password;
    public String username;
    private UserService u;
    
    private CurrentUser(){
        u = UserService.getInstance();
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
        _user.setUri(u.BASE_URI+_user.getUsername());
        setCybercoach(_user);
        u.createUserXML(getCybercoach());
        
        UserTable localuser = new UserTable(getCybercoach().getUsername(),
                getCybercoach().getPassword());
        
        DatabaseService.getInstance().createUser(localuser);
        
    }
    
    
    
}
