package z2_v6;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class MyApplet extends Applet {
    private int cX, cY;
    private float border;
    private Rect tr;
    public static int t = 0;
    private static int APPLET_WIDTH = 900;
    private static int APPLET_HEIGHT = 350;

    @Override
    public void init() {
        setBackground(Color.WHITE);
        setSize(APPLET_WIDTH, APPLET_HEIGHT);
        border = 3;
        cX = APPLET_WIDTH / 2;
        cY = APPLET_HEIGHT / 2;

        tr = new Rect();
    }


    @Override
    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        BufferedImage img = new BufferedImage(450, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gr = img.createGraphics();
        tr.paint(gr);
        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(img, 0, 0, this);
        graphics2D.setFont(new Font("TimesNewRoman", Font.ITALIC, 20));
        graphics2D.drawString("Simple sign", 80, 280);
        
        BufferedImage img2 = new BufferedImage(450, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gr2 = img2.createGraphics();
        tr.paint(gr2);
        gr2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        BufferedImageOp filter = new AffineTransformOp(AffineTransform.getRotateInstance(-Math.PI / 4, 120, 200),
			      AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        graphics2D.drawImage(filter.filter(img2, null), 500, 0, this);
        graphics2D.drawString("Sign with filter (Rotate CÑW 45 degrees)", 450, 320);
    }
}