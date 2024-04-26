package Utilities;

import java.util.concurrent.TimeUnit;

public class TiempoEspera {

    public static void esperar3seg() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("Error al introducir demora entre ataques: " + e.getMessage());
        }
    }

    public static void esperar2seg() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Error al introducir demora entre ataques: " + e.getMessage());
        }
    }

}
