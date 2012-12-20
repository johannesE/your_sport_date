/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxB_SportServer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johannes Eifert
 */
@XmlRootElement(name="partnership")
public class Partnership {
    int id;
    String uri;
    int publicvisible;
    User user1;
    User user2;
    boolean userconfirmed1;
    boolean userconfirmed2;
    public Partnership(){
        
    }
    @XmlAttribute
    public boolean isUserconfirmed1() {
        return userconfirmed1;
    }

    public void setUserconfirmed1(boolean userconfirmed1) {
        this.userconfirmed1 = userconfirmed1;
    }
    @XmlAttribute
    public boolean isUserconfirmed2() {
        return userconfirmed2;
    }

    public void setUserconfirmed2(boolean userconfirmed2) {
        this.userconfirmed2 = userconfirmed2;
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
    
    public int isPublicvisible() {
        return publicvisible;
    }

    public void setPublicvisible(int publicvisible) {
        this.publicvisible = publicvisible;
    }
    //Eventuell falsch..
    
    @XmlElement(name="user1")
    public User getUser1() {
        return user1;
    }
    
    public void setUser1(User user1) {
        this.user1 = user1;
    }
    //Eventuell falsch..
    @XmlElement(name="user2")
    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
    
}
