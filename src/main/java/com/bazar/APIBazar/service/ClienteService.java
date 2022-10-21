
package com.bazar.APIBazar.service;

import com.bazar.APIBazar.model.Cliente;
import com.bazar.APIBazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
  private  IClienteRepository clienteRepo;

    @Override
    public String saveCliente(Cliente cliente) {
   clienteRepo.save(cliente);
   return "Cliente creado de forma correcta";
    }

    @Override
    public List<Cliente> getListClientes() {
   return clienteRepo.findAll();
    }

    @Override
    public Cliente getClienteById(Long id_cliente) {
    return clienteRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public String deleteClienteById(Long id_cliente) {
    clienteRepo.deleteById(id_cliente);
    return "cliente eliminado";
    }

    @Override
    public void updateClienteByCode(Long id_cliente,  String nuevo_nombre, String nuevo_apellido, String nuevo_dni) {
    
        Cliente cliente = this.getClienteById(id_cliente);
        
        
        cliente.setNombre(nuevo_nombre);
        cliente.setApellido(nuevo_apellido);
        cliente.setDni(nuevo_dni);
        
        this.saveCliente(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
    this.saveCliente(cliente);
    }

    
    
}
