-- crgo
select 
    tata_codigo_modulo, tthi_codigo_normalizado, tata_codigo, tata_codigo_sub, tata_codigo_extension
    , tthi_fecha_ini_vigencia, tthi_fecha_fin_vigencia, tthi_descripcion, tthi_es_obligatoria
    , tthi_es_maestra, tthi_es_multiple, tthi_es_afecta_estadisticas
from 
    IFAC_TASATARIFA_TATA
    inner join IFAC_TATAHISTORICO_TTHI on
        tthi_tata_id = tata_id
where 
    tata_es_activo = 1
    and tthi_es_activo = 1
order by tata_codigo_modulo, tata_tipo, tata_codigo, tata_codigo_sub, tata_codigo_extension
;

-- crdp
SELECT 
    tatap.tata_codigo_modulo, tatap.tata_codigo, tatap.tata_codigo_sub, tatap.tata_codigo_extension
    , tatah.tata_codigo_modulo, tatah.tata_codigo, tatah.tata_codigo_sub, tatah.tata_codigo_extension
    , ttco_fecha_inicio, ttco_fecha_fin, ttco_es_obligatoria_hija
FROM ifac_tatacompuesta_ttco ttco
    INNER JOIN IFAC_TASATARIFA_TATA tatap ON tatap.tata_id = ttco_padre_tata_id
    INNER JOIN IFAC_TASATARIFA_TATA tatah ON tatap.tata_id = ttco_hija_tata_id
where 
    ttco_es_activo = 1
order by
    tatap.tata_codigo_modulo, tatap.tata_codigo, tatap.tata_codigo_sub, tatap.tata_codigo_extension
    , tatah.tata_codigo_modulo, tatah.tata_codigo, tatah.tata_codigo_sub, tatah.tata_codigo_extension
;



-- rgla
select proc_codigo_modulo, tata_codigo_modulo, tata_codigo, tata_codigo_sub, tata_codigo_extension
    , proc_tipo, proc_codigo, proc_prioridad, proc_fecha_inicio, proc_fecha_fin, proc_etiqueta, proc_descripcion
    , proc_precio_base, proc_porcentaje, proc_coeficiente, proc_condicion, proc_formula
    , proc_ruta_tipo_iva, proc_ruta_pagador, proc_ruta_pagador_altern, proc_ruta_es_sujeto_pasivo, proc_ruta_codigo_exencion
    , ente_nombre, ivat_codigo, proc_es_sujeto_pasivo
from ifac_procedimiento_proc proc
    left join ifac_tasatarifa_tata on tata_id = proc_tata_id
    left join icon_entidad_ente on ente_id = proc_entidad_id
    left join ifac_ivatipo_ivat on ivat_id = proc_ivat_id
where proc_es_activo = 1
order by proc_codigo_modulo, tata_codigo_modulo, tata_tipo, tata_codigo, tata_codigo_sub, tata_codigo_extension, proc_tipo, proc_codigo
;



-- rgin
SELECT 
    proc1.proc_id, proc1.proc_codigo_modulo, proc1.proc_tipo, proc1.proc_codigo
    , proc2.proc_id, proc2.proc_codigo_modulo, proc2.proc_tipo, proc2.proc_codigo
    , inco_fecha_inicio, inco_fecha_fin, inco_prioridad
FROM 
    ifac_procincompatib_inco inco
    inner join ifac_procedimiento_proc proc1 ON proc1.proc_id = inco.inco_proc_id_1
    inner join ifac_procedimiento_proc proc2 ON proc2.proc_id = inco.inco_proc_id_1
where inco_es_activo = 1
ORDER BY 
    proc1.proc_codigo_modulo, proc1.proc_tipo, proc1.proc_codigo
    , proc2.proc_codigo_modulo, proc2.proc_tipo, proc2.proc_codigo
;


-- aspc
select tata_codigo_modulo, tata_codigo, tata_codigo_sub, tata_codigo_extension
    , aspe_codigo, aspe_fecha_inicio, aspe_fecha_fin, aspe_descripcion, aspe_es_agrupacion
from ifac_tataaspecto_aspe
    left join ifac_tasatarifa_tata on tata_id = aspe_tata_id
where aspe_es_activo = 1
order by tata_codigo_modulo, tata_codigo, tata_codigo_sub, tata_codigo_extension
    , aspe_codigo
;