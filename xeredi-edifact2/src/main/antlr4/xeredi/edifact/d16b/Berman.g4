grammar Berman;

import edifact_d16b_segments, edifact_d16b_components, edifact_d16b_fields;

berman
:
	unh bgm dtm* ftx* rff* qty* gr1* gr3* gr7* unt
;

gr1
:
	nad gr2*
;

gr2
:
	cta com*
;

gr3
:
	tdt rff* dtm* mea* ftx* com* gr4* gr5*
;

gr4
:
	loc dtm*
;

gr5
:
	gor rff* nad* gr6*
;

gr6
:
	doc dtm* loc*
;

/* Atraque */
gr7
:
	tsr qty* ftx* gr8*
;

gr8
:
	loc mea* dtm* qty* poc* ftx* gr9*
;

/* Operacion de Atraque */
gr9
:
	han nad* gr10*
;

gr10
:
	gds ftx* mea* eqn* dgs*
;
