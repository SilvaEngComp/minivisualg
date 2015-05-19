package arvore;

public class DeclaracaoWhile extends Declaracao{
	public SimplesExpressao simplesExpressao;
	public Declaracao declaracao;
	
        
	public DeclaracaoWhile(SimplesExpressao simplesExpressao,Declaracao declaracao){
		this.simplesExpressao=simplesExpressao;
		this.declaracao=declaracao;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
