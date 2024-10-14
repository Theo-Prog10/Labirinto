# Labirinto
## Descrição do Projeto
Nesse projeto, criamos um algorítmo que resolve um labirinto e exibe o processo de solução para o usuário.
Desenvolvido por [Eduardo Pitanga Loureiro](https://github.com/eduardo-pitanga) e [Theo Mischiatti Gomes](https://github.com/Theo-Prog10)

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java](https://www.java.com/en/download/).
<br>Além disto é bom ter um editor para trabalhar com o código como [IntelliJ](https://www.jetbrains.com/idea/download/)

```bash
# Clone este repositório
$ git clone <https://github.com/eduardo-pitanga/Labirinto>

- Executar Main.java para rodar o programa
```

### Documentação do Projeto

#### Processo inicial

- O programa le um arquivo .csv com 0s e 1s separados por "," e monta um labirinto a partir dela, onde 0s representam paredes e 1s caminhos livres.
- De início, o programa le o arquivo usando a classe Entrada e o transforma em um ArrayList de Arraylist de Integer, o armazenando em um Objeto Labirinto.
- O processamento da solução se dá após definir as coordenadas de início e chamar o método solve() do Labirinto.

#### Método solve()
- Para melhor manipulação, o labirinto é convertido em uma matriz.
- Por já ter a primeira coordenada, é dado um push em uma pilha com o valor da coordenada.
- Com base nessa coordenada, é aplicado o método sove() que retornará a primeira coordenada válida que está ao redor da coordenada passada como parâmetro.
- A coordenada é adicionada a pilha e o processo continua até que seja encontrada a saída.
- A saída é definida por um erro ao tentar usar o método redor() de ArrayIndexOutOfBoundsException.
- Caso seja a primeira vez passando pela coordenada, seu valor deixa de ser 1 e passa a ser 2; se for a segunda vez, deixa de ser 2 e passa a ser 3.

#### Método redor()
- O programa percorre as 8 casas ao redor da coordenada passada como parâmetro.
- Se for encontrada uma casa com valor de 1, a busca se encerra e é retornada a coordenada.
- Se ao buscar não houver 1s disponíveis, o método busca por 2s e retorna a primeira coordenada correspondente.
- Se não encontrar nem 1 nem 2, o método retorna 0, indicando que não há um próximo movimento válido.

#### Representação Gráfica
- A classe Display implementa uma UI animada que exibe o processo de solução do labirinto.
- Para tal, passamos como parâmetro a pilha com todas as coordenadas que foram adicionadas no decorrer da solução, que representa por vermelho cada célula por onde o programa anda.
