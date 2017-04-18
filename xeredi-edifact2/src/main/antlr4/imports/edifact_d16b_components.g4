parser grammar edifact_d16b_components;

import edifact_d16b_fields, edifact_common;

/** C001 Transport means */
c_C001
:
	d_8179?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_8178?
	)?
;

/** C002 Document/message name */
c_C002
:
	d_1001?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_1000?
	)?
;

/** C003 Power type */
c_C003
:
	d_7041?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7040?
	)?
;

/** C004 EVENT CATEGORY */
c_C004
:
	d_9637?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9636?
	)?
;

/** C008 MONETARY AMOUNT FUNCTION DETAIL */
c_C008
:
	d_5105?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5104?
	)?
;

/** C009 INFORMATION CATEGORY */
c_C009
:
	d_4149?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4148?
	)?
;

/** C010 INFORMATION TYPE */
c_C010
:
	d_4473?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4472?
	)?
;

/** C011 INFORMATION DETAIL */
c_C011
:
	d_4151?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4150?
	)?
;

/** C012 PROCESSING INDICATOR */
c_C012
:
	d_7365?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7364?
	)?
;

/**
 * C019 PAYMENT TERMS
 */
c_C019
:
	d_4277?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4276?
	)?
;

/**
 * C030 EVENT TYPE
 */
c_C030
:
	d_9171?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9170?
	)?
;

/**
 * C040 CARRIER
 */
c_C040
:
	d_3127?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3126?
	)?
;

/**
 * C042 NATIONALITY DETAILS
 */
c_C042
:
	d_3293?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3292?
	)?
;

/**
 * C045 BILL LEVEL IDENTIFICATION
 */
c_C045
:
	d_7436?
	(
		COLON d_7438?
	)?
	(
		COLON d_7440?
	)?
	(
		COLON d_7442?
	)?
	(
		COLON d_7444?
	)?
	(
		COLON d_7446?
	)?
;

/**
 * C049 REMUNERATION TYPE IDENTIFICATION
 */
c_C049
:
	d_5315?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5314?
	)?
	(
		COLON d_5314?
	)?
;

/**
 * C056 CONTACT DETAILS
 */
c_C056
:
	d_3413?
	(
		COLON d_3412?
	)?
;

/**
 * C058 NAME AND ADDRESS
 */
c_C058
:
	d_3124
	(
		COLON d_3124?
	)?
	(
		COLON d_3124?
	)?
	(
		COLON d_3124?
	)?
	(
		COLON d_3124?
	)?
;

/**
 * C059 STREET
 */
c_C059
:
	d_3042
	(
		COLON d_3042?
	)?
	(
		COLON d_3042?
	)?
	(
		COLON d_3042?
	)?
;

/**
 * C063 EVENT IDENTIFICATION
 */
c_C063
:
	d_9173?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9172?
	)?
;

/**
 * C076 COMMUNICATION CONTACT
 */
c_C076
:
	d_3148 COLON d_3155
;

/**
 * C077 FILE IDENTIFICATION
 */
c_C077
:
	d_1508?
	(
		COLON d_7008?
	)?
;

/**
 * C078 ACCOUNT HOLDER IDENTIFICATION
 */
c_C078
:
	d_3194?
	(
		COLON d_3192?
	)?
	(
		COLON d_3192?
	)?
	(
		COLON d_6345?
	)?
;

/**
 * C079 COMPUTER ENVIRONMENT IDENTIFICATION
 */
c_C079
:
	d_1511?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_1510?
	)?
	(
		COLON d_1056?
	)?
	(
		COLON d_1058?
	)?
	(
		COLON d_7402?
	)?
;

/**
 * C080 PARTY NAME
 */
c_C080
:
	d_3036
	(
		COLON d_3036?
	)?
	(
		COLON d_3036?
	)?
	(
		COLON d_3036?
	)?
	(
		COLON d_3036?
	)?
	(
		COLON d_3045?
	)?
;

/**
 * C082 PARTY IDENTIFICATION DETAILS
 */
c_C082
:
	d_3039
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C085 MARITAL STATUS DETAILS
 */
c_C085
:
	d_3479
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3478?
	)?
;

/**
 * C088 INSTITUTION IDENTIFICATION
 */
c_C088
:
	d_3433
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3434?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3432?
	)?
	(
		COLON d_3436?
	)?
;

/**
 * C090 ADDRESS DETAILS
 */
c_C090
:
	d_3477 COLON d_3286
	(
		COLON d_3286?
	)?
	(
		COLON d_3286?
	)?
	(
		COLON d_3286?
	)?
	(
		COLON d_3286?
	)?
;

/**
 * C099 FILE DETAILS
 */
c_C099
:
	d_1516
	(
		COLON d_1056?
	)?
	(
		COLON d_1503?
	)?
	(
		COLON d_1502?
	)?
;

/**
 * C100 TERMS OF DELIVERY OR TRANSPORT
 */
c_C100
:
	d_4053?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4052?
	)?
	(
		COLON d_4052?
	)?
;

/**
 * C101 RELIGION DETAILS
 */
c_C101
:
	d_3483
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3482?
	)?
;

/**
 * C106 DOCUMENT/MESSAGE IDENTIFICATION
 */
c_C106
:
	d_1004?
	(
		COLON d_1056?
	)?
	(
		COLON d_1060?
	)?
;

/**
 * C107 TEXT REFERENCE
 */
c_C107
:
	d_4441
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C108 TEXT LITERAL
 */
c_C108
:
	d_4440
	(
		COLON d_4440?
	)?
	(
		COLON d_4440?
	)?
	(
		COLON d_4440?
	)?
	(
		COLON d_4440?
	)?
;

/**
 * C128 RATE DETAILS
 */
c_C128
:
	d_5419 COLON d_5420
	(
		COLON d_5284?
	)?
	(
		COLON d_6411?
	)?
;

/**
 * C138 PRICE MULTIPLIER INFORMATION
 */
c_C138
:
	d_5394
	(
		COLON d_5393?
	)?
;

/**
 * C174 VALUE/RANGE
 */
c_C174
:
	d_6411
	(
		COLON d_6314?
	)?
	(
		COLON d_6162?
	)?
	(
		COLON d_6152?
	)?
	(
		COLON d_6432?
	)?
;

/**
 * C186 QUANTITY DETAILS
 */
c_C186
:
	d_6063 COLON d_6060
	(
		COLON d_6411?
	)?
;

/**
 * C200 CHARGE
 */
c_C200
:
	d_8023?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_8022?
	)?
	(
		COLON d_4237?
	)?
	(
		COLON d_7140?
	)?
;

/**
 * C202 PACKAGE TYPE
 */
c_C202
:
	d_7065
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7064?
	)?
;

/**
 * C203 RATE/TARIFF CLASS
 */
c_C203
:
	d_5243
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5242?
	)?
	(
		COLON d_5275?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5275?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C205 HAZARD CODE
 */
c_C205
:
	d_8351
	(
		COLON d_8078?
	)?
	(
		COLON d_8092?
	)?
;

/**
 * C206 IDENTIFICATION NUMBER
 */
c_C206
:
	d_7402
	(
		COLON d_7405?
	)?
	(
		COLON d_4405?
	)?
;

/**
 * C208 IDENTITY NUMBER RANGE
 */
c_C208
:
	d_7402
	(
		COLON d_7402?
	)?
;

/**
 * C210 MARKS & LABELS
 */
c_C210
:
	d_7102
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
	(
		COLON d_7102?
	)?
;

/**
 * C211 DIMENSIONS
 */
c_C211
:
	d_6411
	(
		COLON d_6168?
	)?
	(
		COLON d_6140?
	)?
	(
		COLON d_6008?
	)?
	(
		COLON d_6182?
	)?
;

/**
 * C212 ITEM NUMBER IDENTIFICATION
 */
c_C212
:
	d_7140?
	(
		COLON d_7143?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C213 NUMBER AND TYPE OF PACKAGES
 */
c_C213
:
	d_7224?
	(
		COLON d_7065?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7064?
	)?
	(
		COLON d_7233?
	)?
;

/**
 * C214 SPECIAL SERVICES IDENTIFICATION
 */
c_C214
:
	d_7161?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7160?
	)?
	(
		COLON d_7160?
	)?
;

/**
 * C215 SEAL ISSUER
 */
c_C215
:
	d_9303?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9302?
	)?
;

/**
 * C218 HAZARDOUS MATERIAL
 */
c_C218
:
	d_7419?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7418?
	)?
;

/**
 * C219 MOVEMENT TYPE
 */
c_C219
:
	d_8335?
	(
		COLON d_8334?
	)?
;

/**
 * C220 MODE OF TRANSPORT
 */
c_C220
:
	d_8067?
	(
		COLON d_8066?
	)?
;

/**
 * C222 TRANSPORT IDENTIFICATION
 */
c_C222
:
	d_8213?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_8212?
	)?
	(
		COLON d_8453?
	)?
;

/**
 * C223 DANGEROUS GOODS SHIPMENT FLASHPOINT
 */
c_C223
:
	d_7106?
	(
		COLON d_6411?
	)?
;

/**
 * C224 EQUIPMENT SIZE AND TYPE
 */
c_C224
:
	d_8155?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_8154?
	)?
;

/**
 * C229 CHARGE CATEGORY
 */
c_C229
:
	d_5237
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C231 METHOD OF PAYMENT
 */
c_C231
:
	d_4215
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C232 GOVERNMENT ACTION
 */
c_C232
:
	d_9415?
	(
		COLON d_9411?
	)?
	(
		COLON d_9417?
	)?
	(
		COLON d_9353?
	)?
;

/**
 * C233 SERVICE
 */
c_C233
:
	d_7273
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7273?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C234 UNDG INFORMATION
 */
c_C234
:
	d_7124?
	(
		COLON d_7088?
	)?
;

/**
 * C235 HAZARD IDENTIFICATION PLACARD DETAILS
 */
c_C235
:
	d_8158?
	(
		COLON d_8186?
	)?
;

/**
 * C236 DANGEROUS GOODS LABEL
 */
c_C236
:
	d_8246?
	(
		COLON d_8246?
	)?
	(
		COLON d_8246?
	)?
	(
		COLON d_8246?
	)?
;

/**
 * C237 EQUIPMENT IDENTIFICATION
 */
c_C237
:
	d_8260?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3207?
	)?
;

/**
 * C239 TEMPERATURE SETTING
 */
c_C239
:
	d_6246?
	(
		COLON d_6411?
	)?
;

/**
 * C240 CHARACTERISTIC DESCRIPTION
 */
c_C240
:
	d_7037
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7036?
	)?
	(
		COLON d_7036?
	)?
;

/**
 * C241 DUTY/TAX/FEE TYPE
 */
c_C241
:
	d_5153?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5152?
	)?
;

/**
 * C242 PROCESS TYPE AND DESCRIPTION
 */
c_C242
:
	d_7187
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7186?
	)?
	(
		COLON d_7186?
	)?
;

/**
 * C243 DUTY/TAX/FEE DETAIL
 */
c_C243
:
	d_5279?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5278?
	)?
	(
		COLON d_5273?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C244 TEST METHOD
 */
c_C244
:
	d_4415?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4416?
	)?
;

/**
 * C246 CUSTOMS IDENTITY CODES
 */
c_C246
:
	d_7361
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C270 CONTROL
 */
c_C270
:
	d_6069 COLON d_6066
	(
		COLON d_6411?
	)?
;

/**
 * C272 ITEM CHARACTERISTIC
 */
c_C272
:
	d_7081?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C273 ITEM DESCRIPTION
 */
c_C273
:
	d_7009?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7008?
	)?
	(
		COLON d_7008?
	)?
	(
		COLON d_3453?
	)?
;

/**
 * C279 QUANTITY DIFFERENCE INFORMATION
 */
c_C279
:
	d_6064
	(
		COLON d_6063?
	)?
;

/**
 * C280 RANGE
 */
c_C280
:
	d_6411
	(
		COLON d_6162?
	)?
	(
		COLON d_6152?
	)?
;

/**
 * C286 SEQUENCE INFORMATION
 */
c_C286
:
	d_1050
	(
		COLON d_1159?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C288 PRODUCT GROUP
 */
c_C288
:
	d_5389?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5388?
	)?
;

/**
 * C289 TUNNEL RESTRICTION
 */
c_C289
:
	d_8461?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C329 PATTERN DESCRIPTION
 */
c_C329
:
	d_2013?
	(
		COLON d_2015?
	)?
	(
		COLON d_2017?
	)?
;

/**
 * C330 INSURANCE COVER TYPE
 */
c_C330
:
	d_4497
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C331 INSURANCE COVER DETAILS
 */
c_C331
:
	d_4495?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4494?
	)?
	(
		COLON d_4494?
	)?
;

/**
 * C332 SALES CHANNEL IDENTIFICATION
 */
c_C332
:
	d_3496
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C333 INFORMATION REQUEST
 */
c_C333
:
	d_4511?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4510?
	)?
;

/**
 * C401 EXCESS TRANSPORTATION INFORMATION
 */
c_C401
:
	d_8457 COLON d_8459
	(
		COLON d_7130?
	)?
;

/**
 * C402 PACKAGE TYPE IDENTIFICATION
 */
c_C402
:
	d_7077 COLON d_7064
	(
		COLON d_7143?
	)?
	(
		COLON d_7064?
	)?
	(
		COLON d_7143?
	)?
;

/**
 * C501 PERCENTAGE DETAILS
 */
c_C501
:
	d_5245
	(
		COLON d_5482?
	)?
	(
		COLON d_5249?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C502 MEASUREMENT DETAILS
 */
c_C502
:
	d_6313?
	(
		COLON d_6321?
	)?
	(
		COLON d_6155?
	)?
	(
		COLON d_6154?
	)?
;

/**
 * C503 DOCUMENT/MESSAGE DETAILS
 */
c_C503
:
	d_1004?
	(
		COLON d_1373?
	)?
	(
		COLON d_1366?
	)?
	(
		COLON d_3453?
	)?
	(
		COLON d_1056?
	)?
	(
		COLON d_1060?
	)?
;

/**
 * C504 CURRENCY DETAILS
 */
c_C504
:
	d_6347
	(
		COLON d_6345?
	)?
	(
		COLON d_6343?
	)?
	(
		COLON d_6348?
	)?
;

/**
 * C506 REFERENCE
 */
c_C506
:
	d_1153
	(
		COLON d_1154?
	)?
	(
		COLON d_1156?
	)?
	(
		COLON d_1056?
	)?
	(
		COLON d_1060?
	)?
;

/**
 * C507 DATE/TIME/PERIOD
 */
c_C507
:
	d_2005
	(
		COLON d_2380?
	)?
	(
		COLON d_2379?
	)?
;

/**
 * C508 LANGUAGE DETAILS
 */
c_C508
:
	d_3453?
	(
		COLON d_3452?
	)?
;

/**
 * C509 PRICE INFORMATION
 */
c_C509
:
	d_5125
	(
		COLON d_5118?
	)?
	(
		COLON d_5375?
	)?
	(
		COLON d_5387?
	)?
	(
		COLON d_5284?
	)?
	(
		COLON d_6411?
	)?
;

/**
 * C512 SIZE DETAILS
 */
c_C512
:
	d_6173?
	(
		COLON d_6174?
	)?
;

/**
 * C514 SAMPLE LOCATION DETAILS
 */
c_C514
:
	d_3237?
	(
		COLON d_3236?
	)?
;

/**
 * C515 TEST REASON
 */
c_C515
:
	d_4425?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4424?
	)?
;

/**
 * C516 MONETARY AMOUNT
 */
c_C516
:
	d_5025
	(
		COLON d_5004?
	)?
	(
		COLON d_6345?
	)?
	(
		COLON d_6343?
	)?
	(
		COLON d_4405?
	)?
;

/**
 * C517 LOCATION IDENTIFICATION
 */
c_C517
:
	d_3225?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3224?
	)?
;

/**
 * C519 RELATED LOCATION ONE IDENTIFICATION
 */
c_C519
:
	d_3223?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3222?
	)?
;

/**
 * C521 BUSINESS FUNCTION
 */
c_C521
:
	d_4027 COLON d_4025
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4022?
	)?
;

/**
 * C522 INSTRUCTION
 */
c_C522
:
	d_4403
	(
		COLON d_4401?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4400?
	)?
;

/**
 * C523 NUMBER OF UNIT DETAILS
 */
c_C523
:
	d_6350?
	(
		COLON d_6353?
	)?
;

/**
 * C524 HANDLING INSTRUCTIONS
 */
c_C524
:
	d_4079?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4078?
	)?
;

/**
 * C525 PURPOSE OF CONVEYANCE CALL
 */
c_C525
:
	d_8025?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_8024?
	)?
;

/**
 * C526 FREQUENCY DETAILS
 */
c_C526
:
	d_6071
	(
		COLON d_6072?
	)?
	(
		COLON d_6411?
	)?
;

/**
 * C527 STATISTICAL DETAILS
 */
c_C527
:
	d_6314?
	(
		COLON d_6411?
	)?
	(
		COLON d_6313?
	)?
	(
		COLON d_6321?
	)?
;

/**
 * C528 COMMODITY/RATE DETAIL
 */
c_C528
:
	d_7357?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/**
 * C531 PACKAGING DETAILS
 */
c_C531
:
	d_7075?
	(
		COLON d_7233?
	)?
	(
		COLON d_7073?
	)?
;

/**
 * C532 RETURNABLE PACKAGE DETAILS
 */
c_C532
:
	d_8395?
	(
		COLON d_8393?
	)?
;

/**
 * C533 DUTY/TAX/FEE ACCOUNT DETAIL
 */
c_C533
:
	d_5289
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C534 PAYMENT INSTRUCTION DETAILS. */
c_C534
:
	d_4439?
	(
		COLON d_4431?
	)?
	(
		COLON d_4461?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4435?
	)?
;

/** C536 CONTRACT AND CARRIAGE CONDITION. */
c_C536
:
	d_4065
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C537 TRANSPORT PRIORITY. */
c_C537
:
	d_4219
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C543 AGREEMENT TYPE IDENTIFICATION. */
c_C543
:
	d_7431
	(
		COLON d_7433?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7434?
	)?
;

/** C545 INDEX IDENTIFICATION */
c_C545
:
	d_5013
	(
		COLON d_5027?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C546 INDEX VALUE */
c_C546
:
	d_5030
	(
		COLON d_5039?
	)?
;

/** C549 MONETARY AMOUNT FUNCTION */
c_C549
:
	d_5007?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5006?
	)?
;

/** C550 REQUIREMENT/CONDITION IDENTIFICATION */
c_C550
:
	d_7295
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7294?
	)?
;

/** C551 BANK OPERATION */
c_C551
:
	d_4383
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C552 ALLOWANCE/CHARGE INFORMATION */
c_C552
:
	d_1230?
	(
		COLON d_5189?
	)?
;

/** C553 RELATED LOCATION TWO IDENTIFICATION */
c_C553
:
	d_3233?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3232?
	)?
;

/** C554 RATE/TARIFF CLASS DETAIL */
c_C554
:
	d_5243?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C555 STATUS */
c_C555
:
	d_4405
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4404?
	)?
;

/** C556 STATUS REASON */
c_C556
:
	d_9013
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9012?
	)?
;

/** C564 PHYSICAL OR LOGICAL STATE INFORMATION */
c_C564
:
	d_7007?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7006?
	)?
;

/** C585 PRIORITY DETAILS */
c_C585
:
	d_4037?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4036?
	)?
;

/** C593 ACCOUNT IDENTIFICATION */
c_C593
:
	d_1147
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_1148?
	)?
	(
		COLON d_1146?
	)?
	(
		COLON d_1146?
	)?
	(
		COLON d_6345?
	)?
;

/** C595 ACCOUNTING JOURNAL IDENTIFICATION */
c_C595
:
	d_1171
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_1170?
	)?
;

/** C596 ACCOUNTING ENTRY TYPE DETAILS */
c_C596
:
	d_4475
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4474?
	)?
;

/** C601 STATUS CATEGORY. */
c_C601
:
	d_9015
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C701 ERROR POINT DETAILS. */
c_C701
:
	d_1049?
	(
		COLON d_1052?
	)?
	(
		COLON d_1054?
	)?
;

/** C702 CODE SET IDENTIFICATION. */
c_C702
:
	d_9150?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C703 NATURE OF CARGO.  */
c_C703
:
	d_7085
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C709 MESSAGE IDENTIFIER.  */
c_C709
:
	d_1003
	(
		COLON d_1056?
	)?
	(
		COLON d_1058?
	)?
	(
		COLON d_1476?
	)?
	(
		COLON d_1523?
	)?
	(
		COLON d_1060?
	)?
	(
		COLON d_1373?
	)?
;

/** C770 ARRAY CELL DETAILS.  */
c_C770
:
	d_9424?
;

/** C778 POSITION IDENTIFICATION.  */
c_C778
:
	d_7164?
	(
		COLON d_1050?
	)?
;

/** C779 ARRAY STRUCTURE IDENTIFICATION.  */
c_C779
:
	d_9428
	(
		COLON d_7405?
	)?
;

/** C780 VALUE LIST IDENTIFICATION.  */
c_C780
:
	d_1518
	(
		COLON d_7405?
	)?
;

/** C782 DATA SET IDENTIFICATION.  */
c_C782
:
	d_1520
	(
		COLON d_7405?
	)?
;

/** C783 FOOTNOTE SET IDENTIFICATION.  */
c_C783
:
	d_9430
	(
		COLON d_7405?
	)?
;

/** C784 FOOTNOTE IDENTIFICATION.  */
c_C784
:
	d_9432
	(
		COLON d_7405?
	)?
;

/** C785 STATISTICAL CONCEPT IDENTIFICATION.  */
c_C785
:
	d_6434
	(
		COLON d_7405?
	)?
;

/** C786 STRUCTURE COMPONENT IDENTIFICATION.  */
c_C786
:
	d_7512
	(
		COLON d_7405?
	)?
;

/** C811 QUESTION DETAILS.  */
c_C811
:
	d_4057?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4056?
	)?
;

/** C812 RESPONSE DETAILS.  */
c_C812
:
	d_4345?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4344?
	)?
;

/** C814 SAFETY SECTION.  */
c_C814
:
	d_4046
	(
		COLON d_4044?
	)?
;

/** C815 ADDITIONAL SAFETY INFORMATION.  */
c_C815
:
	d_4039
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4038?
	)?
;

/** C816 NAME COMPONENT DETAILS.  */
c_C816
:
	d_3405
	(
		COLON d_3398?
	)?
	(
		COLON d_3401?
	)?
	(
		COLON d_3295?
	)?
;

/** C817 ADDRESS USAGE.  */
c_C817
:
	d_3299?
	(
		COLON d_3131?
	)?
	(
		COLON d_3475?
	)?
;

/** C818 PERSON INHERITED CHARACTERISTIC DETAILS.  */
c_C818
:
	d_3311?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3310?
	)?
;

/** C819 COUNTRY SUBDIVISION DETAILS. */
c_C819
:
	d_3229?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3228?
	)?
;

/** C820 PREMIUM CALCULATION COMPONENT. */
c_C820
:
	d_4521?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C821 TYPE OF DAMAGE. */
c_C821
:
	d_7501?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7500?
	)?
;

/** C822 DAMAGE AREA. */
c_C822
:
	d_7503?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7502?
	)?
;

/** C823 TYPE OF UNIT/COMPONENT. */
c_C823
:
	d_7505?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7504?
	)?
;

/** C824 COMPONENT MATERIAL. */
c_C824
:
	d_7507?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7506?
	)?
;

/** C825 DAMAGE SEVERITY. */
c_C825
:
	d_7509?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7508?
	)?
;

/** C826 ACTION. */
c_C826
:
	d_1229?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_1228?
	)?
;

/** C827 TYPE OF MARKING. */
c_C827
:
	d_7511
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C828 CLINICAL INTERVENTION DETAILS. */
c_C828
:
	d_9437?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9436?
	)?
;

/** C829 SUB-LINE INFORMATION. */
c_C829
:
	d_5495?
	(
		COLON d_1082?
	)?
;

/** C830 PROCESS IDENTIFICATION DETAILS. */
c_C830
:
	d_7191?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7190?
	)?
;

/** C831 RESULT DETAILS. */
c_C831
:
	d_6314?
	(
		COLON d_6321?
	)?
	(
		COLON d_6155?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_6154?
	)?
;

/** C836 CLINICAL INFORMATION DETAILS. */
c_C836
:
	d_6413?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_6412?
	)?
;

/** C837 CERTAINTY DETAILS. */
c_C837
:
	d_4049?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4048?
	)?
;

/** C838 DOSAGE DETAILS. */
c_C838
:
	d_6083?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_6082?
	)?
;

/** C839 ATTENDEE CATEGORY. */
c_C839
:
	d_7459?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7458?
	)?
;

/** C840 ATTENDANCE ADMISSION DETAILS. */
c_C840
:
	d_9445?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9444?
	)?
;

/** C841 ATTENDANCE DISCHARGE DETAILS. */
c_C841
:
	d_9447?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9446?
	)?
;

/** C844 ORGANISATION CLASSIFICATION DETAIL. */
c_C844
:
	d_3083?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3082?
	)?
;

/** C848 MEASUREMENT UNIT DETAILS. */
c_C848
:
	d_6411?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_6410?
	)?
;

/** C849 PARTIES TO INSTRUCTION. */
c_C849
:
	d_3301
	(
		COLON d_3285?
	)?
;

/** C850 STATUS OF INSTRUCTION. */
c_C850
:
	d_4405
	(
		COLON d_3036?
	)?
;

/** C851 RISK OBJECT TYPE. */
c_C851
:
	d_7179?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C852 RISK OBJECT SUB-TYPE. */
c_C852
:
	d_7177?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7176?
	)?
;

/** C853 ERROR SEGMENT POINT DETAILS. */
c_C853
:
	d_9166?
	(
		COLON d_1050?
	)?
	(
		COLON d_1159?
	)?
;

/** C878 CHARGE/ALLOWANCE ACCOUNT. */
c_C878
:
	d_3434
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_3194?
	)?
	(
		COLON d_6345?
	)?
;

/** C889 CHARACTERISTIC VALUE. */
c_C889
:
	d_7111?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7110?
	)?
	(
		COLON d_7110?
	)?
;

/** C901 APPLICATION ERROR DETAIL. */
c_C901
:
	d_9321
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C941 RELATIONSHIP. */
c_C941
:
	d_9143?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9142?
	)?
;

/** C942 MEMBERSHIP CATEGORY. */
c_C942
:
	d_7451
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7450?
	)?
;

/** C944 MEMBERSHIP STATUS. */
c_C944
:
	d_7453?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7452?
	)?
;

/** C945 MEMBERSHIP LEVEL. */
c_C945
:
	d_7455
	(
		COLON d_7457?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_7456?
	)?
;

/** C948 EMPLOYMENT CATEGORY. */
c_C948
:
	d_9005?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9004?
	)?
;

/** C950 QUALIFICATION CLASSIFICATION. */
c_C950
:
	d_9007?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9006?
	)?
	(
		COLON d_9006?
	)?
;

/** C951 OCCUPATION. */
c_C951
:
	d_9009?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9008?
	)?
	(
		COLON d_9008?
	)?
;

/** C953 CONTRIBUTION TYPE. */
c_C953
:
	d_5049
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_5048?
	)?
;

/** C955 ATTRIBUTE TYPE. */
c_C955
:
	d_9021?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9020?
	)?
;

/** C956 ATTRIBUTE DETAIL. */
c_C956
:
	d_9019?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9018?
	)?
;

/** C960 REASON FOR CHANGE. */
c_C960
:
	d_4295?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4294?
	)?
;

/** C961 FORMULA COMPLEXITY. */
c_C961
:
	d_9505?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

/** C970 CLAUSE NAME. */
c_C970
:
	d_4069?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4068?
	)?
;

/** C971 PROVISO TYPE. */
c_C971
:
	d_4073?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4072?
	)?
;

/** C972 PROVISO CALCULATION. */
c_C972
:
	d_4075?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_4074?
	)?
;

/** C973 APPLICABILITY TYPE. */
c_C973
:
	d_9049?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9048?
	)?
;

/** C974 BASIS TYPE. */
c_C974
:
	d_9047?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON d_9046?
	)?
;

/** C977 PERIOD DETAIL. */
c_C977
:
	d_2119?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

s009 [String msgType]
:
	d_0065 [$msgType] COLON d_0052 COLON d_0054 COLON d_0051
	(
		COLON d_0057?
	)?
	(
		COLON d_0110?
	)?
	(
		COLON d_0113?
	)?
	{$msgType.equals($d_0065.text.toString())}?

;

s010
:
	d_0070
	(
		COLON d_0073?
	)?
;

s016
:
	d_0115
	(
		COLON d_0116?
	)?
	(
		COLON d_0118?
	)?
	(
		COLON d_0051?
	)?
;

s017
:
	d_0121
	(
		COLON d_0122?
	)?
	(
		COLON d_0124?
	)?
	(
		COLON d_0051?
	)?
;

s018
:
	d_0127
	(
		COLON d_0128?
	)?
	(
		COLON d_0130?
	)?
	(
		COLON d_0051?
	)?
;
