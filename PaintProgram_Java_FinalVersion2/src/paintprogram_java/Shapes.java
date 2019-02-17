package paintprogram_java;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Radwa Ali
 */
   public class Shapes {

    int x1, y1;  // starting points of shapes
    int x2, y2;  // ending points (width,height)
    char type;
    boolean filled = false; // default that shape is NOT colored
    boolean dashed = false; // default that shape is NOT dashed 
    int color = 0; // black =0 default ; blue_code= 1; red_code = 2; green_code =3;
    int border = color; // default that shape borders follow shape color
     
    ArrayList<Integer> xPoint = new ArrayList<Integer>();
    ArrayList<Integer> yPoint = new ArrayList<Integer>();
    // constructor 

    public Shapes() {
    }

    // Param. constructor 
    public Shapes(char t ,int startX, int startY , int endx, int endy) {
        x1 = startX;
        y1 = startY;
        x2 = endx;
        y2 = endy;
        type = t;
    }

    public char getType(){
        return type;
    }
    public void setEnd(int x, int y) {
        x2 = x;
        y2 = y;
    }

    public void setStart(int x, int y) {
        x1 = x;
        y1 = y;
    }
    
     public void setColor(int c) {
       color = c;
    }
     
     public void setAll(int stX, int endX, int stY, int endY , int c , boolean f,boolean f2){
         x1 = stX;
         x2 = endX;
         y1 = stY;
         y2 = endY;
         filled = f;
         dashed= f2;
         color = c;
     }

    public void drawShape(Graphics g) {
        //System.out.print("I am in the shape class");
    }
    
     public void drawBorder(int c) {
    }
    protected Color chooseColor(int colorCode) {
        switch (colorCode) {
            case 0:
                return Color.BLACK;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.RED;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
    }
    
    // SETTERS AND GETTERS 
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

}
