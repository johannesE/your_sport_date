/*
 */
package nasreldin_johannes;

import ServiceP_SportServer.UserService;
import ui.UserList;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;
import database.DatabaseService;
import database.UserTable;
import ui.CreateUserWindow;
import ui.LoginWindow;
import ui.Startpopup;
import ui.WeatherTable;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application implements Button.ClickListener{

    public MyVaadinApplication(){ // I know that this should be private. Here this was not possible otherwise.
    }
    public static MyVaadinApplication instance = null;
    private Window window;
    private Label weatherLabel;
    private WeatherTable weatherTable;
    private UserList userList;
    private UserService u = UserService.getInstance();
    private Button newUserButton = new Button("Create a new User", this);
    CreateUserWindow createwindow;
    Button debugButton;
    Button userListButton;
    Button deleteUserButton;
    Button weatherButton; //creation of the weather Button to be related to weather condition
    Button proposedActivity;// the activity must be related to this button
    Button plannedActivity; // the planning must be related to this one
    private Component userlist = null;
    private Button userManagementButton = new Button("User Management", this);
    private VerticalSplitPanel verticalSplit = new VerticalSplitPanel();
    public boolean loggedin = false;

    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }

    public synchronized static MyVaadinApplication getInstance(){
        if (instance == null) 
        {
            instance = new MyVaadinApplication();
        }
        return instance;
    }
    
    @Override
    public void init() {
//        setTheme("mytheme");
        instance = this;
        
        buildMainLayout();
        
        }
         
    public void setMainComponent (Component c){
        verticalSplit.setFirstComponent(createToolbar());
        verticalSplit.setSecondComponent(c);
    }
    
    public void buildMainLayout() {
        if (window == null){
        window = new Window("Your Sport Date Finder");
        setMainWindow(window);
        window.addWindow(new Startpopup(window,u));
        }
        
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        verticalSplit.setSplitPosition(50, HorizontalSplitPanel.UNITS_PIXELS);
        layout.addComponent(verticalSplit);
        
        verticalSplit.setFirstComponent(createToolbar());
        
        setMainComponent(userManagementButton);
        
        getMainWindow().setContent(layout);
        
    }
       

	private Component createToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
                lo.addComponent(userManagementButton);
                if(loggedin){
                    lo.addComponent(newbuttonsForUserServices());
                }
//              
                
//                weatherTable = new WeatherTable();
//                lo.addComponent(weatherTable.createWeatherTable());
                return lo;
        }
        
              
        private Component newbuttonsForUserServices(){    
        
                  //VerticalLayout lr = new VerticalLayout();
                HorizontalLayout lr = new HorizontalLayout();
                  
                debugButton = new Button("DEBUG", this);
                deleteUserButton = new Button("Delete my User", this);
                userListButton = new Button("Get the User List", this);
                lr.addComponent(userListButton); //to arrange the buttons in the interface
                lr.addComponent(deleteUserButton);
                lr.addComponent(debugButton);
                return lr;
              }
               
        private Component newbuttonsForActivities(){     
                 HorizontalLayout ln = new HorizontalLayout();
           
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
            if(!loggedin){
            window.addWindow(new Startpopup(window, u));
            } else { 
                
            }
        }
        
        else if(e.getButton() == deleteUserButton){
            
            
            
            
            
        }
       // window.addWindow(new Startpopup(window,u));
    }
        
}