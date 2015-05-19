package arvore;

/**
 *
 * @author ELIABE
 */
public class TesteVisitor {
    
    public static void main(String[] args){
         
        PrintVisitor pv = new PrintVisitor();
        ExpSoma soma = new ExpSoma(new LiteralInteiro(2), new LiteralInteiro(3));
       
        
      soma.accept(pv);
        
        
    }
}
