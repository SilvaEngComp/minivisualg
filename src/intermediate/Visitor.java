package intermediate;
import  arvore.*;

public interface Visitor{
	
	/*
	 * Pode apagar esses métodos?
	 * Se sim, apagar o import arvore;
	 */
	
	public void visit(Inicio n);
	
    public void visit(BlockFuncao n) ;
    
    public void visit(TipoString n);
    
    public void visit(TipoReal n);

    public void visit(TipoBoolean n);
    
    public void visit(OpMenorIgual n);
    
    public void visit(OpMenor n);

    public void visit(OpMaiorIgual n);
    
    public void visit(OpMaior n);
   
    public void visit(LiteralString n);
   
    public void visit(LiteralReal n);
    
    public void visit(LiteralInteiro n);
   
    public void visit(TipoInt n);
   
    public void visit(OpIgualdade n);
    
    public void visit(ComposicaoDeclaracao n);
    
    public void visit(ExpSoma n);
    
    public void visit(ExpId n);
    
    public void visit(OpDiferente n);
    
    public void visit(DeclaracaoVariaveis n);
    
    public void visit(LiteralVerdadeiro n);
    
    public void visit(LiteralFalso n) ;
    
    public void visit(ListaVariavel n);
    
    public void visit(ListaExpressao n);
    
    public void visit(ListaDeclaracao n);
    
    public void visit(ExpSubtracao n);
    
    public void visit(ExpRelacionais n);
    
    public void visit(ExpOu n);
    
    public void visit(ExpNao n);
    
    public void visit(ExpMultiplicacao n);
    
    public void visit(ExpE n);
    
    public void visit(ExpDivisao n);
    
    public void visit(DeclaracaoWhile n);
    
    public void visit(DeclaracaoLeitura n);
    
    public void visit(DeclaracaoIfElse n);
    
    public void visit(DeclaracaoIf n);
    
    public void visit(DeclaracaoEscrita n);
    
    public void visit(DeclaracaoAtribuicao n);

	/*
	 * Novos visits para a geração de código intemediário
	 */

	public void visit(Binop binop);
	
	public void visit(Const ct);

} 
