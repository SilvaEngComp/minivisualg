package arvore;


public class TipoBoolean extends Tipo {
	private static TipoBoolean tipoBoolean;
	private TipoBoolean(){}
	public static TipoBoolean getInstancia(){
		if(tipoBoolean==null)
			tipoBoolean=new TipoBoolean();
		return  tipoBoolean;
	}
   	public void accept(Visitor visitor){}   

}
