parser grammar edifact_d16b_segments;

import edifact_d16b_components, edifact_d16b_fields, edifact_common;

/** ADR  ADDRESS. FIXME Revisar.*/
s_ADR
:
	'ADR+' c_C817
	(
		PLUS c_C090?
	)?
	(
		PLUS d_3164?
	)?
	(
		PLUS d_3251?
	)?
	(
		PLUS d_3207?
	)?
	(
		PLUS c_C819
	)?
	(
		PLUS c_C517
	)? EOL
;

/** AGR  AGREEMENT IDENTIFICATION. */
s_AGR
:
	'AGR+' c_C543?
	(
		PLUS d_9419?
	)? EOL
;

/** AJT  ADJUSTMENT DETAILS. */
s_AJT
:
	'AJT+' d_4465
	(
		PLUS d_1082?
	)? EOL
;

/** ALC  ALLOWANCE OR CHARGE. */
s_ALC
:
	'ALC+' d_5463
	(
		PLUS c_C552
	)?
	(
		PLUS d_4471?
	)?
	(
		PLUS d_1227?
	)?
	(
		PLUS c_C214
	)? EOL
;

/** ALI  ADDITIONAL INFORMATION. */
s_ALI
:
	'ALI+' d_3239?
	(
		PLUS d_9213?
	)?
	(
		PLUS d_4183?
	)?
	(
		PLUS d_4183?
	)?
	(
		PLUS d_4183?
	)?
	(
		PLUS d_4183?
	)?
	(
		PLUS d_4183?
	)? EOL
;

/** APR  ADDITIONAL PRICE INFORMATION. */
s_APR
:
	'APR+' d_4043?
	(
		PLUS c_C138?
	)?
	(
		PLUS c_C960
	)? EOL
;

/** ARD  MONETARY AMOUNT FUNCTION. */
s_ARD
:
	'ARD+' c_C549
	(
		PLUS c_C008
	)? EOL
;

/** ARR  ARRAY INFORMATION. */
s_ARR
:
	'ARR+' c_C778
	(
		PLUS c_C770
	)? EOL
;

/** ASI  ARRAY STRUCTURE IDENTIFICATION. */
s_ASI
:
	'ASI+' c_C779
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** ATT  ATTRIBUTE. */
s_ATT
:
	'ATT+' d_9017
	(
		PLUS c_C955
	)?
	(
		PLUS c_C956
	)? EOL
;

/** AUT  AUTHENTICATION RESULT. */
s_AUT
:
	'AUT+' d_9280
	(
		PLUS d_9282?
	)? EOL
;

/** BAS  BASIS. */
s_BAS
:
	'BAS+' d_9045 PLUS c_C974 EOL
;

/** BGM  BEGINNING OF MESSAGE. */
s_BGM
:
	'BGM+' c_C002
	(
		PLUS c_C106
	)?
	(
		PLUS d_1225?
	)?
	(
		PLUS d_4343?
	)?
	(
		PLUS d_1373?
	)?
	(
		PLUS d_3453?
	)? EOL
;

/** BII  STRUCTURE IDENTIFICATION. */
s_BII
:
	'BII+' d_7429 PLUS c_C045
	(
		PLUS d_7140?
	)? EOL
;

/** BUS  BUSINESS FUNCTION. */
s_BUS
:
	'BUS+' c_C521?
	(
		PLUS d_3279?
	)?
	(
		PLUS d_4487?
	)?
	(
		PLUS c_C551?
	)?
	(
		PLUS d_4463?
	)? EOL
;

/** CAV  CHARACTERISTIC VALUE. */
s_CAV
:
	'CAV+' c_C889 EOL
;

/** CCD  CREDIT COVER DETAILS. */
s_CCD
:
	'CCD+' d_4505?
	(
		PLUS d_4507?
	)?
	(
		PLUS d_4509?
	)? EOL
;

/** CCI  CHARACTERISTIC/CLASS ID. */
s_CCI
:
	'CCI+' d_7059?
	(
		PLUS c_C502
	)?
	(
		PLUS c_C240?
	)?
	(
		PLUS d_4051?
	)? EOL
;

/** CDI  PHYSICAL OR LOGICAL STATE. */
s_CDI
:
	'CDI+' d_7001 PLUS c_C564 EOL
;

/** CDS  CODE SET IDENTIFICATION. */
s_CDS
:
	'CDS+' c_C702
	(
		PLUS d_1507?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** CDV  CODE VALUE DEFINITION. */
s_CDV
:
	'CDV+' d_9426
	(
		PLUS d_9434?
	)?
	(
		PLUS d_4513?
	)?
	(
		PLUS d_9453?
	)?
	(
		PLUS d_7299?
	)? EOL
;

/** CED  COMPUTER ENVIRONMENT DETAILS. */
s_CED
:
	'CED+' d_1501 PLUS c_C079
	(
		PLUS d_9448?
	)? EOL
;

/** CIN  CLINICAL INFORMATION. */
s_CIN
:
	'CIN+' d_6415
	(
		PLUS c_C836
	)?
	(
		PLUS c_C837
	)? EOL
;

/** CLA  CLAUSE IDENTIFICATION. */
s_CLA
:
	'CLA+' d_4059
	(
		PLUS c_C970
	)? EOL
;

/** CLI  CLINICAL INTERVENTION. */
s_CLI
:
	'CLI+' d_9441
	(
		PLUS c_C828
	)? EOL
;

/** CMP  COMPOSITE DATA ELEMENT IDENTIFICATION. */
s_CMP
:
	'CMP+' d_9146
	(
		PLUS d_1507?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** CNI  CONSIGNMENT INFORMATION. */
s_CNI
:
	'CNI+' d_1490?
	(
		PLUS c_C503
	)?
	(
		PLUS d_1312?
	)? EOL
;

/** CNT  CONTROL TOTAL. */
s_CNT
:
	'CNT+' c_C270 EOL
;

/** COD  COMPONENT DETAILS. */
s_COD
:
	'COD+' c_C823
	(
		PLUS c_C824
	)? EOL
;

/** COM  COMMUNICATION CONTACT. */
s_COM
:
	'COM+' c_C076 EOL
;

/** COT  CONTRIBUTION DETAILS. */
s_COT
:
	'COT+' d_5047
	(
		PLUS c_C953?
	)?
	(
		PLUS c_C522?
	)?
	(
		PLUS c_C203?
	)?
	(
		PLUS c_C960
	)? EOL
;

/** CPI  CHARGE PAYMENT INSTRUCTIONS. */
s_CPI
:
	'CPI+' c_C229?
	(
		PLUS c_C231?
	)?
	(
		PLUS d_4237?
	)? EOL
;

/** CPS  CONSIGNMENT PACKING SEQUENCE. */
s_CPS
:
	'CPS+' d_7164
	(
		PLUS d_7166?
	)?
	(
		PLUS d_7075?
	)? EOL
;

/** CPT  ACCOUNT IDENTIFICATION. */
s_CPT
:
	'CPT+' d_4437 PLUS c_C593 EOL
;

/** CST  CUSTOMS STATUS OF GOODS. */
s_CST
:
	'CST+' d_1496?
	(
		PLUS c_C246?
	)?
	(
		PLUS c_C246?
	)?
	(
		PLUS c_C246?
	)?
	(
		PLUS c_C246?
	)?
	(
		PLUS c_C246?
	)? EOL
;

/** CTA  CONTACT INFORMATION. */
s_CTA
:
	'CTA+' d_3139?
	(
		PLUS c_C056
	)? EOL
;

/** CUX  CURRENCIES. */
s_CUX
:
	'CUX+' c_C504
	(
		PLUS c_C504?
	)?
	(
		PLUS d_5402?
	)?
	(
		PLUS d_6341?
	)? EOL
;

/** DAM  DAMAGE. */
s_DAM
:
	'DAM+' d_7493
	(
		PLUS c_C821
	)?
	(
		PLUS c_C822
	)?
	(
		PLUS c_C825
	)?
	(
		PLUS c_C826
	)? EOL
;

/** DFN  DEFINITION FUNCTION. */
s_DFN
:
	'DFN+' d_9023
	(
		PLUS d_9025?
	)?
	(
		PLUS d_4519?
	)? EOL
;

/** DGS  DANGEROUS GOODS. */
s_DGS
:
	'DGS+' d_8273?
	(
		PLUS c_C205?
	)?
	(
		PLUS c_C234
	)?
	(
		PLUS c_C223
	)?
	(
		PLUS d_8339?
	)?
	(
		PLUS d_8364?
	)?
	(
		PLUS d_8410?
	)?
	(
		PLUS d_8126?
	)?
	(
		PLUS c_C235
	)?
	(
		PLUS c_C236
	)?
	(
		PLUS d_8255?
	)?
	(
		PLUS d_8179?
	)?
	(
		PLUS d_8211?
	)?
	(
		PLUS c_C289
	)? EOL
;

/** DII  DIRECTORY IDENTIFICATION. */
s_DII
:
	'DII+' d_1056 PLUS d_1058
	(
		PLUS d_9148?
	)?
	(
		PLUS d_1476?
	)?
	(
		PLUS d_3453?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** DIM  DIMENSIONS. */
s_DIM
:
	'DIM+' d_6145 PLUS c_C211 EOL
;

/** DLI  DOCUMENT LINE IDENTIFICATION. */
s_DLI
:
	'DLI+' d_1073 PLUS d_1082 EOL
;

/** DLM  DELIVERY LIMITATIONS. */
s_DLM
:
	'DLM+' d_4455?
	(
		PLUS c_C522?
	)?
	(
		PLUS c_C214
	)?
	(
		PLUS d_4457?
	)? EOL
;

/** DMS  DOCUMENT/MESSAGE SUMMARY. */
s_DMS
:
	'DMS+' c_C106
	(
		PLUS c_C002
	)?
	(
		PLUS d_7240?
	)? EOL
;

/** DOC  DOCUMENT/MESSAGE DETAILS. */
s_DOC
:
	'DOC+' c_C002
	(
		PLUS c_C503
	)?
	(
		PLUS d_3153?
	)?
	(
		PLUS d_1220?
	)?
	(
		PLUS d_1218?
	)? EOL
;

/** DRD  DATA REPRESENTATION DETAILS. */
s_DRD
:
	'DRD+' d_7512?
	(
		PLUS d_7515?
	)?
	(
		PLUS d_9169?
	)?
	(
		PLUS d_6174?
	)? EOL
;

/** DSG  DOSAGE ADMINISTRATION. */
s_DSG
:
	'DSG+' d_6085
	(
		PLUS c_C838
	)? EOL
;

/** DSI  DATA SET IDENTIFICATION. */
s_DSI
:
	'DSI+' c_C782
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS c_C286?
	)?
	(
		PLUS d_1060?
	)? EOL
;

/** DTM  DATE/TIME/PERIOD. */
s_DTM
:
	'DTM+' c_C507 EOL
;

/** EDT  EDITING DETAILS. */
s_EDT
:
	'EDT+' d_6178?
	(
		PLUS d_9026?
	)?
	(
		PLUS d_9031?
	)?
	(
		PLUS d_4447?
	)? EOL
;

/** EFI  EXTERNAL FILE LINK IDENTIFICATION. */
s_EFI
:
	'EFI+' c_C077
	(
		PLUS c_C099?
	)?
	(
		PLUS d_1050?
	)?
	(
		PLUS d_9450?
	)? EOL
;

/** ELM  SIMPLE DATA ELEMENT DETAILS. */
s_ELM
:
	'ELM+' d_9150
	(
		PLUS d_9153?
	)?
	(
		PLUS d_6113?
	)?
	(
		PLUS d_9156?
	)?
	(
		PLUS d_9158?
	)?
	(
		PLUS d_9161?
	)?
	(
		PLUS d_1507?
	)?
	(
		PLUS d_4513?
	)?
	(
		PLUS d_6432?
	)? EOL
;

/** ELU  DATA ELEMENT USAGE DETAILS. */
s_ELU
:
	'ELU+' d_9162
	(
		PLUS d_7299?
	)?
	(
		PLUS d_1050?
	)?
	(
		PLUS d_4513?
	)?
	(
		PLUS d_6176?
	)?
	(
		PLUS d_9453?
	)?
	(
		PLUS d_9285?
	)?
	(
		PLUS d_9175?
	)? EOL
;

/** ELV  ELEMENT VALUE DEFINITION. */
s_ELV
:
	'ELV+' d_9029
	(
		PLUS d_9422?
	)?
	(
		PLUS d_7299?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** EMP  EMPLOYMENT DETAILS. */
s_EMP
:
	'EMP+' d_9003
	(
		PLUS c_C948
	)?
	(
		PLUS c_C951
	)?
	(
		PLUS c_C950
	)?
	(
		PLUS d_3480?
	)?
	(
		PLUS d_9035?
	)? EOL
;

/** EQA  ATTACHED EQUIPMENT. */
s_EQA
:
	'EQA+' d_8053
	(
		PLUS c_C237
	)? EOL
;

/** EQD  EQUIPMENT DETAILS. */
s_EQD
:
	'EQD+' d_8053
	(
		PLUS c_C237
	)?
	(
		PLUS c_C224
	)?
	(
		PLUS d_8077?
	)?
	(
		PLUS d_8249?
	)?
	(
		PLUS d_8169?
	)?
	(
		PLUS d_4233?
	)? EOL
;

/** EQN  NUMBER OF UNITS. */
s_EQN
:
	'EQN+' c_C523 EOL
;

/** ERC  APPLICATION ERROR INFORMATION. */
s_ERC
:
	'ERC+' c_C901 EOL
;

/** ERP  ERROR POINT DETAILS. */
s_ERP
:
	'ERP+' c_C701
	(
		PLUS c_C853
	)? EOL
;

/** EVE  EVENT. */
s_EVE
:
	'EVE+' d_9635?
	(
		PLUS c_C004
	)?
	(
		PLUS c_C030
	)?
	(
		PLUS c_C063
	)?
	(
		PLUS d_1229?
	)? EOL
;

/** FCA  FINANCIAL CHARGES ALLOCATION. */
s_FCA
:
	'FCA+' d_4471
	(
		PLUS c_C878?
	)? EOL
;

/** FII  FINANCIAL INSTITUTION INFORMATION. */
s_FII
:
	'FII+' d_3035
	(
		PLUS c_C078
	)?
	(
		PLUS c_C088?
	)?
	(
		PLUS d_3207?
	)? EOL
;

/** FNS  FOOTNOTE SET. */
s_FNS
:
	'FNS+' c_C783
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** FNT  FOOTNOTE. */
s_FNT
:
	'FNT+' c_C784
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** FOR  FORMULA. */
s_FOR
:
	'FOR+' d_9501
	(
		PLUS d_7402?
	)?
	(
		PLUS d_9502?
	)?
	(
		PLUS d_4440?
	)?
	(
		PLUS c_C961
	)? EOL
;

/** FSQ  FORMULA SEQUENCE. */
s_FSQ
:
	'FSQ+' d_9507
	(
		PLUS d_9509?
	)?
	(
		PLUS d_1050?
	)?
	(
		PLUS d_9510?
	)?
	(
		PLUS d_4440?
	)? EOL
;

/** FTX  FREE TEXT. */
s_FTX
:
	'FTX+' d_4451
	(
		PLUS d_4453?
	)?
	(
		PLUS c_C107?
	)?
	(
		PLUS c_C108?
	)?
	(
		PLUS d_3453?
	)?
	(
		PLUS d_4447?
	)? EOL
;

/** GDS  NATURE OF CARGO. */
s_GDS
:
	'GDS+' c_C703?
	(
		PLUS c_C288
	)? EOL
;

/** GEI  PROCESSING INFORMATION. */
s_GEI
:
	'GEI+' d_9649
	(
		PLUS c_C012
	)?
	(
		PLUS d_7187?
	)? EOL
;

/** GID  GOODS ITEM DETAILS. */
s_GID
:
	'GID+' d_1496?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)?
	(
		PLUS c_C213
	)? EOL
;

/** GIN  GOODS IDENTITY NUMBER. */
s_GIN
:
	'GIN+' d_7405 PLUS c_C208
	(
		PLUS c_C208?
	)?
	(
		PLUS c_C208?
	)?
	(
		PLUS c_C208?
	)?
	(
		PLUS c_C208?
	)? EOL
;

/** GIR  RELATED IDENTIFICATION NUMBERS. */
s_GIR
:
	'GIR+' d_7297 PLUS c_C206
	(
		PLUS c_C206?
	)?
	(
		PLUS c_C206?
	)?
	(
		PLUS c_C206?
	)?
	(
		PLUS c_C206?
	)? EOL
;

/** GOR  GOVERNMENTAL REQUIREMENTS. */
s_GOR
:
	'GOR+' d_8323?
	(
		PLUS c_C232
	)?
	(
		PLUS c_C232
	)?
	(
		PLUS c_C232
	)?
	(
		PLUS c_C232
	)? EOL
;

/** GPO  GEOGRAPHICAL POSITION. */
s_GPO
:
	'GPO+' d_6029
	(
		PLUS d_6000?
	)?
	(
		PLUS d_6002?
	)?
	(
		PLUS d_6096?
	)? EOL
;

/** GRU  SEGMENT GROUP USAGE DETAILS. */
s_GRU
:
	'GRU+' d_9164
	(
		PLUS d_7299?
	)?
	(
		PLUS d_6176?
	)?
	(
		PLUS d_4513?
	)?
	(
		PLUS d_1050?
	)? EOL
;

/** HAN  HANDLING INSTRUCTIONS. */
s_HAN
:
	'HAN+' c_C524
	(
		PLUS c_C218
	)? EOL
;

/** HYN  HIERARCHY INFORMATION. */
s_HYN
:
	'HYN+' d_7173
	(
		PLUS d_7171?
	)?
	(
		PLUS d_1229?
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS d_7166?
	)? EOL
;

/** ICD  INSURANCE COVER DESCRIPTION. */
s_ICD
:
	'ICD+' c_C330 PLUS c_C331 EOL
;

/** IDE  IDENTITY. */
s_IDE
:
	'IDE+' d_7495
	(
		PLUS c_C206?
	)?
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS d_1222?
	)?
	(
		PLUS c_C778
	)?
	(
		PLUS c_C240?
	)? EOL
;

/** IFD  INFORMATION DETAIL. */
s_IFD
:
	'IFD+' d_4153?
	(
		PLUS c_C009
	)?
	(
		PLUS c_C010
	)?
	(
		PLUS c_C011
	)?
	(
		PLUS d_4405?
	)? EOL
;

/** IHC  PERSON CHARACTERISTIC. */
s_IHC
:
	'IHC+' d_3289
	(
		PLUS c_C818
	)? EOL
;

/** IMD  ITEM DESCRIPTION. */
s_IMD
:
	'IMD+' d_7077?
	(
		PLUS c_C272
	)?
	(
		PLUS c_C273
	)?
	(
		PLUS d_7383?
	)? EOL
;

/** IND  INDEX DETAILS. */
s_IND
:
	'IND+' c_C545?
	(
		PLUS c_C546?
	)? EOL
;

/** INP  PARTIES AND INSTRUCTION. */
s_INP
:
	'INP+' c_C849?
	(
		PLUS c_C522?
	)?
	(
		PLUS c_C850?
	)?
	(
		PLUS d_1229?
	)? EOL
;

/** INV  INVENTORY MANAGEMENT RELATED DETAILS. */
s_INV
:
	'INV+' d_4501?
	(
		PLUS d_7491?
	)?
	(
		PLUS d_4499?
	)?
	(
		PLUS d_4503?
	)?
	(
		PLUS c_C522?
	)? EOL
;

/** IRQ  INFORMATION REQUIRED. */
s_IRQ
:
	'IRQ+' c_C333 EOL
;

/** LAN  LANGUAGE. */
s_LAN
:
	'LAN+' d_3455
	(
		PLUS c_C508
	)? EOL
;

/** LIN  LINE ITEM. */
s_LIN
:
	'LIN+' d_1082?
	(
		PLUS d_1229?
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS c_C829
	)?
	(
		PLUS d_1222?
	)?
	(
		PLUS d_7083?
	)? EOL
;

/** LOC  PLACE/LOCATION IDENTIFICATION. */
s_LOC
:
	'LOC+' d_3227
	(
		PLUS c_C517
	)?
	(
		PLUS c_C519
	)?
	(
		PLUS c_C553
	)?
	(
		PLUS d_5479?
	)? EOL
;

/** MEA  MEASUREMENTS. */
s_MEA
:
	'MEA+' d_6311
	(
		PLUS c_C502
	)?
	(
		PLUS c_C174?
	)?
	(
		PLUS d_7383?
	)? EOL
;

/** MEM  MEMBERSHIP DETAILS. */
s_MEM
:
	'MEM+' d_7449
	(
		PLUS c_C942?
	)?
	(
		PLUS c_C944
	)?
	(
		PLUS c_C945?
	)?
	(
		PLUS c_C203?
	)?
	(
		PLUS c_C960
	)? EOL
;

/** MKS  MARKET/SALES CHANNEL INFORMATION. */
s_MKS
:
	'MKS+' d_7293
	(
		PLUS c_C332?
	)?
	(
		PLUS d_1229?
	)? EOL
;

/** MOA  MONETARY AMOUNT. */
s_MOA
:
	'MOA+' c_C516 EOL
;

/** MSG  MESSAGE TYPE IDENTIFICATION. */
s_MSG
:
	'MSG+' c_C709
	(
		PLUS d_1507?
	)?
	(
		PLUS d_4513?
	)?
	(
		PLUS c_C941
	)? EOL
;

/** MTD  MAINTENANCE OPERATION DETAILS. */
s_MTD
:
	'MTD+' d_7495
	(
		PLUS d_4513?
	)?
	(
		PLUS d_3005?
	)?
	(
		PLUS d_3009?
	)? EOL
;

/** NAD  NAME AND ADDRESS. */
s_NAD
:
	'NAD+' d_3035
	(
		PLUS c_C082?
	)?
	(
		PLUS c_C058?
	)?
	(
		PLUS c_C080?
	)?
	(
		PLUS c_C059?
	)?
	(
		PLUS d_3164?
	)?
	(
		PLUS c_C819
	)?
	(
		PLUS d_3251?
	)?
	(
		PLUS d_3207?
	)? EOL
;

/** NAT  NATIONALITY. */
s_NAT
:
	'NAT+' d_3493
	(
		PLUS c_C042
	)? EOL
;

/** PAC  PACKAGE. */
s_PAC
:
	'PAC+' d_7224?
	(
		PLUS c_C531
	)?
	(
		PLUS c_C202?
	)?
	(
		PLUS c_C402?
	)?
	(
		PLUS c_C532
	)? EOL
;

/** PAI  PAYMENT INSTRUCTIONS. */
s_PAI
:
	'PAI+' c_C534 EOL
;

/** PAS  ATTENDANCE. */
s_PAS
:
	'PAS+' d_9443
	(
		PLUS c_C839
	)?
	(
		PLUS c_C840
	)?
	(
		PLUS c_C841
	)? EOL
;

/** PCC  PREMIUM CALCULATION COMPONENT DETAILS. */
s_PCC
:
	'PCC+' c_C820
	(
		PLUS d_4522?
	)? EOL
;

/** PCD  PERCENTAGE DETAILS. */
s_PCD
:
	'PCD+' c_C501
	(
		PLUS d_4405?
	)? EOL
;

/** PCI  PACKAGE IDENTIFICATION. */
s_PCI
:
	'PCI+' d_4233?
	(
		PLUS c_C210?
	)?
	(
		PLUS d_8169?
	)?
	(
		PLUS c_C827?
	)? EOL
;

/** PDI  PERSON DEMOGRAPHIC INFORMATION. */
s_PDI
:
	'PDI+' d_3499?
	(
		PLUS c_C085?
	)?
	(
		PLUS c_C101?
	)? EOL
;

/** PER  PERIOD RELATED DETAILS. */
s_PER
:
	'PER+' d_2023?
	(
		PLUS c_C977
	)? EOL
;

/** PGI  PRODUCT GROUP INFORMATION. */
s_PGI
:
	'PGI+' d_5379
	(
		PLUS c_C288
	)? EOL
;

/** PIA  ADDITIONAL PRODUCT ID. */
s_PIA
:
	'PIA+' d_4347 PLUS c_C212
	(
		PLUS c_C212
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS c_C212
	)? EOL
;

/** PNA  PARTY IDENTIFICATION. */
s_PNA
:
	'PNA+' d_3035
	(
		PLUS c_C206?
	)?
	(
		PLUS c_C082?
	)?
	(
		PLUS d_3403?
	)?
	(
		PLUS d_3397?
	)?
	(
		PLUS c_C816?
	)?
	(
		PLUS c_C816?
	)?
	(
		PLUS c_C816?
	)?
	(
		PLUS c_C816?
	)?
	(
		PLUS c_C816?
	)?
	(
		PLUS d_1229?
	)? EOL
;

/** POC  PURPOSE OF CONVEYANCE CALL. */
s_POC
:
	'POC+' c_C525 EOL
;

/** PRC  PROCESS IDENTIFICATION. */
s_PRC
:
	'PRC+' c_C242?
	(
		PLUS c_C830
	)? EOL
;

/** PRI  PRICE DETAILS. */
s_PRI
:
	'PRI+' c_C509?
	(
		PLUS d_5213?
	)? EOL
;

/** PRV  PROVISO DETAILS. */
s_PRV
:
	'PRV+' d_4071
	(
		PLUS c_C971
	)?
	(
		PLUS c_C972
	)? EOL
;

/** PSD  PHYSICAL SAMPLE DESCRIPTION. */
s_PSD
:
	'PSD+' d_4407?
	(
		PLUS d_7039?
	)?
	(
		PLUS c_C526?
	)?
	(
		PLUS d_7045?
	)?
	(
		PLUS d_7047?
	)?
	(
		PLUS c_C514
	)?
	(
		PLUS c_C514
	)?
	(
		PLUS c_C514
	)? EOL
;

/** PTY  PRIORITY. */
s_PTY
:
	'PTY+' d_4035
	(
		PLUS c_C585
	)? EOL
;

/** PYT  PAYMENT TERMS. */
s_PYT
:
	'PYT+' d_4279
	(
		PLUS c_C019
	)?
	(
		PLUS d_2475?
	)?
	(
		PLUS d_2009?
	)?
	(
		PLUS d_2151?
	)?
	(
		PLUS d_2152?
	)? EOL
;

/** QRS  QUERY AND RESPONSE. */
s_QRS
:
	'QRS+' d_7293
	(
		PLUS c_C811
	)?
	(
		PLUS c_C812
	)? EOL
;

/** QTY  QUANTITY. */
s_QTY
:
	'QTY+' c_C186 EOL
;

/** QVR  QUANTITY VARIANCES. */
s_QVR
:
	'QVR+' c_C279?
	(
		PLUS d_4221?
	)?
	(
		PLUS c_C960
	)? EOL
;

/** QUA  QUALIFICATION. */
s_QUA
:
	'QUA+' d_9037
	(
		PLUS c_C950
	)? EOL
;

/** RCS  REQUIREMENTS AND CONDITIONS. */
s_RCS
:
	'RCS+' d_7293
	(
		PLUS c_C550?
	)?
	(
		PLUS d_1229?
	)?
	(
		PLUS d_3207?
	)? EOL
;

/** REL  RELATIONSHIP. */
s_REL
:
	'REL+' d_9141
	(
		PLUS c_C941
	)? EOL
;

/** RFF  REFERENCE. */
s_RFF
:
	'RFF+' c_C506 EOL
;

/** RJL  ACCOUNTING JOURNAL IDENTIFICATION. */
s_RJL
:
	'RJL+' c_C595?
	(
		PLUS c_C596?
	)? EOL
;

/** RNG  RANGE DETAILS. */
s_RNG
:
	'RNG+' d_6167
	(
		PLUS c_C280?
	)? EOL
;

/** ROD  RISK OBJECT TYPE. */
s_ROD
:
	'ROD+' c_C851
	(
		PLUS c_C852
	)? EOL
;

/** RSL  RESULT. */
s_RSL
:
	'RSL+' d_6087
	(
		PLUS d_6077?
	)?
	(
		PLUS c_C831
	)?
	(
		PLUS c_C831
	)?
	(
		PLUS c_C848
	)?
	(
		PLUS d_6079?
	)? EOL
;

/** RTE  RATE DETAILS. */
s_RTE
:
	'RTE+' c_C128
	(
		PLUS d_4405?
	)? EOL
;

/** SAL  REMUNERATION TYPE IDENTIFICATION. */
s_SAL
:
	'SAL+' c_C049 EOL
;

/** SCC  SCHEDULING CONDITIONS. */
s_SCC
:
	'SCC+' d_4017
	(
		PLUS d_4493?
	)?
	(
		PLUS c_C329
	)? EOL
;

/** SCD  STRUCTURE COMPONENT DEFINITION. */
s_SCD
:
	'SCD+' d_7497
	(
		PLUS c_C786?
	)?
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS d_1222?
	)?
	(
		PLUS c_C778
	)?
	(
		PLUS c_C240?
	)? EOL
;

/** SEG  SEGMENT IDENTIFICATION. */
s_SEG
:
	'SEG+' d_9166
	(
		PLUS d_1507?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** SEL  SEAL NUMBER. */
s_SEL
:
	'SEL+' d_9308?
	(
		PLUS c_C215
	)?
	(
		PLUS d_4517?
	)?
	(
		PLUS c_C208?
	)?
	(
		PLUS d_4525?
	)? EOL
;

/** SEQ  SEQUENCE DETAILS. */
s_SEQ
:
	'SEQ+' d_1229?
	(
		PLUS c_C286?
	)? EOL
;

/** SFI  SAFETY INFORMATION. */
s_SFI
:
	'SFI+' d_7164
	(
		PLUS c_C814?
	)?
	(
		PLUS c_C815?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** SGP  SPLIT GOODS PLACEMENT. */
s_SGP
:
	'SGP+' c_C237
	(
		PLUS d_7224?
	)? EOL
;

/** SGU  SEGMENT USAGE DETAILS. */
s_SGU
:
	'SGU+' d_9166
	(
		PLUS d_7299?
	)?
	(
		PLUS d_6176?
	)?
	(
		PLUS d_7168?
	)?
	(
		PLUS d_1050?
	)?
	(
		PLUS d_1049?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** SPR  ORGANISATION CLASSIFICATION DETAILS. */
s_SPR
:
	'SPR+' d_7293
	(
		PLUS d_3079?
	)?
	(
		PLUS c_C844
	)? EOL
;

/** SPS  SAMPLING PARAMETERS FOR SUMMARY STATISTICS. */
s_SPS
:
	'SPS+' c_C526?
	(
		PLUS d_6074?
	)?
	(
		PLUS c_C512
	)?
	(
		PLUS c_C512
	)?
	(
		PLUS c_C512
	)?
	(
		PLUS c_C512
	)?
	(
		PLUS c_C512
	)? EOL
;

/** STA  STATISTICS. */
s_STA
:
	'STA+' d_6331
	(
		PLUS c_C527
	)? EOL
;

/** STC  STATISTICAL CONCEPT. */
s_STC
:
	'STC+' c_C785
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS d_4513?
	)? EOL
;

/** STG  STAGES. */
s_STG
:
	'STG+' d_9421
	(
		PLUS d_6426?
	)?
	(
		PLUS d_6428?
	)? EOL
;

/** STS  STATUS. */
s_STS
:
	'STS+' c_C601?
	(
		PLUS c_C555?
	)?
	(
		PLUS c_C556?
	)?
	(
		PLUS c_C556?
	)?
	(
		PLUS c_C556?
	)?
	(
		PLUS c_C556?
	)?
	(
		PLUS c_C556?
	)? EOL
;

/** TAX  DUTY/TAX/FEE DETAILS. */
s_TAX
:
	'TAX+' d_5283
	(
		PLUS c_C241
	)?
	(
		PLUS c_C533?
	)?
	(
		PLUS d_5286?
	)?
	(
		PLUS c_C243
	)?
	(
		PLUS d_5305?
	)?
	(
		PLUS d_3446?
	)?
	(
		PLUS d_1227?
	)?
	(
		PLUS d_5307?
	)? EOL
;

/** TCC  CHARGE/RATE CALCULATIONS. */
s_TCC
:
	'TCC+' c_C200
	(
		PLUS c_C203?
	)?
	(
		PLUS c_C528
	)?
	(
		PLUS c_C554
	)? EOL
;

/** TDT  TRANSPORT INFORMATION. */
s_TDT
:
	'TDT+' d_8051
	(
		PLUS d_8028?
	)?
	(
		PLUS c_C220
	)?
	(
		PLUS c_C001
	)?
	(
		PLUS c_C040
	)?
	(
		PLUS d_8101?
	)?
	(
		PLUS c_C401?
	)?
	(
		PLUS c_C222
	)?
	(
		PLUS d_8281?
	)?
	(
		PLUS c_C003
	)? EOL
;

/** TEM  TEST METHOD. */
s_TEM
:
	'TEM+' c_C244
	(
		PLUS d_4419?
	)?
	(
		PLUS d_3077?
	)?
	(
		PLUS d_6311?
	)?
	(
		PLUS d_7188?
	)?
	(
		PLUS c_C515
	)? EOL
;

/** TMD  TRANSPORT MOVEMENT DETAILS. */
s_TMD
:
	'TMD+' c_C219
	(
		PLUS d_8332?
	)?
	(
		PLUS d_8341?
	)? EOL
;

/** TMP  TEMPERATURE. */
s_TMP
:
	'TMP+' d_6245
	(
		PLUS c_C239
	)? EOL
;

/** TOD  TERMS OF DELIVERY OR TRANSPORT. */
s_TOD
:
	'TOD+' d_4055?
	(
		PLUS d_4215?
	)?
	(
		PLUS c_C100
	)? EOL
;

/** TPL  TRANSPORT PLACEMENT. */
s_TPL
:
	'TPL+' c_C222 EOL
;

/** TRU  TECHNICAL RULES. */
s_TRU
:
	'TRU+' d_7402
	(
		PLUS d_1056?
	)?
	(
		PLUS d_1058?
	)?
	(
		PLUS d_7175?
	)?
	(
		PLUS d_3055?
	)? EOL
;

/** TSR  TRANSPORT SERVICE REQUIREMENTS. */
s_TSR
:
	'TSR+' c_C536?
	(
		PLUS c_C233?
	)?
	(
		PLUS c_C537?
	)?
	(
		PLUS c_C703?
	)? EOL
;

s_UNH [String msgType]
:
	'UNH+' d_0062 PLUS s009 [$msgType]
	(
		PLUS d_0068?
	)?
	(
		PLUS s010?
	)?
	(
		PLUS s016?
	)?
	(
		PLUS s017?
	)?
	(
		PLUS s018?
	)? EOL
;

s_UNS
:
	'UNS+' d_0081 EOL
;

s_UNT
:
	'UNT+' d_0074 PLUS d_0062 EOL
;

/** VLI  VALUE LIST IDENTIFICATION. */
s_VLI
:
	'VLI+' c_C780
	(
		PLUS c_C082?
	)?
	(
		PLUS d_4405?
	)?
	(
		PLUS d_1514?
	)?
	(
		PLUS d_1507?
	)?
	(
		PLUS d_1505?
	)?
	(
		PLUS c_C240?
	)? EOL
;
