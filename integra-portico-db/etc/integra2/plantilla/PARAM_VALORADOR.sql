SET DEFINE OFF;
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (32, 'Regla para Exención TR por regla 7 días', 'Regla para marcar como exenta TR, al liquidar, por regla 7 días. Si vale 0, no se aplica esta regla. Si vale 1, se aplica la regla por periodos de 24 horas. Si vale 2, se aplica por días naturales', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (42, 'Criterio para grabar datos de domicilio al generar borrador', 'Si vale 0, se grabarán los datos de domicilio que están grabados en M_USUARIO. Si vale 1, se grabarán los datos de domicilio social/fiscal, que están en M_DOMICILIO. Si vale 2, se grabarán los datos de domicilio notificación, que están en M_DOMICILIO', 'TODOS', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (50, 'Tipos de buque para asignación de prestación crucero', 'Tipos de buque separados por ; a los que se asignará prestación de crucero sin tener en cuenta el tipo de actividad', 'B1', 'UC', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (44, 'Decimales a que se redondea la cuota', 'Indica los decimales a los que se redondea la cuota en la liquidación de B1', 'B1', '6', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (49, 'Dom. Público - Valor instalación', 'Criterio para el valor de tasación. Valor 0 para el vigente a fecha inicio liquidaciones expediente. Valor 1 para el vigente a fecha inicio ocupación. Valor 2 para el vigente a fecha inicio borrador. Valor 3 para el vigente a fecha inicio vigencia del bien público que está asociado a ocupación', 'CO', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (53, 'Ocupación superficie zona tránsito - Fecha mínima liquidación ocupación', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación de superficie', 'B6', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (29, 'Criterio Aplicación IVA Escalas y Manifiestos', 'Regla para saber cómo asignar por defecto el IVA en B1, TR,. Si vale 1 se hace en base al check de navegación marítima internacional de la escala. Si vale 2 se hace en base a que el buque asociado disponga de certificado navegación marítima internacional. Si vale 3 el tipo IVA será exento. En B2 y B3 de tramos asociados a escala se grabará el IVA de la B1 que esté grabado a nivel de escala.', 'B1;TR;B2;B3', '3', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (34, 'Dom. Público - Necesidad de disponible facturación', 'Si vale 0, no es necesario que esté marcado el check de Disponible Facturación. Si vale 1, es necesario', 'CO;CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (35, 'Dom. Público - Forma liq. Ocupación por defecto', 'Valor por defecto de la forma de liquidación de ocupación al crear el expediente', 'CO', 'A', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (36, 'Dom. Público - Forma liq. Actividad por defecto', 'Valor por defecto de la froma de liquidación de actividad al crear el expediente', 'CA', 'V', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (37, 'Dom. Público - Tipo IVA ocupación por defecto', 'Valor por defecto del tipo de IVA de ocupación al crear el expediente', 'CO', 'G', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (38, 'Dom. Público - Tipo IVA actividad por defecto', 'Valor por defecto del tipo de IVA de actividad al crear el expediente', 'CA', 'G', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (39, 'Cuenta contable opcional', 'Indica si la cuenta contable en la línea de borrador es opcional. Si vale 0 se obligará a introducirla. si vale 1 no será necesario indicarla', 'TODOS', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (40, 'Código agrupación AP en B0', 'Indica si se asocia la agrupación AP en la línea de borrador al liquidar la B0. Si vale 0 no se rellenará. Si vale 1 se rellenará al liquidar', 'B0', '1', 
    '0', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (43, 'Criterio para grabar check de notificación electrónica al generar borrador', 'Si vale 0, se grabará 0 siempre. Si vale 1, se mirará el campo INDNOTIFELECTRONICA del maestro de clientes. Si vale 2, se mirará el campo  CODTIPONOTIF del  maestro de clientes. En este caso, si dicho campo vale 05, es cuando se grabará a 1 el campo INDNOTIFELECTRONICA. En caso contrario, se grabará 0', 'TODOS', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (51, 'Dom. Público - Fecha mínima liquidación ocupación anual adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación anual por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (52, 'Dom. Público - Fecha mínima liquidación actividad anual adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad anual por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (63, 'Línea importe cero para atraques en dique seco', 'Indica s1 genera línea de importe cero para atraques en dique seco. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (64, 'Tipos de buque para asignación de prestación ro-ro', 'Tipos de buque separados por ; a los que se asignará prestación de ro-ro sin tener en cuenta el tipo de actividad', 'B1', ';', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (65, 'Comprobar partidas por grupo en régimen simplificado B3', 'Indica si se comprueba si hay partidas en simplificado que se liquiden por grupo. Si no se deben comprobar poner 0. Si se deben comprobar pero poder liquidar poner 1. Si se deben comprobar y no poder liquidar poner 2.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (70, 'B3 - Liquidar suministro combustible', 'B3- Indica si se liquidan los servicios de suministro de combustible. Si vale 0 no se podrá liquidar. Si vale 1 se podrá liquidar', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (72, 'Fecha de inicio de cálculo de tramos de días si la exención es al principio del servicio', 'Fecha de inicio de cálculo de tramos de días si la exención es al principio del servicio. Si vale 0 será desde la fecha desde la que no está exento. Si vale 1 será desde la fecha inicio servicio', 'B6', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (73, 'Campo calculado en mantenimiento de partida de pesca', 'Campo calculado en mantenimiento de partida de pesca. Si vale 1, se calculará el importe como  Nº Kg * Precio. Si vale 2, se calculará el precio como Importe / Nº Kg', 'B4', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (31, 'Varios servicios marítimos por buque y puerto', 'Indica si un buque puede estar asociado a varios servicios marítimos en el mismo puerto, Valor 0, un buque NO puede estar asociado simultáneamente a más de 1 servicio marítimo por puerto. Valor 1, un buque se podrá asociar a varios servicios marítimos  en un puerto', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (75, 'IVA Reducido en tarifa residuos', 'IVA Reducido en tarifa residuos. Si vale 0, si según lo parametrizado con parámetro 29, toca IVA general, grabará para TR IVA general. Sin embargo, si vale 1, si según lo parametrizado con parámetro 29 toca IVA general, grabará para TR IVA reducido', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (92, 'Tipo de atraques para 245.5', 'Indica tipos de atraques para aplicar bonificación 245.5. Si se aplica poner los tipos de atraques(A,A2,B,C1,C2,D) separados por ;.A=> Estancia corta atraque Zona 1; A2 Fondeo zona 1; B=> Estancia prolongada atraque Zona 1; C1=> Estancia corta atraque Zona 2; C2 => Estancia prolongada atraque Zona 2; D=> Fondeo Zona 2. Si no se aplica a ninguno poner solo;', 'B1', 'A;C1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (93, 'Agrupación por código arancelario en B2', 'Indica si se agrupa por código arancelario al liquidar la B2. Si vale 0 no se agrupará. Si vale 1 se agrupará', 'B2', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (94, 'B6 - No aplicar progresividad', 'B6 - Tener en cuenta el check de No aplicar progresividad (si sale). En caso de que valga 0, no lo tendrá en cuenta. En caso de valer 1 sí lo tendrá en cuenta', 'B6', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (95, 'B6 - Exención al principo/final segín tipo operación', 'B6 - Tener en cuenta el tipo de operación (si sale) para que la exención sea al principio o al final. En caso de que valga 0, no lo tendrá en cuenta. En caso de valer 1 sí lo tendrá en cuenta', 'B6', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (100, 'B2 - Tipo concesión', 'B2- Indica si la concesión de B2 se obtiene del muelle o de la terminal del tramo. Si vale 1 se obtendrá a partir del muelle. Si vale 2 se hará a partir de la terminal', 'B2', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (101, 'B3 - Tipo concesión', 'B3- Indica si la concesión de B3 se obtiene del muelle o de la terminal. Si vale 1 se obtendrá a partir del muelle. Si vale 2 se hará a partir de la terminal', 'B3', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (102, 'Tarifa residios - Comprobar entrega residuos 132.10.c', 'TR- Indica si se comprueba si el buque ha hecho entrega de residuos en los 7 días anteriores para aplicar el 132.10.c. Si vale 0 no se validará. Si vale 1 secomprobará si ha hecho entrega', 'TR', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (126, 'Finalizar expedientes dominio publico. Proceso automático', 'Indica si se finalizan automáticamente los expedientes de dominio público. Si vale 0 no se ejecutará el proceso. Si vale 1, sí que se ejecutará', 'CO;CA', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (106, 'B0 Pesqueros - Fecha mínima liquidación', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la B0 de pesqueros', 'B0', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (107, 'Liquidación B0 pesqueros base. Liquidar los transeúntes como base', 'Indica si se liquidan los transeuntes como si fueran base. Valor 0, se aplica la condición de base. Valor 1, no aplicará la condición de base y liquidará todo como base', 'B0', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (108, 'Sujeto pasivo B0 pesqueros', 'Indica de donde se obtienen el sujeto pasivo al liquidar B0 pesquero. Valor 1, liquidará al consignatario del buque. Valor 2, liquidará al armador del buque', 'B0', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (109, 'Tipo IVA B0 pesqueros', 'Indica el valor del tipo de IVA en B0 pesqueros. E para exento. N para no sujeto iva', 'B0', 'N', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (110, 'Ocupación superficie zona tránsito-maniobra. Dejar finalizar servicio con fecha posterior a la fecha actual', 'Ocupación superficie zona tránsito-maniobra. Dejar finalizar servicio con fecha posterior a la fecha actual. Si vale 0, no dejaremos finalizar servicio con fecha posterior a la actual. Si vale 1, sí dejaremos', 'B6', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (111, 'Suministro buque – IVA suministro agua en base a IVA escala', 'Suministro buque – IVA suministro agua en base a IVA escala. Si vale 0, se copia el IVA de la B1 de la escala en el suministro. Si vale 1, en caso de que en la escala sea general, en el suministro se copiará Reducido. En las otras casuísticas, seguirá copiando el de la escala tal cual', 'T8', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (114, 'Liquidar B4 por rango fechas. Generación de N borradores por sujeto pasivo, en base a diferentes IVAS', 'Liquidar B4 por rango fechas. Generación de N borradores por sujeto pasivo, en base a diferentes IVAS. Si vale 0, no se generan N borradores por sujeto pasivo. Si vale 1, se generan N borradores por sujeto pasivo, tantos como IVA diferentes hayas en los manifiestos (lo normal es que sean 2)', 'B4', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (115, 'Tipos de actividad de atraques para escalas sin manifiestos', 'Tipos de actividad que se miran en los atraques para el pdf de escalas sin declaración/manifiesto ', 'B1', 'ZCT;ZOP', 
    '1', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (125, 'Valorador dominio público. Dejar valorar año posterior al actual', 'Valorador dominio público. Dejar valorar año posterior al actual. Si vale 0 no dejaremos valorar año posterior. Si vale 1, sí que dejaremos', 'CO;CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (128, 'Periodo impositivo en B0 buques pesqueros base', 'Periodo impositivo en B0 buques pesqueros base. Si vale 0 será la fecha del manifiesto. Si vale 1, irá de 1 enero a 31 diciembre del año asociado a fecha del manifiesto', 'B0', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (68, 'Comprobar equipamientos que se liquidan por tara B3', 'Indica si se comprueba si hay equipamientos que se liquiden por tara. Si no se deben comprobar poner 0. Si se deben comprobar pero poder liquidar poner 1. Si se deben comprobar y no poder liquidar poner 2.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (24, 'Tipos de prestación prolongada que se validaran por días de estancia', 'Tipos de prestación separados por ; que si están menos de una semana se les pondrá Régimen general', 'B1', '10;12;13;14;15;16', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (66, '216.b No aplicar si puerto carga/descarga no es TMCD', 'Indica si aplica regla de 216.b en conocimientos cuyo puerto carga/descarga no es TMCD. Si no se deben aplicar poner 0. Si se debe aplicar poner 1.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (67, 'Ocupación superficie zona tránsito - liquidaciones generadas', 'Indica si al liquidar la ocupación superficie genera un único borrador hasta la fecha fin de liquidación. Si se debe generar un único borrador aunque abarque más de un mes poner 1. Si se debe generar un borrador por mes poner 2.', 'B6', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (71, 'Contadores instalaciones fijas - Fecha mínima liquidación', 'Indica la fecha mínima a partir de la cual se empieza a liquidar los contadores instalaciones fijas', 'T8', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (74, 'Tarifa residuos. Parametrizar si al finalizar la escala se mira si solo tiene fondeos en zona 2 para marcar como exenta TR', 'Tarifa residuos. Parametrizar si al finalizar la escala se mira si solo tiene fondeos en zona 2 para marcar como exenta TR. Si vale 1, sí que aplica la siguiente regla: Al finalizar escala, si solo tiene fondeos en zona 2, marcará como exenta la TR. Si vale 0, esta regla no se aplicará y al finalizar escala no intervendrá sobre exento TR de la escala', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (96, 'Manifiesto Pesca. Asociación tipo IVA', 'Manifiesto Pesca. Asociación tipo IVA. Si vale 0,  se hará en base al tipo de venta. Si vale 1, se hará en base al tipo de operación', 'B4', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (103, 'Agrupación por grupo facturación en B3', 'Indica si se agrupan las partidas por grupo de facturación al liquidar la B3 en régimen por grupos. Si vale 0 no se agrupará. Si vale 1 se agrupará', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (104, 'Finalizar Fondeo en zona 2. Marcar por defecto check Operaciones Comerciales Zona 2 si hay atraque anterior en muelle', 'Finalizar Fondeo en zona 2. Marcar por defecto check Operaciones Comerciales Zona 2 si hay atraque anterior en muelle. Si vale 1, al finalizar atraque, cuando se muestra check de Operaciones Comerciales Zona 2, si hay un atraque anterior en muelle, marcar por defecto el check. Si vale 0, no  se aplica este algoritmo y siempre aparece desmarcado por defecto', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (105, 'Liquidación TR. Validar orden liquidación escalas buque y subpuerto', 'Liquidación TR. Validar orden liquidación escalas buque y subpuerto. Si vale 0, no se validará el orden. Si vale 1,  sí se validará el orden', 'TR', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (113, 'Tipos de atraque para 245.1 y 245.2', 'Tipos de atraque para 245.1 y 245.2.Indica tipos de atraques para aplicar bonificación 245.1 o 245.2. Si se aplica poner los tipos de atraques(A,A2,B,C1,C2,D) separados por ;.A=> Estancia corta atraque Zona 1; A2 Fondeo zona 1; B=> Estancia prolongada atraque Zona 1. C1=> Estancia corta atraque Zona 2. C2 => Estancia prolongada atraque Zona 2. D=> Fondeo Zona 2. Si no se aplica a ninguno poner solo; ', 'B1', 'A;A2;C1;D', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (116, 'Dom. Público - Número decimales del prorrateo', 'Indica el número de decimales a que se redondea el prorrateo de tiempo para ocupación y actividad', 'CO;CA', '9', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (117, 'Valorador B3 – Equipamientos TE o ART exentos si estado es un equipamiento dentro de otro', 'Valorador B3 – Equipamientos TE o ART exentos si estado es un equipamiento dentro de otro. Si vale 0, no se aplica esta regla. Si vale 1, sí se aplica esta regla', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (118, 'T8 Touch Memory - Diferencia permitida importe fichero y calculado', 'Valor de la diferencia máxima permitida entre el importe indicado en el fichero Touch Memory y el calculado por Posidonia en la liquidación de T8 de un servicio Touch Memory', 'T8', '0.02', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (119, 'Valorador B5 tránsitos gestión directa. Liquidar como gestión directa o indirecta', 'Valorador B5 tránsitos gestión directa. Liquidar como gestión directa o indirecta. Si vale 1 liquidará como gestión indirecta (artículo 226.b). Si vale 0, se liquidará acorde a gestión directa (226.a)', 'B5', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (121, 'Tránsitos embarcaciones deportivas en gestión directa. Exención B0 motor <9 metros', 'Tránsitos embarcaciones deportivas en gestión directa. Exención B0 motor <9 metros. Si vale 1, al crear el tránsito con estas características, lo marcará como exento B0. Si vale 0, no lo marcará como exento', 'B0', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (127, 'Tipo IVA B0 por defecto en embarcaciones deportivas', 'Tipo IVA B0 por defecto en embarcaciones deportivas. G General, E Exento, N No sujeto a IVA, R Reducido', 'B0', 'N', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (54, 'Dom. Público - Fecha mínima liquidación ocupación mensual adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación mensual por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (55, 'Dom. Público - Fecha mínima liquidación ocupación bimensual adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación bimensual por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (56, 'Dom. Público - Fecha mínima liquidación ocupación trimestral adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación trimestral por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (57, 'Dom. Público - Fecha mínima liquidación ocupación semestral adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación semestral por adelantado', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (58, 'Dom. Público - Fecha mínima liquidación ocupación anual vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación anual a vencido', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (59, 'Dom. Público - Fecha mínima liquidación ocupación mensual vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación mensual a vencido', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (60, 'Dom. Público - Fecha mínima liquidación ocupación bimensual vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación bimensual a vencido', 'CO', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (61, 'Dom. Público - Fecha mínima liquidación ocupación trimestral vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación trimestral a vencido', 'CO', '01/10/2015', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (62, 'Dom. Público - Fecha mínima liquidación ocupación semestral vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la ocupación semestral a vencido', 'CO', '01/07/2015', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (69, 'B3 - Detectar matrículas repetidas', 'B3- Detectar matrículas repetidas para equipamientos con estado 7. Si vale 0 no buscará matrículas repetidas al liquidar B3. Si vale 1 sí buscará repetidas. Un equipamiento marcado como repetido no se liquidará ni se tendrá en cuenta para la estadística', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (76, 'Dom. Público - Fecha mínima liquidación actividad mensual adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad mensual por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (77, 'Dom. Público - Fecha mínima liquidación actividad bimensual adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad bimensual por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (78, 'Dom. Público - Fecha mínima liquidación actividad trimestral adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad trimestral por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (79, 'Dom. Público - Fecha mínima liquidación actividad semestral adelantado', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad semestral por adelantado', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (80, 'Dom. Público - Fecha mínima liquidación actividad anual vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad anual a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (81, 'Dom. Público - Fecha mínima liquidación actividad mensual vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad mensual a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (82, 'Dom. Público - Fecha mínima liquidación actividad bimensual vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad bimensual a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (83, 'Dom. Público - Fecha mínima liquidación actividad trimestral vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad trimestral a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (84, 'Dom. Público - Fecha mínima liquidación actividad semestral vencido', 'Indica la fecha mínima a partir de la cual se empieza a liquidar la actividad semestral a vencido', 'CA', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (85, 'Dom. Público - Actividad aplicar mínimo de tasa ocupación', 'Indica si al liquidar la actividad se mira si aplica mínimo del 20% de la ocupación. Valor 0 no se aplicará. Valor 1 se podrá aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (86, 'Dom. Público - Actividad aplicar mínimo de cifra negocio', 'Indica si al liquidar la actividad se mira si aplica mínimo de cifra negocio. Valor 0 no se aplicará. Valor 1 se podrá aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (87, 'Dom. Público - Actividad aplicar máximo de tasa ocupación', 'Indica si al liquidar la actividad se mira si aplica máximo del 100% de la ocupación. Valor 0 no se aplicará. Valor 1 se podrá aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (88, 'Dom. Público - Actividad aplicar máximo por valor unidad', 'Indica si al liquidar la actividad se mira si aplica máximo por valor unidad. Valor 0 no se aplicará. Valor 1 se podrá aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (89, 'Dom. Público - Actividad aplicar máximo de cifra negocio', 'Indica si al liquidar la actividad se mira si aplica máximo de cifra negocio. Valor 0 no se aplicará. Valor 1 se podrá aplicar', 'CA', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (90, 'Atraques marina embarcaciones deportivas en gestión indirecta, tipos de atraque permitidos', 'Atraques marina embarcaciones deportivas en gestión indirecta, tipos de atraque permitidos. Si vale 0, permitirá tanto base como tránsitos: Si vale 1 solo permitirá plazas base. Si vale 2, solo permitirá tránsitos', 'B0;B5', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (91, 'Atraques marina embarcaciones deportivas en gestión indirecta. Exención B0 plaza base motor <9 metros', 'Atraques marina embarcaciones deportivas en gestión indirecta. Exención B0 plaza base motor <9 metros. Si vale 1, al cargar atraque con estas características, lo marcará como exento B0. Si vale 0, no lo marcará como exento', 'B0', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (97, 'EDR Gestión indirecta - Fecha minima de liquidación', 'Indica la fecha mínima a partir de la cual se puede liquidar la marina', 'B0;B5', '01/01/2016', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (98, 'EDR Gestión indirecta - Coeficiente multiplicativo adicional', 'Indica si aplica coeficiente multiplicativo a la marina. Valor 0 no se aplicará coeficiente. Valor 1 se aplicará coeficiente', 'B0;B5', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (99, 'EDR Gestión indirecta - Modificación de medias', 'Indica si se pueden modificar las medias a la hora de liquidar la marina. Valor 0 no se dejan modificar. Valor 1 se podrán modificar', 'B0;B5', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (112, 'Acción para indicar servicio marítimo escala. Parametrizar si se muestran todos los servicios marítimos o solo los asociados al buque', 'Acción para indicar servicio marítimo escala. Parametrizar si se muestran todos los servicios marítimos (valor 0)  o solo los asociados al buque (valor 1)', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (120, 'Autorización- Inicio Escala. Recalcular servicio marítimo', 'Autorización- Inicio Escala. Recalcular servicio marítimo. Si vale 0 no se recalcula cuando se autoriza o inicia la escala. Si vale 1 sí se recalcula', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (122, 'Subpuertos en los que está exenta la TR', 'Subpuertos en los que está exenta la TR. Si no está exenta en ninguno dejarlo vacío', 'TR', ';', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (123, 'Valorador tasa ocupación. Parametrizar si sale o no la descripción ocupación/actividad', 'Valorador tasa ocupación. Parametrizar si sale o no la descripción ocupación/actividad. Si vale 0, no sale. Si vale 1, sí sale', 'CO', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (124, 'PDF resumen tramos. Códigos arancelarios incluidos en el total de vehículos en régimen mercancías', 'PDF resumen tramos. Códigos arancelarios incluidos en el total de vehículos en régimen mercancías. Poner los códigos separados por ;', 'B3', '8702A;8702B;8703A;8703B;8703C;8703D;8704A', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (129, 'Suministros buque y otros. Permitir consumo con valor 0', 'Suministros buque y otros. Permitir consumo con valor 0. Si el parámetro vale 0, no se permitirán consumos con valor 0. Si el parámetro vale 1, se permitirán consumos con valor 0', 'T8', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (12, 'Fechas de atraque en líneas borrador', 'Indica si se ponen las fechas de atraque en las líneas de borrador. 1 se muestran. 0 no aparecen ', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (2, 'Cuantía C', 'Indica si se genera línea de cuantía básica C', 'B0', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (3, 'Cuantía S en TMCD', 'Indica si se aplica cuantía básica S al liquidar la B1 en el caso que el puerto origen y destino de la escala sean TMCD. Para añadir la condición después de mirar el servicio marítimo poner 1. Para no tener en cuenta este caso poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (4, 'Avituallamiento Fondeo zona 2', 'Indica tipos de actividad para aplicar avituallamiento fondeo en zona 2. Si se aplica poner los códigos de actividad separados por ;. Si no se aplica a ninguno poner solo;', 'B1', 'ZAO;ZPB;ZRT', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (28, 'Fin Atraque Zona 1 - Marcar check atraque en muelle - no aplicar festivo', 'Indica si al finalizar un atraque en zona 1, el programa marca por defecto el check de atraque en muelle - no aplicar festivo. Si vale 1 aparece marcado. En caso contrario, no aparece marcado', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (25, 'B3-Gijón-Asig 245.3 crear tramo', 'Indica si asigna bonificación 245.3 al crear el tramo. Si no se deben asociar poner 0. Si se debe asociar poner 1.', 'B3', '0', 
    '1', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (14, 'Reducción Serv. Marítimo importe cero', 'Indica se genera línea de reducción por servicio marítimo con importe cero. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (15, 'Atraques continuos', 'Indica se comprueban que los atraques sean continuos. Si se debe comprobar poner 1. Si no se desea comprobar poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (16, 'Bonificaciones 132.10.b y 132.10.c', 'Indica la aplicación de 132.10.b y 132.10.c. Si se deben aplicar las 2 poner 0. Si se debe aplicar 132.10.b y no 132.10.c poner 1. Si se debe aplicar 132.10.c y no 132.10.b poner 2. ', 'TR', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (21, 'Comprobar grupo de partidas en B3', 'Indica si se comprueba si hay partidas cuyo grupo arancelario no sea 1 al 5. Si no se deben comprobar poner 0. Si se deben comprobar poner 1.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (9, 'Reducción Serv. Marítimo fondeo zona 2', 'Indica se genera línea de reducción por servicio marítimo en fondeo zona 2. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (10, 'Reducción Serv. Marítimo en prolongada', 'Indica se genera línea de reducción por servicio marítimo en atraques prolongada. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (13, 'Tipo de atraques para 245.3', 'Indica tipos de atraques para aplicar bonificación 245.3. Si se aplica poner los tipos de atraques(A,A2,B,C1,C2,D) separados por ;.A=> Estancia corta atraque Zona 1; A2 Fondeo zona 1; B=> Estancia prolongada atraque Zona 1; C1=> Estancia corta atraque Zona 2; C2 => Estancia prolongada atraque Zona 2; D=> Fondeo Zona 2. Si no se aplica a ninguno poner solo;', 'B1', 'A;C1;D', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (18, 'Número bultos vehículos', 'Indica a partir de que número de bultos se calculan los vehículos. Si coger los declarados poner 1. Si se debe coger los estadísticos poner 2.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (19, 'Gijón - Líneas importe cero bonificación 245.3 en B2', 'Gijón - Indica si se crean líneas de importe cero para bonificaciones 245.3. Si no se deben crear poner 0. Si se deben crear poner 1.', 'B2', '1', 
    '1', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (20, 'Líneas importe cero bonificación 245.3 en B3', 'Indica si se crean líneas de importe cero para bonificaciones 245.3. Si no se deben crear poner 0. Si se deben crear poner 1.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (22, 'Gijón - Comprobar acumulado 245.3 para el año en B2', 'Gijón - Indica si se mira el acumulado para la bonificación 245.3. Si no se deben comprobar poner 0. Si se deben comprobar poner 1.', 'B2', '0', 
    '1', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (23, 'Comprobar acumulado 245.3 para el año en B3', 'Indica si se mira el acumulado para la bonificación 245.3. Si no se deben comprobar poner 0. Si se deben comprobar poner 1.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (27, 'Línea importe cero para fondeos exentos', 'Indica se genera línea de importe cero para fondeos que estan exentos. Si se debe generar poner 1. Si no se desea generar poner 0', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (1, 'GT', 'Cálculo del Gt como entero o decimal. Para coger el entero de dividir GT/100 poner valor 2. Para coger el valor decimal de dividir GT/100 poner 1', 'B0', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (5, 'GT', 'Cálculo del Gt como entero o decimal. Para coger el entero de dividir GT/100 poner valor 2. Para coger el valor decimal de dividir GT/100 poner 1', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (6, 'Parametrización para 0001', 'Indica si para la partida se aplica lo parametrizado en tabla. Para usar la tabla para la partida 0001 poner valor 1. Para decidirlo en función de los puertos del conocimiento poner 0', 'B2', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (7, '208.d', 'Indica los códigos arancelarios para aplicar artículo 208.d. Si se aplica poner los códigos arancelarios separados por ;. Si no se aplica a ninguno poner solo;', 'B2', '0001;0004;0005;0005L;0006;0007;0008', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (8, 'Linea 0001D', 'Indica se genera línea de importe cero para la partida 0001D. Si se debe generar poner 1. Si no se desea generar poner 0', 'B2', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (17, 'Bonificación 245.3 tránsito terrestre', 'Indica la aplicación del 245.3 en tránsito terrestre. Si no se debe aplicar poner 1. Si se debe aplicar 245.3 para tránsito terrestre poner 1.', 'B3', '0', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (11, 'Tipo navegación para B2 Excursionistas', 'Indica el valor a grabar para el tipo de navegación', 'B2', 'Interior', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (26, '216.b en base a puertos conocimiento', 'Indica si aplica regla de 216.b en conocimientos que han estado o van a estar en régimen de tránsito marítimo . Si no se deben aplicar poner 0. Si se debe aplicar poner 1.', 'B3', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (30, 'B0 exenta IVA', 'Indica si la B0 está exenta de IVA o se calcula igual que la B1 y TR o no está sujeta a IVA. Si vale 0 aplicará las reglas de B1 y TR. Si vale 1 siempre estará exenta de IVA. Si vale 2 se asignará No sujeto a IVA', 'B0', '2', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (33, 'Regla periodos Fondeo Zona 2', 'Regla para indicar si en fondeo en zona 2 los periodos se cuenta como periodos de 24 horas (valor 1) o como días (valor 2)', 'B1', '1', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (41, 'B2 Códigos arancelarios a los que aplica bonificación de cruceristas ', 'B2 Códigos arancelarios a los que aplica bonificación de cruceristas ', 'B2', '0001C;0001X;', 
    '0', '1');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (45, 'Exención horas ocupación superficie', 'Indica el valor por defecto de la exención de horas en los servicios de ocupación superfie. 01 para 48 horas. 02 para 4 horas. 03 para 24 horas. 99 para no exento', 'B6', '01', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (46, 'Tipo IVA ocupación superficie', 'Indica el valor por defecto del tipo de IVA en los servicios de ocupación superfie. E para exento. R para reducido. S para super reducido. G para general. Z para ninguno', 'B6', 'G', 
    '0', '0');
Insert into PARAM_VALORADOR
   (CODIGO, NOMBREREGLA, DESCRIPCIONREGLA, VALORADORASOCIADO, VALOR, BAJA, INDAP)
 Values
   (47, 'Tipo IVA ocupación rodante', 'Indica el valor por defecto del tipo de IVA en los servicios de ocupación rodante. E para exento. R para reducido. S para super reducido. G para general', 'T7', 'E', 
    '0', '0');
COMMIT;
