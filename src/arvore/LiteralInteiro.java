package arvore;

public class LiteralInteiro extends Constante{
	public int literalInteiro;
	
	public LiteralInteiro(int literalInteiro){
		this.literalInteiro=literalInteiro;
	}

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
    
    
}
