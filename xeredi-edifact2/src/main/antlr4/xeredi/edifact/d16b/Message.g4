grammar Message;

import edifact_d16b_segments;

message
:
	(
		s_UNH ["APERAK"] aperak
		| s_UNH ["AUTHOR"] author
		| s_UNH ["BALANC"] balanc
		| s_UNH ["BANSTA"] bansta
		| s_UNH ["BAPLIE"] baplie
		| s_UNH ["BERMAN"] berman
		| s_UNH ["BMISRM"] bmisrm
		| s_UNH ["BOPBNK"] bopbnk
		| s_UNH ["CODECO"] codeco
		| s_UNH ["CUSREP"] cusrep
		| s_UNH ["IFCSUM"] ifcsum
	) s_UNT
;

/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
aperak
:
	s_BGM s_DTM* s_FTX* s_CNT* gr_aperak_1* gr_aperak_2* gr_aperak_3* gr_aperak_4*
;

gr_aperak_1
:
	s_DOC s_DTM*
;

gr_aperak_2
:
	s_RFF s_DTM*
;

gr_aperak_3
:
	s_NAD s_CTA* s_COM*
;

gr_aperak_4
:
	s_ERC s_FTX* gr_aperak_5*
;

gr_aperak_5
:
	s_RFF s_FTX*
;

/* ------------------- AUTHOR ------------------- */
/* ------------------- AUTHOR ------------------- */
/* ------------------- AUTHOR ------------------- */
/* ------------------- AUTHOR ------------------- */
/* ------------------- AUTHOR ------------------- */
author
:
	s_BGM s_DTM* s_BUS* gr_author_1* gr_author_2* gr_author_3* gr_author_4* s_CNT*
	gr_author_9*
;

gr_author_1
:
	s_RFF s_DTM?
;

gr_author_2
:
	s_FII s_CTA? s_COM*
;

gr_author_3
:
	s_NAD s_CTA? s_COM*
;

gr_author_4
:
	s_LIN gr_author_5* gr_author_6* gr_author_7* gr_author_8*
;

gr_author_5
:
	s_RFF s_DTM?
;

gr_author_6
:
	s_SEQ s_GEI s_DTM* s_MOA? s_DOC*
;

gr_author_7
:
	s_FII s_CTA? s_COM*
;

gr_author_8
:
	s_NAD s_CTA? s_COM*
;

gr_author_9
:
	s_AUT s_DTM*
;

/* ------------------- BALANC ------------------- */
/* ------------------- BALANC ------------------- */
/* ------------------- BALANC ------------------- */
/* ------------------- BALANC ------------------- */
/* ------------------- BALANC ------------------- */
balanc
:
	s_BGM s_DTM+ s_RFF* s_CUX* s_FTX? gr_balanc_1* gr_balanc_3* gr_balanc_4*
	gr_balanc_7* gr_balanc_8*
;

gr_balanc_1
:
	s_NAD s_RFF* gr_balanc_2*
;

gr_balanc_2
:
	s_CTA s_COM*
;

gr_balanc_3
:
	s_CCI s_CAV?
;

gr_balanc_4
:
	s_LIN s_MOA+ s_DTM? s_RFF? s_QTY* gr_balanc_5*
;

gr_balanc_5
:
	s_CPT gr_balanc_6*
;

gr_balanc_6
:
	s_CCI s_CAV?
;

gr_balanc_7
:
	s_EQN s_MOA+
;

gr_balanc_8
:
	s_AUT s_DTM?
;

/* ------------------- BANSTA ------------------- */
/* ------------------- BANSTA ------------------- */
/* ------------------- BANSTA ------------------- */
/* ------------------- BANSTA ------------------- */
/* ------------------- BANSTA ------------------- */
bansta
:
	s_BGM s_DTM s_BUS? gr_bansta_1* gr_bansta_2* gr_bansta_3* gr_bansta_4* s_CNT*
	gr_bansta_9*
;

gr_bansta_1
:
	s_RFF s_DTM?
;

gr_bansta_2
:
	s_FII s_CTA? s_COM*
;

gr_bansta_3
:
	s_NAD s_CTA? s_COM*
;

gr_bansta_4
:
	s_LIN gr_bansta_5* gr_bansta_6*
;

gr_bansta_5
:
	s_RFF s_DTM?
;

gr_bansta_6
:
	s_SEQ s_GEI s_DTM* s_MOA? s_CUX? s_PCD? s_FTX? s_DOC* gr_bansta_7?
	gr_bansta_8?
;

gr_bansta_7
:
	s_FII s_CTA? s_COM*
;

gr_bansta_8
:
	s_NAD s_CTA? s_COM*
;

gr_bansta_9
:
	s_AUT s_DTM?
;

/* ------------------- BAPLIE ------------------- */
/* ------------------- BAPLIE ------------------- */
/* ------------------- BAPLIE ------------------- */
/* ------------------- BAPLIE ------------------- */
/* ------------------- BAPLIE ------------------- */
baplie
:
	s_BGM s_DTM* gr_baplie_1* gr_baplie_2* gr_baplie_4* s_UNS gr_baplie_6*
;

gr_baplie_1
:
	s_RFF s_DTM*
;

gr_baplie_2
:
	s_NAD gr_baplie_3*
;

gr_baplie_3
:
	s_CTA s_COM*
;

gr_baplie_4
:
	s_TDT s_RFF* s_FTX* gr_baplie_5*
;

gr_baplie_5
:
	s_LOC s_DTM*
;

gr_baplie_6
:
	s_LOC s_FTX* s_RFF* gr_baplie_7* s_CNT
;

gr_baplie_7
:
	s_EQD s_NAD* s_MEA* s_HAN* s_DIM* s_RFF* s_GDS* s_FTX* gr_baplie_8*
	gr_baplie_9* gr_baplie_10* gr_baplie_11*
;

gr_baplie_8
:
	s_LOC s_TSR? s_TDT?
;

gr_baplie_9
:
	s_TMP s_RNG? s_DTM?
;

gr_baplie_10
:
	s_EQA s_NAD?
;

gr_baplie_11
:
	s_DGS s_ATT* s_MEA* s_FTX* gr_baplie_12*
;

gr_baplie_12
:
	s_CTA s_COM*
;

/* ------------------- BERMAN ------------------- */
/* ------------------- BERMAN ------------------- */
/* ------------------- BERMAN ------------------- */
/* ------------------- BERMAN ------------------- */
/* ------------------- BERMAN ------------------- */
berman
:
	s_BGM s_DTM* s_FTX* s_RFF* s_QTY* gr_berman_1* gr_berman_3* gr_berman_7*
;

gr_berman_1
:
	s_NAD gr_berman_2*
;

gr_berman_2
:
	s_CTA s_COM*
;

gr_berman_3
:
	s_TDT s_RFF* s_DTM* s_MEA* s_FTX* s_COM* gr_berman_4* gr_berman_5*
;

gr_berman_4
:
	s_LOC s_DTM*
;

gr_berman_5
:
	s_GOR s_RFF* s_NAD* gr_berman_6*
;

gr_berman_6
:
	s_DOC s_DTM* s_LOC*
;

// Atraque

gr_berman_7
:
	s_TSR s_QTY* s_FTX* gr_berman_8*
;

gr_berman_8
:
	s_LOC s_MEA* s_DTM* s_QTY* s_POC* s_FTX* gr_berman_9*
;

// Operacion de Atraque

gr_berman_9
:
	s_HAN s_NAD* gr_berman_10*
;

gr_berman_10
:
	s_GDS s_FTX* s_MEA* s_EQN* s_DGS*
;

/* ------------------- BMISRM ------------------- */
/* ------------------- BMISRM ------------------- */
/* ------------------- BMISRM ------------------- */
/* ------------------- BMISRM ------------------- */
/* ------------------- BMISRM ------------------- */
bmisrm
:
	s_BGM s_DTM s_RFF+ s_LOC+ s_FTX* gr_bmisrm_1+ gr_bmisrm_3* gr_bmisrm_4+
;

gr_bmisrm_1
:
	s_PNA s_ADR? s_RFF? gr_bmisrm_2*
;

gr_bmisrm_2
:
	s_CTA s_COM*
;

gr_bmisrm_3
:
	s_DTM s_STS? s_FTX*
;

gr_bmisrm_4
:
	s_LIN s_QTY? s_FTX* gr_bmisrm_5* gr_bmisrm_7*
;

gr_bmisrm_5
:
	s_PNA s_ADR? s_RFF? gr_bmisrm_6*
;

gr_bmisrm_6
:
	s_CTA s_COM*
;

gr_bmisrm_7
:
	s_TDT s_EQD? s_RFF* s_QTY? s_MEA* s_PCD* gr_bmisrm_8*
;

gr_bmisrm_8
:
	s_PSD s_LOC* gr_bmisrm_9*
;

gr_bmisrm_9
:
	s_TEM s_MEA* s_PCD* s_DTM* s_FTX*
;

/* ------------------- BOPBNK ------------------- */
/* ------------------- BOPBNK ------------------- */
/* ------------------- BOPBNK ------------------- */
/* ------------------- BOPBNK ------------------- */
/* ------------------- BOPBNK ------------------- */
bopbnk
:
	s_BGM s_DTM+ gr_bopbnk_1* gr_bopbnk_2+ gr_bopbnk_3+ s_CNT*
;

gr_bopbnk_1
:
	s_RFF s_DTM?
;

gr_bopbnk_2
:
	s_NAD s_CTA? s_COM* s_FTX*
;

gr_bopbnk_3
:
	s_RFF s_CUX? s_MOA* s_LOC? gr_bopbnk_4+
;

gr_bopbnk_4
:
	s_RCS s_FTX? gr_bopbnk_5+
;

gr_bopbnk_5
:
	s_MOA s_ATT? s_NAD? gr_bopbnk_6? gr_bopbnk_7? s_LOC+
;

gr_bopbnk_6
:
	s_GIR s_QTY? s_PRI?
;

gr_bopbnk_7
:
	s_RFF s_DTM?
;

/* ------------------- CODECO ------------------- */
/* ------------------- CODECO ------------------- */
/* ------------------- CODECO ------------------- */
/* ------------------- CODECO ------------------- */
/* ------------------- CODECO ------------------- */
codeco
:
	s_BGM s_DTM* s_FTX* gr_codeco_1* gr_codeco_2? gr_codeco_4+ gr_codeco_6*
	gr_codeco_10+ s_CNT?
;

gr_codeco_1
:
	s_RFF s_DTM*
;

gr_codeco_2
:
	s_TDT s_DTM* s_RFF* gr_codeco_3*
;

gr_codeco_3
:
	s_LOC s_DTM*
;

gr_codeco_4
:
	s_NAD gr_codeco_5*
;

gr_codeco_5
:
	s_CTA s_COM*
;

gr_codeco_6
:
	s_GID s_HAN* s_FTX* s_PIA* s_MEA* gr_codeco_7* s_SGP* gr_codeco_8*
;

gr_codeco_7
:
	s_TMP s_RNG?
;

gr_codeco_8
:
	s_DGS s_FTX* s_MEA* gr_codeco_9*
;

gr_codeco_9
:
	s_CTA s_COM*
;

gr_codeco_10
:
	s_EQD s_RFF* s_TMD* s_DTM* s_LOC* s_MEA* s_DIM* s_SEL* s_FTX* s_PCD* s_EQA*
	s_COD? s_HAN* gr_codeco_11* gr_codeco_12* s_NAD* gr_codeco_14* gr_codeco_16*
;

gr_codeco_11
:
	s_DAM s_COD?
;

gr_codeco_12
:
	s_TDT s_DTM* s_RFF* gr_codeco_13*
;

gr_codeco_13
:
	s_LOC s_DTM*
;

gr_codeco_14
:
	s_DGS s_FTX* s_MEA* gr_codeco_15*
;

gr_codeco_15
:
	s_CTA s_COM*
;

gr_codeco_16
:
	s_TMP s_RNG?
;

/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
cusrep
:
	s_BGM s_DTM* s_QTY* s_POC* s_FTX* s_MEA* s_GEI* s_GPO? s_STS* gr_cusrep_1*
	gr_cusrep_2* gr_cusrep_3* gr_cusrep_4* gr_cusrep_5* gr_cusrep_6* gr_cusrep_9*
	gr_cusrep_11* gr_cusrep_12*
;

gr_cusrep_1
:
	s_RFF s_DTM?
;

gr_cusrep_2
:
	s_LOC s_DTM*
;

gr_cusrep_3
:
	s_LOC s_DTM*
;

gr_cusrep_4
:
	s_DOC s_RFF? s_DTM? s_LOC?
;

gr_cusrep_5
:
	s_TAX s_MOA? s_FII? s_LOC? s_RFF? s_DTM* s_GEI?
;

gr_cusrep_6
:
	s_NAD gr_cusrep_7* gr_cusrep_8*
;

gr_cusrep_7
:
	s_CTA s_COM*
;

gr_cusrep_8
:
	s_RFF s_DTM?
;

gr_cusrep_9
:
	s_TDT s_TPL? s_DTM? gr_cusrep_10*
;

gr_cusrep_10
:
	s_LOC s_GPO? s_DTM* s_QTY* s_NAD* s_MEA* s_POC* s_STS* s_FTX*
;

gr_cusrep_11
:
	s_EQD s_EQN?
;

gr_cusrep_12
:
	s_AUT s_DTM?
;

/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
ifcsum
:
	s_BGM s_DTM* s_MOA* s_FTX* s_CNT* s_PCD? s_GDS* gr_ifcsum_1* gr_ifcsum_2*
	gr_ifcsum_4* gr_ifcsum_7* gr_ifcsum_8* gr_ifcsum_9* gr_ifcsum_23*
	gr_ifcsum_27*
;

gr_ifcsum_1
:
	s_RFF s_DTM*
;

gr_ifcsum_2
:
	s_GOR s_DTM* s_LOC* s_SEL* s_FTX* gr_ifcsum_3*
;

gr_ifcsum_3
:
	s_DOC s_DTM?
;

// Consignatario Mercancia

gr_ifcsum_4
:
	s_NAD gr_ifcsum_5* gr_ifcsum_1*
;

gr_ifcsum_5
:
	s_CTA s_COM*
;

gr_ifcsum_7
:
	s_TCC s_CUX? s_PRI? s_EQN? s_PCD? s_MOA* s_QTY* s_LOC*
;

gr_ifcsum_8
:
	s_ICD s_DTM? s_FTX*
;

gr_ifcsum_9
:
	s_TDT s_DTM* gr_ifcsum_10* gr_ifcsum_11* s_SEL* s_FTX* gr_ifcsum_12*
	gr_ifcsum_13* gr_ifcsum_5* gr_ifcsum_15* gr_ifcsum_8* gr_ifcsum_1*
	gr_ifcsum_18*
;

gr_ifcsum_10
:
	s_TSR s_SCC*
;

gr_ifcsum_11
:
	s_LOC s_DTM*
;

gr_ifcsum_12
:
	s_MEA s_EQN?
;

gr_ifcsum_13
:
	s_DIM s_EQN?
;

gr_ifcsum_15
:
	s_TCC s_MOA* s_PCD?
;

gr_ifcsum_18
:
	s_NAD s_LOC* gr_ifcsum_5* gr_ifcsum_3* gr_ifcsum_21* gr_ifcsum_1*
;

gr_ifcsum_21
:
	s_TCC s_CUX? s_PRI? s_EQN? s_PCD? s_MOA* s_QTY*
;

gr_ifcsum_23
:
	s_EQD s_EQN? s_TPL? s_TMD? s_MEA* s_DIM* s_SEL* s_NAD* s_LOC* s_HAN? s_TMP?
	s_FTX* s_RFF* s_PCD* gr_ifcsum_24* gr_ifcsum_25* gr_ifcsum_5*
;

gr_ifcsum_24
:
	s_EQA s_EQN?
;

gr_ifcsum_25
:
	s_DGS s_FTX*
;

// BL

gr_ifcsum_27
:
	s_CNI gr_ifcsum_28* gr_ifcsum_30* s_CTA? s_COM* s_DTM* s_CNT* s_TSR* s_CUX*
	s_PCD* s_MOA* s_FTX* s_GDS* gr_ifcsum_11* gr_ifcsum_33* gr_ifcsum_1*
	gr_ifcsum_2* gr_ifcsum_37* gr_ifcsum_38* gr_ifcsum_8* gr_ifcsum_40*
	gr_ifcsum_46* gr_ifcsum_53* gr_ifcsum_73*
;

gr_ifcsum_28
:
	s_SGP gr_ifcsum_12*
;

gr_ifcsum_30
:
	s_TPL gr_ifcsum_12*
;

gr_ifcsum_33
:
	s_TOD s_LOC*
;

gr_ifcsum_37
:
	s_CPI s_RFF* s_CUX? s_LOC* s_MOA*
;

gr_ifcsum_38
:
	s_TCC s_LOC? s_FTX? s_CUX? s_PRI? s_EQN? s_PCD? s_MOA* s_QTY*
;

gr_ifcsum_40
:
	s_TDT s_DTM* gr_ifcsum_10* gr_ifcsum_11* gr_ifcsum_43* gr_ifcsum_44*
	gr_ifcsum_8*
;

gr_ifcsum_43
:
	s_RFF s_DTM?
;

gr_ifcsum_44
:
	s_TCC s_MOA* s_PCD?
;

gr_ifcsum_46
:
	s_NAD s_LOC* s_MOA* gr_ifcsum_5* gr_ifcsum_3* gr_ifcsum_21* gr_ifcsum_1*
	gr_ifcsum_37* gr_ifcsum_52*
;

gr_ifcsum_52
:
	s_TSR s_RFF? s_LOC? s_TPL? s_FTX*
;

// Partida

gr_ifcsum_53
:
	s_GID s_HAN? s_TMP? s_RNG? s_TMD? s_LOC* s_MOA* s_PIA* s_GIN* s_FTX*
	gr_ifcsum_54* gr_ifcsum_12* gr_ifcsum_13* gr_ifcsum_1* gr_ifcsum_58*
	gr_ifcsum_59* gr_ifcsum_2* gr_ifcsum_30* gr_ifcsum_64* gr_ifcsum_7*
	gr_ifcsum_8*
;

gr_ifcsum_54
:
	s_NAD s_DTM? s_GDS*
;

// Marcas y etiquetas de partida 

gr_ifcsum_58
:
	s_PCI s_RFF? s_DTM? s_GIN* s_MEA* s_DIM? s_FTX*
;

// Documentos de la partida

gr_ifcsum_59
:
	s_DOC s_DTM*
;

gr_ifcsum_64
:
	s_SGP s_SEQ? gr_ifcsum_12*
;

gr_ifcsum_68
:
	s_DGS s_FTX* gr_ifcsum_5* gr_ifcsum_12* gr_ifcsum_28*
;

gr_ifcsum_73
:
	s_EQD s_EQN? s_TMD? s_MEA* s_DIM* s_SEL* s_TPL* s_HAN? s_TMP? s_FTX* s_PCD*
	gr_ifcsum_21* gr_ifcsum_75* gr_ifcsum_24* gr_ifcsum_77*
;

gr_ifcsum_75
:
	s_NAD s_DTM?
;

gr_ifcsum_77
:
	s_DGS s_FTX* gr_ifcsum_5*
;
