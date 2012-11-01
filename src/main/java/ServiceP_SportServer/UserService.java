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
import java.lang.reflect.Array;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Johannes Eifert
 */
public class UserService {
    String BASE_URI = "http://diufvm31.unifr.ch:8090/CyberCoachServer/";
    ClientConfig config = new DefaultClientConfig();
    
    public User getUserXML(String username){
        Client client = Client.create();
        WebResource r = client.resource(BASE_URI+"resources/users/?start=0&size=10");
        ListXML list = r.accept(MediaType.APPLICATION_XML).get(ListXML.class);
        System.out.print(list.getUsers().size());
        return null;       
            
    
    }
    
}
