package intermediate;

public class Eseq extends Exp {
	
  public Stm stm;
  public Exp exp;
  
  public Eseq(Stm stm, Exp exp){
	  this.stm=stm;
	  this.exp=exp;
  }
  
  public void print(){
	  stm.print();
	  exp.print();
  }
}

