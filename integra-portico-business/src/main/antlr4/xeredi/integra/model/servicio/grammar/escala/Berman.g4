grammar Berman;

berman
:
	unh bgm dtm* ftx* rff* qty*
	(
		nad
		(
			cta com*
		)*
	)+
	(
		tdt rff* dtm* mea* ftx* com*
		(
			loc dtm*
		)*
		(
			gor rff* nad*
			(
				doc dtm* loc*
			)*
		)*
	)+
	(
		tsr qty* ftx*
		(
			loc mea* dtm* qty* poc* ftx*
			(
				han nad*
				(
					gds ftx* mea* eqn* dgs*
				)*
			)*
		)*
	)* unt
;

bgm
:
	'BGM'
;

com
:
	'COM'
;

cta
:
	'CTA'
;

dgs
:
	'DGS'
;

doc
:
	'DOC'
;

dtm
:
	'DTM'
;

eqn
:
	'EQN'
;

ftx
:
	'FTX'
;

gds
:
	'GDS'
;

gor
:
	'GOR'
;

han
:
	'HAN'
;

loc
:
	'LOC'
;

mea
:
	'MEA'
;

nad
:
	'NAD'
;

poc
:
	'POC'
;

qty
:
	'QTY'
;

rff
:
	'RFF'
;

tdt
:
	'TDT'
;

tsr
:
	'TSR'
;

unh
:
	'UNH'
;

unt
:
	'UNT'
;
