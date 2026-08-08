package Laboratorio1.reto7;

public class Jugador {

    public enum Estado {
        ACTIVO, ELIMINADO, GANADOR
    }

    private int numero;
    private String nombre;
    private long deuda;
    private long premio;
    private Estado estado;

    public Jugador(int numero, String nombre, long deuda) {
        this.numero = numero;
        this.nombre = nombre;
        this.deuda = deuda;
        this.premio = 0;
        this.estado = Estado.ACTIVO;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public long getDeuda() {
        return deuda;
    }

    public long getPremio() {
        return premio;
    }

    public void setPremio(long premio) {
        this.premio = premio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return numero + " - " + nombre;
    }
}