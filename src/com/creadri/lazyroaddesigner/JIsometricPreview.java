package com.creadri.lazyroaddesigner;

import com.creadri.lazyroad.Road;
import com.creadri.lazyroad.RoadPart;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author creadri
 */
public class JIsometricPreview extends JPanel {

    private Road road;
    private MaterialArray isometrics;
    private float zoom = 1;

    public JIsometricPreview() {
    }

    public JIsometricPreview(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public JIsometricPreview(LayoutManager layout) {
        super(layout);
    }

    public JIsometricPreview(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public MaterialArray getIsometrics() {
        return isometrics;
    }

    public void setIsometrics(MaterialArray isometrics) {
        this.isometrics = isometrics;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    @Override
    public void paint(Graphics g) {
        if (road == null) {
            return;
        }

        g.setColor(Color.gray);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        int yIncrement = (int) ((float)14 * zoom);
        int xIncrement = (int) ((float)25 * zoom);
        int yIncrement2 = (int) ((float)6 * zoom);
        int xIncrement2 = (int) ((float)11 * zoom);
        

        int initialX = 0;
        int initialY = getHeight() / 2;

        int maxCount = road.getMaxSequence() + 5;
        for (int count = 0; count < maxCount; count++) {

            RoadPart part = road.getRoadPartToBuild(count);
            if (part == null) {
                continue;
            }

            int ids[][] = part.getIds();
            byte datas[][] = part.getDatas();

            int height = part.getHeight();
            int width = part.getWidth();

            for (int i = 0; i < height; i++) {

                int y = initialY - (i * yIncrement);
                int x = initialX + (width * xIncrement);

                for (int j = 0; j < width; j++) {

                    int id = ids[i][j];
                    byte data = datas[i][j];
                    
                    Image img = isometrics.getImageFromIdData(id, data);
                    if (img != null) {
                        if (zoom == 1) {
                            g.drawImage(img, x, y, null);
                        } else {
                            g.drawImage(img, x, y, xIncrement, xIncrement, null);
                        }
                    }

                    x -= xIncrement2;
                    y += yIncrement2;
                }
            }

            initialX += xIncrement2;
            initialY += yIncrement2;
        }
    }
}
