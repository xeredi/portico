/*
select * from IEST_ACTIVIDADPESQUERA_ACPE;
select * from IEST_AGREGACIONESCALA_AGES;
select * from IEST_AGREGACIONSUPERFICIE_AGOS;
select * from IEST_AVITUALLAMIENTO_AVIT;
select * from IEST_BUQUEFONDEOATRAQUE_BUFA;
select * from IEST_MOVIMIENTOMERC_MOME;
select * from IEST_MOVIMIENTOMERCEEE_MMEE;
select * from IEST_MOVIMIENTOTBUQUEEEE_MTBE;
select * from IEST_CUADROMES_CMES;
select * from IEST_PERIODOPROCESO_PEPR;

select * from IGEN_AUTORIDAD_PORT_AUTP;



select count(1) from IEST_ACTIVIDADPESQUERA_ACPE;
select count(1) from IEST_AGREGACIONESCALA_AGES;
select count(1) from IEST_AGREGACIONSUPERFICIE_AGOS;
select count(1) from IEST_AVITUALLAMIENTO_AVIT;
select count(1) from IEST_BUQUEFONDEOATRAQUE_BUFA;
select count(1) from IEST_MOVIMIENTOMERC_MOME;
select count(1) from IEST_MOVIMIENTOMERCEEE_MMEE;
select count(1) from IEST_MOVIMIENTOTBUQUEEEE_MTBE;
select count(1) from IEST_CUADROMES_CMES;
select count(1) from IEST_PERIODOPROCESO_PEPR;

select count(1) from IGEN_AUTORIDAD_PORT_AUTP;

select * from IGEN_AUTORIDAD_PORT_AUTP where autp_id in ('80', '81', '82', '83', '84', '85');
*/



delete from IEST_ACTIVIDADPESQUERA_ACPE
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = acpe_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_AGREGACIONESCALA_AGES
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = ages_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_AGREGACIONSUPERFICIE_AGOS
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = agos_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_AVITUALLAMIENTO_AVIT
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = avit_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_BUQUEFONDEOATRAQUE_BUFA
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = bufa_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_MOVIMIENTOMERC_MOME
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = mome_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_MOVIMIENTOMERCEEE_MMEE
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = mmee_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_MOVIMIENTOTBUQUEEEE_MTBE
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = mtbe_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_CUADROMES_CMES
where 
    exists (
        select 1 from IEST_PERIODOPROCESO_PEPR
        where 
            pepr_id = cmes_pepr_id
            and exists (
                select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
            )
            and pepr_anio = '2015'
    )
;


delete from IEST_PERIODOPROCESO_PEPR
where 
    exists (
        select 1 from IGEN_AUTORIDAD_PORT_AUTP where autp_id = pepr_autp_id and autp_id in ('80', '81', '82', '83', '84', '85')
    )
    and pepr_anio = '2015'
;
