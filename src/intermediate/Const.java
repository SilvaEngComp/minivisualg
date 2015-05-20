package intermediate;
import arvore.*;

public class Const extends Exp {
	
	private int i;
	private float r;
	private String s;
	
	public Const(int i){
		this.i = i;
	}
	public Const(float r){
		this.r = r;
	}
	public Const(String s){
		this.s = s;
	}
	
	public void print(){
		System.out.println(i);
	}
	
}
