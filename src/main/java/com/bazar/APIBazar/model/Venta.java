package com.bazar.APIBazar.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
@Entity
public class Venta {
    
    @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
    private Long codigo_venta;
    
    private LocalDate fecha_venta;
    private Double total;
    
    @OneToMany
    private List<Producto> productos;
    
    @OneToOne
    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> productos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.productos = productos;
        this.unCliente = unCliente;
    }
    
    
}
