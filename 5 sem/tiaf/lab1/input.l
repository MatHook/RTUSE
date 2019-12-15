%option noyywrap yylineno
%{
#include "y.tab.h"
%}
digit [0-9]
hexdigit [a-f]
letter [a-zA-Z]
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
 //yyval.id = strdup(yytext);
 return HEXNUMBER; }
{letter}({letter}|{digit})* {
 //yyval.id = strdup(yytext);
 return IDENT; }
[ \t\n\r] /* skip whitespace */
. { printf("Unknown character [%c]\n",yytext[0]);
 return UNKNOWN; }
%%
int main(int argc, char **argv)
{
 if(argc < 2)
 {
 printf("\nNot enough arguments. Please specify filename.\n");
 return -1;
 }
 if((yyin = fopen(argv[1], "r")) == NULL)
 {
 printf("\nCannot open file %s.\n", argv[1]);
 return -1;
 }
 yylineno = 1;

 while (1)
 {
 int token = yylex();
 if (token == 0) break;
 char names[][19] = {
    "", ";", ":=", "+", "-", "*", "/", 
    "(", ")", "[HEX]", "[IDENT]", "?", 
    "FOR", "DO", "=", "<", ">",
};
 printf("%d - %s\n", token, names[token]);
 }
 fclose(yyin);
 return 0;
}