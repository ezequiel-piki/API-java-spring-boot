
package com.bazar.APIBazar.service;

import com.bazar.APIBazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    //Métodos HTTP: GET, POST, DELETE, PUT
    //Endpoints:
    
    //Creación: localhost:8181/productos/crear
    public String saveProducto(Producto producto);
    
    //Lista completa de productos: localhost:8181/productos
    public List<Producto> getListProductos(); 
    
    //Traer un producto en particular: localhost:8181/productos/{codigo_producto}
    public Producto getProductoByCode(Long codigo_producto);
    
    //Eliminación: localhost:8181/productos/eliminar/{codigo_producto}
    public String deleteProductoByCode(Long codigo_producto);
    
    //Edición: localhost:8181/productos/editar/{codigo_producto}
    public void updateProductoByCode(Long codigo_producto, Long nuevoCodigoProducto,  String nuevo_nombre, 
                                                                       String nueva_marca, Double nuevo_costo, Double nueva_cantidad_disponible);
     
   //Edición: localhost:8181/productos/editar
   public void updateProducto(Producto producto);   

// localhost:8080/productos/falta_stock
    public List<Producto> faltaStock();
}
