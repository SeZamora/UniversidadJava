import caja.Caja ;
public class Main {

    public static void main(String[] args) {
        Caja caja1 = new Caja();
        caja1.profundo = 2.0;
        caja1.alto = 3.0;
        caja1.ancho = 4.0;

        var rcaja1 = caja1.volumne();
        System.out.println("caja 1 -> " + rcaja1);

        Caja caja2 = new Caja(2.0, 2.0, 2.0);

        var rcaja2 = caja2.volumne();
        System.out.println("caja 2 -> "+rcaja2);





    }
}
