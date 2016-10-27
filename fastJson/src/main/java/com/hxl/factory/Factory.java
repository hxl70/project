package com.hxl.factory;

/**
 * Created by hxl on 2016/10/18.
 */
public interface Factory {

    InterfaceController getInterface();

    OperationController getOperation();

}
