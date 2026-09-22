public class Tabla {
    private String codigo;
    private double largo;
    private String estado;

    public Tabla(String codigo, double largo, String estado){
        this.codigo = codigo;
        setLargo(largo);
        this.estado=estado;
    }
    //Si no le ingresan un estado la asume como disponible.
    public Tabla(String codigo, double largo){
        this(codigo, largo, "disponible");
    }
    public String getCodigo(){
        return codigo;
    }
    public double getLargo(){
        return largo;
    }
    public void setLargo(double largo){
        if(largo>= 5 && largo <= 10){
            this.largo = largo;
        }else{
            System.out.println("Error: El largo de la tabla debe estar entre 5 y 10 pies");
        }
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void cambiarEstado(String nuevoEstado){
        this.estado = nuevoEstado;
    }
    public String descripcion() {
        return "Tabla Nro: " + codigo + " - Largo: " + largo + "m - Estado: " + estado;
    }
}
