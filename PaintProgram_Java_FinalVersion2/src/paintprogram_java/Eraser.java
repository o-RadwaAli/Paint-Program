
package paintprogram_java;
import java.awt.Graphics;

/**
 *
 * @author Radwa Ali
 */
public class Eraser extends Shapes {
    public Eraser(){}
    
    public Eraser(char t, int startX , int startY , int l , int w){
        super(t,startX , startY ,l,w);
    }
     public void drawShape(Graphics g){
        g.setColor(chooseColor(4)); // white
        
        int n = xPoint.size();
         int i ;
         for(i =0; i<n-1; i++){
            // g.fillRect(xPoint.get(i), yPoint.get(i), xPoint.get(i+1), yPoint.get(i+1));
             g.fillRect(xPoint.get(i), yPoint.get(i),xPoint.get(i+1) - 5,yPoint.get(i+1) - 5);
         }
        //System.out.print("I am drawing an Oval");  
    }
    
}
