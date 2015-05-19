package arvore;

public class ListaExpressao implements Visitavel{
	public SimplesExpressao simplesExpressao;
	public ListaExpressao listaExpressao;
	
	public ListaExpressao(SimplesExpressao simplesExpressao,ListaExpressao listaExpressao){
		this.simplesExpressao=simplesExpressao;
		this.listaExpressao=listaExpressao;
	}
     
    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
