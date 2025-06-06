# Decorator

**Categoria**: Estrutural

O **Decorator** é um padrão de projeto estrutural que permite **adicionar novas funcionalidades, métodos ou comportamentos a um objeto dinamicamente, sem modificar diretamente o objeto original**, assim evitando a explosão de subclasses causadas por combinações variadas de características.  
Por exemplo, se eu tenho uma classe `Camiseta`, posso criar um *Decorator* que adiciona uma funcionalidade/caracteristica a mais (Ex: EstampaDecorator) sem abrir o arquivo da classe `Camiseta` para modificá-la.

Isso caracteriza o princípio do **Open/Closed*, onde o código está aberto para extensão, mas fechado para modificação.

## Estrutura

![image (1)](https://github.com/user-attachments/assets/e01c5c47-ad3f-4fb7-8e11-fa05d6721d7f)

- **Componente (Component):** Interface ou classe abstrata que define as operações comuns.  
  Ex: `Produto`

- **Componente Concreto (ConcreteComponent):** Representa a implementação real de um produto a ser decorado. É o objeto inicial que será "revestido" com funcionalidades adicionais.  
  Ex: `FundoInvestimentoSimples`

- **Decorador Abstrato (Decorator):** Permite encapsular o objeto original e garantir que os decoradores concretos implementem apenas o que for necessário, evitando duplicação de código.  
  Ex: `ProdutoDecorator`

- **Decoradores Concretos (ConcreteDecorators):** Classes que estendem o decorador abstrato e adicionam comportamentos específicos.  
  Ex: `IsentoIRDecorator`, `IsentoTaxaAdmDecorator`, `TaxaPerformanceDecorator`

## Explicação da Implementação
Imagine o seguinte: eu tenho uma interface chamada `Produto`. Essa interface define um método, por exemplo, `getTaxaAdm()`, que todas as implementações devem possuir, como `CreditoImobiliario`, `FundoInvestimento`, entre outros.

Agora imagine que eu comece a vender versões modificadas desses produtos: `Fundo de Investimento (Isento IR)`, `Fundo De Investimento com ou sem Taxa especifica`, e assim por diante. Isso causaria uma **explosão de classes**, pois eu precisaria criar uma nova classe para cada combinação de características.

Com o padrão *Decorator*, podemos evitar isso. A ideia é **separar o produto de suas "decorações" ou funcionalidades adicionais**. Por exemplo, ao invés de criar uma classe `Fundo de Investimento (Isento IR)`, eu posso ter uma classe `Fundo de investimento` normal e uma classe `IsentoIRDecorator`. Essa classe *Decorator* implementa a mesma interface `Produto` e possui um link (composição) com um `Produto` concreto, nesse caso o `Fundo de Investimento`.

Assim, **o *Decorator* funciona como um intermediário que intercepta as chamadas e pode alterar ou complementar os comportamentos do objeto decorado**. Ele repassa as chamadas de método, como `getTaxaAdm()`, para o objeto interno, podendo adicionar ou modificar informações.

No livro da *Gang of Four*, o *Decorator* abstrato é usado como base para os *Decorators* concretos. **Esse *Decorator* base não faz nada além de manter a referência ao componente decorado e repassar as chamadas de método. Os *Decorators* concretos é que implementam as funcionalidades reais.**

Por exemplo, um `IsentoIRDecorator` poderia aumentar a rentabilidade líquida do fundo, pois o investidor não paga imposto de renda sobre os ganhos. Por isso, o decorator adiciona um valor fixo (ex: +0,2%) na rentabilidade. Enquanto o `IsentoTaxaAdmDecorator` zera a taxa de administração, que é o custo cobrado pelo gestor do fundo. Embora não altere a rentabilidade diretamente, ao reduzir a taxa, o fundo fica mais atrativo, pois diminui custos para o investidor.

**Em nenhum momento modificamos a classe original `FundoInvestimentoSimples`.** Estamos apenas compondo objetos de forma dinâmica, respeitando o princípio de extensão sem modificação. Assim, o objeto final pode se comportar como uma `FundoInvestimentoIsentoTaxaAdm`, sem que essa classe realmente exista no código.

Esse padrão é extremamente poderoso e versátil, principalmente quando se busca flexibilidade na adição de funcionalidades. Ele evita a criação de múltiplas subclasses e promove uma arquitetura mais limpa e extensível.

Dessa forma, foi possivel implementar Fundos Imobiliarios diversos, com ou sem taxas:
![image](https://github.com/user-attachments/assets/5ef627e5-d2d0-4f6e-8ff8-55b38630296c)

