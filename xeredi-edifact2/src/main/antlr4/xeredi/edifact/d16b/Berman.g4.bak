grammar Berman;

import edifact_d16b_segments, edifact_d16b_components, edifact_d16b_fields;

berman
:
	s_UNH["BERMAN"] s_BGM s_DTM* s_FTX* s_RFF* s_QTY* gr_1* gr_3* gr_7* s_UNT
;

gr_1
:
	s_NAD gr_2*
;

gr_2
:
	s_CTA s_COM*
;

gr_3
:
	s_TDT s_RFF* s_DTM* s_MEA* s_FTX* s_COM* gr_4* gr_5*
;

gr_4
:
	s_LOC s_DTM*
;

gr_5
:
	s_GOR s_RFF* s_NAD* gr_6*
;

gr_6
:
	s_DOC s_DTM* s_LOC*
;

/* Atraque */
gr_7
:
	s_TSR s_QTY* s_FTX* gr_8*
;

gr_8
:
	s_LOC s_MEA* s_DTM* s_QTY* s_POC* s_FTX* gr_9*
;

/* Operacion de Atraque */
gr_9
:
	s_HAN s_NAD* gr_10*
;

gr_10
:
	s_GDS s_FTX* s_MEA* s_EQN* s_DGS*
;
