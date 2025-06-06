import decorator.IsentoIRDecorator;
import decorator.IsentoTaxaAdmDecorator;
import produto.FundoInvestimentoSimples;
import produto.Produto;

import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        Produto fundoBase = new FundoInvestimentoSimples(
                "Fundo Itaú Renda Fixa",
                new BigDecimal("0.0150"),
                new BigDecimal("0.1250")
        );

        Produto fundoIsentoTaxaAdm = new IsentoTaxaAdmDecorator(fundoBase);

        Produto fundoIsentoIRTaxaAdm = new IsentoTaxaAdmDecorator(
                new IsentoIRDecorator(fundoBase)  // Decorator aninhado corretamente
        );

        imprimeInfo("=== Fundo Base sem decorator ===", fundoBase);
        imprimeInfo("=== Fundo com Decorator de Isenção Taxa Adm ===", fundoIsentoTaxaAdm);
        imprimeInfo("=== Fundo com 2 decorators (Isenção IR e Taxa Adm) ===", fundoIsentoIRTaxaAdm);
    }

    private static void imprimeInfo(String titulo, Produto fundo) {
        System.out.println(titulo);
        System.out.println("Produto: " + fundo.getNome());
        System.out.println("Taxa de Administração: " + fundo.getTaxaAdm().multiply(BigDecimal.valueOf(100)).setScale(2) + "% a.a.");
        System.out.println("Rentabilidade Líquida: " + fundo.getRentabilidade().multiply(BigDecimal.valueOf(100)).setScale(2) + "% a.a.");
        System.out.println();
    }
}

