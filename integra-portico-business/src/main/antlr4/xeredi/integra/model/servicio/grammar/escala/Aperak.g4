grammar Aperak;

aperak
:
	unh bgm dtm* ftx* cnt*
	(
		doc dtm*
	)*
	(
		rff dtm*
	)*
	(
		nad cta* com*
	)*
	(
		erc ftx?
		(
			rff ftx*
		)*
	)* unt
;

bgm
:
	'BGM'
;

cnt
:
	'CNT'
;

com
:
	'COM'
;

cta
:
	'CTA'
;

doc
:
	'DOC'
;

dtm
:
	'DTM'
;

erc
:
	'ERC'
;

ftx
:
	'FTX'
;

nad
:
	'NAD'
;

rff
:
	'RFF'
;

unh
:
	'UNH'
;

unt
:
	'UNT'
;
