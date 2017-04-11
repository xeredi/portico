grammar edifact_d16b_fields;

import edifact_common;

/*
 * [B] = used in batch messages only
 * [I] = used in interactive messages only
 * [C] = common usage in both batch and interactive messages
 */

/** 1000  Document name [B]*/
d_1000
:
    alphanumeric35
;

/** 1001  Document name code [C] */
d_1001
:
    alphanumeric3
;

/** 1003  Message type code [B] */
d_1003
:
    alphanumeric6
;

/** 1004  Document identifier                                     [C] */
d_1004
:
    alphanumeric70
;

/** 1049  Message section code                                    [B] */
d_1049
:
    alphanumeric3
;

/** 1050  Sequence position identifier                            [C] */
d_1050
:
    alphanumeric10
;

/** 1052  Message item identifier                                 [B] */
d_1052
:
    alphanumeric35
;

/** 1054  Message sub-item identifier                             [B] */
d_1054
:
    integer6
;

/** 1056  Version identifier                                      [B] */
d_1056
:
    alphanumeric9
;

/** 1058  Release identifier                                      [B] */
d_1058
:
    alphanumeric9
;

/** 1060  Revision identifier                                     [B] */
d_1060
:
    alphanumeric6
;

/** 1073  Document line action code                               [B] */
d_1073
:
    alphanumeric3
;

/** 1082  Line item identifier                                    [C] */
d_1082
:
    alphanumeric6
;

/** 1131  Code list identification code                           [C] */
d_1131
:
    alphanumeric17
;

/** 1145  Traveller reference identifier                          [I] */
d_1145
:
    alphanumeric35
;

/** 1146  Account name                                            [B] */
d_1146
:
    alphanumeric35
;

/** 1147  Account identifier                                      [B] */
d_1147
:
    alphanumeric35
;

/** 1148  Account abbreviated name                                [B] */
d_1148
:
    alphanumeric17
;

/** 1153  Reference code qualifier                                [C] */
d_1153
:
    alphanumeric3
;

/** 1154  Reference identifier                                    [C] */
d_1154
:
    alphanumeric70
;

/** 1156  Document line identifier                                [C] */
d_1156
:
    alphanumeric6
;

/** 1159  Sequence identifier source code                         [B] */
d_1159
:
    alphanumeric3
;

/** 1170  Accounting journal name                                 [B] */
d_1170
:
    alphanumeric35
;

/** 1171  Accounting journal identifier                           [B] */
d_1171
:
    alphanumeric17
;

/** 1218  Document originals required quantity                    [B] */
d_1218
:
    integer2
;

/** 1220  Document copies required quantity                       [B] */
d_1220
:
    integer2
;

/** 1222  Configuration level number                              [B] */
d_1222
:
    integer2
;

/** 1225  Message function code                                   [C] */
d_1225
:
    alphanumeric3
;

/** 1227  Calculation sequence code                               [B] */
d_1227
:
    alphanumeric3
;

/** 1228  Action description                                      [B] */
d_1228
:
    alphanumeric35
;

/** 1229  Action code                                             [C] */
d_1229
:
    alphanumeric3
;

/** 1230  Allowance or charge identifier                          [B] */
d_1230
:
    alphanumeric35
;

/** 1312  Consignment load sequence identifier                    [B] */
d_1312
:
    integer4
;

/** 1366  Document source description                             [B] */
d_1366
:
    alphanumeric70
;

/** 1373  Document status code                                    [B] */
d_1373
:
    alphanumeric3
;

/** 1476  Controlling agency identifier                           [B] */
d_1476
:
    alphanumeric2
;

/** 1490  Consolidation item number                               [B] */
d_1490
:
    integer5
;

/** 1496  Goods item number                                       [B] */
d_1496
:
    alphanumeric6
;

/** 1501  Computer environment details code qualifier             [B] */
d_1501
:
    alphanumeric3
;

/** 1502  Data format description                                 [B] */
d_1502
:
    alphanumeric35
;

/** 1503  Data format description code                            [C] */
d_1503
:
    alphanumeric3
;

/** 1505  Value list type code                                    [B] */
d_1505
:
    alphanumeric3
;

/** 1507  Designated class code                                   [B] */
d_1507
:
    alphanumeric3
;

/** 1508  File name                                               [B] */
d_1508
:
    alphanumeric35
;

/** 1510  Computer environment name                               [B] */
d_1510
:
    alphanumeric35
;

/** 1511  Computer environment name code                          [C] */
d_1511
:
    alphanumeric3
;

/** 1514  Value list name                                         [B] */
d_1514
:
    alphanumeric70
;

/** 1516  File format name                                        [B] */
d_1516
:
    alphanumeric17
;

/** 1518  Value list identifier                                   [B] */
d_1518
:
    alphanumeric35
;

/** 1520  Data set identifier                                     [B] */
d_1520
:
    alphanumeric35
;

/** 1523  Message implementation identification code              [B] */
d_1523
:
    alphanumeric6
;

/** 2000  Date                                                    [I] */
d_2000
:
    alphanumeric14
;

/** 2002  Time                                                    [I] */
d_2002
:
    integer4
;

/** 2005  Date or time or period function code qualifier          [C] */
d_2005
:
    alphanumeric3
;

/** 2009  Terms time relation code                                [B] */
d_2009
:
    alphanumeric3
;

/** 2013  Frequency code                                          [C] */
d_2013
:
    alphanumeric3
;

/** 2015  Despatch pattern code                                   [C] */
d_2015
:
    alphanumeric3
;

/** 2017  Despatch pattern timing code                            [C] */
d_2017
:
    alphanumeric3
;

/** 2018  Age                                                     [I] */
d_2018
:
    integer3
;

/** 2023  Period type code qualifier                              [B] */
d_2023
:
    alphanumeric3
;

/** 2029  Time zone identifier                                    [I]	 */
d_2029
:
    alphanumeric3
;

/** 2031  Time variation quantity                                 [I]	 */
d_2031
:
    integer3
;

/** 2116  Time zone difference quantity                           [I]	 */
d_2116
:
    integer4
;

/** 2118  Period detail description                               [B]	 */
d_2118
:
    alphanumeric35
;

/** 2119  Period detail description code                          [B]	 */
d_2119
:
    alphanumeric3
;

/** 2148  Date variation number                                   [I]	 */
d_2148
:
    integer3
;

/** 2151  Period type code                                        [C]	 */
d_2151
:
    alphanumeric3
;

/** 2152  Period count quantity                                   [C]	 */
d_2152
:
    integer3
;

/** 2155  Charge period type code                                 [I]	 */
d_2155
:
    alphanumeric3
;

/** 2156  Check-in time                                           [I]	 */
d_2156
:
    alphanumeric10
;

/** 2160  Days of week set identifier                             [I]	 */
d_2160
:
    alphanumeric7
;

/** 2162  Journey leg duration quantity                           [I]	 */
d_2162
:
    alphanumeric6
;

/** 2164  Millisecond time                                        [I]	 */
d_2164
:
    integer9
;

/** 2379  Date or time or period format code                      [C]	 */
d_2379
:
    alphanumeric3
;

/** 2380  Date or time or period text                             [C]	 */
d_2380
:
    alphanumeric35
;

/** 2475  Event time reference code                               [B]	 */
d_2475
:
    alphanumeric3
;

/** 3005  Maintenance operation operator code                     [B]	 */
d_3005
:
    alphanumeric3
;

/** 3009  Maintenance operation payer code                        [B]	 */
d_3009
:
    alphanumeric3
;

/** 3035  Party function code qualifier                           [C]	 */
d_3035
:
    alphanumeric3
;

/** 3036  Party name                                              [C]	 */
d_3036
:
    alphanumeric70
;

/** 3039  Party identifier                                        [C]	 */
d_3039
:
    alphanumeric35
;

/** 3042  Street and number or post office box identifier         [C]	 */
d_3042
:
    alphanumeric35
;

/** 3045  Party name format code                                  [C]	 */
d_3045
:
    alphanumeric3
;

/** 3055  Code list responsible agency code                       [C]	 */
d_3055
:
    alphanumeric3
;

/** 3077  Test medium code                                        [B]	 */
d_3077
:
    alphanumeric3
;

/** 3079  Organisation classification code                        [B]	 */
d_3079
:
    alphanumeric3
;

/** 3082  Organisational class name                               [B]	 */
d_3082
:
    alphanumeric70
;

/** 3083  Organisational class name code                          [B]	 */
d_3083
:
    alphanumeric17
;

/** 3124  Name and address description                            [C]	 */
d_3124
:
    alphanumeric35
;

/** 3126  Carrier name                                            [B]	 */
d_3126
:
    alphanumeric35
;

/** 3127  Carrier identifier                                      [B]	 */
d_3127
:
    alphanumeric17
;

/** 3131  Address type code                                       [C]	 */
d_3131
:
    alphanumeric3
;

/** 3139  Contact function code                                   [B]	 */
d_3139
:
    alphanumeric3
;

/** 3148  Communication address identifier                        [C]	 */
d_3148
:
    alphanumeric512
;

/** 3153  Communication medium type code                          [C]	 */
d_3153
:
    alphanumeric3
;

/** 3155  Communication means type code                           [B]	 */
d_3155
:
    alphanumeric3
;

/** 3164  City name                                               [C]	 */
d_3164
:
    alphanumeric35
;

/** 3192  Account holder name                                     [B]	 */
d_3192
:
    alphanumeric35
;

/** 3194  Account holder identifier                               [B]	 */
d_3194
:
    alphanumeric35
;

/** 3197  Agent identifier                                        [I]	 */
d_3197
:
    alphanumeric9
;

/** 3207  Country identifier                                      [C]	 */
d_3207
:
    alphanumeric3
;

/** 3222  First related location name                             [B]	 */
d_3222
:
    alphanumeric70
;

/** 3223  First related location identifier                       [C]	 */
d_3223
:
    alphanumeric35
;

/** 3224  Location name                                           [C]	 */
d_3224
:
    alphanumeric256
;

/** 3225  Location identifier                                     [C]	 */
d_3225
:
    alphanumeric35
;

/** 3227  Location function code qualifier                        [C]	 */
d_3227
:
    alphanumeric3
;

/** 3228  Country subdivision name                                [C]	 */
d_3228
:
    alphanumeric70
;

/** 3229  Country subdivision identifier                          [C]	 */
d_3229
:
    alphanumeric9
;

/** 3232  Second related location name                            [B]	 */
d_3232
:
    alphanumeric70
;

/** 3233  Second related location identifier                      [C]	 */
d_3233
:
    alphanumeric35
;

/** 3236  Sample location description                             [B]	 */
d_3236
:
    alphanumeric35
;

/** 3237  Sample location description code                        [B]	 */
d_3237
:
    alphanumeric3
;

/** 3239  Country of origin identifier                            [B]	 */
d_3239
:
    alphanumeric3
;

/** 3251  Postal identification code                              [C]	 */
d_3251
:
    alphanumeric17
;

/** 3279  Geographic area code                                    [B]	 */
d_3279
:
    alphanumeric3
;

/** 3285  Instruction receiving party identifier                  [B]	 */
d_3285
:
    alphanumeric35
;

/** 3286  Address component description                           [C]	 */
d_3286
:
    alphanumeric70
;

/** 3289  Person characteristic code qualifier                    [B]	 */
d_3289
:
    alphanumeric3
;

/** 3292  Nationality name                                        [B]	 */
d_3292
:
    alphanumeric35
;

/** 3293  Nationality name code                                   [B]	 */
d_3293
:
    alphanumeric3
;

/** 3295  Name original alphabet code                             [B]	 */
d_3295
:
    alphanumeric3
;

/** 3299  Address purpose code                                    [C]	 */
d_3299
:
    alphanumeric3
;

/** 3301  Enacting party identifier                               [B]	 */
d_3301
:
    alphanumeric35
;

/** 3310  Inherited characteristic description                    [B]	 */
d_3310
:
    alphanumeric70
;

/** 3311  Inherited characteristic description code               [B]	 */
d_3311
:
    alphanumeric8
;

/** 3397  Name status code                                        [C]	 */
d_3397
:
    alphanumeric3
;

/** 3398  Name component description                              [B]	 */
d_3398
:
    alphanumeric256
;

/** 3401  Name component usage code                               [B]	 */
d_3401
:
    alphanumeric3
;

/** 3403  Name type code                                          [B]	 */
d_3403
:
    alphanumeric3
;

/** 3405  Name component type code qualifier                      [B]	 */
d_3405
:
    alphanumeric3
;

/** 3412  Contact name                                            [B]	 */
d_3412
:
    alphanumeric256
;

/** 3413  Contact identifier                                      [C]	 */
d_3413
:
    alphanumeric17
;

/** 3432  Institution name                                        [B]	 */
d_3432
:
    alphanumeric70
;

/** 3433  Institution name code                                   [B]	 */
d_3433
:
    alphanumeric11
;

/** 3434  Institution branch identifier                           [B]	 */
d_3434
:
    alphanumeric17
;

/** 3436  Institution branch location name                        [B]	 */
d_3436
:
    alphanumeric70
;

/** 3446  Party tax identifier                                    [B]	 */
d_3446
:
    alphanumeric20
;

/** 3449  Bank identifier                                         [I]	 */
d_3449
:
    alphanumeric17
;

/** 3452  Language name                                           [C]	 */
d_3452
:
    alphanumeric35
;

/** 3453  Language name code                                      [C]	 */
d_3453
:
    alphanumeric3
;

/** 3455  Language code qualifier                                 [C]	 */
d_3455
:
    alphanumeric3
;

/** 3457  Originator type code                                    [I]	 */
d_3457
:
    alphanumeric3
;

/** 3459  Frequent traveller identifier                           [I]	 */
d_3459
:
    alphanumeric25
;

/** 3460  Given name                                              [I]	 */
d_3460
:
    alphanumeric70
;

/** 3463  Gate identifier                                         [I]	 */
d_3463
:
    alphanumeric6
;

/** 3465  In-house identifier                                     [I]	 */
d_3465
:
    alphanumeric9
;

/** 3475  Address status code                                     [C]	 */
d_3475
:
    alphanumeric3
;

/** 3477  Address format code                                     [C]	 */
d_3477
:
    alphanumeric3
;

/** 3478  Marital status description                              [B]	 */
d_3478
:
    alphanumeric35
;

/** 3479  Marital status description code                         [C]	 */
d_3479
:
    alphanumeric3
;

/** 3480  Person job title                                        [B]	 */
d_3480
:
    alphanumeric35
;

/** 3482  Religion name                                           [B]	 */
d_3482
:
    alphanumeric35
;

/** 3483  Religion name code                                      [B]	 */
d_3483
:
    alphanumeric3
;

/** 3493  Nationality code qualifier                              [B]	 */
d_3493
:
    alphanumeric3
;

/** 3496  Sales channel identifier                                [B]	 */
d_3496
:
    alphanumeric17
;

/** 3499  Gender code                                             [C]	 */
d_3499
:
    alphanumeric3
;

/** 3500  Family name                                             [I]	 */
d_3500
:
    alphanumeric70
;

/** 3503  Access authorisation identifier                         [I]	 */
d_3503
:
    alphanumeric9
;

/** 3504  Given name title description                            [I]	 */
d_3504
:
    alphanumeric9
;

/** 3507  Benefit coverage constituents code                      [I]	 */
d_3507
:
    alphanumeric3
;

/** 4009  Option code                                             [I]	 */
d_4009
:
    alphanumeric3
;

/** 4017  Delivery plan commitment level code                     [B]	 */
d_4017
:
    alphanumeric3
;

/** 4018  Related information description                         [I]	 */
d_4018
:
    alphanumeric35
;

/** 4022  Business description                                    [B]	 */
d_4022
:
    alphanumeric70
;

/** 4025  Business function code                                  [C]	 */
d_4025
:
    alphanumeric3
;

/** 4027  Business function type code qualifier                   [B]	 */
d_4027
:
    alphanumeric3
;

/** 4035  Priority type code qualifier                            [B]	 */
d_4035
:
    alphanumeric3
;

/** 4036  Priority description                                    [B]	 */
d_4036
:
    alphanumeric35
;

/** 4037  Priority description code                               [B]	 */
d_4037
:
    alphanumeric3
;

/** 4038  Additional safety information description               [B]	 */
d_4038
:
    alphanumeric35
;

/** 4039  Additional safety information description code          [B]	 */
d_4039
:
    alphanumeric3
;

/** 4043  Trade class code                                        [B]	 */
d_4043
:
    alphanumeric3
;

/** 4044  Safety section name                                     [B]	 */
d_4044
:
    alphanumeric70
;

/** 4046  Safety section number                                   [B]	 */
d_4046
:
    integer2
;

/** 4048  Certainty description                                   [C]	 */
d_4048
:
    alphanumeric35
;

/** 4049  Certainty description code                              [C]	 */
d_4049
:
    alphanumeric3
;

/** 4051  Characteristic relevance code                           [B]	 */
d_4051
:
    alphanumeric3
;

/** 4052  Delivery or transport terms description                 [B]	 */
d_4052
:
    alphanumeric70
;

/** 4053  Delivery or transport terms description code            [B]	 */
d_4053
:
    alphanumeric3
;

/** 4055  Delivery or transport terms function code               [B]	 */
d_4055
:
    alphanumeric3
;

/** 4056  Question description                                    [B]	 */
d_4056
:
    alphanumeric256
;

/** 4057  Question description code                               [B]	 */
d_4057
:
    alphanumeric3
;

/** 4059  Clause code qualifier                                   [B]	 */
d_4059
:
    alphanumeric3
;

/** 4065  Contract and carriage condition code                    [B]	 */
d_4065
:
    alphanumeric3
;

/** 4068  Clause name                                             [B]	 */
d_4068
:
    alphanumeric70
;

/** 4069  Clause name code                                        [B]	 */
d_4069
:
    alphanumeric17
;

/** 4071  Proviso code qualifier                                  [B]	 */
d_4071
:
    alphanumeric3
;

/** 4072  Proviso type description                                [B]	 */
d_4072
:
    alphanumeric35
;

/** 4073  Proviso type description code                           [B]	 */
d_4073
:
    alphanumeric3
;

/** 4074  Proviso calculation description                         [B]	 */
d_4074
:
    alphanumeric35
;

/** 4075  Proviso calculation description code                    [B]	 */
d_4075
:
    alphanumeric3
;

/** 4078  Handling instruction description                        [B]	 */
d_4078
:
    alphanumeric512
;

/** 4079  Handling instruction description code                   [B]	 */
d_4079
:
    alphanumeric3
;

/** 4148  Information category description                        [B]	 */
d_4148
:
    alphanumeric70
;

/** 4149  Information category description code                   [B]	 */
d_4149
:
    alphanumeric3
;

/** 4150  Information detail description                          [B]	 */
d_4150
:
    alphanumeric256
;

/** 4151  Information detail description code                     [B]	 */
d_4151
:
    alphanumeric17
;

/** 4183  Special condition code                                  [C]	 */
d_4183
:
    alphanumeric3
;

/** 4184  Special requirement description                         [I]	 */
d_4184
:
    alphanumeric17
;

/** 4187  Special requirement type code                           [I]	 */
d_4187
:
    alphanumeric4
;

/** 4215  Transport charges payment method code                   [B]	 */
d_4215
:
    alphanumeric3
;

/** 4219  Transport service priority code                         [B]	 */
d_4219
:
    alphanumeric3
;

/** 4221  Discrepancy nature identification code                  [B]	 */
d_4221
:
    alphanumeric3
;

/** 4233  Marking instructions code                               [B]	 */
d_4233
:
    alphanumeric3
;

/** 4237  Payment arrangement code                                [B]	 */
d_4237
:
    alphanumeric3
;

/** 4276  Payment terms description                               [B]	 */
d_4276
:
    alphanumeric35
;

/** 4277  Payment terms description identifier                    [B]	 */
d_4277
:
    alphanumeric17
;

/** 4279  Payment terms type code qualifier                       [B]	 */
d_4279
:
    alphanumeric3
;

/** 4294  Change reason description                               [B]	 */
d_4294
:
    alphanumeric35
;

/** 4295  Change reason description code                          [B]	 */
d_4295
:
    alphanumeric3
;

/** 4343  Response type code                                      [C]	 */
d_4343
:
    alphanumeric3
;

/** 4344  Response description                                    [B]	 */
d_4344
:
    alphanumeric256
;

/** 4345  Response description code                               [B]	 */
d_4345
:
    alphanumeric3
;

/** 4347  Product identifier code qualifier                       [B]	 */
d_4347
:
    alphanumeric3
;

/** 4383  Bank operation code                                     [B]	 */
d_4383
:
    alphanumeric3
;

/** 4400  Instruction description                                 [B]	 */
d_4400
:
    alphanumeric35
;

/** 4401  Instruction description code                            [C]	 */
d_4401
:
    alphanumeric3
;

/** 4403  Instruction type code qualifier                         [C]	 */
d_4403
:
    alphanumeric3
;

/** 4404  Status description                                      [B]	 */
d_4404
:
    alphanumeric35
;

/** 4405  Status description code                                 [C]	 */
d_4405
:
    alphanumeric3
;

/** 4407  Sample process step code                                [B]	 */
d_4407
:
    alphanumeric3
;

/** 4415  Test method identifier                                  [B]	 */
d_4415
:
    alphanumeric17
;

/** 4416  Test description                                        [B]	 */
d_4416
:
    alphanumeric70
;

/** 4419  Test administration method code                         [B]	 */
d_4419
:
    alphanumeric3
;

/** 4424  Test reason name                                        [B]	 */
d_4424
:
    alphanumeric35
;

/** 4425  Test reason name code                                   [B]	 */
d_4425
:
    alphanumeric17
;

/** 4431  Payment guarantee means code                            [B]	 */
d_4431
:
    alphanumeric3
;

/** 4435  Payment channel code                                    [B]	 */
d_4435
:
    alphanumeric3
;

/** 4437  Account type code qualifier                             [B]	 */
d_4437
:
    alphanumeric3
;

/** 4439  Payment conditions code                                 [C]	 */
d_4439
:
    alphanumeric3
;

/** 4440  Free text                                               [C]	 */
d_4440
:
    alphanumeric512
;

/** 4441  Free text description code                              [B]	 */
d_4441
:
    alphanumeric17
;

/** 4447  Free text format code                                   [B]	 */
d_4447
:
    alphanumeric3
;

/** 4451  Text subject code qualifier                             [C]	 */
d_4451
:
    alphanumeric3
;

/** 4453  Free text function code                                 [B]	 */
d_4453
:
    alphanumeric3
;

/** 4455  Back order arrangement type code                        [B]	 */
d_4455
:
    alphanumeric3
;

/** 4457  Substitution condition code                             [B]	 */
d_4457
:
    alphanumeric3
;

/** 4461  Payment means code                                      [B]	 */
d_4461
:
    alphanumeric3
;

/** 4463  Intra-company payment indicator code                    [B]	 */
d_4463
:
    alphanumeric3
;

/** 4465  Adjustment reason description code                      [C]	 */
d_4465
:
    alphanumeric3
;

/** 4467  Payment method code                                     [I]	 */
d_4467
:
    alphanumeric4
;

/** 4469  Payment purpose code                                    [I]	 */
d_4469
:
    alphanumeric4
;

/** 4471  Settlement means code                                   [B]	 */
d_4471
:
    alphanumeric3
;

/** 4472  Information type                                        [B]	 */
d_4472
:
    alphanumeric35
;

/** 4473  Information type code                                   [C]	 */
d_4473
:
    alphanumeric4
;

/** 4474  Accounting entry type name                              [B]	 */
d_4474
:
    alphanumeric35
;

/** 4475  Accounting entry type name code                         [B]	 */
d_4475
:
    alphanumeric17
;

/** 4487  Financial transaction type code                         [B]	 */
d_4487
:
    alphanumeric3
;

/** 4493  Delivery instruction code                               [B]	 */
d_4493
:
    alphanumeric3
;

/** 4494  Insurance cover description                             [B]	 */
d_4494
:
    alphanumeric35
;

/** 4495  Insurance cover description code                        [B]	 */
d_4495
:
    alphanumeric17
;

/** 4497  Insurance cover type code                               [C]	 */
d_4497
:
    alphanumeric3
;

/** 4499  Inventory movement reason code                          [B]	 */
d_4499
:
    alphanumeric3
;

/** 4501  Inventory movement direction code                       [B]	 */
d_4501
:
    alphanumeric3
;

/** 4503  Inventory balance method code                           [B]	 */
d_4503
:
    alphanumeric3
;

/** 4505  Credit cover request type code                          [B]	 */
d_4505
:
    alphanumeric3
;

/** 4507  Credit cover response type code                         [B]	 */
d_4507
:
    alphanumeric3
;

/** 4509  Credit cover response reason code                       [B]	 */
d_4509
:
    alphanumeric3
;

/** 4510  Requested information description                       [C]	 */
d_4510
:
    alphanumeric35
;

/** 4511  Requested information description code                  [B]	 */
d_4511
:
    alphanumeric3
;

/** 4513  Maintenance operation code                              [C]	 */
d_4513
:
    alphanumeric3
;

/** 4517  Seal condition code                                     [B]	 */
d_4517
:
    alphanumeric3
;

/** 4519  Definition identifier                                   [B]	 */
d_4519
:
    alphanumeric35
;

/** 4521  Premium calculation component identifier                [B]	 */
d_4521
:
    alphanumeric17
;

/** 4522  Premium calculation component value category identifier [B]	 */
d_4522
:
    alphanumeric35
;

/** 4525  Seal type code                                          [B]	 */
d_4525
:
    alphanumeric3
;

/** 5004  Monetary amount                                         [C]	 */
d_5004
:
    integer35
;

/** 5006  Monetary amount function description                    [B]	 */
d_5006
:
    alphanumeric70
;

/** 5007  Monetary amount function description code               [B]	 */
d_5007
:
    alphanumeric3
;

/** 5013  Index code qualifier                                    [B]	 */
d_5013
:
    alphanumeric3
;

/** 5025  Monetary amount type code qualifier                     [C]	 */
d_5025
:
    alphanumeric3
;

/** 5027  Index type identifier                                   [B]	 */
d_5027
:
    alphanumeric17
;

/** 5030  Index text                                              [C]	 */
d_5030
:
    alphanumeric35
;

/** 5039  Index representation code                               [B]	 */
d_5039
:
    alphanumeric3
;

/** 5047  Contribution code qualifier                             [B]	 */
d_5047
:
    alphanumeric3
;

/** 5048  Contribution type description                           [B]	 */
d_5048
:
    alphanumeric35
;

/** 5049  Contribution type description code                      [B]	 */
d_5049
:
    alphanumeric3
;

/** 5104  Monetary amount function detail description             [B]	 */
d_5104
:
    alphanumeric70
;

/** 5105  Monetary amount function detail description code        [B]	 */
d_5105
:
    alphanumeric17
;

/** 5118  Price amount                                            [C]	 */
d_5118
:
    integer15
;

/** 5125  Price code qualifier                                    [C]	 */
d_5125
:
    alphanumeric3
;

/** 5152  Duty or tax or fee type name                            [B]	 */
d_5152
:
    alphanumeric35
;

/** 5153  Duty or tax or fee type name code                       [C]	 */
d_5153
:
    alphanumeric3
;

/** 5160  Total monetary amount                                   [I]	 */
d_5160
:
    integer20
;

/** 5189  Allowance or charge identification code                 [B]	 */
d_5189
:
    alphanumeric3
;

/** 5213  Sub-line item price change operation code               [C]	 */
d_5213
:
    alphanumeric3
;

/** 5237  Charge category code                                    [B]	 */
d_5237
:
    alphanumeric3
;

/** 5242  Rate or tariff class description                        [B]	 */
d_5242
:
    alphanumeric35
;

/** 5243  Rate or tariff class description code                   [C]	 */
d_5243
:
    alphanumeric9
;

/** 5245  Percentage type code qualifier                          [B]	 */
d_5245
:
    alphanumeric3
;

/** 5249  Percentage basis identification code                    [B]	 */
d_5249
:
    alphanumeric3
;

/** 5261  Charge unit code                                        [I]	 */
d_5261
:
    alphanumeric3
;

/** 5263  Rate type identifier                                    [I]	 */
d_5263
:
    alphanumeric20
;

/** 5267  Service type code                                       [I]	 */
d_5267
:
    alphanumeric3
;

/** 5273  Duty or tax or fee rate basis code                      [B]	 */
d_5273
:
    alphanumeric12
;

/** 5275  Supplementary rate or tariff code                       [B]	 */
d_5275
:
    alphanumeric6
;

/** 5278  Duty or tax or fee rate                                 [C]	 */
d_5278
:
    alphanumeric17
;

/** 5279  Duty or tax or fee rate code                            [B]	 */
d_5279
:
    alphanumeric7
;

/** 5283  Duty or tax or fee function code qualifier              [B]	 */
d_5283
:
    alphanumeric3
;

/** 5284  Unit price basis quantity                               [B]	 */
d_5284
:
    integer9
;

/** 5286  Duty or tax or fee assessment basis quantity            [B]	 */
d_5286
:
    alphanumeric15
;

/** 5289  Duty or tax or fee account code                         [B]	 */
d_5289
:
    alphanumeric6
;

/** 5305  Duty or tax or fee category code                        [B]	 */
d_5305
:
    alphanumeric3
;

/** 5307  Tax or duty or fee payment due date code                [B]	 */
d_5307
:
    alphanumeric3
;

/** 5314  Remuneration type name                                  [B]	 */
d_5314
:
    alphanumeric35
;

/** 5315  Remuneration type name code                             [B]	 */
d_5315
:
    alphanumeric3
;

/** 5375  Price type code                                         [C]	 */
d_5375
:
    alphanumeric3
;

/** 5377  Price change type code                                  [I]	 */
d_5377
:
    alphanumeric3
;

/** 5379  Product group type code                                 [B]	 */
d_5379
:
    alphanumeric3
;

/** 5387  Price specification code                                [B]	 */
d_5387
:
    alphanumeric3
;

/** 5388  Product group name                                      [B]	 */
d_5388
:
    alphanumeric35
;

/** 5389  Product group name code                                 [C]	 */
d_5389
:
    alphanumeric25
;

/** 5393  Price multiplier type code qualifier                    [B]	 */
d_5393
:
    alphanumeric3
;

/** 5394  Price multiplier rate                                   [B]	 */
d_5394
:
    integer12
;

/** 5402  Currency exchange rate                                  [C]	 */
d_5402
:
    integer12
;

/** 5419  Rate type code qualifier                                [B]	 */
d_5419
:
    alphanumeric3
;

/** 5420  Unit price basis rate                                   [B]	 */
d_5420
:
    integer15
;

/** 5463  Allowance or charge code qualifier */
d_5463
:
    alphanumeric3
;

/** 5479  Relation code */
d_5479
:
    alphanumeric3
;

/** 5482  Percentage */
d_5482
:
    integer10
;

/** 5495  Sub-line indicator code */
d_5495
:
    alphanumeric3
;

/** 5501  Rate plan code */
d_5501
:
    alphanumeric3
;

/** 6000  Latitude degree */
d_6000
:
    alphanumeric10
;

/** 6002  Longitude degree */
d_6002
:
    alphanumeric11
;

/** 6008  Height measure */
d_6008
:
    integer15
;

/** 6029  Geographical position code qualifier */
d_6029
:
    alphanumeric3
;

/** 6060  Quantity */
d_6060
:
    alphanumeric35
;

/** 6063  Quantity type code qualifier */
d_6063
:
    alphanumeric3
;

/** 6064  Variance quantity */
d_6064
:
    integer15
;

/** 6066  Control total quantity    */
d_6066
:
    integer18
;

/** 6069  Control total type code qualifier. */
d_6069
:
    alphanumeric3
;

/** 6071  Frequency code qualifier. */
d_6071
:
    alphanumeric3
;

/** 6072  Frequency rate. */
d_6072
:
    integer9
;

/** 6074  Confidence percent. */
d_6074
:
    integer6
;

/** 6077  Result representation code. */
d_6077
:
    alphanumeric3
;

/** 6079  Result normalcy code. */
d_6079
:
    alphanumeric3
;

/** 6082  Dosage description. */
d_6082
:
    alphanumeric70
;

/** 6083  Dosage description identifier. */
d_6083
:
    alphanumeric8
;

/** 6085  Dosage administration code qualifier. */
d_6085
:
    alphanumeric3
;

/** 6087  Result value type code qualifier. */
d_6087
:
    alphanumeric3
;

/** 6096  Altitude. */
d_6096
:
    integer18
;

/** 6113  Length type code. */
d_6113
:
    alphanumeric3
;

/** 6140  Width measure. */
d_6140
:
    integer15
;

/** 6145  Dimension type code qualifier. */
d_6145
:
    alphanumeric3
;

/** 6152  Range maximum quantity. */
d_6152
:
    integer18
;

/** 6154  Non-discrete measurement name. */
d_6154
:
    alphanumeric70
;

/** 6155  Non-discrete measurement name code. */
d_6155
:
    alphanumeric17
;

/** 6162  Range minimum quantity. */
d_6162
:
    integer18
;

/** 6167  Range type code qualifier. */
d_6167
:
    alphanumeric3
;

/** 6168  Length measure. */
d_6168
:
    integer15
;

/** 6173  Size type code qualifier. */
d_6173
:
    alphanumeric3
;

/** 6174  Size measure. */
d_6174
:
    integer15
;

/** 6176  Occurrences maximum number. */
d_6176
:
    integer7
;

/** 6178  Edit field length measure. */
d_6178
:
    integer3
;

/** 6182  Diameter measure. */
d_6182
:
    integer15
;

/** 6245  Temperature type code qualifier. */
d_6245
:
    alphanumeric3
;

/** 6246  Temperature degree. */
d_6246
:
    integer15
;

/** 6311  Measurement purpose code qualifier. */
d_6311
:
    alphanumeric3
;

/** 6313  Measured attribute code. */
d_6313
:
    alphanumeric3
;

/** 6314  Measure. */
d_6314
:
    alphanumeric18
;

/** 6321  Measurement significance code. */
d_6321
:
    alphanumeric3
;

/** 6331  Statistic type code qualifier. */
d_6331
:
    alphanumeric3
;

/** 6341  Exchange rate currency market identifier. */
d_6341
:
    alphanumeric3
;

/** 6343  Currency type code qualifier. */
d_6343
:
    alphanumeric3
;

/** 6345  Currency identification code. */
d_6345
:
    alphanumeric3
;

/** 6347  Currency usage code qualifier. */
d_6347
:
    alphanumeric3
;

/** 6348  Currency rate. */
d_6348
:
    integer4
;

/** 6350  Units quantity. */
d_6350
:
    integer15
;

/** 6353  Unit type code qualifier. */
d_6353
:
    alphanumeric3
;

/** 6410  Measurement unit name. */
d_6410
:
    alphanumeric35
;

/** 6411  Measurement unit code. */
d_6411
:
    alphanumeric8
;

/** 6412  Clinical information description. */
d_6412
:
    alphanumeric70
;

/** 6413  Clinical information description identifier. */
d_6413
:
    alphanumeric17
;

/** 6415  Clinical information type code qualifier. */
d_6415
:
    alphanumeric3
;

/** 6426  Process stages quantity. */
d_6426
:
    integer2
;

/** 6428  Process stages actual quantity. */
d_6428
:
    integer2
;

/** 6432  Significant digits quantity. */
d_6432
:
    integer2
;

/** 6434  Statistical concept identifier. */
d_6434
:
    alphanumeric35
;


/*
     7001  Physical or logical state type code qualifier           [B]
     7006  Physical or logical state description                   [B]
     7007  Physical or logical state description code              [B]
     7008  Item description                                        [C]
     7009  Item description code                                   [C]
     7011  Item availability code                                  [B]
     7036  Characteristic description                              [C]
     7037  Characteristic description code                         [C]
     7039  Sample selection method code                            [B]
     7040  Power type description                                  [B]
     7041  Power type code                                         [B]
     7045  Sample state code                                       [B]
     7047  Sample direction code                                   [B]
     7059  Class type code                                         [B]
     7064  Type of packages                                        [B]
     7065  Package type description code                           [B]
     7073  Packaging terms and conditions code                     [B]
     7075  Packaging level code                                    [B]
     7077  Description format code                                 [B]
     7081  Item characteristic code                                [B]
     7083  Configuration operation code                            [B]
     7085  Cargo type classification code                          [B]
     7088  Dangerous goods flashpoint description                  [B]


     7102  Shipping marks description                              [B]
     7106  Shipment flashpoint degree                              [B]
     7110  Characteristic value description                        [B]
     7111  Characteristic value description code                   [C]
     7124  United Nations Dangerous Goods (UNDG) identifier        [B]
     7130  Customer shipment authorisation identifier              [B]
     7133  Product details type code qualifier                     [I]
     7134  Product name                                            [I]
     7135  Product identifier                                      [I]
     7139  Product characteristic identification code              [I]
     7140  Item identifier                                         [C]
     7143  Item type identification code                           [C]
     7160  Special service description                             [C]
     7161  Special service description code                        [C]
     7164  Hierarchical structure level identifier                 [C]
     7166  Hierarchical structure parent identifier                [B]
     7168  Level number                                            [B]
     7171  Hierarchical structure relationship code                [B]
     7173  Hierarchy object code qualifier                         [B]
     7175  Rule part identifier                                    [B]
     7176  Risk object sub-type description                        [B]
     7177  Risk object sub-type description identifier             [B]
     7179  Risk object type identifier                             [B]
     7186  Process type description                                [B]
     7187  Process type description code                           [B]
     7188  Test method revision identifier                         [B]
     7190  Process description                                     [B]
     7191  Process description code                                [C]


     7224  Package quantity                                        [B]
     7233  Packaging related description code                      [B]
     7240  Item total quantity                                     [B]
     7273  Service requirement code                                [C]
     7293  Sector area identification code qualifier               [B]
     7294  Requirement or condition description                    [B]
     7295  Requirement or condition description identifier         [B]
     7297  Set type code qualifier                                 [B]
     7299  Requirement designator code                             [C]
     7357  Commodity identification code                           [B]
     7361  Customs goods identifier                                [B]
     7364  Processing indicator description                        [B]
     7365  Processing indicator description code                   [C]
     7383  Surface or layer code                                   [C]
     7402  Object identifier                                       [C]
     7405  Object identification code qualifier                    [C]
     7418  Hazardous material category name                        [B]
     7419  Hazardous material category name code                   [B]
     7429  Indexing structure code qualifier                       [B]
     7431  Agreement type code qualifier                           [B]
     7433  Agreement type description code                         [B]
     7434  Agreement type description                              [B]
     7436  Level one identifier                                    [B]
     7438  Level two identifier                                    [B]
     7440  Level three identifier                                  [B]
     7442  Level four identifier                                   [B]
     7444  Level five identifier                                   [B]
     7446  Level six identifier                                    [B]
     7449  Membership type code qualifier                          [B]
     7450  Membership category description                         [B]
     7451  Membership category description code                    [B]
     7452  Membership status description                           [B]
     7453  Membership status description code                      [B]
     7455  Membership level code qualifier                         [B]
     7456  Membership level description                            [B]
     7457  Membership level description code                       [B]
     7458  Attendee category description                           [B]
     7459  Attendee category description code                      [B]
     7491  Inventory type code                                     [B]
     7493  Damage details code qualifier                           [B]
     7495  Object type code qualifier                              [B]
     7497  Structure component function code qualifier             [B]


     7500  Damage type description                                 [B]
     7501  Damage type description code                            [B]
     7502  Damage area description                                 [B]
     7503  Damage area description code                            [B]
     7504  Unit or component type description                      [B]
     7505  Unit or component type description code                 [B]
     7506  Component material description                          [B]
     7507  Component material description code                     [B]
     7508  Damage severity description                             [B]
     7509  Damage severity description code                        [B]
     7511  Marking type code                                       [B]
     7512  Structure component identifier                          [B]
     7515  Structure type code                                     [B]
     7517  Benefit and coverage code                               [I]


     8015  Traffic restriction code                                [I]
     8017  Traffic restriction application code                    [I]
     8022  Freight and other charges description                   [B]
     8023  Freight and other charges description identifier        [B]
     8024  Conveyance call purpose description                     [B]
     8025  Conveyance call purpose description code                [B]
     8028  Means of transport journey identifier                   [B]
     8035  Traffic restriction type code qualifier                 [I]
     8051  Transport stage code qualifier                          [B]
     8053  Equipment type code qualifier                           [C]
     8066  Transport mode name                                     [B]
     8067  Transport mode name code                                [B]
     8077  Equipment supplier code                                 [B]
     8078  Additional hazard classification identifier             [B]
     8092  Hazard code version identifier                          [B]
     8101  Transit direction indicator code                        [B]
     8126  Transport emergency card identifier                     [B]
     8154  Equipment size and type description                     [C]
     8155  Equipment size and type description code                [B]
     8158  Orange hazard placard upper part identifier             [B]
     8169  Full or empty indicator code                            [B]
     8178  Transport means description                             [B]
     8179  Transport means description code                        [C]
     8186  Orange hazard placard lower part identifier             [B]
     8211  Hazardous cargo transport authorisation code            [B]
     8212  Transport means identification name                     [B]
     8213  Transport means identification name identifier          [B]
     8215  Transport means change indicator code                   [I]
     8216  Journey stops quantity                                  [I]
     8219  Traveller accompanied by infant indicator code          [I]
     8246  Dangerous goods marking identifier                      [B]
     8249  Equipment status code                                   [B]
     8255  Packing instruction type code                           [B]
     8260  Equipment identifier                                    [B]
     8273  Dangerous goods regulations code                        [B]
     8275  Container or package contents indicator code            [B]
     8281  Transport means ownership indicator code                [B]


     8323  Transport movement code                                 [B]
     8332  Equipment plan description                              [B]
     8334  Movement type description                               [B]
     8335  Movement type description code                          [B]
     8339  Packaging danger level code                             [B]
     8341  Haulage arrangements code                               [B]
     8351  Hazard identification code                              [B]
     8364  Emergency procedure for ships identifier                [B]
     8393  Returnable package load contents code                   [B]
     8395  Returnable package freight payment responsibility code  [B]
     8410  Hazard medical first aid guide identifier               [B]
     8453  Transport means nationality code                        [B]
     8457  Excess transportation reason code                       [B]
     8459  Excess transportation responsibility code               [B]
     8461  Tunnel Restriction Code                                 [B]


     9003  Employment details code qualifier                       [B]
     9004  Employment category description                         [B]
     9005  Employment category description code                    [C]
     9006  Qualification classification description                [B]
     9007  Qualification classification description code           [B]
     9008  Occupation description                                  [B]
     9009  Occupation description code                             [B]
     9012  Status reason description                               [B]
     9013  Status reason description code                          [C]
     9015  Status category code                                    [B]
     9017  Attribute function code qualifier                       [C]
     9018  Attribute description                                   [C]
     9019  Attribute description code                              [B]
     9020  Attribute type description                              [B]
     9021  Attribute type description code                         [C]
     9023  Definition function code                                [B]
     9025  Definition extent code                                  [B]
     9026  Edit mask format identifier                             [B]
     9029  Value definition code qualifier                         [B]
     9031  Edit mask representation code                           [B]
     9035  Qualification application area code                     [B]
     9037  Qualification type code qualifier                       [B]
     9038  Facility type description                               [I]
     9039  Facility type description code                          [I]
     9040  Reservation identifier                                  [I]
     9043  Reservation identifier code qualifier                   [I]
     9045  Basis code qualifier                                    [B]
     9046  Basis type description                                  [B]
     9047  Basis type description code                             [B]
     9048  Applicability type description                          [B]
     9049  Applicability type description code                     [B]
     9051  Applicability code qualifier                            [B]
     9141  Relationship type code qualifier                        [C]
     9142  Relationship description                                [C]
     9143  Relationship description code                           [C]
     9146  Composite data element tag identifier                   [B]
     9148  Directory status identifier                             [B]
     9150  Simple data element tag identifier                      [B]
     9153  Simple data element character representation code       [B]
     9156  Simple data element maximum length measure              [B]
     9158  Simple data element minimum length measure              [B]
     9161  Code set indicator code                                 [B]
     9162  Data element tag identifier                             [B]
     9164  Group identifier                                        [B]
     9166  Segment tag identifier                                  [B]
     9169  Data representation type code                           [B]
     9170  Event type description                                  [B]
     9171  Event type description code                             [B]
     9172  Event                                                   [B]
     9173  Event description code                                  [B]
     9175  Data element usage type code                            [B]
     9213  Duty regime type code                                   [B]
     9280  Validation result text                                  [B]
     9282  Validation key identifier                               [B]
     9285  Validation criteria code                                [B]


     9302  Sealing party name                                      [B]
     9303  Sealing party name code                                 [B]
     9308  Transport unit seal identifier                          [B]
     9321  Application error code                                  [C]
     9353  Government procedure code                               [B]
     9411  Government involvement code                             [B]
     9415  Government agency identification code                   [B]
     9417  Government action code                                  [B]
     9419  Service layer code                                      [B]
     9421  Process stage code qualifier                            [B]
     9422  Value text                                              [B]
     9424  Array cell data description                             [B]
     9426  Code value text                                         [B]
     9428  Array cell structure identifier                         [B]
     9430  Footnote set identifier                                 [B]
     9432  Footnote identifier                                     [B]
     9434  Code name                                               [B]
     9436  Clinical intervention description                       [B]
     9437  Clinical intervention description code                  [B]
     9441  Clinical intervention type code qualifier               [B]
     9443  Attendance type code qualifier                          [B]
     9444  Admission type description                              [B]
     9445  Admission type description code                         [C]
     9446  Discharge type description                              [B]
     9447  Discharge type description code                         [C]
     9448  File generation command name                            [B]
     9450  File compression technique name                         [B]
     9453  Code value source code                                  [B]
     9501  Formula type code qualifier                             [B]
     9502  Formula name                                            [B]
     9505  Formula complexity code                                 [B]
     9507  Formula sequence code qualifier                         [B]
     9509  Formula sequence operand code                           [B]
     9510  Formula sequence name                                   [B]
     9601  Information category code                               [I]
     9605  Data code qualifier                                     [I]
     9607  Yes or no indicator code                                [I]
     9619  Adjustment category code                                [I]
     9620  Policy limitation identifier                            [I]
     9623  Diagnosis type code                                     [I]
     9625  Related cause code                                      [I]
     9627  Admission source code                                   [I]
     9629  Procedure modification code                             [I]
     9631  Invoice type code                                       [I]
     9635  Event details code qualifier                            [B]
     9636  Event category description                              [B]
     9637  Event category description code                         [B]
     9639  Diagnosis category code                                 [I]
     9641  Service basis code qualifier                            [I]
     9643  Supporting evidence type code qualifier                 [I]
     9645  Payer responsibility level code                         [I]
     9647  Cavity zone code                                        [I]
     9649  Processing information code qualifier                   [B]
*/
f7040
:
    alphanumeric17
;

f7041
:
    alphanumeric3
;

f7064
:
    alphanumeric35
;

f7065
:
    alphanumeric17
;

f7085
:
    alphanumeric3
;

f7088
:
    alphanumeric8
;

f7102
:
    alphanumeric35
;

f7106
:
    integer3
;

f7124
:
    integer4
;

f7130
:
    alphanumeric17
;

f7140
:
    alphanumeric35
;

f7143
:
    alphanumeric3
;

f7224
:
    integer8
;

f7233
:
    alphanumeric3
;

f7273
:
    alphanumeric3
;

f7357
:
    alphanumeric18
;

f7383
:
    alphanumeric3
;

f7402
:
    alphanumeric35
;

f7405
:
    alphanumeric3
;

f7418
:
    alphanumeric35
;

f7419
:
    alphanumeric7
;

f7511
:
    alphanumeric3
;

f8022
:
    alphanumeric26
;

f8023
:
    alphanumeric17
;

f8024
:
    alphanumeric35
;

f8025
:
    alphanumeric3
;

f8028
:
    alphanumeric17
;

f8051
:
    alphanumeric3
;

f8053
:
    alphanumeric3
;

f8066
:
    alphanumeric17
;

f8067
:
    alphanumeric3
;

f8077
:
    alphanumeric3
;

f8078
:
    alphanumeric7
;

f8092
:
    alphanumeric10
;

f8101
:
    alphanumeric3
;

f8126
:
    alphanumeric10
;

f8154
:
    alphanumeric35
;

f8155
:
    alphanumeric10
;

f8158
:
    alphanumeric4
;

f8169
:
    alphanumeric3
;

f8178
:
    alphanumeric17
;

f8179
:
    alphanumeric8
;

f8186
:
    alphanumeric4
;

f8211
:
    alphanumeric3
;

f8212
:
    alphanumeric70
;

f8213
:
    alphanumeric35
;

f8246
:
    alphanumeric4
;

f8249
:
    alphanumeric3
;

f8255
:
    alphanumeric3
;

f8260
:
    alphanumeric17
;

f8273
:
    alphanumeric3
;

f8281
:
    alphanumeric3
;

f8323
:
    alphanumeric3
;

f8332
:
    alphanumeric26
;

f8334
:
    alphanumeric35
;

f8335
:
    alphanumeric3
;

f8339
:
    alphanumeric3
;

f8341
:
    alphanumeric3
;

f8351
:
    alphanumeric7
;

f8364
:
    alphanumeric8
;

f8410
:
    alphanumeric4
;

f8453
:
    alphanumeric3
;

f8457
:
    alphanumeric3
;

f8459
:
    alphanumeric3
;

f8461
:
    alphanumeric6
;

f9302
:
    alphanumeric35
;

f9303
:
    alphanumeric3
;

f9308
:
    alphanumeric35
;

f9321
:
    alphanumeric8
;

f9353
:
    alphanumeric3
;

f9411
:
    alphanumeric3
;

f9415
:
    alphanumeric3
;

f9417
:
    alphanumeric3
;

f0051
:
    alphanumeric3
;

f0052
:
    alphanumeric3
;

f0054
:
    alphanumeric3
;

f0057
:
    alphanumeric6
;

f0062
:
    alphanumeric14
;

f0065
:
    alphanumeric6
;

f0068
:
    alphanumeric35
;

f0070
:
    integer2
;

f0073
:
    alphanumeric1
;

f0074
:
    integer10
;

f0110
:
    alphanumeric6
;

f0113
:
    alphanumeric6
;

f0115
:
    alphanumeric14
;

f0116
:
    alphanumeric3
;

f0118
:
    alphanumeric3
;

f0121
:
    alphanumeric14
;

f0122
:
    alphanumeric3
;

f0124
:
    alphanumeric3
;

f0127
:
    alphanumeric14
;

f0128
:
    alphanumeric3
;

f0130
:
    alphanumeric3
;
