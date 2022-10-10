package tarea1;

import java.time.LocalDateTime;

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