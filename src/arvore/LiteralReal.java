package arvore;

public class LiteralReal extends Constante{
	public double literalReal;
	
	public LiteralReal(double literalReal){
		this.literalReal=literalReal;
	}
        
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
