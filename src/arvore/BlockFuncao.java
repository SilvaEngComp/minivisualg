package arvore;


public class BlockFuncao extends Block{
	public DeclaracaoVariaveis declaracaoVariaveis;
	public Declaracao composicaoDeclaracao;
	
	public BlockFuncao(DeclaracaoVariaveis declaracaoVariaveis,Declaracao composicaoDeclaracao){
		this.declaracaoVariaveis=declaracaoVariaveis;
		this.composicaoDeclaracao=composicaoDeclaracao;	
	}
 
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
