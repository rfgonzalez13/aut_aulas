package org.esei;

public class Aula{
    String id;
    int capacidad;

    public String getId(){
        return this.id;
    }

    public Aula(String id, int capacidad){
        this.id = id;
        this.capacidad = capacidad;
    }
    @Override
    public String toString(){
        return this.id + ": " + this.capacidad;

    }
}
