package com.hxl.factory;

/**
 * Created by hxl on 2016/10/18.
 */
public class IOSFactory implements Factory {
    @Override
    public InterfaceController getInterface() {
        return new IOSInterfaceController();
    }

    @Override
    public OperationController getOperation() {
        return new IOSOperationController();
    }
}
