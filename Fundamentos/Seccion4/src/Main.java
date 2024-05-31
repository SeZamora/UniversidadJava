import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitamos al usuario que proporcione el nombre del libro
        System.out.println("Proporciona el nombre:");
        String nombre = scanner.nextLine();

        // Solicitamos al usuario que proporcione el id del libro
        System.out.println("Proporciona el id:");
        int id = scanner.nextInt();

        // Solicitamos al usuario que proporcione el precio del libro
        System.out.println("Proporciona el precio:");
        double precio = scanner.nextDouble();

        // Solicitamos al usuario que proporcione si el envío es gratuito o no
        System.out.println("Proporciona el envío gratuito (true/false):");
        boolean envioGratuito = scanner.nextBoolean();

        // Mostramos la información del libro en el formato especificado
        System.out.println(nombre + " #" + id);
        System.out.println("Precio: $" + String.format("%.2f", precio));
        System.out.println("Envío Gratuito: " + envioGratuito);

        // Cerramos el objeto Scanner para liberar recursos
        scanner.close();
    }
}
