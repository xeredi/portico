--
-- ABC  (Procedure) 
--
CREATE OR REPLACE procedure        abc as
    cursor cursor1 is select * from m_usuarioaux where secuencial is  null;
    valor number(7);
 begin  
 valor:=8;
 for v_cursor in cursor1 loop
        UPDATE m_usuarioaux set SECUENCIAL=valor where codapsct=v_cursor.CODAPSCT;
        valor:=valor+1;
end loop;
end abc;
/


--
-- ASIGCODABUQUEAUX  (Procedure) 
--
CREATE OR REPLACE procedure asigcodabuqueaux as
    cursor cursor1 is select * from m_buqueaux where codigo is  null;
    valor number(7);
 begin  
 valor:=2000;
 for v_cursor in cursor1 loop
        UPDATE m_buqueaux set CODIGO=valor where codimo=v_cursor.CODIMO;
        valor:=valor+1;
end loop;
end asigcodabuqueaux;
/


--
-- CALCULONUMOPEPESQUERAS  (Procedure) 
--
CREATE OR REPLACE PROCEDURE CALCULONUMOPEPESQUERAS AS
    ANYOREF INTEGER;
 BEGIN  
     ANYOREF:=2013;
    UPDATE ESTADIA E SET E.NUMOPEPESQUERAS=(SELECT COUNT(DISTINCT(P.FECOPERACION)) FROM G4_PESCA P WHERE E.CODPUE=P.CODPUEESCALA AND E.ANYO=P.ANYOESCALA AND E.CODESCALA=P.CODESCALA AND E.CODESTADIA=P.CODESTADIA)
    WHERE E.INDTRAFINT='1' AND  E.ANYO>=ANYOREF;
        COMMIT;
 EXCEPTION
    WHEN OTHERS THEN
      ROLLBACK;
END CALCULONUMOPEPESQUERAS;
/


--
-- FINALIZARAUTORIZACIONBASE  (Procedure) 
--
CREATE OR REPLACE PROCEDURE FINALIZARAUTORIZACIONBASE AS
    V_PARAMETRO VARCHAR2(1000 BYTE);
 BEGIN  
 
EXECUTE IMMEDIATE 'SELECT VALOR FROM PARAMETRO WHERE CODIGO = ''FINALIZARAUTBASE''' INTO V_PARAMETRO ;

IF V_PARAMETRO = 1 THEN
      UPDATE G5_EXPGESTDIRECTA E SET  E.CODESTADO='003' WHERE E.INDTRANSITO='0' AND E.FECFIN<TRUNC(SYSDATE) AND E.CODESTADO='001';
      COMMIT;
END IF; 
 EXCEPTION
    WHEN OTHERS THEN
      ROLLBACK;
END FINALIZARAUTORIZACIONBASE;
/
