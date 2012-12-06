/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.User;

/**
 *
 * @author Johannes Eifert
 */
public class CurrentUser{
    private static CurrentUser instance;
    private CurrentUser(){}
    
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
    
    
    
    
}
