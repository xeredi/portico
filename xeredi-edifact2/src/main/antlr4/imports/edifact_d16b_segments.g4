parser grammar edifact_d16b_segments;

import edifact_d16b_components, edifact_d16b_fields, edifact_common;

/** ADR  ADDRESS. FIXME Revisar.*/
s_ADR
:
	K_ADR
	(
		PLUS c_C817
	)?
	(
		PLUS c_C090
	)?
	(
		PLUS d_3164
	)?
	(
		PLUS d_3251
	)?
	(
		PLUS d_3207
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
	K_AGR
	(
		PLUS c_C543
	)?
	(
		PLUS d_9419
	)? EOL
;

/** AJT  ADJUSTMENT DETAILS. */
s_AJT
:
	K_AJT PLUS d_4465
	(
		PLUS d_1082
	)? EOL
;

/** ALC  ALLOWANCE OR CHARGE. */
s_ALC
:
	K_ALC PLUS d_5463
	(
		PLUS c_C552
	)?
	(
		PLUS d_4471
	)?
	(
		PLUS d_1227
	)?
	(
		PLUS c_C214
	)? EOL
;

/** ALI  ADDITIONAL INFORMATION. */
s_ALI
:
	K_ALI
	(
		PLUS d_3239
	)?
	(
		PLUS d_9213
	)?
	(
		PLUS d_4183
	)?
	(
		PLUS d_4183
	)?
	(
		PLUS d_4183
	)?
	(
		PLUS d_4183
	)?
	(
		PLUS d_4183
	)? EOL
;

/** APR  ADDITIONAL PRICE INFORMATION. */
s_APR
:
	K_APR
	(
		PLUS d_4043
	)?
	(
		PLUS c_C138
	)?
	(
		PLUS c_C960
	)? EOL
;

/** ARD  MONETARY AMOUNT FUNCTION. */
s_ARD
:
	K_ARD
	(
		PLUS c_C549
	)?
	(
		PLUS c_C008
	)? EOL
;

/** ARR  ARRAY INFORMATION. */
s_ARR
:
	K_ARR
	(
		PLUS c_C778
	)?
	(
		PLUS c_C770
	)? EOL
;

/** ASI  ARRAY STRUCTURE IDENTIFICATION. */
s_ASI
:
	K_ASI PLUS c_C779
	(
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS d_4513
	)? EOL
;

/** ATT  ATTRIBUTE. */
s_ATT
:
	K_ATT PLUS d_9017
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
	K_AUT PLUS d_9280
	(
		PLUS d_9282
	)? EOL
;

/** BAS  BASIS. */
s_BAS
:
	K_BAS PLUS d_9045 PLUS c_C974 EOL
;

/** BGM  BEGINNING OF MESSAGE. */
s_BGM
:
	'BGM'
	(
		PLUS c_C002
	)?
	(
		PLUS c_C106
	)?
	(
		PLUS d_1225
	)?
	(
		PLUS d_4343
	)?
	(
		PLUS d_1373
	)?
	(
		PLUS d_3453
	)? EOL
;

/** BII  STRUCTURE IDENTIFICATION. */
s_BII
:
	'BII' PLUS d_7429 PLUS c_C045
	(
		PLUS d_7140
	)? EOL
;

/** BUS  BUSINESS FUNCTION. */
s_BUS
:
	'BUS'
	(
		PLUS c_C521?
	)?
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
	'CAV' PLUS c_C889 EOL
;

/** CCD  CREDIT COVER DETAILS. */
s_CCD
:
	'CCD'
	(
		PLUS d_4505
	)?
	(
		PLUS d_4507
	)?
	(
		PLUS d_4509
	)? EOL
;

/** CCI  CHARACTERISTIC/CLASS ID. */
s_CCI
:
	'CCI'
	(
		PLUS d_7059
	)?
	(
		PLUS c_C502
	)?
	(
		PLUS c_C240
	)?
	(
		PLUS d_4051
	)? EOL
;

/** CDI  PHYSICAL OR LOGICAL STATE. */
s_CDI
:
	'CDI' PLUS d_7001 PLUS c_C564 EOL
;

/** CDS  CODE SET IDENTIFICATION. */
s_CDS
:
	'CDS' PLUS c_C702
	(
		PLUS d_1507
	)?
	(
		PLUS d_4513
	)? EOL
;

/** CDV  CODE VALUE DEFINITION. */
s_CDV
:
	'CDV' PLUS d_9426
	(
		PLUS d_9434
	)?
	(
		PLUS d_4513
	)?
	(
		PLUS d_9453
	)?
	(
		PLUS d_7299
	)? EOL
;

/** CED  COMPUTER ENVIRONMENT DETAILS. */
s_CED
:
	'CED' PLUS d_1501 PLUS c_C079
	(
		PLUS d_9448
	)? EOL
;

/** CIN  CLINICAL INFORMATION. */
s_CIN
:
	'CIN' PLUS d_6415
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
	'CLA' PLUS d_4059
	(
		PLUS c_C970
	)? EOL
;

/** CLI  CLINICAL INTERVENTION. */
s_CLI
:
	'CLI' PLUS d_9441
	(
		PLUS c_C828
	)? EOL
;

/** CMP  COMPOSITE DATA ELEMENT IDENTIFICATION. */
s_CMP
:
	'CMP' PLUS d_9146
	(
		PLUS d_1507
	)?
	(
		PLUS d_4513
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
		PLUS d_1312
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
	'COD+' c_C823?
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
		PLUS c_C953
	)?
	(
		PLUS c_C522
	)?
	(
		PLUS c_C203
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
		PLUS c_C231
	)?
	(
		PLUS d_4237
	)? EOL
;

/** CPS  CONSIGNMENT PACKING SEQUENCE. */
s_CPS
:
	'CPS+' d_7164
	(
		PLUS d_7166
	)?
	(
		PLUS d_7075
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
		PLUS c_C246
	)?
	(
		PLUS c_C246
	)?
	(
		PLUS c_C246
	)?
	(
		PLUS c_C246
	)?
	(
		PLUS c_C246
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
		PLUS d_9025
	)?
	(
		PLUS d_4519
	)? EOL
;

/** DGS  DANGEROUS GOODS. */
s_DGS
:
	'DGS+' d_8273?
	(
		PLUS c_C205
	)?
	(
		PLUS c_C234
	)?
	(
		PLUS c_C223
	)?
	(
		PLUS d_8339
	)?
	(
		PLUS d_8364
	)?
	(
		PLUS d_8410
	)?
	(
		PLUS d_8126
	)?
	(
		PLUS c_C235
	)?
	(
		PLUS c_C236
	)?
	(
		PLUS d_8255
	)?
	(
		PLUS d_8179
	)?
	(
		PLUS d_8211
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
		PLUS d_9148
	)?
	(
		PLUS d_1476
	)?
	(
		PLUS d_3453
	)?
	(
		PLUS d_4513
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
		PLUS c_C522
	)?
	(
		PLUS c_C214
	)?
	(
		PLUS d_4457
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
		PLUS d_7240
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
		PLUS d_3153
	)?
	(
		PLUS d_1220
	)?
	(
		PLUS d_1218
	)? EOL
;

/** DRD  DATA REPRESENTATION DETAILS. */
s_DRD
:
	'DRD+' d_7512?
	(
		PLUS d_7515
	)?
	(
		PLUS d_9169
	)?
	(
		PLUS d_6174
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
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS c_C286
	)?
	(
		PLUS d_1060
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
		PLUS d_9026
	)?
	(
		PLUS d_9031
	)?
	(
		PLUS d_4447
	)? EOL
;

/** EFI  EXTERNAL FILE LINK IDENTIFICATION. */
s_EFI
:
	'EFI+' c_C077
	(
		PLUS c_C099
	)?
	(
		PLUS d_1050
	)?
	(
		PLUS d_9450
	)? EOL
;

/** ELM  SIMPLE DATA ELEMENT DETAILS. */
s_ELM
:
	'ELM+' d_9150
	(
		PLUS d_9153
	)?
	(
		PLUS d_6113
	)?
	(
		PLUS d_9156
	)?
	(
		PLUS d_9158
	)?
	(
		PLUS d_9161
	)?
	(
		PLUS d_1507
	)?
	(
		PLUS d_4513
	)?
	(
		PLUS d_6432
	)? EOL
;

/** ELU  DATA ELEMENT USAGE DETAILS. */
s_ELU
:
	'ELU+' d_9162
	(
		PLUS d_7299
	)?
	(
		PLUS d_1050
	)?
	(
		PLUS d_4513
	)?
	(
		PLUS d_6176
	)?
	(
		PLUS d_9453
	)?
	(
		PLUS d_9285
	)?
	(
		PLUS d_9175
	)? EOL
;

/** ELV  ELEMENT VALUE DEFINITION. */
s_ELV
:
	'ELV+' d_9029
	(
		PLUS d_9422
	)?
	(
		PLUS d_7299
	)?
	(
		PLUS d_4513
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
		PLUS d_3480
	)?
	(
		PLUS d_9035
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
		PLUS d_8077
	)?
	(
		PLUS d_8249
	)?
	(
		PLUS d_8169
	)?
	(
		PLUS d_4233
	)? EOL
;

/** EQN  NUMBER OF UNITS. */
s_EQN
:
	'EQN' PLUS c_C523 EOL
;

/** ERC  APPLICATION ERROR INFORMATION. */
s_ERC
:
	'ERC' PLUS c_C901 EOL
;

/** ERP  ERROR POINT DETAILS. */
s_ERP
:
	'ERP'
	(
		PLUS c_C701
	)?
	(
		PLUS c_C853
	)? EOL
;

/** EVE  EVENT. */
s_EVE
:
	'EVE'
	(
		PLUS d_9635
	)?
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
		PLUS d_1229
	)? EOL
;

/** FCA  FINANCIAL CHARGES ALLOCATION. */
s_FCA
:
	'FCA' PLUS d_4471
	(
		PLUS c_C878
	)? EOL
;

/** FII  FINANCIAL INSTITUTION INFORMATION. */
s_FII
:
	'FII' PLUS d_3035
	(
		PLUS c_C078
	)?
	(
		PLUS c_C088
	)?
	(
		PLUS d_3207
	)? EOL
;

/** FNS  FOOTNOTE SET. */
s_FNS
:
	'FNS' PLUS c_C783
	(
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS d_4513
	)? EOL
;

/** FNT  FOOTNOTE. */
s_FNT
:
	'FNT' PLUS c_C784
	(
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS d_4513
	)? EOL
;

/** FOR  FORMULA. */
s_FOR
:
	'FOR' PLUS d_9501
	(
		PLUS d_7402
	)?
	(
		PLUS d_9502
	)?
	(
		PLUS d_4440
	)?
	(
		PLUS c_C961
	)? EOL
;

/** FSQ  FORMULA SEQUENCE. */
s_FSQ
:
	'FSQ' PLUS d_9507
	(
		PLUS d_9509
	)?
	(
		PLUS d_1050
	)?
	(
		PLUS d_9510
	)?
	(
		PLUS d_4440
	)? EOL
;

/** FTX  FREE TEXT. */
s_FTX
:
	'FTX' PLUS d_4451
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
	'GDS'
	(
		PLUS c_C703
	)?
	(
		PLUS c_C288
	)? EOL
;

/** GEI  PROCESSING INFORMATION. */
s_GEI
:
	'GEI' PLUS d_9649
	(
		PLUS c_C012
	)?
	(
		PLUS d_7187
	)? EOL
;

/** GID  GOODS ITEM DETAILS. */
s_GID
:
	'GID'
	(
		PLUS d_1496
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
	)?
	(
		PLUS c_C213
	)? EOL
;

/** GIN  GOODS IDENTITY NUMBER. */
s_GIN
:
	'GIN' PLUS d_7405 PLUS c_C208
	(
		PLUS c_C208
	)?
	(
		PLUS c_C208
	)?
	(
		PLUS c_C208
	)?
	(
		PLUS c_C208
	)? EOL
;

/** GIR  RELATED IDENTIFICATION NUMBERS. */
s_GIR
:
	'GIR' PLUS d_7297 PLUS c_C206
	(
		PLUS c_C206
	)?
	(
		PLUS c_C206
	)?
	(
		PLUS c_C206
	)?
	(
		PLUS c_C206
	)? EOL
;

/** GOR  GOVERNMENTAL REQUIREMENTS. */
s_GOR
:
	'GOR'
	(
		PLUS d_8323
	)?
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
	'GPO' PLUS d_6029
	(
		PLUS d_6000
	)?
	(
		PLUS d_6002
	)?
	(
		PLUS d_6096
	)? EOL
;

/** GRU  SEGMENT GROUP USAGE DETAILS. */
s_GRU
:
	'GRU' PLUS d_9164
	(
		PLUS d_7299
	)?
	(
		PLUS d_6176
	)?
	(
		PLUS d_4513
	)?
	(
		PLUS d_1050
	)? EOL
;

/** HAN  HANDLING INSTRUCTIONS. */
s_HAN
:
	'HAN'
	(
		PLUS c_C524
	)?
	(
		PLUS c_C218
	)? EOL
;

/** HYN  HIERARCHY INFORMATION. */
s_HYN
:
	'HYN' PLUS d_7173
	(
		PLUS d_7171
	)?
	(
		PLUS d_1229
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS d_7166
	)? EOL
;

/** ICD  INSURANCE COVER DESCRIPTION. */
s_ICD
:
	'ICD' PLUS c_C330 PLUS c_C331 EOL
;

/** IDE  IDENTITY. */
s_IDE
:
	'IDE' PLUS d_7495
	(
		PLUS c_C206
	)?
	(
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS d_1222
	)?
	(
		PLUS c_C778
	)?
	(
		PLUS c_C240
	)? EOL
;

/** IFD  INFORMATION DETAIL. */
s_IFD
:
	'IFD'
	(
		PLUS d_4153
	)?
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
		PLUS d_4405
	)? EOL
;

/** IHC  PERSON CHARACTERISTIC. */
s_IHC
:
	'IHC' PLUS d_3289
	(
		PLUS c_C818
	)? EOL
;

/** IMD  ITEM DESCRIPTION. */
s_IMD
:
	'IMD'
	(
		PLUS d_7077
	)?
	(
		PLUS c_C272
	)?
	(
		PLUS c_C273
	)?
	(
		PLUS d_7383
	)? EOL
;

/** IND  INDEX DETAILS. */
s_IND
:
	'IND'
	(
		PLUS c_C545
	)?
	(
		PLUS c_C546
	)? EOL
;

/** INP  PARTIES AND INSTRUCTION. */
s_INP
:
	'INP'
	(
		PLUS c_C849
	)?
	(
		PLUS c_C522
	)?
	(
		PLUS c_C850
	)?
	(
		PLUS d_1229
	)? EOL
;

/** INV  INVENTORY MANAGEMENT RELATED DETAILS. */
s_INV
:
	'INV'
	(
		PLUS d_4501
	)?
	(
		PLUS d_7491
	)?
	(
		PLUS d_4499
	)?
	(
		PLUS d_4503
	)?
	(
		PLUS c_C522
	)? EOL
;

/** IRQ  INFORMATION REQUIRED. */
s_IRQ
:
	'IRQ' PLUS c_C333 EOL
;

/** LAN  LANGUAGE. */
s_LAN
:
	'LAN' PLUS d_3455
	(
		PLUS c_C508
	)? EOL
;

/** LIN  LINE ITEM. */
s_LIN
:
	'LIN'
	(
		PLUS d_1082
	)?
	(
		PLUS d_1229
	)?
	(
		PLUS c_C212
	)?
	(
		PLUS c_C829
	)?
	(
		PLUS d_1222
	)?
	(
		PLUS d_7083
	)? EOL
;

/** LOC  PLACE/LOCATION IDENTIFICATION. */
s_LOC
:
	'LOC' PLUS d_3227
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
		PLUS d_5479
	)? EOL
;

/** MEA  MEASUREMENTS. */
s_MEA
:
	'MEA' PLUS d_6311
	(
		PLUS c_C502
	)?
	(
		PLUS c_C174
	)?
	(
		PLUS d_7383
	)? EOL
;

/** MEM  MEMBERSHIP DETAILS. */
s_MEM
:
	'MEM' PLUS d_7449
	(
		PLUS c_C942
	)?
	(
		PLUS c_C944
	)?
	(
		PLUS c_C945
	)?
	(
		PLUS c_C203
	)?
	(
		PLUS c_C960
	)? EOL
;

/** MKS  MARKET/SALES CHANNEL INFORMATION. */
s_MKS
:
	'MKS' PLUS d_7293
	(
		PLUS c_C332
	)?
	(
		PLUS d_1229
	)? EOL
;

/** MOA  MONETARY AMOUNT. */
s_MOA
:
	'MOA' PLUS c_C516 EOL
;

/** MSG  MESSAGE TYPE IDENTIFICATION. */
s_MSG
:
	'MSG' PLUS c_C709
	(
		PLUS d_1507
	)?
	(
		PLUS d_4513
	)?
	(
		PLUS c_C941
	)? EOL
;

/** MTD  MAINTENANCE OPERATION DETAILS. */
s_MTD
:
	'MTD' PLUS d_7495
	(
		PLUS d_4513
	)?
	(
		PLUS d_3005
	)?
	(
		PLUS d_3009
	)? EOL
;

/** NAD  NAME AND ADDRESS. */
s_NAD
:
	'NAD' PLUS d_3035
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
	'NAT' PLUS d_3493
	(
		PLUS c_C042
	)? EOL
;

/** PAC  PACKAGE. */
s_PAC
:
	'PAC'
	(
		PLUS d_7224
	)?
	(
		PLUS c_C531
	)?
	(
		PLUS c_C202
	)?
	(
		PLUS c_C402
	)?
	(
		PLUS c_C532
	)? EOL
;

/** PAI  PAYMENT INSTRUCTIONS. */
s_PAI
:
	'PAI' PLUS c_C534 EOL
;

/** PAS  ATTENDANCE. */
s_PAS
:
	'PAS' PLUS d_9443
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
	'PCC'
	(
		PLUS c_C820
	)?
	(
		PLUS d_4522
	)? EOL
;

/** PCD  PERCENTAGE DETAILS. */
s_PCD
:
	'PCD' PLUS c_C501
	(
		PLUS d_4405
	)? EOL
;

/** PCI  PACKAGE IDENTIFICATION. */
s_PCI
:
	'PCI'
	(
		PLUS d_4233
	)?
	(
		PLUS c_C210
	)?
	(
		PLUS d_8169
	)?
	(
		PLUS c_C827
	)? EOL
;

/** PDI  PERSON DEMOGRAPHIC INFORMATION. */
s_PDI
:
	'PDI'
	(
		PLUS d_3499
	)?
	(
		PLUS c_C085
	)?
	(
		PLUS c_C101
	)? EOL
;

/** PER  PERIOD RELATED DETAILS. */
s_PER
:
	'PER'
	(
		PLUS d_2023
	)?
	(
		PLUS c_C977
	)? EOL
;

/** PGI  PRODUCT GROUP INFORMATION. */
s_PGI
:
	'PGI' PLUS d_5379
	(
		PLUS c_C288
	)? EOL
;

/** PIA  ADDITIONAL PRODUCT ID. */
s_PIA
:
	'PIA' PLUS d_4347 PLUS c_C212
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
	'PNA' PLUS d_3035
	(
		PLUS c_C206
	)?
	(
		PLUS c_C082
	)?
	(
		PLUS d_3403
	)?
	(
		PLUS d_3397
	)?
	(
		PLUS c_C816
	)?
	(
		PLUS c_C816
	)?
	(
		PLUS c_C816
	)?
	(
		PLUS c_C816
	)?
	(
		PLUS c_C816
	)?
	(
		PLUS d_1229
	)? EOL
;

/** POC  PURPOSE OF CONVEYANCE CALL. */
s_POC
:
	'POC' PLUS c_C525 EOL
;

/** PRC  PROCESS IDENTIFICATION. */
s_PRC
:
	'PRC'
	(
		PLUS c_C242
	)?
	(
		PLUS c_C830
	)? EOL
;

/** PRI  PRICE DETAILS. */
s_PRI
:
	'PRI'
	(
		PLUS c_C509
	)?
	(
		PLUS d_5213
	)? EOL
;

/** PRV  PROVISO DETAILS. */
s_PRV
:
	'PRV' PLUS d_4071
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
	'PSD'
	(
		PLUS d_4407
	)?
	(
		PLUS d_7039
	)?
	(
		PLUS c_C526
	)?
	(
		PLUS d_7045
	)?
	(
		PLUS d_7047
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
	'PTY' PLUS d_4035
	(
		PLUS c_C585
	)? EOL
;

/** PYT  PAYMENT TERMS. */
s_PYT
:
	'PYT' PLUS d_4279
	(
		PLUS c_C019
	)?
	(
		PLUS d_2475
	)?
	(
		PLUS d_2009
	)?
	(
		PLUS d_2151
	)?
	(
		PLUS d_2152
	)? EOL
;

/** QRS  QUERY AND RESPONSE. */
s_QRS
:
	'QRS' PLUS d_7293
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
	'QTY' PLUS c_C186 EOL
;

/** QVR  QUANTITY VARIANCES. */
s_QVR
:
	'QVR'
	(
		PLUS c_C279
	)?
	(
		PLUS d_4221
	)?
	(
		PLUS c_C960
	)? EOL
;

/** QUA  QUALIFICATION. */
s_QUA
:
	'QUA' PLUS d_9037
	(
		PLUS c_C950
	)? EOL
;

/** RCS  REQUIREMENTS AND CONDITIONS. */
s_RCS
:
	'RCS' PLUS d_7293
	(
		PLUS c_C550
	)?
	(
		PLUS d_1229
	)?
	(
		PLUS d_3207
	)? EOL
;

/** REL  RELATIONSHIP. */
s_REL
:
	'REL' PLUS d_9141
	(
		PLUS c_C941
	)? EOL
;

/** RFF  REFERENCE. */
s_RFF
:
	'RFF' PLUS c_C506 EOL
;

/** RJL  ACCOUNTING JOURNAL IDENTIFICATION. */
s_RJL
:
	'RJL'
	(
		PLUS c_C595
	)?
	(
		PLUS c_C596
	)? EOL
;

/** RNG  RANGE DETAILS. */
s_RNG
:
	'RNG' PLUS d_6167
	(
		PLUS c_C280
	)? EOL
;

/** ROD  RISK OBJECT TYPE. */
s_ROD
:
	'ROD'
	(
		PLUS c_C851
	)?
	(
		PLUS c_C852
	)? EOL
;

/** RSL  RESULT. */
s_RSL
:
	'RSL' PLUS d_6087
	(
		PLUS d_6077
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
		PLUS d_6079
	)? EOL
;

/** RTE  RATE DETAILS. */
s_RTE
:
	'RTE' PLUS c_C128
	(
		PLUS d_4405
	)? EOL
;

/** SAL  REMUNERATION TYPE IDENTIFICATION. */
s_SAL
:
	'SAL'
	(
		PLUS c_C049
	)? EOL
;

/** SCC  SCHEDULING CONDITIONS. */
s_SCC
:
	'SCC' PLUS d_4017
	(
		PLUS d_4493
	)?
	(
		PLUS c_C329
	)? EOL
;

/** SCD  STRUCTURE COMPONENT DEFINITION. */
s_SCD
:
	'SCD' PLUS d_7497
	(
		PLUS c_C786
	)?
	(
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS d_1222
	)?
	(
		PLUS c_C778
	)?
	(
		PLUS c_C240
	)? EOL
;

/** SEG  SEGMENT IDENTIFICATION. */
s_SEG
:
	'SEG' PLUS d_9166
	(
		PLUS d_1507
	)?
	(
		PLUS d_4513
	)? EOL
;

/** SEL  SEAL NUMBER. */
s_SEL
:
	'SEL'
	(
		PLUS d_9308
	)?
	(
		PLUS c_C215
	)?
	(
		PLUS d_4517
	)?
	(
		PLUS c_C208
	)?
	(
		PLUS d_4525
	)? EOL
;

/** SEQ  SEQUENCE DETAILS. */
s_SEQ
:
	'SEQ'
	(
		PLUS d_1229
	)?
	(
		PLUS c_C286
	)? EOL
;

/** SFI  SAFETY INFORMATION. */
s_SFI
:
	'SFI' PLUS d_7164
	(
		PLUS c_C814
	)?
	(
		PLUS c_C815
	)?
	(
		PLUS d_4513
	)? EOL
;

/** SGP  SPLIT GOODS PLACEMENT. */
s_SGP
:
	'SGP' PLUS c_C237
	(
		PLUS d_7224
	)? EOL
;

/** SGU  SEGMENT USAGE DETAILS. */
s_SGU
:
	'SGU' PLUS d_9166
	(
		PLUS d_7299
	)?
	(
		PLUS d_6176
	)?
	(
		PLUS d_7168
	)?
	(
		PLUS d_1050
	)?
	(
		PLUS d_1049
	)?
	(
		PLUS d_4513
	)? EOL
;

/** SPR  ORGANISATION CLASSIFICATION DETAILS. */
s_SPR
:
	'SPR' PLUS d_7293
	(
		PLUS d_3079
	)?
	(
		PLUS c_C844
	)? EOL
;

/** SPS  SAMPLING PARAMETERS FOR SUMMARY STATISTICS. */
s_SPS
:
	'SPS'
	(
		PLUS c_C526
	)?
	(
		PLUS d_6074
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
	'STA' PLUS d_6331
	(
		PLUS c_C527
	)? EOL
;

/** STC  STATISTICAL CONCEPT. */
s_STC
:
	'STC' PLUS c_C785
	(
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS d_4513
	)? EOL
;

/** STG  STAGES. */
s_STG
:
	'STG' PLUS d_9421
	(
		PLUS d_6426
	)?
	(
		PLUS d_6428
	)? EOL
;

/** STS  STATUS. */
s_STS
:
	'STS'
	(
		PLUS c_C601
	)?
	(
		PLUS c_C555
	)?
	(
		PLUS c_C556
	)?
	(
		PLUS c_C556
	)?
	(
		PLUS c_C556
	)?
	(
		PLUS c_C556
	)?
	(
		PLUS c_C556
	)? EOL
;

/** TAX  DUTY/TAX/FEE DETAILS. */
s_TAX
:
	'TAX' PLUS d_5283
	(
		PLUS c_C241
	)?
	(
		PLUS c_C533
	)?
	(
		PLUS d_5286
	)?
	(
		PLUS c_C243
	)?
	(
		PLUS d_5305
	)?
	(
		PLUS d_3446
	)?
	(
		PLUS d_1227
	)?
	(
		PLUS d_5307
	)? EOL
;

/** TCC  CHARGE/RATE CALCULATIONS. */
s_TCC
:
	'TCC'
	(
		PLUS c_C200
	)?
	(
		PLUS c_C203
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
	'TDT' PLUS d_8051
	(
		PLUS d_8028
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
		PLUS d_8101
	)?
	(
		PLUS c_C401
	)?
	(
		PLUS c_C222
	)?
	(
		PLUS d_8281
	)?
	(
		PLUS c_C003
	)? EOL
;

/** TEM  TEST METHOD. */
s_TEM
:
	'TEM'
	(
		PLUS c_C244
	)?
	(
		PLUS d_4419
	)?
	(
		PLUS d_3077
	)?
	(
		PLUS d_6311
	)?
	(
		PLUS d_7188
	)?
	(
		PLUS c_C515
	)? EOL
;

/** TMD  TRANSPORT MOVEMENT DETAILS. */
s_TMD
:
	'TMD'
	(
		PLUS c_C219
	)?
	(
		PLUS d_8332
	)?
	(
		PLUS d_8341
	)? EOL
;

/** TMP  TEMPERATURE. */
s_TMP
:
	'TMP' PLUS d_6245
	(
		PLUS c_C239
	)? EOL
;

/** TOD  TERMS OF DELIVERY OR TRANSPORT. */
s_TOD
:
	'TOD'
	(
		PLUS d_4055?
	)?
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
	'TPL' PLUS c_C222 EOL
;

/** TRU  TECHNICAL RULES. */
s_TRU
:
	'TRU' PLUS d_7402
	(
		PLUS d_1056
	)?
	(
		PLUS d_1058
	)?
	(
		PLUS d_7175
	)?
	(
		PLUS d_3055
	)? EOL
;

/** TSR  TRANSPORT SERVICE REQUIREMENTS. */
s_TSR
:
	'TSR'
	(
		PLUS c_C536?
	)?
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
	'UNH' PLUS d_0062 PLUS s009 [$msgType]
	(
		PLUS d_0068
	)?
	(
		PLUS s010
	)?
	(
		PLUS s016
	)?
	(
		PLUS s017
	)?
	(
		PLUS s018
	)? EOL
;

s_UNS
:
	'UNS' PLUS d_0081 EOL
;

s_UNT
:
	'UNT' PLUS d_0074 PLUS d_0062 EOL
;

/** VLI  VALUE LIST IDENTIFICATION. */
s_VLI
:
	'VLI' PLUS c_C780
	(
		PLUS c_C082
	)?
	(
		PLUS d_4405
	)?
	(
		PLUS d_1514
	)?
	(
		PLUS d_1507
	)?
	(
		PLUS d_1505
	)?
	(
		PLUS c_C240
	)? EOL
;
