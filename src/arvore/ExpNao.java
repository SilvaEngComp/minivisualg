package arvore;

public class ExpNao extends SimplesExpressao  {

    public SimplesExpressao simplesExpressao;

    public ExpNao(SimplesExpressao simplesExpressao) {
        this.simplesExpressao = simplesExpressao;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
