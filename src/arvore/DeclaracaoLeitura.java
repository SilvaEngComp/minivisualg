package arvore;

public class DeclaracaoLeitura extends Declaracao{
	public ListaVariavel listaVariavel;
	
	public DeclaracaoLeitura(ListaVariavel listaVariavel){
		this.listaVariavel=listaVariavel;
	}
        

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
