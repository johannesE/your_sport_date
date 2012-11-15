/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nasreldin_johannes;

import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johannes Eifert
 */
public class DatabaseHelper {
    private JDBCConnectionPool connectionPool = null;

    public DatabaseHelper() {
        initConnectionPool();
    }

    private void initConnectionPool(){
        try {
            connectionPool = new SimpleJDBCConnectionPool(
                    "org.hsqldb.jdbc.JDBCDriver",
                    "jdbc:hsqldb:mem:sqlcontainer", "SA", "", 2, 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connectionPool.reserveConnection().nativeSQL("CREATE TABLE city (id"
                    + " INTEGER GENERATED ALWAYS AS IDENTITY, name VARCHAR(64), "
                    + "version INTEGER DEFAULT 0 NOT NULL, PRIMARY KEY (id));");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
