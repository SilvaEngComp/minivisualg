package arvore;

public class ComposicaoDeclaracao extends Declaracao{
  public ListaDeclaracao ld;
  public ComposicaoDeclaracao(ListaDeclaracao l){
    ld = l;
  }

  public void accept(Visitor v){
    v.visit(this);
  } 
}
