package intermediate;
import arvore.*;;

public class Binop extends Exp {

	private int op;
	private Exp e1, e2;

	public Binop(int op, Exp e1, Exp e2) {
		this.op = op;
		this.e1 = e1;
		this.e2 = e2;

	}
	
	public void print(){
		
		e1.print();
		System.out.println(symToOp(op));
		e2.print();
	}
	
	public String symToOp(int op){
		switch (op){
		case sym.SOMA:
			return "+";
		case sym.SUBTRACAO:
			return "-";
		case sym.MULTIPLICACAO:
			return "*";
		case sym.DIVISAO:
			return "/";
		case sym.E:
			return "e";
		case sym.OU:
			return "ou";
		case sym.XOU:
			return "=";
		case sym.NAO:
			return "NAO";
		default:
			return null;
			
		}
	}


}
