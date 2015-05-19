package arvore;

public class DeclaracaoIfElse extends Declaracao{
	public SimplesExpressao simplesExpressao;
	public Declaracao declaracao1,declaracao2;
  
	public DeclaracaoIfElse(SimplesExpressao simplesExpressao,Declaracao declaracao1,Declaracao declaracao2){
		this.simplesExpressao=simplesExpressao;
		this.declaracao1=declaracao1;
		this.declaracao2=declaracao2;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
