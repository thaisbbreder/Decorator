package produto;

import java.math.BigDecimal;

public interface Produto {
    String getNome();
    BigDecimal getTaxaAdm();
    BigDecimal getRentabilidade();
}

//É o componente base (Component). Tanto os produtos concretos quanto os decoradores implementam essa interface