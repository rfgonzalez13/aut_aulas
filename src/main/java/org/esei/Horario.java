package org.esei;

public class Horario{
    public float inicio;
    public float fin;
    public float duracion;
    public String id;

    public Horario(String horainicio, String horafin) throws HorarioInvalidoException{ 
        this.inicio = getHoraNum(horainicio);
        this.fin = getHoraNum(horafin);
        if (this.fin < this.inicio){
            throw new HorarioInvalidoException();
        }
        this.duracion = this.fin - this.inicio;
        this.id = this.inicio + " - " + this.fin;
    }

    public Boolean coincide(Horario horario){
        return !(horario.fin <= this.inicio || this.fin <= horario.inicio);
    }

    public String tostrHoraInicio(){
        return tostrHora(this.inicio);
    }

    public String tostrHoraFin(){
        return tostrHora(this.fin);
    }

    private String tostrHora(float hora){
        int minutos = Math.round((hora%1)*60);
        int horas = (int)hora;
        if (minutos > 0){ 
            return horas + ":" + minutos;
        }else{
            return horas + ":00"; 
        }
    }
    

    private float getHoraNum(String horario) throws HorarioInvalidoException{
        String[] inicio = horario.split(":");
        int hora = 00;
        try{
            hora =Integer.parseInt(inicio[0]);
            if (hora>23 || hora<0){
                throw new NumberFormatException();
            }
        }catch(NumberFormatException e){
            System.out.println("Formato de hora incorrecto");
            throw new HorarioInvalidoException();
        }
        int minutos = 0;
        try{
            minutos =Integer.parseInt(inicio[1]);
            if (minutos>=60 || minutos<0){
                throw new NumberFormatException();
            }
        }catch(NumberFormatException e){
            System.out.println("Formato de minutos incorrecto");
            throw new HorarioInvalidoException();
        }
        return hora + (float)minutos/60;
    }


}
