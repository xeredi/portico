FICHEROS EUROSTAT
-----------------

Nombre Fichero: MRTM_<tipoFichero>_Q_ES_<año>_000<trimestre>.TXT

Campos separados por ';'

Capos fijos
	- Tipo Fichero: A1, A2, ...
	- Año
	- Trimestre
	- Puerto Declarante

Campos variables en funcion del tipo de fichero
	- c0 : Dirección transporte
	- c1 : Puerto carga/descarga
	- c2 : Zona costera EEE
	- c3 : Unidad de carga
	- c4 : Tipo cargamento (Grupo NST)
	- c5 : Registro buque
	- c6 : Tipo buque EEE
	- c7 : Tamaño buque
	- c8 : Tamaño buque GT EEE
	- c9 : Toneladas
	- c10: Nº pasajeros
	- c11: Nº unidades llenas
	- c12: Nº unidades vacías
	- c13: Nº buques
	- c14: Peso muerto
	- c15: Nº Gts
	- c16: Nº cruceros
	- c17: Nº cruceros en tránsito

Ficheros Trimestrales
	A1
		Campos agrupación: 		c0, c1, c2, c3
		Campos sumarización: 	c9
	A2
		Campos agrupación: 		c0, c1, c2, c3
		Campos sumarización: 	c9

Ficheros Anuales
	A3
		Campos agrupación: 		c0
		Campos sumarización: 	c9, c10, c16, c17

