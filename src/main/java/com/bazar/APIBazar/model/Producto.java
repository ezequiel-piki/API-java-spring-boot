
package com.bazar.APIBazar.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)         
    Long codigo_producto;
    
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    
   //@ManyToOne
    //@JoinColumn(name="codigo_venta")
    //@JsonIgnore
    //Venta venta;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
    
    
}
