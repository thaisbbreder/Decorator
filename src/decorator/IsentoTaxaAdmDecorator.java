package decorator;


import produto.Produto;
import java.math.BigDecimal;

public class IsentoTaxaAdmDecorator extends ProdutoDecorator {

    public IsentoTaxaAdmDecorator(Produto componente) {
        super(componente);
    }

    @Override
    public String getNome() {
        return componente.getNome() + " (Isento Taxa Adm)";
    }

    @Override
    public BigDecimal getTaxaAdm() {
        // Zera a taxa de administração
        return BigDecimal.ZERO;
    }
}


//  É outro decorador concreto. Modifica o comportamento do método getRentabilidade() com uma lógica adicional específica de performance.