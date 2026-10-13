# Sistema de Vendas em Java (Domain-Driven Design - DDD)

Projeto desenvolvido com o objetivo de aprender, modelar e aplicar na prática os conceitos fundamentais do **Domain-Driven Design (DDD)** utilizando **Java puro**, sem o auxílio de frameworks ou dependências externas.

---

## 🎯 Objetivos do Projeto

- Compreender a modelagem de domínio centrada nas regras de negócio.
- Implementar o padrão de **Modelo de Domínio Rico** (evitando o modelo anêmico).
- Aplicar a **Inversão de Dependência (DIP)** para desacoplar a camada de domínio da infraestrutura de dados.
- Estruturar uma arquitetura em camadas clara e modular (`Domain`, `Application` e `Infrastructure`).

---

## 🏗️ Conceitos do DDD Aplicados

- **Linguagem Ubíqua:** Métodos e classes com nomes orientados ao negócio (`debitarEstoque`, `adicionarItem`, `pagar`).
- **Entidades:** Classes com identidade própria (`UUID`) e validações de invariantes diretamente nos construtores (`Cliente` e `Produto`).
- **Agregados e Raiz do Agregado:** O `Pedido` atua como a raiz do agregado, orquestrando seus itens (`ItemPedido`), garantindo a consistência do valor total e protegendo o estado da transação.
- **Repository Pattern:** Contratos de persistência isolados em interfaces (`domain.repository`) com implementações simuladas em memória (`infrastructure`).
- **Use Cases / Application Services:** A classe `RealizarVendas` orquestra o fluxo de busca, alteração de domínio e persistência sem conter regras de cálculo do negócio.

---

## 📂 Estrutura do Projeto

```text
src/main/java/com/brunorafaeldev/sistemavendas
 ├── domain
 │    ├── entity       # Entidades, Agregados e Enums (Cliente, Produto, Pedido, ItemPedido, StatusPedido)
 │    └── repository   # Interfaces dos repositórios
 ├── application       # Casos de uso / Serviços de aplicação (RealizarVendas)
 ├── infrastructure    # Implementação dos repositórios em memória
 └── App.java         # Ponto de entrada e teste do fluxo completo
