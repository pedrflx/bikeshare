# Bikeshare | Programação 02
O objetivo do BIKESHARE é construir, como projeto da disciplina de Programação 02, a lógica de negócio completa de um sistema de bicicletas compartilhadas, acessada por uma Facade e validada por testes de aceitação automatizados sem qualquer camada de interface gráfica ou de persistência em banco de dados.

<p align="center">
  <img src="https://user-images.githubusercontent.com/91018438/204195385-acc6fcd4-05a7-4f25-87d1-cb7d5cc5c852.png" alt="animated" />
</p>

 ## Sobre o projeto

Assim como o WePayU tinha por propósito construir um sistema de folha de pagamento, o **BIKESHARE** tem por propósito construir um sistema de gerenciamento de um serviço de bicicletas compartilhadas (bike-sharing), no estilo dos sistemas usados em várias cidades brasileiras (ex.: Bike Itaú, Tembici).

O sistema mantém um cadastro de **usuários**, **estações** (pontos de retirada/devolução) e **bicicletas**. Um usuário retira uma bicicleta disponível em uma estação, usa-a por um período (um **aluguel**, também chamado de "corrida") e a devolve em qualquer estação com vaga livre. O sistema deve:

- Controlar a disponibilidade de bicicletas em cada estação (bicicletas presentes × vagas livres);
- Impedir a retirada de bicicletas indisponíveis (em uso, em manutenção) e de estações sem bicicletas;
- Impedir a devolução em estações sem vagas;
- Calcular o valor a cobrar por cada aluguel, de acordo com o **plano** do usuário (avulso ou assinante) e com a duração da corrida;
- Impedir que um usuário **inadimplente** (com pendências financeiras) faça uma nova retirada;
- Impedir que um usuário com um aluguel em andamento inicie um segundo aluguel simultâneo;
- Registrar o histórico de aluguéis de cada usuário e gerar relatórios (faturamento, bicicletas disponíveis/alugadas);
- Permitir desfazer/refazer operações (undo/redo);
- Rodar de forma **totalmente desacoplada de interface gráfica** — assim como no WePayU, só será implementada a lógica de negócio, acessada por uma **Façade** e validada por scripts de teste de aceitação (EasyAccept).

Está dentro do escopo: cadastro, consulta, alteração e remoção de usuários e estações; gestão de bicicletas convencionais e elétricas; retirada e devolução de bicicletas, com cálculo de tarifa; planos de tarifação avulso, assinante e planos customizados criados em tempo de execução; regras de bloqueio por inadimplência, estação cheia ou vazia e bicicleta indisponível; lançamento e conclusão de manutenção; relatórios de disponibilidade e faturamento; desfazer/refazer operações; e persistência do estado do sistema entre execuções.

Está fora do escopo: qualquer interface gráfica ou web, integração com um gateway de pagamento real, geolocalização	e qualquer forma de concorrência.		

## Glossário 

| Termo | Definição |
|---|---|
| **Usuário** | Pessoa cadastrada no sistema, identificada por um identificador único gerado automaticamente. Pode alugar bicicletas. |
| **Estação** | Ponto físico com um número fixo de vagas (`capacidade`), onde bicicletas ficam disponíveis para retirada e podem ser devolvidas. |
| **Bicicleta** | Veículo compartilhado, identificado unicamente, que pertence a uma estação enquanto não está em uso. |
| **Vaga** | Espaço disponível em uma estação para receber uma bicicleta. `vagas livres = capacidade − bicicletas presentes`. |
| **Aluguel (ou corrida)** | Período de uso de uma bicicleta por um usuário, do momento da retirada até a devolução. |
| **Plano** | Modalidade de cobrança contratada pelo usuário: *avulso* (paga por minuto/hora a cada corrida) ou *assinante* (paga mensalidade e tem franquia de minutos gratuitos). |
| **Tarifa** | Valor cobrado por um aluguel, calculado de acordo com o plano do usuário e a duração da corrida. |
| **Penalidade / taxa extra** | Cobrança adicional lançada sobre um usuário (ex.: atraso na devolução, dano à bicicleta, devolução fora da área de cobertura). Análoga à "taxa de serviço" do sindicato no WePayU. |
| **Inadimplência** | Situação de um usuário que possui pendências financeiras não quitadas; nesse estado, não pode iniciar novos aluguéis. |
| **Estado da bicicleta** | Condição operacional da bicicleta: disponível, em uso, em manutenção ou removida. |
| **Estado do aluguel** | Condição de uma corrida: em andamento, finalizada, cancelada ou expirada. |
| **Bicicleta convencional / elétrica** | Os dois tipos fixos de bicicleta suportados pelo sistema; a elétrica possui nível de bateria e cobrança adicional por minuto. |
| **Usuário pessoa física / jurídica** | Os dois tipos fixos de usuário; pessoa física se identifica por CPF, pessoa jurídica por CNPJ/razão social e pode ter fatura consolidada. |
| **Método de pagamento** | Forma pela qual o usuário paga suas cobranças: cartão, Pix ou saldo pré-carregado. |

---

## Desenvolvimento

15/11 US1 concluída (71 testes OK). Usuários pessoa física e jurídica, com plano avulso ou assinante. A Facade só repassa os pedidos, cada usuário responde pelos próprios atributos e o repositório gera os ids sem nunca expor a lista.

15/11 US2 concluída (46 testes OK). Consulta de todos os atributos do usuário e busca por email sem diferenciar maiúsculas. Os dados de cartão, pix e saldo dão erro por padrão na forma de pagamento, e cada forma vai sobrescrever só os seus.

16/11 Persistência (us1_1 com 14 testes OK). Ao encerrar, o sistema grava os dados em bikeshare_data.ser com Serializable, e ao abrir carrega de volta.

17/11 US3 concluída (us3 com 129 testes OK e us3_1 com 17). Alteração de dados, plano e forma de pagamento. Cartão, pix e saldo carregado são filhas de MetodoPag e cada uma responde só pelos próprios dados. O saldo fica guardado ao trocar de forma de pagamento, e o email continua único também na alteração.

18/11 US4 concluída (us4 com 37 testes OK e us4_1 com 15). Remoção de usuário pelo repositório. Os ids nunca são reaproveitados e o email do removido fica livre para um novo cadastro.

18/11 US5 concluída (us5 com 42 testes OK e us5_1 com 11). Cadastro de estação com nome, endereço e capacidade. Os repositórios tem uma mãe que gera os ids, e as estações também são salvas no arquivo.