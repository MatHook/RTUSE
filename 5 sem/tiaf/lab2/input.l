%option noyywrap yylineno
%{
#include "y.tab.h"
%}
letter [a-zA-Z_]
digit [0-9]
hexdigit [a-f]
%%
";" { return SEMICOLON; }
":=" { return BECOMES; }
"+" { return PLUS; }
"-" { return MINUS; }
"*" { return TIMES; }
"/" { return SLASH; }
"(" { return LPAREN; }
")" { return RPAREN; }
"FOR" { return FOR; }
"DO" { return DO; }
"=" { return EQUALS; }
"<" { return LESS; }
">" { return GREATER; }

{digit}({hexdigit}|{digit})* {
    printf("Met HEX \n");
    return HEXNUMBER;
    } 
{letter}({letter}|{digit})* {
    printf("Met IDENT\n");
    return IDENT;
    }

[ \t\n\r] /* skip whitespace */
. { printf("Unknown character [%c]\n",yytext[0]); return UNKNOWN; }
%%
