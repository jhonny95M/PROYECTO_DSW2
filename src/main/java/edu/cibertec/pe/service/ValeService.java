package edu.cibertec.pe.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cibertec.pe.entity.Estado;
import edu.cibertec.pe.entity.Kardex;
import edu.cibertec.pe.entity.Producto;
import edu.cibertec.pe.entity.Stock;
import edu.cibertec.pe.entity.User;
import edu.cibertec.pe.entity.Vale;
import edu.cibertec.pe.repository.KardexRepository;
import edu.cibertec.pe.repository.ProductoRepository;
import edu.cibertec.pe.repository.StockRepository;
import edu.cibertec.pe.repository.ValeRepository;
import edu.cibertec.pe.request.IngresoAlmacenRequest;
import edu.cibertec.pe.request.ProductoResquest;
import edu.cibertec.pe.util.ExceptionValidate;

@Service
public class ValeService {
	@Autowired
	ValeRepository valeRepository;
	@Autowired
	KardexRepository kardexRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	ProductoRepository productoRepository;
	
	private static final int ID_ALMACEN=1; 
	private static final int ID_CLASE_INGRESO=1; 
	private static final int ID_CLASE_SALIDA=2; 
	
	@Transactional
	public Long RegistrarIngresoVale(IngresoAlmacenRequest request) throws ExceptionValidate 
	{
		Vale vale=new Vale();
		vale.setIdVale(0L);
		vale.setIdAlmacen(ID_ALMACEN);
		vale.setEstado(new Estado(1));
		vale.setIdEstado(1);
		vale.setFecha(LocalDateTime.now());
		vale.setIdClase(ID_CLASE_INGRESO);
		vale.setIdTipMov(request.getIdTipMonv());
		vale.setUsuario(new User(request.getIdUsuario()));
		vale.setIdUsuario(request.getIdUsuario());
		//vale.setTipoMovimiento(new TipoMovimiento(ID_CLASE,request.getIdTipMonv()));
		Vale rs_vale= valeRepository.save(vale);
		int item=0;
		Map<Long, List<ProductoResquest>> groups = request.getProductos().stream()
				.collect(Collectors.groupingBy(ProductoResquest::getId));
		for (Map.Entry<Long, List<ProductoResquest>> k: groups.entrySet()) {
			item++;
			Optional<Producto> p=productoRepository.findById(k.getKey());
			if(p.isEmpty())throw new ExceptionValidate("El producto no se ha registrado");
			double cantidad=k.getValue().stream().mapToDouble(ProductoResquest::getCantidad).sum();
			Kardex kardex=new Kardex();
			kardex.setCantidad(cantidad);
			kardex.setIdAlmacen(ID_ALMACEN);
			kardex.setIdClase(ID_CLASE_INGRESO);
			kardex.setIdTipMov(request.getIdTipMonv());
			kardex.setVale(rs_vale);
			kardex.setProducto(p.get());
			kardex.setIdVale(rs_vale.getIdVale());
			kardex.setItemVale(item);
			kardexRepository.save(kardex);
			Stock stock=p.get().getStock();
			if(stock==null)stock=new Stock();
			stock.setCantidad(stock.getCantidad()+cantidad);
			stock.setProducto(p.get());
			stockRepository.save(stock);
		}
		return rs_vale.getIdVale();
	}
	@Transactional
	public Long RegistrarSalidaVale(IngresoAlmacenRequest request) throws ExceptionValidate 
	{
		Vale vale=new Vale();
		vale.setIdVale(0L);
		vale.setIdAlmacen(ID_ALMACEN);
		vale.setEstado(new Estado(1));
		vale.setIdEstado(1);
		vale.setFecha(LocalDateTime.now());
		vale.setIdClase(ID_CLASE_SALIDA);
		vale.setIdTipMov(request.getIdTipMonv());
		vale.setUsuario(new User(request.getIdUsuario()));
		vale.setIdUsuario(request.getIdUsuario());
		//vale.setTipoMovimiento(new TipoMovimiento(ID_CLASE,request.getIdTipMonv()));
		Vale rs_vale= valeRepository.save(vale);
		int item=0;
		Map<Long, List<ProductoResquest>> groups = request.getProductos().stream()
				.collect(Collectors.groupingBy(ProductoResquest::getId));
		for (Map.Entry<Long, List<ProductoResquest>> k: groups.entrySet()) {
			item++;
			Optional<Producto> p=productoRepository.findById(k.getKey());
			if(p.isEmpty())throw new ExceptionValidate("El producto no se ha registrado");
			double cantidad=k.getValue().stream().mapToDouble(ProductoResquest::getCantidad).sum();
			Stock stock=p.get().getStock();
			if(stock==null)stock=new Stock();
			double stockTotal=stock.getCantidad()-cantidad;
			if(stockTotal<0) {
				String descProd=p.get().getName();
				throw new ExceptionValidate("El producto "+descProd+" no cuenta con stock suficiente.");
			
			}
			Kardex kardex=new Kardex();
			kardex.setCantidad(cantidad);
			kardex.setIdAlmacen(ID_ALMACEN);
			kardex.setIdClase(ID_CLASE_SALIDA);
			kardex.setIdTipMov(request.getIdTipMonv());
			kardex.setVale(rs_vale);
			kardex.setProducto(p.get());
			kardex.setIdVale(rs_vale.getIdVale());
			kardex.setItemVale(item);
			kardexRepository.save(kardex);
			
			stock.setCantidad(stockTotal);
			stock.setProducto(p.get());
			stockRepository.save(stock);
		}
		return rs_vale.getIdVale();
	}
	

}
