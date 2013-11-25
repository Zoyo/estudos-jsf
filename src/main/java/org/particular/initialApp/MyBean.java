package org.particular.initialApp;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "myBean")
@SessionScoped
public class MyBean implements Serializable {

    private static final long serialVersionUID = 8301865434469950945L;

    String str = "hello";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void reset(ActionEvent ae) {
        str = "";
    }

}
