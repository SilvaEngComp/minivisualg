package arvore;

public class OpMenorIgual extends OperadoresRelacionais{
	private static OpMenorIgual tipoMenorIgual;

	private OpMenorIgual(){}
	public static OpMenorIgual getInstancia(){
		if(tipoMenorIgual==null)
			tipoMenorIgual = new OpMenorIgual();
		return tipoMenorIgual;

	}	

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
       
    }
}
