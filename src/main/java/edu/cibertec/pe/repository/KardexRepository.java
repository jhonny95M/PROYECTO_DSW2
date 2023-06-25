package edu.cibertec.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cibertec.pe.dto.KardexDto;
import edu.cibertec.pe.entity.Kardex;
import edu.cibertec.pe.entity.KardexId;

@Repository
public interface KardexRepository extends JpaRepository<Kardex, KardexId> {
	@Query(value = "SELECT new edu.cibertec.pe.dto.KardexDto(c.nomClase, v.Fecha, k.idVale, k.ItemVale, tm.NomTipMov, p.name, k.cantidad, u.email) " +
	           "FROM Kardex k " +
	           "INNER JOIN k.producto p " +
	           "INNER JOIN k.vale v " +
	           "INNER JOIN v.tipoMovimiento tm " +
	           "INNER JOIN v.usuario u " +
	           "INNER JOIN tm.claseMovimiento c " +
	           "WHERE v.estado.id = 1")
	List<KardexDto> findByKardexActivo();
	@Query(value = "SELECT new edu.cibertec.pe.dto.KardexDto(c.nomClase, v.Fecha, k.idVale, k.ItemVale, tm.NomTipMov, p.name, k.cantidad, u.email,c.idClase,p.id) " +
	           "FROM Kardex k " +
	           "INNER JOIN k.producto p " +
	           "INNER JOIN k.vale v " +
	           "INNER JOIN v.tipoMovimiento tm " +
	           "INNER JOIN v.usuario u " +
	           "INNER JOIN tm.claseMovimiento c " +
	           "WHERE v.estado.id = 1 AND p.id=:id order by v.Fecha")
	List<KardexDto> findByKardexByProducto(long id);
}
