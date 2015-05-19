package arvore;

/**
 *
 * @author ELIABE
 */
public class OpIgualdade extends OperadoresRelacionais {
    
    private static OpIgualdade tipoIgualdade;
    
    private OpIgualdade(){}
	public static OpIgualdade getInstancia(){
		if(tipoIgualdade==null)
			tipoIgualdade = new OpIgualdade();
		return tipoIgualdade;

	}	
        
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
