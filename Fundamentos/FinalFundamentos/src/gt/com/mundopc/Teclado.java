package gt.com.mundopc;

public class Teclado extends DispositivoEntrada{
    private int idTeclado;
    private static int contadorTeclados;

    public Teclado(String tipoEntrada, String entrada) {
        super(tipoEntrada, entrada);
        this.idTeclado = ++contadorTeclados;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "idTeclado=" + idTeclado +
                "} " + super.toString();
    }
}
