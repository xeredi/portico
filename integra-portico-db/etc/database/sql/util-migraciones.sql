truncate table TBL_SUBPARAMETRO_DATO_SPDT;
delete from TBL_SUBPARAMETRO_VERSION_SPVR;
delete from TBL_SUBPARAMETRO_SPRM;

truncate table TBL_PARAMETRO_DATO_PRDT;
DELETE FROM TBL_I18N_I18N where I18N_PREF = 'prvr';
delete from TBL_PARAMETRO_VERSION_PRVR;
delete from TBL_PARAMETRO_PRMT;

truncate table tbl_subserv_subserv_ssss;
truncate table tbl_subservicio_dato_ssdt;
delete from TBL_subservicio_ssrv;

truncate table tbl_servicio_dato_srdt;
delete from TBL_servicio_srvc;

select count(1) from TBL_SUBPARAMETRO_DATO_SPDT;
select count(1) from TBL_SUBPARAMETRO_VERSION_SPVR;
select count(1) from TBL_SUBPARAMETRO_SPRM;

select count(1) from TBL_PARAMETRO_DATO_PRDT;
select count(1) from TBL_I18N_I18N where I18N_PREF = 'prvr';
select count(1) from TBL_PARAMETRO_VERSION_PRVR;
select count(1) from TBL_PARAMETRO_PRMT;

select (
    (select count(1) from TBL_SUBPARAMETRO_DATO_SPDT)
    + (select count(1) from TBL_SUBPARAMETRO_VERSION_SPVR)
    + (select count(1) from TBL_SUBPARAMETRO_SPRM)
    
    + (select count(1) from TBL_PARAMETRO_DATO_PRDT)
    + (select count(1) from TBL_I18N_I18N where I18N_PREF = 'prvr')
    + (select count(1) from TBL_PARAMETRO_VERSION_PRVR)
    + (select count(1) from TBL_PARAMETRO_PRMT)
) as rows_number
FROM DUAL;

select (
    (select count(1) from TBL_SUBSERVICIO_DATO_SSDT)
    + (select count(1) from TBL_SUBSERV_SUBSERV_SSSS)
    + (select count(1) from TBL_SUBSERVICIO_SSRV)
    
    + (select count(1) from TBL_SERVICIO_DATO_SRDT)
    + (select count(1) from TBL_SERVICIO_SRVC)
) as rows_number
FROM DUAL;


select tablespace_name, segment_type, segment_name, sum(bytes) / (1024*1024) as mb, sum(blocks)
from user_extents
group by tablespace_name, segment_type, segment_name
having sum(bytes) / (1024*1024) > 1
order by segment_type, mb desc
;

select tablespace_name, segment_type, sum(bytes) / (1024*1024) as mb, sum(blocks)
from user_extents
group by tablespace_name, segment_type
order by segment_type, mb desc
;

select sum(bytes) / (1024*1024) as mb, sum(blocks)
from user_extents
;






