# Desafio Criptografia
Desafio é desenvolver uma api onde irá criptografar os dados sensiveis.

* Irei utilizar a criptografia SHA-512.

## Documentação
Explicação:

Considere os campos `userDocument` e `creditCardToken` como campos sensíveis que devem ser criptografados. A tabela de
exemplo seria a seguinte:

| id | userDocument     | creditCardToken | value |
|:---|:-----------------|:----------------|:------|
| 1  | MzYxNDA3ODE4MzM= | YWJjMTIz        | 5999  |
| 2  | MzI5NDU0MTA1ODM= | eHl6NDU2        | 1000  |
| 3  | NzYwNzc0NTIzODY= | Nzg5eHB0bw==    | 1500  |

A estrutura da entidade correspondente seria a seguinte:

| Campo           | Tipo   |
|:----------------|:-------|
| id              | Long   |
| userDocument    | String |
| creditCardToken | String |
| value           | Long   |
s
### Ferramentas
Para desenvolver essa API estarei utilizando:

*  `Java 17`
*  `MAVEN 3.9.4`
*  `Spring Boot 3.1.3`
*  `BD PostgreSQL`

