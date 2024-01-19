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

   ## Caixa preta: 
    - Baseia-se nos requisitos básicos do software, sendo o foco nos requisitos da aplicação, ou seja, nas ações que deve desempenhar.
    - Diferente do teste de caixa branca, ele possui esse nome porque o código-fonte é ignorado no teste. Assim, ao se utilizar dessa técnica, o tester não está preocupado com os elementos constitutivos do software, mas em como ele funciona.
    - Os principais testes caixa preta são os testes de integração e de API;


