Alter table G3_EQUIPAMIENTO MODIFY NUMBULTOS number(7);


-- insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('GR', 'FLS', 'GRFLS', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('FR', 'EAV', 'FREAV', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('FR', 'EUV', 'FREUV', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('ES', 'ACU', 'ESACU', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
-- insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('ZZ', 'ZAB', 'ZZZAB', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('CN', 'BYQ', 'CNBYQ', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('MD', 'GIU', 'MDGIU', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('CF', 'TOG', 'CFTOG', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('CA', 'PNO', 'CAPNO', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);
-- insert into m_puerto (CODPAIS, CODPUE, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF, INDCANARIAS, INDPROVTEN, INDBALEARES, INDESPUERTO) values ('ZZ', '***', 'ZZ***', SYSDATE, NULL, NULL, NULL, 0, 0, 0, 0);


-- select * from G3_TIPOBULTO;

insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '1A'	, 'BIDÓN DE ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '1B'	, 'BIDÓN DE ALUMINIO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '1D'	, 'BIDÓN DE CONTRACHAPADO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '1G'	, 'BIDÓN DE CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '1W'	, 'BIDÓN DE MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2C'	, 'TONEL DE MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '3A'	, 'JERRICÁN DE ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '3H'	, 'JERRICÁN DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '43'	, 'CONTENEDOR PLEGABLE PARA GRANELES');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4A'	, 'CAJA DE ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4B'	, 'CAJA DE ALUMINIO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4C'	, 'CAJA DE MADERA NATURAL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4D'	, 'CAJA DE CONTRACHAPADO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4F'	, 'CAJA DE MADERA RECONSTITUIDA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4G'	, 'CAJA DE PANELES DE FIBRAS');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4H'	, 'CAJA DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '5H'	, 'SACO DE TEJIDO PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '5L'	, 'SACO DE TELA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '5M'	, 'SACO DE PAPEL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '6H'	, 'ENVASE COMPUESTO, RECIPIENTE DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '6P'	, 'ENVASE COMPUESTO, RECIPIENTE DE VIDRIO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AA'	, 'RECIP INTERMEDIO GRANELES, PLÁSTICO RÍG.');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AB'	, 'RECIPIENTE DE CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AC'	, 'RECIPIENTE DE PAPEL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AD'	, 'RECIPIENTE DE MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AF'	, 'PALETA MODULAR, ANILLOS DE 80x60 CM.');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AG'	, 'PALETA, FUNDA TERMORRETRÁCTIL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AI'	, 'BLÍSTER DOBLE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AJ'	, 'CONO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AV'	, 'CÁPSULA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'BM'	, 'BARREÑO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'BW'	, 'CAJA, PARA LÍQUIDOS');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'CD'	, 'LATA, CON ASA Y PICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'CM'	, 'CARTA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'CN'	, 'CONTENEDOR, NO ESPECIFICADO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'CQ'	, 'CARTUCHO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'CW'	, 'JAULA DESLIZANTE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DA'	, 'CAJÓN, DE PLÁSTICO, MULTICAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DB'	, 'CAJÓN, DE MADERA, MULTICAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DC'	, 'CAJÓN, DE CARTÓN, MULTICAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DG'	, 'JAULA CHEP');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DH'	, 'CAJA CHEP');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DI'	, 'BIDÓN DE HIERRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DK'	, 'CAJA, DE CARTÓN, PARA GRANELES');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DL'	, 'CAJÓN, DE PLÁSTICO, PARA GRANELES');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DM'	, 'CAJÓN, DE MADERA, PARA GRANELES');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DN'	, 'GENERADOR DE AEROSOL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DS'	, 'BANDEJA, DE PLÁSTICO, UN NIVEL, SIN TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DT'	, 'BANDEJA, DE MADERA, UN NIVEL, SIN TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DU'	, 'BANDEJA, DE POLIESTI, UN NIVEL, SIN TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DV'	, 'BANDEJA, DE CARTÓN, UN NIVEL, SIN TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DW'	, 'BANDEJA, DE PLÁSTICO, 2 NIVEL, SIN TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DX'	, 'BANDEJA, DE MADERA, 2 NIVEL, SIN TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'DY'	, 'BANDEJA, DE CARTÓN, 2 NIVEL, SIN TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'EC'	, 'SACO, DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ED'	, 'CAJA, CON BASE DE PALETA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'EE'	, 'CAJA, CON BASE DE PALETA, DE MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'EF'	, 'CAJA, CON BASE DE PALETA, DE CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'EG'	, 'CAJA, CON BASE DE PALETA, DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'EH'	, 'CAJA, CON BASE DE PALETA, DE METAL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'EI'	, 'CAJA ISOTÉRMICA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'FT'	, 'ENVASE PARA ALIMENTOS');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'FX'	, 'SACO, FLEXIBLE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'GR'	, 'RECIPIENTE, DE VIDRIO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'HA'	, 'CESTO, CON ASA, DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'HB'	, 'CESTO, CON ASA, DE MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'HC'	, 'CESTO, CON ASA, DE CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IA'	, 'EMBALAJE, EXPOSITOR, DE MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IB'	, 'EMBALAJE, EXPOSITOR, DE CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IC'	, 'EMBALAJE, EXPOSITOR, DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ID'	, 'EMBALAJE, EXPOSITOR, DE METAL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IE'	, 'EMBALAJE, CON VENTANA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IF'	, 'EMBALAJE, TUBULAR');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IG'	, 'EMBALAJE, FORRADO DE PAPEL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IH'	, 'BIDÓN, DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'IK'	, 'EMBALAJE, DE CARTÓN, CON ORIFICIOS');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'LV'	, 'CONTENEDOR');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'MR'	, 'RECIPIENTE, DE METAL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'MW'	, 'RECIPIENTE, FORRADO DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'NA'	, 'SIN OBJETO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'NF'	, 'NO EMBALADO NI ACONDICIONADO, UNIDAD ÚNI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'NG'	, 'NO EMBALADO NI ACONDICIONADO, VARIAS UNI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'NU'	, 'RED, TUBULAR, DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'NV'	, 'RED, TUBULAR, DE TELA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'PB'	, 'PALETA CAJA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'PD'	, 'PALETA, MODULAR, AROS DE 80x100 CM.');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'PE'	, 'PALETA, MODULAR, ANILLOS DE 80x120 CM.');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'PF'	, 'CELDA SIN TECHO PARA TRANSPORTE ANIMALE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'PJ'	, 'CANASTILLA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'PR'	, 'RECIPIENTE, DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'PV'	, 'TUBOS, EN HAZ/ATADO/FAJO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QA'	, 'BIDÓN, DE ACERO, PARTE SUPERIOR FIJA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QB'	, 'BIDÓN, DE ACERO, PARTE SUPERIOR AMOVIBLE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QC'	, 'BIDÓN, DE ALUMINIO, PARTE SUPERIOR FIJA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QD'	, 'BIDÓN, DE ALUMINIO, PARTE SUPERIOR AMOVI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QF'	, 'BIDÓN, DE PLÁSTICO, PARTE SUPERIOR FIJA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QG'	, 'BIDÓN, DE PLÁSTICO, PARTE SUPERIOR AMOVI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QH'	, 'TONEL, DE MADERA, CON BITOQUE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QJ'	, 'TONEL, DE MADERA, PARTE SUPERIOR FIJA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QK'	, 'JERRICÁN, DE ACERO, PARTE SUPERIOR FIJA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QL'	, 'JERRICÁN, DE ACERO, PARTE SUPERIOR REMOV');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QM'	, 'JERRICÁN, PLÁSTICO, PARTE SUPERIOR FIJA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QN'	, 'JERRICÁN, PLÁSTICO, PARTE SUPERIOR REMOV');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QP'	, 'CAJA, DE MADERA, ORDINARIA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QQ'	, 'CAJA, DE MADERA, PANELES ESTANCOS POLVO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QR'	, 'CAJA, DE PLÁSTICO EXPANDIDO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'QS'	, 'CAJA, DE PLÁSTICO RÍGIDO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'RJ'	, 'ARMARIO ROPERO, MÓVIL');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'RK'	, 'ESTANTE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'SB'	, 'LÁMINA CALANDRADA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'SO'	, 'CANILLA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'SP'	, 'HOJA, REVESTIMIENTO DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'SS'	, 'CAJÓN, DE ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'SV'	, 'FUNDA, DE ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'SX'	, 'SURTIDO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'SY'	, 'MANGA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'TI'	, 'CUBA MEDIANA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'TL'	, 'CUBA, CON TAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'TV'	, 'TUBO CON BOQUILLA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'UC'	, 'NO ENJAULADO (ANIMAL)');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'VK'	, 'CONTENEDOR DE TIPO VANPACK');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WA'	, 'RECIPIENTE INTERMEDIO PARA GRANELES');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WC'	, 'RECIPIENTE INTERMEDIO GRANELES, ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WD'	, 'RECIPIENTE INTERMEDIO GRANELES, ALUMINIO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WF'	, 'RECIPIENTE INTERMEDIO GRANELES, METÁLICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WG'	, 'RIG, ACERO, PRESIONES>10 KPA (0,1 BAR)');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WH'	, 'RIG, ALUMIN., PRESIONES>10 KPA (0,1 BAR)');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WJ'	, 'RIG, METÁLIC, PRESIONES>10 KPA (0,1 BAR)');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WK'	, 'RI GRANELES LÍQUIDOS, DE ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WL'	, 'RI GRANELES LÍQUIDOS, DE ALUMINIO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WM'	, 'RI GRANELES LÍQUIDOS, METÁLICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WN'	, 'RIG, TEJIDO DE PLÁSTICO, SIN REVESTIMIEN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WP'	, 'RIG, TEJIDO DE PLÁSTICO, CON REVESTIMIEN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WQ'	, 'RIG, TEJIDO DE PLÁSTICO, CON FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WR'	, 'RIG, TEJIDO PLÁSTICO, REVEST. Y FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WS'	, 'RIG, DE PELÍCULA PLÁSTICA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WT'	, 'RIG, DE TELA, SIN REVEST. NI FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WU'	, 'RIG, DE MADERA, CON FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WV'	, 'RIG, DE TELA, CON REVESTIMIENTO INTERIOR');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WW'	, 'RIG, DE TELA, CON FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WX'	, 'RIG, DE TELA, CON REVESTIMIENTO Y FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WY'	, 'RIG, DE CONTRACHAPADO, CON FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'WZ'	, 'RIG, DE MADERA RECONSTITUIDA, CON FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XA'	, 'SACO, DE TEJIDO DE PLÁSTICO, SIN REVEST.');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XB'	, 'SACO, TEJIDO DE PLÁSTICO, ESTANCO POLVO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XC'	, 'SACO, TEJIDO DE PLÁSTICO, HIDRÓFUGO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XD'	, 'SACO, DE PELÍCULA DE PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XF'	, 'SACO, DE TELA, SIN REVESTI. NI FORRO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XG'	, 'SACO, DE TELA, ESTANCO AL POLVO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XH'	, 'SACO, DE TELA, HIDRÓFUGO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XJ'	, 'SACO, DE PAPEL, MULTICAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'XK'	, 'SACO, DE PAPEL, MULTICAPA, HIDRÓFUGO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YA'	, 'EC, RECIP. PLÁSTICO BIDÓN EXTERIOR ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YB'	, 'EC, RECIP. PLÁSTICO CAJA EXTERIOR ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YC'	, 'EC, RECIP. PLÁSTICO BIDÓN EXTERIOR ALUMI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YD'	, 'EC, RECIP. PLÁSTICO CAJA EXTERIOR ALUMI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YF'	, 'EC, RECIP. PLÁSTICO CAJA EXTERIOR MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YG'	, 'EC, RECIP. PLÁSTICO BIDÓN EXT. CONTRACH');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YH'	, 'EC, RECIP. PLÁSTICO CAJA EXT. CONTRACH');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YJ'	, 'EC, RECIP. PLÁSTICO BIDÓN EXT. CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YK'	, 'EC, RECIP. PLÁSTICO CAJA EXT. CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YL'	, 'EC, RECIP. PLÁSTICO BIDÓN EXT. PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YM'	, 'EC, RECIP. PLÁSTICO CAJA EXT. PLÁSTICO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YN'	, 'EC, RECIP. VIDRIO, BIDÓN EXTERIOR ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YP'	, 'EC, RECIP. VIDRIO, CAJA EXTERIOR ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YQ'	, 'EC, RECIP. VIDRIO, BIDÓN EXTERIOR ALUMIN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YR'	, 'EC, RECIP. VIDRIO, CAJA EXTERIOR ALUMIN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YS'	, 'EC, RECIP. VIDRIO, CAJA EXTERIOR MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YT'	, 'EC, RECIP. VIDRIO, BIDÓN EXT CONTRACHAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YV'	, 'EC, RECIP. VIDRIO, CESTO EXTERIOR MIMBRE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YW'	, 'EC, RECIP. VIDRIO, BIDÓN EXTERIOR CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YX'	, 'EC, RECIP. VIDRIO, CAJA EXTERIOR CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YY'	, 'EC, RECIP. VIDRIO, EMBAL EXT PLÁST EXPAN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'YZ'	, 'EC, RECIP. VIDRIO, EMBAL EXT PLÁST RÍGID');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'Z1'	, 'PALET');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZA'	, 'RIG, DE PAPEL MULTICAPA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZB'	, 'SACO, DE GRAN TAMAÑO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZC'	, 'RIG, DE PAPEL MULTICAPA, HIDRÓFUGO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZD'	, 'RIG SÓLIDOS, PLÁSTICO RÍGIDO CON ELEM.');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZF'	, 'RIG SÓLIDOS, PLÁSTICO RÍGIDO, EXENTO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZG'	, 'RIG, PLÁSTICO RÍGIDO, ELEM. ESTR., PRESU');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZH'	, 'RIG, PLÁSTICO RÍGIDO, EXENTO, PRESURIZAD');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZJ'	, 'RIG, PLÁSTICO RÍGIDO, ELEMENTOS ESTRUCTU');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZK'	, 'RIG, PLÁSTICO RÍGIDO, EXENTO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZL'	, 'RIG SÓLIDOS, MATERIAL COMP, RECIP. INTER');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZM'	, 'RIG SÓLIDOS, MATERIAL COMP, PLÁST. FLEXI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZN'	, 'RI, MATERIAL COMP,RI PLÁS.RÍG PRESURIZAD');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZP'	, 'RI, MATERIAL COMP,RI PLÁS.FLEX. PRESURIZ');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZQ'	, 'RIG LÍQUIDOS, MATERIAL COMP. RI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZR'	, 'RIG LÍQUIDOS, MATERIAL COMP. RI');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZS'	, 'RIG DE MATERIAL COMPUESTO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZT'	, 'RIG, DE CARTÓN');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZU'	, 'RIG, FLEXIBLE');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZV'	, 'RIG, DE METAL DISTINTO DEL ACERO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZW'	, 'RIG, DE MADERA');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZX'	, 'RIG, DE CONTRACHAPADO');
insert into G3_TIPOBULTO (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ZY'	, 'RIG, DE MADERA RECONSTITUIDA');



-- select * from G3_TIPOTAMEQUIP;

insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2300', '2300');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2451', '2451');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2476', '2476');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '25U5', '25U5');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '28U3', '28U3');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '29U1', '29U1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2CU2', '2CU2');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2DP1', '2DP1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2EB0', '2EB0');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2EG3', '2EG3');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2EP1', '2EP1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2EU1', '2EU1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '2NG1', '2NG1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '3CT0', '3CT0');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '40U5', '40U5');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '45H0', '45H0');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '48P5', '48P5');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '48U2', '48U2');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '48UO', '48UO');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '49P0', '49P0');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '49U2', '49U2');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4EG2', '4EG2');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4EP1', '4EP1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4FG1', '4FG1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, '4NR1', '4NR1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ACU1', 'ACU1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'AEU3', 'AEU3');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ANG3', 'ANG3');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'ANU3', 'ANU3');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'APG1', 'APG1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'G9P0', 'G9P0');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'GNU3', 'GNU3');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'H0U1', 'H0U1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'HEU1', 'HEU1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'HFP1', 'HFP1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'L4R0', 'L4R0');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'LDG1', 'LDG1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'LDG2', 'LDG2');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'LEU1', 'LEU1');
insert into G3_TIPOTAMEQUIP (usralta, USRMODIF, FECALTA, FECMODIF, codigo, descripcion) values (NULL, NULL, SYSDATE, null, 'LPG3', 'LPG3');

