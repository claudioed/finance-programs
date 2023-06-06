# Finance Condition diagrams

Find finance conditions diagrams to help understand microservice big picture  

## Class diagram

```mermaid
classDiagram
    FinanceCondition *-- Subsidy: has
    FinanceCondition *-- Targets: has
    FinanceCondition *-- Flat: has
    FinanceCondition *-- Duration: has
    FinanceCondition *-- DownPaymentRequirements: has
    FinanceCondition *-- MonetaryAmount: has
    

```

