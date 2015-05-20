package intermediate;

public class Cjump extends Stm {
  public int relop;
  public Exp left, right;
  public String iftrue, iffalse;
  
  public Cjump(int relop, Exp left, Exp right, String iftrue, String iffalse) {
     this.relop=relop;
     this.left=left;
     this.right=right;
     this.iftrue=iftrue;
     this.iffalse=iffalse;
  }
  
 public void print(){
	 left.print();
	 System.out.println(stmToOp(relop));
	 right.print();
	 System.out.println(iftrue);
	 System.out.println(iffalse);
 }
 
  private String stmToOp (int relop) {
    switch (relop) {
    case sym.IGUAL:
    	return "=";
    case sym.DIFERENTE:
    	return "<>";
	case sym.MENOR:
		return "<";
	case sym.MAIOR:
		return ">";
	case sym.MENORIGUAL:  
		return "<=";
	case sym.MAIORIGUAL:  
		return ">=";
	case sym.ATRIBUICAO: 
		return "<-";
	default:
		return null;
    }
  }
}

