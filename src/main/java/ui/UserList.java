/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

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
         usertable.addContainerProperty("Name", String.class,  null);
         return usertable;
     }
}
