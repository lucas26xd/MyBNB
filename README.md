# MyBNB
Mini Projeto desevolvido em Julho/2016 em Java com persistencia de dados em arquivos.

## Todas as telas são capazes de realizar o CRUD completo,
### Na primeira aba, é possível realizar cadastro:
![Tela cadastro]()

### Na segunda aba, é possível visualizar os registros cadastrados:
![Tela consulta]()

### Clicando duas vezes em cima de um registro específico, será direcionada a primeira aba com os campos povoados daquele registro, onde será possível Alterar ou Remover tal registro.
![Tela edição]()

## Organização de pastas
Arquivos base do programa estão na pasta 
> .\Cidades

As demais telas de CRUD salvam/editam arquivos em suas respectivas pastas
> .\Clientes

> .\Hospedagem

> .\Viagens

Arquivos de códigos se encontram dentro da pasta
> .\src

Utilizo a biblioteca [Glazed Lists](https://glazedlists.github.io/glazedlists-tutorial/) para criar dentro de um JComboBox um campo de texto que, ao digitar, sugere resultados da lista (AutoComplete), o jar da biblioteca se encontra
> .\lib