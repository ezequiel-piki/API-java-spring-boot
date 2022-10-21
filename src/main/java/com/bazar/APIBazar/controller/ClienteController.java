
package com.bazar.APIBazar.controller;

import com.bazar.APIBazar.model.Cliente;
import com.bazar.APIBazar.service.IClienteService;
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
public class ClienteController {

@Autowired    
    IClienteService clienteService;

//Creación: localhost:8181/cliente/crear
    @PostMapping("/cliente/crear")
    public String saveCliente(@RequestBody Cliente cliente){
         
        return clienteService.saveCliente(cliente);
      
    }
    
    //Lista completa de clientes: localhost:8181/clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
    return clienteService.getListClientes();
    }
    
    //Traer un cliente en particular: localhost:8181/clientes/{id_cliente}
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getClienteById(@PathVariable Long id_cliente){
    return clienteService.getClienteById(id_cliente);
    }
    
    //Eliminación: localhost:8181/clientes/eliminar/{id_cliente}
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteClienteById(@PathVariable Long id_cliente){
    return clienteService.deleteClienteById(id_cliente);
    }
    
    //Edición: localhost:8181/clientes/editar/{id_cliente}
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente updateClienteByCode(@PathVariable Long id_cliente, 
                                                                   @RequestParam(required=false, name="nombre" ) String nuevo_nombre, 
                                                                   @RequestParam(required=false, name="apellido" )   String nuevo_apellido, 
                                                                   @RequestParam(required=false, name="dni" )   String nuevo_dni){
    
        clienteService.updateClienteByCode(id_cliente, nuevo_nombre, nuevo_apellido, nuevo_dni);
        
        Cliente cliente = clienteService.getClienteById(id_cliente);
        
        return cliente;
    }
    
      //Edición2: localhost:8181/clientes/editar
      @PutMapping("/clientes/editar")
    public Cliente updateCliente(@RequestBody Cliente cliente){
    
        clienteService.updateCliente(cliente);
    
        return clienteService.getClienteById(cliente.getId_cliente());
    }
    
}

