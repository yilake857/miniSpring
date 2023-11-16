package org.github.springframework.beans;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyu
 * Created on 2023-11-16
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for(int i = 0;i < propertyValueList.size();i++){
            PropertyValue propertyValue =  this.propertyValueList.get(i);
            if(propertyValue.equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }



}
