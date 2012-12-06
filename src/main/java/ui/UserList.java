/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import JaxB_SportServer.ListXML;
import JaxB_SportServer.User;
import ServiceP_SportServer.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

/**
 *
 * @author Johannes Eifert
 */
public class UserList {
     private Table usertable;
     UserService service = UserService.getInstance();
    
     public Component createUserList(){
         usertable = new Table("User List");
         usertable.addContainerProperty("Name", String.class,  null);
         usertable.addContainerProperty("URI", String.class,  null);
         
         getAllUserInformation();
         User[] users = getAllUserInformation();
         for (int i = 0; i < users.length; i++) {
             usertable.addItem(new Object[]{users[i].getUsername(),
                 users[i].getUri()}, new Integer(i+1));
         }
        return usertable;
     }
     
     private User[] getAllUserInformation(){
         
         ListXML list = service.getUserXML();
         User[] arrayList = list.getUsers().toArray(new User[0]);
         
         return arrayList;
     }
}
