package arvore;

public class OpMaiorIgual extends OperadoresRelacionais {
	private static OpMaiorIgual tipoMaiorIgual;

	private OpMaiorIgual(){}
	public static OpMaiorIgual getInstancia(){
		if(tipoMaiorIgual==null)
			tipoMaiorIgual = new OpMaiorIgual();
		return tipoMaiorIgual;

	}	

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        
    }
}
