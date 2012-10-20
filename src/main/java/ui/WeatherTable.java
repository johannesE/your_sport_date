/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Johannes Eifert
 */
public class WeatherTable {
    private Table weatherTable;
    private String[] dayofweek = new String[]{"Monday", "Tuesday", "Wednesday",
    "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday",
    "Thursday", "Friday", "Saturday", "Sunday"};
    private int weekday;
    
    
    public Component createWeatherTable() {
        weatherTable = new Table();
        weatherTable.addContainerProperty("Today", String.class,  null);
        weatherTable.addContainerProperty("Tomorrow", String.class, null);
        weekday = getWeekday();
        for(int i=0; i<7; i++){
        weatherTable.addContainerProperty(dayofweek[(weekday+i) % 7], String.class, null);
        }
        weatherTable.addItem();
        return weatherTable;
    }
    private int getWeekday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.get(Calendar.DAY_OF_WEEK);
    }
}
