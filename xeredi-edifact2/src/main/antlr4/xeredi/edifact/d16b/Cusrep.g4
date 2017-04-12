grammar Cusrep;

import edifact_d16b_segments, edifact_d16b_components, edifact_d16b_fields;

cusrep
:
	s_UNH s_BGM s_DTM* s_QTY* s_POC* s_FTX* s_MEA* s_GEI* s_GPO? s_STS* gr_1* gr_2* gr_3* gr_4* gr_5* gr_6* gr_9* gr_11* gr_12* s_UNT
;

gr_1
:
	s_RFF s_DTM?
;

gr_2
:
	s_LOC s_DTM*
;

gr_3
:
	s_LOC s_DTM*
;

gr_4
:
	s_DOC s_RFF? s_DTM? s_LOC?
;

gr_5
:
	s_TAX s_MOA? s_FII? s_LOC? s_RFF? s_DTM* s_GEI?
;

gr_6
:
	s_NAD gr_7* gr_8*
;

gr_7
:
	s_CTA s_COM*
;

gr_8
:
	s_RFF s_DTM?
;

gr_9
:
	s_TDT s_TPL? s_DTM? gr_10*
;

gr_10
:
	s_LOC s_GPO? s_DTM* s_QTY* s_NAD* s_MEA* s_POC* s_STS* s_FTX*
;

gr_11
:
	s_EQD s_EQN?
;

gr_12
:
	s_AUT s_DTM?
;
