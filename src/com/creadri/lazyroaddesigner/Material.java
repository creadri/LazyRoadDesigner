/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creadri.lazyroaddesigner;

import java.awt.Image;

/**
 *
 * @author creadri
 */
public class Material implements Comparable<Material> {
    private int id;
    private byte data;
    private Image image;
    private String name;

    public Material(int id, byte data, Image image, String name) {
        this.id = id;
        this.data = data;
        this.image = image;
        this.name = name;
    }

    public byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Material o) {
        
        int iddiff = id - o.id;
        if (iddiff == 0) {
            return data -o.data;
        } else {
            return iddiff;
        }
    }
}
