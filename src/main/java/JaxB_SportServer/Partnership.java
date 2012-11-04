/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxB_SportServer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;

/**
 *
 * @author Johannes Eifert
 */
public class Partnership {
    int id;
    String uri;
    boolean publicvisible;
    User user1;
    User user2;
    public Partnership(){
        
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
    
    public boolean isPublicvisible() {
        return publicvisible;
    }

    public void setPublicvisible(boolean publicvisible) {
        this.publicvisible = publicvisible;
    }
    @XmlElementRef
    public User getUser1() {
        return user1;
    }
    
    public void setUser1(User user1) {
        this.user1 = user1;
    }
    @XmlElementRef
    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
    
}
