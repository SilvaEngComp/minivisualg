package arvore;

public class OpDiferente extends OperadoresRelacionais {
	private static OpDiferente tipoDiferente;

	private OpDiferente(){}
	public static OpDiferente getInstancia(){
		if(tipoDiferente==null)
			tipoDiferente = new OpDiferente();
		return tipoDiferente;

	}	

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
