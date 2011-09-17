/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creadri.lazyroaddesigner;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Nélis Adrien
 */
public class MaterialImageDisplay extends JLabel implements TableCellRenderer {

    private Color selected;
    private Color unselected;
    
    
    public MaterialImageDisplay() {
        setOpaque(true);
        selected = Color.LIGHT_GRAY;
        unselected = Color.WHITE;
        setPreferredSize(new Dimension(16, 16));
        setMaximumSize(getPreferredSize());
        setMinimumSize(getPreferredSize());
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (value instanceof Image) {
            setIcon(new ImageIcon((Image) value));
        }
        
        if (isSelected) {
            setBackground(selected);
            //setBorder(new BevelBorder(BevelBorder.LOWERED));
        } else {
            setBackground(unselected);
        }
        
        return this;
    }
    
    
}
