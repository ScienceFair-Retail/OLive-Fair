/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olive.model;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 *
 * @author haramamu
 */
public class HeatMapDataPoints {

    public LinkedHashMap<Points, Double> getLinkedHashMap() {
        return linkedHashMap;
    }

    public void setLinkedHashMap(LinkedHashMap<Points, Double> linkedHashMap) {
        this.linkedHashMap = linkedHashMap;
    }
     LinkedHashMap<Points,Double> linkedHashMap = new LinkedHashMap<>();
     
      public  void insertDefault(int coordinateSize) {
        int size =coordinateSize;
        int x = -size;
        int y = size;
        
        while(y >= -size) {
            while(x <= size) {
                Points point = new Points(x,y);
                linkedHashMap.put(point, new Double(0));
                x++;
            }
            x=-size;
            y--;
        }
    }
    
    
    public double[][] generateDoubleArray(int coordinateSize){
        int size =coordinateSize;
         int rowSize = 2*size +1;
        double[][] data = new double[rowSize][rowSize];
        /**
         *  Generate the data.
         */    
        int j=0;
        int x = 0;
        int y = 0;
        for(Points points:linkedHashMap.keySet()) {
            j++;
            System.out.print("["+points.toString() + "," + linkedHashMap.get(points) + "]");
            if(j%(2*coordinateSize+1) == 0) {
                System.out.println();
            }
           
            data[x][y] = linkedHashMap.get(points);
            y++;
            
            if(y == rowSize) {
                // reset y 
                // increment x
                x++;
                y=0;
            }
        }        
        return data;
    }
    
    /**
     *  Modifies Points
     * @param p
     * @param value 
     */
    public void modifyPoints(Points p,Double value){
        getLinkedHashMap().put(p, value);
    }
    
    
    public void modifyPoints(Map<Points,Double> modifiedData){
        getLinkedHashMap().putAll(modifiedData);
    }
     
}
