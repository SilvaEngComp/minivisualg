package arvore;

public class TipoInt extends Tipo {
	private static TipoInt tipoInt;

	private TipoInt(){}
	public static TipoInt getInstancia(){
		if(tipoInt==null)
			tipoInt = new TipoInt();
		return tipoInt;

	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
        
}
