package paintprogram_java;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Radwa Ali
 */
public class Oval extends Shapes {
    
    public Oval(){}
    
    public Oval(char t, int startX , int startY , int l , int w){
        super(t,startX , startY ,l,w);
    }
    
    public void drawShape(Graphics g){
        
      g.setColor(chooseColor(this.color));
        if(this.filled)
            g.fillOval(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        Graphics2D gd = (Graphics2D) g;
        if(this.dashed)
        {
            BasicStroke b = new BasicStroke(1, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL, 10,new float[]{9},0);
            gd.setStroke(b);
            gd.setColor(chooseColor(this.color));
            gd.drawOval(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        }
        else
            g.drawOval(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        //System.out.print("I am drawing an Oval");  
    }
    
        public void drawBorder(int c){
        if (c != this.color){ 
            //Shapes thisBorder = this ;
            Shapes thisBorder = new Oval('O',this.x1 -1, this.y1 - 1,this.x2 + 1, this.y2 + 1 );
            thisBorder.filled = false;
            thisBorder.color = c;
            Painter.allShapes.add(thisBorder); // add it to vector
            Painter.numOfShapes ++;
            System.out.println("A border is being drawn");
        }   
    }
    
    
}
