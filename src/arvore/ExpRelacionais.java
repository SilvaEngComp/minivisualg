package arvore;

public class ExpRelacionais extends SimplesExpressao{
	public SimplesExpressao simplesExpressao1,simplesExpressao2;
	public OperadoresRelacionais operadoresRelacionais;
	
	public ExpRelacionais(SimplesExpressao simplesExpressao1,OperadoresRelacionais operadoresRelacionais,SimplesExpressao simplesExpressao2){
		this.simplesExpressao1=simplesExpressao1;
		this.operadoresRelacionais=operadoresRelacionais;
		this.simplesExpressao2=simplesExpressao2;
	}	

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
