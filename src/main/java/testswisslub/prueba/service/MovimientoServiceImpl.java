package testswisslub.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testswisslub.prueba.entity.Movimiento;
import testswisslub.prueba.repository.MovimientoRepository;

import java.util.List;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

    @Autowired
    MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento updateMovimiento(Movimiento movimiento) {
        Movimiento movimientoActual = movimientoRepository.findById(movimiento.getId()).orElse(null);
        if(movimientoActual == null){
            return null;
        }
        movimientoActual.setDescripcion(movimiento.getDescripcion());
        movimientoActual.setCodigoBodegaOrigen(movimiento.getCodigoBodegaOrigen());
        movimientoActual.setCodigoBodegaDestino(movimiento.getCodigoBodegaDestino());
        movimientoActual.setEstado(movimiento.getEstado());
        return movimientoRepository.save(movimientoActual);
    }

    @Override
    public void delete(Long id) {
        movimientoRepository.deleteById(id);
    }


    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Movimiento findById(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movimiento> buscarMovimientosPorEstado(String estado) {
        return movimientoRepository.findByEstado(estado);
    }
}
