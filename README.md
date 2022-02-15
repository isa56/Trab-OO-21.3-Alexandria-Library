# Sistema de Biblioteca - Alexandria Library

## Sumário:
* [Descrição](#descrição);
* [Como usar](#como-usar);
* []();
* [Integrantes do Grupo](#integrantes-do-grupo);
* [Links Importantes](#links-importantes);
* [Requisitos de Sistema](#requisitos-de-sistema)

## Descrição:
Sistema de Biblioteca para o curso de Orientação a Objetos (DCC025) no período 2021.3 da UFJF.
* Linguagem: <img alt="Java" src="https://www.ativasoft.com.br/blog/wp-content/uploads/2018/01/java_icon.png" width="40"></img>

## Como Usar:
1. Faça um clone deste repositório: `git clone https://github.com/isa56/Trab-OO-21.3-Alexandria-Library`;
2. Vá para a pasta: `Trab-OO-21.3-Alexandria-Library\alexandria-library` e abra um terminal nela;
3. Digite `mvn install`, logo em seguida, digite `java -jar target/alexandria-library-1.0-SNAPSHOT-jar-with-dependencies.jar`;
4. Use a interface gráfica para testar o sistema.

## Descrição do Sistema:
O sistema foi implementado seguindo o padrão **MVC**, e possui cinco pacotes: `Models`, `Views`, `Controllers`, `Data` e `Utils`. No primeiro pacote, estão os modelos de classe que fazem parte do sistema, como os diferentes `Usuários (User, LibraryUser, Employee, Manager)`, `Livro (Book)` e `Empréstimos (Loan)`, há também o `enum Genre`. Já em `Views`, estão as telas que são apresentada para os usuários, assim como uma classe-mãe `Screen` da qual todas as outras telas herdam. Em `Controllers` há as classes que realmente controlam, criam e administram Objetos das classes das `models`, que são chamadas pelas classes de `Views`, completando o modelo **MVC**, há também as classes que controlam `Login` e `WindowEvents`, que controla os eventos de abertura e fechamento da Janela. Além dos pacotes desse modelo, há o pacote `Data`, em que são armazenados os arquivos lidos e escritos, de extensão `.json`, `bookdata, employeedata, loandata, managerdata e userdata`. Há também o pacote `Utils`, em que está uma classe abstrata `Constants`, a qual possui todas as strings e valores fixos, a classe `JSON`, que manipula os arquivos `.json` usando a biblioteca [`gson`, do Google](https://github.com/google/gson) e a classe `FileIO`, que controla a entrada e saída em arquivos usando `gson`. 
<br>
A *Herança* é usada para todas as telas, que herdam de `Screen`, assim como para os usuários. Já o *polimorfismo* é usado no construtor dessas classes para diferenciar a maneira como são usadas.
<br>
A *Classe Abstrata* `Constants` é usada para definir constantes que são usadas por todo o projeto. Usamos também a *interface* `Drawer`, que obriga todas as telas a definirem um método `draw`, o qual deve "desenhar" na tela todos os elementos.
<br>
Usamos muitas *listas* de objetos das `models` como `List e ArrayList` como *coleção*. Para *tratar exceções* de diversos tipos, como preenchimento de formulários e de *leitura e escrita dos arquivos* `.json` em `data`.
<br>
Além disso, as classes que compõe as `Views` funcionam como *Interface Gráfica* utilizando o **Swing**, do Java.

## Integrantes do Grupo:
* [Gabriel Frasson Costa - 202035001](https://github.com/GFrasson);
* [Isadora Gonçalves Ferreira - 202035017](https://github.com/isa56);
* [Nélio Alves Gouvêa - 201935037](https://github.com/NelioGouvea);

## Links Importantes:
* [Enunciado](https://drive.google.com/file/d/1tSs02AVMjhpnLdY8hz3z4NkEfP1iElu5/view?usp=sharing);
* [GitHub](https://github.com/isa56/Trab-OO-21.3-Alexandria-Library);
* [Diagrama UML](https://whimsical.com/library-QDHPYk5Heu1yxXjxdszpeS);
* [Documentação](https://docs.google.com/document/d/12vQCwFmxIfWlj0aecTC6e5dEiQZnVNvYpGeK84B6ZIg/edit?usp=sharing);
* [Slide](https://www.canva.com/design/DAExTqRL9TM/W0bkBqGoevsf_PAh8CJ00Q/view?utm_content=DAExTqRL9TM&utm_campaign=designshare&utm_medium=link&utm_source=sharebutton);
* [Vídeo](https://youtu.be/xlqUIzIDYfM);
* [Mockup da Interface do Usuário](https://www.figma.com/file/vMCnSn9rKDv7W9a2k9zrpG/Alexandria?node-id=0%3A1).

## Requisitos de Sistema:
1. Sistema de Login;
2. Usuários com direitos diferentes;
3. Listagem de Livros;
4. Relatório de Usuários que emprestaram um livro;
5. Empréstimo e Devolução de Livros.
