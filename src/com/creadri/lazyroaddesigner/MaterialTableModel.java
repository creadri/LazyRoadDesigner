/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creadri.lazyroaddesigner;

import java.awt.Image;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nélis Adrien
 */
public class MaterialTableModel extends AbstractTableModel {

    private MaterialArray materials;

    public MaterialTableModel(MaterialArray ma) {
        this.materials = ma;
    }
    
    public Material getMaterial(int row) {
        return materials.get(row);
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return materials.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return materials.get(rowIndex).getImage();
        } else {
            return materials.get(rowIndex).getName();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Image.class;
            default:
                return String.class;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return null;
            case 1:
                return "Name";
        }
        return "Default";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
