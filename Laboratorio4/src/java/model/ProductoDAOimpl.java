/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galla
 */
public class ProductoDAOimpl implements ProductoDAO{
/* creamos la clase y le implementamos todos los
    metodos del ProductoDAO
    */
    
    static List<Producto> dbProductos = new ArrayList<>();
    /* ya conocemos lo que es un array list, le ponemos
    static para que no se creen 1000 arraylist y solo sea
    una unica*/
    
    
    @Override
    public Producto save(Producto producto) {
        dbProductos.add(producto); /* lo mete en la base de datos*/
        return producto;
    }

    @Override
    public List<Producto> listar() {
        return dbProductos; /*directamente te muestra todo */
    }

    @Override
    public Producto buscar(int clave) {
        /* por cada producto en la base de datos*/
        for (Producto dbProducto : dbProductos){
            if(dbProducto.getClave() == clave){
                return new Producto(clave, dbProducto.getNombre(), dbProducto.getPrecio(), dbProducto.getCantidad());
            }
        }
        return null; /*PARA EVITAR ERRORES NOMAS */
    }
    
    
    
}
