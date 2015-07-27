grammar segments;

import components, fields;

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

erc
:
	'ERC+' EOL
;

poc
:
	'POC+' EOL
;

tod
:
	'TOD+' EOL
;

seq
:
	'SEQ+' EOL
;

rng
:
	'RNG+' EOL
;

pia
:
	'PIA+' EOL
;

tsr
:
	'TSR+' EOL
;

idt
:
	'IDT+' EOL
;

gin
:
	'GIN+' EOL
;

tmp
:
	'TMP+' EOL
;

tmd
:
	'TMD+' EOL
;

han
:
	'HAN+' EOL
;

tpl
:
	'TPL+' EOL
;

scc
:
	'SCC+' EOL
;

icd
:
	'ICD+' EOL
;

qty
:
	'QTY+' EOL
;

eqn
:
	'EQN+' EOL
;

pri
:
	'PRI+' EOL
;

tcc
:
	'TCC+' EOL
;

gds
:
	'GDS+' EOL
;

pcd
:
	'PCD+' EOL
;

moa
:
	'MOA+' EOL
;

unh
:
	'UNH' '+' f0062 '+' s009
	(
		'+' f0068
	)?
	(
		'+' s010
	)?
	(
		'+' s016
	)?
	(
		'+' s017
	)?
	(
		'+' s018
	)? EOL
;

bgm
:
	'BGM'
	(
		'+' c002
	)?
	(
		'+' c106
	)?
	(
		'+' f1225
	)?
	(
		'+' f4343
	)?
	(
		'+' f1373
	)?
	(
		'+' f3453
	)? EOL
;

dtm
:
	'DTM' '+' c507 EOL
;

rff
:
	'RFF' '+' c506 EOL
;

gor
:
	'GOR'
	(
		'+' f8323
	)?
	(
		'+' c232
	)?
	(
		'+' c232
	)?
	(
		'+' c232
	)?
	(
		'+' c232
	)? EOL
;

tdt
:
	'TDT' '+' f8051 '+' f8028? '+' c220?
	(
		'+' c001?
	)?
	(
		'+' c040?
	)?
	(
		'+' f8101?
	)?
	(
		'+' c401?
	)?
	(
		'+' c222?
	)?
	(
		'+' f8281?
	)?
	(
		'+' c003?
	)? EOL
;

loc
:
	'LOC' '+' f3227
	(
		'+' c517
	)?
	(
		'+' c519
	)?
	(
		'+' c553
	)?
	(
		'+' f5479
	)? EOL
;

nad
:
	'NAD' '+' f3035
	(
		'+' c082
	)?
	(
		'+' c058
	)?
	(
		'+' c080
	)?
	(
		'+' c059
	)?
	(
		'+' f3164
	)?
	(
		'+' c819
	)?
	(
		'+' f3251
	)?
	(
		'+' f3207
	)? EOL
;

cni
:
	'CNI'
	(
		'+' f1490
	)?
	(
		'+' c503
	)?
	(
		'+' f1312
	)? EOL
;

gid
:
	'GID'
	(
		'+' f1496
	)?
	(
		'+' c213
	)?
	(
		'+' c213
	)?
	(
		'+' c213
	)?
	(
		'+' c213
	)?
	(
		'+' c213
	)? EOL
;

ftx
:
	'FTX' '+' f4451
	(
		'+' f4453?
	)?
	(
		'+' c107?
	)?
	(
		'+' c108?
	)?
	(
		'+' f3453?
	)?
	(
		'+' f4447?
	)? EOL
;

mea
:
	'MEA' '+' f6311
	(
		'+' c502
	)?
	(
		'+' c174
	)?
	(
		'+' f7383
	)? EOL
;

pci
:
	'PCI' '+' f4233?
	(
		'+' c210
	)?
	(
		'+' f8169
	)?
	(
		'+' c827
	)? EOL
;

doc
:
	'DOC' '+' c002
	(
		'+' c503
	)?
	(
		'+' f3153
	)?
	(
		'+' f1220
	)?
	(
		'+' f1218
	)? EOL
;

sgp
:
	'SGP' '+' c237
	(
		'+' f7224
	)? EOL
;

eqd
:
	'EQD' '+' f8053
	(
		'+' c237?
	)?
	(
		'+' c224?
	)?
	(
		'+' f8077?
	)?
	(
		'+' f8249?
	)?
	(
		'+' f8169?
	)?
	(
		'+' f4233?
	)? EOL
;

sel
:
	'SEL' '+' f9308?
	(
		'+' c215
	)?
	(
		'+' f4517
	)?
	(
		'+' c208
	)?
	(
		'+' f4525
	)? EOL
;

unt
:
	'UNT' '+' f0074 '+' f0062 EOL
;

cnt
:
	'CNT' '+' c270 EOL
;

com
:
	'COM' '+' c076 EOL
;

cpi
:
	'CPI' '+' c229?
	(
		'+' c231
	)?
	(
		'+' f4237
	)? EOL
;

cta
:
	'CTA' '+' f3139?
	(
		'+' c056
	)? EOL
;

cux
:
	'CUX' '+' c504
	(
		'+' c504
	)?
	(
		'+' f5402
	)?
	(
		'+' f6341
	)? EOL
;

dgs
:
	'DGS' '+' f8273?
	(
		'+' c205
	)?
	(
		'+' c234
	)?
	(
		'+' c223
	)?
	(
		'+' f8339
	)?
	(
		'+' f8364
	)?
	(
		'+' f8410
	)?
	(
		'+' f8126
	)?
	(
		'+' c235
	)?
	(
		'+' c236
	)?
	(
		'+' f8255
	)?
	(
		'+' f8179
	)?
	(
		'+' f8211
	)?
	(
		'+' c289
	)? EOL
;

dim
:
	'DIM' '+' f6145 '+' c211 EOL
;

eqa
:
	'EQA' '+' f8053
	(
		'+' c237
	)? EOL
;
