SET DEFINE OFF;
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (5, 'Código TUCA CN 20 no RO-RO', 'Indica el código TUCA para contenedores de 20 no RO-RO', 'N31');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (6, 'Código TUCA CN 20 RO-RO', 'Indica el código TUCA para contenedores de 20 RO-RO', 'R31');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (7, 'Código TUCA CN 40 no RO-RO', 'Indica el código TUCA para contenedores de 40 no RO-RO', 'N32');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (8, 'Código TUCA CN 40 RO-RO', 'Indica el código TUCA para contenedores de 40 RO-RO', 'R32');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (2, 'Tipo buque OPPE granelero sólido', 'Indica si no hay tipo de bulto en partida que tipos de buque OPPE son graneleros sólidos. Los tipos de buque se separan por ;', 'S;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (3, 'Tipo buque OPPE granelero líquido', 'Indica si no hay tipo de bulto en partida que tipos de buque OPPE son graneleros líquidos. Los tipos de buque se separan por ;', 'T;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (11, 'Instalación especial en partidas', 'Indica cómo se cálcula el campo de instalación especial. Si vale 0 se grabará a 1 si es granel sólido y el muelle del tramo y el código arancelario están marcados como instalación especial. Si vale 1 se grabará a 1 si el código arancelario está marcado como instalación especial y la partida no tiene equipamiento asociado', '1');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (12, 'Código bonificación que aplica equipamiento RO-RO', 'Indica la bonificación a nivel de buque o tipo de buque que hará que se aplique ro-ro al contenedor', 'B3-00101');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (14, 'Equipamientos TE como CN', 'Indica si los TE se consideran contenedores.Si vale 0, un equipamiento de tipo TE no se considerará como un CN.Si vale 1, un equipamiento de tipo  TE, sí se considerará como un CN', '1');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (15, 'Tamaño TE para contenedor de 40', 'Indica los tamaños TE que se consideran contenedores de 40, si se consideran contenedores según el parámetro "Equipamientos TE como CN"(parámetro con código 14). Valores separados por;', '1480;1490;17;1780;1790;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (16, 'Código TUCA TE 20, si se considera contenedor', 'Indica el código TUCA para remolques de 20, si se consideran contenedores según el parámetro "Equipamientos TE como CN"(parámetro con código 14)', 'RP3');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (17, 'Código TUCA TE 40, si se considera contenedor', 'Indica el código TUCA para remolques de 40, si se consideran contenedores según el parámetro "Equipamientos TE como CN"(parámetro con código 14)', 'RP4');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (13, 'Forma presentación en partida', 'Indica de donde se obtiene la forma de presentación de la partida. Valor 1 para el tipo de bulto (tabla est_paramfptipobulto). Valor 2 para la TUCA de la mercancía (tabla est_paramfptuca)', '2');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (9, 'Código UTI codaran 8704', 'Indica los códigos UTI a los que se asigna el código arancelario 8704. Valores separados por;', '01;02;03;04;08;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (10, 'Código UTI codaran 8716', 'Indica los códigos UTI a los que se asigna el código arancelario 8716. Valores separados por;', '05;06;07;');
Insert into PARAM_ESTADISTICA
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALOR)
 Values
   (1, 'Criterio fecha estadística para tablas con vigencias', 'Indica a partir de que fecha se calculan las estadísticas cuando se debe mirar tablas maestras con vigencias. Valdrá 1 para fecha inicio ó 2 para fecha fin . Importante. No confundir con configuración del criterio para vistas estadísticas que está en la función Oracle CRITERIOFECHAEST', '2');
COMMIT;
