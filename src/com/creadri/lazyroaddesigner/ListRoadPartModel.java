package com.creadri.lazyroaddesigner;

import com.creadri.lazyroad.Road;
import javax.swing.AbstractListModel;

/**
 *
 * @author creadri
 */
public class ListRoadPartModel extends AbstractListModel{
    
    private Road road;

    public ListRoadPartModel() {
        super();
    }
    
    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }
    
    @Override
    public Object getElementAt(int index) {
        if (road == null) {
            return null;
        }
        return road.getRoadPart(index);
    }

    @Override
    public int getSize() {
        if (road == null) {
            return 0;
        }
        return road.size();
    }
}
