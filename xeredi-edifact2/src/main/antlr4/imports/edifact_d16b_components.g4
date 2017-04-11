grammar edifact_d16b_components;

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
	f8179?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f8178?
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
	f7041?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f7040?
	)?
;

/**
 * C004 EVENT CATEGORY
 */
//c_C004
//:
//    f9637?
//    (
//        COLON d_1131?
//    )?
//    (
//        COLON d_3055?
//    )?
//    (
//        COLON f9636?
//    )?
//;

c040
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

c056
:
	d_3413?
	(
		COLON d_3412?
	)?
;

c058
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

c059
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

c076
:
	d_3148 COLON d_3155
;

c080
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

c082
:
	d_3039
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

c100
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

c106
:
	d_1004?
	(
		COLON d_1056?
	)?
	(
		COLON d_1060?
	)?
;

c107
:
	d_4441
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

c108
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

c174
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

c186
:
	d_6063 COLON d_6060
	(
		COLON d_6411?
	)?
;

c200
:
	f8023?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f8022?
	)?
	(
		COLON d_4237?
	)?
	(
		COLON f7140?
	)?
;

c203
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

c205
:
	f8351
	(
		COLON f8078?
	)?
	(
		COLON f8092?
	)?
;

c208
:
	f7402
	(
		COLON f7402?
	)?
;

c210
:
	f7102
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
	(
		COLON f7102?
	)?
;

c211
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

c212
:
	f7140?
	(
		COLON f7143?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

c213
:
	f7224?
	(
		COLON f7065?
	)?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f7064?
	)?
	(
		COLON f7233?
	)?
;

c215
:
	f9303?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f9302?
	)?
;

c218
:
	f7419?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f7418?
	)?
;

c219
:
	f8335?
	(
		COLON f8334?
	)?
;

c220
:
	f8067?
	(
		COLON f8066?
	)?
;

c222
:
	f8213?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f8212?
	)?
	(
		COLON f8453?
	)?
;

c223
:
	f7106?
	(
		COLON d_6411?
	)?
;

c224
:
	f8155?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f8154?
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
	f9415?
	(
		COLON f9411?
	)?
	(
		COLON f9417?
	)?
	(
		COLON f9353?
	)?
;

c233
:
	f7273
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f7273?
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
	f7124?
	(
		COLON f7088?
	)?
;

c235
:
	f8158?
	(
		COLON f8186?
	)?
;

c236
:
	f8246?
	(
		COLON f8246?
	)?
	(
		COLON f8246?
	)?
	(
		COLON f8246?
	)?
;

c237
:
	f8260?
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
	f8461?
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
	f8457 COLON f8459
	(
		COLON f7130?
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
	f8025?
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
	(
		COLON f8024?
	)?
;

c528
:
	f7357?
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
	f7085
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
	f7511
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

c901
:
	f9321
	(
		COLON d_1131?
	)?
	(
		COLON d_3055?
	)?
;

s009
:
	f0065 COLON f0052 COLON f0054 COLON f0051
	(
		COLON f0057?
	)?
	(
		COLON f0110?
	)?
	(
		COLON f0113?
	)?
;

s010
:
	f0070
	(
		COLON f0073?
	)?
;

s016
:
	f0115
	(
		COLON f0116?
	)?
	(
		COLON f0118?
	)?
	(
		COLON f0051?
	)?
;

s017
:
	f0121
	(
		COLON f0122?
	)?
	(
		COLON f0124?
	)?
	(
		COLON f0051?
	)?
;

s018
:
	f0127
	(
		COLON f0128?
	)?
	(
		COLON f0130?
	)?
	(
		COLON f0051?
	)?
;
