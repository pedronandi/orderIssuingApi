<h1 align="center">API de Emissão de Pedidos (Order Issuing API)</h1>

Essa API funciona como back-end de uma aplicação simplificada de emissão de pedidos. Ela foi implementada em Java, com o auxílio do framework [Spring Boot](https://start.spring.io/), e utilizando o banco de dados [PostgreSQL](https://www.postgresql.org/). O projeto do Spring Boot conta com as seguintes dependências: Spring Web, Lombok, Spring Data JPA e PostgreSQL Driver.
Através dessa API, é possível efetuar o cadastro e a atualização de pedidos. Também é possível consultar os pedidos já existentes.

## Essa aplicação contém as seguintes entidades:

<strong>Cliente</strong>: Não possui CRUD, pois estão todos pré-cadastrados;
<strong>Produto</strong>: Também sem CRUD disponível, pelo mesmo motivo que os clientes;
<strong>Item</strong>: Composto por um produto, uma quantidade e um valor informado;
<strong>Pedido</strong>: Composto por um cliente e por uma lista de itens.

<strong>OBS</strong>: Na implementação, a entidade Pedido é chamada "OrderRequest" e não apenas "Order". Isso porque o projeto inicial foi construído sobre o banco de dados H2, onde a palavra "ORDER" é reservada.

## Dados pré-cadastrados:

<p align="center"><strong>[Clientes]</strong></p>
<p align="center">
  <img src="/img/clientes.png" />
</p>

<p align="center"><strong>[Produtos]</strong></p>
<p align="center">
  <img src="/img/produtos.png" />
</p>

## Regras de negócio:

- <strong>Básicas</strong>: No item, quantidade e valor informados devem ser maiores que zero;
- <strong>Rentabilidade</strong>: Os itens do pedido podem ser classificados em três níveis de rentabilidade, de acordo com a diferença entre o valor informado do item e o preço do produto (que é fixo):
  - <strong>Ótima</strong>: Quando o preço usado no pedido é maior que o preço do produto. Ex: Se o preço do produto é de R$ 100, a rentabilidade será ótima se o item for vendido por R$ 100,01 (inclusive) ou mais;
  - <strong>Boa</strong>: Quando o preço do item é no máximo 10% menor que o preço do produto. Ex: Se o preço do produto é de R$ 100, a rentabilidade será boa se o item for vendido por qualquer preço entre R$ 90 (inclusive) e R$ 100 (inclusive).
  - <strong>Ruim</strong>: Quando o preço do item é inferior ao preço do produto menos 10%. Ex: Se o preço do produto é de R$ 100, a rentabilidade será ruim se o preço for menor ou igual a R$ 89,99. Quando efetuado cadastro do pedido, o sistema irá calcular a rentabilidade. Se a mesma for ruim, o item não será cadastrado e o usuário será informado.
- <strong>Múltiplo de venda</strong>: Alguns produtos só podem ser vendidos em quantidades múltiplas de um determinado número. Por exemplo, o produto X-Wing só pode ser vendido em múltiplos de 2, por exemplo, 2, 4, 6, 8, etc. Já o produto Lightsaber só pode ser vendido em múltiplos de 5, ou seja, 5, 10, 15, 20 e assim por diante. Produtos que não possuem múltiplos podem ser vendidos em qualquer quantidade.

## Acesso à produção:

- A API está disponível através [deste endereço](https://order-issuing-api.herokuapp.com/)
- Ela foi hospedada no ![Heroku](https://heroku.com/), através da integração com o próprio GitHub e do plugin disponível para o PostgreSQL.

## Imagens e exemplos - Testes da API através do Isomnia:

<p align="center"><strong>Cadastro do pedido com sucesso - HTTP 200:</strong></p>
<p align="center">
  <img src="/img/post.png" />
</p>

<p align="center"><strong>Busca pelos pedidos cadastrados:</strong></p>
<p align="center">
  <img src="/img/get.png" />
</p>

<p align="center"><strong>Busca pelos pedidos cadastrados: https://order-issuing-api.herokuapp.com/orderRequest</strong></p>
<p align="center">
  <img src="/img/getFromBrowser.png" />
</p>

<p align="center"><strong>Atualização do pedido:</strong></p>
<p align="center">
  <img src="/img/update.png" />
</p>

## Imagens e exemplos - Regras de negócio:

<p align="center"><strong>Quantidade do item zerada:</strong></p>
<p align="center">
  <img src="/img/amountUnreportedException.png" />
</p>

<p align="center"><strong>Valor informado do item zerado:</strong></p>
<p align="center">
  <img src="/img/unitPriceUnreportedException.png" />
</p>

<p align="center"><strong>Rentabilidade ruim calculada:</strong></p>
<p align="center">
  <img src="/img/profitabilityException.png" />
</p>

<p align="center"><strong>Quantidade do item não é múltiplo do produto informado:</strong></p>
<p align="center">
  <img src="/img/multipleException.png" />
</p>

## Como executar localmente?

Para executar esse projeto localmente, é necessário:
- [Neste tutorial](https://medium.com/@julianlfs/postgresql-pgadmin-4-docker-compose-9526f281c5e5) é possível configurar e rodar o PostgreSQL através do Docker, na sua máquina;
- Com o PostgreSQL rodando, é necessário reconfigurar o arquivo <strong>application.properties</strong> com as variáveis de ambiente locais (estão comentadas, em detrimento das variáveis do Heroku).
