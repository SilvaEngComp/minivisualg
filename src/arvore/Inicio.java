package arvore;

public class Inicio {
	
	public String id;
	public Block block;
	
	public Inicio(String id,Block block){
		this.id=id;
		this.block=block;
	}
        
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
	
	public void print(){
		//visit(new PrintVisitor());
		accept(new PrintVisitor());
	}
}
