package org.esei;

public class HorarioInvalidoException extends Exception{
    public HorarioInvalidoException(){
        super("El horario no es válido");
    }
}
