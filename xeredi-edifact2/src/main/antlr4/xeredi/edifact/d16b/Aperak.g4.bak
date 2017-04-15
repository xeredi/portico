grammar Aperak;

import edifact_d16b_segments;

aperak
:
	s_UNH["APERAK"] s_BGM s_DTM* s_FTX* s_CNT* gr_1* gr_2* gr_3* gr_4* s_UNT
;

gr_1
:
	s_DOC s_DTM*
;

gr_2
:
	s_RFF s_DTM*
;

gr_3
:
	s_NAD s_CTA* s_COM*
;

gr_4
:
	s_ERC s_FTX* gr_5*
;

gr_5
:
	s_RFF s_FTX*
;
