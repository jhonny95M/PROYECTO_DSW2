package edu.cibertec.pe.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cibertec.pe.entity.MovimientoKardex;
import edu.cibertec.pe.entity.OrdenCompra;
import edu.cibertec.pe.entity.Producto;
import edu.cibertec.pe.entity.Proveedor;
import edu.cibertec.pe.entity.Stock;
import edu.cibertec.pe.repository.*;
import edu.cibertec.pe.request.ProductoResquest;
import edu.cibertec.pe.util.ExceptionValidate;

@Service
public class AlmacenService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private MovimientoKardexRepository movimientoKardexRepository;

    @Transactional
    public void ingresarOrdenCompra(String numeroOrdenCompra, LocalDate fechaOrdenCompra, String nombreProveedor,
                                    List<ProductoResquest> lstproductos) throws ExceptionValidate {
    	OrdenCompra oc= ordenCompraRepository.findByNumero(numeroOrdenCompra);
    	if(oc!=null)throw new ExceptionValidate("La Orden de compra N° "+numeroOrdenCompra+" ya fue atendida.");
        // Buscar o crear el proveedor
        Proveedor proveedor = proveedorRepository.findByNombre(nombreProveedor)
                .orElseGet(() -> {
                    Proveedor nuevoProveedor = new Proveedor();
                    nuevoProveedor.setNombre(nombreProveedor);
                    return proveedorRepository.save(nuevoProveedor);
                });

        // Crear la orden de compra
        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setNumero(numeroOrdenCompra);
        ordenCompra.setFecha(fechaOrdenCompra);
        ordenCompra.setProveedor(proveedor);
        ordenCompraRepository.save(ordenCompra);

        // Registrar los productos en el kárdex
            for (ProductoResquest item : lstproductos) {
				
            	double cantidad = item.getCantidad();
            	Producto producto = productoRepository.findByName(item.getName())
            			.orElseGet(() -> {
            				Producto nuevoProducto = new Producto();
            				nuevoProducto.setName(item.getName());
            				nuevoProducto.setCategoryId(item.getCategoryId());
            				nuevoProducto.setStock(new Stock());
            				nuevoProducto.setUnitPrice(item.getUnitPrice());
            				return productoRepository.save(nuevoProducto);
            			});
			
            	Stock stock = producto.getStock();
                stock.setCantidad(stock.getCantidad() + cantidad);
                stock.setProducto(producto);
                productoRepository.save(producto);
                
            MovimientoKardex movimientoKardex = new MovimientoKardex();
            movimientoKardex.setTipoMovimiento("INGRESO DE ORDEN DE COMPRA");
            movimientoKardex.setFecha(LocalDateTime.now());
            movimientoKardex.setProducto(producto);
            movimientoKardex.setCantidad(cantidad);
            movimientoKardex.setOrdenCompra(ordenCompra);
            movimientoKardexRepository.save(movimientoKardex);
            }
    }
}

