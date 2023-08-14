package testswisslub.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testswisslub.prueba.entity.Movimiento;
import testswisslub.prueba.repository.MovimientoRepository;
import testswisslub.prueba.service.IMovimientoService;
import testswisslub.prueba.service.MovimientoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovimientoRestControllers {
    @Autowired
    private IMovimientoService movimientoService;

    private final MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoRestControllers(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @GetMapping("/movimientos")
    public List<Movimiento> index(){
        return movimientoService.findAll();
    }

    @GetMapping("/movimientos/{id}")
    public Movimiento show(@PathVariable Long id){
        return movimientoService.findById(id);
    }

    @GetMapping("/movimientos/estado/{estados}")
    public List<Movimiento> showState(@PathVariable String estados){
        return movimientoService.buscarMovimientosPorEstado(estados);
    }

    @PostMapping("/movimientos")
    public Movimiento create(@RequestBody Movimiento movimiento){
        return movimientoService.save(movimiento);
    }

    @PutMapping("/movimientos/{id}")
    public ResponseEntity<Movimiento> update(@RequestBody Movimiento movimiento, @PathVariable Long id){
        Movimiento movimientoActualizado = movimientoService.updateMovimiento(movimiento);
        if (movimientoActualizado != null){
            return ResponseEntity.ok(movimientoActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/movimientos/{id}")
    public void delete (@PathVariable Long id){
        movimientoService.delete(id);
    }
}
