grammar edifact_d16b_segments;

import edifact_d16b_components, edifact_d16b_fields, edifact_common;

tax
:
	'TAX+' EOL
;

sts
:
	'STS+' EOL
;

gpo
:
	'GPO+' EOL
;

gei
:
	'GEI+' EOL
;

fii
:
	'FII+' EOL
;

aut
:
	'AUT+' EOL
;

idt
:
	'IDT+' EOL
;

unh
:
	'UNH' PLUS f0062 PLUS s009
	(
		PLUS f0068?
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

/*
bgm
:
	'BGM'
	(
		PLUS c002?
	)?
	(
		PLUS c106?
	)?
	(
		PLUS f1225?
	)?
	(
		PLUS f4343?
	)?
	(
		PLUS f1373?
	)?
	(
		PLUS f3453?
	)? EOL
;
 */
bgm
:
	'BGM'
	(
		PLUS c_C002?
	)?
	(
		PLUS c106?
	)?
	(
		PLUS d_1225?
	)?
	(
		PLUS d_4343?
	)?
	(
		PLUS d_1373?
	)?
	(
		PLUS d_3453?
	)? EOL
;

dtm
:
	'DTM' PLUS c507 EOL
;

rff
:
	'RFF' PLUS c506 EOL
;

gor
:
	'GOR'
	(
		PLUS f8323?
	)?
	(
		PLUS c232?
	)?
	(
		PLUS c232?
	)?
	(
		PLUS c232?
	)?
	(
		PLUS c232?
	)? EOL
;

tdt
:
	'TDT' PLUS f8051
	(
		PLUS f8028?
	)?
	(
		PLUS c220?
	)?
	(
		PLUS c_C001?
	)?
	(
		PLUS c040?
	)?
	(
		PLUS f8101?
	)?
	(
		PLUS c401?
	)?
	(
		PLUS c222?
	)?
	(
		PLUS f8281?
	)?
	(
		PLUS c_C003?
	)? EOL
;

loc
:
	'LOC' PLUS d_3227
	(
		PLUS c517?
	)?
	(
		PLUS c519?
	)?
	(
		PLUS c553?
	)?
	(
		PLUS d_5479?
	)? EOL
;

nad
:
	'NAD' PLUS d_3035
	(
		PLUS c082?
	)?
	(
		PLUS c058?
	)?
	(
		PLUS c080?
	)?
	(
		PLUS c059?
	)?
	(
		PLUS d_3164?
	)?
	(
		PLUS c819?
	)?
	(
		PLUS d_3251?
	)?
	(
		PLUS d_3207?
	)? EOL
;

cni
:
	'CNI'
	(
		PLUS d_1490?
	)?
	(
		PLUS c503?
	)?
	(
		PLUS d_1312?
	)? EOL
;

gid
:
	'GID'
	(
		PLUS d_1496?
	)?
	(
		PLUS c213?
	)?
	(
		PLUS c213?
	)?
	(
		PLUS c213?
	)?
	(
		PLUS c213?
	)?
	(
		PLUS c213?
	)? EOL
;

ftx
:
	'FTX' PLUS d_4451
	(
		PLUS d_4453?
	)?
	(
		PLUS c107?
	)?
	(
		PLUS c108?
	)?
	(
		PLUS d_3453?
	)?
	(
		PLUS d_4447?
	)? EOL
;

mea
:
	'MEA' PLUS d_6311
	(
		PLUS c502?
	)?
	(
		PLUS c174?
	)?
	(
		PLUS f7383?
	)? EOL
;

pci
:
	'PCI'
	(
		PLUS d_4233?
	)?
	(
		PLUS c210?
	)?
	(
		PLUS f8169?
	)?
	(
		PLUS c827?
	)? EOL
;

doc
:
	'DOC' PLUS c_C002
	(
		PLUS c503?
	)?
	(
		PLUS d_3153?
	)?
	(
		PLUS d_1220?
	)?
	(
		PLUS d_1218?
	)? EOL
;

sgp
:
	'SGP' PLUS c237
	(
		PLUS f7224?
	)? EOL
;

eqd
:
	'EQD' PLUS f8053
	(
		PLUS c237?
	)?
	(
		PLUS c224?
	)?
	(
		PLUS f8077?
	)?
	(
		PLUS f8249?
	)?
	(
		PLUS f8169?
	)?
	(
		PLUS d_4233?
	)? EOL
;

sel
:
	'SEL'
	(
		PLUS f9308?
	)?
	(
		PLUS c215?
	)?
	(
		PLUS d_4517?
	)?
	(
		PLUS c208?
	)?
	(
		PLUS d_4525?
	)? EOL
;

unt
:
	'UNT' PLUS f0074 PLUS f0062 EOL
;

cnt
:
	'CNT' PLUS c270 EOL
;

com
:
	'COM' PLUS c076 EOL
;

cpi
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

cta
:
	'CTA'
	(
		PLUS d_3139?
	)?
	(
		PLUS c056?
	)? EOL
;

cux
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

dgs
:
	'DGS'
	(
		PLUS f8273?
	)?
	(
		PLUS c205?
	)?
	(
		PLUS c234?
	)?
	(
		PLUS c223?
	)?
	(
		PLUS f8339?
	)?
	(
		PLUS f8364?
	)?
	(
		PLUS f8410?
	)?
	(
		PLUS f8126?
	)?
	(
		PLUS c235?
	)?
	(
		PLUS c236?
	)?
	(
		PLUS f8255?
	)?
	(
		PLUS f8179?
	)?
	(
		PLUS f8211?
	)?
	(
		PLUS c289?
	)? EOL
;

dim
:
	'DIM' PLUS d_6145 PLUS c211 EOL
;

eqa
:
	'EQA' PLUS f8053
	(
		PLUS c237?
	)? EOL
;

eqn
:
	'EQN' PLUS c523 EOL
;

gds
:
	'GDS'
	(
		PLUS c703?
	)?
	(
		PLUS c288?
	)? EOL
;

gin
:
	'GIN' PLUS f7402 PLUS c208
	(
		PLUS c208?
	)?
	(
		PLUS c208?
	)?
	(
		PLUS c208?
	)?
	(
		PLUS c208?
	)? EOL
;

han
:
	'HAN'
	(
		PLUS c524?
	)?
	(
		PLUS c218?
	)? EOL
;

icd
:
	'ICD' PLUS c330 PLUS c331 EOL
;

moa
:
	'MOA' PLUS c516 EOL
;

pcd
:
	'PCD' PLUS c501
	(
		PLUS d_4405?
	)? EOL
;

pia
:
	'PIA' PLUS d_4347 PLUS c212
	(
		PLUS c212?
	)?
	(
		PLUS c212?
	)?
	(
		PLUS c212?
	)?
	(
		PLUS c212?
	)? EOL
;

pri
:
	'PRI'
	(
		PLUS c509?
	)?
	(
		PLUS d_5213?
	)? EOL
;

qty
:
	'QTY' PLUS c186 EOL
;

rng
:
	'RNG' PLUS d_6167
	(
		PLUS c280?
	)? EOL
;

scc
:
	'SCC' PLUS d_4017
	(
		PLUS d_4493?
	)?
	(
		PLUS c329?
	)? EOL
;

seq
:
	'SEQ'
	(
		PLUS d_1229?
	)?
	(
		PLUS c286?
	)? EOL
;

tcc
:
	'TCC'
	(
		PLUS c200?
	)?
	(
		PLUS c203?
	)?
	(
		PLUS c528?
	)?
	(
		PLUS c554?
	)? EOL
;

tmd
:
	'TMD'
	(
		PLUS c219?
	)?
	(
		PLUS f8332?
	)?
	(
		PLUS f8341?
	)? EOL
;

tmp
:
	'TMP' PLUS d_6245
	(
		PLUS c239?
	)? EOL
;

tod
:
	'TOD'
	(
		PLUS d_4055?
	)?
	(
		PLUS d_4215?
	)?
	(
		PLUS c100?
	)? EOL
;

tpl
:
	'TPL' PLUS c222 EOL
;

tsr
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

erc
:
	'ERC' PLUS c901 EOL
;

poc
:
	'POC' PLUS c525 EOL
;
