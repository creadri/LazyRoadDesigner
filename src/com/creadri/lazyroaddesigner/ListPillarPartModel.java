package com.creadri.lazyroaddesigner;

import com.creadri.lazyroad.Pillar;
import javax.swing.AbstractListModel;

/**
 *
 * @author creadri
 */
public class ListPillarPartModel extends AbstractListModel {
    
    private Pillar pillar;

    public ListPillarPartModel() {
        super();
    }
    
    public Pillar getPillar() {
        return pillar;
    }

    public void setPillar(Pillar pillar) {
        this.pillar = pillar;
    }
    
    @Override
    public Object getElementAt(int index) {
        if (pillar == null) {
            return null;
        }
        return pillar.getPillarPart(index);
    }

    @Override
    public int getSize() {
        if (pillar == null) {
            return 0;
        }
        return pillar.size();
    }
}
