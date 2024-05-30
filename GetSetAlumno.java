

public class GetSetAlumno {
    private int clave = 0;
    private int edad = 0;
    private int clavePrs = 0;
    private String nombre = "";
    private String genero = "";

    GetSetAlumno() {
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getClave() {
        return this.clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setClavePrs(int clavePrs) {
        this.clavePrs = clavePrs;
    }

    public int getClavePrs() {
        return this.clavePrs;
    }
}
