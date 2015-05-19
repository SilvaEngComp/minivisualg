package arvore;

public class OpMaior extends OperadoresRelacionais  {
	public static OpMaior tipoMaior;

	public OpMaior(){}
	public static OpMaior getInstancia(){
		if(tipoMaior==null)
			tipoMaior = new OpMaior();
		return tipoMaior;

	}	

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    
  
}
