/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprogram_java;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Radwa Ali
 */
public class FreeLine extends Shapes {
    
    
    public FreeLine(){}
    
    public FreeLine(char t, int startX , int startY , int l , int w){
        super(t,startX , startY ,l,w);
    }
     public void drawShape(Graphics g){
         g.setColor(chooseColor(this.color));
         int n = xPoint.size();
         int i , M;
         //boolean flag = false;
         for(i =0; i<n-1; i++){
             g.drawLine(xPoint.get(i), yPoint.get(i), xPoint.get(i+1), yPoint.get(i+1));
         }
        //System.out.println("I am drawing a FREE line ");
    }
    
}
