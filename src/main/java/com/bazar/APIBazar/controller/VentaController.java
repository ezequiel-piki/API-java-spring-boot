
package com.bazar.APIBazar.controller;

import com.bazar.APIBazar.model.Cliente;
import com.bazar.APIBazar.model.Producto;
import com.bazar.APIBazar.model.Venta;
import com.bazar.APIBazar.model.VentaDTO;
import com.bazar.APIBazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VentaController {
    
    @Autowired
    IVentaService ventaService;
    
    //Creación: localhost:8181/ventas/crear
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta){
    ventaService.saveVenta(venta);
    return "Venta realizada";
    }
    
     //Lista completa de ventas: localhost:8181/ventas
    @GetMapping("/ventas")
    public List<Venta> getListVentas(){
    return ventaService.getListVentas();
    } 
    
    //Traer una venta en particular: localhost:8181/ventas/{codigo_venta}
    @GetMapping("/ventas/{codigo_venta}")   
    public Venta getVentaByCode(@PathVariable Long codigo_venta){
    return ventaService.getVentaByCode(codigo_venta);
    }
    
     //Eliminación: localhost:8181/ventas/eliminar/{codigo_venta}
   @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVentaByCode(@PathVariable Long codigo_venta){
    return ventaService.deleteVentaByCode(codigo_venta);
    }
    
    //Edición: localhost:8181/ventas/editar/{codigo_venta}
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta updateVentaByCode(@PathVariable Long codigo_venta,  
                                                             @RequestParam(required = false, name="fecha")  LocalDate nueva_fecha_venta, 
                                                             @RequestParam(required = false, name="total")   Double nuevo_total, 
                                                              @RequestParam(required = false, name="productos")  List<Producto> nuevos_productos, 
                                                               @RequestParam(required = false, name="cliente") Cliente nuevoCliente){
    ventaService.updateVentaByCode(codigo_venta, nueva_fecha_venta, nuevo_total, nuevos_productos, nuevoCliente);
    
    Venta venta = ventaService.getVentaByCode(codigo_venta);
    return venta;
    }
    
     //Edición2: localhost:8181/ventas/editar
      @PutMapping("/ventas/editar")
    public Venta updateVenta(@RequestBody Venta venta){
    
        ventaService.updateVenta(venta);
    
        return ventaService.getVentaByCode(venta.getCodigo_venta());
    }
   
    // Obtener la lista de productos de una determinada venta: localhost:8181/ventas/productos/{codigo_venta}
    @GetMapping("/ventas/productos/{codigo_venta}")
   public List<Producto> getListaProductosDeVenta(@PathVariable Long codigo_venta){
    return ventaService.getListaProductosDeVenta(codigo_venta);
    }
   
      //Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
       @GetMapping("/ventas/fecha/{fecha_venta}")
       public String getRecaudacionDelDiaVentasTotales(@PathVariable("fecha_venta")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_venta) {
       return ventaService.getRecaudacionDelDiaVentasTotales(fecha_venta);
       }
       
      // localhost:8181/ventas/mayor_venta
      //Tener en cuenta patrón DTO para este escenario
      @GetMapping("/ventas/mayor_venta")
      public VentaDTO mayorVenta(){
      return ventaService.mayorVenta();
      }
}
