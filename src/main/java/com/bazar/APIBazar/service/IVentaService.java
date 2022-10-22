
package com.bazar.APIBazar.service;

import com.bazar.APIBazar.model.Cliente;
import com.bazar.APIBazar.model.Producto;
import com.bazar.APIBazar.model.Venta;
import com.bazar.APIBazar.model.VentaDTO;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
     //Métodos HTTP: GET, POST, DELETE, PUT
    //Endpoints:
    
    //Creación: localhost:8181/ventas/crear
    public Venta saveVenta(Venta venta);
    
    //Lista completa de ventas: localhost:8181/productos
    public List<Venta> getListVentas(); 
    
    //Traer una venta en particular: localhost:8181/ventas/{codigo_venta}
    public Venta getVentaByCode(Long codigo_venta);
    
    //Eliminación: localhost:8181/ventas/eliminar/{codigo_venta}
    public String deleteVentaByCode(Long codigo_venta);
    
    //Edición: localhost:8181/ventas/editar/{codigo_venta}
    public void updateVentaByCode(Long codigo_venta,  LocalDate nueva_fecha_venta, Double nuevo_total, List<Producto> nuevos_productos, Cliente nuevoCliente);

    //Edición: localhost:8181/ventas/editar
   public void updateVenta(Venta venta);   
   
    
   //localhost:8181/ventas/productos/{codigo_venta}
   public List<Producto> getListaProductosDeVenta(Long codigo_venta);
   
   //Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
   public String getRecaudacionDelDiaVentasTotales(LocalDate fecha_venta);

    // localhost:8181/ventas/mayor_venta
      //Tener en cuenta patrón DTO para este escenario
    public VentaDTO mayorVenta();
}
