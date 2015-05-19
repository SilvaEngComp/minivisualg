package arvore;


public class ExpSoma extends SimplesExpressao {
	public SimplesExpressao simplesExpressao1,simplesExpressao2;
	
  
	public ExpSoma(SimplesExpressao simplesExpressao1,SimplesExpressao simplesExpressao2){
		this.simplesExpressao1=simplesExpressao1;
		this.simplesExpressao2=simplesExpressao2;
	}

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
		
}
