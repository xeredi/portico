-- // 0 0 1 Metamodelo Servicio
-- Migration SQL that makes the change goes here.

-- Manifiesto de Pesca
-- Manifiesto de Pesca
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21001, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45105, 1, 1, 1,  4, 1, 1, 1, NULL, 'Buque')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 43000, 1, 1, 3,  3, 1, 1, 1, NULL, 'Cod. Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45155, 1, 1, 4,  3, 0, 0, 0, NULL, 'Tipo Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45070, 1, 2, 1,  4, 1, 1, 1, NULL, 'T Operacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45035, 1, 2, 2,  4, 1, 1, 1, NULL, 'Vendedor')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45036, 1, 2, 3,  4, 0, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45075, 1, 3, 1,  3, 0, 1, 1, NULL, 'Tipo Manif.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45080, 1, 3, 2,  3, 0, 1, 1, NULL, 'Subtipo Manif.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 41020, 1, 3, 3,  1, 0, 1, 1, NULL, 'Referencia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 43005, 1, 4, 1,  2, 1, 1, 1, NULL, 'Orden Venta')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 41040, 1, 4, 2,  2, 1, 1, 0, NULL, 'Peso')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 41041, 1, 4, 3,  2, 1, 1, 0, NULL, 'Imp. Total')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45040, 1, 4, 4,  2, 1, 1, 0, NULL, 'T. IVA')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 41000, 1, 4, 5,  2, 1, 1, 1, NULL, 'Suj. Pas. Sustituto')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45180, 1, 5, 1,  4, 0, 1, 1, NULL, 'Alineacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45110, 1, 5, 2,  4, 0, 1, 0, NULL, 'Arte de Pesca')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 45065, 1, 5, 3,  4, 0, 1, 0, NULL, 'Zona de Pesca')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 41021, 1, 6, 1,  8, 0, 0, 0, NULL, 'Nombre Fichero')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 41080, 1, 7, 1, 12, 0, 0, 0, NULL, 'Observaciones')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21001, 41081, 1, 8, 1, 12, 0, 0, 0, NULL, 'Observaciones Facturacion')
/

-- Partida de Pesca
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22001, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 45215, 1, 1, 1, 4, 1, 1, 1, NULL, 'Especie')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 45220, 1, 1, 2, 4, 0, 1, 1, NULL, 'Comprador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 45225, 1, 2, 1, 4, 1, 1, 1, NULL, 'Presentacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 43090, 1, 2, 2, 4, 1, 1, 1, NULL, 'Destino')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 41040, 1, 3, 1, 2, 0, 1, 0, NULL, 'Cajas')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 41041, 1, 3, 2, 2, 1, 1, 0, NULL, 'Kilos')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 41042, 1, 3, 3, 2, 0, 1, 0, NULL, 'Precio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22001, 41043, 1, 3, 4, 2, 1, 1, 0, NULL, 'Importe')
/





-- Manifiesto de Mercancia
-- Manifiesto de Mercancia
-- Manifiesto de Mercancia
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21002, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41100, 1,  2,  2,  2, 0, 1, 1, NULL, 'F. Envio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 43100, 1,  3,  3,  2, 0, 1, 1, NULL, 'Tipo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 47001, 1,  3,  4,  2, 0, 1, 1, NULL, 'Escala')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41000, 1,  4,  4,  1, 1, 1, 1, NULL, 'EDI?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41020, 1,  5,  5,  3, 0, 1, 1, NULL, 'Nº EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41021, 1,  6,  6,  3, 0, 1, 1, NULL, 'Nº Viaje')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41060, 1,  7,  7,  2, 1, 1, 1, NULL, 'Nº Tramos')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41061, 1,  8,  8,  2, 0, 1, 1, NULL, 'Dias en Puerto')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41001, 1,  9,  9,  2, 1, 1, 1, NULL, 'Serv. Regular?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41002, 1, 10, 10,  2, 1, 1, 1, NULL, 'Reg. Simple?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 41003, 1, 11, 11,  2, 1, 1, 1, NULL, 'Abarloado?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 43110, 1, 12, 12,  2, 1, 1, 1, NULL, 'Tipo de Operacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 43330, 1, 13, 13,  2, 0, 1, 1, NULL, 'P. T. C.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45245, 1, 14, 14,  4, 0, 1, 1, NULL, 'Acuerdo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45180, 1, 15, 15,  4, 0, 1, 1, NULL, 'Alineacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45365, 1, 16, 16,  4, 1, 1, 1, NULL, 'R. Aduanero')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45035, 1, 17, 17,  4, 0, 1, 1, NULL, 'Estibador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 43000, 1, 18, 18,  3, 1, 1, 1, NULL, 'Cod. Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45155, 1, 19, 19,  4, 0, 0, 1, NULL, 'Tipo Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45036, 1, 20, 20,  4, 1, 0, 1, NULL, 'Consignatario')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45305, 1, 21, 21,  4, 0, 1, 1, NULL, 'Terminal')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45240, 1, 22, 22,  4, 0, 1, 1, NULL, 'Servicio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45005, 1, 23, 23,  4, 0, 0, 0, NULL, 'Pais Entrada')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21002, 45360, 1, 24, 24,  4, 0, 0, 0, NULL, 'Desc. Adicional')
/

-- Consignatario de Manifiesto
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22002, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22002, 45035, 1,  1,  1,  4, 1, 1, 1, NULL, 'Consignatario')
/

-- BL
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22003, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 43135, 1,  1,  1,  3, 1, 1, 1, NULL, 'Tipo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41060, 1,  2,  2,  2, 0, 0, 0, NULL, 'Tramo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 43000, 1,  3,  3,  3, 0, 1, 1, NULL, 'Cod. Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45155, 1,  4,  4,  4, 0, 1, 1, NULL, 'Tipo Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41020, 1,  5,  5,  4, 0, 0, 0, NULL, 'Nombre')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45285, 1,  7,  7,  4, 1, 1, 1, NULL, 'Operacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45055, 1,  8,  8,  4, 0, 1, 1, NULL, 'Origen')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45056, 1,  9,  9,  4, 1, 1, 1, NULL, 'Carga')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45057, 1, 10, 10,  4, 1, 1, 1, NULL, 'Descarga')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45058, 1, 11, 11,  4, 0, 1, 1, NULL, 'Destino')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45059, 1, 12, 12,  4, 0, 1, 1, NULL, 'Transbordo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41021, 1, 13, 13,  4, 0, 1, 1, NULL, 'Dec. Sum. Transito')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 43125, 1, 14, 14,  4, 1, 1, 1, NULL, 'Tipo Transporte')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45350, 1, 15, 15,  4, 0, 1, 1, NULL, 'Modo Transporte EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41022, 1, 16, 16,  4, 0, 1, 1, NULL, 'Transporte Post.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 43390, 1, 17, 17,  4, 0, 1, 1, NULL, 'T. Destino')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45300, 1, 18, 18,  4, 0, 1, 1, NULL, 'Inst. Especial')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45180, 1, 19, 19,  4, 1, 1, 1, NULL, 'Alineacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45035, 1, 20, 20,  4, 0, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41000, 1, 21, 21,  2, 1, 1, 1, NULL, 'Suj. Pasivo?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45235, 1, 22, 22,  3, 1, 1, 1, NULL, 'T. Navegacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41001, 1, 23, 23,  2, 1, 1, 1, NULL, 'Reg. Simple?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45305, 1, 24, 24,  4, 0, 1, 1, NULL, 'Terminal')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45245, 1, 25, 25,  4, 0, 1, 1, NULL, 'Acuerdo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45240, 1, 26, 26,  4, 0, 1, 1, NULL, 'Servicio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45036, 1, 27, 27,  4, 0, 1, 1, NULL, 'Estibador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 45040, 1, 28, 28,  3, 1, 1, 1, NULL, 'T. IVA')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41024, 1, 29, 29,  12, 0, 0, 0, NULL, 'Observaciones')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22003, 41023, 1, 30, 30,  12, 0, 0, 0, NULL, 'Observaciones Facturacion')
/

-- Partida
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22004, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45290, 1, 1, 1,  4, 1, 1, 1, NULL, 'Mercancia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45345, 1, 2, 2,  4, 0, 1, 1, NULL, 'T. Bulto')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 43000, 1, 4, 4,  4, 1, 1, 1, NULL, 'Cod. Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45155, 1, 5, 5,  4, 0, 0, 0, NULL, 'Tipo Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41000, 1, 6, 6,  4, 1, 1, 1, NULL, 'Avituallamiento?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41001, 1, 7, 7,  4, 1, 1, 1, NULL, 'Ro-Ro?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41060, 1, 8, 8,  4, 0, 1, 0, NULL, 'Nº Bultos')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41061, 1, 9, 9,  4, 0, 1, 0, NULL, 'Nº U.C.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45145, 1, 10, 10,  4, 0, 1, 1, NULL, 'U.C.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41062, 1, 11, 11,  4, 0, 0, 0, NULL, 'Nº Pasajeros')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41040, 1, 12, 12,  4, 0, 0, 0, NULL, 'Volumen')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41063, 1, 13, 13,  4, 0, 0, 0, NULL, 'Peso')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41020, 1, 14, 14,  4, 0, 0, 0, NULL, 'Nº Part. Transito')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41021, 1, 15, 15,  4, 0, 0, 0, NULL, 'Dec. Sum. Transito')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45245, 1, 16, 16,  4, 0, 1, 1, NULL, 'Acuerdo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45035, 1, 17, 17,  4, 0, 1, 1, NULL, 'Estibador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45335, 1, 18, 18,  4, 0, 1, 1, NULL, 'Receptor')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45300, 1, 19, 19,  4, 0, 1, 1, NULL, 'Inst. Especial')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45275, 1, 20, 20,  4, 0, 1, 1, NULL, 'T. Suministro')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45305, 1, 21, 21,  4, 0, 1, 1, NULL, 'Terminal')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 45330, 1, 22, 22,  4, 0, 1, 1, NULL, 'Marca de Vehiculo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41002, 1, 23, 23,  4, 0, 1, 1, NULL, 'Declarado ENS?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22004, 41022, 1, 24, 24, 12, 0, 1, 1, NULL, 'Observaciones')
/

-- Equipamiento
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22005, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 45325, 1, 2, 2,  4, 1, 1, 1, NULL, 'Tipo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 41020, 1, 3, 3,  4, 1, 1, 1, NULL, 'Matricula')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 43000, 1, 4, 4,  4, 1, 1, 1, NULL, 'Cod. Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 45155, 1, 5, 5,  4, 0, 0, 0, NULL, 'Tipo Exencion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 41021, 1, 6, 6,  4, 1, 0, 0, NULL, 'Ind. Lleno-Vacio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 41060, 1, 7, 7,  4, 0, 0, 0, NULL, 'Nº Vacios')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 41000, 1, 8, 8,  4, 1, 1, 1, NULL, 'Ro-Ro?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 41061, 1, 9, 9,  4, 1, 1, 0, NULL, 'Tara')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 45145, 1, 10, 10,  4, 1, 1, 1, NULL, 'U. Carga')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22005, 41022, 1, 11, 11,  12, 0, 0, 0, NULL, 'Observaciones')
/

-- IM de Partida
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22008, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22008, 45315, 1,  1,  1,  4, 1, 1, 1, NULL, 'IM')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22008, 41020, 1,  2,  2,  4, 0, 0, 0, NULL, 'Descripcion')
/

-- MMPP de Partida
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22009, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22009, 45320, 1,  1,  1,  4, 1, 1, 1, NULL, 'MM.PP.')
/

-- Precinto de Equipamiento
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22010, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22010, 41020, 1,  1,  1,  4, 1, 1, 1, NULL, 'Precinto')
/

-- Partida-Equipamiento
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22006, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22006, 41060, 1,  1,  1,  4, 1, 1, 0, NULL, 'Nº Bultos')
/

-- Documento de Partida
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22007, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22007, 43475, 1,  1,  1,  4, 0, 1, 1, NULL, 'Sit. Embarque')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22007, 43480, 1,  1,  2,  4, 0, 1, 1, NULL, 'Sit. Aduanera')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22007, 41100, 1,  2,  2,  4, 0, 1, 0, NULL, 'F. Emisión')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22007, 41020, 1,  3,  3,  4, 0, 1, 0, NULL, 'Nº Aduanero')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22007, 41021, 1,  4,  4,  4, 1, 1, 0, NULL, 'Estado Documento')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22007, 45310, 1,  5,  5,  4, 0, 1, 1, NULL, 'Tipo Documento')
/







-- Escala
-- Escala
-- Escala
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21003, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41000, 1,  1,  1,  2, 1, 1, 1, NULL, 'Carga EDI?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41020, 1,  2,  2,  3, 0, 0, 0, NULL, 'Emisor EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41021, 1,  3,  3,  2, 0, 0, 0, NULL, 'Ref. Mensaje EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 43245, 1,  5,  5,  2, 0, 1, 1, NULL, 'Estado C. M.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41100, 1,  6,  6,  2, 0, 0, 0, NULL, 'Fecha C. M.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41101, 1,  7,  7,  2, 0, 0, 0, NULL, 'Fecha Not. Prác.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41022, 1,  8,  8,  3, 0, 0, 0, NULL, 'Manifiesto Not. Prác.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41102, 1,  9,  9,  2, 0, 1, 0, NULL, 'F. Entrada')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41103, 1, 10, 10,  2, 0, 1, 0, NULL, 'F. Salida')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45010, 1, 11, 11,  4, 1, 1, 1, NULL, 'Buque')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45030, 1, 12, 12,  4, 1, 1, 1, NULL, 'T. Buque Ent.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45031, 1, 13, 13,  4, 1, 1, 1, NULL, 'T. Buque Sal.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 43115, 1, 14, 14,  2, 1, 1, 1, NULL, 'Estancia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41001, 1, 15, 15,  2, 1, 1, 1, NULL, 'Nav. Internacional')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 43000, 1, 16, 16,  2, 1, 1, 1, NULL, 'Cód. Exención')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45155, 1, 17, 17,  4, 0, 0, 1, NULL, 'Tipo Exención')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41002, 1, 18, 18,  2, 1, 0, 0, NULL, 'Carga MM.PP.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41003, 1, 19, 19,  2, 1, 0, 0, NULL, 'Transporta MM.PP.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41004, 1, 20, 20,  2, 1, 0, 0, NULL, 'Descarga MM.PP.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41005, 1, 21, 21,  2, 1, 0, 0, NULL, 'Suj. Pas. Sust.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41006, 1, 22, 22,  2, 1, 0, 0, NULL, 'Op. Comerciales?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45245, 1, 23, 23,  4, 0, 0, 1, NULL, 'Acuerdo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45240, 1, 24, 24,  4, 0, 0, 1, NULL, 'Serv. Tráfico')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45040, 1, 25, 25,  2, 1, 0, 0, NULL, 'Tipo de IVA')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45235, 1, 26, 26,  3, 1, 0, 0, NULL, 'Navegación Ent.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45236, 1, 27, 27,  3, 1, 0, 0, NULL, 'Navegación Sal.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41023, 1, 28, 28,  3, 0, 0, 0, NULL, 'Cap. Entrada')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41024, 1, 29, 29,  3, 0, 0, 0, NULL, 'Cap. Salida')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41060, 1, 30, 30,  1, 0, 0, 0, NULL, 'Trip. Ent.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41062, 1, 31, 31,  1, 0, 0, 0, NULL, 'Trip. Sal.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41063, 1, 32, 32,  1, 0, 0, 0, NULL, 'Pas. Ent.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41064, 1, 33, 33,  1, 0, 0, 0, NULL, 'Pas. Sal.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41065, 1, 34, 34,  1, 0, 0, 0, NULL, 'Pol. Ent.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41066, 1, 35, 35,  1, 0, 0, 0, NULL, 'Pol. Sal.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41067, 1, 36, 36,  1, 0, 0, 0, NULL, 'Esclusas')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41068, 1, 37, 37,  1, 0, 0, 0, NULL, 'Pasarelas')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45055, 1, 38, 38,  4, 1, 0, 0, NULL, 'Puerto Sig.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45056, 1, 39, 39,  4, 1, 0, 0, NULL, 'Puerto Ant.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45035, 1, 40, 40,  4, 0, 0, 0, NULL, 'Cliente S.M.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45036, 1, 41, 41,  4, 0, 0, 0, NULL, 'Cliente Residuos')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 45037, 1, 42, 42,  4, 0, 0, 0, NULL, 'Consignatario')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41025, 1, 43, 43, 12, 0, 0, 0, NULL, 'Observaciones')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41026, 1, 44, 44, 12, 0, 0, 0, NULL, 'Observaciones C.M.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41027, 1, 45, 45, 12, 0, 0, 0, NULL, 'Observaciones DUE')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41028, 1, 46, 46, 12, 0, 0, 0, NULL, 'Observaciones Facturación')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41007, 1, 47, 47,  2, 1, 0, 0, NULL, 'Cabotaje?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41008, 1, 48, 48,  2, 1, 0, 0, NULL, 'Transporta Crudo?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41009, 1, 49, 49,  3, 1, 0, 0, NULL, 'Recogida por Medios Marinos?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41010, 1, 50, 50,  2, 1, 0, 0, NULL, 'Cert. Anexo?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41011, 1, 51, 51,  2, 1, 0, 0, NULL, 'Cert. Residuos?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41012, 1, 52, 52,  2, 1, 0, 0, NULL, 'Tarifa Residuos?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 43515, 1, 53, 53,  4, 0, 0, 0, NULL, 'Cond. Tanque Lastre')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 43520, 1, 54, 54,  4, 0, 0, 0, NULL, 'Cond. Tanque Carga')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41013, 1, 55, 55,  2, 1, 0, 0, NULL, 'Merc. Regulada?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41069, 1, 56, 56,  2, 0, 0, 0, NULL, 'Vol. Carga')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41014, 1, 57, 57,  2, 1, 0, 0, NULL, 'Tareas Obligatorias?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41031, 1, 58, 58,  4, 0, 0, 0, NULL, 'Tareas Obligatorias')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21003, 41015, 1, 59, 59,  2, 1, 0, 0, NULL, 'Modificado EDI?')
/

-- Atraque
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22011, 1, 'General')
/
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22011, 2, 'Solicitud')
/
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22011, 3, 'Autorizacion')
/
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22011, 4, 'Real')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41100, 1,  1,  1,  2, 0, 0, 0, NULL, 'F. Autorizacion')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41020, 1,  2,  2,  3, 0, 0, 0, NULL, 'Emisor EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41060, 1,  3,  3,  2, 0, 1, 0, NULL, 'Nº EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 43000, 1,  4,  4,  3, 1, 1, 1, NULL, 'Cód. Exención')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41000, 1,  5,  5,  2, 1, 0, 0, NULL, 'Suj. Pas. Sust.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41101, 1,  6,  6,  2, 1, 1, 0, NULL, 'F. Solicitud')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45035, 1,  8,  8,  4, 0, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45155, 1,  9,  9,  4, 0, 1, 1, NULL, 'T. Exención')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45036, 1, 10, 10,  4, 1, 1, 1, NULL, 'Consignatario')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41001, 1, 11, 11,  2, 1, 0, 0, NULL, 'Modificado EDI?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45360, 1, 12, 12,  3, 0, 0, 0, NULL, 'Desc. Adiciomal')
/
	-- Sol
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 43120, 2,  1,  1,  2, 0, 0, 0, NULL, 'Estancia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45000, 2,  1,  2,  3, 0, 0, 0, NULL, 'T. Act.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 43525, 2,  1,  3,  3, 0, 0, 0, NULL, 'T. Act. EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45180, 2,  1,  4,  4, 0, 0, 0, NULL, 'Alineación')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45380, 2,  2,  1,  2, 0, 0, 0, NULL, 'T. Atr.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45410, 2,  2,  2,  4, 0, 0, 0, NULL, 'T. Atr. EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41040, 2,  2,  3,  1, 0, 0, 0, NULL, 'Noray I.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41041, 2,  2,  4,  1, 0, 0, 0, NULL, 'Noray F.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41042, 2,  2,  5,  1, 0, 0, 0, NULL, 'Calado E.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41043, 2,  2,  6,  1, 0, 0, 0, NULL, 'Calado S.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41007, 2,  2,  7,  1, 0, 0, 0, NULL, 'Exen. Prac.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41044, 2,  3,  1,  1, 0, 0, 0, NULL, 'Rampa Ad.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41045, 2,  3,  2,  1, 0, 0, 0, NULL, 'Esl. Rampa')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41002, 2,  3,  3,  1, 0, 0, 0, NULL, 'Luz?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41003, 2,  3,  4,  1, 0, 0, 0, NULL, 'Fuerza?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41004, 2,  3,  5,  1, 0, 0, 0, NULL, 'Combust.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41005, 2,  3,  6,  1, 0, 0, 0, NULL, 'Hielo?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41006, 2,  3,  7,  1, 0, 0, 0, NULL, 'Agua?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41080, 2,  4,  1, 12, 0, 0, 0, NULL, 'Observaciones')
/
	-- Aut.
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 43121, 3,  1,  1,  2, 0, 0, 0, NULL, 'Estancia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45001, 3,  1,  2,  3, 0, 0, 0, NULL, 'T. Act.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 43526, 3,  1,  3,  3, 0, 0, 0, NULL, 'T. Act. EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45181, 3,  1,  4,  4, 0, 0, 0, NULL, 'Alineación')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45381, 3,  2,  1,  2, 0, 0, 0, NULL, 'T. Atr.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45411, 3,  2,  2,  4, 0, 0, 0, NULL, 'T. Atr. EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41046, 3,  2,  3,  1, 0, 0, 0, NULL, 'Noray I.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41047, 3,  2,  4,  1, 0, 0, 0, NULL, 'Noray F.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41048, 3,  2,  5,  1, 0, 0, 0, NULL, 'Calado E.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41049, 3,  2,  6,  1, 0, 0, 0, NULL, 'Calado S.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41013, 3,  2,  7,  1, 0, 0, 0, NULL, 'Exen. Prac.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41050, 3,  3,  1,  1, 0, 0, 0, NULL, 'Rampa Ad.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41051, 3,  3,  2,  1, 0, 0, 0, NULL, 'Esl. Rampa')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41081, 3,  4,  1, 12, 0, 0, 0, NULL, 'Observaciones')
/
	-- rea
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 43122, 4,  1,  1,  2, 0, 0, 0, NULL, 'Estancia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45002, 4,  1,  2,  3, 0, 0, 0, NULL, 'T. Act.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 43527, 4,  1,  3,  3, 0, 0, 0, NULL, 'T. Act. EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45182, 4,  1,  4,  4, 0, 0, 0, NULL, 'Alineación')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45382, 4,  2,  1,  2, 0, 0, 0, NULL, 'T. Atr.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 45412, 4,  2,  2,  4, 0, 0, 0, NULL, 'T. Atr. EDI')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41052, 4,  2,  3,  1, 0, 0, 0, NULL, 'Noray I.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41053, 4,  2,  4,  1, 0, 0, 0, NULL, 'Noray F.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41054, 4,  2,  5,  1, 0, 0, 0, NULL, 'Calado E.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41055, 4,  2,  6,  1, 0, 0, 0, NULL, 'Calado S.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41019, 4,  2,  7,  1, 0, 0, 0, NULL, 'Exen. Prac.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41056, 4,  3,  1,  1, 0, 0, 0, NULL, 'Rampa Ad.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41057, 4,  3,  2,  1, 0, 0, 0, NULL, 'Esl. Rampa')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22011, 41082, 4,  4,  1, 12, 0, 0, 0, NULL, 'Observaciones')
/

-- Operacion de Atraque
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22012, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 45370, 1,  1,  1,  4, 1, 1, 1, NULL, 'T. Operación')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 41040, 1,  2,  2,  4, 0, 1, 0, NULL, 'P.M.U.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 41041, 1,  3,  3,  4, 0, 1, 0, NULL, 'Cant. Movida')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 43315, 1,  4,  4,  4, 0, 1, 0, NULL, 'Unid. Berman')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 41020, 1,  5,  5,  4, 0, 1, 0, NULL, 'Lugar Carga-Descarga')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 45035, 1,  6,  6,  4, 0, 1, 1, NULL, 'Estibador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 41021, 1,  7,  7,  4, 0, 0, 0, NULL, 'Obs. Mercancia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 41022, 1,  8,  8,  4, 0, 0, 0, NULL, 'Obs. Estibador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22012, 45385, 1,  9,  9,  4, 0, 1, 1, NULL, 'T. Mercancía')
/

-- Contador de Escala
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22015, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22015, 43160, 1,  1,  1,  3, 1, 1, 1, NULL, 'Tipo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22015, 41060, 1,  1,  2,  2, 1, 1, 1, NULL, 'Nº. Lecturas')
/

-- Contador de Escala
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22016, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22016, 45440, 1,  1,  1,  3, 1, 1, 1, NULL, 'Subt. Residuo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22016, 41040, 1,  2,  1,  2, 0, 1, 0, NULL, 'Cant. Declarada')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22016, 41041, 1,  2,  2,  2, 0, 1, 0, NULL, 'Cant. Estimada')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22016, 41042, 1,  2,  3,  2, 0, 1, 0, NULL, 'Cant. Pendiente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22016, 41043, 1,  2,  4,  2, 0, 1, 0, NULL, 'Cant. Entregada')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22016, 41044, 1,  2,  5,  2, 0, 1, 0, NULL, 'Cap. Maxima')
/





-- Suministro de buque
-- Suministro de buque
-- Suministro de buque
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21005, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 41020, 1,  1,  1,  3, 0, 1, 1, NULL, 'Referencia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 45275, 1,  1,  3,  4, 1, 1, 1, NULL, 'T. Suministro')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 43000, 1,  2,  1,  3, 1, 1, 1, NULL, 'Cód. Exen.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 45155, 1,  2,  2,  4, 0, 1, 1, NULL, 'T. Exen.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 45360, 1,  2,  3,  4, 0, 1, 1, NULL, 'Desc. Adicional')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 45035, 1,  3,  1,  4, 1, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 45036, 1,  3,  2,  4, 0, 1, 1, NULL, 'Pagador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 41000, 1,  3,  3,  2, 1, 1, 1, NULL, 'Suj. Pasivo?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 41100, 1,  4,  1,  2, 0, 1, 1, NULL, 'F. Solicitud')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 41101, 1,  4,  2,  2, 0, 1, 1, NULL, 'F. Autorización')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 41080, 1, 10,  1, 12, 0, 0, 0, NULL, 'Observaciones')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21005, 41081, 1, 11,  1, 12, 0, 0, 0, NULL, 'Observaciones Fact.')
/
-- SUCO_ESCA_ID 	number 	19 	 √  		null
-- IESC_ESCALA_ESCA

-- Gasto
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22013, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22013, 45390, 1,  1,  1,  3, 1, 1, 1, NULL, 'T. Gasto')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22013, 45040, 1,  1,  2,  3, 0, 1, 1, NULL, 'T. IVA')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22013, 41040, 1,  1,  3,  3, 0, 1, 0, NULL, 'Coste')
/

-- Lectura
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22014, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 41040, 1,  1,  1,  2, 0, 1, 0, NULL, 'L. Inicio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 41020, 1,  1,  2, 10, 0, 0, 0, NULL, 'Obs. Inicio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 41041, 1,  2,  1,  2, 0, 1, 0, NULL, 'L. Fin')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 41021, 1,  2,  2, 10, 0, 0, 0, NULL, 'Obs. Fin')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 41042, 1,  3,  1,  2, 0, 1, 0, NULL, 'Consumo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 43540, 1,  3,  2,  3, 0, 1, 1, NULL, 'T. Hora')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 45040, 1,  3,  3,  3, 1, 1, 1, NULL, 'T. IVA')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22014, 45395, 1,  4,  1,  2, 0, 1, 1, NULL, 'Contador')
/
-- LCSU_PRSU_ID 	number 	19 	 √  		null
-- ISUM_PUNTORED_PRSU




-- Ocupacion de superficie
-- Ocupacion de superficie
-- Ocupacion de superficie
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21007, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41020, 1,  1,  1,  2, 0, 1, 1, NULL, 'Referencia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 43340, 1,  1,  2,  3, 0, 1, 1, NULL, 'T. Valoración')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45040, 1,  1,  4,  3, 1, 1, 1, NULL, 'T. IVA')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 43000, 1,  2,  1,  3, 1, 1, 1, NULL, 'Cód. Exen.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45155, 1,  2,  2,  3, 0, 1, 1, NULL, 'T. Exen.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45360, 1,  2,  3,  3, 0, 1, 1, NULL, 'Desc. Adic.')
/
-- EscalaId
-- ManifiestoId
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45035, 1,  4,  1,  4, 1, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45036, 1,  4,  2,  4, 0, 1, 1, NULL, 'Cliente Tasas')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41000, 1,  4,  3,  2, 1, 1, 1, NULL, 'Suj. Pas. Sust.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45115, 1,  5,  1,  3, 1, 1, 1, NULL, 'T. Mercancía')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41021, 1,  5,  2,  3, 0, 1, 0, NULL, 'Mercancía')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45270, 1,  5,  3,  3, 1, 1, 1, NULL, 'T. Operación')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41001, 1,  5,  4,  2, 1, 1, 1, NULL, 'Ro-Ro?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45260, 1,  6,  1,  3, 0, 1, 1, NULL, 'Zona Depósito')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 45265, 1,  6,  2,  3, 0, 1, 1, NULL, 'T. Unidad')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41100, 1,  7,  1,  2, 0, 1, 0, NULL, 'F. Solicitud')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41060, 1,  7,  2,  2, 0, 1, 0, NULL, 'Sup. Solicitud')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41061, 1,  7,  3,  2, 0, 1, 0, NULL, 'Tm. Solicitud')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41101, 1,  8,  1,  2, 0, 1, 0, NULL, 'F. Autorización')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41062, 1,  8,  2,  2, 0, 1, 0, NULL, 'Sup. Autorización')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41063, 1,  8,  3,  2, 0, 1, 0, NULL, 'Tm. Autorización')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41080, 1, 10,  1, 11, 0, 0, 0, NULL, 'Observaciones')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21007, 41081, 1, 11,  1, 11, 0, 0, 0, NULL, 'Observaciones Facturación')
/

-- Linea de Ocupacion de Superficie
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22018, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22018, 41060, 1,  1,  1,  2, 1, 1, 0, NULL, 'Medida')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22018, 41061, 1,  1,  2,  2, 0, 1, 0, NULL, 'Medida Equivalente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22018, 41020, 1,  1,  3,  6, 0, 1, 0, NULL, 'Mercancia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22018, 41021, 1,  1,  4,  1, 0, 1, 0, NULL, 'Referencia')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22018, 41080, 1,  2,  1, 11, 0, 0, 0, NULL, 'Observaciones')
/




-- Amarres
-- Amarres
-- Amarres
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21008, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41120, 1,  1,  1,  2, 1, 1, 0, NULL, 'F. Solicitud')
/
-- TODO Atraque
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 45415, 1,  2,  1,  3, 1, 1, 1, NULL, 'T. Movimiento')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 45035, 1,  2,  2,  3, 1, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 45036, 1,  2,  3,  3, 1, 1, 1, NULL, 'Prestador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41060, 1,  3,  1,  2, 1, 1, 0, NULL, 'Nº. Amarradores')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41061, 1,  3,  2,  1, 1, 1, 0, NULL, 'Cab. Proa')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41062, 1,  3,  3,  1, 1, 1, 0, NULL, 'Cab. Popa')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41040, 1,  3,  4,  1, 0, 1, 0, NULL, 'Tarifa')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41041, 1,  3,  5,  1, 0, 1, 0, NULL, 'Bonif.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41042, 1,  3,  6,  1, 0, 1, 0, NULL, 'Descuento')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41043, 1,  3,  7,  1, 0, 1, 0, NULL, 'Recargo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21008, 41044, 1,  3,  8,  1, 0, 1, 0, NULL, 'Imp. Total')
/

-- Medio de Amarre
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (22019, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22019, 45420, 1,  1,  1,  3, 1, 1, 1, NULL, 'T. Medio')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (22019, 41060, 1,  1,  2,  2, 1, 1, 0, NULL, 'Nº. Medios')
/



-- Practicajes
-- Practicajes
-- Practicajes
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21009, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 41120, 1,  1,  1,  2, 1, 1, 0, NULL, 'F. Solicitud')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 41000, 1,  1,  2,  2, 1, 1, 1, NULL, 'Punto Correcto')
/
-- TODO Atraque
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 45425, 1,  1,  4,  3, 1, 1, 1, NULL, 'T. Maniobra')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 45035, 1,  2,  1,  4, 1, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 45036, 1,  2,  2,  4, 1, 1, 1, NULL, 'Prestador')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 45037, 1,  2,  3,  4, 0, 1, 1, NULL, 'Practico')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 41040, 1,  3,  1,  1, 0, 1, 0, NULL, 'Tarifa')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 41041, 1,  3,  2,  1, 0, 1, 0, NULL, 'Bonif.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 41042, 1,  3,  3,  1, 0, 1, 0, NULL, 'Descuento')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 41043, 1,  3,  4,  1, 0, 1, 0, NULL, 'Recargo')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21009, 41044, 1,  3,  5,  1, 0, 1, 0, NULL, 'Imp. Total')
/



-- Asignacion de Amarres
-- Asignacion de Amarres
-- Asignacion de Amarres
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_orden, engd_etiqueta) VALUES (21010, 1, 'General')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 41000, 1,  1,  1,  2, 1, 1, 0, NULL, 'Desautorizado con Ocup.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45450, 1,  1,  2,  3, 1, 1, 1, NULL, 'Amarre')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45451, 1,  1,  3,  3, 0, 1, 1, NULL, 'Amarre Secundario')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 41120, 1,  1,  4,  2, 0, 1, 0, NULL, 'F. Ini. Secundario')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 41121, 1,  1,  5,  2, 0, 1, 0, NULL, 'F. Fin Secundario')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45035, 1,  2,  1,  4, 0, 1, 1, NULL, 'Cliente')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45470, 1,  2,  2,  4, 0, 1, 1, NULL, 'Embarcacion Dep.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 43000, 1,  2,  3,  1, 0, 1, 1, NULL, 'Cod. Exen.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45155, 1,  2,  4,  3, 0, 1, 1, NULL, 'T. Exen.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45036, 1,  3,  1,  4, 0, 1, 1, NULL, 'Cliente Adic.')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 41001, 1,  3,  2,  2, 0, 1, 1, NULL, 'Suj. Pas. Sust.?')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45040, 1,  3,  3,  3, 1, 1, 1, NULL, 'Tipo IVA')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 45360, 1,  3,  4,  3, 0, 1, 1, NULL, 'Desc. Adicional')
/
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (21010, 41080, 1,  4,  1, 12, 0, 0, 0, NULL, 'Observaciones')
/







-- //@UNDO
-- SQL to undo the change goes here.

DELETE FROM portico.tbl_subserv_subserv_ssss
/
DELETE FROM portico.tbl_subservicio_dato_ssdt
/
DELETE FROM portico.tbl_subservicio_ssrv
/
DELETE FROM portico.tbl_servicio_dato_srdt
/
DELETE FROM portico.tbl_servicio_srvc
/
DELETE FROM portico.tbl_servicio_secuencia_srsc
/




DELETE FROM portico.tbl_entidad_tipo_dato_entd WHERE entd_enti_pk IN (
	21001
	, 22001

	, 21002
	, 22002
	, 22003
	, 22004
	, 22005
	, 22006
	, 22007
	, 22008
	, 22009
	, 22010

	, 21003
	, 22011
	, 22012
	, 22015
	, 22016

	, 21005
	, 22013
	, 22014

	, 21007
	, 22018

	, 21008
	, 22019

	, 21009

	, 21010
)
/


DELETE FROM portico.tbl_entidad_grupo_dato_engd WHERE engd_enti_pk IN (
	21001
	, 22001

	, 21002
	, 22002
	, 22003
	, 22004
	, 22005
	, 22006
	, 22007
	, 22008
	, 22009
	, 22010

	, 21003
	, 22011
	, 22012
	, 22015
	, 22016

	, 21005
	, 22013
	, 22014

	, 21007
	, 22018

	, 21008
	, 22019

	, 21009

	, 21010
)
/

