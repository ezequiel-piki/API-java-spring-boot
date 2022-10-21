
package com.bazar.APIBazar.controller;

import com.bazar.APIBazar.model.Producto;
import com.bazar.APIBazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    IProductoService productoService;
    
    //Endpoints:
    
    //Creación: localhost:8181/productos/crear
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto){
         
        productoService.saveProducto(producto);
        
        return"producto creado con exito";
    }
    
    //Lista completa de productos: localhost:8181/productos
    @GetMapping("/productos")
    public List<Producto> getListProductos(){
    
        return productoService.getListProductos();
    
    }
    
    //Traer un producto en particular: localhost:8080/productos/{codigo_producto}
    @GetMapping("/productos/{codigo_producto}")
    public Producto getProductoByCode(@PathVariable Long codigo_producto){
    
        return productoService.getProductoByCode(codigo_producto);
    
    }
    
     //Eliminación: localhost:8181/productos/eliminar/{codigo_producto}
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProductoByCode(@PathVariable Long codigo_producto){
    
        productoService.deleteProductoByCode(codigo_producto);
        
        return "Producto eliminado";
    }
    
    //Edición: localhost:8080/productos/editar/{codigo_producto}
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto updateProductoByCode(@PathVariable Long codigo_producto, 
                                                                   @RequestParam(required = false, name="codigo") Long nuevoCodigoProducto,  
                                                                   @RequestParam(required = false, name="nombre") String nuevo_nombre,
                                                                   @RequestParam(required = false, name="marca") String nueva_marca,
                                                                   @RequestParam(required = false, name="costo")  Double nuevo_costo, 
                                                                   @RequestParam(required = false, name="cantidad") Double nueva_cantidad_disponible)
    {
        
        productoService.updateProductoByCode(codigo_producto, nuevoCodigoProducto, 
                                                                                  nuevo_nombre, nueva_marca, nuevo_costo, 
                                                                                  nueva_cantidad_disponible);
       
        Producto producto = productoService.getProductoByCode(codigo_producto);
        
       return producto;
    }
    
    //Edición2: localhost:8181/productos/editar
      @PutMapping("/productos/editar")
    public Producto updateCliente(@RequestBody Producto producto){
    
        productoService.updateProducto(producto);
    
        return productoService.getProductoByCode(producto.getCodigo_producto());
    }
    
    
     // localhost:8181/productos/falta_stock
    @GetMapping("/productos/falta_stock")
     public List<Producto> faltaStock() {
     return productoService.faltaStock();
     }
    
}
