package gt.com.mundopc;

public class DispositivoEntrada {
    private String tipoEntrada;
    private String entrada;

    public DispositivoEntrada(String tipoEntrada, String entrada) {
        this.tipoEntrada = tipoEntrada;
        this.entrada = entrada;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "DispositivoEntrada{" +
                "tipoEntrada='" + tipoEntrada + '\'' +
                ", entrada='" + entrada + '\'' +
                '}';
    }
}
