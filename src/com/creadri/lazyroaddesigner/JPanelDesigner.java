/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelDesigner.java
 *
 * Created on 06-juil.-2011, 13:29:06
 */
package com.creadri.lazyroaddesigner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Nélis Adrien
 */
public class JPanelDesigner extends javax.swing.JPanel {

    private int width;
    private int height;
    private int column;
    private int row;
    private int blockSize;
    private Image[][] imgs;
    private Image player;
    private int groundLayer;

    /** Creates new form JPanelDesigner */
    public JPanelDesigner() {
        setDesignSize(0, 0);
    }

    public Image getPlayer() {
        return player;
    }

    public void setPlayer(Image player) {
        this.player = player;
    }

    public int getGroundLayer() {
        return groundLayer;
    }

    public void setGroundLayer(int groundLayer) {
        this.groundLayer = groundLayer;
    }

    public final void setDesignSize(int width, int height) {

        this.width = width;
        this.height = height;

        imgs = new Image[height][width];
    }

    @Override
    public void paint(Graphics g) {
        // draw the black outside
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        if (width == 0 || height == 0) {
            return;
        }

        blockSize = Math.min(getWidth(), getHeight()) / Math.max(width, height);

        int gridWidth = width * blockSize;
        int gridHeight = height * blockSize;
        
        // draw the air
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, gridWidth, gridHeight);

        // draw the player if there is one
        if (player != null) {
            g.drawImage(player, ((width / 2) * blockSize) + 1, ((height - groundLayer - 3) * blockSize) + 1, blockSize - 1, (blockSize * 2) - 1, this);
        }
        
        // draw the lines
        g.setColor(Color.black);

        // draw vertical lines
        for (int i = 0; i <= width; i++) {
            g.drawLine(i * blockSize, 0, i * blockSize, gridHeight);
        }
        // draw horizontal lines
        for (int i = 0; i <= height; i++) {
            g.drawLine(0, i * blockSize, gridWidth, i * blockSize);
        }

        // draw images
        if (imgs != null) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Image img = imgs[i][j];
                    if (img != null) {
                        g.drawImage(img, (j * blockSize) + 1, ((height - i - 1) * blockSize) + 1, blockSize - 1, blockSize - 1, this);
                    }
                }
            }
        }
    }

    public void fillBlock(int x, int y, Image img) {
        Graphics g = getGraphics();

        // get the location
        column = (x / blockSize) >= width ? width - 1 : (x / blockSize);
        int displayRow = (y / blockSize) >= height ? height - 1 : (y / blockSize);
        row = height - 1 - displayRow;
        
        // memorize
        imgs[row][column] = img;
        // in case of transparent images
        g.setColor(Color.lightGray);
        g.fillRect((column * blockSize) + 1, (displayRow * blockSize) + 1, blockSize - 1, blockSize - 1);
        // draw image
        g.drawImage(img, (column * blockSize) + 1, (displayRow * blockSize) + 1, blockSize - 1, blockSize - 1, this);
    }

    public void fillAir(int x, int y) {
        Graphics g = getGraphics();

        // get the location
        column = (x / blockSize) >= width ? width - 1 : (x / blockSize);
        int displayRow = (y / blockSize) >= height ? height - 1 : (y / blockSize);
        row = height - 1 - displayRow;
        
        // memorize
        imgs[row][column] = null;
        
        // draw
        g.setColor(Color.lightGray);
        g.fillRect((column * blockSize) + 1, (displayRow * blockSize) + 1, blockSize - 1, blockSize - 1);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public Image[][] getImgs() {
        return imgs;
    }

    public void setImgs(Image[][] imgs) {
        this.imgs = imgs;
    }

    public void setImgAt(int x, int y, Image img) {
        this.imgs[y][x] = img;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
