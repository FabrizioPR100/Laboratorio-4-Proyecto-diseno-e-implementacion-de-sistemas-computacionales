/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author galla
 */
public interface ProductoDAO {
    
    Producto save(Producto producto);
    /* metodo save recibe el objeto producto
    y devuelve el tipo de dato producto*/
    
    List<Producto> listar();
    /* no recibe nada pero devuelve la lista de productos */
    
    Producto buscar(int clave);
    /* recibe un entero y devuelve un producto*/
    
    
}
