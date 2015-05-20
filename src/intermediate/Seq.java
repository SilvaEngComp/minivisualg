package intermediate;

public class Seq extends Stm{
  
  public Stm left, right;
  
  public Seq(Stm left, Stm right){
	  this.left=left;
	  this.right=right;
  }
  
  public void print(){
	  left.print();
	  right.print();
  }
}

