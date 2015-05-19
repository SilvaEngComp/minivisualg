package arvore;

public class ExpId extends SimplesExpressao{
	public String id;
	
	public ExpId(String id){
		this.id=id;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
