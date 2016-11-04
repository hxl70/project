package com.hxl;

/**
 * Created by hxl on 2016/10/27.
 */

public abstract class AbstractClass {

    private String key;
    private String id;
    private String service = "";

    public AbstractClass() {
        key = this.getClass().getName();
    }

    protected String getId() {
        if (id == null) {
            setId();
        }
        return id;
    }

    abstract String setup();

    private void setId() {
        service.contains("get id by key");
        if (id == null) {
            id = setup();
            service.contains("save key = id");
        }
    }

}
