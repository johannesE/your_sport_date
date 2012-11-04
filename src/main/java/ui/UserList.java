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
     UserService service = new UserService();
    
     public Component createUserList(){
         usertable = new Table();
         usertable.addContainerProperty("Name", String.class,  null);
         usertable.addContainerProperty("URI", String.class,  null);
         
         getAllUserInformation();
         User[] users = getAllUserInformation();
         
         for (int i = 0; i < users.length; i++) {
             String name = users[i].getUsername();
             usertable.addItem(new Object[]{name, users[i].getUri()});
             System.out.println(users[i].getUsername()+" & "+users[i].getUri());
         }
        
        return usertable;
     }
     
     private User[] getAllUserInformation(){
         
         ListXML list = service.getUserXML();
         System.out.print(list.getUsers().toArray()[1].toString()); 
         User[] arrayList = list.getUsers().toArray(new User[0]);
         
         return arrayList;
     }
}
