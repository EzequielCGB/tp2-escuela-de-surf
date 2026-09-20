public class Tabla {
    private int codigo;
    private double largo;
    private String estado;

    public Tabla(int codigo, double largo, String estado){
        this.codigo = codigo;
        setLargo(largo);
    }
    public int getCodigo(){
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
    public String descripcion() {
        return "Tabla Nro: " + codigo + " - Largo: " + largo + "m - Estado: " + estado;
    }
}
