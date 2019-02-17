package paintprogram_java;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;

/**
 *
 * @author Radwa Ali
 */
public class Painter extends Applet{

  //  public static Painter forController = new Painter();
    public static Vector <Shapes> allShapes = new Vector<Shapes>();
    public static Vector <Shapes> removedShapes = new Vector<Shapes>();
    public static int numOfShapes = -1;
    public static int numOfRemovedShapes = -1;
    public static Choice colorPalette = new Choice();
    public static Checkbox fill = new Checkbox("Filled");
    public static Checkbox dashed = new Checkbox("Dashed");
     public static Checkbox border= new Checkbox("Border");

    public void paint(Graphics g) {
        for(int i=0; i<allShapes.size(); i++){
            //System.out.println(i);
            allShapes.get(i).drawShape(g);
        }
    }

    public void init() {
        
        colorPalette.addItem("Black");
        colorPalette.addItem("Blue");
        colorPalette.addItem("Red");
        colorPalette.addItem("Green");
        colorPalette.addItem("White");
        colorPalette.setBackground(Color.white);
        add(colorPalette);
        
        /* adding buttons */
        Button lineButton = new Button("Straight Line");
        Button freeButton = new Button("Free Line");
        Button rectButton = new Button("Rectangle");
        Button ovalButton = new Button("Oval");
        add(lineButton);
        add(freeButton);
        add(rectButton);
        add(ovalButton);
        
        Controller l = new Controller('L', this);
        lineButton.addActionListener(l);
        addMouseMotionListener(l);
        addMouseListener(l);
        
        Controller f = new Controller('F',this);
        freeButton.addActionListener(f);
        addMouseMotionListener(f);
        addMouseListener(f);
        
        Controller r = new Controller('R',this);
        rectButton.addActionListener(r);
        addMouseMotionListener(r);
        addMouseListener(r);
        
        Controller o = new Controller('O',this);
        ovalButton.addActionListener(o);
        addMouseMotionListener(o);
        addMouseListener(o);

        
        Button clearButton = new Button("Clear");
        Button undoButton = new Button("Undo");
        Button redoButton = new Button("Redo");
        Button eraserButton = new Button("Eraser");
        add(clearButton);
        add(undoButton);
        add(redoButton);
        add(eraserButton);
        
        clearButton.addActionListener(new Controller('C',this));
        
        Controller er = new Controller('E',this);
        eraserButton.addActionListener(er);
        addMouseListener(er);
        addMouseMotionListener(er);
//        save.addActionListener(this);
//        upload.addActionListener(this);
//        redo.addActionListener(this);
         Controller un = new Controller('U',this);
         undoButton.addActionListener(un);
         Controller re = new Controller('X',this);
         redoButton.addActionListener(re);
      
        add(fill);
        add(dashed);
        add(border);
        
        border.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (border.getState()) {
                    if(numOfShapes > -1)
                        allShapes.get(Painter.numOfShapes).drawBorder(Painter.colorPalette.getSelectedIndex());      
                } 
            }

        });

    }
    
    public void rePaint(){
        repaint();
    }
    
}
