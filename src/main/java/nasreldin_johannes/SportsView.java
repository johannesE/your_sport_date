/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import JaxB_SportServer.Sport;
import JaxB_SportServer.Subscription;
import ServiceP_SportServer.UserService;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.terminal.Paintable;
import com.vaadin.terminal.Paintable.RepaintRequestEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

/**
 *
 * @author Johannes Eifert
 */
public class SportsView{
    UserService u = UserService.getInstance();
    String selected = new String();
    Table sportsTable;
    private HorizontalLayout hl;
    private Component secondTable = new Label(" please select an Item from the list to the left ");
    
    public Component getComponent(){
        hl = new HorizontalLayout();
        hl.addComponent(new Label("&nbsp;", Label.CONTENT_XHTML)); // spacing
        hl.addComponent(sportTable());
        hl.addComponent(secondTable);
        
        
        
       
        return hl;
    }
    
    public Sport[] getSportArray(){
        return u.getSportXML().getSports().toArray(new Sport[0]);
    }
    
    private Table sportTable(){
        sportsTable = new Table("Available Sports are: ");
        sportsTable.addContainerProperty("Name", String.class, null);
        sportsTable.setSelectable(true);
        sportsTable.setImmediate(true);
        sportsTable.addListener(new Property.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                if(sportsTable.getValue() != null){
                    selected = sportsTable.getContainerProperty(
                            sportsTable.getValue(), "Name").getValue().toString();
                    System.out.println(selected + " selected.");
                    secondTable = subscriptedTable();
                    hl.requestRepaintAll(); //did not work, therefore as a simple fix:
                    MyVaadinApplication.getInstance().setMainComponent(getComponent());
                }
                
            }
        });
        Sport[] sport = getSportArray();
        for (int i = 0; i<sport.length; i++){
            sportsTable.addItem(new Object[]{sport[i].getName()}, new Integer(i+1));
        }
        return sportsTable;
    }

    private Component subscriptedTable() {
        
        Table _table = new Table("The Subscriptions for "+ selected);
        _table.addContainerProperty("Username", String.class, null);
        _table.addContainerProperty("URI", String.class, null);
        
        Sport _sport = new Sport();
        _sport.setName(selected);
        Subscription[] _sub = u.getSubscriptionforSport(_sport);
        
        for (int i=0; i<_sub.length;i++){
            Subscription __sub = u.getSubscriptionDetails(_sub[i]);
//            System.out.println(__sub.getId());
            if(__sub != null){// because of some errors on the server
                if(__sub.getUser() != null){
                    _table.addItem(new Object[]{__sub.getUser().getUsername(), __sub.getUri()}, new Integer(i+1));
                }
            }
        }
        
        return _table;
      
    }
}
