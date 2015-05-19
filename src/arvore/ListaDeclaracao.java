package arvore;

public class ListaDeclaracao implements Visitavel{
	public Declaracao declaracao;
	public ListaDeclaracao listaDeclaracao;
	
	
	public ListaDeclaracao(Declaracao declaracao, ListaDeclaracao listaDeclaracao){
		this.listaDeclaracao=listaDeclaracao;
		this.declaracao=declaracao;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
        
     
}
