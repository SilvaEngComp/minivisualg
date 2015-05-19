import arvore.*; 
import java.io.*;

public class Minivisualg{ 

	static public void main(String argv[]) throws Exception { 

		parser p = new parser( new Lexer(new FileReader(argv[0]) ));
		//p.parse();

		Inicio prog = (Inicio) p.parse().value;
		//prog.print();
		
		TypeCheckerVisitor checker = new TypeCheckerVisitor();
		boolean checagem = checker.check(prog);

		if (!checagem)
			System.out.println("Compilação finalizada com erros!");
		if (checagem){
			// Equivlente ao visitor
			IntermediateCodeGen t = new IntermediateCodeGen();
			Stm s = t.generate(prog);
			s.print();
			
		}


	}
}
