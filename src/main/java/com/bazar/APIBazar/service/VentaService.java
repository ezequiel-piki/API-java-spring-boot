
package com.bazar.APIBazar.service;

import com.bazar.APIBazar.model.Cliente;
import com.bazar.APIBazar.model.Producto;
import com.bazar.APIBazar.model.Venta;
import com.bazar.APIBazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
   private IVentaRepository ventaRepo;

    @Override
    public Venta saveVenta(Venta venta) {
    return  ventaRepo.save(venta);
    
    }

    @Override
    public List<Venta> getListVentas() {
    return ventaRepo.findAll();
    }

    @Override
    public Venta getVentaByCode(Long codigo_venta) {
    return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public String deleteVentaByCode(Long codigo_venta) {
    
        ventaRepo.deleteById(codigo_venta);
        
        return "venta eliminada";
    }

    @Override
    public void updateVentaByCode(Long codigo_venta,  LocalDate nueva_fecha_venta, Double nuevo_total, List<Producto> nuevos_productos, Cliente nuevoCliente) {
    
         //ocupo this porque llamo al mismo metdo findVentaByCode de esta clase   
        Venta venta = this.getVentaByCode(codigo_venta);
        
        venta.setFecha_venta(nueva_fecha_venta);
        venta.setTotal(nuevo_total);
        venta.setProductos(nuevos_productos);
        venta.setUnCliente(nuevoCliente);
        
        this.saveVenta(venta);
    }

    
    @Override
    public void updateVenta(Venta venta) {
    this.saveVenta(venta);
    }

    @Override
    public List<Producto> getListaProductosDeVenta(Long codigo_venta) {
    Venta venta = this.getVentaByCode(codigo_venta);
    return venta.getProductos();
    }

    @Override
    public String getRecaudacionDelDiaVentasTotales(LocalDate fecha_venta) {
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String fechaString = fecha_venta.format(formatter);
        
        List<Venta> ventas = this.getListVentas();
     
        List<Venta> ventasDelDia = new ArrayList<Venta>();
        
        Double recaudacion = 0.0;
        
        
        
        for (Venta venta : ventas) {
             
            String fecha =   venta.getFecha_venta().format(formatter);
            
            if( fechaString.equals(fecha)){
            
                ventasDelDia.add(venta);
            
                recaudacion = recaudacion +  venta.getTotal();
            }
        }
         
        return "La recaudacion del dia es de "+ recaudacion +" pesos. " + "Cantidad total de ventas en el dia de la fecha: "+ ventasDelDia.size()+ ". Fecha: "+ fechaString;
     
    }
    
    
}
