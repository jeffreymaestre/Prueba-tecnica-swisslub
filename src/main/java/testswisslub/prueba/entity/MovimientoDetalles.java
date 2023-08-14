package testswisslub.prueba.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "movimiento_detalles")
public class MovimientoDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    private Movimiento movimiento;

    @Column(name = "item_codigo")
    private String itemCodigo;

    @Column(name = "cantidad_enviada")
    private Long cantidadEnviada;
}
