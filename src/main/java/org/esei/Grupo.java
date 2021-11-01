package org.esei;


public class Grupo {
    String id;
    Horario horario;
    int numAlumnos;
    Aula aula;
    AulaCollection candidatas;

    public Grupo(String id, Horario horario, int numAlumnos){
        this.id = id;
        this.horario = horario;
        this.numAlumnos = numAlumnos;
        this.candidatas = new AulaCollection();
    }
    public void addCandidata(Aula aula){
        this.candidatas.add(aula);
    }
    public void setAula(Aula aula){
        this.aula = aula;
    }
}
