grammar Message;

import edifact_d16b_segments;

message
:
	(
		s_UNH ["APERAK"] m_aperak
		| s_UNH ["AUTHOR"] m_author
		| s_UNH ["BALANC"] m_balanc
		| s_UNH ["BANSTA"] m_bansta
		| s_UNH ["BAPLIE"] m_baplie
		| s_UNH ["BERMAN"] m_berman
		| s_UNH ["BMISRM"] m_bmisrm
		| s_UNH ["BOPBNK"] m_bopbnk
		| s_UNH ["CODECO"] m_codeco
		| s_UNH ["CREMUL"] m_cremul
		| s_UNH ["CUSREP"] m_cusrep
		| s_UNH ["FINCAN"] m_fincan
		| s_UNH ["IFCSUM"] m_ifcsum
		| s_UNH ["INVOIC"] m_invoic
		| s_UNH ["ORDERS"] m_orders
		| s_UNH ["PAYMUL"] m_paymul
	) s_UNT
;

/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
/* ------------------- APERAK ------------------- */
m_aperak
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
m_author
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
m_balanc
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
m_bansta
:
	s_BGM s_DTM s_BUS? gr_bansta_1* gr_bansta_2* gr_bansta_3* gr_bansta_4+ s_CNT*
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
m_baplie
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
m_berman
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
m_bmisrm
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
m_bopbnk
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
m_codeco
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

/* ------------------- CREMUL ------------------- */
/* ------------------- CREMUL ------------------- */
/* ------------------- CREMUL ------------------- */
/* ------------------- CREMUL ------------------- */
/* ------------------- CREMUL ------------------- */
m_cremul
:
	s_BGM s_DTM? s_BUS? gr_cremul_1* gr_cremul_2* gr_cremul_3* gr_cremul_4+ s_CNT*
	gr_cremul_28*
;

gr_cremul_1
:
	s_RFF s_DTM?
;

gr_cremul_2
:
	s_FII s_CTA? s_COM*
;

gr_cremul_3
:
	s_NAD s_CTA? s_COM*
;

gr_cremul_4
:
	s_LIN s_DTM* s_BUS? s_MOA+ gr_cremul_5+ gr_cremul_6 gr_cremul_7* gr_cremul_10+
;

gr_cremul_5
:
	s_RFF s_DTM?
;

gr_cremul_6
:
	s_FII s_CTA? s_COM*
;

gr_cremul_7
:
	s_FCA s_MOA* gr_cremul_8*
;

gr_cremul_8
:
	s_ALC s_PCD? s_MOA* s_CUX? s_DTM? gr_cremul_9*
;

gr_cremul_9
:
	s_TAX s_MOA* s_CUX? s_DTM?
;

gr_cremul_10
:
	s_SEQ s_DTM* s_BUS? s_FII+ gr_cremul_11* gr_cremul_12? gr_cremul_13*
	gr_cremul_14* gr_cremul_15* gr_cremul_16* gr_cremul_17* gr_cremul_20?
;

gr_cremul_11
:
	s_RFF s_DTM?
;

gr_cremul_12
:
	s_PAI s_FTX?
;

gr_cremul_13
:
	s_MOA s_CUX? s_DTM* s_RFF?
;

gr_cremul_14
:
	s_NAD s_CTA? s_COM*
;

gr_cremul_15
:
	s_INP s_FTX? s_DTM?
;

gr_cremul_16
:
	s_GEI s_MOA? s_LOC* s_NAD? s_RCS? s_FTX*
;

gr_cremul_17
:
	s_FCA s_MOA* gr_cremul_18*
;

gr_cremul_18
:
	s_ALC s_PCD? s_MOA* s_CUX? s_DTM* gr_cremul_19*
;

gr_cremul_19
:
	s_TAX s_MOA* s_CUX? s_DTM?
;

gr_cremul_20
:
	s_PRC s_FTX* gr_cremul_21* gr_cremul_27?
;

gr_cremul_21
:
	s_DOC s_MOA* s_DTM* s_RFF* s_NAD* gr_cremul_22* gr_cremul_23* gr_cremul_24*
;

gr_cremul_22
:
	s_CUX s_DTM?
;

gr_cremul_23
:
	s_AJT s_MOA? s_RFF? s_FTX*
;

gr_cremul_24
:
	s_DLI s_MOA* s_PIA* s_DTM* gr_cremul_25* gr_cremul_26*
;

gr_cremul_25
:
	s_CUX s_DTM?
;

gr_cremul_26
:
	s_AJT s_MOA? s_RFF? s_FTX*
;

gr_cremul_27
:
	s_GEI s_MOA*
;

gr_cremul_28
:
	s_AUT s_DTM?
;

/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
/* ------------------- CUSREP ------------------- */
m_cusrep
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

/* ------------------- FINCAN ------------------- */
/* ------------------- FINCAN ------------------- */
/* ------------------- FINCAN ------------------- */
/* ------------------- FINCAN ------------------- */
/* ------------------- FINCAN ------------------- */
m_fincan
:
	s_BGM s_DTM s_BUS? gr_fincan_1* gr_fincan_2* gr_fincan_3* gr_fincan_4+ s_CNT*
	gr_fincan_6*
;

gr_fincan_1
:
	s_RFF s_DTM?
;

gr_fincan_2
:
	s_FII s_CTA? s_COM*
;

gr_fincan_3
:
	s_NAD s_CTA? s_COM*
;

gr_fincan_4
:
	s_LIN gr_fincan_5*
;

gr_fincan_5
:
	s_RFF s_DTM?
;

gr_fincan_6
:
	s_AUT s_DTM?
;

/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
/* ------------------- IFCSUM ------------------- */
m_ifcsum
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

/* ------------------- INVOIC ------------------- */
/* ------------------- INVOIC ------------------- */
/* ------------------- INVOIC ------------------- */
/* ------------------- INVOIC ------------------- */
/* ------------------- INVOIC ------------------- */
m_invoic
:
	s_BGM s_DTM+ s_PAI? s_ALI* s_IMD? s_FTX* s_LOC* s_GEI* s_DGS? s_GIR*
	gr_invoic_1* gr_invoic_2* gr_invoic_6* gr_invoic_7* gr_invoic_8* gr_invoic_9*
	gr_invoic_12* gr_invoic_13* gr_invoic_14* gr_invoic_16* gr_invoic_23*
	gr_invoic_24? gr_invoic_25? gr_invoic_26* gr_invoic_27* s_UNS s_CNT*
	gr_invoic_52+ gr_invoic_54* gr_invoic_55*
;

gr_invoic_1
:
	s_RFF s_DTM* s_GIR* s_LOC* s_MEA* s_QTY* s_FTX* s_MOA* s_RTE*
;

gr_invoic_2
:
	s_NAD s_LOC* s_FII* s_MOA* gr_invoic_3* gr_invoic_4* gr_invoic_5*
;

gr_invoic_3
:
	s_RFF s_DTM*
;

gr_invoic_4
:
	s_DOC s_DTM*
;

gr_invoic_5
:
	s_CTA s_COM*
;

gr_invoic_6
:
	s_TAX s_MOA? s_LOC*
;

gr_invoic_7
:
	s_CUX s_DTM*
;

gr_invoic_8
:
	s_PYT s_DTM* s_PCD? s_MOA? s_PAI? s_FII?
;

gr_invoic_9
:
	s_TDT s_TSR? gr_invoic_10* gr_invoic_11*
;

gr_invoic_10
:
	s_LOC s_DTM*
;

gr_invoic_11
:
	s_RFF s_DTM*
;

gr_invoic_12
:
	s_TOD s_LOC*
;

gr_invoic_13
:
	s_EQD s_SEL*
;

gr_invoic_14
:
	s_PAC s_MEA* s_EQD* gr_invoic_15*
;

gr_invoic_15
:
	s_PCI s_RFF? s_DTM* s_GIN*
;

gr_invoic_16
:
	s_ALC s_ALI* s_FTX? gr_invoic_17* gr_invoic_18? gr_invoic_19? gr_invoic_20*
	gr_invoic_21? gr_invoic_22*
;

gr_invoic_17
:
	s_RFF s_DTM*
;

gr_invoic_18
:
	s_QTY s_RNG?
;

gr_invoic_19
:
	s_PCD s_RNG?
;

gr_invoic_20
:
	s_MOA s_RNG? s_CUX? s_DTM?
;

gr_invoic_21
:
	s_RTE s_RNG?
;

gr_invoic_22
:
	s_TAX s_MOA?
;

gr_invoic_23
:
	s_RCS s_RFF* s_DTM* s_FTX*
;

gr_invoic_24
:
	s_AJT s_FTX*
;

gr_invoic_25
:
	s_INP s_FTX*
;

gr_invoic_26
:
	s_EFI s_CED* s_COM* s_RFF* s_DTM* s_QTY*
;

gr_invoic_27
:
	s_LIN s_PIA* s_PGI* s_IMD* s_MEA* s_QTY* s_PCD? s_ALI* s_DTM* s_GIN* s_GIR*
	s_QVR? s_EQD? s_FTX* s_DGS? gr_invoic_28* gr_invoic_29* gr_invoic_30*
	gr_invoic_31* gr_invoic_32* gr_invoic_34* gr_invoic_35* gr_invoic_36*
	gr_invoic_40* gr_invoic_46* gr_invoic_48* gr_invoic_49* gr_invoic_50*
	gr_invoic_51*
;

gr_invoic_28
:
	s_MOA s_CUX?
;

gr_invoic_29
:
	s_PYT s_DTM* s_PCD* s_MOA?
;

gr_invoic_30
:
	s_PRI s_CUX? s_APR? s_RNG? s_DTM*
;

gr_invoic_31
:
	s_RFF s_DTM*
;

gr_invoic_32
:
	s_PAC s_MEA* s_EQD? gr_invoic_33*
;

gr_invoic_33
:
	s_PCI s_RFF? s_DTM* s_GIN*
;

gr_invoic_34
:
	s_LOC s_QTY* s_DTM*
;

gr_invoic_35
:
	s_TAX s_MOA* s_LOC*
;

gr_invoic_36
:
	s_NAD s_LOC* s_FII* gr_invoic_37* gr_invoic_38* gr_invoic_39*
;

gr_invoic_37
:
	s_RFF s_DTM*
;

gr_invoic_38
:
	s_DOC s_DTM*
;

gr_invoic_39
:
	s_CTA s_COM*
;

gr_invoic_40
:
	s_ALC s_ALI* s_DTM* s_FTX? gr_invoic_41? gr_invoic_42? gr_invoic_43*
	gr_invoic_44? gr_invoic_45*
;

gr_invoic_41
:
	s_QTY s_RNG?
;

gr_invoic_42
:
	s_PCD s_RNG?
;

gr_invoic_43
:
	s_MOA s_RNG? s_CUX? s_DTM?
;

gr_invoic_44
:
	s_RTE s_RNG?
;

gr_invoic_45
:
	s_TAX s_MOA*
;

gr_invoic_46
:
	s_TDT gr_invoic_47*
;

gr_invoic_47
:
	s_LOC s_DTM*
;

gr_invoic_48
:
	s_TOD s_LOC*
;

gr_invoic_49
:
	s_RCS s_RFF* s_DTM* s_FTX*
;

gr_invoic_50
:
	s_GEI s_RFF* s_IMD* s_DTM* s_GIR* s_LOC* s_MEA* s_QTY* s_FTX* s_MOA*
;

gr_invoic_51
:
	s_EFI s_CED* s_COM* s_RFF* s_DTM* s_QTY*
;

gr_invoic_52
:
	s_MOA gr_invoic_53?
;

gr_invoic_53
:
	s_RFF s_DTM*
;

gr_invoic_54
:
	s_TAX s_MOA*
;

gr_invoic_55
:
	s_ALC s_ALI? s_MOA* s_FTX?
;

/* ------------------- ORDERS ------------------- */
/* ------------------- ORDERS ------------------- */
/* ------------------- ORDERS ------------------- */
/* ------------------- ORDERS ------------------- */
/* ------------------- ORDERS ------------------- */
m_orders
:
	s_BGM s_DTM+ s_PAI? s_ALI* s_IMD* s_FTX* s_GIR* gr_orders_1* gr_orders_2*
	gr_orders_6* gr_orders_7* gr_orders_8* gr_orders_10* gr_orders_12*
	gr_orders_13* gr_orders_15* gr_orders_16* gr_orders_18* gr_orders_19*
	gr_orders_25* gr_orders_26* gr_orders_28* gr_orders_29* s_UNS s_MOA* s_CNT*
	gr_orders_63*
;

gr_orders_1
:
	s_RFF s_DTM*
;

gr_orders_2
:
	s_NAD s_LOC* s_FII* gr_orders_3* gr_orders_4* gr_orders_5*
;

gr_orders_3
:
	s_RFF s_DTM*
;

gr_orders_4
:
	s_DOC s_DTM*
;

gr_orders_5
:
	s_CTA s_COM*
;

gr_orders_6
:
	s_TAX s_MOA? s_LOC*
;

gr_orders_7
:
	s_CUX s_PCD* s_DTM*
;

gr_orders_8
:
	s_PYT s_DTM* s_PCD? gr_orders_9*
;

gr_orders_9
:
	s_MOA s_GIR* s_RJL*
;

gr_orders_10
:
	s_TDT gr_orders_11*
;

gr_orders_11
:
	s_LOC s_DTM*
;

gr_orders_12
:
	s_TOD s_LOC*
;

gr_orders_13
:
	s_PAC s_MEA* gr_orders_14*
;

gr_orders_14
:
	s_PCI s_RFF? s_DTM* s_GIN*
;

gr_orders_15
:
	s_EQD s_HAN* s_MEA* s_FTX*
;

gr_orders_16
:
	s_SCC s_FTX* s_RFF* gr_orders_17*
;

gr_orders_17
:
	s_QTY s_DTM*
;

gr_orders_18
:
	s_APR s_DTM* s_RNG?
;

gr_orders_19
:
	s_ALC s_ALI* s_DTM* gr_orders_20? gr_orders_21? gr_orders_22* gr_orders_23?
	gr_orders_24*
;

gr_orders_20
:
	s_QTY s_RNG?
;

gr_orders_21
:
	s_PCD s_RNG?
;

gr_orders_22
:
	s_MOA s_RNG?
;

gr_orders_23
:
	s_RTE s_RNG?
;

gr_orders_24
:
	s_TAX s_MOA?
;

gr_orders_25
:
	s_RCS s_RFF* s_DTM* s_FTX*
;

gr_orders_26
:
	s_DGS s_FTX* gr_orders_27*
;

gr_orders_27
:
	s_CTA s_COM*
;

gr_orders_28
:
	s_EFI s_CED* s_COM* s_RFF* s_DTM* s_QTY*
;

gr_orders_29
:
	s_LIN s_PIA* s_IMD* s_MEA* s_QTY* s_PCD* s_ALI* s_DTM* s_MOA* s_GEI* s_GIN*
	s_GIR* s_QVR? s_DOC* s_PAI? s_MTD* s_FTX* gr_orders_30* gr_orders_31*
	gr_orders_33* gr_orders_34* gr_orders_35* gr_orders_38* gr_orders_40*
	gr_orders_41* gr_orders_45* gr_orders_51* gr_orders_53* gr_orders_54*
	gr_orders_55* gr_orders_57* gr_orders_58* gr_orders_60* gr_orders_62*
;

gr_orders_30
:
	s_CCI s_CAV* s_MEA*
;

gr_orders_31
:
	s_PYT s_DTM* s_PCD? gr_orders_32*
;

gr_orders_32
:
	s_MOA s_GIR*
;

gr_orders_33
:
	s_PRI s_CUX? s_APR* s_RNG? s_DTM*
;

gr_orders_34
:
	s_RFF s_DTM* s_GEI* s_MOA*
;

gr_orders_35
:
	s_PAC s_MEA* s_QTY* s_DTM* gr_orders_36? gr_orders_37*
;

gr_orders_36
:
	s_RFF s_DTM*
;

gr_orders_37
:
	s_PCI s_RFF? s_DTM* s_GIN*
;

gr_orders_38
:
	s_LOC s_PCD? s_DTM* gr_orders_39*
;

gr_orders_39
:
	s_QTY s_STS*
;

gr_orders_40
:
	s_TAX s_MOA? s_LOC*
;

gr_orders_41
:
	s_NAD s_LOC* s_FII* gr_orders_42* gr_orders_43* gr_orders_44*
;

gr_orders_42
:
	s_RFF s_DTM*
;

gr_orders_43
:
	s_DOC s_DTM*
;

gr_orders_44
:
	s_CTA s_COM*
;

gr_orders_45
:
	s_ALC s_ALI* s_DTM* gr_orders_46? gr_orders_47? gr_orders_48* gr_orders_49?
	gr_orders_50*
;

gr_orders_46
:
	s_QTY s_RNG?
;

gr_orders_47
:
	s_PCD s_RNG?
;

gr_orders_48
:
	s_MOA s_RNG?
;

gr_orders_49
:
	s_RTE s_RNG?
;

gr_orders_50
:
	s_TAX s_MOA?
;

gr_orders_51
:
	s_TDT gr_orders_52*
;

gr_orders_52
:
	s_LOC s_DTM*
;

gr_orders_53
:
	s_TOD s_LOC*
;

gr_orders_54
:
	s_EQD s_HAN* s_MEA* s_FTX*
;

gr_orders_55
:
	s_SCC s_FTX* s_RFF* gr_orders_56*
;

gr_orders_56
:
	s_QTY s_DTM*
;

gr_orders_57
:
	s_RCS s_RFF* s_DTM* s_FTX*
;

gr_orders_58
:
	s_STG gr_orders_59*
;

gr_orders_59
:
	s_QTY s_MOA?
;

gr_orders_60
:
	s_DGS s_FTX* gr_orders_61*
;

gr_orders_61
:
	s_CTA s_COM*
;

gr_orders_62
:
	s_EFI s_CED* s_COM* s_RFF* s_DTM* s_QTY*
;

gr_orders_63
:
	s_ALC s_ALI? s_MOA*
;

/* ------------------- PAYMUL ------------------- */
/* ------------------- PAYMUL ------------------- */
/* ------------------- PAYMUL ------------------- */
/* ------------------- PAYMUL ------------------- */
/* ------------------- PAYMUL ------------------- */
m_paymul
:
	s_BGM s_DTM s_BUS? gr_paymul_1* gr_paymul_2* gr_paymul_3* gr_paymul_4* s_CNT*
	gr_paymul_24*
;

gr_paymul_1
:
	s_RFF s_DTM?
;

gr_paymul_2
:
	s_FII s_CTA? s_COM*
;

gr_paymul_3
:
	s_NAD s_CTA? s_COM*
;

gr_paymul_4
:
	s_LIN s_DTM* s_RFF* s_BUS? s_FCA? gr_paymul_5? gr_paymul_6* gr_paymul_7*
	gr_paymul_8? gr_paymul_9* gr_paymul_10? gr_paymul_11*
;

gr_paymul_5
:
	s_MOA s_CUX? s_DTM* s_RFF?
;

gr_paymul_6
:
	s_FII s_CTA? s_COM*
;

gr_paymul_7
:
	s_NAD s_CTA? s_COM*
;

gr_paymul_8
:
	s_INP s_FTX? s_DTM*
;

gr_paymul_9
:
	s_GEI s_MOA? s_LOC* s_NAD? s_RCS? s_FTX*
;

gr_paymul_10
:
	s_PRC s_FTX
;

gr_paymul_11
:
	s_SEQ s_MOA s_DTM? s_BUS? s_RFF* s_PAI? s_FCA? gr_paymul_12* gr_paymul_13*
	gr_paymul_14* gr_paymul_15* gr_paymul_16?
;

gr_paymul_12
:
	s_FII s_CTA? s_COM*
;

gr_paymul_13
:
	s_NAD s_CTA? s_COM*
;

gr_paymul_14
:
	s_INP s_FTX? s_DTM*
;

gr_paymul_15
:
	s_GEI s_MOA? s_LOC* s_NAD? s_RCS? s_FTX*
;

gr_paymul_16
:
	s_PRC s_FTX* gr_paymul_17* gr_paymul_23?
;

gr_paymul_17
:
	s_DOC s_MOA* s_DTM* s_RFF* s_NAD* gr_paymul_18* gr_paymul_19* gr_paymul_20*
;

gr_paymul_18
:
	s_CUX s_DTM?
;

gr_paymul_19
:
	s_AJT s_MOA s_RFF? s_FTX*
;

gr_paymul_20
:
	s_DLI s_MOA+ s_PIA* s_DTM* gr_paymul_21* gr_paymul_22*
;

gr_paymul_21
:
	s_CUX s_DTM?
;

gr_paymul_22
:
	s_AJT s_MOA s_RFF? s_FTX*
;

gr_paymul_23
:
	s_GEI s_MOA*
;

gr_paymul_24
:
	s_AUT s_DTM?
;
