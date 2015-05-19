import arvore.*;
import java.util.HashMap;
import java.util.Stack;

public class TypeCheckerVisitor implements Visitor{

	/*
	 * Atributos:
	 * ok - variável de retorno
	 * pilha - pilha de tipos
	 * Table - tabela de tipos
	 */
	private boolean ok; 
	private Stack<Tipo> pilha;
	public HashMap<String, Tipo> table;

	/*
	 * Método construtor: inicializa as variáveis;
	 */
	public TypeCheckerVisitor(){
		ok = true; 
		pilha = new Stack<Tipo>();
		table = new HashMap<String, Tipo>();
	}

	/*
	 * método check: inicia a checagem
	 */
	boolean check(Inicio prog){
		visit(prog);
		return ok;
	}

	/*===========================================
	 * 
	 *  Visits
	 * 
	 * ==========================================
	 */
	@Override
	public void visit(Inicio n) {
		visit((BlockFuncao)n.block);

	}
	
	@Override
	public void visit(BlockFuncao n) {
    if (n.declaracaoVariaveis != null)
		  visit(n.declaracaoVariaveis);
		visit( (ComposicaoDeclaracao) n.composicaoDeclaracao);

	}
	
	@Override
	public void visit(TipoString n) {}

	@Override
	public void visit(TipoInt n) {}

	@Override
	public void visit(TipoReal n) {}

	@Override
	public void visit(TipoBoolean n) {}

	@Override
	public void visit(OpMenorIgual n) {}

	@Override
	public void visit(OpMenor n) {}

	@Override
	public void visit(OpMaiorIgual n) {}

	@Override
	public void visit(OpMaior n) {}

	@Override
	public void visit(OpIgualdade n) {}

	@Override
	public void visit(OpDiferente n) {}

	@Override
	public void visit(LiteralString n) {
		pilha.push(TipoString.getInstancia());
	}

	@Override
	public void visit(LiteralReal n) {
		pilha.push(TipoReal.getInstancia());
	}

	@Override
	public void visit(LiteralInteiro n) {
		pilha.push(TipoInt.getInstancia());	
	}

	@Override
	public void visit(LiteralFalso n) {
		pilha.push(TipoBoolean.getInstancia());
	}

	@Override
	public void visit(LiteralVerdadeiro n){
		pilha.push(TipoBoolean.getInstancia());
	}

	@Override
	public void visit(ExpId n) {
		Tipo t = table.get(n.id);
		if (t == null){
			System.out.println("Variável "+n.id+" não foi declarada.");
			printTypeErro(null,null,n);
		}
		pilha.push(t);

	}

	@Override
	public void visit(DeclaracaoVariaveis n) {
		ListaVariavel v = n.lv;
		while(v != null){
			table.put(v.id, n.t);
			v = v.cauda;
		}

		if(n.cauda != null)
			visit(n.cauda);

	}

	@Override
	public void visit(ListaVariavel n) {
		Tipo t = table.get(n.id);
		if (t == null){
			System.out.println("Variável "+n.id+" não foi declarada.");
			printTypeErro(null,null,n);
		}
		if(n.cauda != null){
			visit(n.cauda);
		}
	}

	@Override
	public void visit(ListaExpressao n) {
		ListaExpressao le = n.listaExpressao;
		n.simplesExpressao.accept(this);
		if(n.listaExpressao != null){
			visit(n.listaExpressao);
		}
	}

	@Override
	public void visit(ListaDeclaracao n) {
		ListaDeclaracao ld = n.listaDeclaracao;
		n.declaracao.accept(this);
		if(n.listaDeclaracao != null){
			visit(n.listaDeclaracao);
		}

	}

	@Override
	public void visit(ExpRelacionais n) {
		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = pilha.pop();
		Tipo t3;
		if (n.operadoresRelacionais instanceof OpIgualdade){
			t3 = resultTypeEquals(t1, t2);
		}
		else{
			t3 = resultTypeRelational(t1, t2);
		}
		pilha.push(t3);
		if( t3 == null){
			printTypeErro(t1, t2, n);
		}		
	}

	@Override
	public void visit(ExpE n) {
		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = pilha.pop();
		Tipo t3 = resultTypeBoolean(t1,t2);
		if(t3 == null){
			printTypeErro(t1, t2, n);	
		}

	}

	@Override
	public void visit(ExpOu n) {
		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = pilha.pop();
		Tipo t3 = resultTypeBoolean(t1,t2);
		if(t3 == null){
			printTypeErro(t1, t2, n);	
		}
	}

	@Override
	public void visit(ExpNao n) {
		n.simplesExpressao.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = resultTypeBoolean(t1);
		pilha.push(t2);
		if(t2 == null){
			printTypeErro(t1, t2, n);	
		}
	}

	@Override
	public void visit(ExpSoma n) {
		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = pilha.pop();
		Tipo t3 = resultTypeAritmetic(t1, t2);
		pilha.push(t3);
		if( t3 == null){
			printTypeErro(t1, t2, n);	
		}
	}

	@Override
	public void visit(ExpSubtracao n) {
		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = pilha.pop();
		Tipo t3 = resultTypeAritmetic(t1, t2);
		pilha.push(t3);
		if( t3 == null){
			printTypeErro(t1, t2, n);	
		}
	}

	@Override
	public void visit(ExpMultiplicacao n) {
		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = pilha.pop();
		Tipo t3 = resultTypeAritmetic(t1, t2);
		pilha.push(t3);
		if( t3 == null){
			printTypeErro(t1, t2, n);

		}
	}

	@Override
	public void visit(ExpDivisao n) {
		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
		Tipo t1 = pilha.pop();
		Tipo t2 = pilha.pop();
		Tipo t3 = resultTypeAritmetic(t1, t2);
		pilha.push(t3);
		if( t3 == null){
			printTypeErro(t1, t2, n);
		}
	}

	@Override
	public void visit(ComposicaoDeclaracao n) {
		visit(n.ld);
	}
	
	@Override
	public void visit(DeclaracaoLeitura n) {
    if (n.listaVariavel != null)
  		visit(n.listaVariavel); 
	}
	
	@Override
	public void visit(DeclaracaoEscrita n) {
    if (n.listaExpressao != null)
		  visit(n.listaExpressao);
	}

	@Override
	public void visit(DeclaracaoIf n) {
		n.simplesExpressao.accept(this);
		Tipo t = pilha.pop();
		if (!(t instanceof TipoBoolean)){
			printTypeErro(t,null,n);
		}
		n.declaracao.accept(this);
	}
	
	@Override
	public void visit(DeclaracaoIfElse n) {
		n.simplesExpressao.accept(this);
		Tipo t = pilha.pop();
		if (!(t instanceof TipoBoolean)){
			printTypeErro(t,null,n);
		}
		n.declaracao1.accept(this);
		n.declaracao2.accept(this);
	}
	
	@Override
	public void visit(DeclaracaoWhile n) {
		n.simplesExpressao.accept(this);
		Tipo t = pilha.pop();
		if (!(t instanceof TipoBoolean)){
			printTypeErro(t,null,n);
		}
		n.declaracao.accept(this);	
	}

	@Override
	public void visit(DeclaracaoAtribuicao n) {
		n.simplesExpressao.accept(this);
		Tipo t1 = table.get(n.id);
		Tipo t2 = pilha.pop();
		if (t1 == null){
			System.out.println("Variável "+n.id+" não foi declarada.");
			printTypeErro(null,null,n);
		}
		if (!typeAssignment(t1,t2)){
			printTypeErro(t1,t2,n);
		}
	}
	
	/*
	 * Verifica se uma atrbuição é possível
	 * 
	 */
	public boolean typeAssignment(Tipo t1, Tipo t2){
		if (t1==t2){
			return true;
		}
		else if ((t1 instanceof TipoReal) && (t2 instanceof TipoInt)){
			return true;
		}
		else{
			return false;
		}
	}

	/*
	 * Retorna o tipo de uma expressão aritimética
	 * com base nos seus operando
	 */
	public Tipo resultTypeAritmetic(Tipo t1, Tipo t2){
		if (t1 instanceof TipoString || t2 instanceof TipoString){
			return null;
		}
		if (t1 instanceof TipoBoolean || t2 instanceof TipoBoolean){
			return null;
		}
		if (t1==t2){
			return t1;
		}
		else if ((t1 instanceof TipoReal) && (t2 instanceof TipoInt)){
			return t1;
		}
		else if ((t2 instanceof TipoReal) && (t1 instanceof TipoInt)){
			return t2;
		}
		else{
			return null;
		}
	}

	/*
	 * Retorna o tipo de uma expressão relacional
	 * com base nos seus operando
	 */
	public Tipo resultTypeEquals(Tipo t1, Tipo t2){
		if ((t1==t2) && (t1 instanceof TipoString))
			return TipoBoolean.getInstancia();
		else if ((t1==t2) && (t1 instanceof TipoBoolean))
			return TipoBoolean.getInstancia();
		else
			return resultTypeRelational(t1,t2);
	}

	/*
	 * Retorna o tipo de uma expressão relacional
	 * com base nos seus operando
	 */
	public Tipo resultTypeRelational(Tipo t1, Tipo t2){
		if (t1 instanceof TipoString || t2 instanceof TipoString)
			return null;
		if (t1 instanceof TipoBoolean || t2 instanceof TipoBoolean)
			return null;
		if (t1==t2)
			return TipoBoolean.getInstancia();
		else if ((t1 instanceof TipoReal) && (t2 instanceof TipoInt))
			return TipoBoolean.getInstancia();
		else if ((t2 instanceof TipoReal) && (t1 instanceof TipoInt))
			return TipoBoolean.getInstancia();
		else
			return null;
	}

	/*
	 * Retorna o tipo de uma expressão booleana
	 *
	 */
	public Tipo resultTypeBoolean(Tipo t1, Tipo t2){
		if ((t1==t2) && (t1 instanceof TipoBoolean))
			return t1;
		else
			return null;	
	}

	public Tipo resultTypeBoolean(Tipo t1){
		if (t1 instanceof TipoBoolean)
			return t1;
		else
			return null;	
	}


	/*
	 *  Equivalente: compara dois tipos e retorna
	 *  true se os tipos forem equivalentes ou false
	 *  se os tipos forem diferentes
	 */
	private boolean equivalent(Tipo t1, Tipo t2){

		if (t1 == t2){
			return true;
		}
		else{
			return false;
		}

	}
	/*
	 * Erro: Imprime a mensagem de erro identificando
	 * o tipo de cada variável
	 */
	private void printTypeErro(Tipo t1, Tipo t2, Object ob){
		String type1 = getTypeString(t1);
		String type2 = getTypeString(t2);
		ok = false;

		System.out.println("ERRO: Tipos incompatíveis: Tipo: "+type1+", Tipo: "+type2+" Objeto: "+ob.toString());

	}
	/*
	 * getType: Retorna uma string com o nome
	 * do tipo de dado de uma variável
	 */
	private String getTypeString(Tipo t){
		if (t instanceof TipoInt)
			return "INTEIRO";
		else if (t instanceof TipoReal)
			return "REAL";
		else if (t instanceof TipoBoolean)
			return "BOOLEANO";
		else if (t instanceof TipoString)
			return "CADEIA";
		else
			return "TIPO INVÁLIDO";
	}

}
