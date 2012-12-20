/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.Subscription;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import java.lang.String;
import java.sql.Array;
import java.util.Date;

/**
 *
 * @author Johannes Eifert
 */
public class UserStats {
    CurrentUser user = CurrentUser.getInstance();
    private Subscription[] subscriptionsentries;
    
    public Component getComponent(){
        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(new Label("Hello "+ user.getCybercoach().getRealname()+","));
        vl.addComponent(new Label("Your Username is: " + user.getCybercoach().getUsername()
                + " We are not going to display your password here, sorry."));
        vl.addComponent(new Label("But we can tell you your email adress. It is: " + user.getCybercoach().getEmail()));
        
        Table subscriptions = new Table("Subscriptions");
        subscriptions.addContainerProperty("Sport", String.class, null);
        subscriptions.addContainerProperty("Time added", Date.class, null);
        if (user.getCybercoach().getSubscriptions() != null){
            subscriptionsentries = user.getCybercoach().getSubscriptions().toArray( new Subscription[0]);
        
        //adding the entries to the table
            for (int i =0; i< subscriptionsentries.length; i++){
                subscriptions.addItem(new Object[]{subscriptionsentries[i].getSport()}, new Integer(i+1));
            }
        }
        HorizontalLayout hl = new HorizontalLayout();
        
        hl.addComponent(new Label("You have the following Subscriptions: "));
        hl.addComponent(subscriptions);
        
        
        vl.addComponent(hl);
        return vl;
    }
    
    
}
