package agentes;

import java.io.Serializable;

public class Ecuaciones implements Serializable {

    private String ecuacion1, ecuacion2, ecuacion3;

    public String getEcuacion1() {
        return ecuacion1;
    }

    public void setEcuacion1(String ecuacion1) {
        this.ecuacion1 = ecuacion1;
    }

    public String getEcuacion2() {
        return ecuacion2;
    }

    public void setEcuacion2(String ecuacion2) {
        this.ecuacion2 = ecuacion2;
    }

    public String getEcuacion3() {
        return ecuacion3;
    }

    public void setEcuacion3(String ecuacion3) {
        this.ecuacion3 = ecuacion3;
    }

    public Ecuaciones(String ecuacion1, String ecuacion2, String ecuacion3) {
        this.ecuacion1 = ecuacion1;
        this.ecuacion2 = ecuacion2;
        this.ecuacion3 = ecuacion3;
    }

}
