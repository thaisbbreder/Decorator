package produto;

import produto.Produto;

import java.math.BigDecimal;

public class FundoInvestimentoSimples implements Produto {
    private String nome;
    private BigDecimal taxaAdm;
    private BigDecimal rentabilidade;

    public FundoInvestimentoSimples(String nome, BigDecimal taxaAdm, BigDecimal rentabilidade) {
        this.nome = nome;
        this.taxaAdm = taxaAdm;
        this.rentabilidade = rentabilidade;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public BigDecimal getTaxaAdm() {
        return taxaAdm;
    }

    @Override
    public BigDecimal getRentabilidade() {
        return rentabilidade;
    }
}

//É o componente concreto (ConcreteComponent).
// Representa a implementação real de um produto a ser decorado. É o objeto inicial que será "revestido" com funcionalidades adicionais.