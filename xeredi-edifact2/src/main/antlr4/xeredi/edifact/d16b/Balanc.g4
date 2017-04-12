grammar Balanc;

import edifact_d16b_segments;

balanc
:
    s_UNH s_BGM s_DTM+ s_RFF* s_CUX* s_FTX? gr_1* gr_3* gr_4* gr_7* gr_8* s_UNT
;

gr_1
:
    s_NAD s_RFF* gr_2*
;

gr_2
:
    s_CTA s_COM*
;

gr_3
:
    s_CCI s_CAV?
;

gr_4
:
    s_LIN s_MOA+ s_DTM? s_RFF? s_QTY* gr_5*
;

gr_5
:
    s_CPT gr_6*
;

gr_6
:
    s_CCI s_CAV?
;

gr_7
:
    s_EQN s_MOA+
;

gr_8
:
    s_AUT s_DTM?
;