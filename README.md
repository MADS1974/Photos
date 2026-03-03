# 📸 Photos App

#### Um aplicativo Android para visualização de uma galeria de fotos consumindo dados de uma API REST (JSONPlaceholder) desenvolvido em Kotlin.
O objetivo principal é demonstrar a integração com serviços web, processamento de JSON e o carregamento dinâmico de imagens da rede utilizando 
a biblioteca Volley.

Este projeto foi criado para fins acadêmicos no contexto da disciplina D2DA2 - Des. Android 2:

#### •Consumo de APIs REST com Volley (JsonArrayRequest)
#### •Processamento de dados JSON para objetos Kotlin usando Gson
#### •Carregamento e exibição de imagens de rede com ImageRequest
#### •Implementação do padrão Singleton para gerenciamento de fila de requisições HTTP
#### •Uso de ViewBinding para manipulação segura da interface
#### •Adaptação de URLs de terceiros (placehold.co) para compatibilidade com formatos de imagem no Android (.png)

## 🚀 Funcionalidades

✔️ Listagem de Fotos: Busca dinamicamente os metadados de 100 fotos da API JSONPlaceholder.
#### ✔️ Seleção via Spinner: Permite ao usuário selecionar uma foto específica através de um menu suspenso (Spinner).
#### ✔️ Visualização em Alta Resolução: Exibe a imagem principal da foto selecionada em um ImageView grande.
#### ✔️ Miniatura (Thumbnail): Exibe a versão reduzida da imagem para referência visual.
#### ✔️ Tratamento de Placeholders: Correção dinâmica de URLs para garantir que as imagens coloridas de teste sejam 
renderizadas corretamente no Android via extensão .png.

#### ✔️ Feedback de Erro: Notificações via Toast caso ocorram falhas na rede ou no parse das imagens.

## 🛠 Tecnologias Utilizadas
#### •Kotlin — Linguagem principal
#### •Android Studio — IDE de desenvolvimento
#### •ViewBinding — Acesso seguro aos elementos de UI
#### •Volley — Biblioteca para requisições HTTP e carregamento de imagens
#### •Gson — Conversão de JSON para objetos de dados (POJOs)
#### •Custom Adapter — Implementação de PhotoAdapter para o Spinner
#### •Material Design — Componentes de interface como Toolbar e Widgets

## 📸 Demonstração do App

#### 01 - Tela Principal e Seleção
O Spinner no topo permite navegar entre os títulos das fotos carregadas. 
#### Ao selecionar, o app dispara requisições para buscar a imagem principal e a miniatura.
#### 02 - Carregamento de Imagens
As imagens são carregadas seguindo as dimensões e cores hexadecimais originais da API, 
utilizando o gerador placehold.co com suporte a formato PNG.

## ▶️ Como Executar o Projeto

#### 1.Clone este repositório:
#### Kotlin
#### git clone https://github.com/MADS1974/Photos.git
#### 2.Abra o projeto no Android Studio.
#### 3.Aguarde a sincronização do Gradle.
#### 4.Certifique-se de que o dispositivo/emulador tenha acesso à Internet.
#### 5.Execute o app.
#### 📚 CréditosProjeto acadêmico desenvolvido para a disciplina Desenvolvimento para Android 

#### 1 – D2DA2, ministrada pelo professor Pedro Northon Nobile (IFSP).

#### 🙋‍♂️ AutorMárcio Adriano

🔗 Conecte-se comigo:
LinkedIn - Márcio AdrianoDica para o GitHub
