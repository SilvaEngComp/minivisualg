package arvore;

/**
 *
 * @author ELIABE
 */
public class DeclaracaoVariaveis implements Visitavel{
    
    public Tipo t;
    public ListaVariavel lv;
    public DeclaracaoVariaveis cauda;
    
    public DeclaracaoVariaveis(ListaVariavel lv, Tipo t, DeclaracaoVariaveis cauda){
        this.lv = lv;
        this.t = t;
        this.cauda = cauda;
    }

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
  
}
