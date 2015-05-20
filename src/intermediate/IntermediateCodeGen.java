package intermediate;
import arvore.*;

import arvore.*;
import java.util.Stack;

public abstract class IntermediateCodeGen implements Visitor {
	
	private Stack<Exp> pilhaExp;
	private Stack<Stm> pilhaStm;
	
	public IntermediateCodeGen() {
		pilhaExp = new Stack<Exp>();
		pilhaStm = new Stack<Stm>();
	}
	
	public Stm generate(Inicio p){
		visit(p);
		return pilhaStm.pop();
	}

	@Override
	public void visit(Inicio n) {

	}

	@Override
	public void visit(BlockFuncao n) {

	}

	@Override
	public void visit(TipoString n) {

	}
	
	@Override
	public void visit(TipoInt n) {

	}

	@Override
	public void visit(TipoReal n) {

	}

	@Override
	public void visit(TipoBoolean n) {

	}

	@Override
	public void visit(OpIgualdade n) {

	}
	
	@Override
	public void visit(OpDiferente n) {

	}
	
	@Override
	public void visit(OpMenorIgual n) {

	}

	@Override
	public void visit(OpMenor n) {

	}

	@Override
	public void visit(OpMaiorIgual n) {

	}

	@Override
	public void visit(OpMaior n) {

	}

	@Override
	public void visit(LiteralString n) {

	}

	@Override
	public void visit(LiteralReal n) {

	}

	@Override
	public void visit(LiteralInteiro n) {

	}
	
	@Override
	public void visit(LiteralVerdadeiro n) {

	}

	@Override
	public void visit(LiteralFalso n) {

	}

	@Override
	public void visit(ComposicaoDeclaracao n) {

	}

	@Override
	public void visit(ExpId n) {

	}
	
	@Override
	public void visit(ExpSoma n) {
		n.simplesExpressao1.accept(this);
	    Exp e1 = (Exp) pilhaExp.pop();
	    n.simplesExpressao2.accept(this);
	    Exp e2 = (Exp) pilhaExp.pop();
	    pilhaExp.push((Exp) new Binop(sym.SOMA, e1, e2));
	}

	@Override
	public void visit(ExpSubtracao n) {
		n.simplesExpressao1.accept(this);
	    Exp e1 = (Exp) pilhaExp.pop();
	    n.simplesExpressao2.accept(this);
	    Exp e2 = (Exp) pilhaExp.pop();
	    pilhaExp.push((Exp) new Binop(sym.SUBTRACAO, e1, e2));
	}
	
	@Override
	public void visit(ExpMultiplicacao n) {
		n.simplesExpressao1.accept(this);
	    Exp e1 = (Exp) pilhaExp.pop();
	    n.simplesExpressao2.accept(this);
	    Exp e2 = (Exp) pilhaExp.pop();
	    pilhaExp.push((Exp) new Binop(sym.MULTIPLICACAO, e1, e2));
	}
	
	@Override
	public void visit(ExpDivisao n) {
		n.simplesExpressao1.accept(this);
	    Exp e1 = (Exp) pilhaExp.pop();
	    n.simplesExpressao2.accept(this);
	    Exp e2 = (Exp) pilhaExp.pop();
	    pilhaExp.push((Exp) new Binop(sym.DIVISAO, e1, e2));

	}
	
	@Override
	public void visit(ExpRelacionais n) {

	}

	@Override
	public void visit(ExpOu n) {

	}

	@Override
	public void visit(ExpNao n) {

	}

	@Override
	public void visit(ExpE n) {

	}
	
	@Override
	public void visit(DeclaracaoEscrita n) {

	}
	
	@Override
	public void visit(DeclaracaoLeitura n) {

	}
	
	@Override
	public void visit(DeclaracaoAtribuicao n) {

	}

	@Override
	public void visit(DeclaracaoVariaveis n) {

	}

	@Override
	public void visit(ListaVariavel n) {

	}

	@Override
	public void visit(ListaExpressao n) {

	}

	@Override
	public void visit(ListaDeclaracao n) {

	}
	
	@Override
	public void visit(DeclaracaoIf n) {

	}
	
	@Override
	public void visit(DeclaracaoIfElse n) {

	}

	@Override
	public void visit(DeclaracaoWhile n) {

	}
	
}
