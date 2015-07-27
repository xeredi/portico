grammar AperakD14b;

import segments, components, fields;

aperak
:
	unh bgm dtm* ftx* cnt* gr1* gr2* gr3* gr4* unt
;

gr1
:
	doc dtm*
;

gr2
:
	rff dtm*
;

gr3
:
	nad cta* com*
;

gr4
:
	erc ftx* gr5*
;

gr5
:
	rff ftx*
;
