package gt.com.mundopc;

public class Orden {
    private int idOrden;
    private Computadora computadoras[];
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private static final int maxComputadoras = 10;

    public Orden(){
        this.idOrden = ++contadorOrdenes;
        this.computadoras = new Computadora[Orden.maxComputadoras];
    }
    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadoras < Orden.maxComputadoras){
            this.computadoras[this.contadorComputadoras] = computadora;
            ++this.contadorComputadoras;
        }
    }
    public void mostrarOrden(){
        System.out.println("Orden #:" + this.idOrden);
        System.out.println("Computadoras de la orden #:" + this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i]);
        }
    }

}
