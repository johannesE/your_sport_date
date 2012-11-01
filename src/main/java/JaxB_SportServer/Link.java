/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxB_SportServer;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johannes Eifert
 */
@XmlRootElement(name="link")
public class Link {
    public Link(){
        
    }
    
    String description;
    String href;
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    
    
}
