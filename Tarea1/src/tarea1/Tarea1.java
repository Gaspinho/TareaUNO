package tarea1;

import java.time.LocalDateTime;

public class Tarea1 {
   
    public static void main(String[] args) {
        
    }
    
}
class OrdenCompra{
    LocalDateTime fecha=LocalDateTime.now();
    private String estado;
    Articulo aux;
    public OrdenCompra(String status){
        estado=status;
    }
    public float calcPrecioSinIVA(DetalleOrden cuant){
        float prize=cuant.DarCant()*aux.DarPrecio();
        float aux1=(prize*19)/100;
        float res=prize-aux1;
        return(res);
    }
    public float calcIVA(DetalleOrden cuant){
        float prize=cuant.DarCant()*aux.DarPrecio();
        float aux1=(prize*19)/100;
        float res=prize+aux1;
        return(res);
    }
    public float calcPrecio(DetalleOrden cuant){
        return(cuant.DarCant()*aux.DarPrecio());
    }
    public float calcPeso(Articulo art,DetalleOrden cuant){
        return(cuant.DarCant()*aux.DarPeso());
    }
    
}
class DetalleOrden{
    private int cantidad;
    private Articulo art;
    public DetalleOrden(int cant){
        cantidad=cant;
    }
    public float calcPrecioSinIVA(){
        float prize=cantidad*art.DarPrecio();
        float aux=(prize*19)/100;
        float res=prize-aux;
        return(res);
    }
    public float calcIVA(){
        float prize=cantidad*art.DarPrecio();
        float aux=(prize*19)/100;
        float res=prize+aux;
        return(res);
    }
    public float calcPrecio(){
        return(cantidad*art.DarPrecio());
    }
    public float calcPeso(){
        return(cantidad*art.DarPeso());
    }
    public float DarCant(){
        return(cantidad);
    }
    
}
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
class Cliente{
    private String nombre;
    private String rut;
    public Cliente(String a,String b){
        nombre=a;
        rut=b;
    }
    public String DarNombre(){
        return nombre;
    }
    public String DarRut(){
        return rut;
    }
    
}
class Direccion{
    private String direccion;
    public Direccion(String d){
        direccion=d;
    }
    public String DarDireccion(){
        return direccion;
    }
    
}
class DocTributario{
    private String direccion;
    private String rut;
    LocalDateTime fecha=LocalDateTime.now();
    public DocTributario(Cliente persona,Direccion dir){
        rut=persona.DarRut();
        direccion=dir.DarDireccion();
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
class Pago{
    private float monto;
    LocalDateTime fecha=LocalDateTime.now();
    public Pago(OrdenCompra total,DetalleOrden detail){
        monto=total.calcIVA(detail);
    }
    public float Pagar(){
        return monto;
    }
    
}
class Efectivo extends Pago{
    public Efectivo(OrdenCompra total,DetalleOrden detail){
        super(total,detail);
    }
    public float calcDevolucion(float efective){
        float vuelto=efective-super.Pagar();
        return(vuelto);
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String NumCuenta;
    public Transferencia(){
        
    }
    
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(){
        
    }

    
}