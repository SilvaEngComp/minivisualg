package arvore;

public class DeclaracaoEscrita extends Declaracao {
	public ListaExpressao listaExpressao;
	
	public DeclaracaoEscrita(ListaExpressao listaExpressao){
		this.listaExpressao=listaExpressao;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
