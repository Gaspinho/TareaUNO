package tarea1;

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    public Articulo(float kg,String name,String description,float price){
        peso=kg;
        nombre=name;
        descripcion=description;
        precio=price;
    }
    public float DarPeso(){
        return peso;
    }
    public String DarNombre(){
        return nombre;
    }
    public String DarDescrip(){
        return descripcion;
    }
    public float DarPrecio(){
        return precio;
    }
}
