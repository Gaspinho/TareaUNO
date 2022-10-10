package tarea1;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Tarea1 {
   
    public static void main(String[] args) {
        Cliente clit=new Cliente("gaspar","21.135.714-2","Concepcion");
        Articulo arti=new Articulo(1,"oso","felpa",100);
        DetalleOrden ord=new DetalleOrden(2,arti);
        ord.añadir(1,arti);
        OrdenCompra prueba=new OrdenCompra(ord,clit);
        String s=prueba.dar_Estado();
        float value=prueba.calcPrecioIVA();
        System.out.println(s);
        System.out.println(value);
        
        
    }
    
}
class OrdenCompra{
    LocalDateTime fecha=LocalDateTime.now();
    public String estado;
    private DetalleOrden help;
    public OrdenCompra(DetalleOrden cuant,Cliente persona){
       help=cuant;
    }
    public float calcPrecioSinIVA(){
        return(help.calcPrecioSinIVA());
    }
    public float calcIVA(){
        return(help.calcIVA());
    }
    public float calcPrecio(){
        return(help.calcPrecio());
    }
    public float calcPeso(){
        return(help.calcPeso());
    }
    public String dar_Estado(){
        if(estado==null){
            estado="no pagado";
        }else{
            
        }
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
    public DetalleOrden(int cant,Articulo object){
        for(int i=0;i<cant;i++){
            lista_compras.add(i,object);
        }
        cantidad=cant;
        res=0;
    }
    public void añadir(int x,Articulo sujeto){
        for(int i=cantidad;i<x+cantidad;i++){
            lista_compras.add(sujeto);
        }
        cantidad=x+cantidad;
    }
    public float calcPrecioSinIVA(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
            float num_actual=art.DarPrecio();
            float aux=(num_actual*19)/100;
            float precio_objetoSiniva=num_actual-aux;
            res=res+precio_objetoSiniva;
        }
        return(res);
    }
    public float calcIVA(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
            float num_actual=art.DarPrecio();
            float aux=(num_actual*19)/100;
            float precio_objetoSiniva=num_actual+aux;
            res=res+precio_objetoSiniva;
        }
        return(res);
    }
    public float calcPrecio(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
            float num_actual=art.DarPrecio();
            res=res+num_actual;
        }
        return(res);
    }
    public float calcPeso(){
        for(int i=0;i<lista_compras.size();i++){
            art=lista_compras.get(i);
            float num_actual=art.DarPrecio();
            res=res+num_actual;
        }
        return(res);
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
class Pago{
    private float monto;
    public OrdenCompra auxi2;
    LocalDateTime fecha=LocalDateTime.now();
    public Pago(OrdenCompra total){
        monto=total.calcIVA();
        auxi2=total;
        total.estado="pagando";
    }
    public float Pagar(){
        return monto;
    }
    
}
class Efectivo extends Pago{
    public Efectivo(OrdenCompra total){
        super(total);
        auxi2=total;
    }
    public float calcDevolucion(float efective){
        float vuelto=efective-super.Pagar();
        auxi2.estado="pagado";
        return(vuelto);
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String NumCuenta;
    public Transferencia(OrdenCompra total){
       super(total);
    }
    public void pagar(String a,String b){
        banco=a;
        NumCuenta=b;
        auxi2.estado="pagado";
    }
    
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(OrdenCompra total){
        super(total);
    }
    public void pagar(String a,String b){
        tipo=a;
        numTransaccion=b;
        auxi2.estado="pagado";
    }
    
}