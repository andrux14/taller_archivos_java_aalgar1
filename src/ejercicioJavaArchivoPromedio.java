import java.io.*;

public class ejercicioJavaArchivoPromedio {
    public static void main(String[] args) {

        String ruta = "D:/Fundamentos de Programacion/Documentos_Prueba/test2.txt";
        File file = new File(ruta);

        if (!file.exists()) {
            System.out.println("La ruta del archivo es incorrecta");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linea;
            int suma = 0;
            int i = 0;
            int maximo = Integer.MIN_VALUE;
            int minimo = Integer.MAX_VALUE;

            while ((linea = br.readLine()) != null) {

                linea = linea.trim();
                if (linea.chars().allMatch(Character::isDigit)) {
                    int numero = Integer.parseInt(linea);
                    suma += numero;
                    i++;
                    if (numero > maximo) {
                        maximo = numero;
                    }
                    if (numero < minimo) {
                        minimo = numero;
                    }
                }
            }

            if (i > 0) {

                double promedio = (double) suma / i;

                System.out.println("El promedio de notas es: " + promedio);
                System.out.println("La nota mayor es: " + maximo);
                System.out.println("La nota menor es: " + minimo);

            } else {
                System.out.println("El archivo no contiene información valida o está vacío");
            }
        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("El archivo no contiene datos numericos.");
        }
    }
}