package tarea1;

import java.util.ArrayList;

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