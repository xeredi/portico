SET DEFINE OFF;
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('ALL', 'Todas las funcionalidades', TO_DATE('11/20/2012 12:57:00', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('11/20/2012 12:57:00', 'MM/DD/YYYY HH24:MI:SS'), 
    'prueba', 'prueba');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('TEST1', 'test1 de pablo', TO_DATE('12/21/2015 15:35:31', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('12/21/2015 15:35:31', 'MM/DD/YYYY HH24:MI:SS'), 
    'prueba', 'prueba');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, OBSERVACIONES, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('MLL', 'MLLACER', 'PERFIL DE PRUEBAS', TO_DATE('02/25/2015 12:22:57', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('03/04/2015 10:56:35', 'MM/DD/YYYY HH24:MI:SS'), 
    'prueba', 'prueba');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('SER', 'Servicios Diversos', TO_DATE('04/22/2016 10:11:44', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('04/22/2016 10:12:05', 'MM/DD/YYYY HH24:MI:SS'), 
    'ACARRASCO', 'ACARRASCO');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('SUM', 'suministros', TO_DATE('04/22/2016 10:12:23', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('04/22/2016 10:12:23', 'MM/DD/YYYY HH24:MI:SS'), 
    'ACARRASCO', 'ACARRASCO');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('DOM', 'Dominio Público', TO_DATE('04/22/2016 10:12:51', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('04/22/2016 10:12:51', 'MM/DD/YYYY HH24:MI:SS'), 
    'ACARRASCO', 'ACARRASCO');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('ESC', 'Escalas', TO_DATE('04/15/2016 13:37:50', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('04/15/2016 13:37:50', 'MM/DD/YYYY HH24:MI:SS'), 
    'ACARRASCO', 'ACARRASCO');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('EDI', 'Servicios EDI', TO_DATE('04/22/2016 10:10:56', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('04/22/2016 10:10:56', 'MM/DD/YYYY HH24:MI:SS'), 
    'ACARRASCO', 'ACARRASCO');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, OBSERVACIONES, FECALTA, FECMODIF, USRALTA, USRMODIF)
 Values
   ('FAC', 'Facturación', 'tiene todas las funcionalidades, excepto administración', TO_DATE('04/22/2016 10:14:23', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('04/22/2016 10:14:23', 'MM/DD/YYYY HH24:MI:SS'), 
    'ACARRASCO', 'ACARRASCO');
Insert into GU_PERFIL
   (CODPERFIL, NOMBRE, FECALTA, USRALTA, USRMODIF)
 Values
   ('MAQ', 'Servicios Maquinaria', TO_DATE('05/02/2016 10:35:34', 'MM/DD/YYYY HH24:MI:SS'), 'SISTEMA', 'SISTEMA');
COMMIT;
