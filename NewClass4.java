/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mini_project;
import java.awt.*;  
import java.awt.event.*;  
import java.applet.*;  
import javax.swing.JComponent;
/**
 *
 * @author Baruni Priya TS
 */
public class NewClass4 extends JComponent {
    private Image image;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY;
    public NewClass4() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX=e.getX();
                oldY=e.getY();
            }
        }
        );
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX=e.getX();
                currentY=e.getY();
                if(g2!=null)
                {
                    g2.drawLine(oldX, oldY, currentX,currentY);
                    repaint();
                    oldX=currentX;
                    oldY=currentY;
                }
            }
        }
        );
    }
    protected void paintComponent(Graphics g) {
        if(image==null) {
            image=createImage(getSize().width,getSize().height);
            g2=(Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0,0,null);
    }
    public void clear()  {
        g2.setPaint(Color.WHITE);
        g2.fillRect(0,0,getSize().width,getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
    
    
} 

