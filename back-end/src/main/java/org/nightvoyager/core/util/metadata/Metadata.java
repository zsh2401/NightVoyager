package org.nightvoyager.core.util.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public final class Metadata{

    public static final String KEY_NAME = "nvsys_name";
    public static final String KEY_ID = "nvsys_id";
    public static final String KEY_AUTHOR = "nvsys_author";
    public static final String VALUE_NOT_SUPPORT = "___nsX___";
    public static final String KEY_TITLE = "nvsys_title";
    public static final String KEY_DESCRIPTION = "nvsys_desc";
    @NotNull
    private Map<String,Object> map;

    public Metadata(@NotNull Map<String,Object> kv){
        this.map = kv;
    }

    @JsonProperty("__map__")
    @NotNull
    public Map<String,Object> getSourceMap(){
        //No clone
        return this.map;
    }

    @JsonIgnore
    @NotNull
    public String toJson() throws Exception{
        return new ObjectMapper().writeValueAsString(this);
    }

    @JsonProperty("name")
    @NotNull
    public String name(){
        return getValue(KEY_NAME,"Unknown name");
    }

    @JsonProperty("id")
    @NotNull
    public String id(){
        return getValue(KEY_ID,VALUE_NOT_SUPPORT);
    }

    @JsonProperty("description")
    @NotNull
    public String description(){
        final String DEFAULT_VALUE = "";
        return getValue(KEY_DESCRIPTION,DEFAULT_VALUE);
    }

    @JsonIgnore
    public Object getValue(@NotNull final String key){
        return map.get(key);
    }

    @JsonIgnore
    public <T extends Object> T
        getValue(@NotNull final String key,@NotNull Class<T> covertType) throws Exception{
        return (T)map.get(key);
    }

    @JsonIgnore
    public <T extends Object> T
    getValue(@NotNull final String key,final T defaultValue){
        try{
                return getValue(key,(Class<T> )defaultValue.getClass());
            }catch (Exception e){
    //            e.printStackTrace();
                return defaultValue;
            }
    }
}
