DIGITO	[0-9]
LETRA	[a-zA-Z]
Underline [_]
ID	{LETRA}({LETRA}|{Underline}|{DIGITO})*
PV 	[;]
ATRIB 	[=]
ACO	[[]
FCO	[]]
ACH	[{]
FCH	[}]
AP	[(]
FP	[)]
P	[.]
WHITESPACE "\t"|"\n"|"\r"|" "
OP	"&&"|"<"|"+"|"-"|"*"
TYPE    "int"|"boolean"
PR	"public"|"class"|"static"|"void"|"main"|"String"|"return"|"if"|"while"|"else"|"System.out.println"|"legth"|"new"|"this"|"!"|"Identifier"|"true"|"false"
%%
{WHITESPACE}		{printf("");}
{OP}			{printf("Operação: %s\n",yytext);}
{ATRIB}			{printf("Atribuição: %s\n",yytext);}
{TYPE}			{printf("Tipo: %s\n",yytext);}
{PR}			{printf("Palavra reservada: %s\n",yytext);}	
{DIGITO}+		{printf("Inteiro: %s\n",yytext);}
{DIGITO}+{P}+{DIGITO}+	{printf("Real: %s\n",yytext);} 
{ID}+			{printf("var: %s\n",yytext);}
{PV} 			{printf("Ponto e Virgula: %s\n",yytext);}
{ACO} 			{printf("Abre conchetes: %s\n",yytext);}
{FCO} 			{printf("Fecha conchetes: %s\n",yytext);}
{ACH} 			{printf("Abre Chaves: %s\n",yytext);}
{FCH} 			{printf("Fecha chaves: %s\n",yytext);}
{AP} 			{printf("Abre parenteses: %s\n",yytext);}
{FP} 			{printf("Fecha parenteses: %s\n",yytext);}
{P}			{printf("Ponto: %s\n", yytext);}

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}

