CREATE OR REPLACE FUNCTION CRITERIOFECHAEST RETURN VARCHAR2 IS
TIPO VARCHAR2(1 BYTE);
BEGIN
   TIPO := 'P';
   RETURN TIPO;
   EXCEPTION
     WHEN NO_DATA_FOUND THEN
       RETURN 'P';
     WHEN OTHERS THEN
       RETURN 'P';
END CRITERIOFECHAEST;
  
  CREATE OR REPLACE FORCE VIEW V_EST_ESCALA ("CODPUE", "ANYO", "CODSER", "NUMESCALA", "FECHAEST", "GT", "ESTCODTIPNAV", "ESTCODTIPNAVENT", "ESTCODTIPNAVSAL", "ESTCODTIPTER", "ESTCODTIPSITOPPE", "ESTINDDESGUACE", "ESTCODTIPBUQOPPE", "ESTINDMERCANTE", "IDCONSIGNATARIO", "CODPAIORIGEN", "CODPUEORIGEN", "CODPAIDESTINO", "CODPUEDESTINO", "ESTCODTIPNAVGLOBAL", "BANDERA", "ESTCODTIPNAVENTOPPE", "ESTCODTIPNAVSALOPPE", "ESTINDOPPE", "ESTRANGOGTOPPE", "IMOBUQUE", "NUMESCALAS", "ESLORATOTAL", "CALMAXIMO", "FECINIREAL", "FECFINREAL", "ESTCODTIPBUQ", "NOMBUQUE", "INDGUERRA") AS 
  SELECT E.CODPUE,
          E.ANYO,
          E.CODESCALA,
          E.NUMESCALA,
          CASE
             WHEN CRITERIOFECHAEST () = 'O' THEN E.FECFINREAL
             WHEN CRITERIOFECHAEST () = 'P' THEN E.FECINIREAL
          END,
          BV.GT,
          E.ESTCODTIPNAV,
          E.ESTCODTIPNAVENT,
          E.ESTCODTIPNAVSAL,
          E.ESTCODTIPTER,
          E.ESTCODTIPSITOPPE,
          E.ESTINDDESGUACE,
          TB.CODTIPOOPPE,
          T.INDMERCANTE,
          E.CODCONSIGNATARIO,
          E.CODPAIORIGEN,
          E.CODPUEORIGEN,
          E.CODPAIDESTINO,
          E.CODPUEDESTINO,
          TN.CODTIPO,
          BV.BANDERA,
          E.ESTCODTIPNAVENTOPPE,
          E.ESTCODTIPNAVSALOPPE,
          T.INDMERCANTE,
          CASE
             WHEN BV.GT >= 0 AND BV.GT <= 99 THEN '99'
             WHEN BV.GT >= 100 AND BV.GT <= 499 THEN '01'
             WHEN BV.GT >= 500 AND BV.GT <= 999 THEN '02'
             WHEN BV.GT >= 1000 AND BV.GT <= 1999 THEN '03'
             WHEN BV.GT >= 2000 AND BV.GT <= 2999 THEN '04'
             WHEN BV.GT >= 3000 AND BV.GT <= 3999 THEN '05'
             WHEN BV.GT >= 4000 AND BV.GT <= 4999 THEN '06'
             WHEN BV.GT >= 5000 AND BV.GT <= 5999 THEN '07'
             WHEN BV.GT >= 6000 AND BV.GT <= 6999 THEN '08'
             WHEN BV.GT >= 7000 AND BV.GT <= 7999 THEN '09'
             WHEN BV.GT >= 8000 AND BV.GT <= 8999 THEN '10'
             WHEN BV.GT >= 9000 AND BV.GT <= 9999 THEN '11'
             WHEN BV.GT >= 10000 AND BV.GT <= 19999 THEN '12'
             WHEN BV.GT >= 20000 AND BV.GT <= 29999 THEN '13'
             WHEN BV.GT >= 30000 AND BV.GT <= 39999 THEN '14'
             WHEN BV.GT >= 40000 AND BV.GT <= 49999 THEN '15'
             WHEN BV.GT >= 50000 AND BV.GT <= 79999 THEN '16'
             WHEN BV.GT >= 80000 AND BV.GT <= 99999 THEN '17'
             WHEN BV.GT >= 100000 AND BV.GT <= 149999 THEN '18'
             WHEN BV.GT >= 150000 AND BV.GT <= 199999 THEN '19'
             WHEN BV.GT >= 200000 AND BV.GT <= 249999 THEN '20'
             WHEN BV.GT >= 250000 AND BV.GT <= 299999 THEN '21'
             WHEN BV.GT >= 300000 AND BV.GT <= 9999999 THEN '22'
          END,
          BU.CODIMO,
          1,
          BV.ESLORATOTAL,
          BV.CALMAXIMO,
          E.FECINIREAL,
          E.FECFINREAL,
          BV.CODTIPOBUQUE,
          BU.NOMBRE,
          TB.INDGUERRA
     FROM ESCALA E
          LEFT JOIN M_BUQUE BU
             ON (BU.CODBUQUE = E.CODBUQUE)
          LEFT JOIN M_BUQUEVERSION BV
             ON (BV.CODBUQUE = BU.CODBUQUE
                 AND BV.FECINIVIG <=
                        (CASE
                            WHEN E.FECINIREAL IS NOT NULL
                            THEN
                               TRUNC (E.FECINIREAL)
                            ELSE
                               TRUNC (E.ETA)
                         END)
                 AND (BV.FECFINVIG >=
                         (CASE
                             WHEN E.FECINIREAL IS NOT NULL
                             THEN
                                TRUNC (E.FECINIREAL)
                             ELSE
                                TRUNC (E.ETA)
                          END)
                      OR BV.FECFINVIG IS NULL))
          LEFT JOIN TIPO_BUQUE TB
             ON BV.CODTIPOBUQUE = TB.CODTIPOBUQUE
          INNER JOIN TIPO_BUQUEOPPE T
             ON (T.CODIGO = TB.CODTIPOOPPE)
          INNER JOIN EST_TIPO_NAVEGACION TN
             ON (TN.CODIGO = E.ESTCODTIPNAV)
    WHERE 
          1=1
--          and E.ESTINDEXENTA = '0'
--          AND E.INDTRAFINT = '0'
--          AND E.CODESTADO IN ('IN', 'FI', 'LD');
