# Álcool ou Gasolina? - App Android

Este é um aplicativo Android desenvolvido como parte de um projeto de extensão universitário, com o objetivo de auxiliar usuários a decidirem qual combustível é mais vantajoso economicamente abastecer, com base na comparação entre os preços do álcool e da gasolina.

## 🎯 Objetivo

Permitir que o usuário insira os preços do álcool e da gasolina e, com base na **regra de negócio (álcool/gasolina <= 0.7)**, indicar qual dos dois combustíveis compensa mais.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Framework de UI**: Jetpack Compose
- **IDE**: Android Studio
- **Versão mínima do Android**: API 21 (Lollipop)

## 📱 Funcionalidades

- Entrada dos preços do álcool e da gasolina
- Validação de campos
- Cálculo da proporção entre os combustíveis
- Exibição de mensagem recomendando a melhor escolha
- Interface simples e responsiva

## 💡 Regra de Negócio

Se o valor do álcool dividido pelo valor da gasolina for **menor ou igual a 0.7**, o aplicativo recomenda **abastecer com álcool**. Caso contrário, recomenda **abastecer com gasolina**.

> Fórmula: `álcool / gasolina <= 0.7 → Álcool é mais vantajoso`

## ✅ Situação Atual

- [x] Interface implementada
- [x] Lógica de decisão funcional
- [x] Testado com entradas válidas e inválidas

## 📂 Como Rodar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/seunome/alcool-ou-gasolina-app.git
