package whereit.com.passei.util;

import java.util.GregorianCalendar;

/**
 * Created by Desenvolvimento on 08/02/17.
 */

public class DateUtil {

    public static String getToday(){
        GregorianCalendar gc = new GregorianCalendar();
        return "";
    }


    private String getWeekDay(int day){
        String week;
        switch (day) {
            case 1:
                week =  "Domingo";
                break;
            case 2:
                week =  "Segunda-Feira";
                break;
            case 3:
                week =  "Terça-Feira";
                break;
            case 4:
                week =  "Quarta-Feira";
                break;
            case 5:
                week =  "Quinta-Feira";
                break;
            case 6:
                week =  "Sexta-Feira";
                break;
            case 7:
                week =  "Sábado";
                break;
            default:
                week =  "Domigno";

        }
        return week;
    }

}
