package arvore;

public class LiteralVerdadeiro extends Constante {
	private static LiteralVerdadeiro tipoBoolean;
	private LiteralVerdadeiro(){}
        
	public static LiteralVerdadeiro getInstancia(){
		if(tipoBoolean==null)
			tipoBoolean=new LiteralVerdadeiro();
		return  tipoBoolean;
	}	
        
    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
