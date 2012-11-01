 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceP_SportServer;

import JaxB_SportServer.ListXML;
import JaxB_SportServer.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Johannes Eifert
 */
public class UserService {
    String BASE_URI = "http://diufvm31.unifr.ch:8090/CyberCoachServer/";
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    
    public ListXML getUserXML(String username){
        System.out.println("Accessing user list..");
        WebResource r = client.resource(BASE_URI+"resources/users/?start=0&size=100");
        ListXML list = r.accept(MediaType.APPLICATION_XML).get(ListXML.class);
        System.out.println("User list accessed.");
        
        return list;
        
    }
    
}
