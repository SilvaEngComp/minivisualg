package intermediate;

import arvore.Visitor;

public class Binop extends Exp {

	private int op;
	private ExpStm e1, e2;

	public Binop(int op, ExpStm e1, ExpStm e2) {
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
		case sym.IGUAL:
			return "=";
		case sym.DIFERENTE:
			return "<>";
		case sym.MAIOR:
			return ">";
		case sym.MENOR:
			return "<";
		case sym.MAIORIGUAL:
			return ">=";
		case sym.MENORIGUAL:
			return "<=";
		case sym.NAO:
			return "NÃO";
		default:
			return null;
			
		}
	}

	@Override
	public void accept(Visitor visitor) {
		//visitor.visit(this);
		/*
		 * Como implemntar?
		 */
	}

}
