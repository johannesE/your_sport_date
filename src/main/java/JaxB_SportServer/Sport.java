/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JaxB_SportServer;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Johannes Eifert
 */
public class Sport {
    int id;
    String name;
    String uri;
    String description;
    public Sport(){
        
    }
    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    @XmlAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
