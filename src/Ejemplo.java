import java.util.Scanner;

public class Ejemplo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Solicitar el número de puestos de control
        System.out.print("Ingrese el número de puestos de control: ");
        int numPuestosControl = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // 2. Solicitar el número de chapulines
        System.out.print("Ingrese el número de chapulines: ");
        int numChapulines = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Declarar vectores y matriz
        String[] puestosControl = new String[numPuestosControl];
        String[] chapulines = new String[numChapulines];
        int[][] tiempos = new int[numChapulines][numPuestosControl];

        // 4. Solicitar los nombres de los puestos de control
        for (int i = 0; i < numPuestosControl; i++) {
            System.out.print("Ingrese el nombre del puesto de control " + (i + 1) + ": ");
            puestosControl[i] = scanner.nextLine();
        }

        // 5. Solicitar los nombres de los chapulines
        for (int i = 0; i < numChapulines; i++) {
            System.out.print("Ingrese el nombre del chapulín " + (i + 1) + ": ");
            chapulines[i] = scanner.nextLine();
        }

        // 6. Iniciar el Rally
        for (int i = 0; i < numChapulines; i++) {
            for (int j = 0; j < numPuestosControl; j++) {
                System.out.println("Ingrese el tiempo en minutos para el chapulín " + chapulines[i] + " en el puesto de control " + puestosControl[j] + ":");
                tiempos[i][j] = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
            }
        }

        // 7. Calcular los tiempos finales y obtener el ganador
        int[] tiemposTotales = new int[numChapulines];
        for (int i = 0; i < numChapulines; i++) {
            for (int j = 0; j < numPuestosControl; j++) {
                tiemposTotales[i] += tiempos[i][j];
            }
        }

        int indiceGanador = 0;
        int tiempoMinimo = tiemposTotales[0];
        for (int i = 1; i < numChapulines; i++) {
            if (tiemposTotales[i] < tiempoMinimo) {
                tiempoMinimo = tiemposTotales[i];
                indiceGanador = i;
            }
        }

        // 8. Imprimir la salida a consola
        System.out.println("\nResultados del Rally de Chapulines:");
        System.out.println("Puesto    Chapulín    Tiempo Total");
        for (int i = 0; i < numChapulines; i++) {
            System.out.printf("%-10d%-12s%-10d\n", (i + 1), chapulines[i], tiemposTotales[i]);
        }
        System.out.println("\nEl ganador es: " + chapulines[indiceGanador] + " con un tiempo total de " + tiempoMinimo + " minutos.");
    }
}