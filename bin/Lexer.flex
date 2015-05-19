/* JFlex example: part of Java language lexer specification */

import java_cup.runtime.*;

/**
* This class is a simple example lexer.
*/

%%
%class Lexer
%unicode
%cup
%line
%column
// Definição do case insensitive
%ignorecase
%{
	StringBuffer string = new StringBuffer();
	private Symbol symbol(int type) { return new Symbol(type,yyline, yycolumn);}
	private Symbol symbol(int type, Object value) {return new Symbol(type, yyline, yycolumn, value);}
%}
// Definição das expressões regulares básicas para o funcionamento
	letra = [a-zA-Z]
	digito = [0-9]
	id = {letra} ({letra} | {digito})*
	literal_inteiro = {digito}+
	literal_real = {digito}+ "." {digito}* | {digito}* "." {digito}+
	abrechave       = \{
	fechachave      = \}
	semchavedireita   = [^}]
	corpo_comentario    = {semchavedireita}*
	commentario         = {abrechave}{corpo_comentario}{fechachave}
	espacobranco      = [ \n\t]
	literal_cadeia = "'" ([^'\n] | "\\'")* "'"
%state STRING
%%
	/* Definição dos tokens utilizados na linguagem*/	
	<YYINITIAL>	"SE" {return symbol(sym.SE); }
	<YYINITIAL>	"OU" { return symbol(sym.OU); }
	<YYINITIAL> "E" { return symbol(sym.E); }
	<YYINITIAL> "NÃO" { return symbol(sym.NAO); }
	<YYINITIAL>	"ENTÃO" { return symbol(sym.ENTAO); }
	<YYINITIAL>	"SENÃO" { return symbol(sym.SENAO);}
	<YYINITIAL>	"ENQUANTO" { return symbol(sym.ENQUANTO);}
	<YYINITIAL>	"FAÇA" { return symbol(sym.FACA);}
	<YYINITIAL>	"INÍCIO" { return symbol(sym.INICIO); }
	<YYINITIAL>	"FIM" { return symbol(sym.FIM); }
	<YYINITIAL>	"LEIA" { return symbol(sym.LEIA); }
	<YYINITIAL>	"ESCREVA" { return symbol(sym.ESCREVA);}
	<YYINITIAL>	"VAR" { return symbol(sym.VAR); }
	<YYINITIAL>	"PROGRAMA" { return symbol(sym.PROGRAMA); }
	<YYINITIAL>	"VERDADEIRO" { return symbol(sym.VERDADEIRO); }
	<YYINITIAL>	"FALSO" { return symbol(sym.FALSO); }
	<YYINITIAL>	"REAL" {return symbol(sym.REAL); }
	<YYINITIAL>	"CADEIA" {return symbol(sym.CADEIA); }
	<YYINITIAL>	"INTEIRO" {return symbol(sym.INTEIRO); }
	<YYINITIAL>	"BOOLEANO" { return symbol(sym.BOOLEANO); }
	
	<YYINITIAL> {

		/* operators */
		"+" { return symbol(sym.SOMA); }
		"-" { return symbol(sym.SUBTRACAO); }
		"*" { return symbol(sym.MULTIPLICACAO); }
		"/" { return symbol(sym.DIVISAO); }
		"<>" { return symbol(sym.DIFERENTE); }
		"<" { return symbol(sym.MENOR); }
		">" { return symbol(sym.MAIOR); }
		"<=" { return symbol(sym.MENORIGUAL); }
		">=" { return symbol(sym.MAIORIGUAL); }
		"<-" { return symbol(sym.ATRIBUICAO); }
		"=" { return symbol(sym.IGUAL); }
		":" { return symbol(sym.DOISPONTOS); }
		";" { return symbol(sym.PONTOVIRGULA); }
		"," { return symbol(sym.VIRGULA); }
		"(" { return symbol(sym.PARENTESEESQUERDO); }
		")" { return symbol(sym.PARENTESEDIREITO); }
		"." { return symbol(sym.PONTO); }
		/* Definição do identificador, valores reais de (inteiro, real, cadeia) e operadores e simbolos  */
		{id} { return symbol(sym.ID,new String(yytext())); }
		{literal_inteiro} { return symbol(sym.LITERAL_INTEIRO,new Integer(yytext())); }
		{literal_real} { return symbol(sym.LITERAL_REAL,new Double(yytext()) ); }
		{literal_cadeia} {return symbol(sym.LITERAL_CADEIA,new String(yytext()));}

		/*Coment*/
		{commentario} {/* Ignorar comentário. */}
		{espacobranco}    { /* Ignorar espaço em branco. */ }
	}
	
	<<EOF>> {return symbol(sym.EOF);}
/* erro */
.  { System.out.println("Caractere Ilegal, '" + yytext() + "' linha: " + yyline + ", coluna: " + yychar); }
