
package com.bazar.APIBazar.service;

import com.bazar.APIBazar.model.Producto;
import com.bazar.APIBazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
  private  IProductoRepository productoRepo;

    @Override
    public String saveProducto(Producto producto) {
     
        productoRepo.save(producto);
    
        return "Producto creado con exito";
    }

    @Override
    public List<Producto> getListProductos() {
     return productoRepo.findAll();
    }

    @Override
    public Producto getProductoByCode(Long codigo_producto) {
    
        return productoRepo.findById(codigo_producto).orElse(null);
    
    }

    @Override
    public String deleteProductoByCode(Long codigo_producto) {
    
        productoRepo.deleteById(codigo_producto);
        
        return " producto eliminado";
    }

    @Override
    public void updateProductoByCode(Long codigo_producto, Long nuevoCodigoProducto, 
                                                                       String nuevo_nombre,  String nueva_marca, 
                                                                       Double nuevo_costo, Double nueva_cantidad_disponible ) {
        
        //ocupo this porque llamo al mismo metdo findProducto de esta clase   
        Producto producto = this.getProductoByCode(codigo_producto);
        
        producto.setCodigo_producto(nuevoCodigoProducto);
        producto.setNombre(nuevo_nombre);
        producto.setMarca(nueva_marca);
        producto.setCosto(nuevo_costo);
        producto.setCantidad_disponible(nueva_cantidad_disponible);
    
        //ocupo this porque ocupo el mismo metodo saveProducto de esta clase para guardar los cambios
        this.saveProducto(producto);
       
        
    }

    @Override
    public List<Producto> faltaStock() {
    
        List<Producto> productos = productoRepo.findAll();
        
        List<Producto> stockMenorQue5 = new ArrayList<Producto>();
        
        for (Producto producto :  productos) {
            
            if(producto.getCantidad_disponible() < 5){
            stockMenorQue5.add(producto);
            }
            
        }
        
        return stockMenorQue5;
    }

    @Override
    public void updateProducto(Producto producto) {
    this.saveProducto(producto);
    }
    
}
