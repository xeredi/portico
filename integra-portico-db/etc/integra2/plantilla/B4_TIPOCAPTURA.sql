SET DEFINE OFF;
Insert into B4_TIPOCAPTURA
   (CODIGO, DESCRIPCION, USRMODIF, FECMODIF)
 Values
   ('FC', 'CRUSTACEOS', 'prueba', TO_DATE('09/25/2014 16:13:04', 'MM/DD/YYYY HH24:MI:SS'));
Insert into B4_TIPOCAPTURA
   (CODIGO, DESCRIPCION)
 Values
   ('FM', 'MOLUSCOS');
Insert into B4_TIPOCAPTURA
   (CODIGO, DESCRIPCION, USRMODIF, FECMODIF)
 Values
   ('FP', 'PECES', 'prueba', TO_DATE('09/24/2014 18:02:06', 'MM/DD/YYYY HH24:MI:SS'));
Insert into B4_TIPOCAPTURA
   (CODIGO, DESCRIPCION)
 Values
   ('MM', 'MAMIFEROS');
COMMIT;
