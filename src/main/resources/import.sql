-- Inserts para la tabla movimiento
INSERT INTO movimiento (id_empresa, descripcion, bodega_origen_codigo, bodega_destino_codigo, fecha_creacion, fecha_entrega, estado)
VALUES (1, 'Descripción Movimiento 1', 'BOD001', 'BOD002', '2023-08-01', '2023-08-10', 'Activo');

INSERT INTO movimiento (id_empresa, descripcion, bodega_origen_codigo, bodega_destino_codigo, fecha_creacion, fecha_entrega, estado)
VALUES (2, 'Descripción Movimiento 2', 'BOD003', 'BOD004', '2023-08-05', '2023-08-15', 'Inactivo');

-- Inserts para la tabla movimiento_detalles
INSERT INTO movimiento_detalles (movimiento_id, item_codigo, cantidad_enviada)
VALUES (1, 'COD001', 10);

INSERT INTO movimiento_detalles (movimiento_id, item_codigo, cantidad_enviada)
VALUES (1, 'COD002', 5);

INSERT INTO movimiento_detalles (movimiento_id, item_codigo, cantidad_enviada)
VALUES (2, 'COD003', 8);

INSERT INTO movimiento_detalles (movimiento_id, item_codigo, cantidad_enviada)
VALUES (2, 'COD004', 12);
