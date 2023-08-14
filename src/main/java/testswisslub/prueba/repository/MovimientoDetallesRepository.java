package testswisslub.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import testswisslub.prueba.entity.MovimientoDetalles;

import java.util.List;

@Repository
public interface MovimientoDetallesRepository extends JpaRepository<MovimientoDetalles, Long> {
    List<MovimientoDetalles> findByMovimientoId(Long movimientoId);
    List<MovimientoDetalles> findByMovimientoEstado(String estado);

    @Query(nativeQuery = true,
            value = "SELECT m.id as movimiento_id, " +
                    "md.id as movimiento_detalle_id, " +
                    "m.bodega_origen_codigo, " +
                    "m.id_empresa as empresa, " +
                    "m.bodega_destino_codigo as bodega_destino_codigo, " +
                    "md.item_codigo as item_id " +
                    "FROM movimiento m " +
                    "JOIN movimiento_detalles md ON m.id = md.movimiento_id " +
                    "WHERE m.estado = :estado")
    List<Object[]> obtenerDetallesPersonalizadosPorEstado(@Param("estado") String estado);

}
