package tarea1;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Tarea1 {
   
    public static void main(String[] args) {
        
    }
    
}
class OrdenCompra{
    LocalDateTime fecha=LocalDateTime.now();
    private String estado;
    public OrdenCompra(){
       estado="no pagado";
    }
    public float calcPrecioSinIVA(DetalleOrden cuant){
        float prize=cuant.calcPrecioSinIVA();
        float aux1=(prize*19)/100;
        float res=prize-aux1;
        return(res);
    }
    public float calcIVA(DetalleOrden cuant){
        float prize=cuant.calcIVA();
        float aux1=(prize*19)/100;
        float res=prize+aux1;
        return(res);
    }
    public float calcPrecio(DetalleOrden cuant){
        return(cuant.calcPrecio());
    }
    public float calcPeso(Articulo art,DetalleOrden cuant){
        return(cuant.calcPeso());
    }
    public String dar_Estado(String status){
        estado=status;
        return(estado);
    }
    public LocalDateTime dar_Fecha(){
        return(fecha);
    }
    
}
class DetalleOrden{
    private int cantidad;
    private float res;
    private Articulo art;
    ArrayList<Articulo> lista_compras = new ArrayList<Articulo>();
    public DetalleOrden(int cant){
        cantidad=cant;
        res=0;
    }
    public float calcPrecioSinIVA(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
            float prize=cantidad*art.DarPrecio();
            float aux=(prize*19)/100;
            res=prize-aux;
        }
        return(res);
    }
    public float calcIVA(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
            float prize=cantidad*art.DarPrecio();
            float aux=(prize*19)/100;
            res=prize+aux;
        }
        return(res);
    }
    public float calcPrecio(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
        }
        return(cantidad*art.DarPrecio());
    }
    public float calcPeso(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
        }
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
    private String nombre;
    LocalDateTime fecha=LocalDateTime.now();
    public DocTributario(Cliente persona,Direccion dir){
        nombre=persona.DarNombre();
        rut=persona.DarRut();
        direccion=dir.DarDireccion();
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
class Pago{
    private float monto;
    LocalDateTime fecha=LocalDateTime.now();
    public Pago(OrdenCompra total,DetalleOrden detail){
        monto=total.calcIVA(detail);
    }
    public float Pagar(){
        return monto;
    }
    public String update_status(OrdenCompra total){
        return total.dar_Estado("pagando");
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
     public String update_status(OrdenCompra total){
        return total.dar_Estado("pagado");
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String NumCuenta;
    public Transferencia(String bank,String account){
        banco=bank;
        NumCuenta=account;
    }
    public String update_status(OrdenCompra total){
        return total.dar_Estado("pagado");
    }
    
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(String type,String trans){
        tipo=type;
        numTransaccion=trans;
    }
    public String update_status(OrdenCompra total){
        return total.dar_Estado("pagado");
    }
    

    
}