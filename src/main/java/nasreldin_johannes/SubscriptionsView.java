/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Johannes Eifert
 */
public class SubscriptionsView {
    
    
    public Component getComponent(){
        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(new Label("Subscribe to: "));
        
        
        return vl;
    }
}
