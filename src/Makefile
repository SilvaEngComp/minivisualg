LEXER= Lexer.java
PARSER=parser.java
SYM=sym.java

JAVACUP=java -jar java_cup.jar
JFLEX=jflex

all:
		$(JAVACUP) parser.cup
		$(JFLEX) Lexer.flex
		javac arvore/*.java *.java
clean:
	rm -f *.class
	rm -f $(LEXER)
	rm -f $(PARSER)
	rm -f $(SYM)
	rm -f Lexer.java~

