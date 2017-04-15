grammar Bansta;

import edifact_d16b_segments;

bansta
:
	s_UNH["BANSTA"] s_BGM s_DTM s_BUS? gr_1* gr_2* gr_3* gr_4*  s_CNT* gr_9* s_UNT
;

gr_1
:
	s_RFF s_DTM?
;

gr_2
:
	s_FII s_CTA? s_COM*
;

gr_3
:
	s_NAD s_CTA? s_COM*
;

gr_4
:
	s_LIN gr_5* gr_6*
;

gr_5
:
	s_RFF s_DTM?
;

gr_6
:
	s_SEQ s_GEI s_DTM* s_MOA? s_CUX? s_PCD? s_FTX? s_DOC* gr_7? gr_8?
;

gr_7
:
	s_FII s_CTA? s_COM*
;

gr_8
:
	s_NAD s_CTA? s_COM*
;

gr_9
:
	s_AUT s_DTM?
;