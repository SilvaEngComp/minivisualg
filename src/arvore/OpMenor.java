package arvore;

public class OpMenor extends OperadoresRelacionais  {
	private static OpMenor tipoMenor;

	private OpMenor(){}
	public static OpMenor getInstancia(){
		if(tipoMenor==null)
			tipoMenor = new OpMenor();
		return tipoMenor;

	}	

    @Override
    public void accept(Visitor visitor) {
        
        visitor.visit(this);
        
    }
}
