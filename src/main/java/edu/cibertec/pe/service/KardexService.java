package edu.cibertec.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.pe.dto.KardexDto;
import edu.cibertec.pe.repository.KardexRepository;

@Service
public class KardexService {
	@Autowired
	KardexRepository repository;

	public List<KardexDto> getAll() {
		return repository.findByKardexActivo();
	}

	public List<KardexDto> getAllByProducto(long id) {
		List<KardexDto> kardexs = repository.findByKardexByProducto(id);
		double stock = kardexs.get(0).getCantidad();
		int signo = 1;
		for (int i = 0; i < kardexs.size(); i++) {
			kardexs.get(i).setStock(stock);
			if (i + 1 < kardexs.size()) {
				signo = 1;
				signo = kardexs.get(i + 1).getIdClase() == 1 ? signo * 1 : signo * -1;
				stock = stock + kardexs.get(i + 1).getCantidad() * signo;
			}
		}
		return kardexs;
	}

}
