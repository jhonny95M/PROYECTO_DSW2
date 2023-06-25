package edu.cibertec.pe.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.cibertec.pe.entity.Cliente;

@Repository
public class ClienteRepository {
	
	private static List<Cliente> lista = new ArrayList<>();
	
	public List<Cliente> getAllClientes(){
		
		return lista;
	}
    
	public Optional<Cliente> getClienteById(int cod){
		
		return lista.stream().filter(c -> c.getCod() == cod).findFirst();
	} 
	
	public Cliente addCliente(Cliente obj) {
		lista.add(obj);
		return obj;
		
	}
	
	public Cliente UpdateCliente(Cliente obj) {
		getClienteById(obj.getCod()).ifPresent(clienteExistente ->{
			clienteExistente.setNom(obj.getNom());
			clienteExistente.setApleP(obj.getApleP());
			clienteExistente.setApleM(obj.getApleM());
			clienteExistente.setDirec(obj.getDirec());
			clienteExistente.setRubro(obj.getRubro());
			
		});
		return obj;
		
	}
	
	public void deleteCliente(int cod) {
		
		getClienteById(cod).ifPresent(c -> lista.remove(c));
	}
}
