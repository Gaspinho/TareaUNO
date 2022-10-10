package tarea1;

class Cliente{
    private String nombre;
    private String rut;
    private String direccion;
    public Cliente(String a,String b,String c){
        nombre=a;
        rut=b;
        direccion=c;
    }
    public String DarNombre(){
        return nombre;
    }
    public String DarRut(){
        return rut;
    }
    public String DarDireccion(){
        return direccion;
    }
}