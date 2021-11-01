package org.esei;

public class TABtoAulas implements ToObject{
    
    int numTokens;

    TABtoAulas(){
        this.numTokens = 2;
    }

    public Aula transform(String line){
        String[] tokens = line.split("\t");
        //Check if given format it is correct
        if (tokens.length != numTokens) {
			throw new IllegalArgumentException(
						"the line does not contain " + numTokens + " tokens");
		}
        int capacidad = 0;
        try{
            capacidad = Integer.parseInt(tokens[1]);
        }catch(NumberFormatException e){
            System.out.println("Error al parsear capacidad de las aulas");
        }

        return new Aula(tokens[0], capacidad);
    }
}
