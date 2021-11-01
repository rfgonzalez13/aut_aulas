package org.esei;

//Reader Interface
public interface Reader {

    void inicializar(int sheet);
	//returns a String from an input source or null in if there's none
	String readLine();
}
