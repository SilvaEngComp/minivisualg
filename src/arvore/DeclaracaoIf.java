package arvore;

public class DeclaracaoIf extends Declaracao {
	public SimplesExpressao simplesExpressao;
	public Declaracao declaracao;
	
	public DeclaracaoIf(SimplesExpressao simplesExpressao,Declaracao declaracao){
		this.simplesExpressao=simplesExpressao;
		this.declaracao=declaracao;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
