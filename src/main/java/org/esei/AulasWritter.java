package org.esei;

public class AulasWritter implements Writter{

    AulaCollection out;
    
    AulasWritter(AulaCollection out){
        this.out = out;
    }

    public void writeObject(Object o) {
        if("Aula".equals(o.getClass().getSimpleName())){
            out.add((Aula)o);
        }
        
    }
    
}
