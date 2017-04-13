/**
 * D93a
 * 	http://www.unece.org/trade/untdid/d93/
 * 	http://www.unece.org/fileadmin/DAM/trade/untdid/d14b/trmd/ifcsum_c.htm
 * http://content.portdebarcelona.cat/cntmng/d/d/workspace/SpacesStore/2185ccaf-a590-4dba-8a64-74d95cb929b7/GuiaDSDescarga_Carga33b.pdf%7cGuiaDSDescarga_Carga33b.pdf
 */
grammar Ifcsum;

import edifact_d16b_segments, edifact_d16b_components, edifact_d16b_fields;

 ifcsum
 :
 	s_UNH["IFCSUM"] s_BGM s_DTM* s_MOA* s_FTX* s_CNT* s_PCD? s_GDS* gr_1* gr_2* gr_4* gr_7* gr_8* gr_9* gr_23*
 	gr_27* s_UNT
 ;

 gr_1
 :
 	s_RFF s_DTM*
 ;

 gr_2
 :
 	s_GOR s_DTM* s_LOC* s_SEL* s_FTX* gr_3*
 ;

 gr_3
 :
 	s_DOC s_DTM?
 ;

/* Consignatario Mercancia */
 gr_4
 :
 	s_NAD gr_5* gr_1*
 ;

 gr_5
 :
 	s_CTA s_COM*
 ;

 gr_7
 :
 	s_TCC s_CUX? s_PRI? s_EQN? s_PCD? s_MOA* s_QTY* s_LOC*
 ;

 gr_8
 :
 	s_ICD s_DTM? s_FTX*
 ;

 gr_9
 :
 	s_TDT s_DTM* gr_10* gr_11* s_SEL* s_FTX* gr_12* gr_13* gr_5* gr_15* gr_8* gr_1* gr_18*
 ;

 gr_10
 :
 	s_TSR s_SCC*
 ;

 gr_11
 :
 	s_LOC s_DTM*
 ;

 gr_12
 :
 	s_MEA s_EQN?
 ;

 gr_13
 :
 	s_DIM s_EQN?
 ;

 gr_15
 :
 	s_TCC s_MOA* s_PCD?
 ;

 gr_18
 :
 	s_NAD s_LOC* gr_5* gr_3* gr_21* gr_1*
 ;

 gr_21
 :
 	s_TCC s_CUX? s_PRI? s_EQN? s_PCD? s_MOA* s_QTY*
 ;

 gr_23
 :
 	s_EQD s_EQN? s_TPL? s_TMD? s_MEA* s_DIM* s_SEL* s_NAD* s_LOC* s_HAN? s_TMP? s_FTX* s_RFF* s_PCD* gr_24*
 	gr_25* gr_5*
 ;

 gr_24
 :
 	s_EQA s_EQN?
 ;

 gr_25
 :
 	s_DGS s_FTX*
 ;

/* BL */
 gr_27
 :
 	s_CNI gr_28* gr_30* s_CTA? s_COM* s_DTM* s_CNT* s_TSR* s_CUX* s_PCD* s_MOA* s_FTX* s_GDS* gr_11*
 	gr_33* gr_1* gr_2* gr_37* gr_38* gr_8* gr_40* gr_46* gr_53* gr_73*
 ;

 gr_28
 :
 	s_SGP gr_12*
 ;

 gr_30
 :
 	s_TPL gr_12*
 ;

 gr_33
 :
 	s_TOD s_LOC*
 ;

 gr_37
 :
 	s_CPI s_RFF* s_CUX? s_LOC* s_MOA*
 ;

 gr_38
 :
 	s_TCC s_LOC? s_FTX? s_CUX? s_PRI? s_EQN? s_PCD? s_MOA* s_QTY*
 ;

 gr_40
 :
 	s_TDT s_DTM* gr_10* gr_11* gr_43* gr_44* gr_8*
 ;

 gr_43
 :
 	s_RFF s_DTM?
 ;

 gr_44
 :
 	s_TCC s_MOA* s_PCD?
 ;

 gr_46
 :
 	s_NAD s_LOC* s_MOA* gr_5* gr_3* gr_21* gr_1* gr_37* gr_52*
 ;

 gr_52
 :
 	s_TSR s_RFF? s_LOC? s_TPL? s_FTX*
 ;

/* Partida */
 gr_53
 :
 	s_GID s_HAN? s_TMP? s_RNG? s_TMD? s_LOC* s_MOA* s_PIA* s_GIN* s_FTX* gr_54* gr_12* gr_13* gr_1*
 	gr_58* gr_59* gr_2* gr_30* gr_64* gr_7* gr_8*
 ;

 gr_54
 :
 	s_NAD s_DTM? s_GDS*
 ;

/* Marcas y etiquetas de partida */
 gr_58
 :
 	s_PCI s_RFF? s_DTM? s_GIN* s_MEA* s_DIM? s_FTX*
 ;

/* Documentos de la partida */
 gr_59
 :
 	s_DOC s_DTM*
 ;

 gr_64
 :
 	s_SGP s_SEQ? gr_12*
 ;

 gr_68
 :
 	s_DGS s_FTX* gr_5* gr_12* gr_28*
 ;

 gr_73
 :
 	s_EQD s_EQN? s_TMD? s_MEA* s_DIM* s_SEL* s_TPL* s_HAN? s_TMP? s_FTX* s_PCD* gr_21* gr_75* gr_24*
 	gr_77*
 ;

 gr_75
 :
 	s_NAD s_DTM?
 ;

 gr_77
 :
 	s_DGS s_FTX* gr_5*
 ;
