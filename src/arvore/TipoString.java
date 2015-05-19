package arvore;

public class TipoString extends Tipo {
	private static TipoString tipoString;
	private TipoString(){}
	public static TipoString getInstancia(){
		if(tipoString==null)
			tipoString=new TipoString();
		return tipoString;
	}	

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        
    }
}
