/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olive.model;

import java.util.HashSet;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author haramamu
 */
public class OLiveProperties {
    
     private static OLiveProperties oliveProps;

    public static String FILE_LOCATION =
            "olive.model.Olive";

    public static String getFILE_LOCATION() {
        return FILE_LOCATION;
    }

    public static void setFILE_LOCATION(String FILE_LOCATION) {
        OLiveProperties.FILE_LOCATION = FILE_LOCATION;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String jdbcUrl;
    private String userName;
    private String password;
    

    private void loadProperties() {
        ResourceBundle rb = ResourceBundle.getBundle(FILE_LOCATION);
        
                setUserName(rb.getString("password"));
        setPassword(rb.getString("user"));
        setJdbcUrl(rb.getString("url"));

    }
    
    
        public static synchronized final OLiveProperties getHandle() {
        if (oliveProps == null) {
            oliveProps = new OLiveProperties();
            oliveProps.loadProperties();
        }
        return oliveProps;
    }
}
