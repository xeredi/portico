SET DEFINE OFF;
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (5, 'C�digo TUCA CN 20 no RO-RO', 'Indica el c�digo TUCA para contenedores de 20 no RO-RO', 'N31');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (6, 'C�digo TUCA CN 20 RO-RO', 'Indica el c�digo TUCA para contenedores de 20 RO-RO', 'R31');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (7, 'C�digo TUCA CN 40 no RO-RO', 'Indica el c�digo TUCA para contenedores de 40 no RO-RO', 'N32');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (8, 'C�digo TUCA CN 40 RO-RO', 'Indica el c�digo TUCA para contenedores de 40 RO-RO', 'R32');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (2, 'Tipo buque OPPE granelero s�lido', 'Indica si no hay tipo de bulto en partida que tipos de buque OPPE son graneleros s�lidos. Los tipos de buque se separan por ;', 'S;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (3, 'Tipo buque OPPE granelero l�quido', 'Indica si no hay tipo de bulto en partida que tipos de buque OPPE son graneleros l�quidos. Los tipos de buque se separan por ;', 'T;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (11, 'Instalaci�n especial en partidas', 'Indica c�mo se c�lcula el campo de instalaci�n especial. Si vale 0 se grabar� a 1 si es granel s�lido y el muelle del tramo y el c�digo arancelario est�n marcados como instalaci�n especial. Si vale 1 se grabar� a 1 si el c�digo arancelario est� marcado como instalaci�n especial y la partida no tiene equipamiento asociado', '1');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (12, 'C�digo bonificaci�n que aplica equipamiento RO-RO', 'Indica la bonificaci�n a nivel de buque o tipo de buque que har� que se aplique ro-ro al contenedor', 'B3-00101');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (14, 'Equipamientos TE como CN', 'Indica si los TE se consideran contenedores.Si vale 0, un equipamiento de tipo TE no se considerar� como un CN.Si vale 1, un equipamiento de tipo  TE, s� se considerar� como un CN', '1');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (15, 'Tama�o TE para contenedor de 40', 'Indica los tama�os TE que se consideran contenedores de 40, si se consideran contenedores seg�n el par�metro "Equipamientos TE como CN"(par�metro con c�digo 14). Valores separados por;', '1480;1490;17;1780;1790;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (16, 'C�digo TUCA TE 20, si se considera contenedor', 'Indica el c�digo TUCA para remolques de 20, si se consideran contenedores seg�n el par�metro "Equipamientos TE como CN"(par�metro con c�digo 14)', 'RP3');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (17, 'C�digo TUCA TE 40, si se considera contenedor', 'Indica el c�digo TUCA para remolques de 40, si se consideran contenedores seg�n el par�metro "Equipamientos TE como CN"(par�metro con c�digo 14)', 'RP4');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (13, 'Forma presentaci�n en partida', 'Indica de donde se obtiene la forma de presentaci�n de la partida. Valor 1 para el tipo de bulto (tabla est_paramfptipobulto). Valor 2 para la TUCA de la mercanc�a (tabla est_paramfptuca)', '2');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (9, 'C�digo UTI codaran 8704', 'Indica los c�digos UTI a los que se asigna el c�digo arancelario 8704. Valores separados por;', '01;02;03;04;08;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (10, 'C�digo UTI codaran 8716', 'Indica los c�digos UTI a los que se asigna el c�digo arancelario 8716. Valores separados por;', '05;06;07;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (1, 'Criterio fecha estad�stica para tablas con vigencias', 'Indica a partir de que fecha se calculan las estad�sticas cuando se debe mirar tablas maestras con vigencias. Valdr� 1 para fecha inicio � 2 para fecha fin . Importante. No confundir con configuraci�n del criterio para vistas estad�sticas que est� en la funci�n Oracle CRITERIOFECHAEST', '2');
COMMIT;
