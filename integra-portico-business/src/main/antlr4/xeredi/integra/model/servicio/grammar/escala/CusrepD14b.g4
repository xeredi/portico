grammar CusrepD14b;

import segments, components, fields;

cusrep
:
	unh bgm dtm* qty* poc* ftx* mea* gei* gpo? sts* gr1* gr2* gr3* gr4* gr5* gr6* gr9* gr11* gr12* unt
;

gr1
:
	rff dtm?
;

gr2
:
	loc dtm*
;

gr3
:
	loc dtm*
;

gr4
:
	doc rff? dtm? loc?
;

gr5
:
	tax moa? fii? loc? rff? dtm* gei?
;

gr6
:
	nad gr7* gr8*
;

gr7
:
	cta com*
;

gr8
:
	rff dtm?
;

gr9
:
	tdt tpl? dtm? gr10*
;

gr10
:
	loc gpo? dtm* qty* nad* mea* poc* sts* ftx*
;

gr11
:
	eqd eqn?
;

gr12
:
	aut dtm?
;
