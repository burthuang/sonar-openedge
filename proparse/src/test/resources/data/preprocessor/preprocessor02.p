

    { preprocessor/preprocessor02.i }

&IF DEFINED(FOO) &THEN
 DEFINE VARIABLE var1 AS CHARACTER.
&ENDIF
&IF {&FOO} GT 100 &THEN
 DEFINE VARIABLE var2 AS CHARACTER.
&ENDIF
 &UNDEFINE FOO
&IF DEFINED(FOO) &THEN
 DEFINE VARIABLE var3 AS CHARACTER.
&ENDIF

&IF DEFINED(BAR) &THEN
 DEFINE VARIABLE var4 AS CHARACTER.
&ENDIF