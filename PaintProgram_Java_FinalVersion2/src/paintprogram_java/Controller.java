package paintprogram_java;

import java.awt.event.*;

/**
 *
 * @author Radwa Ali
 */
public class Controller implements ActionListener, MouseListener, MouseMotionListener {

    private boolean bPressed = false, created = false;
    private char buttonCode;
    private int oldx, oldy;
    private int curentColor = 0; // FreeLine --> F , Rectangle --> R , Oval --> O , Line --> L , Clear --> C
    private boolean currentFill = false;
    private boolean currentDashed = false;
    private boolean border = false;
    Painter forController;

    // constructor
    public Controller() {
    }

    // Param. Controller
    public Controller(char c,Painter p) {
       forController = p;
        buttonCode = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bPressed = true;
        if (this.buttonCode == 'C') {
            Painter.allShapes.clear();  // Clear untill we add the undo option.
            Painter.numOfShapes = -1;
            forController.rePaint();
        }

        if (this.buttonCode == 'U' && !Painter.allShapes.isEmpty()) { // undo 
            Painter.removedShapes.add(Painter.allShapes.get(Painter.numOfShapes));
            Painter.allShapes.remove(Painter.numOfShapes);
            Painter.numOfRemovedShapes++;
            Painter.numOfShapes--;
            forController.rePaint();
        }

        if (this.buttonCode == 'X' && !Painter.removedShapes.isEmpty()) { // redo 
            Painter.allShapes.add(Painter.removedShapes.get(Painter.numOfRemovedShapes));
            Painter.removedShapes.remove(Painter.numOfRemovedShapes);
            Painter.numOfShapes++;
            Painter.numOfRemovedShapes--;
            forController.rePaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("adfgb");
        if (bPressed) {
            oldx = e.getX();
            oldy = e.getY();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (bPressed) {
            char code = this.buttonCode;
            switch (code) {
                case 'F': // Draw Free Line 
                    if (!created) {
                        Shapes free = new FreeLine();
                        free.setStart(oldx, oldy);
                        free.setEnd(e.getX(), e.getY());
                        free.xPoint.add(oldx);
                        free.yPoint.add(oldy);
                        free.setColor(Painter.colorPalette.getSelectedIndex());
                        Painter.allShapes.add(free);
                        Painter.numOfShapes++;
                        created = true;
                    } else {
                        Painter.allShapes.get(Painter.numOfShapes).xPoint.add(e.getX());
                        Painter.allShapes.get(Painter.numOfShapes).yPoint.add(e.getY());
                    }
                        forController.rePaint();

                    break;

                case 'R':  // Draw Rectangle

                    if (!created) {
                        if (Painter.fill.getState()) {
                            currentFill = true;
                        }
                        if (Painter.dashed.getState()) {
                            currentDashed = true;
                        }
                        Shapes r = new Rectangle('R', e.getX(), e.getY(), 0, 0);
                        r.color = Painter.colorPalette.getSelectedIndex();
                        r.filled = currentFill;
                        r.dashed = currentDashed;
                        Painter.allShapes.add(r); // add it to vector
                        Painter.numOfShapes++;
                        created = true;
                    } else {
                        Shapes sh = Painter.allShapes.get(Painter.numOfShapes);
                        int x, y, width, height; 
                        if (e.getX() >= oldx) {  // x1 is left edge
                            x = oldx;
                            width = e.getX() - oldx;
                        } else {          // x2 is left edge
                            x = e.getX();
                            width = oldx - e.getX();
                        }
                        if (e.getY() >= oldy) {  // y1 is left edge
                            y = oldy;
                            height = e.getY()- oldy;
                        } else {        // y2 is right edge
                            y =e.getY();
                            height = oldy -e.getY();
                        }
                        sh.setStart(x, y);
                        sh.setEnd(width,height);
                      //  Painter.allShapes.get(Painter.numOfShapes).setEnd(e.getX() - oldx, e.getY() - oldy);
                    }
                    forController.rePaint();

                    break;
                case 'L':  // Draw Line
                    if (!created) {
                        if (Painter.dashed.getState()) {
                            currentDashed = true;
                        }
                        Shapes l = new Line('L', e.getX(), e.getY(), e.getX(), e.getY());
                        l.color = Painter.colorPalette.getSelectedIndex();
                        l.dashed = currentDashed;
                        Painter.allShapes.add(l);
                        Painter.numOfShapes++;
                        created = true;
                    } else {
                        Painter.allShapes.get(Painter.numOfShapes).setEnd(e.getX(), e.getY());
                    }
                    forController.rePaint();

                    break;
                case 'O':  // Draw Oval 
                    if (!created) {
                        if (Painter.fill.getState()) {
                            currentFill = true;
                        }

                        if (Painter.dashed.getState()) {
                            currentDashed = true;
                        }
                        Shapes o = new Oval('O', e.getX(), e.getY(), 0, 0);
                        o.color = Painter.colorPalette.getSelectedIndex();
                        o.filled = currentFill;
                        o.dashed = currentDashed;
                        Painter.allShapes.add(o);
                        Painter.numOfShapes++;
                        created = true;
                    } else {
                        Shapes sh = Painter.allShapes.get(Painter.numOfShapes);
                        int x, y, width, height; 
                        if (e.getX() >= oldx) {  // x1 is left edge
                            x = oldx;
                            width = e.getX() - oldx;
                        } else {          // x2 is left edge
                            x = e.getX();
                            width = oldx - e.getX();
                        }
                        if (e.getY() >= oldy) {  // y1 is left edge
                            y = oldy;
                            height = e.getY()- oldy;
                        } else {        // y2 is right edge
                            y =e.getY();
                            height = oldy -e.getY();
                        }
                        sh.setStart(x, y);
                        sh.setEnd(width,height);
                       // Painter.allShapes.get(Painter.numOfShapes).setEnd(e.getX() - oldx, e.getY() - oldy);
                    }
                    forController.rePaint();
                    break;

                case 'E': // Eraser 

                    if (!created) {
                        Shapes eraser = new Eraser();
                        eraser.setStart(oldx, oldy);
                        eraser.setEnd(e.getX(), e.getY());
                        eraser.xPoint.add(oldx);
                        eraser.yPoint.add(oldy);
                        Painter.allShapes.add(eraser);
                        Painter.numOfShapes++;
                        created = true;

                    } else {
                        Painter.allShapes.get(Painter.numOfShapes).xPoint.add(e.getX());
                        Painter.allShapes.get(Painter.numOfShapes).yPoint.add(e.getY());
                    forController.rePaint();
                    break;
            }
        }
    }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (bPressed) {
        }
        bPressed = created = currentFill = currentDashed = border = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    }

