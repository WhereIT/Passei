package whereit.com.passei.util;

import java.util.GregorianCalendar;

/**
 * Created by Desenvolvimento on 08/02/17.
 */

public class DateUtil {

    public String getToday(){
        GregorianCalendar gc = new GregorianCalendar();
        int weekDay = gc.get(GregorianCalendar.DAY_OF_WEEK);
        String week = getWeekDay(weekDay);
        int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
        int monthNumber = gc.get(GregorianCalendar.MONTH);
        String month = getMonth(monthNumber);
        int year = gc.get(GregorianCalendar.YEAR);
        String today = week + ", " + String.valueOf(day) + " de " + month + " de " + String.valueOf(year);
        return today;
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

    private String getMonth(int monthN){
        String month;
        switch (monthN) {
            case 1:
                month =  "Janeiro";
                break;
            case 2:
                month =  "Fevereiro";
                break;
            case 3:
                month =  "Março";
                break;
            case 4:
                month =  "Abril";
                break;
            case 5:
                month =  "Maio";
                break;
            case 6:
                month =  "Junho";
                break;
            case 7:
                month =  "Julho";
                break;
            case 8:
                month =  "Agosto";
                break;
            case 9:
                month =  "Setembro";
                break;
            case 10:
                month =  "Outubro";
                break;
            case 11:
                month =  "Novembro";
                break;
            case 12:
                month =  "Dezembro";
                break;
            default:
                month =  "Janeiro";

        }
        return month;
    }

}
