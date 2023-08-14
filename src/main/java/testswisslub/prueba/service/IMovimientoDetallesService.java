package testswisslub.prueba.service;

import testswisslub.prueba.entity.MovimientoDetalles;

import java.util.List;

public interface IMovimientoDetallesService {
    public MovimientoDetalles save(MovimientoDetalles movimientoDetalles);
    public MovimientoDetalles update(MovimientoDetalles movimientoDetalles);
    public void delete(Long id);
    public List<MovimientoDetalles> findAll();
    public MovimientoDetalles findById(Long id);
    public List<MovimientoDetalles> findByMovimientoId(Long movimientoId);
    public List<MovimientoDetalles> findByMovimientoEstado(String estado);
    public List<Object[]> obtenerDetallesPersonalizadosPorEstado(String estado);
}
