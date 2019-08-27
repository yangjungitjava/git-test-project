package com.xinyusot;

import java.util.ArrayList;//没导包
import java.util.List;

public class A {
    private List l=null;
    public A(){

    }
    public List getDataSource(){
        return this.l;
    }
    public int getSize(){
        return this.l.size();
    }
    public void add(Object obj){
        if(this.l==null){
            this.l=new ArrayList(100);
            this.l.add(obj);
        }
    }
}
