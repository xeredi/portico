--
-- CRITERIOFECHAEST  (Function) 
--
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
/
