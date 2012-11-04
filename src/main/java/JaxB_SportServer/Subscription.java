/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxB_SportServer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johannes Eifert
 */
@XmlRootElement(name="subscription")
public class Subscription {
    int id;
    String uri;
    
    public Subscription(){
        
    }
    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlAttribute
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    
    
}
