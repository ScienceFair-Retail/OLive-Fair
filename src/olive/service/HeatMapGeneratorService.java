/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olive.service;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Image;
import olive.dao.HeatMapDAO;
import olive.model.HeatChart;
import olive.helper.HeatMapHelper;
import olive.model.HeatMapDataPoints;
/**
 *
 * @author haramamu
 */
public class HeatMapGeneratorService {
    /**
     *  Default Coordinate Index.
     */
    public static int COORDINATE_INDEX=4;
    public static String DEFAULT_FILE_SAVE="java-heat-chart.png";
    HeatMapDataPoints  heatMapDataPoints = new HeatMapDataPoints();
    HeatMapDAO  dao = new HeatMapDAO();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HeatMapGeneratorService generator = new HeatMapGeneratorService();
        generator.generateChargeImage();
     
      
    }
    /**
     *  Returns the a Image. 
     * The default coordinate index is 10.
     * @return 
     */
    public final Image generateChargeImage() {
        return generateChargeImage(COORDINATE_INDEX);
    }
    
    /**
     *  Returns the Chart Image 
     * @return 
     */
    protected Image generateChargeImage(int arrayIndex){
        heatMapDataPoints.insertDefault(arrayIndex);
        modifyHeatChartData();
        
        double[][] data = heatMapDataPoints.generateDoubleArray(arrayIndex);
    
        HeatChart map = new HeatChart(data);
            
        map.setTitle("OLive Heat Map");
        map.setXAxisLabel("X Shop Floor");
        map.setYAxisLabel("Y Shop Floor");
        map.setHighValueColour(Color.RED);

        map.setYValues(HeatMapHelper.getYAxis(arrayIndex));
        map.setXValues( HeatMapHelper.getXAxis(arrayIndex));
	
         try {
             // Default Save
            map.saveToFile(new File(DEFAULT_FILE_SAVE));        
      
        } catch (IOException ex) {
            Logger.getLogger(HeatMapGeneratorService.class.getName()).log(Level.SEVERE, null, ex);
        }
      return   map.getChartImage();
    }
    
    
   
    /**
     *  Protected Class for the Modifying the Heat Chart Data.
     */
    protected void modifyHeatChartData(){
    heatMapDataPoints.modifyPoints(dao.readHeapMap()); 
    }
    
}
