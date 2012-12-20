/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.Sport;
import ServiceP_SportServer.UserService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.Select;
import com.vaadin.ui.VerticalLayout;
import java.util.Collection;

/**
 *
 * @author Johannes Eifert
 */
public class SubscriptionsView {
    UserService u = UserService.getInstance();
    
    public Component getComponent(){
        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(new Label("Subscribe to: "));
        vl.addComponent(createForm());
        
        
        return vl;
    }
    
    private Component createForm(){
        VerticalLayout vl = new VerticalLayout();
        Form form = new Form();
        
        
        Select select = new Select("Sport", u.getSportXML().getSports());
        form.addField("select", select);
        form.getField("select").setRequired(true);
        form.getField("select").setRequiredError("Please choose a sport first");
        Button okbutton = new Button("Subscribe", form, "commit");
        vl.addComponent(form);
        vl.addComponent(okbutton);
        return vl;
    }
    
    public void makeCollection(){
        Collection<Sport> sport = null;
        while(u.getSportXML().getSports().iterator().hasNext()){
            sport.add(u.getSportXML().getSports().iterator().next());
        }
    }
}
