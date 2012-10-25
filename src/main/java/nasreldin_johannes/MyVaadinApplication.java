/*
 */
package nasreldin_johannes;

import com.vaadin.Application;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import ui.WeatherTable;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {
    private Window window;
    private Label weatherLabel;
    private WeatherTable weatherTable= new WeatherTable();
	
	

    @Override
    public void init() {
    	buildMainLayout();
    }

	private void buildMainLayout() {
		window = new Window("Your SportDate Finder");
		setMainWindow(window);
		window.addComponent(createToolbar());
		
	}

	private Component createToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
        lo.addComponent(weatherLabel = new Label("Weather: \n"
        		+"Proposed Activity: \n"
                        +"Planned Activity: ", Label.CONTENT_PREFORMATTED));
        lo.addComponent(weatherTable.createWeatherTable());
        return lo;
	}

    

    
}