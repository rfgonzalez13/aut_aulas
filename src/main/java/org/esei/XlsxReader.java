package org.esei;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class XlsxReader implements Reader{
    
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    Iterator<Row> itr;
 
    XlsxReader(File f){
        try{
            this.fis = new FileInputStream(f);
            this.wb = new XSSFWorkbook(fis); 
        }catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado");
        }catch(IOException e){
            System.out.println("Error en la entrada/salida");
        }
        
    }
    public void inicializar(int sheet){
        this.sheet = wb.getSheetAt(sheet);
        itr = this.sheet.iterator();
    }
    public String readLine(){ 
        String toret = "";
        try{    
            if (itr == null){
                throw new NullPointerException();
            }
        }catch(NullPointerException e){
            System.out.println("Sheet no inicializada, por favor haz setSheet(numerosheet)");
        }
        if(itr.hasNext()) {
			Row row = itr.next();  
            Iterator<Cell> cellIterator = row.cellIterator(); 
            while (cellIterator.hasNext()){
                Cell celldata = cellIterator.next();  
                switch(celldata.getCellType()) {
                    case STRING:
                        toret += celldata.getStringCellValue() + "\t";
                        break;
                    case NUMERIC:
                        toret += (int)celldata.getNumericCellValue() + "\t";
                        break;
                    case BOOLEAN:
                        if(celldata.getBooleanCellValue()){
                            toret += "true\t";
                        }else{
                            toret += "false\t"; 
                        }
                        break;
                    default:
                        toret += "\t";
                }
            }    
            return toret;
		}else return null;
    }
}
