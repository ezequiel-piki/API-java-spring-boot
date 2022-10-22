
package com.bazar.APIBazar.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class VentaDTO {
   //  codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
   //apellido del cliente de la venta con el monto más alto de todas. 
    private Long codigo_venta;
    private Double total; 
    private List<Producto> listaDeProductos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaDTO(Long codigo_venta, Double total, List<Producto> listaDeProductos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.listaDeProductos = listaDeProductos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }

    public VentaDTO() {
    }
    
    
}
