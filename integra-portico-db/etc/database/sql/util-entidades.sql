
-- Buscar entidades hijas
SELECT *
FROM tbl_entidad_enti
WHERE
	EXISTS (
		SELECT 1
		FROM tbl_entidad_entidad_enen
		WHERE enen_entih_pk = enti_pk
			AND enen_entip_pk = 22004
	)
;

SELECT *
FROM tbl_entidad_entidad_enen
;
