package arvore;

public class LiteralFalso extends Constante {
	private static LiteralFalso tipoBoolean;
	private LiteralFalso(){}
        
	public static LiteralFalso getInstancia(){
		if(tipoBoolean==null)
			tipoBoolean=new LiteralFalso();
		return  tipoBoolean;
	}	
        
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

  
}
