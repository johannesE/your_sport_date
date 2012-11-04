/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxB_SportServer;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
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
    Collection <Subscription> subscriptions;
    
    @XmlElementWrapper(name="links")
    @XmlElementRef
    public Collection<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Collection<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
    
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
