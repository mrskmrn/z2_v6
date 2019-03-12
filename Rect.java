package z2_v6;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class Rect implements Shape{
    
    public Rect() {
    }
    
    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        return false;
    }

    @Override
    public boolean contains(Point2D p) {
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double v) {
        return null;
    }

    public void paint(Graphics g) {
    	Rectangle2D rectangle2D = new Rectangle2D.Double(50, 100, 200, 150);
        Graphics2D gr2D = (Graphics2D) g;
        gr2D.setBackground(Color.white);
		   
		gr2D.setPaint(new GradientPaint(200,100,Color.black,200,250,Color.white));
		gr2D.fillRect(50, 100, 200, 150);
		
		gr2D.setColor(new Color(255, 0, 0));
		gr2D.drawRect(50, 100, 200, 150);
        gr2D.setFont(new Font("Verdana", Font.BOLD, 50));
        gr2D.drawString("STOP", 80, 190);
        
        Paint shadowPaint = new Color(0, 0, 0, 40);
        AffineTransform shadowTransform = AffineTransform.getShearInstance(-2.5, 0);
        shadowTransform.scale(1.0, 0.5);
        gr2D.setPaint(shadowPaint);
        gr2D.translate(311, 125);
        gr2D.fill(shadowTransform.createTransformedShape(rectangle2D));
        gr2D.translate(-311, -125);
    }
}