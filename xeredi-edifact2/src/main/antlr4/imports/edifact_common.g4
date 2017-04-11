grammar edifact_common;


integer2
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 2}?

;

integer3
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 3}?

;

integer4
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 4}?

;

integer5
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 5}?

;

integer6
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 6}?

;

integer7
:
    ALPHANUMERIC
    {$ALPHANUMERIC.text.length() <= 7}?

;

integer8
:
    ALPHANUMERIC
    {$ALPHANUMERIC.text.length() <= 8}?

;

integer9
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 9}?

;

integer10
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 10}?

;

integer12
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 12}?

;

integer15
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 15}?

;

integer18
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 18}?

;

integer20
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 20}?

;

integer35
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 35}?

;

alphanumeric1
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 1}?

;

alphanumeric2
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 2}?

;

alphanumeric3
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 3}?

;

alphanumeric4
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 4}?

;

alphanumeric6
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 6}?

;

alphanumeric7
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 7}?

;

alphanumeric8
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 8}?

;

alphanumeric9
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 9}?

;

alphanumeric10
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 10}?

;

alphanumeric11
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 11}?

;

alphanumeric12
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 12}?

;

alphanumeric14
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 14}?

;

alphanumeric15
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 15}?

;

alphanumeric17
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 17}?

;

alphanumeric18
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 18}?

;

alphanumeric20
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 20}?

;

alphanumeric25
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 25}?

;

alphanumeric26
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 26}?

;

alphanumeric35
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 35}?

;

alphanumeric70
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 70}?

;

alphanumeric256
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 256}?

;

alphanumeric512
:
	ALPHANUMERIC
	{$ALPHANUMERIC.text.length() <= 512}?

;

ALPHANUMERIC
:
	(
		[A-Za-z0-9ñÑá-úÁ-Ú]
		| ' '
		| '/'
		| ','
		| '.'
	)+
;

INTEGER
:
	(
		[0-9]
	)+
;

COLON
:
	':'
;

PLUS
:
	'+'
;

EOL
:
	'\'' ' '* '\n'*
;

WS
:
	[ \r\n\t]+ -> skip
;


