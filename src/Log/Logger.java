package Log;

import java.io.*;

public class Logger {

    private static final String LOG_FILE = "log_partidas.txt";

    public static String Log(String mensaje) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(mensaje);
            writer.newLine();
            return mensaje;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de logs: " + e.getMessage() + "\n");
        }
        return null;
    }

    public static void leerLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("log_partidas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de logs: " + e.getMessage()+ "\n");
        }
    }

    public static void borrarLogs() {
        try {
            if (new File("log_partidas.txt").delete()) {
                System.out.println("Archivo de logs borrado con exito.\n");
            } else {
                System.out.println("No se encontró archivo de logs para borrar.\n");
            }
        } catch (SecurityException e) {
            System.err.println("No tienes permisos para borrar el archivo de logs: \n" + e.getMessage());
        }
    }

}
