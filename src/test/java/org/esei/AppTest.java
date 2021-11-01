package org.esei;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void HorarioCreado()
    {
        try{
            Horario h = new Horario("10:00", "12:30");
            assertTrue(h.inicio == 10.0);
            assertTrue(h.fin == 12.5);
        }catch(HorarioInvalidoException e){
            assertTrue(false);
        }
    }


    @Test
    public void horarioNoCoinciden()
    {
        try{
            Horario h1 = new Horario("10:00", "12:00");
            Horario h2 = new Horario("9:00", "10:00");
            Horario h3 = new Horario("12:00", "13:00");
            assertFalse(h1.coincide(h2));
            assertFalse(h1.coincide(h3));
            assertFalse(h3.coincide(h2));
        }catch(HorarioInvalidoException e){
            assertFalse(true);
        }
    }

    @Test
    public void horarioSiCoinciden()
    {
        try{
            Horario h1 = new Horario("10:00", "12:00");
            Horario h2 = new Horario("9:00", "11:00");
            Horario h3 = new Horario("11:00", "12:00");
            Horario h4 = new Horario("9:00", "13:00");
            Horario h5 = new Horario("11:00", "11:30");
            assertTrue(h1.coincide(h2));
            assertTrue(h1.coincide(h3));
            assertTrue(h1.coincide(h4));
            assertTrue(h1.coincide(h5));
        }catch(HorarioInvalidoException e){
            assertFalse(true);
        }
    }

    @Test
    public void horariosExcepciones()
    {
        Horario h1 = null;
        try{
            h1 = new Horario("10:00", "26:00");
            assertFalse(true);
        }catch(HorarioInvalidoException e){
            assertFalse(false);
        }
        try{
            h1 = new Horario("20:00", "12:00");
            assertFalse(true);
        }catch(HorarioInvalidoException e){
            assertFalse(false);
        }
        try{
            h1 = new Horario("10:00", "12:85");
            assertFalse(true);
        }catch(HorarioInvalidoException e){
            assertFalse(false);
        }
        try{
            h1 = new Horario("12:00", "1200:00");
            assertFalse(true);
        }catch(HorarioInvalidoException e){
            assertFalse(false);
        }
        try{
            h1 = new Horario("andadad", "20:00");
            assertFalse(true);
        }catch(HorarioInvalidoException e){
            assertFalse(false);
        }
        try{
            h1 = new Horario("10:xx", "12:00");
            assertFalse(true);
        }catch(HorarioInvalidoException e){
            assertFalse(false);
        }
        assertNull(h1);
    }

    @Test
    public void horarioTostr()
    {
        try{
            Horario h1 = new Horario("10:25", "12:35");
            assertEquals(h1.tostrHoraInicio(), "10:25");
            assertEquals(h1.tostrHoraFin(), "12:35");
        }catch(HorarioInvalidoException e){
            assertFalse(true);
        }
    }

    @Test
    public void horarioTostr00()
    {
        try{
            Horario h1 = new Horario("10:00", "12:33");
            assertEquals(h1.tostrHoraInicio(), "10:00");
            assertEquals(h1.tostrHoraFin(), "12:33");
        }catch(HorarioInvalidoException e){
            assertFalse(true);
        }
    }

    @Test
    public void leerXLSX(){
        File f = new File("./res/Aulas.xlsx"); 
        Reader r = new XlsxReader(f);
        r.inicializar(0);
        assertNotNull(r.readLine());
    }

    @Test
    public void transformarToAulas(){
        File f = new File("./res/Aulas.xlsx"); 
        Reader r = new XlsxReader(f);
        ToObject t = new TABtoAulas();
        r.inicializar(0);
        Aula a1 = (Aula)t.transform(r.readLine());
        System.out.println(a1.toString());
        assertNotNull(a1);
    }

    @Test
    public void containsAulas(){
        Aula a1 = new Aula("SO1", 16);
        Aula a2 = new Aula("SO1", 30);
        Aula a3 = new Aula("SO2", 40);
        AulaCollection aulas = new AulaCollection();
        assertTrue(aulas.add(a1));
        assertTrue(aulas.contains(a1));
        assertTrue(aulas.contains(a2));
        assertFalse(aulas.add(a2));
        assertFalse(aulas.contains(a3));
        assertTrue(aulas.add(a3));
        assertTrue(aulas.contains(a3));
    }


    @Test
    public void buscarAulas(){
        Aula a1 = new Aula("SO1", 16);
        Aula a2 = new Aula("SO2", 30);
        Aula a3 = new Aula("SO3", 40);
        AulaCollection aulas = new AulaCollection();
        aulas.add(a1);
        aulas.add(a2);
        assertEquals(aulas.getById("SO2"), a2);
        assertNull(aulas.getById("SO3"));
        aulas.add(a3);
        assertEquals(aulas.getById("SO3"), a3);
    }


}
