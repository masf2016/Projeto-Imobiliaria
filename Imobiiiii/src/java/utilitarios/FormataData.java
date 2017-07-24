/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Mário
 */
public class FormataData {

    /**
     * @param args the command line arguments
     */
    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    // Formatação de texto
    SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoDate = new SimpleDateFormat("yyyy-MM-dd");

    public Date convertDataString(String strData) throws ParseException {
        java.sql.Date formatodate = new java.sql.Date(fmt.parse(strData).getTime());

        return formatodate;
    }

    public String convertDataDate(Date dtDate) throws ParseException {
        String strData = fmt.format(dtDate);

        return strData;
    }
}
