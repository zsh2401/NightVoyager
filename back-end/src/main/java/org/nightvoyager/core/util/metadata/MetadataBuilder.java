package org.nightvoyager.core.util.metadata;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class MetadataBuilder {
    private final HashMap<String,String> map = new HashMap<>();
    public void setName(String name){
        map.put(MetadataKey.NAME,name);
    }
    public void setDescription(String description){
        map.put(MetadataKey.DESCRIPTION,description);
    }
    public void setAuthor(String author){
        map.put(MetadataKey.AUTHOR,author);
    }
    public Map<String,String> getResult(){
        return Collections.unmodifiableMap(map);
    }
}
