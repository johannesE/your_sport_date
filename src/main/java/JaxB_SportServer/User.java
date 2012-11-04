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
@XmlRootElement(name="user")
public class User {
    String username;
    String uri;
    boolean publicvisible;
    
    
    public boolean isPublicvisible() {
        return publicvisible;
    }

    public void setPublicvisible(boolean publicvisible) {
        this.publicvisible = publicvisible;
    }
    
    public User(){
    }
    @XmlAttribute
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @XmlAttribute
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    
    
}
