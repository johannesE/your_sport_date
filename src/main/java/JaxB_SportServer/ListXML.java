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
@XmlRootElement(name="list")
public class ListXML {
    public ListXML(){
    }
    Collection <Sport> sports;
    Collection <User> users;
    int available;
    int end;
    int start;
    String uri;
    String type;
    Collection <Link> links;
    Collection <Partnership> partnerships;
    
    @XmlAttribute
    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
    @XmlAttribute
    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    @XmlAttribute
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    @XmlAttribute
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    @XmlAttribute
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
    
    public void setLinks(Collection<Link> links) {
        this.links = links;
    }
    
    
    @XmlElementWrapper(name="users")
    @XmlElementRef
    public Collection<User> getUsers() {
        return users;
    }
    
    public void setUsers(Collection<User> users) {
        this.users = users;
    }
    @XmlElementWrapper(name="sports")
    @XmlElementRef
    public Collection<Sport> getSports() {
        return sports;
    }

    public void setSports(Collection<Sport> sports) {
        this.sports = sports;
    }
    @XmlElementWrapper(name="partnerships")
    @XmlElementRef
    public Collection<Partnership> getPartnerships() {
        return partnerships;
    }

    public void setPartnerships(Collection<Partnership> partnerships) {
        this.partnerships = partnerships;
    }
    
    
    

}
