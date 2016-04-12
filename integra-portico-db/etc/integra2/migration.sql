-- CREACION DE SINONIMOS PARA LAS TABLAS DE INTEGRA1
DECLARE
	CURSOR c IS SELECT table_name FROM all_tables WHERE owner = 'INTEGRA';
	cmd VARCHAR2(200);
BEGIN
	FOR t IN c LOOP
		cmd := 'CREATE SYNONYM ' || t.table_name || ' FOR integra.' || t.table_name;
		EXECUTE IMMEDIATE cmd;
	END LOOP;
END;



-- CREACION DE SECUENCIA Y TABLA INTERMEDIA DE MIGRACION
CREATE SEQUENCE sq_migration;

CREATE TABLE tbl_migration_id_mgid (
    mgid_prefix VARCHAR2(4) NOT NULL
    , mgid_old_id NUMBER(19) NOT NULL
    , mgid_new_id NUMBER(19) NOT NULL

    , CONSTRAINT pk_mgid PRIMARY KEY(mgid_prefix, mgid_old_id)
);

INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'part', part_id FROM iman_partida_part;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'equi', equi_id FROM iman_equipamiento_equi;


INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'ivat', ivat_id FROM ifac_ivatipo_ivat;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tata', tata_id FROM ifac_tasatarifa_tata;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'exet', exet_id FROM igen_exenciontipo_exet;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'ente', ente_id FROM icon_entidad_ente;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'alin', alin_id FROM igen_alineacion_alin;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'acue', acue_id FROM iesc_acuerdo_acue;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'orga', orga_id FROM icom_organizacion_orga;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'term', term_id FROM iman_terminal_term;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'buqu', buqu_buque_id FROM iesc_buque_buqu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'iesp', iesp_id FROM iman_instespecial_iesp;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'modu', modu_id FROM icon_modulo_modu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'prfa', prfa_id FROM ifac_proceso_prfa;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'dead', dead_id FROM igen_descuentoadic_dead;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'unic', unic_id FROM iman_unidadcarga_unic;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'temd', temd_id FROM iemd_tipoembarcacion_temd;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'atet', atet_id FROM iesc_atraqueeditipo_atet;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'merc', merc_id FROM iman_mercancia_merc;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tvia', tvia_id FROM icom_tipovia_tvia;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tobl', tobl_id FROM iman_tipooperacion_tobl;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tamd', tamd_id FROM iemd_tipoamarre_tamd;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'atrt', atrt_id FROM iesc_atraquetipo_atrt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'emet', emet_id FROM iest_mercanciatipo_emet;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'texp', texp_id FROM iexp_tipoexpediente_texp;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'arpe', arpe_id FROM ipes_artepesca_arpe;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'zope', zope_id FROM ipes_zonapesca_zope;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'remt', remt_id FROM irem_remolquemedtipo_remt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'orgt', orgt_id FROM icom_organizaciontipo_orgt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'dore', dore_id FROM idiv_dominioref_dore;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'sdep', sdep_id FROM iemd_serviciodep_sdep;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'conv', conv_id FROM iesc_convenio_conv;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'muel', muel_id FROM iesc_muelle_muel;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'cocu', cocu_id FROM iest_conceptocuadro_cocu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'gnst', gnst_id FROM iest_gruponst_gnst;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tage', tage_id FROM iexp_tipoactividadg_tage;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tsex', tsex_id FROM iexp_tiposuperficieb_tsex;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'udex', udex_id FROM iexp_unidaddatoexp_udex;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'cati', cati_id FROM ipes_capturatipo_cati;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'mpst', mpst_id FROM ipes_manifiestostipo_mpst;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'topp', topp_id FROM ipes_operaciontipo_topp;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tcsu', tcsu_id FROM isum_tipocontador_tcsu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tosu', tosu_id FROM isup_tipooperacion_tosu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'unis', unis_id FROM isup_unidad_unis;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'amat', amat_id FROM iama_amarremediotipo_amat;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'ammt', ammt_id FROM iama_movimientotipo_ammt;
-- INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'carn', carn_id FROM icen_carnet_carn;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'dcen', dcen_id FROM icen_documento_dcen;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'pret', pret_id FROM icom_prestadortipo_pret;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'usut', usut_id FROM icom_usuariotipo_usut;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'modb', modb_id FROM icon_modulobatch_modb;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'alit', alit_id FROM iesc_alineaciontipo_alit;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'cert', cert_id FROM iesc_certificadotipo_cert;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'mert', mert_id FROM iesc_mercanciatipo_mert;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'rest', rest_id FROM iesc_residuostipo_rest;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'sett', sett_id FROM iesc_serviciotipo_sett;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'ageo', ageo_id FROM iest_areageografica_ageo;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'amun', amun_id FROM iest_areamundial_amun;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'bugt', bugt_id FROM iest_buquetipogt_bugt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'fama', fama_id FROM iest_fachadamaritima_fama;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'gnat', gnat_id FROM iest_gruponaturaleza_gnat;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'subg', subg_id FROM iest_subgrupo_subg;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'esex', esex_id FROM iexp_estadoexpediente_esex;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tbie', tbie_id FROM iexp_tipobien_tbie;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tepf', tepf_id FROM ifac_tipoerrorproc_tepf;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'eted', eted_id FROM igen_erroreditipo_eted;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'gara', gara_id FROM iman_grupoarancel_gara;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'imar', imar_id FROM iman_instruccmarcaje_imar;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'vmar', vmar_id FROM iman_marcavehiculo_vmar;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'mmpp', mmpp_id FROM iman_mmpp_mmpp;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tedi', tedi_id FROM iman_modotranspedi_tedi;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tbul', tbul_id FROM iman_tipobulto_tbul;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'attd', attd_id FROM iman_tipodocaeat_attd;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'bupe', bupe_id FROM ipes_buque_bupe;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'btpe', btpe_id FROM ipes_buquetipo_btpe;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'gfpe', gfpe_id FROM ipes_grupofamilia_gfpe;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'mpti', mpti_id FROM ipes_manifiestotipo_mpti;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'prpe', prpe_id FROM ipes_presentacion_prpe;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'prat', prat_id FROM ipra_maniobratipo_prat;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'prog', prog_id FROM ipro_programacion_prog;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'gzsu', gzsu_id FROM isup_grupozona_gzsu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tsup', tsup_id FROM isup_tiposuperficie_tsup;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'coad', coad_id FROM icen_consejo_coad;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'codr', codr_id FROM icon_codigoreferencia_codr;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'bgte', bgte_id FROM iest_buquetipogteee_bgte;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'pagr', pagr_id FROM iest_paramagreagacion_pagr;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'faex', faex_id FROM iexp_fase_faex;
-- INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'gaex', gaex_id FROM iexp_garantia_gaex;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'rece', rece_id FROM iman_receptor_rece;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'cope', cope_id FROM ipes_comprador_cope;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'pais', pais_id FROM igen_pais_pais;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'aspe', aspe_id FROM ifac_tataaspecto_aspe;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'navt', navt_id FROM igen_navegaciontipo_navt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'acci', acci_id FROM icon_accion_acci;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'eatt', eatt_id FROM icon_entidadatributo_eatt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tsum', tsum_id FROM isum_tiposuministro_tsum;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'usua', usua_id FROM icom_usuario_usua;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'proc', proc_id FROM ifac_procedimiento_proc;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'doct', doct_id FROM idoc_documentotipo_doct;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'trex', trex_id FROM iexp_tramite_trex;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tivi', tivi_id FROM ifac_tipovista_tivi;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tsdi', tsdi_id FROM idiv_tiposerviciodiv_tsdi;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'bapr', bapr_id FROM ifap_baremo_bapr;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tcan', tcan_id FROM ifap_tipocanon_tcan;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'tequ', tequ_id FROM iman_tipoequipamiento_tequ;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'fape', fape_id FROM ipes_familia_fape;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'remt', remt_id FROM irem_movimientotipo_remt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'pres', pres_orga_id FROM icom_prestador_pres;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'mdoc', mdoc_id FROM iexp_modelodocumento_mdoc;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'buet', buet_id FROM iest_registrobuqueeeetipo_buet;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'zcos', zcos_id FROM iest_zonacosteraeee_zcos;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'unlo', unlo_id FROM igen_unlocode_unlo;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'radu', radu_id FROM iman_recintoaduanero_radu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'remt', buqt_id FROM iest_buquetipoeee_buqt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'buqt', buqt_id FROM iest_buquetipoest_buqt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'buqt', buqt_id FROM igen_buquetipo_buqt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'autp', autp_id FROM igen_autoridad_port_autp;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'subp', subp_id FROM igen_subpuerto_subp;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'traf', traf_id FROM iesc_trafico_traf;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'esca', esca_id FROM iesc_escala_esca;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'mani', mani_id FROM iman_manifiesto_mani;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'maco', maco_id FROM iman_consignatario_maco;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'mabl', mabl_id FROM iman_bl_mabl;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'acet', acet_id FROM iesc_actividadeditipo_acet;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'prsu', prsu_id FROM isum_puntored_prsu;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'reds', reds_id FROM isum_red_reds;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'actt', actt_id FROM iesc_actividadtipo_actt;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'cfac', cfac_id FROM ifac_cabecerafactura_cfac;
INSERT INTO tbl_migration_id_mgid (mgid_new_id, mgid_prefix, mgid_old_id) SELECT sq_migration.nextval, 'eatf', eatf_id FROM icon_entidadatributofiltr_eatf;

COMMIT;

/*
iind_indicador_indi
iexp_modelodocumentovar_mdov
iemd_instalaciondep_indp
iemd_amarre_amad
icom_prestadortempsubp_prtp
iexp_expediente_expe
iesc_atraque_atra
iemd_instalaciondepa_inda
ifac_cabeceravaloracion_cval
igen_provincia_prov
ifap_cabecerafp_cafp
iemd_asignacionamarre_asam
iest_registrobuquetipo_burt
ifac_facturaservicio_fase
igen_ficheroedi_edif
iemd_embarcacion_embd
idiv_valordominioref_vdre
iest_periodoproceso_pepr
icen_empresacensada_emce
igen_municipio_muni
isup_zona_zons
iman_partida_part
iexp_zonaportuaria_zopo
ifap_bonificacionfp_bofp
isum_tipogasto_tgsu
ipes_especiepesca_espe
isum_consumo_suco
icen_epigrafe_epig
iesc_residuossubtipo_ress
iest_naturaleza_natu
iexp_suprabien_sbie
iexp_tipoactividad_taex
igen_operaciontipo_opet
iinc_incidenciatipo_inct
icon_filtro_filt
idoc_documento_docu
isum_contador_cosu
icom_permiso_perm
iemd_embarcacionaut_emba
iman_equipamiento_equi
iemd_peticionamarre_peam
iesc_buquetemp_buqu
isup_superficie_suoc
icon_filtroconfiguracion_fcon
iesc_buquetipoedi_bqte
iexp_proyecto_prex
ifac_etiquetavista_etvi
idiv_elementovar_elva
iexp_tramiteexpediente_teed
igen_erroredi_eedi
ifac_documentofactura_docf
ipra_practico_prap
ifac_lineavaloracion_lval
ifap_lineafp_lifp
iama_amarre_amar
ifac_lineafactura_lfac
irem_remolque_remo
ipes_manifiesto_mape
biomasa
bobinas_de_acero
bonificacion_2523b
cemento_envasado
chatarra
iama_amarremediotipoi18n_amat
iama_movimientotipoi18n_ammt
icen_documentodata_dced
icen_epigrafei18n_epig
icom_organizaciontipoi18n_orgt
icom_permisoi18n_perm
icom_prestadortipoi18n_pret
icom_tipoviai18n_tvia
icom_usuario_permiso
icom_usuariotipoi18n_usut
icon_accioni18n_acci
icon_codigoreferenciai18n_codr
icon_entidadatributoi18n_eatt
icon_entidadi18n_ente
icon_modulobatchi18n_modb
icon_moduloi18n_modu
icon_secuencia_servicio_secs
icon_secuencia_sservicio_ssec
idiv_dominiorefi18n_dore
idiv_elementovari18n_elva
idiv_tiposerviciodivi18n_tsdi
idiv_valordominiorefi18n_vdre
idoc_documentodata_docd
idoc_documentotipoi18n_doct
iemd_accionpeticionamarre_apam
iemd_instalaciondepai18n_inda
iemd_instalaciondepi18n_indp
iemd_serviciodepi18n_sdep
iemd_tipoamarrei18n_tamd
iemd_tipoembarcacioni18n_temd
iesc_actividadeditipoi18n_acet
iesc_actividadtipoi18n_actt
iesc_acuerdoi18n_acue
iesc_acuerdotemp_acue
iesc_alineaciontipoi18n_alit
iesc_atraqueeditipoi18n_atet
iesc_atraquetipoi18n_atrt
iesc_buquetipoedii18n_bqte
iesc_certificadotipoi18n_cert
iesc_convenioi18n_conv
iesc_conveniotemp_conv
iesc_mercanciatipoi18n_mert
iesc_muellei18n_muel
iesc_residuossubtipoi18n_ress
iesc_residuostipoi18n_rest
iesc_serviciotipoi18n_sett
iesc_traficoi18n_traf
iest_areageograficai18n_ageo
iest_areamundiali18n_amun
iest_buquetipoeeei18n_buqt
iest_buquetipoesti18n_buqt
iest_buquetipogti18n_bugt
iest_conceptocuadroi18n_cocu
iest_fachadamaritimai18n_fama
iest_gruponaturalezai18n_gnat
iest_gruponsti18n_gnst
iest_mercanciatipoi18n_emet
iest_naturalezai18n_natu
iest_subgrupoi18n_subg
iest_zonacosteraeeei18n_zcos
iexp_activexpediente_acex
iexp_bien_punto_red_bipr
iexp_bienhistorico_bieh
iexp_estadoexpedientei18n_esex
iexp_modelodocumentodata_mdod
iexp_proyectodetalle_prde
iexp_suprabienhistorico_sbih
iexp_tipoactividadgi18n_tage
iexp_tipoactividadi18n_taex
iexp_tipobieni18n_tbie
iexp_tipoexpedientei18n_texp
iexp_tiposuperficiebi18n_tsex
iexp_unidaddatoexpi18n_udex
iexp_zonaportuariahist_vzpc
iexp_zonaportuariai18n_zopo
ifac_contadorescala_coes
ifac_contadortrafico_cots
ifac_documentofacturadata_dofd
ifac_etiquetavistai18n_etvi
ifac_incidenciafactura_incf
ifac_ivatipoi18n_ivat
ifac_seriefactura_sefa
ifac_tataaspectoagr_aspa
ifac_tataaspectocab_aspc
ifac_tataaspectolin_aspl
ifac_tatahistorico_tthi
ifac_tipoerrorproci18n_tepf
ifac_vista_vist
ifap_baremoi18n_bapr
ifap_bonificacionfpi18n_bofp
ifap_tipocanoni18n_tcan
igen_alineacioni18n_alin
igen_autoridad_porti18n_autp
igen_buqueauxiliarberman_babe
igen_buquetipoi18n_buqt
igen_descuentoadici18n_dead
igen_erroreditipoi18n_eted
igen_exenciontipoi18n_exet
igen_municipioi18n_muni
igen_navegaciontipoi18n_navt
igen_operaciontipoi18n_opet
igen_paisi18n_pais
igen_provinciai18n_prov
igen_subpuertoi18n_subp
igen_unlocodei18n_unlo
iinc_incidencia_inci
iinc_incidenciatipoi18n_inct
iind_indicadorlista_indl
iman_grupoaranceli18n_gara
iman_instespeciali18n_iesp
iman_instruccmarcajei18n_imar
iman_mercanciai18n_merc
iman_mmppi18n_mmpp
iman_modotranspedii18n_tedi
iman_precintoequip_preq
iman_recintoaduaneroi18n_radu
iman_termninali18n_term
iman_tipobultoi18n_tbul
iman_tipodocaeati18n_attd
iman_tipoequipamientoi18n_tequ
iman_tipooperacioni18n_tobl
iman_unidadcargai18n_unic
ipes_artepescai18n_arpe
ipes_buquetipoi18n_btpe
ipes_capturatipoi18n_cati
ipes_especiepescai18n_espe
ipes_familiai18n_fape
ipes_grupofamiliai18n_gfpe
ipes_manifiestostipoi18n_mpst
ipes_manifiestosubtipo_mpst
ipes_manifiestotipoi18n_mpti
ipes_operaciontipoi18n_topp
ipes_presentacioni18n_prpe
ipes_zonapescai18n_zope
ipra_maniobratipoi18n_prat
ipro_argumento_argu
irem_movimientotipoi18n_remt
irem_remolquemedtipo18n_remt
isum_consumodetalle_sucd
isum_lecturapuntored_lpsu
isum_tipocontadori18n_tcsu
isum_tipogastoi18n_tgsu
isum_tiposuministroi18n_tsum
isup_grupozonai18n_gzsu
isup_lineaocupacion_sulo
isup_tipooperacioni18n_tosu
isup_tiposuperficiei18n_tsup
isup_unidadi18n_unis
isup_zonai18n_zons
marmol_y_granito
teus_0043
teus_consignatario
teus_llenos
teus_llenos_0015
teus_llenos_0043
teus_llenos_0056
teus_llenos_0062
teus_llenos_0197
teus_llenos_0247
teus_vacios
teus_vacios_0015
teus_vacios_0043
teus_vacios_0056
teus_vacios_0062
teus_vacios_0197
teus_vacios_0247
yeso_a_granel
iama_amarremedio_amam
iaud_visatributo_viat
icen_empleado_empc
icom_organizacionorgt_orot
icom_prestadortemp_pres
icom_servicio_serv
icom_usuario_rol
icom_usuario_subpuerto
icon_filtroconfigatributo_fcat
icon_filtroelemento_fatt
idoc_documento_accion
idoc_documentotipo_accion
iemd_amarre_punto_red_adpr
iemd_amarre_serviciodep_asde
iemd_instdep_serviciodep_isde
iesc_buquesubpuerto_busp
iesc_certificadobuque_cerb
iesc_escalaresiduo_escr
iesc_muelletemp_muel
iesc_serviciotiposervicio_stst
iesc_traficobuque_trbu
iest_avituallamiento_avit
iest_paramagreagacionsp_pags
iexp_bien_bien
iexp_documentotramite_dotr
iexp_expedienterel_exex
iexp_garantiaexpediente_gexp
iexp_gravamenttasaocup_gtoe
iexp_superficiebien_subi
iexp_tasatarifatramite_ttte
iexp_tramiteteorico_trte
ifac_contadorbuque_cobu
ifac_entidadproceso_enpr
ifac_entidadvista_envi
ifac_errorproceso_errp
ifac_ivafactura_ivaf
ifac_tataaspectojerarquia_asje
ifac_tatacompuesta_ttco
ifap_bonificacionlineafp_blfp
iind_indicadorentidad_inde
iman_partidadocu_pado
iman_partidaequip_paeq
iman_partidaim_paim
iman_partidammpp_pamp
irem_remolquemedio_remm
irem_remolquemedtipotemp_remt
isum_contadorpuntored_cpsu
icen_vehiculo_veec
icon_configuracion_conf
iesc_buqueconvenio_buco
iest_cuadrotrimestre_ctri
iest_movimientotbuqueeee_mtbe
iexp_datosexplotacion_daex
iexp_gravamentasaact_gtae
ifac_ivavaloracion_ivav
ifac_tasatarifaservicioan_ttsa
ifap_bonificacioncabfp_bcfp
iman_terminaltemp_term
iman_unidadcargatemp_unic
isum_gastoconsumo_gcsu
isum_gastopuntored_gpsu
isup_superficiedetalle_sude
isup_zonatemp_zons
icen_direccion_cont_dcec
icen_direccion_noti_dnec
icen_expedienteconsejo_exco
iesc_relacionatraquetipo_ratt
ifac_tasatarifaservicio_ttse
ifac_tataaspectoexc_aspx
iman_instespecialtemp_iesp
ipes_partida_pape
isum_clientepuntored_clsu
isum_lecturaconsumo_lcsu
icom_direccion_cont_dirc
icom_direccion_noti_dirn
iemd_embarcacionautcli_eacl
iemd_instpeticionamarre_ipam
iesc_atraqueoperacion_atop
iest_cuadromes_cmes
igen_alineaciontemp_alin
idiv_lineaserviciodiv_lsdi
iest_movimientomerceee_mmee
ifac_detallefactura_dfac
iman_mercanciatemp_merc
iest_agregacionsuperficie_agos
iest_buquefondeoatraque_bufa
ifac_detallevaloracion_dval
iesc_atraquedetalle_atrd
iest_actividadpesquera_acpe
ipra_practicaje_prac
iemd_servicioembaut_seda
ipes_buquetemp_bupe
iest_agregacionescala_ages
idiv_serviciodiv_sedi
iest_movimientomerc_mome
iaud_evento_aevt
icen_secuencia_consejo_seco
icen_secuencia_empleado_seec
icen_secuencia_empresa_seem
icom_secuencia_secu
icon_secuencia_generica_secg
iesc_naviera_navi
iesc_notificaciones_noes
iexp_bienexpediente_biex
iexp_secuencia_tramitteor_setr
ifac_etiquetaimpresion_etim
ifac_parametrizacion_para
ifac_procelemcuantitativo_elcu
ifac_procincompatib_inco
ifac_procjerarquia_prje
ifac_procoperandoprecio_oppr
ifap_actualizacionipc_aipc
*/

-- BORRADO DE SECUENCIA Y TABLA INTERMEDIA DE MIGRACION
DROP SEQUENCE sq_migration;
DROP TABLE tbl_migration_id_mgid;

-- BORRADO DE SINONIMOS PARA LAS TABLAS DE INTEGRA1
DECLARE
	CURSOR c IS SELECT table_name FROM all_tables WHERE owner = 'INTEGRA';
	cmd VARCHAR2(200);
BEGIN
	FOR t IN c LOOP
		cmd := 'DROP SYNONYM ' || t.table_name;
		EXECUTE IMMEDIATE cmd;
	END LOOP;
END;
