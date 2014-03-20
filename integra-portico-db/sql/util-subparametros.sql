-- exists
select *
from tbl_subparametro_sprm
;

SELECT *
from tbl_subparametro_version_spvr
;

select COUNT(1)
from tbl_subparametro_sprm
WHERE
	sprm_prmt_pk = ?
	AND sprm_prmt_dep_pk = ?
;
