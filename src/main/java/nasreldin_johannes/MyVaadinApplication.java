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
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import ui.CreateUserWindow;
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
    private Button newUserButton;

    @Override
    public void init() {
    	buildMainLayout();
    }

	private void buildMainLayout() {
		window = new Window("Your SportDate Finder");
		setMainWindow(window);
		window.addComponent(createToolbar());
                window.addComponent(getUserList());
		
	}

	private Component createToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
                weatherTable = new WeatherTable();
                lo.addComponent(weatherLabel = new Label("Weather: \n"
        		+"Proposed Activity: \n"
                        +"Planned Activity: ", Label.CONTENT_PREFORMATTED));
                lo.addComponent(weatherTable.createWeatherTable());
                newUserButton = new Button("Create a new User", this);
                lo.addComponent(newUserButton);
                return lo;
	}
        private Component getUserList(){
            userList = new UserList();
            return userList.createUserList();
        }

    public void buttonClick(ClickEvent e) {
        if (e.getButton()== newUserButton) {
            System.out.println("Create a new user: ");
            CreateUserWindow createwindow = new CreateUserWindow();
            window.addWindow(createwindow);
        }
        
    }
        
}