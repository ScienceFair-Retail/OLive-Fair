/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olive.model;

/**
 *
 * @author haramamu
 */
public class Points {
    
    int x;
    int y;
    
    
    public Points(int x,int y) {
        this.x=x;
        this.y=y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object o) {
        Points p =(Points)o;
        if((p.x == this.x) && (p.y == this.y)) {
            return true;
        }else {
            return false;
        }
        
    }
    /**
     * 
     * @return 
     */    
    public String toString(){
        return this.x + "," + this.y;
    }
            @Override
        public int hashCode() {
            return (int)(7 * x + y * 103);
        }
    
    
}
