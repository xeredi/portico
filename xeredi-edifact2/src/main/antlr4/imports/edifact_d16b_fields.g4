grammar edifact_d16b_fields;

import edifact_common;

/*
 * [B] = used in batch messages only
 * [I] = used in interactive messages only
 * [C] = common usage in both batch and interactive messages
 */

/** 1000  Document name. */
d_1000
:
	alphanumeric [35]
;

/** 1001  Document name code. */
d_1001
:
	alphanumeric [3]
;

/** 1003  Message type code. */
d_1003
:
	alphanumeric [6]
;

/** 1004  Document identifier. */
d_1004
:
	alphanumeric [70]
;

/** 1049  Message section code. */
d_1049
:
	alphanumeric [3]
;

/** 1050  Sequence position identifier. */
d_1050
:
	alphanumeric [10]
;

/** 1052  Message item identifier. */
d_1052
:
	alphanumeric [35]
;

/** 1054  Message sub-item identifier. */
d_1054
:
	numeric [6]
;

/** 1056  Version identifier. */
d_1056
:
	alphanumeric [9]
;

/** 1058  Release identifier */
d_1058
:
	alphanumeric [9]
;

/** 1060  Revision identifier . */
d_1060
:
	alphanumeric [6]
;

/** 1073  Document line action code  . */
d_1073
:
	alphanumeric [3]
;

/** 1082  Line item identifier   . */
d_1082
:
	alphanumeric [6]
;

/** 1131  Code list identification code. */
d_1131
:
	alphanumeric [17]
;

/** 1145  Traveller reference identifier. */
d_1145
:
	alphanumeric [35]
;

/** 1146  Account name. */
d_1146
:
	alphanumeric [35]
;

/** 1147  Account identifier */
d_1147
:
	alphanumeric [35]
;

/** 1148  Account abbreviated name   . */
d_1148
:
	alphanumeric [17]
;

/** 1153  Reference code qualifier    . */
d_1153
:
	alphanumeric [3]
;

/** 1154  Reference identifier   . */
d_1154
:
	alphanumeric [70]
;

/** 1156  Document line identifier    . */
d_1156
:
	alphanumeric [6]
;

/** 1159  Sequence identifier source code. */
d_1159
:
	alphanumeric [3]
;

/** 1170  Accounting journal name. */
d_1170
:
	alphanumeric [35]
;

/** 1171  Accounting journal identifier  . */
d_1171
:
	alphanumeric [17]
;

/** 1218  Document originals required quantity. */
d_1218
:
	numeric [2]
;

/** 1220  Document copies required quantity   . */
d_1220
:
	numeric [2]
;

/** 1222  Configuration level number . */
d_1222
:
	numeric [2]
;

/** 1225  Message function code  . */
d_1225
:
	alphanumeric [3]
;

/** 1227  Calculation sequence code  . */
d_1227
:
	alphanumeric [3]
;

/** 1228  Action description */
d_1228
:
	alphanumeric [35]
;

/** 1229  Action code    */
d_1229
:
	alphanumeric [3]
;

/** 1230  Allowance or charge identifier . */
d_1230
:
	alphanumeric [35]
;

/** 1312  Consignment load sequence identifier. */
d_1312
:
	numeric [4]
;

/** 1366  Document source description. */
d_1366
:
	alphanumeric [70]
;

/** 1373  Document status code. */
d_1373
:
	alphanumeric [3]
;

/** 1476  Controlling agency identifier  . */
d_1476
:
	alphanumeric [2]
;

/** 1490  Consolidation item number  . */
d_1490
:
	numeric [5]
;

/** 1496  Goods item number  */
d_1496
:
	alphanumeric [6]
;

/** 1501  Computer environment details code qualifier. */
d_1501
:
	alphanumeric [3]
;

/** 1502  Data format description. */
d_1502
:
	alphanumeric [35]
;

/** 1503  Data format description code. */
d_1503
:
	alphanumeric [3]
;

/** 1505  Value list type code. */
d_1505
:
	alphanumeric [3]
;

/** 1507  Designated class code  . */
d_1507
:
	alphanumeric [3]
;

/** 1508  File name*/
d_1508
:
	alphanumeric [35]
;

/** 1510  Computer environment name  . */
d_1510
:
	alphanumeric [35]
;

/** 1511  Computer environment name code . */
d_1511
:
	alphanumeric [3]
;

/** 1514  Value list name    */
d_1514
:
	alphanumeric [70]
;

/** 1516  File format name   */
d_1516
:
	alphanumeric [17]
;

/** 1518  Value list identifier  . */
d_1518
:
	alphanumeric [35]
;

/** 1520  Data set identifier . */
d_1520
:
	alphanumeric [35]
;

/** 1523  Message implementation identification code . */
d_1523
:
	alphanumeric [6]
;

/** 2000  Date . */
d_2000
:
	alphanumeric [14]
;

/** 2002  Time . */
d_2002
:
	numeric [4]
;

/** 2005  Date or time or period function code qualifier. */
d_2005
:
	alphanumeric [3]
;

/** 2009  Terms time relation code   . */
d_2009
:
	alphanumeric [3]
;

/** 2013  Frequency code */
d_2013
:
	alphanumeric [3]
;

/** 2015  Despatch pattern code  . */
d_2015
:
	alphanumeric [3]
;

/** 2017  Despatch pattern timing code. */
d_2017
:
	alphanumeric [3]
;

/** 2018  Age  . */
d_2018
:
	numeric [3]
;

/** 2023  Period type code qualifier . */
d_2023
:
	alphanumeric [3]
;

/** 2029  Time zone identifier.	 */
d_2029
:
	alphanumeric [3]
;

/** 2031  Time variation quantity  .	 */
d_2031
:
	numeric [3]
;

/** 2116  Time zone difference quantity .	 */
d_2116
:
	numeric [4]
;

/** 2118  Period detail description  .	 */
d_2118
:
	alphanumeric [35]
;

/** 2119  Period detail description code. */
d_2119
:
	alphanumeric [3]
;

/** 2148  Date variation number    .	 */
d_2148
:
	numeric [3]
;

/** 2151  Period type code   	 */
d_2151
:
	alphanumeric [3]
;

/** 2152  Period count quantity  .	 */
d_2152
:
	numeric [3]
;

/** 2155  Charge period type code  .	 */
d_2155
:
	alphanumeric [3]
;

/** 2156  Check-in time  .	 */
d_2156
:
	alphanumeric [10]
;

/** 2160  Days of week set identifier   .	 */
d_2160
:
	alphanumeric [7]
;

/** 2162  Journey leg duration quantity .	 */
d_2162
:
	alphanumeric [6]
;

/** 2164  Millisecond time    .	 */
d_2164
:
	numeric [9]
;

/** 2379  Date or time or period format code   . */
d_2379
:
	alphanumeric [3]
;

/** 2380  Date or time or period text .	 */
d_2380
:
	alphanumeric [35]
;

/** 2475  Event time reference code  .	 */
d_2475
:
	alphanumeric [3]
;

/** 3005  Maintenance operation operator code  . */
d_3005
:
	alphanumeric [3]
;

/** 3009  Maintenance operation payer code. */
d_3009
:
	alphanumeric [3]
;

/** 3035  Party function code qualifier.	 */
d_3035
:
	alphanumeric [3]
;

/** 3036  Party name    	 */
d_3036
:
	alphanumeric [70]
;

/** 3039  Party identifier   	 */
d_3039
:
	alphanumeric [35]
;

/** 3042  Street and number or post office box identifier. */
d_3042
:
	alphanumeric [35]
;

/** 3045  Party name format code .	 */
d_3045
:
	alphanumeric [3]
;

/** 3055  Code list responsible agency code    . */
d_3055
:
	alphanumeric [3]
;

/** 3077  Test medium code  	 */
d_3077
:
	alphanumeric [3]
;

/** 3079  Organisation classification code. */
d_3079
:
	alphanumeric [3]
;

/** 3082  Organisational class name  .	 */
d_3082
:
	alphanumeric [70]
;

/** 3083  Organisational class name code. */
d_3083
:
	alphanumeric [17]
;

/** 3124  Name and address description.	 */
d_3124
:
	alphanumeric [35]
;

/** 3126  Carrier name 	 */
d_3126
:
	alphanumeric [35]
;

/** 3127  Carrier identifier	 */
d_3127
:
	alphanumeric [17]
;

/** 3131  Address type code  	 */
d_3131
:
	alphanumeric [3]
;

/** 3139  Contact function code  .	 */
d_3139
:
	alphanumeric [3]
;

/** 3148  Communication address identifier. */
d_3148
:
	alphanumeric [512]
;

/** 3153  Communication medium type code  . */
d_3153
:
	alphanumeric [3]
;

/** 3155  Communication means type code . */
d_3155
:
	alphanumeric [3]
;

/** 3164  City name	 */
d_3164
:
	alphanumeric [35]
;

/** 3192  Account holder name .	 */
d_3192
:
	alphanumeric [35]
;

/** 3194  Account holder identifier  .	 */
d_3194
:
	alphanumeric [35]
;

/** 3197  Agent identifier    .	 */
d_3197
:
	alphanumeric [9]
;

/** 3207  Country identifier 	 */
d_3207
:
	alphanumeric [3]
;

/** 3222  First related location name.	 */
d_3222
:
	alphanumeric [70]
;

/** 3223  First related location identifier    . */
d_3223
:
	alphanumeric [35]
;

/** 3224  Location name 	 */
d_3224
:
	alphanumeric [256]
;

/** 3225  Location identifier	 */
d_3225
:
	alphanumeric [35]
;

/** 3227  Location function code qualifier. */
d_3227
:
	alphanumeric [3]
;

/** 3228  Country subdivision name    .	 */
d_3228
:
	alphanumeric [70]
;

/** 3229  Country subdivision identifier  . */
d_3229
:
	alphanumeric [9]
;

/** 3232  Second related location name  . */
d_3232
:
	alphanumeric [70]
;

/** 3233  Second related location identifier   . */
d_3233
:
	alphanumeric [35]
;

/** 3236  Sample location description.	 */
d_3236
:
	alphanumeric [35]
;

/** 3237  Sample location description code. */
d_3237
:
	alphanumeric [3]
;

/** 3239  Country of origin identifier  . */
d_3239
:
	alphanumeric [3]
;

/** 3251  Postal identification code  .	 */
d_3251
:
	alphanumeric [17]
;

/** 3279  Geographic area code.	 */
d_3279
:
	alphanumeric [3]
;

/** 3285  Instruction receiving party identifier    . */
d_3285
:
	alphanumeric [35]
;

/** 3286  Address component description.	 */
d_3286
:
	alphanumeric [70]
;

/** 3289  Person characteristic code qualifier . */
d_3289
:
	alphanumeric [3]
;

/** 3292  Nationality name  	 */
d_3292
:
	alphanumeric [35]
;

/** 3293  Nationality name code  .	 */
d_3293
:
	alphanumeric [3]
;

/** 3295  Name original alphabet code.	 */
d_3295
:
	alphanumeric [3]
;

/** 3299  Address purpose code   .	 */
d_3299
:
	alphanumeric [3]
;

/** 3301  Enacting party identifier  .	 */
d_3301
:
	alphanumeric [35]
;

/** 3310  Inherited characteristic description . */
d_3310
:
	alphanumeric [70]
;

/** 3311  Inherited characteristic description code . */
d_3311
:
	alphanumeric [8]
;

/** 3397  Name status code   	 */
d_3397
:
	alphanumeric [3]
;

/** 3398  Name component description .	 */
d_3398
:
	alphanumeric [256]
;

/** 3401  Name component usage code  .	 */
d_3401
:
	alphanumeric [3]
;

/** 3403  Name type code    	 */
d_3403
:
	alphanumeric [3]
;

/** 3405  Name component type code qualifier   . */
d_3405
:
	alphanumeric [3]
;

/** 3412  Contact name 	 */
d_3412
:
	alphanumeric [256]
;

/** 3413  Contact identifier 	 */
d_3413
:
	alphanumeric [17]
;

/** 3432  Institution name  	 */
d_3432
:
	alphanumeric [70]
;

/** 3433  Institution name code  .	 */
d_3433
:
	alphanumeric [11]
;

/** 3434  Institution branch identifier . */
d_3434
:
	alphanumeric [17]
;

/** 3436  Institution branch location name. */
d_3436
:
	alphanumeric [70]
;

/** 3446  Party tax identifier.	 */
d_3446
:
	alphanumeric [20]
;

/** 3449  Bank identifier.	 */
d_3449
:
	alphanumeric [17]
;

/** 3452  Language name 	 */
d_3452
:
	alphanumeric [35]
;

/** 3453  Language name code 	 */
d_3453
:
	alphanumeric [3]
;

/** 3455  Language code qualifier.	 */
d_3455
:
	alphanumeric [3]
;

/** 3457  Originator type code.	 */
d_3457
:
	alphanumeric [3]
;

/** 3459  Frequent traveller identifier .	 */
d_3459
:
	alphanumeric [25]
;

/** 3460  Given name.	 */
d_3460
:
	alphanumeric [70]
;

/** 3463  Gate identifier.	 */
d_3463
:
	alphanumeric [6]
;

/** 3465  In-house identifier .	 */
d_3465
:
	alphanumeric [9]
;

/** 3475  Address status code	 */
d_3475
:
	alphanumeric [3]
;

/** 3477  Address format code	 */
d_3477
:
	alphanumeric [3]
;

/** 3478  Marital status description .	 */
d_3478
:
	alphanumeric [35]
;

/** 3479  Marital status description code . */
d_3479
:
	alphanumeric [3]
;

/** 3480  Person job title  	 */
d_3480
:
	alphanumeric [35]
;

/** 3482  Religion name	 */
d_3482
:
	alphanumeric [35]
;

/** 3483  Religion name code	 */
d_3483
:
	alphanumeric [3]
;

/** 3493  Nationality code qualifier .	 */
d_3493
:
	alphanumeric [3]
;

/** 3496  Sales channel identifier   .	 */
d_3496
:
	alphanumeric [17]
;

/** 3499  Gender code   	 */
d_3499
:
	alphanumeric [3]
;

/** 3500  Family name    .	 */
d_3500
:
	alphanumeric [70]
;

/** 3503  Access authorisation identifier.  */
d_3503
:
	alphanumeric [9]
;

/** 3504  Given name title description  .	 */
d_3504
:
	alphanumeric [9]
;

/** 3507  Benefit coverage constituents code. */
d_3507
:
	alphanumeric [3]
;

/** 4009  Option code    .	 */
d_4009
:
	alphanumeric [3]
;

/** 4017  Delivery plan commitment level code  . */
d_4017
:
	alphanumeric [3]
;

/** 4018  Related information description.  */
d_4018
:
	alphanumeric [35]
;

/** 4022  Business description.	 */
d_4022
:
	alphanumeric [70]
;

/** 4025  Business function code .	 */
d_4025
:
	alphanumeric [3]
;

/** 4027  Business function type code qualifier. */
d_4027
:
	alphanumeric [3]
;

/** 4035  Priority type code qualifier  . */
d_4035
:
	alphanumeric [3]
;

/** 4036  Priority description.	 */
d_4036
:
	alphanumeric [35]
;

/** 4037  Priority description code  .	 */
d_4037
:
	alphanumeric [3]
;

/** 4038  Additional safety information description . */
d_4038
:
	alphanumeric [35]
;

/** 4039  Additional safety information description code. */
d_4039
:
	alphanumeric [3]
;

/** 4043  Trade class code  	 */
d_4043
:
	alphanumeric [3]
;

/** 4044  Safety section name .	 */
d_4044
:
	alphanumeric [70]
;

/** 4046  Safety section number  .	 */
d_4046
:
	numeric [2]
;

/** 4048  Certainty description  .	 */
d_4048
:
	alphanumeric [35]
;

/** 4049  Certainty description code  .	 */
d_4049
:
	alphanumeric [3]
;

/** 4051  Characteristic relevance code . */
d_4051
:
	alphanumeric [3]
;

/** 4052  Delivery or transport terms description   . */
d_4052
:
	alphanumeric [70]
;

/** 4053  Delivery or transport terms description code  . */
d_4053
:
	alphanumeric [3]
;

/** 4055  Delivery or transport terms function code . */
d_4055
:
	alphanumeric [3]
;

/** 4056  Question description.	 */
d_4056
:
	alphanumeric [256]
;

/** 4057  Question description code  .	 */
d_4057
:
	alphanumeric [3]
;

/** 4059  Clause code qualifier  .	 */
d_4059
:
	alphanumeric [3]
;

/** 4065  Contract and carriage condition code . */
d_4065
:
	alphanumeric [3]
;

/** 4068  Clause name  	 */
d_4068
:
	alphanumeric [70]
;

/** 4069  Clause name code  	 */
d_4069
:
	alphanumeric [17]
;

/** 4071  Proviso code qualifier .	 */
d_4071
:
	alphanumeric [3]
;

/** 4072  Proviso type description   .	 */
d_4072
:
	alphanumeric [35]
;

/** 4073  Proviso type description code . */
d_4073
:
	alphanumeric [3]
;

/** 4074  Proviso calculation description . */
d_4074
:
	alphanumeric [35]
;

/** 4075  Proviso calculation description code . */
d_4075
:
	alphanumeric [3]
;

/** 4078  Handling instruction description. */
d_4078
:
	alphanumeric [512]
;

/** 4079  Handling instruction description code. */
d_4079
:
	alphanumeric [3]
;

/** 4148  Information category description. */
d_4148
:
	alphanumeric [70]
;

/** 4149  Information category description code. */
d_4149
:
	alphanumeric [3]
;

/** 4150  Information detail description. */
d_4150
:
	alphanumeric [256]
;

/** 4151  Information detail description code  . */
d_4151
:
	alphanumeric [17]
;

/** 4153  Information details code qualifier. */
d_4153
:
	alphanumeric [3]
;

/** 4183  Special condition code .	 */
d_4183
:
	alphanumeric [3]
;

/** 4184  Special requirement description.  */
d_4184
:
	alphanumeric [17]
;

/** 4187  Special requirement type code .	 */
d_4187
:
	alphanumeric [4]
;

/** 4215  Transport charges payment method code. */
d_4215
:
	alphanumeric [3]
;

/** 4219  Transport service priority code . */
d_4219
:
	alphanumeric [3]
;

/** 4221  Discrepancy nature identification code    . */
d_4221
:
	alphanumeric [3]
;

/** 4233  Marking instructions code  .	 */
d_4233
:
	alphanumeric [3]
;

/** 4237  Payment arrangement code   .	 */
d_4237
:
	alphanumeric [3]
;

/** 4276  Payment terms description  .	 */
d_4276
:
	alphanumeric [35]
;

/** 4277  Payment terms description identifier . */
d_4277
:
	alphanumeric [17]
;

/** 4279  Payment terms type code qualifier    . */
d_4279
:
	alphanumeric [3]
;

/** 4294  Change reason description  .	 */
d_4294
:
	alphanumeric [35]
;

/** 4295  Change reason description code. */
d_4295
:
	alphanumeric [3]
;

/** 4343  Response type code 	 */
d_4343
:
	alphanumeric [3]
;

/** 4344  Response description.	 */
d_4344
:
	alphanumeric [256]
;

/** 4345  Response description code  .	 */
d_4345
:
	alphanumeric [3]
;

/** 4347  Product identifier code qualifier    . */
d_4347
:
	alphanumeric [3]
;

/** 4383  Bank operation code .	 */
d_4383
:
	alphanumeric [3]
;

/** 4400  Instruction description.	 */
d_4400
:
	alphanumeric [35]
;

/** 4401  Instruction description code.	 */
d_4401
:
	alphanumeric [3]
;

/** 4403  Instruction type code qualifier . */
d_4403
:
	alphanumeric [3]
;

/** 4404  Status description	 */
d_4404
:
	alphanumeric [35]
;

/** 4405  Status description code.	 */
d_4405
:
	alphanumeric [3]
;

/** 4407  Sample process step code   .	 */
d_4407
:
	alphanumeric [3]
;

/** 4415  Test method identifier .	 */
d_4415
:
	alphanumeric [17]
;

/** 4416  Test description  	 */
d_4416
:
	alphanumeric [70]
;

/** 4419  Test administration method code . */
d_4419
:
	alphanumeric [3]
;

/** 4424  Test reason name  	 */
d_4424
:
	alphanumeric [35]
;

/** 4425  Test reason name code  .	 */
d_4425
:
	alphanumeric [17]
;

/** 4431  Payment guarantee means code  . */
d_4431
:
	alphanumeric [3]
;

/** 4435  Payment channel code.	 */
d_4435
:
	alphanumeric [3]
;

/** 4437  Account type code qualifier.	 */
d_4437
:
	alphanumeric [3]
;

/** 4439  Payment conditions code.	 */
d_4439
:
	alphanumeric [3]
;

/** 4440  Free text	 */
d_4440
:
	alphanumeric [512]
;

/** 4441  Free text description code .	 */
d_4441
:
	alphanumeric [17]
;

/** 4447  Free text format code  .	 */
d_4447
:
	alphanumeric [3]
;

/** 4451  Text subject code qualifier .	 */
d_4451
:
	alphanumeric [3]
;

/** 4453  Free text function code.	 */
d_4453
:
	alphanumeric [3]
;

/** 4455  Back order arrangement type code. */
d_4455
:
	alphanumeric [3]
;

/** 4457  Substitution condition code.	 */
d_4457
:
	alphanumeric [3]
;

/** 4461  Payment means code	 */
d_4461
:
	alphanumeric [3]
;

/** 4463  Intra-company payment indicator code . */
d_4463
:
	alphanumeric [3]
;

/** 4465  Adjustment reason description code   . */
d_4465
:
	alphanumeric [3]
;

/** 4467  Payment method code .	 */
d_4467
:
	alphanumeric [4]
;

/** 4469  Payment purpose code.	 */
d_4469
:
	alphanumeric [4]
;

/** 4471  Settlement means code  .	 */
d_4471
:
	alphanumeric [3]
;

/** 4472  Information type  	 */
d_4472
:
	alphanumeric [35]
;

/** 4473  Information type code  .	 */
d_4473
:
	alphanumeric [4]
;

/** 4474  Accounting entry type name .	 */
d_4474
:
	alphanumeric [35]
;

/** 4475  Accounting entry type name code . */
d_4475
:
	alphanumeric [17]
;

/** 4487  Financial transaction type code . */
d_4487
:
	alphanumeric [3]
;

/** 4493  Delivery instruction code  .	 */
d_4493
:
	alphanumeric [3]
;

/** 4494  Insurance cover description.	 */
d_4494
:
	alphanumeric [35]
;

/** 4495  Insurance cover description code. */
d_4495
:
	alphanumeric [17]
;

/** 4497  Insurance cover type code   .	 */
d_4497
:
	alphanumeric [3]
;

/** 4499  Inventory movement reason code. */
d_4499
:
	alphanumeric [3]
;

/** 4501  Inventory movement direction code    . */
d_4501
:
	alphanumeric [3]
;

/** 4503  Inventory balance method code . */
d_4503
:
	alphanumeric [3]
;

/** 4505  Credit cover request type code. */
d_4505
:
	alphanumeric [3]
;

/** 4507  Credit cover response type code . */
d_4507
:
	alphanumeric [3]
;

/** 4509  Credit cover response reason code    . */
d_4509
:
	alphanumeric [3]
;

/** 4510  Requested information description    . */
d_4510
:
	alphanumeric [35]
;

/** 4511  Requested information description code    . */
d_4511
:
	alphanumeric [3]
;

/** 4513  Maintenance operation code  .	 */
d_4513
:
	alphanumeric [3]
;

/** 4517  Seal condition code .	 */
d_4517
:
	alphanumeric [3]
;

/** 4519  Definition identifier  .	 */
d_4519
:
	alphanumeric [35]
;

/** 4521  Premium calculation component identifier  . */
d_4521
:
	alphanumeric [17]
;

/** 4522  Premium calculation component value category identifier. */
d_4522
:
	alphanumeric [35]
;

/** 4525  Seal type code    	 */
d_4525
:
	alphanumeric [3]
;

/** 5004  Monetary amount    	 */
d_5004
:
	numeric [35]
;

/** 5006  Monetary amount function description . */
d_5006
:
	alphanumeric [70]
;

/** 5007  Monetary amount function description code . */
d_5007
:
	alphanumeric [3]
;

/** 5013  Index code qualifier.	 */
d_5013
:
	alphanumeric [3]
;

/** 5025  Monetary amount type code qualifier  . */
d_5025
:
	alphanumeric [3]
;

/** 5027  Index type identifier  .	 */
d_5027
:
	alphanumeric [17]
;

/** 5030  Index text    	 */
d_5030
:
	alphanumeric [35]
;

/** 5039  Index representation code  .	 */
d_5039
:
	alphanumeric [3]
;

/** 5047  Contribution code qualifier.	 */
d_5047
:
	alphanumeric [3]
;

/** 5048  Contribution type description . */
d_5048
:
	alphanumeric [35]
;

/** 5049  Contribution type description code   . */
d_5049
:
	alphanumeric [3]
;

/** 5104  Monetary amount function detail description   . */
d_5104
:
	alphanumeric [70]
;

/** 5105  Monetary amount function detail description code. */
d_5105
:
	alphanumeric [17]
;

/** 5118  Price amount	 */
d_5118
:
	numeric [15]
;

/** 5125  Price code qualifier .	 */
d_5125
:
	alphanumeric [3]
;

/** 5152  Duty or tax or fee type name  . */
d_5152
:
	alphanumeric [35]
;

/** 5153  Duty or tax or fee type name code. */
d_5153
:
	alphanumeric [3]
;

/** 5160  Total monetary amount  .	 */
d_5160
:
	numeric [20]
;

/** 5189  Allowance or charge identification code   . */
d_5189
:
	alphanumeric [3]
;

/** 5213  Sub-line item price change operation code . */
d_5213
:
	alphanumeric [3]
;

/** 5237  Charge category code.	 */
d_5237
:
	alphanumeric [3]
;

/** 5242  Rate or tariff class description   . */
d_5242
:
	alphanumeric [35]
;

/** 5243  Rate or tariff class description code   . */
d_5243
:
	alphanumeric [9]
;

/** 5245  Percentage type code qualifier. */
d_5245
:
	alphanumeric [3]
;

/** 5249  Percentage basis identification code . */
d_5249
:
	alphanumeric [3]
;

/** 5261  Charge unit code.	 */
d_5261
:
	alphanumeric [3]
;

/** 5263  Rate type identifier   .	 */
d_5263
:
	alphanumeric [20]
;

/** 5267  Service type code. */
d_5267
:
	alphanumeric [3]
;

/** 5273  Duty or tax or fee rate basis code. */
d_5273
:
	alphanumeric [12]
;

/** 5275  Supplementary rate or tariff code. */
d_5275
:
	alphanumeric [6]
;

/** 5278  Duty or tax or fee rate. */
d_5278
:
	alphanumeric [17]
;

/** 5279  Duty or tax or fee rate code. */
d_5279
:
	alphanumeric [7]
;

/** 5283  Duty or tax or fee function code qualifier. */
d_5283
:
	alphanumeric [3]
;

/** 5284  Unit price basis quantity  .	 */
d_5284
:
	numeric [9]
;

/** 5286  Duty or tax or fee assessment basis quantity  . */
d_5286
:
	alphanumeric [15]
;

/** 5289  Duty or tax or fee account code    . */
d_5289
:
	alphanumeric [6]
;

/** 5305  Duty or tax or fee category code   . */
d_5305
:
	alphanumeric [3]
;

/** 5307  Tax or duty or fee payment due date code  . */
d_5307
:
	alphanumeric [3]
;

/** 5314  Remuneration type name .	 */
d_5314
:
	alphanumeric [35]
;

/** 5315  Remuneration type name code.	 */
d_5315
:
	alphanumeric [3]
;

/** 5375  Price type code. */
d_5375
:
	alphanumeric [3]
;

/** 5377  Price change type code .	 */
d_5377
:
	alphanumeric [3]
;

/** 5379  Product group type code    .	 */
d_5379
:
	alphanumeric [3]
;

/** 5387  Price specification code   .	 */
d_5387
:
	alphanumeric [3]
;

/** 5388  Product group name	 */
d_5388
:
	alphanumeric [35]
;

/** 5389  Product group name code.	 */
d_5389
:
	alphanumeric [25]
;

/** 5393  Price multiplier type code qualifier . */
d_5393
:
	alphanumeric [3]
;

/** 5394  Price multiplier rate .	 */
d_5394
:
	numeric [12]
;

/** 5402  Currency exchange rate .	 */
d_5402
:
	numeric [12]
;

/** 5419  Rate type code qualifier   .	 */
d_5419
:
	alphanumeric [3]
;

/** 5420  Unit price basis rate .	 */
d_5420
:
	numeric [15]
;

/** 5463  Allowance or charge code qualifier */
d_5463
:
	alphanumeric [3]
;

/** 5479  Relation code */
d_5479
:
	alphanumeric [3]
;

/** 5482  Percentage */
d_5482
:
	numeric [10]
;

/** 5495  Sub-line indicator code */
d_5495
:
	alphanumeric [3]
;

/** 5501  Rate plan code */
d_5501
:
	alphanumeric [3]
;

/** 6000  Latitude degree */
d_6000
:
	alphanumeric [10]
;

/** 6002  Longitude degree */
d_6002
:
	alphanumeric [11]
;

/** 6008  Height measure */
d_6008
:
	numeric [15]
;

/** 6029  Geographical position code qualifier */
d_6029
:
	alphanumeric [3]
;

/** 6060  Quantity */
d_6060
:
	alphanumeric [35]
;

/** 6063  Quantity type code qualifier */
d_6063
:
	alphanumeric [3]
;

/** 6064  Variance quantity */
d_6064
:
	numeric [15]
;

/** 6066  Control total quantity    */
d_6066
:
	numeric [18]
;

/** 6069  Control total type code qualifier. */
d_6069
:
	alphanumeric [3]
;

/** 6071  Frequency code qualifier. */
d_6071
:
	alphanumeric [3]
;

/** 6072  Frequency rate. */
d_6072
:
	numeric [9]
;

/** 6074  Confidence percent. */
d_6074
:
	numeric [6]
;

/** 6077  Result representation code. */
d_6077
:
	alphanumeric [3]
;

/** 6079  Result normalcy code. */
d_6079
:
	alphanumeric [3]
;

/** 6082  Dosage description. */
d_6082
:
	alphanumeric [70]
;

/** 6083  Dosage description identifier. */
d_6083
:
	alphanumeric [8]
;

/** 6085  Dosage administration code qualifier. */
d_6085
:
	alphanumeric [3]
;

/** 6087  Result value type code qualifier. */
d_6087
:
	alphanumeric [3]
;

/** 6096  Altitude. */
d_6096
:
	numeric [18]
;

/** 6113  Length type code. */
d_6113
:
	alphanumeric [3]
;

/** 6140  Width measure. */
d_6140
:
	numeric [15]
;

/** 6145  Dimension type code qualifier. */
d_6145
:
	alphanumeric [3]
;

/** 6152  Range maximum quantity. */
d_6152
:
	numeric [18]
;

/** 6154  Non-discrete measurement name. */
d_6154
:
	alphanumeric [70]
;

/** 6155  Non-discrete measurement name code. */
d_6155
:
	alphanumeric [17]
;

/** 6162  Range minimum quantity. */
d_6162
:
	numeric [18]
;

/** 6167  Range type code qualifier. */
d_6167
:
	alphanumeric [3]
;

/** 6168  Length measure. */
d_6168
:
	numeric [15]
;

/** 6173  Size type code qualifier. */
d_6173
:
	alphanumeric [3]
;

/** 6174  Size measure. */
d_6174
:
	numeric [15]
;

/** 6176  Occurrences maximum number. */
d_6176
:
	numeric [7]
;

/** 6178  Edit field length measure. */
d_6178
:
	numeric [3]
;

/** 6182  Diameter measure. */
d_6182
:
	numeric [15]
;

/** 6245  Temperature type code qualifier. */
d_6245
:
	alphanumeric [3]
;

/** 6246  Temperature degree. */
d_6246
:
	numeric [15]
;

/** 6311  Measurement purpose code qualifier. */
d_6311
:
	alphanumeric [3]
;

/** 6313  Measured attribute code. */
d_6313
:
	alphanumeric [3]
;

/** 6314  Measure. */
d_6314
:
	alphanumeric [18]
;

/** 6321  Measurement significance code. */
d_6321
:
	alphanumeric [3]
;

/** 6331  Statistic type code qualifier. */
d_6331
:
	alphanumeric [3]
;

/** 6341  Exchange rate currency market identifier. */
d_6341
:
	alphanumeric [3]
;

/** 6343  Currency type code qualifier. */
d_6343
:
	alphanumeric [3]
;

/** 6345  Currency identification code. */
d_6345
:
	alphanumeric [3]
;

/** 6347  Currency usage code qualifier. */
d_6347
:
	alphanumeric [3]
;

/** 6348  Currency rate. */
d_6348
:
	numeric [4]
;

/** 6350  Units quantity. */
d_6350
:
	numeric [15]
;

/** 6353  Unit type code qualifier. */
d_6353
:
	alphanumeric [3]
;

/** 6410  Measurement unit name. */
d_6410
:
	alphanumeric [35]
;

/** 6411  Measurement unit code. */
d_6411
:
	alphanumeric [8]
;

/** 6412  Clinical information description. */
d_6412
:
	alphanumeric [70]
;

/** 6413  Clinical information description identifier. */
d_6413
:
	alphanumeric [17]
;

/** 6415  Clinical information type code qualifier. */
d_6415
:
	alphanumeric [3]
;

/** 6426  Process stages quantity. */
d_6426
:
	numeric [2]
;

/** 6428  Process stages actual quantity. */
d_6428
:
	numeric [2]
;

/** 6432  Significant digits quantity. */
d_6432
:
	numeric [2]
;

/** 6434  Statistical concept identifier. */
d_6434
:
	alphanumeric [35]
;

/** 7001  Physical or logical state type code qualifier. */
d_7001
:
	alphanumeric [3]
;

/** 7006  Physical or logical state description. */
d_7006
:
	alphanumeric [70]
;

/** 7007  Physical or logical state description code. */
d_7007
:
	alphanumeric [3]
;

/** 7008  Item description. */
d_7008
:
	alphanumeric [256]
;

/** 7009  Item description code. */
d_7009
:
	alphanumeric [17]
;

/** 7011  Item availability code. */
d_7011
:
	alphanumeric [3]
;

/** 7036  Characteristic description. */
d_7036
:
	alphanumeric [35]
;

/** 7037  Characteristic description code. */
d_7037
:
	alphanumeric [17]
;

/** 7039  Sample selection method code. */
d_7039
:
	alphanumeric [3]
;

/** 7040  Power type description. */
d_7040
:
	alphanumeric [17]
;

/** 7041  Power type code. */
d_7041
:
	alphanumeric [3]
;

/** 7045  Sample state code. */
d_7045
:
	alphanumeric [3]
;

/** 7047  Sample direction code. */
d_7047
:
	alphanumeric [3]
;

/** 7059  Class type code. */
d_7059
:
	alphanumeric [3]
;

/** 7064  Type of packages. */
d_7064
:
	alphanumeric [35]
;

/** 7065  Package type description code. */
d_7065
:
	alphanumeric [17]
;

/** 7073  Packaging terms and conditions code. */
d_7073
:
	alphanumeric [3]
;

/** 7075  Packaging level code. */
d_7075
:
	alphanumeric [3]
;

/** 7077  Description format code. */
d_7077
:
	alphanumeric [3]
;

/** 7081  Item characteristic code. */
d_7081
:
	alphanumeric [3]
;

/** 7083  Configuration operation code. */
d_7083
:
	alphanumeric [3]
;

/** 7085  Cargo type classification code. */
d_7085
:
	alphanumeric [3]
;

/** 7088  Dangerous goods flashpoint description. */
d_7088
:
	alphanumeric [8]
;

/** 7102  Shipping marks description. */
d_7102
:
	alphanumeric [35]
;

/** 7106  Shipment flashpoint degree. */
d_7106
:
	numeric [3]
;

/** 7110  Characteristic value description. */
d_7110
:
	alphanumeric [35]
;

/** 7111  Characteristic value description code. */
d_7111
:
	alphanumeric [3]
;

/** 7124  United Nations Dangerous Goods (UNDG) identifier. */
d_7124
:
	numeric [4]
;

/** 7130  Customer shipment authorisation identifier. */
d_7130
:
	alphanumeric [17]
;

/** 7133  Product details type code qualifier. */
d_7133
:
	alphanumeric [3]
;

/** 7134  Product name. */
d_7134
:
	alphanumeric [35]
;

/** 7135  Product identifier. */
d_7135
:
	alphanumeric [35]
;

/** 7139  Product characteristic identification code. */
d_7139
:
	alphanumeric [3]
;

/** 7140  Item identifier. */
d_7140
:
	alphanumeric [35]
;

/** 7143  Item type identification code. */
d_7143
:
	alphanumeric [3]
;

/** 7160  Special service description. */
d_7160
:
	alphanumeric [35]
;

/** 7161  Special service description code. */
d_7161
:
	alphanumeric [3]
;

/** 7164  Hierarchical structure level identifier. */
d_7164
:
	alphanumeric [35]
;

/** 7166  Hierarchical structure parent identifier. */
d_7166
:
	alphanumeric [35]
;

/** 7168  Level number. */
d_7168
:
	numeric [3]
;

/** 7171  Hierarchical structure relationship code. */
d_7171
:
	alphanumeric [3]
;

/** 7173  Hierarchy object code qualifier. */
d_7173
:
	alphanumeric [3]
;

/** 7175  Rule part identifier. */
d_7175
:
	alphanumeric [7]
;

/** 7176  Risk object sub-type description. */
d_7176
:
	alphanumeric [70]
;

/** 7177  Risk object sub-type description identifier. */
d_7177
:
	alphanumeric [17]
;

/** 7179  Risk object type identifier. */
d_7179
:
	alphanumeric [17]
;

/** 7186  Process type description. */
d_7186
:
	alphanumeric [35]
;

/** 7187  Process type description code. */
d_7187
:
	alphanumeric [17]
;

/** 7188  Test method revision identifier. */
d_7188
:
	alphanumeric [30]
;

/** 7190  Process description. */
d_7190
:
	alphanumeric [70]
;

/** 7191  Process description code. */
d_7191
:
	alphanumeric [17]
;

/** 7224  Package quantity. */
d_7224
:
	numeric [8]
;

/** 7233  Packaging related description code. */
d_7233
:
	alphanumeric [3]
;

/** 7240  Item total quantity. */
d_7240
:
	numeric [15]
;

/** 7273  Service requirement code. */
d_7273
:
	alphanumeric [3]
;

/** 7293  Sector area identification code qualifier. */
d_7293
:
	alphanumeric [3]
;

/** 7294  Requirement or condition description. */
d_7294
:
	alphanumeric [35]
;

/** 7295  Requirement or condition description identifier. */
d_7295
:
	alphanumeric [17]
;

/** 7297  Set type code qualifier. */
d_7297
:
	alphanumeric [3]
;

/** 7299  Requirement designator code. */
d_7299
:
	alphanumeric [3]
;

/** 7357  Commodity identification code. */
d_7357
:
	alphanumeric [18]
;

/** 7361  Customs goods identifier. */
d_7361
:
	alphanumeric [18]
;

/** 7364  Processing indicator description. */
d_7364
:
	alphanumeric [35]
;

/** 7365  Processing indicator description code. */
d_7365
:
	alphanumeric [3]
;

/** 7383  Surface or layer code. */
d_7383
:
	alphanumeric [3]
;

/** 7402  Object identifier. */
d_7402
:
	alphanumeric [35]
;

/** 7405  Object identification code qualifier. */
d_7405
:
	alphanumeric [3]
;

/** 7418  Hazardous material category name. */
d_7418
:
	alphanumeric [35]
;

/** 7419  Hazardous material category name code. */
d_7419
:
	alphanumeric [7]
;

/** 7429  Indexing structure code qualifier. */
d_7429
:
	alphanumeric [3]
;

/** 7431  Agreement type code qualifier. */
d_7431
:
	alphanumeric [3]
;

/** 7433  Agreement type description code. */
d_7433
:
	alphanumeric [3]
;

/** 7434  Agreement type description. */
d_7434
:
	alphanumeric [70]
;

/** 7436  Level one identifier. */
d_7436
:
	alphanumeric [17]
;

/** 7438  Level two identifier. */
d_7438
:
	alphanumeric [17]
;

/** 7440  Level three identifier. */
d_7440
:
	alphanumeric [17]
;

/** 7442  Level four identifier. */
d_7442
:
	alphanumeric [17]
;

/** 7444  Level five identifier. */
d_7444
:
	alphanumeric [17]
;

/** 7446  Level six identifier. */
d_7446
:
	alphanumeric [17]
;

/** 7449  Membership type code qualifier. */
d_7449
:
	alphanumeric [3]
;

/** 7450  Membership category description. */
d_7450
:
	alphanumeric [35]
;

/** 7451  Membership category description code. */
d_7451
:
	alphanumeric [4]
;

/** 7452  Membership status description. */
d_7452
:
	alphanumeric [35]
;

/** 7453  Membership status description code. */
d_7453
:
	alphanumeric [3]
;

/** 7455  Membership level code qualifier. */
d_7455
:
	alphanumeric [3]
;

/** 7456  Membership level description. */
d_7456
:
	alphanumeric [35]
;

/** 7457  Membership level description code. */
d_7457
:
	alphanumeric [9]
;

/** 7458  Attendee category description. */
d_7458
:
	alphanumeric [35]
;

/** 7459  Attendee category description code. */
d_7459
:
	alphanumeric [3]
;

/** 7491  Inventory type code. */
d_7491
:
	alphanumeric [3]
;

/** 7493  Damage details code qualifier. */
d_7493
:
	alphanumeric [3]
;

/** 7495  Object type code qualifier. */
d_7495
:
	alphanumeric [3]
;

/** 7497  Structure component function code qualifier. */
d_7497
:
	alphanumeric [3]
;

/** 7500  Damage type description. */
d_7500
:
	alphanumeric [35]
;

/** 7501  Damage type description code. */
d_7501
:
	alphanumeric [3]
;

/** 7502  Damage area description. */
d_7502
:
	alphanumeric [35]
;

/** 7503  Damage area description code. */
d_7503
:
	alphanumeric [3]
;

/** 7504  Unit or component type description. */
d_7504
:
	alphanumeric [35]
;

/** 7505  Unit or component type description code. */
d_7505
:
	alphanumeric [3]
;

/** 7506  Component material description. */
d_7506
:
	alphanumeric [35]
;

/** 7507  Component material description code. */
d_7507
:
	alphanumeric [3]
;

/** 7508  Damage severity description. */
d_7508
:
	alphanumeric [35]
;

/** 7509  Damage severity description code. */
d_7509
:
	alphanumeric [3]
;

/** 7511  Marking type code. */
d_7511
:
	alphanumeric [3]
;

/** 7512  Structure component identifier. */
d_7512
:
	alphanumeric [35]
;

/** 7515  Structure type code. */
d_7515
:
	alphanumeric [3]
;

/** 7517  Benefit and coverage code. */
d_7517
:
	alphanumeric [3]
;

/** 8015  Traffic restriction code. */
d_8015
:
	alphanumeric [3]
;

/** 8017  Traffic restriction application code. */
d_8017
:
	alphanumeric [3]
;

/** 8022  Freight and other charges description. */
d_8022
:
	alphanumeric [26]
;

/** 8023  Freight and other charges description identifier. */
d_8023
:
	alphanumeric [17]
;

/** 8024  Conveyance call purpose description. */
d_8024
:
	alphanumeric [35]
;

/** 8025  Conveyance call purpose description code. */
d_8025
:
	alphanumeric [3]
;

/** 8028  Means of transport journey identifier. */
d_8028
:
	alphanumeric [17]
;

/** 8035  Traffic restriction type code qualifier. */
d_8035
:
	alphanumeric [3]
;

/** 8051  Transport stage code qualifier. */
d_8051
:
	alphanumeric [3]
;

/** 8053  Equipment type code qualifier. */
d_8053
:
	alphanumeric [3]
;

/** 8066  Transport mode name. */
d_8066
:
	alphanumeric [17]
;

/** 8067  Transport mode name code. */
d_8067
:
	alphanumeric [3]
;

/** 8077  Equipment supplier code. */
d_8077
:
	alphanumeric [3]
;

/** 8078  Additional hazard classification identifier. */
d_8078
:
	alphanumeric [7]
;

/** 8092  Hazard code version identifier. */
d_8092
:
	alphanumeric [10]
;

/** 8101  Transit direction indicator code. */
d_8101
:
	alphanumeric [3]
;

/** 8126  Transport emergency card identifier. */
d_8126
:
	alphanumeric [10]
;

/** 8154  Equipment size and type description. */
d_8154
:
	alphanumeric [35]
;

/** 8155  Equipment size and type description code. */
d_8155
:
	alphanumeric [10]
;

/** 8158  Orange hazard placard upper part identifier. */
d_8158
:
	alphanumeric [4]
;

/** 8169  Full or empty indicator code. */
d_8169
:
	alphanumeric [3]
;

/** 8178  Transport means description. */
d_8178
:
	alphanumeric [17]
;

/** 8179  Transport means description code. */
d_8179
:
	alphanumeric [8]
;

/** 8186  Orange hazard placard lower part identifier. */
d_8186
:
	alphanumeric [4]
;

/** 8211  Hazardous cargo transport authorisation code. */
d_8211
:
	alphanumeric [3]
;

/** 8212  Transport means identification name. */
d_8212
:
	alphanumeric [70]
;

/** 8213  Transport means identification name identifier. */
d_8213
:
	alphanumeric [35]
;

/** 8215  Transport means change indicator code. */
d_8215
:
	alphanumeric [1]
;

/** 8216  Journey stops quantity. */
d_8216
:
	numeric [3]
;

/** 8219  Traveller accompanied by infant indicator code. */
d_8219
:
	alphanumeric [1]
;

/** 8246  Dangerous goods marking identifier. */
d_8246
:
	alphanumeric [4]
;

/** 8249  Equipment status code. */
d_8249
:
	alphanumeric [3]
;

/** 8255  Packing instruction type code. */
d_8255
:
	alphanumeric [3]
;

/** 8260  Equipment identifier. */
d_8260
:
	alphanumeric [17]
;

/** 8273  Dangerous goods regulations code. */
d_8273
:
	alphanumeric [3]
;

/** 8275  Container or package contents indicator code. */
d_8275
:
	alphanumeric [3]
;

/** 8281  Transport means ownership indicator code. */
d_8281
:
	alphanumeric [3]
;

/** 8323  Transport movement code. */
d_8323
:
	alphanumeric [3]
;

/** 8332  Equipment plan description. */
d_8332
:
	alphanumeric [35]
;

/** 8334  Movement type description. */
d_8334
:
	alphanumeric [35]
;

/** 8335  Movement type description code. */
d_8335
:
	alphanumeric [3]
;

/** 8339  Packaging danger level code. */
d_8339
:
	alphanumeric [3]
;

/** 8341  Haulage arrangements code. */
d_8341
:
	alphanumeric [3]
;

/** 8351  Hazard identification code. */
d_8351
:
	alphanumeric [7]
;

/** 8364  Emergency procedure for ships identifier. */
d_8364
:
	alphanumeric [8]
;

/** 8393  Returnable package load contents code. */
d_8393
:
	alphanumeric [3]
;

/** 8395  Returnable package freight payment responsibility code. */
d_8395
:
	alphanumeric [3]
;

/** 8410  Hazard medical first aid guide identifier. */
d_8410
:
	alphanumeric [4]
;

/** 8453  Transport means nationality code. */
d_8453
:
	alphanumeric [3]
;

/** 8457  Excess transportation reason code. */
d_8457
:
	alphanumeric [3]
;

/** 8459  Excess transportation responsibility code. */
d_8459
:
	alphanumeric [3]
;

/** 8461  Tunnel Restriction Code. */
d_8461
:
	alphanumeric [6]
;

/** 9003  Employment details code qualifier. */
d_9003
:
	alphanumeric [3]
;

/** 9004  Employment category description. */
d_9004
:
	alphanumeric [35]
;

/** 9005  Employment category description code. */
d_9005
:
	alphanumeric [3]
;

/** 9006  Qualification classification description. */
d_9006
:
	alphanumeric [35]
;

/** 9007  Qualification classification description code. */
d_9007
:
	alphanumeric [3]
;

/** 9008  Occupation description. */
d_9008
:
	alphanumeric [35]
;

/** 9009  Occupation description code. */
d_9009
:
	alphanumeric [3]
;

/** 9012  Status reason description. */
d_9012
:
	alphanumeric [256]
;

/** 9013  Status reason description code. */
d_9013
:
	alphanumeric [3]
;

/** 9015  Status category code. */
d_9015
:
	alphanumeric [3]
;

/** 9017  Attribute function code qualifier. */
d_9017
:
	alphanumeric [3]
;

/** 9018  Attribute description. */
d_9018
:
	alphanumeric [256]
;

/** 9019  Attribute description code. */
d_9019
:
	alphanumeric [17]
;

/** 9020  Attribute type description. */
d_9020
:
	alphanumeric [70]
;

/** 9021  Attribute type description code. */
d_9021
:
	alphanumeric [17]
;

/** 9023  Definition function code. */
d_9023
:
	alphanumeric [3]
;

/** 9025  Definition extent code. */
d_9025
:
	alphanumeric [3]
;

/** 9026  Edit mask format identifier. */
d_9026
:
	alphanumeric [35]
;

/** 9029  Value definition code qualifier. */
d_9029
:
	alphanumeric [3]
;

/** 9031  Edit mask representation code. */
d_9031
:
	alphanumeric [3]
;

/** 9035  Qualification application area code. */
d_9035
:
	alphanumeric [3]
;

/** 9037  Qualification type code qualifier. */
d_9037
:
	alphanumeric [3]
;

/** 9038  Facility type description. */
d_9038
:
	alphanumeric [70]
;

/** 9039  Facility type description code. */
d_9039
:
	alphanumeric [3]
;

/** 9040  Reservation identifier. */
d_9040
:
	alphanumeric [20]
;

/** 9043  Reservation identifier code qualifier. */
d_9043
:
	alphanumeric [3]
;

/** 9045  Basis code qualifier. */
d_9045
:
	alphanumeric [3]
;

/** 9046  Basis type description. */
d_9046
:
	alphanumeric [35]
;

/** 9047  Basis type description code. */
d_9047
:
	alphanumeric [3]
;

/** 9048  Applicability type description. */
d_9048
:
	alphanumeric [35]
;

/** 9049  Applicability type description code. */
d_9049
:
	alphanumeric [3]
;

/** 9051  Applicability code qualifier. */
d_9051
:
	alphanumeric [3]
;

/** 9141  Relationship type code qualifier. */
d_9141
:
	alphanumeric [3]
;

/** 9142  Relationship description. */
d_9142
:
	alphanumeric [35]
;

/** 9143  Relationship description code. */
d_9143
:
	alphanumeric [3]
;

/** 9146  Composite data element tag identifier. */
d_9146
:
	alphanumeric [4]
;

/** 9148  Directory status identifier. */
d_9148
:
	alphanumeric [3]
;

/** 9150  Simple data element tag identifier. */
d_9150
:
	alphanumeric [4]
;

/** 9153  Simple data element character representation code. */
d_9153
:
	alphanumeric [3]
;

/** 9156  Simple data element maximum length measure. */
d_9156
:
	numeric [3]
;

/** 9158  Simple data element minimum length measure. */
d_9158
:
	numeric [3]
;

/** 9161  Code set indicator code. */
d_9161
:
	alphanumeric [3]
;

/** 9162  Data element tag identifier. */
d_9162
:
	alphanumeric [4]
;

/** 9164  Group identifier. */
d_9164
:
	alphanumeric [4]
;

/** 9166  Segment tag identifier. */
d_9166
:
	alphanumeric [3]
;

/** 9169  Data representation type code. */
d_9169
:
	alphanumeric [3]
;

/** 9170  Event type description. */
d_9170
:
	alphanumeric [70]
;

/** 9171  Event type description code. */
d_9171
:
	alphanumeric [3]
;

/** 9172  Event. */
d_9172
:
	alphanumeric [256]
;

/** 9173  Event description code. */
d_9173
:
	alphanumeric [35]
;

/** 9175  Data element usage type code. */
d_9175
:
	alphanumeric [3]
;

/** 9213  Duty regime type code. */
d_9213
:
	alphanumeric [3]
;

/** 9280  Validation result text. */
d_9280
:
	alphanumeric [35]
;

/** 9282  Validation key identifier. */
d_9282
:
	alphanumeric [35]
;

/** 9285  Validation criteria code. */
d_9285
:
	alphanumeric [3]
;

/** 9302  Sealing party name. */
d_9302
:
	alphanumeric [35]
;

/** 9303  Sealing party name code. */
d_9303
:
	alphanumeric [3]
;

/** 9308  Transport unit seal identifier. */
d_9308
:
	alphanumeric [35]
;

/** 9321  Application error code. */
d_9321
:
	alphanumeric [8]
;

/** 9353  Government procedure code. */
d_9353
:
	alphanumeric [3]
;

/** 9411  Government involvement code. */
d_9411
:
	alphanumeric [3]
;

/** 9415  Government agency identification code. */
d_9415
:
	alphanumeric [3]
;

/** 9417  Government action code. */
d_9417
:
	alphanumeric [3]
;

/** 9419  Service layer code. */
d_9419
:
	alphanumeric [3]
;

/** 9421  Process stage code qualifier. */
d_9421
:
	alphanumeric [3]
;

/** 9422  Value text. */
d_9422
:
	alphanumeric [512]
;

/** 9424  Array cell data description. */
d_9424
:
	alphanumeric [512]
;

/** 9426  Code value text. */
d_9426
:
	alphanumeric [35]
;

/** 9428  Array cell structure identifier. */
d_9428
:
	alphanumeric [35]
;

/** 9430  Footnote set identifier. */
d_9430
:
	alphanumeric [35]
;

/** 9432  Footnote identifier. */
d_9432
:
	alphanumeric [35]
;

/** 9434  Code name. */
d_9434
:
	alphanumeric [70]
;

/** 9436  Clinical intervention description. */
d_9436
:
	alphanumeric [70]
;

/** 9437  Clinical intervention description code. */
d_9437
:
	alphanumeric [17]
;

/** 9441  Clinical intervention type code qualifier. */
d_9441
:
	alphanumeric [3]
;

/** 9443  Attendance type code qualifier. */
d_9443
:
	alphanumeric [3]
;

/** 9444  Admission type description. */
d_9444
:
	alphanumeric [35]
;

/** 9445  Admission type description code. */
d_9445
:
	alphanumeric [3]
;

/** 9446  Discharge type description. */
d_9446
:
	alphanumeric [35]
;

/** 9447  Discharge type description code. */
d_9447
:
	alphanumeric [3]
;

/** 9448  File generation command name. */
d_9448
:
	alphanumeric [35]
;

/** 9450  File compression technique name. */
d_9450
:
	alphanumeric [35]
;

/** 9453  Code value source code. */
d_9453
:
	alphanumeric [3]
;

/** 9501  Formula type code qualifier. */
d_9501
:
	alphanumeric [3]
;

/** 9502  Formula name. */
d_9502
:
	alphanumeric [35]
;

/** 9505  Formula complexity code. */
d_9505
:
	alphanumeric [3]
;

/** 9507  Formula sequence code qualifier. */
d_9507
:
	alphanumeric [3]
;

/** 9509  Formula sequence operand code. */
d_9509
:
	alphanumeric [17]
;

/** 9510  Formula sequence name. */
d_9510
:
	alphanumeric [35]
;

/** 9601  Information category code. */
d_9601
:
	alphanumeric [3]
;

/** 9605  Data code qualifier. */
d_9605
:
	alphanumeric [3]
;

/** 9607  Yes or no indicator code. */
d_9607
:
	alphanumeric [3]
;

/** 9619  Adjustment category code. */
d_9619
:
	alphanumeric [3]
;

/** 9620  Policy limitation identifier. */
d_9620
:
	alphanumeric [10]
;

/** 9623  Diagnosis type code. */
d_9623
:
	alphanumeric [3]
;

/** 9625  Related cause code. */
d_9625
:
	alphanumeric [3]
;

/** 9627  Admission source code. */
d_9627
:
	alphanumeric [3]
;

/** 9629  Procedure modification code. */
d_9629
:
	alphanumeric [3]
;

/** 9631  Invoice type code. */
d_9631
:
	alphanumeric [3]
;

/** 9635  Event details code qualifier. */
d_9635
:
	alphanumeric [3]
;

/** 9636  Event category description. */
d_9636
:
	alphanumeric [70]
;

/** 9637  Event category description code. */
d_9637
:
	alphanumeric [3]
;

/** 9639  Diagnosis category code. */
d_9639
:
	alphanumeric [3]
;

/** 9641  Service basis code qualifier. */
d_9641
:
	alphanumeric [3]
;

/** 9643  Supporting evidence type code qualifier. */
d_9643
:
	alphanumeric [3]
;

/** 9645  Payer responsibility level code. */
d_9645
:
	alphanumeric [3]
;

/** 9647  Cavity zone code. */
d_9647
:
	alphanumeric [3]
;

/** 9649  Processing information code qualifier. */
d_9649
:
	alphanumeric [3]
;

/*
*/
d_0051
:
	alphanumeric [3]
;

d_0052
:
	alphanumeric [3]
;

d_0054
:
	alphanumeric [3]
;

d_0057
:
	alphanumeric [6]
;

d_0062
:
	alphanumeric [14]
;

d_0065 [String msgType]
:
	alphanumeric [6]
	{$msgType.equals($alphanumeric.text.toString())}?

;

d_0068
:
	alphanumeric [35]
;

d_0070
:
	numeric [2]
;

d_0073
:
	alphanumeric [1]
;

d_0074
:
	numeric [10]
;

d_0110
:
	alphanumeric [6]
;

d_0113
:
	alphanumeric [6]
;

d_0115
:
	alphanumeric [14]
;

d_0116
:
	alphanumeric [3]
;

d_0118
:
	alphanumeric [3]
;

d_0121
:
	alphanumeric [14]
;

d_0122
:
	alphanumeric [3]
;

d_0124
:
	alphanumeric [3]
;

d_0127
:
	alphanumeric [14]
;

d_0128
:
	alphanumeric [3]
;

d_0130
:
	alphanumeric [3]
;
