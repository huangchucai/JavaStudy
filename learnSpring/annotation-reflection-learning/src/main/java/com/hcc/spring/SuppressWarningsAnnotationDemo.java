package com.hcc.spring;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarningsAnnotationDemo {
    public void suppressUncheckedWarning() {
        @SuppressWarnings("rawtypes")
        List list = new ArrayList();
    }

    @SuppressWarnings("unused")
    public void suppressUnusedWarning(){
        int i = 5;
        int b = 10;
    }

    @SuppressWarnings({"deprecation"})
    public void suppressDeprecationWarning(){
        System.runFinalizersOnExit(true);
    }
}
