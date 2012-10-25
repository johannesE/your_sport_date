 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceP_SportServer;

import JaxB_SportServer.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Johannes Eifert
 */
public class UserService {
    public User getUserXML(){
        Client client = Client.create();
        String BASE_RES = "http://diufvm31.unifr.ch:8090/CyberCoachServer/";
        WebResource r = client.resource(BASE_RES+"resources/users");
        return null;
    }
    
}
