package org.esei;

public class ConsoleWritter implements Writter{

    public void writeObject(Object o) {
        System.out.println(o.toString());
    }
    
}
