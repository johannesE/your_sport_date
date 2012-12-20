/*
 */
package nasreldin_johannes;

import ServiceP_SportServer.UserService;
import ui.UserList;
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
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
    private Button myStatsButton;
    private UserStats userStats;
    private Button sportsButton;
    private SportsView sportsView;
    private SubscriptionsView subscriptionsView;
    private Button subscriptionsButton;

    public MyVaadinApplication(){ // I know that this should be private. Here this was not possible otherwise.
    }
    public static MyVaadinApplication instance = null;
    private Window window;
    private Label weatherLabel;
    private WeatherTable weatherTable;
    private UserList userList;
    private UserService u = UserService.getInstance();
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
                
                if(loggedin){
                    userManagementButton.setCaption("Logout");
                    userManagementButton.setIcon(new ExternalResource("http://cdn1.iconfinder.com/data/icons/gnomeicontheme/16x16/apps/gnome-logout.png"));
                    
                    lo.addComponent(newbuttonsForUserServices());
                }
//              
                
//                weatherTable = new WeatherTable();
//                lo.addComponent(weatherTable.createWeatherTable());
                lo.addComponent(userManagementButton);
                return lo;
        }
        
              
        private Component newbuttonsForUserServices(){    
        
                  //VerticalLayout lr = new VerticalLayout();
                HorizontalLayout lr = new HorizontalLayout();
                subscriptionsButton = new Button("Subscriptions", this);
                subscriptionsButton.setIcon(new ExternalResource("http://feed.feedarea.de/images/subscribe_feed.gif"));
                myStatsButton = new Button("My Stats", this);
                myStatsButton.setIcon(new ExternalResource("http://www.diigo.com/front-end-utils/images/icon-account-premium.png"));
//                debugButton = new Button("DEBUG", this);
                deleteUserButton = new Button("Delete my User", this);
                deleteUserButton.setIcon(new ExternalResource("http://www.veryicon.com/icon/preview/Application/asp.net/user3%20%28delete%29%20Icon.jpg"));
                userListButton = new Button("Get the User List", this);
                userListButton.setIcon(new ExternalResource("https://confluence.atlassian.com/download/attachments/267257851/user_list.gif?version=1&modificationDate=1278992053454"));
                sportsButton = new Button("Sports", this);
                sportsButton.setIcon(new ExternalResource("http://www.senselan.ch/webportal/images/ico_sport.gif"));
                lr.addComponent(myStatsButton);
                lr.addComponent(userListButton);
                lr.addComponent(sportsButton);
                lr.addComponent(subscriptionsButton);
                lr.addComponent(deleteUserButton);
//                lr.addComponent(debugButton);
                
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

    public void logout(){
        loggedin = false;
        userManagementButton.setCaption("User Management");
        this.init();
        window.addWindow(new Startpopup(window, u));
        
    }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()== null) {
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

            
//            for(int i=0;i<100;i++){
//            User user = new User();
//            user.setEmail("asdfg@gmail.com");
//            user.setPassword("password");
//            user.setPublicvisible(1);
//            user.setRealname("huhuhu");
//            user.setUsername("0"+i+"0");
//            u.createUserXML(user);
//            }
        }else if (e.getButton() == userListButton){
            if (userlist == null){
           
            userlist = getUserList();
            setMainComponent(userlist);
            }
            else {
                userlist = getUserList();
                userlist.requestRepaint();
                setMainComponent(userlist);
            }
        }
        else if (e.getButton()== userManagementButton){
            if(!loggedin){
            window.addWindow(new Startpopup(window, u));
            } else { // logout
                logout();
            }
        }
        
        else if(e.getButton() == deleteUserButton){
            
            CurrentUser.getInstance().removeMe();
            logout();
            setMainComponent(new Label("You were deleted! ;-)"));
        }
        else if(e.getButton() == myStatsButton){
           if(userStats == null){
               userStats = new UserStats();
           } 
           
           setMainComponent(userStats.getComponent());
           
        } else if (e.getButton()== sportsButton){
            if (sportsView ==null){
                sportsView = new SportsView();
            }
            setMainComponent(sportsView.getComponent());
        } else if (e.getButton() == subscriptionsButton){
            if(subscriptionsView == null){
                subscriptionsView = new SubscriptionsView();
            }
            setMainComponent(subscriptionsView.getComponent());
        }
       
    }
        
}