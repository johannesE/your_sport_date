 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceP_SportServer;

import JaxB_SportServer.ListXML;
import JaxB_SportServer.Partnership;
import JaxB_SportServer.Sport;
import JaxB_SportServer.Subscription;
import JaxB_SportServer.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.Base64;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author Johannes Eifert
 */
public class UserService {
    private static UserService instance;
    
    private UserService(){
        
    }
    public synchronized static UserService getInstance() {
        if (instance == null) 
        {
            instance = new UserService();
        }
        return instance;
    }
    
    public String BASE_URI = "http://diufvm31.unifr.ch:8090";
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    
    public ListXML getUserXML(){
        System.out.println("Accessing user list..");
        WebResource r = client.resource(BASE_URI+"/CyberCoachServer/resources/users/?start=0&size=1000");
        ListXML list = r.accept(MediaType.APPLICATION_XML).get(ListXML.class);
        System.out.println("User list accessed.");
        return list;
    }
    
    public boolean isUser(User _user){
        User[] list = getUserXML().getUsers().toArray(new User[0]);
        
        for(int i = 0; i<list.length; i++){
            if(list[i].getUsername() == _user.getUsername()){
                return true;
            } else {
               return false;
            }
        }
        return false;
    }
    
    public void createUserXML(User user){
        System.out.print("Creating user: ");
        System.out.println(user.getUri());
        WebResource r = client.resource(BASE_URI+
                "/CyberCoachServer/resources/users/"+user.getUsername());
        ClientResponse resp= r.type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML).put(ClientResponse.class, user);
        if("200".equals(resp.getClientResponseStatus().toString())){
            System.out.println("There has been an error, "+
                    "your user could not have been created");
        } else {
            System.out.println("User "+user.getUsername()+" created :-)");
        }
        
    }
    
    public void deleteUser(User user){
        System.out.println("Deleting user " + user);
        
//        client.addFilter(new HTTPBasicAuthFilter(user.getUsername(), user.getPassword()));
        
        WebResource r = client.resource(BASE_URI+
                "/CyberCoachServer/resources/users/"+user.getUsername());
        
        System.out.println("Trying to delete user " + r.toString());        
       
        ClientResponse resp = r
                .header("Authorization", "Basic " + new String(Base64.encode( user.getUsername() +":"+ user.getPassword() )))
                .type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .delete(ClientResponse.class);
        
//        client.removeAllFilters();
        
        if ("200".equals(resp.getClientResponseStatus().toString())){
          System.out.println("User "+ user +" successfully deleted");  
        } else {
            System.out.println("Error while deleting user "+ user);
        }
        
        
//       TODO:Logout of vaadin
    }
    public User updateUserData(User _user){
        WebResource r = client.resource(BASE_URI+"/CyberCoachServer/resources/users/" + _user.getUsername());
        _user = r.header("Authorization", "Basic " + new String(Base64.encode( _user.getUsername() +":"+ _user.getPassword() )))
                .accept(MediaType.APPLICATION_XML).get(User.class);
        return _user;
    }
    
    
    public ListXML getSportXML(){
        System.out.println("Accessing Sport list..");
        WebResource r = client.resource(BASE_URI+"/CyberCoachServer/resources/sports");
        ListXML list = r.accept(MediaType.APPLICATION_XML).get(ListXML.class);
        System.out.println("Sport list accessed.");
        return list;
    }
    
    public Subscription[] getSubscriptionforSport(Sport _sport){
        System.out.println("Accessing Sport.." + _sport.getName());
        WebResource r = client.resource(BASE_URI+"/CyberCoachServer/resources/sports/" + _sport.getName()+"?start=0&size=1000");
        Sport sport = r.accept(MediaType.APPLICATION_XML).get(Sport.class);
        
        return sport.getSubscriptions().toArray(new Subscription[0]);
    }
    
    public Subscription getSubscriptionDetails(Subscription _sub){
        System.out.println("Accessing Subscription.." + _sub.getUri());
        WebResource r = client.resource(BASE_URI + _sub.getUri());
        _sub = r.accept(MediaType.APPLICATION_XML).get(Subscription.class);
        
        return _sub;
    }
    
    public Partnership getPartnershipDetails(Partnership _part){
        System.out.println("Accessing Partnership.." + _part.getUri());
        WebResource r = client.resource(BASE_URI + _part.getUri());
        _part = r.accept(MediaType.APPLICATION_XML).get(Partnership.class);
        System.out.println("Partnership"+ _part.getId() +" accessed");
        System.out.println("Partnership"+ _part.getUser1() +" accessed");
        return _part;
    }
    
    public User getUserDetails(User _user){
        System.out.println("Accessing User.." + _user.getUri());
        WebResource r = client.resource(BASE_URI + _user.getUri());
        _user = r.accept(MediaType.APPLICATION_XML).get(User.class);
        
        return _user;
    }
    
    
}
