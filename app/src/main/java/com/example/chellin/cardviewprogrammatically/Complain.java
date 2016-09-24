package com.example.chellin.cardviewprogrammatically;

/**
 * Created by fiyyanp on 7/16/2016.
 */
public class Complain {
    public Object outMsg;
    public String status;
    public String inMsg;
    public String localTs;

    public Complain() {
    }

    public Complain(Object outMsg, String status, String inMsg, String localTs) {
        this.outMsg = outMsg;
        this.status = status;
        this.inMsg = inMsg;
        this.localTs = localTs;
    }

    public Object getOutMsg() {
        return outMsg;
    }

    public void setOutMsg(Object outMsg) {
        this.outMsg = outMsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInMsg() {
        return inMsg;
    }

    public void setInMsg(String inMsg) {
        this.inMsg = inMsg;
    }

    public String getLocalTs() {
        return localTs;
    }

    public void setLocalTs(String localTs) {
        this.localTs = localTs;
    }
}
