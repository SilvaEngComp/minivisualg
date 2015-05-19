package arvore;

public class LiteralString extends Constante{
	public String literalString;
	
	public LiteralString(String literalString){
		this.literalString=literalString;
	}

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }

}
