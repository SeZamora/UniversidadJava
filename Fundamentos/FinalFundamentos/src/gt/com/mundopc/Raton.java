package gt.com.mundopc;

public class Raton extends DispositivoEntrada{
    private int idRaton;
    private static int contadorRatones;

    public Raton(String tipoEntrada, String entrada) {
        super(tipoEntrada, entrada);
        this.idRaton = ++contadorRatones;
    }



    @Override
    public String toString() {
        return "Raton{" +
                "idRaton=" + idRaton +
                "} " + super.toString();
    }
}
