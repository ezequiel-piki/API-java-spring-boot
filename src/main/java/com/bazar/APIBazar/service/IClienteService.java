
package com.bazar.APIBazar.service;

import com.bazar.APIBazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    //a. Métodos HTTP: GET, POST, DELETE, PUT
    //b. Endpoints: 

//Creación: localhost:8181/clientes/crear
public String saveCliente(Cliente cliente);
    
//Lista completa de clientes: localhost:8181/clientes
 public List<Cliente> getListClientes(); 
    
//Traer un cliente en particular: localhost:8181/clientes/{id_cliente}
public Cliente getClienteById(Long id_cliente);
    
//Eliminación: localhost:8181/clientes/eliminar/{id_cliente}
 public String deleteClienteById(Long id_cliente);    
    
//Edición: localhost:8181/clientes/editar/{id_cliente}
 public void updateClienteByCode(Long id_cliente, String nuevo_nombre, 
                                                                       String nuevo_apellido, String nuevo_dni);
 
 //Edición: localhost:8181/clientes/editar
  public void updateCliente(Cliente cliente);
}
