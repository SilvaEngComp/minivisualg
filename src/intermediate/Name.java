package intermediate;

public class Name extends Exp {
  
  public String label;
  
  public Name(String label){
	  this.label=label;
  }
  
  public void print(){
	  System.out.println(label);
  }
}

