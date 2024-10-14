import java.io.Serializable;

public class Entrada implements Serializable {
    
    private String sensor1, sensor2, sensor6, sensor4, sensor5;
    private int sensor3;
    
    public Entrada(String sensor1, String sensor2, String sensor6, String sensor4, String sensor5, int sensor3) {
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor6 = sensor6;
        this.sensor4 = sensor4;
        this.sensor5 = sensor5;
        this.sensor3 = sensor3;
    }

    public String getSensor1() {
        return sensor1;
    }

    public void setSensor1(String sensor1) {
        this.sensor1 = sensor1;
    }

    public String getSensor2() {
        return sensor2;
    }

    public void setSensor2(String sensor2) {
        this.sensor2 = sensor2;
    }

    public String getSensor6() {
        return sensor6;
    }

    public void setSensor6(String sensor6) {
        this.sensor6 = sensor6;
    }

    public String getSensor4() {
        return sensor4;
    }

    public void setSensor4(String sensor4) {
        this.sensor4 = sensor4;
    }

    public String getSensor5() {
        return sensor5;
    }

    public void setSensor5(String sensor5) {
        this.sensor5 = sensor5;
    }

    public int getSensor3() {
        return sensor3;
    }

    public void setSensor3(int sensor3) {
        this.sensor3 = sensor3;
    }

    @Override
    public String toString() {
        return "Entrada{" + "sensor1=" + sensor1 + ", sensor2=" + sensor2 + ", sensor6=" + sensor6 + ", sensor4=" + sensor4 + ", sensor5=" + sensor5 + ", sensor3=" + sensor3 + '}';
    }
}
