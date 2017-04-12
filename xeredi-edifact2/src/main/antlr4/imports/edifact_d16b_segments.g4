grammar edifact_d16b_segments;

import edifact_d16b_components, edifact_d16b_fields, edifact_common;

/** ADR  ADDRESS. FIXME Revisar.*/
s_ADR
:
    'ADR'
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
    'AGR'
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
    'AJT' PLUS d_4465
    (
        PLUS d_1082
    )? EOL
;

/** ALC  ALLOWANCE OR CHARGE. */
s_ALC
:
    'ALC' PLUS d_5463
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
    'ALI'
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
    'APR'
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
    'ARD'
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
    'ARR'
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
    'ASI' PLUS c_C779
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
    'ATT' PLUS d_9017
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
    'AUT' PLUS d_9280
    (
        PLUS d_9282
    )? EOL
;

/** BAS  BASIS. */
s_BAS
:
    'BAS' PLUS d_9045 PLUS c_C974 EOL
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
        PLUS c_C521
    )?
    (
        PLUS d_3279
    )?
    (
        PLUS d_4487
    )?
    (
        PLUS c_C551
    )?
    (
        PLUS d_4463
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



s_TAX
:
    'TAX+' EOL
;

s_LIN
:
    'LIN+' EOL
;

s_STS
:
    'STS+' EOL
;

s_GPO
:
    'GPO+' EOL
;

s_GEI
:
    'GEI+' EOL
;

s_FII
:
    'FII+' EOL
;

s_IDT
:
    'IDT+' EOL
;

s_UNH
:
    'UNH' PLUS d_0062 PLUS s009
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

s_DTM
:
    'DTM' PLUS c_C507 EOL
;

s_RFF
:
    'RFF' PLUS c_C506 EOL
;

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

s_NAD
:
    'NAD' PLUS d_3035
    (
        PLUS c_C082
    )?
    (
        PLUS c_C058
    )?
    (
        PLUS c_C080
    )?
    (
        PLUS c_C059
    )?
    (
        PLUS d_3164
    )?
    (
        PLUS c_C819
    )?
    (
        PLUS d_3251
    )?
    (
        PLUS d_3207
    )? EOL
;

s_CNI
:
    'CNI'
    (
        PLUS d_1490
    )?
    (
        PLUS c_C503
    )?
    (
        PLUS d_1312
    )? EOL
;

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

s_PCI
:
    'PCI'
    (
        PLUS d_4233?
    )?
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

s_DOC
:
    'DOC' PLUS c_C002
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

s_SGP
:
    'SGP' PLUS c_C237
    (
        PLUS d_7224?
    )? EOL
;

s_EQD
:
    'EQD' PLUS d_8053
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

s_UNT
:
    'UNT' PLUS d_0074 PLUS d_0062 EOL
;

s_CNT
:
    'CNT' PLUS c_C270 EOL
;

s_COM
:
    'COM' PLUS c_C076 EOL
;

s_CPI
:
    'CPI'
    (
        PLUS c_C229?
    )?
    (
        PLUS c_C231?
    )?
    (
        PLUS d_4237?
    )? EOL
;

s_CTA
:
    'CTA'
    (
        PLUS d_3139
    )?
    (
        PLUS c_C056
    )? EOL
;

s_CUX
:
    'CUX' PLUS c_C504
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

s_DGS
:
    'DGS'
    (
        PLUS d_8273
    )?
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

s_DIM
:
    'DIM' PLUS d_6145 PLUS c_C211 EOL
;

s_EQA
:
    'EQA' PLUS d_8053
    (
        PLUS c_C237
    )? EOL
;

s_EQN
:
    'EQN' PLUS c_C523 EOL
;

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

s_GIN
:
    'GIN' PLUS d_7402 PLUS c_C208
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

s_ICD
:
    'ICD' PLUS c_C330 PLUS c_C331 EOL
;

s_MOA
:
    'MOA' PLUS c_C516 EOL
;

s_PCD
:
    'PCD' PLUS c_C501
    (
        PLUS d_4405?
    )? EOL
;

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

s_PRI
:
    'PRI'
    (
        PLUS c_C509?
    )?
    (
        PLUS d_5213?
    )? EOL
;

s_QTY
:
    'QTY' PLUS c_C186 EOL
;

s_RNG
:
    'RNG' PLUS d_6167
    (
        PLUS c_C280?
    )? EOL
;

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

s_SEQ
:
    'SEQ'
    (
        PLUS d_1229?
    )?
    (
        PLUS c_C286?
    )? EOL
;

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

s_TMP
:
    'TMP' PLUS d_6245
    (
        PLUS c_C239
    )? EOL
;

s_TOD
:
    'TOD'
    (
        PLUS d_4055
    )?
    (
        PLUS d_4215
    )?
    (
        PLUS c_C100
    )? EOL
;

s_TPL
:
    'TPL' PLUS c_C222 EOL
;

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

s_ERC
:
    'ERC' PLUS c_C901 EOL
;

s_POC
:
    'POC' PLUS c_C525 EOL
;
