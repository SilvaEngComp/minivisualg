package intermediate;

import java.util.Stack;

import arvore.BlockFuncao;
import arvore.ComposicaoDeclaracao;
import arvore.DeclaracaoAtribuicao;
import arvore.DeclaracaoEscrita;
import arvore.DeclaracaoIf;
import arvore.DeclaracaoIfElse;
import arvore.DeclaracaoLeitura;
import arvore.DeclaracaoVariaveis;
import arvore.DeclaracaoWhile;
import arvore.ExpDivisao;
import arvore.ExpE;
import arvore.ExpId;
import arvore.ExpMultiplicacao;
import arvore.ExpNao;
import arvore.ExpOu;
import arvore.ExpRelacionais;
import arvore.ExpSoma;
import arvore.ExpSubtracao;
import arvore.Inicio;
import arvore.ListaDeclaracao;
import arvore.ListaExpressao;
import arvore.ListaVariavel;
import arvore.LiteralFalso;
import arvore.LiteralInteiro;
import arvore.LiteralReal;
import arvore.LiteralString;
import arvore.LiteralVerdadeiro;
import arvore.OpDiferente;
import arvore.OpIgualdade;
import arvore.OpMaior;
import arvore.OpMaiorIgual;
import arvore.OpMenor;
import arvore.OpMenorIgual;
import arvore.Tipo;
import arvore.TipoBoolean;
import arvore.TipoInt;
import arvore.TipoReal;
import arvore.TipoString;
import arvore.Visitor;

public abstract class IntermediateCodeGen implements Visitor {
	
	private Stack<Exp> pilha;
	
	public IntermediateCodeGen() {
		pilha = new Stack<Exp>();
	}
	
	public Stm generate(Inicio p){
		visit(p);
		/*
		 * Dúvida aqui. 
		 */
		return (Stm) pilha.pop();
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
	public void visit(TipoReal n) {

	}

	@Override
	public void visit(TipoBoolean n) {

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
	public void visit(TipoInt n) {

	}

	@Override
	public void visit(OpIgualdade n) {

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
	    Exp e1 = (Exp) pilha.pop();
	    n.simplesExpressao2.accept(this);
	    Exp e2 = (Exp) pilha.pop();
	    pilha.push(new Binop(sym.SOMA, e1, e2));
	}

	@Override
	public void visit(OpDiferente n) {

	}

	@Override
	public void visit(DeclaracaoVariaveis n) {

	}

	@Override
	public void visit(LiteralVerdadeiro n) {

	}

	@Override
	public void visit(LiteralFalso n) {

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
	public void visit(ExpSubtracao n) {

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
	public void visit(ExpMultiplicacao n) {

	}

	@Override
	public void visit(ExpE n) {

	}

	@Override
	public void visit(ExpDivisao n) {

	}

	@Override
	public void visit(DeclaracaoWhile n) {

	}

	@Override
	public void visit(DeclaracaoLeitura n) {

	}

	@Override
	public void visit(DeclaracaoIfElse n) {

	}

	@Override
	public void visit(DeclaracaoIf n) {

	}

	@Override
	public void visit(DeclaracaoEscrita n) {

	}

	@Override
	public void visit(DeclaracaoAtribuicao n) {

	}

}
