package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    public static void main(String[] args) {
        List list=new ArrayList();
        Random rm = new Random();
        for(int i=0;i<100;i++) {
            System.out.println(rm.nextInt(100)+1);
        }
    }

}
