package com.hxl;

import java.util.List;

/**
 * Created by hxl on 2016/9/27.
 */
public class EntityObject {

    private String identity;
    private String type;
    private List<SourceData> sourceData;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SourceData> getSourceData() {
        return sourceData;
    }

    public void setSourceData(List<SourceData> sourceData) {
        this.sourceData = sourceData;
    }
}
