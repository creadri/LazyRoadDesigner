package com.creadri.lazyroaddesigner;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author creadri
 */
public class MaterialArray extends ArrayList<Material> {

    private Material tmpSearch;
    
    public MaterialArray(InputStream yamlFile) {
        super();
        
        loadYaml(yamlFile);
        
        tmpSearch = new Material(0, (byte)0, null, null);
        
        Collections.sort(this);
    }

    public final void loadYaml(InputStream stream) {
        Yaml yaml = new Yaml();

        Map<String, Map<String, Object>> map = (Map<String, Map<String, Object>>) yaml.load(stream);

        Iterator<Entry<String, Map<String, Object>>> it = map.entrySet().iterator();
        String name = "null";
        while (it.hasNext()) {
            try {
                Entry<String, Map<String, Object>> entry = it.next();
                Map<String, Object> imap = entry.getValue();
                
                int id = ((Integer) imap.get("id")).intValue();
                byte data = ((Integer) imap.get("data")).byteValue();
                name = entry.getKey();
                URL url = this.getClass().getResource((String) imap.get("img"));

                this.add(new Material(id, data, ImageIO.read(url), name));
            } catch (Exception ex) {
                System.err.println("Error with image for : " + name);
                //ex.printStackTrace();
            }
        }
    }
    
    
    public Image getImageFromIdData(int id, byte data) {
        tmpSearch.setId(id);
        tmpSearch.setData(data);
        int index = Collections.binarySearch(this, tmpSearch);
        if (index >= 0) {
            return this.get(index).getImage();
        }
        
        return null;
    }
}
