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
import com.vaadin.ui.Window;
import ui.CreateUserWindow;
import ui.Startpopup;
import ui.WeatherTable;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application implements Button.ClickListener{
    private Window window;
    private Label weatherLabel;
    private WeatherTable weatherTable;
    private UserList userList;
    private UserService u = new UserService();
    private Button newUserButton = new Button("Create a new User", this);
    CreateUserWindow createwindow;
    Button commit;
    Button debugButton;
    Button userListButton;
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
                window.addWindow(new Startpopup(window,u));
		window.addComponent(createToolbar());
                
	}

	private Component createToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
                weatherTable = new WeatherTable();
                lo.addComponent(weatherLabel = new Label("Weather: \n"
        		+"Proposed Activity: \n"
                        +"Planned Activity: ", Label.CONTENT_PREFORMATTED));
                lo.addComponent(weatherTable.createWeatherTable());
                debugButton = new Button("DEBUG", this);
                lo.addComponent(debugButton);
                userListButton = new Button("Get the User List", this);
                lo.addComponent(userListButton);
                lo.addComponent(userManagementButton);
                return lo;
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
            for(int i=0;i<100;i++){
            User user = new User();
            user.setEmail("asdfg@gmail.com");
            user.setPassword("password");
            user.setPublicvisible(1);
            user.setRealname("huhuhu");
            user.setUsername("0"+i+"0");
            u.createUserXML(user);
            }
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
        
    }
        
}