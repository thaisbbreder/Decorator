package decorator;

import produto.Produto;

import java.math.BigDecimal;

public abstract class ProdutoDecorator implements Produto {
    protected Produto componente;

    public ProdutoDecorator(Produto componente) {
        this.componente = componente;
    }

    @Override
    public String getNome() {
        return componente.getNome();
    }

    @Override
    public BigDecimal getTaxaAdm() {
        return componente.getTaxaAdm();
    }

    @Override
    public BigDecimal getRentabilidade() {
        return componente.getRentabilidade();
    }
}


//É o decorador abstrato (Decorator base). Permite encapsular o objeto original e garantir que os decoradores concretos implementem apenas o que for necessário, evitando duplicação de código.