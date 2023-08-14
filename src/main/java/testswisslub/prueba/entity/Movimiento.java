package testswisslub.prueba.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_empresa")
    private Long idEmpresa;

    private String descripcion;

    @Column(name = "bodega_origen_codigo")
    private String codigoBodegaOrigen;

    @Column(name = "bodega_destino_codigo")
    private String codigoBodegaDestino;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "fecha_entrega")
    private Date deliveryAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "movimiento",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovimientoDetalles> detalles;

    private String estado;

    @PrePersist
    public void prePersist(){
        this.createAt = new Date();
    }
}
