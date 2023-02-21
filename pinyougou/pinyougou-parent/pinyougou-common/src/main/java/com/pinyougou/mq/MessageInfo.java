package com.pinyougou.mq;

import java.io.Serializable;

public class MessageInfo implements Serializable {

    private static final long serialVersionUID = -4206122703453814687L;

    public static final int METHOD_ADD=1;
    public static final int METHOD_DELETE=2;
    public static final int METHOD_UPDATE=3;

    //执行的动作 增删改-->123
    private int method;

    private Object context;

    public MessageInfo() {
    }

    public MessageInfo(int method, Object context) {
        this.method = method;
        this.context = context;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }
}
