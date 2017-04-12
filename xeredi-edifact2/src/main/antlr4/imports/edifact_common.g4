grammar edifact_common;

alphanumeric [int maxLength]
:
    ALPHANUMERIC
    {$ALPHANUMERIC.text.length() <= $maxLength}?

;

numeric [int maxLength]
:
    ALPHANUMERIC
    {$ALPHANUMERIC.text.length() <= $maxLength}?

;

ALPHANUMERIC
:
    (
        [A-Za-z0-9ñÑ]
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


