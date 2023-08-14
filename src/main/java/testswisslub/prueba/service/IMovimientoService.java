package testswisslub.prueba.service;

import testswisslub.prueba.entity.Movimiento;

import java.util.List;

public interface IMovimientoService {
    public Movimiento save(Movimiento movimiento);
    public Movimiento updateMovimiento(Movimiento movimiento);
    public void delete(Long id);
    public List<Movimiento> findAll();
    public Movimiento findById(Long id);

    public List<Movimiento> buscarMovimientosPorEstado(String estado);
}
