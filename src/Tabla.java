public class Tabla {
    private int codigo;
    private double largo;
    private String estado;

    public Tabla(int codigo, double largo, String estado){
        this.codigo = codigo;
        this.largo=largo;
        this.estado=estado;
    }
    public void cambiarEstado(String nuevoEstado){
        this.estado=nuevoEstado;
    }
    public void descripcion() {
        System.out.println("Tabla Nro: " + codigo + " - Largo: " + largo + "m - Estado: " + estado);
    }
}
