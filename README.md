# Projeto Final - Java Desktop SENAC

 ![Diagrama de Classe](/diagrama.png)

Projeto Final Disciplina Desktop - Pizzaria 

1. O sistema deve ter como primeira tela a página de login.
- Para logar no sistema o usuário deve ter seus dados salvo no banco de dados.
- O usuário vai entrar com login e senha. O sistema vai verificar se existem algum usuário com o esses dados e caso tenha o sistema abrirá a tela principal do sistema, fechando a tela de login. 

2. Na tela principal mostrar menu suspenso e ícone para atalho rápido (Já foram vistos em aulas anteriores). 
- Obs.: A tela principal só fechará quando o sistema for fechado!
- Deverá constar na tela principal menu e ícone para cadastro de cliente e pesquisa de cliente. 
- Deverá constar na tela principal menu e ícone para cadastro de pedido e pesquisa de pedido.
- Deverá constar na tela principal menu para sair do sistema (fechar o sistema).

3. Tela de cadastro de cliente: deverá cadastrar ou alterar o cliente com todos os campos de cliente, pessoas e endereço, conforme testes unitários da DAO cliente que já foram corrigidas em aulas anteriores.

4. Tela de pesquisa de cliente: usar a tabela para listar cliente e um campo para filtrar por nome. Nessa tela deverá ter a ação de excluir e de alterar os clientes que forem listados. Obs.: (Tem vídeo aula explicando como listar usando o componente de tabela do Java Swing.)

5. Tela de cadastro de pedido: Pesquisar um cliente por telefone, e preencher os campos do valor do pedido. O número e a data devem ser gerados pelo sistema, mas deverão aparecer na interface gráfica sempre que forem cadastrar um novo pedido. Para o número do pedido dever ser somado com mais 1 do último gravado no banco. Pegar a data atual do sistema e mostrar da tela para posteriormente gravar no banco também.

6. Tela de pesquisa de pedido: Pode ser duas telas. Na pesquisa deve pesquisar por nome do cliente e mostrar seus pedidos. E pesquisar por data inicial e data final. Mostrar todos os pedidos com seus clientes nesse intervalo inicial e final.

