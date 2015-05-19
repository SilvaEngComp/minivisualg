package arvore;

public class DeclaracaoAtribuicao extends Declaracao  {
	public String id;
	public SimplesExpressao simplesExpressao;

	public  DeclaracaoAtribuicao(String id, SimplesExpressao simplesExpressao){
		this.id=id;
		this.simplesExpressao=simplesExpressao;
	}

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
