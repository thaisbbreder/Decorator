package decorator;

import produto.Produto;

import java.math.BigDecimal;

public class IsentoIRDecorator extends ProdutoDecorator {

    public IsentoIRDecorator(Produto componente) {
        super(componente);
    }

    @Override
    public String getNome() {
        return componente.getNome();
    }

    @Override
    public BigDecimal getRentabilidade() {
        // Simula acrescimo sem o IR: +0.2% na rentabilidade
        return componente.getRentabilidade().add(new BigDecimal("0.002"));
    }
}

//É um decorador concreto (ConcreteDecorator). Adiciona comportamento específico ao objeto produto.Produto, sem alterar a estrutura original.