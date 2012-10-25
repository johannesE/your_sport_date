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
@XmlRootElement(name="user")
public class User {
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    String uri;
    
}
