-- Permisos para todas las acciones asociadas a entidad para el usuario 'admin'
INSERT INTO tbl_grupo_accion_entidad_grae(grae_grpo_pk, grae_acen_pk)
SELECT
    (
        SELECT usgr_grpo_pk
        FROM tbl_usuario_grupo_usgr
        WHERE usgr_usro_pk = (
            SELECT usro_pk FROM tbl_usuario_usro WHERE usro_login = 'admin'
        )
    ) AS grae_grpo_pk
    , acen_pk AS grae_acen_pk
FROM tbl_accion_entidad_acen
;
