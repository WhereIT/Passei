package whereit.com.passei.model;



/**
 * Created by leani on 17/02/2017.
 */

public class Aulas {


    private Materia materia;
    private int aulas;
    private String horaI;
    private String horaF;
    private String horasRestantes;


    public String getHorasRestantes() {
        return horasRestantes;
    }

    public void setHorasRestantes(String horasRestantes) {
        this.horasRestantes = horasRestantes;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getAulas() {
        return aulas;
    }

    public void setAulas(int aulas) {
        this.aulas = aulas;
    }

    public String getHoraI() {
        return horaI;
    }

    public void setHoraI(String horaI) {
        this.horaI = horaI;
    }

    public String getHoraF() {
        return horaF;
    }

    public void setHoraF(String horaF) {
        this.horaF = horaF;
    }



}
