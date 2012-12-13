/*
 */
package nasreldin_johannes;

import JaxB_SportServer.User;
import ServiceP_SportServer.UserService;
import ui.UserList;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import database.DatabaseService;
import database.UserTable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ui.CreateUserWindow;
import ui.LoginWindow;
import ui.Startpopup;
import ui.WeatherTable;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application implements Button.ClickListener{

   // public static Object getInstance() {
   //     throw new UnsupportedOperationException("Not yet implemented");//Diff_1 auto generated from the login
   // }
    private Window window;
    private Label weatherLabel;
    private WeatherTable weatherTable;
    private UserList userList;
    private UserService u = UserService.getInstance();
    private Button newUserButton = new Button("Create a new User", this);
    CreateUserWindow createwindow;
    Button commit;
    Button debugButton;
    Button userListButton;
    Button deleteUserButton;
    Button weatherButton; //creation of the weather Button to be related to weather condition
    Button proposedActivity;// the activity must be related to this button
    Button plannedActivity; // the planning must be related to this one
    private Component userlist = null;
    private Button userManagementButton = new Button("User Management", this);

    @Override
    public void init() {
//        setTheme("mytheme");
    	buildMainLayout();
        
         }      
            private void buildMainLayout() {
            window = new Window("Your SportDate Finder");
                setMainWindow(window);
              
                //setMainWindow (new LoginWindow());//the authenticaion method
              
                window.addWindow(new Startpopup(window,u));
           window.addComponent(createToolbar());
        window.addComponent(newbuttonsForActivities());
           
    
                
                //setMainWindow(window);
                //window.addWindow(new Startpopup(window,u));
		//window.addComponent(createToolbar());
                
	}

	private Component createToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
                weatherTable = new WeatherTable();
                 window.addComponent(new Label("Weather Table"));
               /*
                * 
                
                lo.addComponent(weatherLabel = new Label("Weather: \n"
        		+"Proposed Activity: \n"
                        +"Planned Activity: ", Label.CONTENT_PREFORMATTED));
                */
                lo.addComponent(weatherTable.createWeatherTable());
                
                 debugButton = new Button("DEBUG", this);
                lo.addComponent(debugButton);
                deleteUserButton = new Button("Delete my User", this);
                userListButton = new Button("Get the User List", this);
                lo.addComponent(deleteUserButton);
                lo.addComponent(userListButton);
                lo.addComponent(userManagementButton);
                return lo;
	}
        
                 
        private Component newbuttonsForActivities(){     
        
           VerticalLayout ln = new VerticalLayout();
            weatherButton = new Button ("Weather Situation");//to appear in the top
           ln.addComponent(weatherButton); //to integrate buttons to UI
                
                proposedActivity = new Button ("Proposed Activity");
                plannedActivity = new Button ("Planned Activity"); 
                
                ln.addComponent(proposedActivity); //to integrate buttons to UI
                ln.addComponent(plannedActivity); //to integrate buttons to UI form
                return ln;
        }
         
              
           private Component getUserList(){
            userList = new UserList();
            return userList.createUserList();
        }


    public void buttonClick(ClickEvent e) {
        if (e.getButton()== newUserButton) {
        }
        else if(e.getButton() == commit){
            createwindow.form.commit();
            createwindow.userbean.setUri(u.BASE_URI+createwindow.userbean.getUsername());
            u.createUserXML(createwindow.userbean);
            window.removeWindow(createwindow);
                       
        }
        else if (e.getButton() == debugButton){
//            DoodlePoll poll = new DoodlePoll();
//            
//            // set title, description
//            poll.setTitle("What do you want for lunch?");
//            poll.setDesc("Just a test poll..");
//
//// set the poll type to text
//            poll.setType(DoodlePoll.TEXT_POLL);
//// only YES or NO are possible votes
//            poll.setMode(2);
//
//// add options to vote for
//            poll.addOption("pizza");
//            poll.addOption("pasta");
//            poll.addOption("burger");
//
//// save the poll to Doodle
//            poll.save();
//            System.out.println(poll.toString());
//            System.out.println(poll.getId());
//            System.out.println(poll.getXKey());
//            System.out.println(poll.isNew());
            
            
            int i = 0;
            UserTable _user = new UserTable("username"+i, "wrongpassword"+i);
            
            DatabaseService _DS = DatabaseService.getInstance();
                    _DS.getUser(_user);
            System.out.println(_DS.getUser(_user).getPassword());
            
//            for(int i=0;i<100;i++){
//            User user = new User();
//            user.setEmail("asdfg@gmail.com");
//            user.setPassword("password");
//            user.setPublicvisible(1);
//            user.setRealname("huhuhu");
//            user.setUsername("0"+i+"0");
//            u.createUserXML(user);
//            }
        }
        else if (e.getButton() == userListButton){
            if (userlist == null){
            userlist = getUserList();
            window.addComponent(userlist);
            }
            else {
                userlist = getUserList();
                userlist.requestRepaint();
            }
        }
        else if (e.getButton()== userManagementButton){
            window.addWindow(new Startpopup(window, u));
        }
        
        else if(e.getButton() == deleteUserButton){
            
            
            
            
            
        }
       // window.addWindow(new Startpopup(window,u));
    }
        
}