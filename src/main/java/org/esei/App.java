package org.esei;

import java.io.File;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File f = new File("./res/Aulas.xlsx"); 
        Reader r = new XlsxReader(f);
        ToObject t = new TABtoAulas();
        Writter w = new ConsoleWritter();
        r.inicializar(0);
        for (int i=0; i<21;i++){
            w.writeObject((Aula)t.transform(r.readLine()));
        }
        
    }
}
