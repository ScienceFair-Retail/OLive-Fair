/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olive.helper;

/**
 *
 * @author haramamu
 */
public class HeatMapHelper {
    
    /**
     * Gets all the XAxis
     * @param coordinateSize
     * @return 
     */
    public static Object[] getXAxis(int coordinateSize){
        int x=-coordinateSize;
        int y = -(x);
        int t=0;
        Object[] xAxis = new Object[2*y+1]; 
        while(x <= y ) {
            xAxis[t++] = x;
            x++;
        }
//        printData(xAxis);
        return xAxis;
    }
    /**
     *  Gets the Y Axis.
     * @param coordinateSize
     * @return 
     */
    public static Object[] getYAxis(int coordinateSize){
        int y=coordinateSize;
        int x = -(y);
        int t=0;
        Object[] yAxis = new Object[2*y+1]; 
        while(y >= x ) {
            yAxis[t++] = y;
            y--;
        }
//        printData(yAxis);
        return yAxis;
    }
    
    /**
     *  
     * @param myArray 
     */
     private void printAxisData(Object[] myArray) {
        for(int i=0;i<myArray.length;i++) {
            System.out.print(myArray[i]);
            System.out.print(" ");
        }
    }
}
