/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olive.dao;

import java.sql.DriverManager;

import java.util.Properties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import olive.model.Points;
import java.util.Map;
import java.util.HashMap;
import olive.model.OLiveProperties;
/**
 *
 * @author haramamu
 */
public class HeatMapDAO {

    private static final String SQL_GET_POINTS = "select X_AXIS,Y_AXIS,count(IMAGE_IDENTIFIER)as FREQ from OLIVE_HEAT_MAP group by X_AXIS,Y_AXIS,IMAGE_IDENTIFIER";

    public Map<Points,Double> readHeapMap() {
      
        Connection con = getTestConnection();
        
          Map<Points,Double> dataModel= new HashMap<>();

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_GET_POINTS);

            while (rs.next()) {
                int x = rs.getInt("X_AXIS");
                int y = rs.getInt("Y_AXIS");
                int frequency = rs.getInt("FREQ");
                
                dataModel.put(new Points(x,y), new Double(frequency));
                System.out.println("X" + x + " Y " + y + "frequency" + frequency);
            }

        } catch (SQLException exception) {
             Logger.getLogger(HeatMapDAO.class.getName()).log(Level.SEVERE, null, exception);
        }
        
        return dataModel;
    }

    public static Connection getTestConnection() {
        Properties properties = new Properties(); // Create Properties object
        properties.put("user", OLiveProperties.getHandle().getUserName());         // Set user ID for connection
        properties.put("password", OLiveProperties.getHandle().getPassword());     // Set password for connection
        String url = OLiveProperties.getHandle().getJdbcUrl();
        // Set URL for data source
        Connection con = null;
        // Create connection

        try {
            con = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            Logger.getLogger(HeatMapDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }

    public static void main(String args[]) {
        HeatMapDAO d = new HeatMapDAO();
        d.readHeapMap();
    }
}
