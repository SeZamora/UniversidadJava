package caja;

public class Caja {

    public Double ancho;
    public Double alto;
    public Double profundo;

    public Caja(){
        System.out.println("Se creo el constructor vacio");
    }
    public Caja(Double ancho, Double alto, Double profundo){
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
    }

    public Double volumne(){
        Double resultado;
        resultado = this.alto * this.ancho * this.profundo;
        return  resultado;
    }

}
