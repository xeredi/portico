truncate table tbl_valoracion_det_vlrd;
delete from tbl_valoracion_lin_vlrl;
delete from tbl_valoracion_vlrc;

truncate table tbl_proceso_parametro_prpm;
truncate table tbl_proceso_mensaje_prmn;
truncate table tbl_proceso_item_prit;
delete from TBL_PROCESO_BATCH_PRBT;

truncate table TBL_subservicio_dato_ssdt;
truncate table TBL_subserv_subserv_ssss;
truncate table TBL_subservicio_trmt_sstr;
delete from TBL_subservicio_ssrv;

truncate table TBL_SERVICIO_DATO_SRDT;
truncate table TBL_SERVICIO_ARCHIVO_SRAR;
truncate table TBL_servicio_trmt_srtr;
truncate table TBL_servicio_actor_srac;
delete from TBL_SERVICIO_SRVC;


EXEC DBMS_STATS.GATHER_SCHEMA_STATS('PORTICO');
EXEC DBMS_STATS.GATHER_SCHEMA_STATS('PORTICOADM');

