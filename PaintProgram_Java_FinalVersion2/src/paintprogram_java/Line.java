package paintprogram_java;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Radwa Ali
 */
public class Line extends Shapes{
    
     public Line(){}
    
    public Line(char t, int startX , int startY , int l , int w){
        super(t,startX , startY ,l,w);
    }
    
    public void drawShape(Graphics g){
        
         Graphics2D gd = (Graphics2D) g;
        if(this.dashed)
        {
            BasicStroke b = new BasicStroke(1, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL, 10,new float[]{9},0);
            gd.setStroke(b);
            gd.setColor(chooseColor(this.color));
            gd.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        }
         else
        {
             g.setColor(chooseColor(this.color));
             g.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());   
            
        }
        
     //   gd.dispose();
    }
}
