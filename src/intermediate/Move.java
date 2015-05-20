package intermediate;

public class Move extends Stm {
  public Exp dst, src;
  
  public Move(Exp dst, Exp src){
	  this.dst=dst;
	  this.src=src;
  }
  
  public void print(){
	  dst.print();
	  src.print();
  }
}

