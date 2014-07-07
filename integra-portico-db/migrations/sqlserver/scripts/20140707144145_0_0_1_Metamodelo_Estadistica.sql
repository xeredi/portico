-- // 0 0 1 Metamodelo Estadistica
-- Migration SQL that makes the change goes here.

-- Actividad Pesquera
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 45095, 1, 1, 1, 4, 1, 1, 1, NULL, 'T. Captura')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 41060, 1, 1, 2, 2, 1, 1, 1, NULL, 'Kilos')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 41040, 1, 1, 3, 2, 1, 1, 1, NULL, 'Precio')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 45070, 1, 2, 1, 4, 0, 1, 1, NULL, 'T. Oper.')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 45215, 1, 2, 2, 4, 0, 1, 1, NULL, 'Especie')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 45110, 1, 2, 3, 4, 0, 1, 1, NULL, 'Arte')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 45065, 1, 3, 1, 4, 0, 1, 1, NULL, 'Zona')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23000, 45035, 1, 3, 2, 4, 0, 1, 1, NULL, 'Vendedor')
/
-- Agregacion de Escala
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45000, 1, 1, 1, 4, 1, 1, 1, NULL, 'T. Activ.')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45230, 1, 1, 2, 4, 1, 1, 1, NULL, 'T. Buque GT')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45030, 1, 1, 3, 4, 1, 1, 1, NULL, 'T. Buque')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45235, 1, 2, 1, 4, 1, 1, 1, NULL, 'T. Nav. Entrada')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45236, 1, 2, 2, 4, 1, 1, 1, NULL, 'T. Nav. Salida')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45005, 1, 2, 3, 4, 1, 1, 1, NULL, 'Pais')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 41060, 1, 2, 3, 2, 1, 1, 1, NULL, 'No. Escalas')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 41061, 1, 2, 4, 2, 1, 1, 1, NULL, 'No. GTs')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45010, 1, 3, 1, 4, 0, 1, 1, NULL, 'Buque')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 43115, 1, 3, 2, 4, 0, 1, 1, NULL, 'T. Estancia')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45240, 1, 3, 3, 4, 0, 1, 1, NULL, 'Serv. Trafico')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45245, 1, 4, 1, 4, 0, 1, 1, NULL, 'Acuerdo')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23001, 45035, 1, 4, 2, 4, 0, 1, 1, NULL, 'Consignatario')
/
-- Agregacion de Superficie
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23002, 45260, 1, 1, 1, 4, 1, 1, 1, NULL, 'Zona Deposito')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23002, 45265, 1, 1, 2, 4, 1, 1, 1, NULL, 'Unidad de Superficie')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23002, 45115, 1, 1, 3, 4, 0, 1, 1, NULL, 'Tipo de Mercancia')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23002, 45270, 1, 2, 1, 4, 0, 1, 1, NULL, 'T. Op. Superficie')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23002, 45035, 1, 2, 2, 4, 0, 1, 1, NULL, 'Cliente')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23002, 41000, 1, 2, 3, 2, 0, 1, 1, NULL, 'Ro-Ro')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23002, 41060, 1, 2, 4, 2, 1, 1, 0, NULL, 'Unidades')
/
-- Avituallamiento
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23003, 45275, 1, 1, 1, 4, 1, 1, 1, NULL, 'T. Suministro')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23003, 41060, 1, 1, 2, 2, 1, 1, 1, NULL, 'Toneladas')
/
-- Buque Fondeo atraque
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 45380, 1, 1, 1, 4, 1, 1, 1, NULL, 'T. Atraque')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 45035, 1, 1, 2, 4, 0, 1, 1, NULL, 'Consignatario')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 45010, 1, 1, 3, 4, 0, 1, 1, NULL, 'Buque')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 45240, 1, 2, 1, 4, 0, 1, 1, NULL, 'Trafico')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 45180, 1, 2, 2, 4, 0, 1, 1, NULL, 'Alineacion')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 41060, 1, 3, 1, 2, 1, 1, 0, NULL, 'No Buques')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 41061, 1, 3, 2, 2, 1, 1, 0, NULL, 'Esloras')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 41062, 1, 3, 3, 2, 1, 1, 0, NULL, 'Esloras-Dias')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 41063, 1, 3, 4, 2, 1, 1, 0, NULL, 'GTs')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23004, 41064, 1, 3, 5, 2, 1, 1, 0, NULL, 'GTs-Dias')
/
-- Movimiento Mercancia
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45285, 1, 1, 1, 4, 1, 1, 1, NULL, 'T. Operacion BL')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45055, 1, 1, 2, 4, 1, 1, 1, NULL, 'Puerto Carga')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45056, 1, 1, 3, 4, 1, 1, 1, NULL, 'Puerto Descarga')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45180, 1, 2, 1, 4, 1, 1, 1, NULL, 'Alineacion')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45057, 1, 2, 2, 4, 1, 1, 1, NULL, 'Origen')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45058, 1, 2, 3, 4, 1, 1, 1, NULL, 'Destino')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45290, 1, 3, 1, 4, 0, 1, 1, NULL, 'Mercancia')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45235, 1, 3, 2, 4, 1, 1, 1, NULL, 'T. Navegacion')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45145, 1, 3, 3, 4, 1, 1, 1, NULL, 'U. Carga')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45300, 1, 4, 1, 4, 1, 1, 1, NULL, 'Inst. Especial')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 43125, 1, 4, 2, 4, 1, 1, 1, NULL, 'T. Transporte')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 41000, 1, 4, 3, 2, 1, 1, 1, NULL, 'Ro-Ro')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 41040, 1, 5, 1, 2, 1, 1, 1, NULL, 'Toneladas')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 41060, 1, 5, 2, 2, 1, 1, 1, NULL, 'Unidades')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 41041, 1, 5, 3, 2, 1, 1, 1, NULL, 'TEUS')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45035, 1, 6, 1, 4, 0, 1, 1, NULL, 'Estibador')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45036, 1, 6, 2, 4, 0, 1, 1, NULL, 'Consignatario')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45010, 1, 6, 3, 4, 0, 1, 1, NULL, 'Buque')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45240, 1, 7, 1, 4, 0, 1, 1, NULL, 'Trafico')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45245, 1, 7, 2, 4, 0, 1, 1, NULL, 'Acuerdo')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 45305, 1, 7, 3, 4, 0, 1, 1, NULL, 'Terminal')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23005, 41020, 1, 8, 1, 4, 0, 1, 1, NULL, 'T. Equipamiento')
/
-- Movimiento de Mercancia EEE
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 45055, 1, 1, 1, 4, 1, 1, 1, NULL, 'Puerto Carga-Descarga')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 45290, 1, 1, 2, 4, 1, 1, 1, NULL, 'Mercancia')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 45145, 1, 1, 3, 4, 1, 1, 1, NULL, 'U.C.')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 45140, 1, 2, 1, 4, 1, 1, 1, NULL, 'G. NST')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 45170, 1, 2, 2, 4, 1, 1, 1, NULL, 'Reg. T. Buque EEE')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 43130, 1, 2, 3, 4, 1, 1, 1, NULL, 'Dir. Mercancia')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 41000, 1, 3, 1, 2, 1, 1, 1, NULL, 'Ro-Ro')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 41040, 1, 4, 1, 2, 1, 1, 1, NULL, 'Toneladas')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 41060, 1, 4, 2, 2, 1, 1, 1, NULL, 'PAX')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 41061, 1, 4, 3, 2, 1, 1, 1, NULL, 'PAX Crucero')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 41062, 1, 4, 4, 2, 1, 1, 1, NULL, 'PAX I-F')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 41063, 1, 4, 5, 2, 1, 1, 1, NULL, 'U.C. Llenas')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23006, 41064, 1, 4, 6, 2, 1, 1, 1, NULL, 'U.C. Vacias')
/
-- Movimiento Tipo Buque EEE
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23007, 45020, 1, 1, 1, 4, 1, 1, 1, NULL, 'T. Buque EEE')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23007, 45445, 1, 1, 2, 4, 1, 1, 1, NULL, 'T. Buque GT EEE')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23007, 41060, 1, 1, 3, 2, 1, 1, 1, NULL, 'No. Buques')
/
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (23007, 41061, 1, 1, 4, 2, 1, 1, 1, NULL, 'No. GTs')
/


-- //@UNDO
-- SQL to undo the change goes here.

-- Tipo Estadistica Tipo Dato
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23000
/
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23001
/
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23002
/
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23003
/
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23004
/
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23005
/
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23006
/
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=23007
/


