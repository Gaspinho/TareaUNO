package tarea1;

import java.time.LocalDateTime;

class DocTributario{
    private String direccion;
    private String rut;
    private String nombre;
    LocalDateTime fecha=LocalDateTime.now();
    public DocTributario(Cliente persona){
        nombre=persona.DarNombre();
        rut=persona.DarRut();
        direccion=persona.DarDireccion();
    }
    public String datitos(){
        return(nombre+rut+direccion);
    }
    
}
class Boleta extends DocTributario{
    public Boleta(){
        
    }
    
} 
class Factura extends DocTributario{
    public Factura(){
        
    }
    
}