/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

/**
 *
 * @author ELIABE
 */
public class PrintVisitor implements Visitor{
    
    public PrintVisitor(){
        
    }

	@Override
    public void visit(ComposicaoDeclaracao n) {
       System.out.println("Classe Visitada= "+n.toString());
       if (n.ld != null)
		 n.ld.accept(this);
    }


    @Override
    public void visit(ExpSoma n) {
        System.out.println("Classe Visitada= "+n.toString());
       n.simplesExpressao1.accept(this);
       n.simplesExpressao2.accept(this);
    
    }

    @Override
    public void visit(TipoString n) {
        System.out.println("Classe Visitada= "+n.toString());
    }

    @Override
    public void visit(TipoBoolean n) {
        System.out.println("Classe Visitada= "+n.toString()); 
    }

    @Override
    public void visit(TipoReal n) {
        System.out.println("Classe Visitada= "+n.toString());
        
       
    }

    @Override
    public void visit(OpMenorIgual n) {
        System.out.println("Classe Visitada= "+n.toString());
     
    }

    @Override
    public void visit(OpMenor n) {
        System.out.println("Classe Visitada= "+n.toString());
       
    }

    @Override
    public void visit(OpMaiorIgual n) {
        System.out.println("Classe Visitada= "+n.toString());
       
    }

    @Override
    public void visit(OpMaior n) {
        System.out.println("Classe Visitada= "+n.toString());
        
    }

    @Override
    public void visit(LiteralString n) {
        System.out.println("Classe Visitada= "+n.toString());
        System.out.println("Atributo= "+n.literalString);
      
    }

    @Override
    public void visit(LiteralReal n) {
        System.out.println("Classe Visitada= "+n.toString());
        System.out.println("Atributo= "+n.literalReal);
       
    }

    @Override
    public void visit(LiteralInteiro n) {
        System.out.println("Classe Visitada= "+n.toString());
        System.out.println("Atributo= "+n.literalInteiro);
       
    }

    @Override
    public void visit(TipoInt n) {
        System.out.println("Classe Visitada= "+n.toString());
        
    }

    @Override
    public void visit(OpIgualdade n) {
        System.out.println("Classe Visitada= "+n.toString());
       
    }

    @Override
    public void visit(ExpId n) {
        System.out.println("Classe Visitada= "+n.toString());
		System.out.println("Atributo= "+n.id);
       
    }

    @Override
    public void visit(OpDiferente n) {
        System.out.println("Classe Visitada= "+n.toString());
    
    }

    @Override
    public void visit(DeclaracaoVariaveis n) {
        System.out.println("Classe Visitada= "+n.toString());
       n.t.accept(this);
       n.lv.accept(this);
       if (n.cauda != null)
         n.cauda.accept(this);
    }

    @Override
    public void visit(LiteralVerdadeiro n) {
        System.out.println("Classe Visitada= "+n.toString());
      
    }


    @Override
    public void visit(LiteralFalso n) {
		System.out.println("Classe Visitada= "+n.toString());
        
    }

    @Override
    public void visit(ListaVariavel n) {
       System.out.println("Classe Visitada= "+n.toString());
       System.out.println("Atributo = "+n.id);
       if (n.cauda != null)
         n.cauda.accept(this);
    }

    @Override
    public void visit(ListaExpressao n) {
        System.out.println("Classe Visitada= "+n.toString());
       n.simplesExpressao.accept(this);
	   if (n.listaExpressao != null)
       	 n.listaExpressao.accept(this);
    }

    @Override
    public void visit(ListaDeclaracao n) {
        System.out.println("Classe Visitada= "+n.toString());
        n.declaracao.accept(this);
        if (n.listaDeclaracao != null)
          n.listaDeclaracao.accept(this); 
    }


    @Override
    public void visit(Inicio n) {
        System.out.println("Classe Visitada= "+n.toString());
        System.out.println("Atributo = "+n.id);
        n.block.accept(this);
        
      
    }

    @Override
    public void visit(ExpSubtracao n) {
        System.out.println("Classe Visitada= "+n.toString());
        n.simplesExpressao1.accept(this);
        n.simplesExpressao2.accept(this);
       
    
    }

    @Override
    public void visit(ExpRelacionais n) {
        System.out.println("Classe Visitada= "+n.toString());
      n.operadoresRelacionais.accept(this);
      n.simplesExpressao1.accept(this);
      n.simplesExpressao2.accept(this);
    }

    @Override
    public void visit(ExpOu n) {
        System.out.println("Classe Visitada= "+n.toString());
        n.simplesExpressao1.accept(this);
        n.simplesExpressao2.accept(this);
    }

    @Override
    public void visit(ExpNao n) {
        System.out.println("Classe Visitada= "+n.toString());
       n.simplesExpressao.accept(this);
       
       
    }

    @Override
    public void visit(ExpMultiplicacao n) {
        System.out.println("Classe Visitada= "+n.toString());
        n.simplesExpressao1.accept(this);
        n.simplesExpressao2.accept(this);
    }

    @Override
    public void visit(ExpE n) {
        System.out.println("Classe Visitada= "+n.toString());
  		n.simplesExpressao1.accept(this);
		n.simplesExpressao2.accept(this);
    }

    @Override
    public void visit(ExpDivisao n) {
        System.out.println("Classe Visitada= "+n.toString());
      	n.simplesExpressao1.accept(this);
	    n.simplesExpressao2.accept(this);
    }

    @Override
    public void visit(DeclaracaoWhile n) {
        System.out.println("Classe Visitada= "+n.toString());
        n.simplesExpressao.accept(this);
        n.declaracao.accept(this);
    }

    @Override
    public void visit(DeclaracaoLeitura n) {
        System.out.println("Classe Visitada= "+n.toString());
    if(n.listaVariavel != null)
		n.listaVariavel.accept(this);
            
    }

    @Override
    public void visit(DeclaracaoIfElse n) {
        System.out.println("Classe Visitada= "+n.toString());
	  	n.simplesExpressao.accept(this);
      	n.declaracao1.accept(this);
      	n.declaracao2.accept(this);
    }

    @Override
    public void visit(DeclaracaoIf n) {
        System.out.println("Classe Visitada= "+n.toString());
      n.simplesExpressao.accept(this);
      n.declaracao.accept(this);
    }

    @Override
    public void visit(DeclaracaoEscrita n) {
        System.out.println("Classe Visitada= "+n.toString());
        if(n.listaExpressao != null)
			n.listaExpressao.accept(this);
    }

    @Override
    public void visit(DeclaracaoAtribuicao n) {
        System.out.println("Classe Visitada= "+n.toString());
        System.out.println("Atributo= "+n.id);
        n.simplesExpressao.accept(this);
    }



    @Override
    public void visit(BlockFuncao n) {
        System.out.println("Classe  Visitada= "+n.toString());
        if (n.declaracaoVariaveis != null)
          n.declaracaoVariaveis.accept(this);
        if (n.composicaoDeclaracao != null)
          n.composicaoDeclaracao.accept(this);
       
    }
    
}
