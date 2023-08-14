package testswisslub.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testswisslub.prueba.entity.Movimiento;
import testswisslub.prueba.entity.MovimientoDetalles;
import testswisslub.prueba.service.IMovimientoDetallesService;
import testswisslub.prueba.service.IMovimientoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovimientoDetallesRestControllers {
    @Autowired
    private IMovimientoDetallesService movimientoService;

    @GetMapping("/detalles")
    public List<MovimientoDetalles> index(){
        return movimientoService.findAll();
    }

    @GetMapping("/detalles/{id}")
    public MovimientoDetalles show(@PathVariable Long id){
        return movimientoService.findById(id);
    }

    @PostMapping("/detalles")
    public MovimientoDetalles create(@RequestBody MovimientoDetalles movimientoDetalles){
        return movimientoService.save(movimientoDetalles);
    }

    @PutMapping("/detalles/{id}")
    public ResponseEntity<MovimientoDetalles> update(@RequestBody MovimientoDetalles movimientoDetalles, @PathVariable Long id){
        MovimientoDetalles movimientoActualizado = movimientoService.update(movimientoDetalles);
        if (movimientoActualizado != null){
            return ResponseEntity.ok(movimientoActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/detalles/{id}")
    public void delete (@PathVariable Long id){
        movimientoService.delete(id);
    }

    @GetMapping("/detalles/movimiento/{movimientoId}")
    public List<MovimientoDetalles> getDetallesPorMovimientoId(@PathVariable Long movimientoId) {
        return movimientoService.findByMovimientoId(movimientoId);
    }

    @GetMapping("/detalles/porEstadoDeMovimiento/{estado}")
    public List<MovimientoDetalles> findByEstadoDeMovimiento(@PathVariable String estado) {
        return movimientoService.findByMovimientoEstado(estado);
    }

    @GetMapping("/movimientos-detalles-personalizados")
    public ResponseEntity<List<Object[]>> obtenerDetallesPersonalizadosPorEstado(@RequestParam String estado) {
        List<Object[]> detallesPersonalizados = movimientoService.obtenerDetallesPersonalizadosPorEstado(estado);

        if (!detallesPersonalizados.isEmpty()) {
            return ResponseEntity.ok(detallesPersonalizados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
