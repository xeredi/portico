grammar Ifcsum;

ifcsum
:
	unh bgm dtm* moa* ftx* cnt* pcd? gds*
	(
		rff dtm*
	)*
	(
		gor dtm* loc* sel* ftx*
		(
			doc dtm?
		)*
	)*
	(
		nad
		(
			cta com*
		)*
		(
			rff dtm*
		)*
	)*
	(
		tcc cux? pri? eqn? pcd? moa* qty* loc*
	)*
	(
		icd dtm? ftx*
	)* grTdt* grEqd*
	(
		cni
		(
			sgp
			(
				mea eqn?
			)*
		)*
		(
			tpl
			(
				mea eqn?
			)*
		)* cta? com* dtm* cnt* tsr* cux* pcd* moa* ftx* gds*
		(
			loc dtm*
		)*
		(
			tod loc*
		)*
		(
			rff dtm*
		)*
		(
			gor dtm* loc* sel* ftx*
			(
				doc dtm?
			)*
		)*
		(
			cpi rff* cux? loc* moa*
		)*
		(
			tcc loc? ftx? cux? pri? eqn? pcd? moa* qty*
		)*
		(
			icd dtm? ftx*
		)* grCniTdt* grCniNad* grCniGid* grCniEqd*
	)* unt
;

grTdt
:
	tdt dtm*
	(
		tsr scc*
	)*
	(
		loc dtm*
	)* sel* ftx*
	(
		mea eqn?
	)*
	(
		dim eqn?
	)*
	(
		cta com*
	)*
	(
		tcc moa* pcd?
	)*
	(
		icd dtm? ftx*
	)*
	(
		rff dtm*
	)*
	(
		nad loc*
		(
			cta com*
		)*
		(
			doc dtm*
		)*
		(
			tcc cux? pri? eqn? pcd? moa* qty*
		)*
		(
			rff dtm*
		)*
	)*
;

grEqd
:
	eqd eqn? tpl? tmd? mea* dim* sel* nad* loc* han? tmp? ftx* rff* pcd*
	(
		eqa eqn?
	)*
	(
		dgs ftx*
		(
			cta com*
		)*
	)*
;

grCniTdt
:
	tdt dtm*
	(
		tsr scc*
	)*
	(
		loc dtm*
	)*
	(
		rff dtm?
	)*
	(
		tcc moa* pcd?
	)*
	(
		icd dtm? ftx*
	)*
;

grCniNad
:
	nad loc* moa*
	(
		cta com*
	)*
	(
		doc dtm?
	)*
	(
		tcc cux? pri? eqn? pcd? moa* qty*
	)*
	(
		rff dtm*
	)*
	(
		cpi rff* cux? loc* moa*
	)*
	(
		tsr rff? loc? tpl? ftx*
	)*
;

grCniGid
:
	gid han? tmp? rng? tmd? loc* moa* pia* gin* ftx*
	(
		nad dtm? gds*
	)*
	(
		mea eqn?
	)*
	(
		dim eqn?
	)*
	(
		rff dtm*
	)*
	(
		pci rff? dtm? gin* mea* dim? ftx*
	)*
	(
		doc dtm*
	)*
	(
		gor dtm* loc* sel* ftx*
		(
			doc dtm?
		)*
	)*
	(
		tpl
		(
			mea eqn?
		)*
	)*
	(
		sgp seq?
		(
			mea eqn?
		)*
	)*
	(
		tcc cux? pri? eqn? pcd? moa* qty* loc*
	)*
	(
		icd dtm? ftx*
	)*
	(
		dgs ftx*
		(
			cta com*
		)*
		(
			mea eqn?
		)*
		(
			sgp
			(
				mea eqn*
			)*
		)*
	)*
;

grCniEqd
:
	eqd eqn? tmd? mea* dim* sel* tpl* han? tmp? ftx* pcd*
	(
		tcc cux? pri? eqn? pcd? moa* qty*
	)*
	(
		nad dtm?
	)*
	(
		eqa eqn?
	)*
	(
		dgs ftx*
		(
			cta com*
		)*
	)*
;

unh
:
	'UNH' ANYCHAR+ LINE_SEPARATOR
;

bgm
:
	'BGM' LINE_SEPARATOR
;

dtm
:
	'DTM' ANYCHAR+ LINE_SEPARATOR
;

moa
:
	'MOA' ANYCHAR+ LINE_SEPARATOR
;

ftx
:
	'FTX' ANYCHAR+ LINE_SEPARATOR
;

cnt
:
	'CNT' ANYCHAR+ LINE_SEPARATOR
;

pcd
:
	'PCD' ANYCHAR+ LINE_SEPARATOR
;

gds
:
	'GDS' ANYCHAR+ LINE_SEPARATOR
;

rff
:
	'RFF' ANYCHAR+ LINE_SEPARATOR
;

gor
:
	'GOR' ANYCHAR+ LINE_SEPARATOR
;

loc
:
	'LOC' ANYCHAR+ LINE_SEPARATOR
;

sel
:
	'SEL' ANYCHAR+ LINE_SEPARATOR
;

doc
:
	'DOC' ANYCHAR+ LINE_SEPARATOR
;

nad
:
	'NAD' ANYCHAR+ LINE_SEPARATOR
;

cta
:
	'CTA' ANYCHAR+ LINE_SEPARATOR
;

com
:
	'COM' ANYCHAR+ LINE_SEPARATOR
;

tcc
:
	'TCC' ANYCHAR+ LINE_SEPARATOR
;

cux
:
	'CUX' ANYCHAR+ LINE_SEPARATOR
;

pri
:
	'PRI' ANYCHAR+ LINE_SEPARATOR
;

eqn
:
	'EQN' ANYCHAR+ LINE_SEPARATOR
;

qty
:
	'QTY' ANYCHAR+ LINE_SEPARATOR
;

icd
:
	'ICD' ANYCHAR+ LINE_SEPARATOR
;

tdt
:
	'TDT' ANYCHAR+ LINE_SEPARATOR
;

tsr
:
	'TSR' ANYCHAR+ LINE_SEPARATOR
;

scc
:
	'SCC' ANYCHAR+ LINE_SEPARATOR
;

mea
:
	'MEA' ANYCHAR+ LINE_SEPARATOR
;

dim
:
	'DIM' ANYCHAR+ LINE_SEPARATOR
;

eqd
:
	'EQD' ANYCHAR+ LINE_SEPARATOR
;

tpl
:
	'TPL' ANYCHAR+ LINE_SEPARATOR
;

tmd
:
	'TMD' ANYCHAR+ LINE_SEPARATOR
;

han
:
	'HAN' ANYCHAR+ LINE_SEPARATOR
;

tmp
:
	'TMP' ANYCHAR+ LINE_SEPARATOR
;

eqa
:
	'EQA' ANYCHAR+ LINE_SEPARATOR
;

dgs
:
	'DGS' ANYCHAR+ LINE_SEPARATOR
;

cni
:
	'CNI' ANYCHAR+ LINE_SEPARATOR
;

sgp
:
	'SGP' ANYCHAR+ LINE_SEPARATOR
;

tod
:
	'TOD' ANYCHAR+ LINE_SEPARATOR
;

cpi
:
	'CPI' ANYCHAR+ LINE_SEPARATOR
;

gid
:
	'GID' ANYCHAR+ LINE_SEPARATOR
;

rng
:
	'RNG' ANYCHAR+ LINE_SEPARATOR
;

pia
:
	'PIA' ANYCHAR+ LINE_SEPARATOR
;

gin
:
	'GIN' ANYCHAR+ LINE_SEPARATOR
;

pci
:
	'PCI' ANYCHAR+ LINE_SEPARATOR
;

seq
:
	'SEQ' ANYCHAR+ LINE_SEPARATOR
;

unt
:
	'UNT' LINE_SEPARATOR?
;

/*
VARCHAR
:
	[A-Za-z0-9()., ]
;
*/
ANYCHAR
:
	'A' .. 'Z'
	| 'a' .. 'z'
	| '0' .. '9'
	| ' '
	| ','
	| '.'
	| '('
	| ')'
;
/*
FTX
:
	'FTX'
;

COM
:
	'COM'
;
 */
LINE_SEPARATOR
:
	'\r'? '\n'
;

