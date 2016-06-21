SET DEFINE OFF;
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (32, 'Regla para Exenci�n TR por regla 7 d�as', 'Regla para marcar como exenta TR, al liquidar, por regla 7 d�as. Si vale 0, no se aplica esta regla. Si vale 1, se aplica la regla por periodos de 24 horas. Si vale 2, se aplica por d�as naturales', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (42, 'Criterio para grabar datos de domicilio al generar borrador', 'Si vale 0, se grabar�n los datos de domicilio que est�n grabados en M_USUARIO. Si vale 1, se grabar�n los datos de domicilio social/fiscal, que est�n en M_DOMICILIO. Si vale 2, se grabar�n los datos de domicilio notificaci�n, que est�n en M_DOMICILIO', 'TODOS', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (50, 'Tipos de buque para asignaci�n de prestaci�n crucero', 'Tipos de buque separados por ; a los que se asignar� prestaci�n de crucero sin tener en cuenta el tipo de actividad', 'B1', 'UC', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (44, 'Decimales a que se redondea la cuota', 'Indica los decimales a los que se redondea la cuota en la liquidaci�n de B1', 'B1', '6', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (49, 'Dom. P�blico - Valor instalaci�n', 'Criterio para el valor de tasaci�n. Valor 0 para el vigente a fecha inicio liquidaciones expediente. Valor 1 para el vigente a fecha inicio ocupaci�n. Valor 2 para el vigente a fecha inicio borrador. Valor 3 para el vigente a fecha inicio vigencia del bien p�blico que est� asociado a ocupaci�n', 'CO', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (53, 'Ocupaci�n superficie zona tr�nsito - Fecha m�nima liquidaci�n ocupaci�n', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n de superficie', 'B6', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (29, 'Criterio Aplicaci�n IVA Escalas y Manifiestos', 'Regla para saber c�mo asignar por defecto el IVA en B1, TR,. Si vale 1 se hace en base al check de navegaci�n mar�tima internacional de la escala. Si vale 2 se hace en base a que el buque asociado disponga de certificado navegaci�n mar�tima internacional. Si vale 3 el tipo IVA ser� exento. En B2 y B3 de tramos asociados a escala se grabar� el IVA de la B1 que est� grabado a nivel de escala.', 'B1;TR;B2;B3', '3', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (34, 'Dom. P�blico - Necesidad de disponible facturaci�n', 'Si vale 0, no es necesario que est� marcado el check de Disponible Facturaci�n. Si vale 1, es necesario', 'CO;CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (35, 'Dom. P�blico - Forma liq. Ocupaci�n por defecto', 'Valor por defecto de la forma de liquidaci�n de ocupaci�n al crear el expediente', 'CO', 'A', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (36, 'Dom. P�blico - Forma liq. Actividad por defecto', 'Valor por defecto de la froma de liquidaci�n de actividad al crear el expediente', 'CA', 'V', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (37, 'Dom. P�blico - Tipo IVA ocupaci�n por defecto', 'Valor por defecto del tipo de IVA de ocupaci�n al crear el expediente', 'CO', 'G', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (38, 'Dom. P�blico - Tipo IVA actividad por defecto', 'Valor por defecto del tipo de IVA de actividad al crear el expediente', 'CA', 'G', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (39, 'Cuenta contable opcional', 'Indica si la cuenta contable en la l�nea de borrador es opcional. Si vale 0 se obligar� a introducirla. si vale 1 no ser� necesario indicarla', 'TODOS', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (40, 'C�digo agrupaci�n AP en B0', 'Indica si se asocia la agrupaci�n AP en la l�nea de borrador al liquidar la B0. Si vale 0 no se rellenar�. Si vale 1 se rellenar� al liquidar', 'B0', '1', 
    '0', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (43, 'Criterio para grabar check de notificaci�n electr�nica al generar borrador', 'Si vale 0, se grabar� 0 siempre. Si vale 1, se mirar� el campo INDNOTIFELECTRONICA del maestro de clientes. Si vale 2, se mirar� el campo  CODTIPONOTIF del  maestro de clientes. En este caso, si dicho campo vale 05, es cuando se grabar� a 1 el campo INDNOTIFELECTRONICA. En caso contrario, se grabar� 0', 'TODOS', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (51, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n anual adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n anual por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (52, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad anual adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad anual por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (63, 'L�nea importe cero para atraques en dique seco', 'Indica s1 genera l�nea de importe cero para atraques en dique seco. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (64, 'Tipos de buque para asignaci�n de prestaci�n ro-ro', 'Tipos de buque separados por ; a los que se asignar� prestaci�n de ro-ro sin tener en cuenta el tipo de actividad', 'B1', ';', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (65, 'Comprobar partidas por grupo en r�gimen simplificado B3', 'Indica si se comprueba si hay partidas en simplificado que se liquiden por grupo. Si no se deben comprobar poner 0. Si se deben comprobar pero poder liquidar poner 1. Si se deben comprobar y no poder liquidar poner 2.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (70, 'B3 - Liquidar suministro combustible', 'B3- Indica si se liquidan los servicios de suministro de combustible. Si vale 0 no se podr� liquidar. Si vale 1 se podr� liquidar', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (72, 'Fecha de inicio de c�lculo de tramos de d�as si la exenci�n es al principio del servicio', 'Fecha de inicio de c�lculo de tramos de d�as si la exenci�n es al principio del servicio. Si vale 0 ser� desde la fecha desde la que no est� exento. Si vale 1 ser� desde la fecha inicio servicio', 'B6', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (73, 'Campo calculado en mantenimiento de partida de pesca', 'Campo calculado en mantenimiento de partida de pesca. Si vale 1, se calcular� el importe como  N� Kg * Precio. Si vale 2, se calcular� el precio como Importe / N� Kg', 'B4', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (31, 'Varios servicios mar�timos por buque y puerto', 'Indica si un buque puede estar asociado a varios servicios mar�timos en el mismo puerto, Valor 0, un buque NO puede estar asociado simult�neamente a m�s de 1 servicio mar�timo por puerto. Valor 1, un buque se podr� asociar a varios servicios mar�timos  en un puerto', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (75, 'IVA Reducido en tarifa residuos', 'IVA Reducido en tarifa residuos. Si vale 0, si seg�n lo parametrizado con par�metro 29, toca IVA general, grabar� para TR IVA general. Sin embargo, si vale 1, si seg�n lo parametrizado con par�metro 29 toca IVA general, grabar� para TR IVA reducido', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (92, 'Tipo de atraques para 245.5', 'Indica tipos de atraques para aplicar bonificaci�n 245.5. Si se aplica poner los tipos de atraques(A,A2,B,C1,C2,D) separados por ;.A=> Estancia corta atraque Zona 1; A2 Fondeo zona 1; B=> Estancia prolongada atraque Zona 1; C1=> Estancia corta atraque Zona 2; C2 => Estancia prolongada atraque Zona 2; D=> Fondeo Zona 2. Si no se aplica a ninguno poner solo;', 'B1', 'A;C1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (93, 'Agrupaci�n por c�digo arancelario en B2', 'Indica si se agrupa por c�digo arancelario al liquidar la B2. Si vale 0 no se agrupar�. Si vale 1 se agrupar�', 'B2', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (94, 'B6 - No aplicar progresividad', 'B6 - Tener en cuenta el check de No aplicar progresividad (si sale). En caso de que valga 0, no lo tendr� en cuenta. En caso de valer 1 s� lo tendr� en cuenta', 'B6', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (95, 'B6 - Exenci�n al principo/final seg�n tipo operaci�n', 'B6 - Tener en cuenta el tipo de operaci�n (si sale) para que la exenci�n sea al principio o al final. En caso de que valga 0, no lo tendr� en cuenta. En caso de valer 1 s� lo tendr� en cuenta', 'B6', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (100, 'B2 - Tipo concesi�n', 'B2- Indica si la concesi�n de B2 se obtiene del muelle o de la terminal del tramo. Si vale 1 se obtendr� a partir del muelle. Si vale 2 se har� a partir de la terminal', 'B2', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (101, 'B3 - Tipo concesi�n', 'B3- Indica si la concesi�n de B3 se obtiene del muelle o de la terminal. Si vale 1 se obtendr� a partir del muelle. Si vale 2 se har� a partir de la terminal', 'B3', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (102, 'Tarifa residios - Comprobar entrega residuos 132.10.c', 'TR- Indica si se comprueba si el buque ha hecho entrega de residuos en los 7 d�as anteriores para aplicar el 132.10.c. Si vale 0 no se validar�. Si vale 1 secomprobar� si ha hecho entrega', 'TR', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (126, 'Finalizar expedientes dominio publico. Proceso autom�tico', 'Indica si se finalizan autom�ticamente los expedientes de dominio p�blico. Si vale 0 no se ejecutar� el proceso. Si vale 1, s� que se ejecutar�', 'CO;CA', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (106, 'B0 Pesqueros - Fecha m�nima liquidaci�n', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la B0 de pesqueros', 'B0', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (107, 'Liquidaci�n B0 pesqueros base. Liquidar los transe�ntes como base', 'Indica si se liquidan los transeuntes como si fueran base. Valor 0, se aplica la condici�n de base. Valor 1, no aplicar� la condici�n de base y liquidar� todo como base', 'B0', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (108, 'Sujeto pasivo B0 pesqueros', 'Indica de donde se obtienen el sujeto pasivo al liquidar B0 pesquero. Valor 1, liquidar� al consignatario del buque. Valor 2, liquidar� al armador del buque', 'B0', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (109, 'Tipo IVA B0 pesqueros', 'Indica el valor del tipo de IVA en B0 pesqueros. E para exento. N para no sujeto iva', 'B0', 'N', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (110, 'Ocupaci�n superficie zona tr�nsito-maniobra. Dejar finalizar servicio con fecha posterior a la fecha actual', 'Ocupaci�n superficie zona tr�nsito-maniobra. Dejar finalizar servicio con fecha posterior a la fecha actual. Si vale 0, no dejaremos finalizar servicio con fecha posterior a la actual. Si vale 1, s� dejaremos', 'B6', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (111, 'Suministro buque � IVA suministro agua en base a IVA escala', 'Suministro buque � IVA suministro agua en base a IVA escala. Si vale 0, se copia el IVA de la B1 de la escala en el suministro. Si vale 1, en caso de que en la escala sea general, en el suministro se copiar� Reducido. En las otras casu�sticas, seguir� copiando el de la escala tal cual', 'T8', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (114, 'Liquidar B4 por rango fechas. Generaci�n de N borradores por sujeto pasivo, en base a diferentes IVAS', 'Liquidar B4 por rango fechas. Generaci�n de N borradores por sujeto pasivo, en base a diferentes IVAS. Si vale 0, no se generan N borradores por sujeto pasivo. Si vale 1, se generan N borradores por sujeto pasivo, tantos como IVA diferentes hayas en los manifiestos (lo normal es que sean 2)', 'B4', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (115, 'Tipos de actividad de atraques para escalas sin manifiestos', 'Tipos de actividad que se miran en los atraques para el pdf de escalas sin declaraci�n/manifiesto ', 'B1', 'ZCT;ZOP', 
    '1', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (125, 'Valorador dominio p�blico. Dejar valorar a�o posterior al actual', 'Valorador dominio p�blico. Dejar valorar a�o posterior al actual. Si vale 0 no dejaremos valorar a�o posterior. Si vale 1, s� que dejaremos', 'CO;CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (128, 'Periodo impositivo en B0 buques pesqueros base', 'Periodo impositivo en B0 buques pesqueros base. Si vale 0 ser� la fecha del manifiesto. Si vale 1, ir� de 1 enero a 31 diciembre del a�o asociado a fecha del manifiesto', 'B0', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (68, 'Comprobar equipamientos que se liquidan por tara B3', 'Indica si se comprueba si hay equipamientos que se liquiden por tara. Si no se deben comprobar poner 0. Si se deben comprobar pero poder liquidar poner 1. Si se deben comprobar y no poder liquidar poner 2.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (24, 'Tipos de prestaci�n prolongada que se validaran por d�as de estancia', 'Tipos de prestaci�n separados por ; que si est�n menos de una semana se les pondr� R�gimen general', 'B1', '10;12;13;14;15;16', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (66, '216.b No aplicar si puerto carga/descarga no es TMCD', 'Indica si aplica regla de 216.b en conocimientos cuyo puerto carga/descarga no es TMCD. Si no se deben aplicar poner 0. Si se debe aplicar poner 1.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (67, 'Ocupaci�n superficie zona tr�nsito - liquidaciones generadas', 'Indica si al liquidar la ocupaci�n superficie genera un �nico borrador hasta la fecha fin de liquidaci�n. Si se debe generar un �nico borrador aunque abarque m�s de un mes poner 1. Si se debe generar un borrador por mes poner 2.', 'B6', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (71, 'Contadores instalaciones fijas - Fecha m�nima liquidaci�n', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar los contadores instalaciones fijas', 'T8', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (74, 'Tarifa residuos. Parametrizar si al finalizar la escala se mira si solo tiene fondeos en zona 2 para marcar como exenta TR', 'Tarifa residuos. Parametrizar si al finalizar la escala se mira si solo tiene fondeos en zona 2 para marcar como exenta TR. Si vale 1, s� que aplica la siguiente regla: Al finalizar escala, si solo tiene fondeos en zona 2, marcar� como exenta la TR. Si vale 0, esta regla no se aplicar� y al finalizar escala no intervendr� sobre exento TR de la escala', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (96, 'Manifiesto Pesca. Asociaci�n tipo IVA', 'Manifiesto Pesca. Asociaci�n tipo IVA. Si vale 0,  se har� en base al tipo de venta. Si vale 1, se har� en base al tipo de operaci�n', 'B4', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (103, 'Agrupaci�n por grupo facturaci�n en B3', 'Indica si se agrupan las partidas por grupo de facturaci�n al liquidar la B3 en r�gimen por grupos. Si vale 0 no se agrupar�. Si vale 1 se agrupar�', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (104, 'Finalizar Fondeo en zona 2. Marcar por defecto check Operaciones Comerciales Zona 2 si hay atraque anterior en muelle', 'Finalizar Fondeo en zona 2. Marcar por defecto check Operaciones Comerciales Zona 2 si hay atraque anterior en muelle. Si vale 1, al finalizar atraque, cuando se muestra check de Operaciones Comerciales Zona 2, si hay un atraque anterior en muelle, marcar por defecto el check. Si vale 0, no  se aplica este algoritmo y siempre aparece desmarcado por defecto', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (105, 'Liquidaci�n TR. Validar orden liquidaci�n escalas buque y subpuerto', 'Liquidaci�n TR. Validar orden liquidaci�n escalas buque y subpuerto. Si vale 0, no se validar� el orden. Si vale 1,  s� se validar� el orden', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (113, 'Tipos de atraque para 245.1 y 245.2', 'Tipos de atraque para 245.1 y 245.2.Indica tipos de atraques para aplicar bonificaci�n 245.1 o 245.2. Si se aplica poner los tipos de atraques(A,A2,B,C1,C2,D) separados por ;.A=> Estancia corta atraque Zona 1; A2 Fondeo zona 1; B=> Estancia prolongada atraque Zona 1. C1=> Estancia corta atraque Zona 2. C2 => Estancia prolongada atraque Zona 2. D=> Fondeo Zona 2. Si no se aplica a ninguno poner solo; ', 'B1', 'A;A2;C1;D', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (116, 'Dom. P�blico - N�mero decimales del prorrateo', 'Indica el n�mero de decimales a que se redondea el prorrateo de tiempo para ocupaci�n y actividad', 'CO;CA', '9', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (117, 'Valorador B3 � Equipamientos TE o ART exentos si estado es un equipamiento dentro de otro', 'Valorador B3 � Equipamientos TE o ART exentos si estado es un equipamiento dentro de otro. Si vale 0, no se aplica esta regla. Si vale 1, s� se aplica esta regla', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (118, 'T8 Touch Memory - Diferencia permitida importe fichero y calculado', 'Valor de la diferencia m�xima permitida entre el importe indicado en el fichero Touch Memory y el calculado por Posidonia en la liquidaci�n de T8 de un servicio Touch Memory', 'T8', '0.02', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (119, 'Valorador B5 tr�nsitos gesti�n directa. Liquidar como gesti�n directa o indirecta', 'Valorador B5 tr�nsitos gesti�n directa. Liquidar como gesti�n directa o indirecta. Si vale 1 liquidar� como gesti�n indirecta (art�culo 226.b). Si vale 0, se liquidar� acorde a gesti�n directa (226.a)', 'B5', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (121, 'Tr�nsitos embarcaciones deportivas en gesti�n directa. Exenci�n B0 motor <9 metros', 'Tr�nsitos embarcaciones deportivas en gesti�n directa. Exenci�n B0 motor <9 metros. Si vale 1, al crear el tr�nsito con estas caracter�sticas, lo marcar� como exento B0. Si vale 0, no lo marcar� como exento', 'B0', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (127, 'Tipo IVA B0 por defecto en embarcaciones deportivas', 'Tipo IVA B0 por defecto en embarcaciones deportivas. G General, E Exento, N No sujeto a IVA, R Reducido', 'B0', 'N', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (54, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n mensual adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n mensual por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (55, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n bimensual adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n bimensual por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (56, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n trimestral adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n trimestral por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (57, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n semestral adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n semestral por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (58, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n anual vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n anual a vencido', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (59, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n mensual vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n mensual a vencido', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (60, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n bimensual vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n bimensual a vencido', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (61, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n trimestral vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n trimestral a vencido', 'CO', '01/10/2015', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (62, 'Dom. P�blico - Fecha m�nima liquidaci�n ocupaci�n semestral vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la ocupaci�n semestral a vencido', 'CO', '01/07/2015', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (69, 'B3 - Detectar matr�culas repetidas', 'B3- Detectar matr�culas repetidas para equipamientos con estado 7. Si vale 0 no buscar� matr�culas repetidas al liquidar B3. Si vale 1 s� buscar� repetidas. Un equipamiento marcado como repetido no se liquidar� ni se tendr� en cuenta para la estad�stica', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (76, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad mensual adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad mensual por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (77, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad bimensual adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad bimensual por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (78, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad trimestral adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad trimestral por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (79, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad semestral adelantado', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad semestral por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (80, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad anual vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad anual a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (81, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad mensual vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad mensual a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (82, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad bimensual vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad bimensual a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (83, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad trimestral vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad trimestral a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (84, 'Dom. P�blico - Fecha m�nima liquidaci�n actividad semestral vencido', 'Indica la fecha m�nima a partir de la cual se empieza a liquidar la actividad semestral a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (85, 'Dom. P�blico - Actividad aplicar m�nimo de tasa ocupaci�n', 'Indica si al liquidar la actividad se mira si aplica m�nimo del 20% de la ocupaci�n. Valor 0 no se aplicar�. Valor 1 se podr� aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (86, 'Dom. P�blico - Actividad aplicar m�nimo de cifra negocio', 'Indica si al liquidar la actividad se mira si aplica m�nimo de cifra negocio. Valor 0 no se aplicar�. Valor 1 se podr� aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (87, 'Dom. P�blico - Actividad aplicar m�ximo de tasa ocupaci�n', 'Indica si al liquidar la actividad se mira si aplica m�ximo del 100% de la ocupaci�n. Valor 0 no se aplicar�. Valor 1 se podr� aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (88, 'Dom. P�blico - Actividad aplicar m�ximo por valor unidad', 'Indica si al liquidar la actividad se mira si aplica m�ximo por valor unidad. Valor 0 no se aplicar�. Valor 1 se podr� aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (89, 'Dom. P�blico - Actividad aplicar m�ximo de cifra negocio', 'Indica si al liquidar la actividad se mira si aplica m�ximo de cifra negocio. Valor 0 no se aplicar�. Valor 1 se podr� aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (90, 'Atraques marina embarcaciones deportivas en gesti�n indirecta, tipos de atraque permitidos', 'Atraques marina embarcaciones deportivas en gesti�n indirecta, tipos de atraque permitidos. Si vale 0, permitir� tanto base como tr�nsitos: Si vale 1 solo permitir� plazas base. Si vale 2, solo permitir� tr�nsitos', 'B0;B5', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (91, 'Atraques marina embarcaciones deportivas en gesti�n indirecta. Exenci�n B0 plaza base motor <9 metros', 'Atraques marina embarcaciones deportivas en gesti�n indirecta. Exenci�n B0 plaza base motor <9 metros. Si vale 1, al cargar atraque con estas caracter�sticas, lo marcar� como exento B0. Si vale 0, no lo marcar� como exento', 'B0', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (97, 'EDR Gesti�n indirecta - Fecha minima de liquidaci�n', 'Indica la fecha m�nima a partir de la cual se puede liquidar la marina', 'B0;B5', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (98, 'EDR Gesti�n indirecta - Coeficiente multiplicativo adicional', 'Indica si aplica coeficiente multiplicativo a la marina. Valor 0 no se aplicar� coeficiente. Valor 1 se aplicar� coeficiente', 'B0;B5', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (99, 'EDR Gesti�n indirecta - Modificaci�n de medias', 'Indica si se pueden modificar las medias a la hora de liquidar la marina. Valor 0 no se dejan modificar. Valor 1 se podr�n modificar', 'B0;B5', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (112, 'Acci�n para indicar servicio mar�timo escala. Parametrizar si se muestran todos los servicios mar�timos o solo los asociados al buque', 'Acci�n para indicar servicio mar�timo escala. Parametrizar si se muestran todos los servicios mar�timos (valor 0)  o solo los asociados al buque (valor 1)', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (120, 'Autorizaci�n- Inicio Escala. Recalcular servicio mar�timo', 'Autorizaci�n- Inicio Escala. Recalcular servicio mar�timo. Si vale 0 no se recalcula cuando se autoriza o inicia la escala. Si vale 1 s� se recalcula', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (122, 'Subpuertos en los que est� exenta la TR', 'Subpuertos en los que est� exenta la TR. Si no est� exenta en ninguno dejarlo vac�o', 'TR', ';', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (123, 'Valorador tasa ocupaci�n. Parametrizar si sale o no la descripci�n ocupaci�n/actividad', 'Valorador tasa ocupaci�n. Parametrizar si sale o no la descripci�n ocupaci�n/actividad. Si vale 0, no sale. Si vale 1, s� sale', 'CO', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (124, 'PDF resumen tramos. C�digos arancelarios incluidos en el total de veh�culos en r�gimen mercanc�as', 'PDF resumen tramos. C�digos arancelarios incluidos en el total de veh�culos en r�gimen mercanc�as. Poner los c�digos separados por ;', 'B3', '8702A;8702B;8703A;8703B;8703C;8703D;8704A', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (129, 'Suministros buque y otros. Permitir consumo con valor 0', 'Suministros buque y otros. Permitir consumo con valor 0. Si el par�metro vale 0, no se permitir�n consumos con valor 0. Si el par�metro vale 1, se permitir�n consumos con valor 0', 'T8', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (12, 'Fechas de atraque en l�neas borrador', 'Indica si se ponen las fechas de atraque en las l�neas de borrador. 1 se muestran. 0 no aparecen ', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (2, 'Cuant�a C', 'Indica si se genera l�nea de cuant�a b�sica C', 'B0', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (3, 'Cuant�a S en TMCD', 'Indica si se aplica cuant�a b�sica S al liquidar la B1 en el caso que el puerto origen y destino de la escala sean TMCD. Para a�adir la condici�n despu�s de mirar el servicio mar�timo poner 1. Para no tener en cuenta este caso poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (4, 'Avituallamiento Fondeo zona 2', 'Indica tipos de actividad para aplicar avituallamiento fondeo en zona 2. Si se aplica poner los c�digos de actividad separados por ;. Si no se aplica a ninguno poner solo;', 'B1', 'ZAO;ZPB;ZRT', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (28, 'Fin Atraque Zona 1 - Marcar check atraque en muelle - no aplicar festivo', 'Indica si al finalizar un atraque en zona 1, el programa marca por defecto el check de atraque en muelle - no aplicar festivo. Si vale 1 aparece marcado. En caso contrario, no aparece marcado', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (25, 'B3-Gij�n-Asig 245.3 crear tramo', 'Indica si asigna bonificaci�n 245.3 al crear el tramo. Si no se deben asociar poner 0. Si se debe asociar poner 1.', 'B3', '0', 
    '1', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (14, 'Reducci�n Serv. Mar�timo importe cero', 'Indica se genera l�nea de reducci�n por servicio mar�timo con importe cero. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (15, 'Atraques continuos', 'Indica se comprueban que los atraques sean continuos. Si se debe comprobar poner 1. Si no se desea comprobar poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (16, 'Bonificaciones 132.10.b y 132.10.c', 'Indica la aplicaci�n de 132.10.b y 132.10.c. Si se deben aplicar las 2 poner 0. Si se debe aplicar 132.10.b y no 132.10.c poner 1. Si se debe aplicar 132.10.c y no 132.10.b poner 2. ', 'TR', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (21, 'Comprobar grupo de partidas en B3', 'Indica si se comprueba si hay partidas cuyo grupo arancelario no sea 1 al 5. Si no se deben comprobar poner 0. Si se deben comprobar poner 1.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (9, 'Reducci�n Serv. Mar�timo fondeo zona 2', 'Indica se genera l�nea de reducci�n por servicio mar�timo en fondeo zona 2. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (10, 'Reducci�n Serv. Mar�timo en prolongada', 'Indica se genera l�nea de reducci�n por servicio mar�timo en atraques prolongada. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (13, 'Tipo de atraques para 245.3', 'Indica tipos de atraques para aplicar bonificaci�n 245.3. Si se aplica poner los tipos de atraques(A,A2,B,C1,C2,D) separados por ;.A=> Estancia corta atraque Zona 1; A2 Fondeo zona 1; B=> Estancia prolongada atraque Zona 1; C1=> Estancia corta atraque Zona 2; C2 => Estancia prolongada atraque Zona 2; D=> Fondeo Zona 2. Si no se aplica a ninguno poner solo;', 'B1', 'A;C1;D', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (18, 'N�mero bultos veh�culos', 'Indica a partir de que n�mero de bultos se calculan los veh�culos. Si coger los declarados poner 1. Si se debe coger los estad�sticos poner 2.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (19, 'Gij�n - L�neas importe cero bonificaci�n 245.3 en B2', 'Gij�n - Indica si se crean l�neas de importe cero para bonificaciones 245.3. Si no se deben crear poner 0. Si se deben crear poner 1.', 'B2', '1', 
    '1', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (20, 'L�neas importe cero bonificaci�n 245.3 en B3', 'Indica si se crean l�neas de importe cero para bonificaciones 245.3. Si no se deben crear poner 0. Si se deben crear poner 1.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (22, 'Gij�n - Comprobar acumulado 245.3 para el a�o en B2', 'Gij�n - Indica si se mira el acumulado para la bonificaci�n 245.3. Si no se deben comprobar poner 0. Si se deben comprobar poner 1.', 'B2', '0', 
    '1', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (23, 'Comprobar acumulado 245.3 para el a�o en B3', 'Indica si se mira el acumulado para la bonificaci�n 245.3. Si no se deben comprobar poner 0. Si se deben comprobar poner 1.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (27, 'L�nea importe cero para fondeos exentos', 'Indica se genera l�nea de importe cero para fondeos que estan exentos. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (1, 'GT', 'C�lculo del Gt como entero o decimal. Para coger el entero de dividir GT/100 poner valor 2. Para coger el valor decimal de dividir GT/100 poner 1', 'B0', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (5, 'GT', 'C�lculo del Gt como entero o decimal. Para coger el entero de dividir GT/100 poner valor 2. Para coger el valor decimal de dividir GT/100 poner 1', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (6, 'Parametrizaci�n para 0001', 'Indica si para la partida se aplica lo parametrizado en tabla. Para usar la tabla para la partida 0001 poner valor 1. Para decidirlo en funci�n de los puertos del conocimiento poner 0', 'B2', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (7, '208.d', 'Indica los c�digos arancelarios para aplicar art�culo 208.d. Si se aplica poner los c�digos arancelarios separados por ;. Si no se aplica a ninguno poner solo;', 'B2', '0001;0004;0005;0005L;0006;0007;0008', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (8, 'Linea 0001D', 'Indica se genera l�nea de importe cero para la partida 0001D. Si se debe generar poner 1. Si no se desea generar poner 0', 'B2', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (17, 'Bonificaci�n 245.3 tr�nsito terrestre', 'Indica la aplicaci�n del 245.3 en tr�nsito terrestre. Si no se debe aplicar poner 1. Si se debe aplicar 245.3 para tr�nsito terrestre poner 1.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (11, 'Tipo navegaci�n para B2 Excursionistas', 'Indica el valor a grabar para el tipo de navegaci�n', 'B2', 'Interior', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (26, '216.b en base a puertos conocimiento', 'Indica si aplica regla de 216.b en conocimientos que han estado o van a estar en r�gimen de tr�nsito mar�timo . Si no se deben aplicar poner 0. Si se debe aplicar poner 1.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (30, 'B0 exenta IVA', 'Indica si la B0 est� exenta de IVA o se calcula igual que la B1 y TR o no est� sujeta a IVA. Si vale 0 aplicar� las reglas de B1 y TR. Si vale 1 siempre estar� exenta de IVA. Si vale 2 se asignar� No sujeto a IVA', 'B0', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (33, 'Regla periodos Fondeo Zona 2', 'Regla para indicar si en fondeo en zona 2 los periodos se cuenta como periodos de 24 horas (valor 1) o como d�as (valor 2)', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (41, 'B2 C�digos arancelarios a los que aplica bonificaci�n de cruceristas ', 'B2 C�digos arancelarios a los que aplica bonificaci�n de cruceristas ', 'B2', '0001C;0001X;', 
    '0', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (45, 'Exenci�n horas ocupaci�n superficie', 'Indica el valor por defecto de la exenci�n de horas en los servicios de ocupaci�n superfie. 01 para 48 horas. 02 para 4 horas. 03 para 24 horas. 99 para no exento', 'B6', '01', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (46, 'Tipo IVA ocupaci�n superficie', 'Indica el valor por defecto del tipo de IVA en los servicios de ocupaci�n superfie. E para exento. R para reducido. S para super reducido. G para general. Z para ninguno', 'B6', 'G', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (47, 'Tipo IVA ocupaci�n rodante', 'Indica el valor por defecto del tipo de IVA en los servicios de ocupaci�n rodante. E para exento. R para reducido. S para super reducido. G para general', 'T7', 'E', 
    '0', '0');
COMMIT;
