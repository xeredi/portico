grammar edifact_d16b_segments;

import edifact_d16b_components, edifact_d16b_fields, edifact_common;

s_TAX
:
	'TAX+' EOL
;

s_STS
:
	'STS+' EOL
;

s_GPO
:
	'GPO+' EOL
;

s_GEI
:
	'GEI+' EOL
;

s_FII
:
	'FII+' EOL
;

s_AUT
:
	'AUT+' EOL
;

s_IDT
:
	'IDT+' EOL
;

s_UNH
:
	'UNH' PLUS d_0062 PLUS s009
	(
		PLUS d_0068?
	)?
	(
		PLUS s010?
	)?
	(
		PLUS s016?
	)?
	(
		PLUS s017?
	)?
	(
		PLUS s018?
	)? EOL
;

s_BGM
:
	'BGM'
	(
		PLUS c_C002
	)?
	(
		PLUS c_C106
	)?
	(
		PLUS d_1225
	)?
	(
		PLUS d_4343
	)?
	(
		PLUS d_1373
	)?
	(
		PLUS d_3453
	)? EOL
;

s_DTM
:
	'DTM' PLUS c507 EOL
;

s_RFF
:
	'RFF' PLUS c506 EOL
;

s_GOR
:
	'GOR'
	(
		PLUS d_8323
	)?
	(
		PLUS c232
	)?
	(
		PLUS c232
	)?
	(
		PLUS c232
	)?
	(
		PLUS c232
	)? EOL
;

s_TDT
:
	'TDT' PLUS d_8051
	(
		PLUS d_8028
	)?
	(
		PLUS c_C220
	)?
	(
		PLUS c_C001
	)?
	(
		PLUS c_C040
	)?
	(
		PLUS d_8101
	)?
	(
		PLUS c401
	)?
	(
		PLUS c_C222
	)?
	(
		PLUS d_8281
	)?
	(
		PLUS c_C003
	)? EOL
;

s_LOC
:
	'LOC' PLUS d_3227
	(
		PLUS c517
	)?
	(
		PLUS c519
	)?
	(
		PLUS c553
	)?
	(
		PLUS d_5479
	)? EOL
;

s_NAD
:
	'NAD' PLUS d_3035
	(
		PLUS c_C082
	)?
	(
		PLUS c_C058
	)?
	(
		PLUS c_C080
	)?
	(
		PLUS c_C059
	)?
	(
		PLUS d_3164
	)?
	(
		PLUS c819
	)?
	(
		PLUS d_3251
	)?
	(
		PLUS d_3207
	)? EOL
;

s_CNI
:
	'CNI'
	(
		PLUS d_1490
	)?
	(
		PLUS c503
	)?
	(
		PLUS d_1312
	)? EOL
;

s_GID
:
	'GID'
	(
		PLUS d_1496
	)?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)? EOL
;

s_FTX
:
	'FTX' PLUS d_4451
	(
		PLUS d_4453?
	)?
	(
		PLUS c_C107?
	)?
	(
		PLUS c_C108?
	)?
	(
		PLUS d_3453?
	)?
	(
		PLUS d_4447?
	)? EOL
;

s_MEA
:
	'MEA' PLUS d_6311
	(
		PLUS c502
	)?
	(
		PLUS c_C174
	)?
	(
		PLUS d_7383
	)? EOL
;

s_PCI
:
	'PCI'
	(
		PLUS d_4233?
	)?
	(
		PLUS c_C210?
	)?
	(
		PLUS d_8169?
	)?
	(
		PLUS c827?
	)? EOL
;

s_DOC
:
	'DOC' PLUS c_C002
	(
		PLUS c503
	)?
	(
		PLUS d_3153
	)?
	(
		PLUS d_1220
	)?
	(
		PLUS d_1218
	)? EOL
;

s_SGP
:
	'SGP' PLUS c237
	(
		PLUS d_7224?
	)? EOL
;

s_EQD
:
	'EQD' PLUS d_8053
	(
		PLUS c237
	)?
	(
		PLUS c_C224
	)?
	(
		PLUS d_8077
	)?
	(
		PLUS d_8249
	)?
	(
		PLUS d_8169
	)?
	(
		PLUS d_4233
	)? EOL
;

s_SEL
:
	'SEL'
	(
		PLUS d_9308
	)?
	(
		PLUS c_C215
	)?
	(
		PLUS d_4517
	)?
	(
		PLUS c_C208
	)?
	(
		PLUS d_4525
	)? EOL
;

s_UNT
:
	'UNT' PLUS d_0074 PLUS d_0062 EOL
;

s_CNT
:
	'CNT' PLUS c270 EOL
;

s_COM
:
	'COM' PLUS c_C076 EOL
;

s_CPI
:
	'CPI'
	(
		PLUS c229?
	)?
	(
		PLUS c231?
	)?
	(
		PLUS d_4237?
	)? EOL
;

s_CTA
:
	'CTA'
	(
		PLUS d_3139
	)?
	(
		PLUS c_C056
	)? EOL
;

s_CUX
:
	'CUX' PLUS c504
	(
		PLUS c504?
	)?
	(
		PLUS d_5402?
	)?
	(
		PLUS d_6341?
	)? EOL
;

s_DGS
:
	'DGS'
	(
		PLUS d_8273
	)?
	(
		PLUS c_C205
	)?
	(
		PLUS c234
	)?
	(
		PLUS c_C223
	)?
	(
		PLUS d_8339
	)?
	(
		PLUS d_8364
	)?
	(
		PLUS d_8410
	)?
	(
		PLUS d_8126
	)?
	(
		PLUS c235
	)?
	(
		PLUS c236
	)?
	(
		PLUS d_8255
	)?
	(
		PLUS d_8179
	)?
	(
		PLUS d_8211
	)?
	(
		PLUS c289
	)? EOL
;

s_DIM
:
	'DIM' PLUS d_6145 PLUS c_C211 EOL
;

s_EQA
:
	'EQA' PLUS d_8053
	(
		PLUS c237
	)? EOL
;

s_EQN
:
	'EQN' PLUS c523 EOL
;

s_GDS
:
	'GDS'
	(
		PLUS c703
	)?
	(
		PLUS c288
	)? EOL
;

s_GIN
:
	'GIN' PLUS d_7402 PLUS c_C208
	(
		PLUS c_C208?
	)?
	(
		PLUS c_C208?
	)?
	(
		PLUS c_C208?
	)?
	(
		PLUS c_C208?
	)? EOL
;

s_HAN
:
	'HAN'
	(
		PLUS c524
	)?
	(
		PLUS c_C218
	)? EOL
;

s_ICD
:
	'ICD' PLUS c330 PLUS c331 EOL
;

s_MOA
:
	'MOA' PLUS c516 EOL
;

s_PCD
:
	'PCD' PLUS c501
	(
		PLUS d_4405?
	)? EOL
;

s_PIA
:
	'PIA' PLUS d_4347 PLUS c_C212
	(
		PLUS c_C212
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS c_C212
	)? EOL
;

s_PRI
:
	'PRI'
	(
		PLUS c509?
	)?
	(
		PLUS d_5213?
	)? EOL
;

s_QTY
:
	'QTY' PLUS c_C186 EOL
;

s_RNG
:
	'RNG' PLUS d_6167
	(
		PLUS c280?
	)? EOL
;

s_SCC
:
	'SCC' PLUS d_4017
	(
		PLUS d_4493
	)?
	(
		PLUS c329
	)? EOL
;

s_SEQ
:
	'SEQ'
	(
		PLUS d_1229?
	)?
	(
		PLUS c286?
	)? EOL
;

s_TCC
:
	'TCC'
	(
		PLUS c_C200
	)?
	(
		PLUS c_C203
	)?
	(
		PLUS c528
	)?
	(
		PLUS c554
	)? EOL
;

s_TMD
:
	'TMD'
	(
		PLUS c_C219
	)?
	(
		PLUS d_8332
	)?
	(
		PLUS d_8341
	)? EOL
;

s_TMP
:
	'TMP' PLUS d_6245
	(
		PLUS c239
	)? EOL
;

s_TOD
:
	'TOD'
	(
		PLUS d_4055
	)?
	(
		PLUS d_4215
	)?
	(
		PLUS c_C100
	)? EOL
;

s_TPL
:
	'TPL' PLUS c_C222 EOL
;

s_TSR
:
	'TSR'
	(
		PLUS c536?
	)?
	(
		PLUS c233?
	)?
	(
		PLUS c537?
	)?
	(
		PLUS c703?
	)? EOL
;

s_ERC
:
	'ERC' PLUS c901 EOL
;

s_POC
:
	'POC' PLUS c525 EOL
;
