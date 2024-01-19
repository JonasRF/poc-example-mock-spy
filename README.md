## Cobertura de código com Jacoco
## Competências
 - Parte 1: Avançando nos testes unitários
 -  Abordagens de teste
    - Caixa branca
    - Caixa preta
- Principais anotações Mockito
   - @Mock
   - @Spy
   - @InjectMocks
   - Exemplo utilização @Mock, @Spy e @InjectMocks
 - Introdução à cobertura de código
- Parte 2: Cobertura de código com Jacoco
   - Tipos básicos de cobertura de código/testes
   - Statement Coverage (Line Coverage)
   - Branch Coverage
   - Function Coverage
 - Discussão
 - Ferramentas para cobertura
 - JaCoCo
   - Dependência
 - Recursos importantes
 - Exercícios

Parte 1: Avançando nos testes unitários
Objetivo: apresentar tópicos adicionais sobre testes unitários para complementar o conteúdo aprendido nos capítulos anteriores.
## Abordagens de teste
 - Uma das partes principais deste processo é o teste de software, que tem como objetivo descobrir sistematicamente diferentes classes de erros com uma quantidade de tempo e esforço mínimos. 
 - Os testes podem ser divididos em 2 grupos, sendo o teste caixa branca e o teste caixa preta:
Caixa branca:
 - O teste de caixa branca possui esse nome porque o testador tem acesso à estrutura interna da aplicação. Logo, seu foco é garantir que os componentes do software estejam concisos.
 - O teste é realizado diretamente no código fonte, ou seja, o teste analisa a estrutura interna dos componentes do sistema. 
 - Nesta técnica são analisados os caminhos básicos do software e a ideia é que esses caminhos sejam testados.
 - Um dos principais testes de caixa branca são os testes unitários;

 - ## Caixa preta: 
    - Baseia-se nos requisitos básicos do software, sendo o foco nos requisitos da aplicação, ou seja, nas ações que deve desempenhar.
    - Diferente do teste de caixa branca, ele possui esse nome porque o código-fonte é ignorado no teste. Assim, ao se utilizar dessa técnica, o tester não está preocupado com os elementos constitutivos do software, mas em como ele funciona.
    - Os principais testes caixa preta são os testes de integração e de API;

![image](https://github.com/JonasRF/poc-example-mock-spy/assets/77034798/3df13e68-4977-4c4c-bad2-dbd507ea23cf)

À direita uma representação do teste de caixa branca que tem acesso direto ao código fonte; (b) À esquerda o teste de caixa preta onde o que são analisados são os requisitos.
 - Uma das principais vantagens ao implementar os testes unitários, por exemplo, é proteger os recursos já implementados de serem quebrados à medida que o código muda. Além de proporcionar ao desenvolvedor um senso de proteção da aplicação contra bugs.

## Principais anotações Mockito
@Mock
Um mock em testes unitários é um objeto que implementa o comportamento de algum componente do sistema. Em outras palavras, substitui as dependências. É muito usado para incluir alguma dependência (ex: Repository ou Service).

@Spy
A ideia do spy é permitir encapsular a instância de algum objeto existente. É como se ele espionasse um objeto real. Por padrão, o spy irá delegar as chamadas de métodos para o objeto real e rastrear as chamadas e parâmetros. 

É usado em circunstâncias mais específicas quando comparado com o @Mock, sendo elas:
 - Simular o comportamento de um método da mesma classe que está sendo testada.
 - Testes Unitários em sistemas legados.

@InjectMocks
Usado para instanciar o objeto testado automaticamente e injetar todas as dependências anotadas @Mock e @Spy.

## Exemplo utilizando @Mock, @Spy e @InjectMocks
Considere um serviço ###ProductService### que implementa os métodos insert e update de produtos. Cada produto é composto pelos campos id, name e price. Ambos os métodos utilizam uma função ###validateData(), responsável por validar se o nome não é vazio e se o preço é positivo. 

Implemente os testes unitários da camada de serviços para os métodos insert e update considerando os cenários de teste.
Observação: Assuma que não estamos usando lib de validação
