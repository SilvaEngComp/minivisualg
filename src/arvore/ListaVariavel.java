package arvore;

/**
 *
 * @author ELIABE
 */
public class ListaVariavel implements Visitavel{
    public String id;
    public ListaVariavel cauda;
    
    public ListaVariavel(String id, ListaVariavel cauda){
        this.id = id;
        this.cauda = cauda;
    }

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
    
    
}
