%{
  #include <stdio.h>
  extern FILE *yyin;
  extern int yylineno;
  //extern int ch;
  extern char *yytext;
  void yyerror(char *);
  extern int yylex (void);
%}
%token SEMICOLON BECOMES PLUS MINUS TIMES SLASH LPAREN RPAREN 
HEXNUMBER IDENT UNKNOWN FOR DO EQUALS LESS GREATER
%right ASSIGN
%left CMP
%%
program:
  statement { printf("Программа\n"); }
  | program statement { printf("Программа\n"); }
statement:  
  FOR expr_cmp DO expr { printf("Условие\n"); }
    | expr SEMICOLON { printf("Высказывание\n"); }
expr: 
    IDENT BECOMES expr_cmp { printf("Присваивание\n"); }
prim_expr: 
    IDENT { printf("Идентификатор\n"); }
    | HEXNUMBER { printf("Число\n"); }
    | LPAREN expr RPAREN { printf("Значение в скобках\n"); }
expr_cmp:
    prim_expr PLUS prim_expr { printf("+\n"); }
    | prim_expr MINUS prim_expr { printf("-\n"); }
    | prim_expr TIMES prim_expr { printf("*\n"); }
    | prim_expr SLASH prim_expr { printf("/\n"); }
    | prim_expr LESS prim_expr { printf("<\n"); }
    | prim_expr GREATER prim_expr { printf(">\n"); }
    | prim_expr EQUALS prim_expr { printf("==\n"); }
    | prim_expr { printf("Значение\n"); }
%%

void yyerror(char *errmsg) {
  fprintf(stderr, "%s (%d): %s\n", errmsg, yylineno, yytext);
}


int main(int argc, char **argv) {
  if(argc < 2) {
    printf("\nNot enough arguments. Please specify filename. \n");
    return -1;
  }
  if((yyin = fopen(argv[1], "r")) == NULL) {
    printf("\nCannot open file %s.\n", argv[1]);
    return -1;
  }
  yylineno = 1;
  yyparse();
  return 0;
}