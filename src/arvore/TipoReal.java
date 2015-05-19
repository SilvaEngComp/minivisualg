package arvore;

public class TipoReal extends Tipo {
	private static TipoReal tipoReal;
	private TipoReal(){}
	public static TipoReal getInstancia(){
		if(tipoReal==null)
			tipoReal = new TipoReal();
		return tipoReal;
	}	

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
