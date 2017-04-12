parser grammar edifact_d16b_components;

import edifact_d16b_fields, edifact_common;

/*
    C008 Monetary amount function detail
    C009 Information category
    C010 Information type
    C011 Information detail
    C012 Processing indicator
    C019 Payment terms
    C030 Event type
    C040 Carrier
    C042 Nationality details
    C045 Bill level identification
    C049 Remuneration type identification
    C056 Contact details
    C058 Name and address
    C059 Street
    C063 Event identification
    C076 Communication contact
    C077 File identification
    C078 Account holder identification
    C079 Computer environment identification
    C080 Party name
    C082 Party identification details
    C085 Marital status details
    C088 Institution identification
    C090 Address details
    C099 File details
    C100 Terms of delivery or transport
    C101 Religion details
    C106 Document/message identification
    C107 Text reference
    C108 Text literal
    C128 Rate details
    C138 Price multiplier information
    C174 Value/range
    C186 Quantity details
    C200 Charge
    C202 Package type
    C203 Rate/tariff class
    C205 Hazard code
    C206 Identification number
    C208 Identity number range
    C210 Marks & labels
    C211 Dimensions
    C212 Item number identification
    C213 Number and type of packages
    C214 Special services identification
    C215 Seal issuer
    C218 Hazardous material
    C219 Movement type
    C220 Mode of transport
    C222 Transport identification
    C223 Dangerous goods shipment flashpoint
    C224 Equipment size and type
    C229 Charge category
    C231 Method of payment
    C232 Government action
    C233 Service
    C234 UNDG information
    C235 Hazard identification placard details
    C236 Dangerous goods label
    C237 Equipment identification
    C239 Temperature setting
    C240 Characteristic description
    C241 Duty/tax/fee type
    C242 Process type and description
    C243 Duty/tax/fee detail
    C244 Test method
    C246 Customs identity codes
    C270 Control
    C272 Item characteristic
    C273 Item description
    C279 Quantity difference information
    C280 Range
    C286 Sequence information
    C288 Product group
    C289 Tunnel Restriction
    C329 Pattern description
    C330 Insurance cover type
    C331 Insurance cover details
    C332 Sales channel identification
    C333 Information request
    C401 Excess transportation information
    C402 Package type identification
    C501 Percentage details
    C502 Measurement details
    C503 Document/message details
    C504 Currency details
    C506 Reference
    C507 Date/time/period
    C508 Language details
    C509 Price information
    C512 Size details
    C514 Sample location details
    C515 Test reason
    C516 Monetary amount
    C517 Location identification
    C519 Related location one identification
    C521 Business function
    C522 Instruction
    C523 Number of unit details
    C524 Handling instructions
    C525 Purpose of conveyance call
    C526 Frequency details
    C527 Statistical details
    C528 Commodity/rate detail
    C531 Packaging details
    C532 Returnable package details
    C533 Duty/tax/fee account detail
    C534 Payment instruction details
    C536 Contract and carriage condition
    C537 Transport priority
    C543 Agreement type identification
    C545 Index identification
    C546 Index value
    C549 Monetary amount function
    C550 Requirement/condition identification
    C551 Bank operation
    C552 Allowance/charge information
    C553 Related location two identification
    C554 Rate/tariff class detail
    C555 Status
    C556 Status reason
    C564 Physical or logical state information
    C585 Priority details
    C593 Account identification
    C595 Accounting journal identification
    C596 Accounting entry type details
    C601 Status category
    C701 Error point details
    C702 Code set identification
    C703 Nature of cargo
    C709 Message identifier
    C770 Array cell details
    C778 Position identification
    C779 Array structure identification
    C780 Value list identification
    C782 Data set identification
    C783 Footnote set identification
    C784 Footnote identification
    C785 Statistical concept identification
    C786 Structure component identification
    C811 Question details
    C812 Response details
    C814 Safety section
    C815 Additional safety information
    C816 Name component details
    C817 Address usage
    C818 Person inherited characteristic details
    C819 Country subdivision details
    C820 Premium calculation component
    C821 Type of damage
    C822 Damage area
    C823 Type of unit/component
    C824 Component material
    C825 Damage severity
    C826 Action
    C827 Type of marking
    C828 Clinical intervention details
    C829 Sub-line information
    C830 Process identification details
    C831 Result details
    C836 Clinical information details
    C837 Certainty details
    C838 Dosage details
    C839 Attendee category
    C840 Attendance admission details
    C841 Attendance discharge details
    C844 Organisation classification detail
    C848 Measurement unit details
    C849 Parties to instruction
    C850 Status of instruction
    C851 Risk object type
    C852 Risk object sub-type
    C853 Error segment point details
    C878 Charge/allowance account
    C889 Characteristic value
    C901 Application error detail
    C941 Relationship
    C942 Membership category
    C944 Membership status
    C945 Membership level
    C948 Employment category
    C950 Qualification classification
    C951 Occupation
    C953 Contribution type
    C955 Attribute type
    C956 Attribute detail
    C960 Reason for change
    C961 Formula complexity
    C970 Clause name
    C971 Proviso type
    C972 Proviso calculation
    C973 Applicability type
    C974 Basis type
    C977 Period detail

 */

/**
 * C001 Transport means
 */
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

/**
 * C002 Document/message name
 */
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

/**
 * C003 Power type
 */
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

/**
 * C004 EVENT CATEGORY
 */
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

/**
 * C008 MONETARY AMOUNT FUNCTION DETAIL
 */
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

/**
 * C009 INFORMATION CATEGORY
 */
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

/**
 * C010 INFORMATION TYPE
 */
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

/**
 * C011 INFORMATION DETAIL
 */
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

/**
 * C012 PROCESSING INDICATOR
 */
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

c229
:
    d_5237
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c231
:
    d_4215
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c232
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

c233
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

c234
:
    d_7124?
    (
        COLON d_7088?
    )?
;

c235
:
    d_8158?
    (
        COLON d_8186?
    )?
;

c236
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

c237
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

c239
:
    d_6246?
    (
        COLON d_6411?
    )?
;

c270
:
    d_6069 COLON d_6066
    (
        COLON d_6411?
    )?
;

c280
:
    d_6411
    (
        COLON d_6162?
    )?
    (
        COLON d_6152?
    )?
;

c286
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

c288
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

c289
:
    d_8461?
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c329
:
    d_2013?
    (
        COLON d_2015?
    )?
    (
        COLON d_2017?
    )?
;

c330
:
    d_4497
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c331
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

c401
:
    d_8457 COLON d_8459
    (
        COLON d_7130?
    )?
;

c501
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

c502
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

c503
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

c504
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

c506
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

c507
:
    d_2005
    (
        COLON d_2380?
    )?
    (
        COLON d_2379?
    )?
;

c509
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

c516
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

c517
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

c519
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

c523
:
    d_6350?
    (
        COLON d_6353?
    )?
;

c524
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

c525
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

c528
:
    d_7357?
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c536
:
    d_4065
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c537
:
    d_4219
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c553
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

c554
:
    d_5243?
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c703
:
    d_7085
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c819
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

c827
:
    d_7511
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

c901
:
    d_9321
    (
        COLON d_1131?
    )?
    (
        COLON d_3055?
    )?
;

s009
:
    d_0065 COLON d_0052 COLON d_0054 COLON d_0051
    (
        COLON d_0057?
    )?
    (
        COLON d_0110?
    )?
    (
        COLON d_0113?
    )?
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
