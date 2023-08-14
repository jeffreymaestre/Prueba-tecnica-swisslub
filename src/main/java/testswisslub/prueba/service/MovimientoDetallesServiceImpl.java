package testswisslub.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testswisslub.prueba.entity.MovimientoDetalles;
import testswisslub.prueba.repository.MovimientoDetallesRepository;

import java.util.List;

@Service
public class MovimientoDetallesServiceImpl implements IMovimientoDetallesService{


    @Autowired
    MovimientoDetallesRepository movimientoDetallesRepository;

    @Override
    public MovimientoDetalles save(MovimientoDetalles movimientoDetalles) {
        return movimientoDetallesRepository.save(movimientoDetalles);
    }

    @Override
    public MovimientoDetalles update(MovimientoDetalles movimientoDetalles) {
        MovimientoDetalles movimientoActual = movimientoDetallesRepository.findById(movimientoDetalles.getId()).orElse(null);
        if(movimientoActual == null){
            return null;
        }
        movimientoActual.setMovimiento(movimientoDetalles.getMovimiento());
        movimientoActual.setItemCodigo(movimientoDetalles.getItemCodigo());
        movimientoActual.setCantidadEnviada(movimientoDetalles.getCantidadEnviada());

        return movimientoDetallesRepository.save(movimientoActual);
    }

    @Override
    public void delete(Long id) {
        movimientoDetallesRepository.deleteById(id);
    }


    @Override
    public List<MovimientoDetalles> findAll() {
        return movimientoDetallesRepository.findAll();
    }

    @Override
    public MovimientoDetalles findById(Long id) {
        return movimientoDetallesRepository.findById(id).orElse(null);
    }

    @Override
    public List<MovimientoDetalles> findByMovimientoId(Long movimientoId) {
        return  movimientoDetallesRepository.findByMovimientoId(movimientoId);
    }

    @Override
    public List<MovimientoDetalles> findByMovimientoEstado(String estado) {
        return movimientoDetallesRepository.findByMovimientoEstado(estado);
    }

    @Override
    public List<Object[]> obtenerDetallesPersonalizadosPorEstado(String estado) {
        return movimientoDetallesRepository.obtenerDetallesPersonalizadosPorEstado(estado);
    }

}
