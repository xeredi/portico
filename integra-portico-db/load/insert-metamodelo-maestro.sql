-- TipoParametro-TipoDato
-- TipoParametro-TipoDato
-- TipoParametro-TipoDato

-- Tipos de Actividad
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20001;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20001, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20001;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20001, 43465, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo Actividad Est.');

-- Tipos de Actividad EDI
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20002;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20002, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20002;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20002, 45000, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo Actividad');

-- Acuerdo
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20003;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20003, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20003;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20003, 41000, 1, 1, 1, 4, 1, 1, 1, NULL, 'Aplica Manifiesto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20003, 41001, 1, 1, 2, 4, 1, 1, 1, NULL, 'Aplica Escala');

-- Pais
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20004;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20004, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20004;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20004, 45015, 1, 1, 1, 4, 1, 1, 1, NULL, 'Area Mundial');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20004, 41000, 1, 2, 1, 2, 1, 1, 1, NULL, 'UE?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20004, 41001, 1, 2, 2, 2, 1, 1, 1, NULL, 'Schengen?');

-- Tipo de Buque Est
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20008;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20008, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20008;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20008, 45020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo EEE');

-- Tipo de Buque
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20009;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20009, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20009;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20009, 41000, 1, 1, 1, 4, 1, 1, 1, NULL, 'Roro?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20009, 41001, 1, 2, 2, 4, 1, 1, 1, NULL, 'Comercial?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20009, 45025, 1, 3, 3, 4, 1, 1, 1, NULL, 'Tipo Est');

-- Organizacion
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20010;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20010, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20010;
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20010;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20010, 2, 'Direccion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Nombre');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 43035, 1, 1, 2, 2, 0, 1, 1, NULL, 'Tipo Doc.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41021, 1, 1, 3, 2, 0, 1, 1, NULL, 'Documento');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41022, 1, 2, 1, 6, 0, 0, 0, NULL, 'Descripcion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41023, 2, 1, 1, 6, 0, 0, 0, NULL, 'Direccion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41024, 2, 1, 2, 1, 0, 0, 0, NULL, 'C.P.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 45055, 2, 1, 3, 3, 0, 0, 0, NULL, 'Localidad');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41025, 2, 2, 1, 4, 0, 0, 0, NULL, 'Persona de Contacto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41026, 2, 2, 2, 2, 0, 0, 0, NULL, 'Tlf.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41027, 2, 2, 3, 2, 0, 0, 0, NULL, 'Tlf. 2');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41028, 2, 2, 4, 2, 0, 0, 0, NULL, 'Fax');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41029, 2, 3, 1, 4, 0, 0, 0, NULL, 'Email');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20010, 41030, 2, 3, 2, 4, 0, 0, 0, NULL, 'Web');

-- Tipo de IVA
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20011;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20011, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20011;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20011, 41040, 1, 1, 1, 4, 1, 1, 0, NULL, '%');

-- Zona Costera EEE
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20013;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20013, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20013;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20013, 45005, 1, 1, 1, 4, 1, 1, 1, NULL, 'Pais');

-- Unlocode
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20014;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20014, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20014;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20014, 45005, 1, 1, 1, 4, 1, 1, 1, NULL, 'Pais');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20014, 45045, 1, 1, 2, 4, 1, 1, 1, NULL, 'Area Geografica');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20014, 45050, 1, 1, 3, 4, 1, 1, 1, NULL, 'Zona Costera EEE');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20014, 41040, 1, 2, 1, 1, 0, 0, 0, NULL, 'Latitud');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20014, 41041, 1, 2, 2, 1, 0, 0, 0, NULL, 'Longitud');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20014, 41000, 1, 2, 3, 2, 1, 1, 1, NULL, 'Insular?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20014, 41001, 1, 2, 4, 2, 1, 0, 0, NULL, 'Ceu/Mel/Can?');

-- Tipo de Suministro
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20024;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20024, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20024;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20024, 45040, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo de IVA');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20024, 41000, 1, 2, 2, 4, 1, 1, 1, NULL, 'Avituallamiento?');

-- Tipo de Gasto
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20025;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20025, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20025;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20025, 45040, 1, 1, 1, 4, 0, 1, 1, NULL, 'Tipo de IVA');

-- Tipo de Medio de Remolque
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20027;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20027, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20027;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20027, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Sist. Antiincendios');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20027, 41060, 1, 2, 2, 4, 1, 1, 1, NULL, 'Potencia');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20027, 41021, 1, 3, 3, 4, 1, 1, 1, NULL, 'Tipo Propulsion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20027, 41061, 1, 4, 4, 4, 1, 1, 1, NULL, 'Fuerza Tiro');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20027, 45010, 1, 5, 5, 4, 0, 1, 1, NULL, 'Buque');

-- Tipo de Operacion de Pesca
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20032;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20032, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20032;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20032, 41000, 1, 1, 1, 4, 1, 1, 1, NULL, 'Genera Tasa');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20032, 43000, 1, 2, 2, 4, 0, 1, 1, NULL, 'Cod. Exencion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20032, 43005, 1, 3, 3, 4, 1, 1, 1, NULL, 'Indicador de Venta');

-- Familia de Especie de Pesca
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20036;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20036, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20036;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20036, 45085, 1, 1, 1, 4, 1, 1, 1, NULL, 'Grupo de Familia');

-- Especie de Pesca
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20038;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20038, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20038;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20038, 45090, 1, 1, 1, 4, 1, 1, 1, NULL, 'Familia de Especie de Pesca');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20038, 45095, 1, 2, 2, 4, 0, 1, 1, NULL, 'Tipo de Captura de Pesca');

-- Buque de Pesca
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20040;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20040, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20040;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Nombre');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41021, 1, 1, 2, 2, 0, 0, 0, NULL, 'Callsign');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 45005, 1, 1, 3, 3, 0, 1, 1, NULL, 'Bandera');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41022, 1, 2, 1, 1, 0, 0, 0, NULL, 'Lista');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41023, 1, 2, 2, 1, 0, 1, 1, NULL, 'Matricula');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41024, 1, 2, 3, 1, 0, 0, 0, NULL, 'Folio');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41025, 1, 2, 4, 2, 0, 0, 0, NULL, 'Censo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41040, 1, 2, 5, 1, 1, 1, 0, NULL, 'GT');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41041, 1, 2, 6, 1, 1, 1, 0, NULL, 'Eslora');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41042, 1, 2, 7, 1, 0, 1, 0, NULL, 'Manga');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41043, 1, 2, 8, 1, 0, 0, 0, NULL, 'Cal. Max.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 45035, 1, 3, 1, 4, 0, 1, 1, NULL, 'Consignatario');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 45036, 1, 3, 2, 4, 0, 1, 1, NULL, 'Armador');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 45065, 1, 4, 1, 3, 1, 1, 1, NULL, 'Zona de Pesca');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 45110, 1, 4, 2, 3, 1, 1, 1, NULL, 'Arte de Pesca');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 45100, 1, 4, 3, 3, 1, 1, 1, NULL, 'Tipo de Buque');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20040, 41000, 1, 5, 1, 3, 1, 0, 1, NULL, 'Genera Tasa al Buque');

-- Naturaleza de Mercancia
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20044;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20044, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20044;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20044, 45120, 1, 1, 1, 4, 1, 1, 1, NULL, 'Grupo de Naturaleza');

-- Mercancia
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20049;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20049, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20049;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20049, 45145, 1, 1, 1, 4, 1, 1, 1, NULL, 'U. C.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20049, 45140, 1, 1, 2, 4, 1, 1, 1, NULL, 'G. NST');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20049, 41000, 1, 1, 3, 2, 1, 1, 1, NULL, 'Transporte?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20049, 45135, 1, 2, 1, 4, 1, 1, 1, NULL, 'Subgrupo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20049, 45130, 1, 2, 2, 4, 1, 1, 1, NULL, 'Gr. Aranc.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20049, 45125, 1, 2, 3, 4, 1, 1, 1, NULL, 'Naturaleza');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20049, 41080, 1, 3, 1, 12, 0, 0, 0, NULL, 'Observaciones');

-- Tipo de Equipamiento
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20051;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20051, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20051;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20051, 41000, 1, 1, 1, 2, 1, 1, 1, NULL, 'Roro?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20051, 41020, 1, 2, 2, 2, 1, 1, 1, NULL, 'Tamaño');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20051, 45145, 1, 3, 3, 4, 1, 1, 1, NULL, 'Unidad de Carga');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20051, 45290, 1, 4, 4, 4, 0, 1, 1, NULL, 'Mercancia');

-- Recinto Aduanero
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20054;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20054, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20054;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20054, 45055, 1, 1, 1, 4, 1, 1, 1, NULL, 'Unlocode');

-- Terminal
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20055;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20055, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20055;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20055, 41000, 1, 1, 1, 4, 1, 1, 1, NULL, 'En Concesion?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20055, 45040, 1, 3, 3, 4, 0, 1, 1, NULL, 'Tipo de IVA');

-- Receptor Mercancia
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20056;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20056, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20056;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20056, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Descripcion');

-- Modo de Transporte EDI de Mercancia
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20057;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20057, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20057;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20057, 43125, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo de Transporte');

-- Mercancias Peligrosas
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20058;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20058, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20058;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20058, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Nº ONU');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20058, 41021, 1, 2, 2, 4, 1, 1, 1, NULL, 'Clase');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20058, 41022, 1, 3, 3, 4, 1, 1, 1, NULL, 'Nº Version');

-- Marca Vehiculo
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20059;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20059, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20059;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20059, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Marca');

-- Instalacion Especial
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20061;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20061, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20061;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20061, 45180, 1, 1, 1, 4, 1, 1, 1, NULL, 'Alineacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20061, 45035, 1, 1, 2, 4, 0, 1, 1, NULL, 'Estibador');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20061, 41000, 1, 2, 1, 4, 1, 1, 1, NULL, 'Adicionada Est.?');

-- Provincia
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20062;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20062, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20062;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20062, 45005, 1, 1, 1, 4, 1, 1, 1, NULL, 'Pais');

-- Subpuerto
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20063;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20063, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20063;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20063, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Codigo EDI');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20063, 45055, 1, 2, 2, 4, 1, 1, 1, NULL, 'Unlocode');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20063, 45365, 1, 2, 3, 2, 0, 1, 1, NULL, 'Rec. Adu.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20063, 45040, 1, 3, 3, 4, 0, 1, 1, NULL, 'Tipo de IVA');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20063, 41000, 1, 4, 4, 4, 1, 1, 1, NULL, 'Adicionado Estadisticas?');

-- Tipo de Operacion de Mercancia
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20064;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20064, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20064;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20064, 45040, 1, 1, 1, 4, 0, 1, 1, NULL, 'Tipo de IVA');

-- Tipo de Navegacion
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20065;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20065, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20065;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20065, 45040, 1, 1, 1, 4, 0, 1, 1, NULL, 'Tipo de IVA');

-- Tipo de Error EDI
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20067;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20067, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20067;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20067, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Nivel');

-- Tipo de Canon
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20069;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20069, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20069;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20069, 41040, 1, 2, 2, 4, 0, 1, 0, NULL, '% Actualizacion');

-- Bonificacion FP
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20070;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20070, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20070;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20070, 41020, 1, 1, 1, 4, 0, 1, 1, NULL, 'Articulo de Ley');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20070, 41060, 1, 2, 2, 4, 0, 1, 0, NULL, 'Prioridad');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20070, 41040, 1, 3, 3, 4, 0, 1, 0, NULL, 'Importe');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20070, 41041, 1, 4, 4, 4, 0, 1, 0, NULL, 'Porcentaje');

-- Baremo FP
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20071;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20071, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20071;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20071, 41040, 1, 1, 1, 4, 1, 1, 0, NULL, 'Precio');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20071, 41020, 1, 2, 2, 4, 0, 1, 1, NULL, 'Articulo de Ley');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20071, 41041, 1, 3, 3, 4, 0, 1, 0, NULL, '% Actualizacion');

-- Zona Portuaria
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20072;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20072, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20072;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20072, 45150, 1, 1, 1, 4, 1, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20072, 41040, 1, 2, 2, 4, 0, 1, 0, NULL, 'Superficie Total (m2)');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20072, 41041, 1, 3, 3, 4, 1, 1, 0, NULL, 'Valor');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20072, 41042, 1, 4, 4, 4, 0, 1, 0, NULL, 'Superficie Concesionable (m2)');

-- Tipo de Expediente
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20074;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20074, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20074;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20074, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo General');

-- Tipo de Actividad Concesional
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20077;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20077, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20077;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20077, 45165, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo de Actividad General');

-- Suprabien
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20078;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20078, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20078;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 45150, 1, 1, 1, 4, 1, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41020, 1, 2, 2, 4, 1, 1, 1, NULL, 'Descripcion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 45160, 1, 3, 3, 4, 1, 1, 1, NULL, 'Tipo de Bien');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41021, 1, 4, 4, 4, 0, 1, 1, NULL, 'Referencia');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41000, 1, 5, 5, 4, 1, 1, 1, NULL, 'Obra/Instalacion?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41040, 1, 6, 6, 4, 0, 1, 0, NULL, 'Valor Obra/Instalacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41041, 1, 7, 7, 4, 0, 0, 0, NULL, 'Valor Depr. Obra/Instalacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41042, 1, 8, 8, 4, 0, 0, 0, NULL, 'Vida Util');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41043, 1, 9, 9, 4, 0, 1, 0, NULL, 'Sup. Total (m2)');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41044, 1, 10, 10, 4, 0, 1, 0, NULL, 'Sup. Concesionable (m2)');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41001, 1, 11, 11, 4, 1, 1, 1, NULL, 'Concesionable?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41022, 1, 12, 12, 4, 0, 0, 1, NULL, 'Ref. Catastral');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41045, 1, 13, 13, 4, 0, 0, 0, NULL, 'Valor Catastral');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20078, 41023, 1, 14, 14, 4, 0, 0, 1, NULL, 'Ref. Registral');

-- Garantia
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20079;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20079, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20079;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 45035, 1, 1, 1, 4, 0, 1, 1, NULL, 'Organizacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 45150, 1, 2, 2, 4, 0, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 43010, 1, 3, 3, 4, 1, 1, 1, NULL, 'Tipo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 43015, 1, 4, 4, 4, 1, 1, 1, NULL, 'Clase');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41100, 1, 5, 5, 4, 1, 1, 1, NULL, 'F. Deposito');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41101, 1, 6, 6, 4, 0, 1, 1, NULL, 'F. Devolucion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41102, 1, 7, 7, 4, 0, 1, 1, NULL, 'F. Revision');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41103, 1, 8, 8, 4, 0, 1, 1, NULL, 'F. Caducidad');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41040, 1, 9, 9, 4, 1, 0, 0, NULL, 'Cant. Depositada');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41041, 1, 10, 10, 4, 0, 0, 0, NULL, 'Cant. Devuelta');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41042, 1, 11, 11, 4, 0, 0, 0, NULL, 'Cant. Ejecutada');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41020, 1, 12, 12, 4, 0, 1, 1, NULL, 'Referencia');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20079, 41021, 1, 13, 13, 4, 0, 0, 0, NULL, 'Observaciones');

-- Fase
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20080;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20080, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20080;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20080, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Descripcion');

-- Estado Expediente
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20081;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20081, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20081;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20081, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Estado Base');

-- Registro de Tipo de Buque EEE
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20082;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20082, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20082;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20082, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Descripcion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20082, 45005, 1, 2, 2, 4, 1, 1, 1, NULL, 'Pais');

-- Registro de Tipo de Buque
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20083;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20083, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20083;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20083, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Descripcion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20083, 45170, 1, 1, 2, 4, 0, 1, 1, NULL, 'Registro de Tipo de Buque EEE');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20083, 41021, 1, 2, 1, 4, 1, 1, 0, NULL, 'Poblacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20083, 45005, 1, 2, 2, 4, 1, 1, 1, NULL, 'Pais');

-- Concepto Cuadro Estadistico
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20084;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20084, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20084;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20084, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Periodicidad');

-- Tipo de Buque GT
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20085;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20085, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20085;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20085, 41060, 1, 1, 1, 4, 1, 1, 0, NULL, 'Limite Superior');

-- Servicio de Trafico
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20086;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20086, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20086;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20086, 45150, 1, 1, 1, 4, 1, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20086, 41000, 1, 2, 2, 4, 1, 1, 1, NULL, 'Incrementa Contadores?');

-- Tipo de Residuo
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20088;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20088, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20088;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20088, 41000, 1, 1, 1, 4, 1, 1, 1, NULL, 'Facturable?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20088, 43020, 1, 2, 2, 4, 0, 1, 1, NULL, 'Anexo Marpol');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20088, 43025, 1, 3, 3, 4, 0, 1, 1, NULL, 'Presentacion');

-- Subtipo de Residuo
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20089;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20089, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20089;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20089, 41000, 1, 1, 1, 4, 1, 1, 1, NULL, 'Facturable?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20089, 45185, 1, 2, 2, 4, 1, 1, 1, NULL, 'Tipo de Residuo');

-- Naviera
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20090;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20090, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20090;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20090, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Descripcion');

-- Muelle
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20091;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20091, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20091;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20091, 45150, 1, 1, 1, 4, 1, 1, 1, NULL, 'Subpuerto');

-- Convenio
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20093;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20093, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20093;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20093, 41020, 1, 1, 1, 4, 0, 1, 1, NULL, 'Empresa');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20093, 41021, 1, 2, 2, 4, 0, 1, 1, NULL, 'Codigo EDI');

-- Tipo de Certificado
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20094;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20094, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20094;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20094, 41020, 1, 1, 1, 4, 0, 1, 1, NULL, 'Codigo EDI');

-- Tipo de Buque EDI
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20095;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20095, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20095;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20095, 45030, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo de Buque');

-- Instalacion Deportiva Autonomica
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20100;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20100, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20100;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20100, 45150, 1, 1, 1, 4, 1, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20100, 45055, 1, 2, 2, 4, 0, 1, 1, NULL, 'Puerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20100, 41080, 1, 3, 3, 4, 0, 0, 0, NULL, 'Observaciones');

-- Instalacion Deportiva
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20101;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20101, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20101;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 45150, 1, 1, 1, 4, 1, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 45200, 1, 1, 2, 4, 1, 1, 1, NULL, 'Tipo de Amarre');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 45195, 1, 1, 3, 4, 0, 1, 1, NULL, 'Tipo de Embarcacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41040, 1, 2, 1, 4, 1, 1, 1, NULL, 'Calado Real');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41041, 1, 2, 2, 4, 1, 1, 1, NULL, 'Manga Real');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41042, 1, 2, 3, 4, 1, 1, 1, NULL, 'Eslora Real');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41043, 1, 2, 4, 4, 1, 1, 1, NULL, 'Altura Real');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41044, 1, 3, 1, 4, 1, 0, 0, NULL, 'Calado Maximo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41045, 1, 3, 2, 4, 1, 0, 0, NULL, 'Manga Maximo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41046, 1, 3, 3, 4, 1, 0, 0, NULL, 'Eslora Maximo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41047, 1, 3, 4, 4, 1, 0, 0, NULL, 'Altura Maximo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41048, 1, 4, 1, 4, 0, 0, 0, NULL, 'Calado Minimo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41049, 1, 4, 2, 4, 0, 0, 0, NULL, 'Manga Minimo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41050, 1, 4, 3, 4, 0, 0, 0, NULL, 'Eslora Minimo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41051, 1, 4, 4, 4, 0, 0, 0, NULL, 'Altura Minimo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41000, 1, 5, 1, 4, 1, 1, 1, NULL, 'En Tierra?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20101, 41080, 1, 6, 1, 4, 0, 0, 0, NULL, 'Observaciones');

-- Modulo
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20102;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20102, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20102;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20102, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo');

-- Tipo de Documento
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20103;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20103, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20103;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20103, 45205, 1, 1, 1, 4, 1, 1, 1, NULL, 'Modulo');

-- Buque
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20005;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20005, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20005;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41020, 1,  1,  1, 4, 1, 1, 1, NULL, 'Nombre');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41021, 1,  1,  2, 2, 1, 1, 0, NULL, 'Callsign');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 45005, 1,  1,  3, 3, 1, 1, 1, NULL, 'Bandera');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 45030, 1,  1,  4, 3, 1, 1, 1, NULL, 'Tipo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41100, 1,  2,  1, 2, 0, 0, 0, NULL, 'F. Alta EDI');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41101, 1,  2,  2, 2, 0, 0, 0, NULL, 'F. Validacion EDI');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41000, 1,  2,  3, 2, 0, 0, 1, NULL, 'Pte. Validacion EDI');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41022, 1,  3,  1, 8, 0, 0, 0, NULL, 'Observaciones DUE');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41060, 1,  4,  1, 1, 1, 1, 0, NULL, 'GT');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41061, 1,  4,  2, 1, 0, 0, 0, NULL, 'Uds. Fact.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41062, 1,  4,  3, 1, 0, 1, 0, NULL, 'T.R.B.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41063, 1,  4,  4, 1, 0, 1, 0, NULL, 'T.P.M.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41064, 1,  4,  5, 1, 0, 1, 0, NULL, 'Vol. SBT');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 43060, 1,  4,  6, 2, 0, 1, 0, NULL, 'Uds. SBT');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41040, 1,  4,  7, 1, 0, 0, 0, NULL, 'Cal. Min');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41041, 1,  4,  8, 1, 0, 0, 0, NULL, 'Cal. Max');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41042, 1,  4,  9, 1, 1, 0, 0, NULL, 'Eslora');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41043, 1,  4, 10, 1, 0, 0, 0, NULL, 'Manga');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41044, 1,  4, 11, 1, 0, 0, 0, NULL, 'Alt. Puntal');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41065, 1,  5,  1, 1, 0, 0, 0, NULL, 'Potencia');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41045, 1,  5,  2, 1, 0, 0, 0, NULL, 'Alt. Arb.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41046, 1,  5,  3, 1, 0, 0, 0, NULL, 'Vel. Cruc.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41047, 1,  5,  4, 1, 0, 0, 0, NULL, 'Vel. Max.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41066, 1,  5,  5, 1, 0, 0, 0, NULL, 'Hel. Prop.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41067, 1,  5,  6, 1, 0, 0, 0, NULL, 'Hel. Proa');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41068, 1,  5,  7, 1, 0, 0, 0, NULL, 'Hel. Popa');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41069, 1,  5,  8, 1, 0, 0, 0, NULL, 'Helices');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41070, 1,  5,  9, 1, 0, 0, 0, NULL, 'No. SBT');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41071, 1,  5, 10, 1, 0, 0, 0, NULL, 'Pasarelas');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41001, 1,  6,  1, 2, 1, 0, 0, NULL, 'Doble Casco?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41002, 1,  6,  2, 2, 1, 0, 0, NULL, 'Cert. Capitania?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41003, 1,  6,  3, 2, 1, 0, 0, NULL, 'Insp. MOU/PSC?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41048, 1,  7,  1, 2, 0, 0, 0, NULL, 'Carga Max (Cap.)');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41049, 1,  7,  2, 2, 0, 0, 0, NULL, 'Carga Max (Lng.)');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41072, 1,  7,  3, 2, 0, 0, 0, NULL, 'Tripulacion Max');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41073, 1,  7,  4, 2, 0, 0, 0, NULL, 'Pasaje Max');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41102, 1,  8,  1, 2, 0, 0, 0, NULL, 'F. Construccion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41023, 1,  8,  2, 4, 0, 0, 0, NULL, 'Sociedad Clasificacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41024, 1,  8,  3, 4, 0, 0, 0, NULL, 'Aseguradora');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41025, 1,  9,  1, 4, 0, 0, 0, NULL, 'Club PI');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 45006, 1, 10,  1, 3, 1, 1, 0, NULL, 'Pais de Registro');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 45175, 1, 10,  2, 3, 0, 1, 0, NULL, 'Tipo de Registro');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 45035, 1, 10,  3, 4, 0, 1, 0, NULL, 'Armador');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41026, 1, 11,  1, 4, 0, 0, 0, NULL, 'Libro Registro');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41027, 1, 11,  2, 8, 0, 0, 0, NULL, 'Direccion. Naviera');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41028, 1, 12,  1, 4, 0, 0, 0, NULL, 'No. Certificado GT');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41103, 1, 12,  2, 2, 1, 0, 0, NULL, 'F. Seg. Resp. Civil');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41004, 1, 12,  3, 2, 1, 1, 1, NULL, 'Nav. Int.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41005, 1, 12,  4, 2, 1, 1, 1, NULL, 'Op. Comer.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41006, 1, 13,  1, 2, 0, 0, 0, NULL, 'Insp. MOU/PSC');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41104, 1, 13,  2, 2, 0, 0, 0, NULL, 'Fecha Ult. Inspeccion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41074, 1, 13,  3, 2, 0, 0, 0, NULL, 'No. Defic. Pte.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 45055, 1, 13,  4, 4, 0, 0, 0, NULL, 'Puerto Ultima Inspeccion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20005, 41080, 1, 16, 1, 12, 0, 0, 0, NULL, 'Observaciones');

-- Autoridad Portuaria
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20107;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20107, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20107;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20107, 45055, 1, 1, 1, 4, 0, 1, 0, NULL, 'Localidad');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20107, 45210, 1, 2, 2, 4, 0, 1, 1, NULL, 'A. P. Padre');

-- Unidad de Carga
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20048;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20048, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20048;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20048, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo EEE');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20048, 41000, 1, 2, 2, 4, 1, 1, 1, NULL, 'EEE?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20048, 41040, 1, 3, 3, 4, 0, 1, 0, NULL, 'Nº TEUS');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20048, 45115, 1, 4, 4, 4, 1, 1, 1, NULL, 'Tipo de Mercancia');

-- Comprador de Pesca
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20108;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20108, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20108;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20108, 41020, 1, 1, 1, 4, 1, 1, 1, NULL, 'NIF');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20108, 41021, 1, 1, 2, 4, 1, 1, 1, NULL, 'Descripcion');

-- Alineacion
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20109;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20109, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20109;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 45190, 1, 1, 1, 3, 1, 1, 1, NULL, 'Muelle');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 45060, 1, 1, 2, 3, 1, 1, 1, NULL, 'Tipo de Alin.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41040, 1, 2, 1, 1, 0, 1, 0, NULL, 'Noray I.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41041, 1, 2, 2, 1, 0, 1, 0, NULL, 'Noray F.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41042, 1, 2, 3, 1, 1, 1, 0, NULL, 'Calado');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41043, 1, 2, 4, 1, 0, 1, 0, NULL, 'Longitud');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41044, 1, 2, 5, 1, 0, 1, 0, NULL, 'Anchura');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41000, 1, 3, 1, 2, 1, 1, 1, NULL, 'En Concesion?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41001, 1, 3, 2, 2, 1, 1, 1, NULL, 'De Particulares?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41002, 1, 3, 3, 2, 1, 1, 1, NULL, 'Ag. en Concesion?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20109, 41003, 1, 3, 4, 2, 1, 1, 1, NULL, 'Zona del Puerto?');

-- Tipo de Organizacion
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20106;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20106, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20106;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20106, 43040, 1, 1, 1, 2, 1, 1, 1, NULL, 'Tipo Base');

-- Redes
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20110;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20110, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20110;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 45150, 1, 1, 1, 2, 1, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 41020, 1, 1, 2, 6, 0, 1, 1, NULL, 'Nombre');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 43045, 1, 2, 1, 1, 1, 1, 1, NULL, 'Tipo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 43050, 1, 2, 2, 1, 0, 1, 1, NULL, 'Subtipo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 45035, 1, 2, 3, 4, 1, 1, 1, NULL, 'Proveedor');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 41021, 1, 2, 4, 4, 0, 1, 1, NULL, 'No. Poliza');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 41060, 1, 3, 1, 1, 1, 1, 1, NULL, 'Potencia');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 41022, 1, 3, 2, 4, 0, 1, 1, NULL, 'Tarifa');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 41040, 1, 3, 3, 2, 0, 1, 1, NULL, 'Coste Unitario');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20110, 41080, 1, 4, 1, 12, 0, 0, 0, NULL, 'Observaciones');

-- Zona de Deposito
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20111;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20111, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20111;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 45150, 1, 1, 1, 4, 1, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 45250, 1, 1, 2, 4, 0, 1, 1, NULL, 'Tipo de Superficie');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 43000, 1, 1, 3, 4, 1, 1, 1, NULL, 'Cod. Exencion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 45255, 1, 2, 1, 4, 0, 1, 1, NULL, 'Grupo Zona');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 41000, 1, 2, 2, 2, 1, 1, 1, NULL, 'Ro-Ro');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 41001, 1, 2, 3, 2, 1, 1, 1, NULL, 'Zona Muelles');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 41060, 1, 2, 4, 2, 0, 1, 0, NULL, 'Superficie');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 41061, 1, 2, 5, 1, 0, 1, 0, NULL, 'Altura');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20111, 41062, 1, 2, 6, 1, 0, 1, 0, NULL, 'Plantas');

-- Contador
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20113;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20113, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk = 20113;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 45150, 1, 1, 1, 3, 0, 1, 1, NULL, 'Subpuerto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 45400, 1, 1, 2, 3, 1, 1, 1, NULL, 'Tipo');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 43545, 1, 1, 3, 3, 1, 1, 1, NULL, 'Estado');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41000, 1, 1, 4, 2, 1, 1, 1, NULL, 'Para Buques?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41020, 1, 2, 1, 9, 0, 1, 0, NULL, 'Fabricante');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41060, 1, 2, 2, 2, 0, 1, 0, NULL, 'Año Fabricacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41061, 1, 3, 1, 2, 0, 1, 0, NULL, 'Pot. Máx.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41062, 1, 3, 2, 2, 0, 1, 0, NULL, 'Dígitos');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41040, 1, 3, 3, 2, 1, 1, 0, NULL, 'Factor Multiplicador');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41100, 1, 4, 1, 2, 0, 1, 0, NULL, 'F. Compra');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41101, 1, 4, 2, 2, 0, 1, 0, NULL, 'F. Fin Garantia');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41102, 1, 4, 3, 2, 1, 1, 0, NULL, 'F. Instalacion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20113, 41103, 1, 4, 4, 2, 0, 1, 0, NULL, 'F. Vida Estimada');

-- Tipo de Atraque EDI
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20115;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20115, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk = 20115;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20115, 45380, 1, 1, 1, 4, 1, 1, 1, NULL, 'Tipo de Atraque');

-- Municipio
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20116;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20116, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20116;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20116, 45430, 1, 1, 1, 3, 1, 1, 1, NULL, 'Provincia');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20116, 41020, 1, 1, 2, 6, 0, 0, 0, NULL, 'Dirección de Contacto');

-- Tipo de Buque GT EEE
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=20117;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (20117, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=20117;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (20117, 41060, 1, 1, 1, 2, 1, 1, 0, NULL, 'Limite Inf.');










-- TipoSubparametro-TipoDato
-- TipoSubparametro-TipoDato
-- TipoSubparametro-TipoDato

-- Trafico Buque
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=24000;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (24000, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=24000;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24000, 41040, 1, 1, 1, 2, 0, 1, 0, NULL, 'Nº Puertos/semana');

-- Capacidad Buque
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=24001;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (24001, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=24001;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24001, 41040, 1, 1, 1, 2, 1, 1, 0, NULL, 'Capacidad Máx.');

-- Subpuerto Buque
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=24003;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (24003, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=24003;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24003, 45035, 1, 1, 1, 4, 0, 1, 1, NULL, 'Consignatario');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24003, 41000, 1, 1, 2, 2, 1, 1, 0, NULL, 'Base en Puerto?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24003, 41001, 1, 1, 3, 2, 1, 1, 0, NULL, 'Plan Residuos Liq.?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24003, 41002, 1, 1, 4, 2, 1, 1, 0, NULL, 'Plan Residuos Sól.?');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24003, 41080, 1, 2, 1, 11, 0, 0, 0, NULL, 'Observaciones');

-- Subpuerto Organizacion
DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk=24010;
INSERT INTO tbl_entidad_grupo_dato_engd (engd_enti_pk, engd_numero, engd_etiqueta) VALUES (24010, 1, 'General');
DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk=24010;
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41023, 1, 1, 1, 6, 0, 1, 0, NULL, 'Direccion');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41024, 1, 1, 2, 1, 0, 1, 0, NULL, 'C.P.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 45055, 1, 1, 3, 3, 0, 1, 0, NULL, 'Localidad');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41025, 1, 2, 1, 4, 0, 1, 0, NULL, 'Persona de Contacto');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41026, 1, 2, 2, 2, 0, 1, 0, NULL, 'Tlf.');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41027, 1, 2, 3, 2, 0, 0, 0, NULL, 'Tlf. 2');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41028, 1, 2, 4, 2, 0, 0, 0, NULL, 'Fax');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41029, 1, 3, 1, 4, 0, 0, 0, NULL, 'Email');
INSERT INTO tbl_entidad_tipo_dato_entd (entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto, entd_etiqueta)
VALUES (24010, 41030, 1, 3, 2, 4, 0, 0, 0, NULL, 'Web');
