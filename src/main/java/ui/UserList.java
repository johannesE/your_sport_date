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
     
    
     public Component createUserList(){
         usertable = new Table();
         usertable.addContainerProperty("Name", String.class,  "default");
         usertable.addContainerProperty("Name2", String.class,  "default");
         
         getAllUserInformation();
         Object[] users = getAllUserInformation();
         for (int i = 0; i < users.length; i++) {
             usertable.addItem(new Object[]{users.toString(),"default2"});
         }
         
         return usertable;
     }
     
     private Object[] getAllUserInformation(){
         UserService service = new UserService();
         ListXML list = service.getUserXML();
         System.out.print(list.getUsers().toArray()[1].toString()); 
         Object[] arrayList =list.getUsers().toArray();
         return arrayList;
     }
}
