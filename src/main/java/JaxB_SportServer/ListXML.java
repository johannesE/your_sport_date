/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxB_SportServer;

import java.util.Collection;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johannes Eifert
 */
@XmlRootElement(name="list")
public class ListXML {
    Collection <User> users;
    int available;
    int end;
    int start;
    String uri;
    String type;
    Collection <Link> links;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @XmlElementWrapper(name="links")
    @XmlElementRef
    public Collection<Link> getLinks() {
        return links;
    }
    @XmlElementWrapper(name="links")
    @XmlElementRef
    public void setLinks(Collection<Link> links) {
        this.links = links;
    }
    
    
    @XmlElementWrapper(name="users")
    @XmlElementRef
    public Collection<User> getUsers() {
        return users;
    }
    @XmlElementWrapper(name="users")
    @XmlElementRef
    public void setUsers(Collection<User> users) {
        this.users = users;
    }
    
    
    

}