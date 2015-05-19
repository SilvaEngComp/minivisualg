package intermediate;

import arvore.Visitor;

public class Const extends Exp {
	private int value;
	public Const(int value){
		this.value = value;
	}
	
	public void print(){
		/*
		 * Como implementar?
		 */
		System.out.println(value);
	}
	
	@Override
	public void accept(Visitor visitor) {
		/*
		 * Como implementar?
		 */

	}

}
