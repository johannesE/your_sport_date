/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.Sport;
import JaxB_SportServer.User;
import ServiceP_SportServer.UserService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.Select;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Johannes Eifert
 */
public class SubscriptionsView {
    UserService u = UserService.getInstance();
    private Form form;
    
    public Component getComponent(){
        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(new Label("Subscribe to: "));
        vl.addComponent(createForm());
        
        
        return vl;
    }
    
    private Component createForm(){
        VerticalLayout vl = new VerticalLayout();
        form = new Form();
        
        
        Select select = new Select("Sport", makeCollection());
        
        form.addField("select", select);
        form.getField("select").setRequired(true);
        form.getField("select").setRequiredError("Please choose a sport first");
        Button okbutton = new Button("Subscribe", form, "commit");
        okbutton.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent e) {
                form.commit();
                System.out.println(form.getItemProperty("select").toString());
                User _user = CurrentUser.getInstance().getCybercoach();
                Sport _sport = new Sport();
                _sport.setName(form.getField("select").toString());
                _sport.setUri("CyberCoachServer/resources/sports/"
                        + form.getField("select").toString());
                u.setSubscription(_sport, _user);
                
            }
        });
        vl.addComponent(form);
        vl.addComponent(okbutton);
        return vl;
    }
    
    public Collection makeCollection(){
        Collection<String> sport = new ArrayList<String>();
//        while(u.getSportXML().getSports().iterator().hasNext()){
//            sport.add(u.getSportXML().getSports().iterator().next().getName());
//        }
        Sport[] sports = u.getSportXML().getSports().toArray(new Sport[0]);
        for (int i=0; i<sports.length; i++){
            if(sports[i].getName()!= null){
                sport.add(sports[i].getName());
            }
        }
        
        return sport;
    }
}
