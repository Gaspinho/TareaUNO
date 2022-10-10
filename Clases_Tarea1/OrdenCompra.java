package tarea1;

import java.time.LocalDateTime;

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