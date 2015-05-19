package intermediate;

import arvore.Visitor;

public class Const extends Exp {
	private int i;
	public Const(int i){
		this.i = i;
	}
	
	public void print(){
		/*
		 * Como implementar?
		 */
		System.out.println(i);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		/*
		 * Como implementar?
		 */

	}

}
