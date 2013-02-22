#ost.pt mobile example

Nesta repositório é possível encontrar um projecto Android que serve de biblioteca exemplo para a interacção com os módulos OAuth, para autênticação e autorização dos utilizadores na plataforma.

É fornecido também um projecto demonstrativo de como é possível utilizar a biblioteca.

As instruções apresentadas aplicam-se ao Eclipse Development Environment Indigo Service Release 2 com ADT plugin versão 0.9.7 ou superior.

##Requisitos

* Registar aplicação no portal ost.pt e obter os respectivos Consumer Key e Consumer Secret.

##Instruções para a biblioteca


1. No Eclipse, criar um novo projecto a partir de código existente (New->Project->Android->Android Project from Existing code), utilizando a directoria library, e defini-lo como biblioteca, caso não esteja (http://developer.android.com/tools/projects/projects-eclipse.html#SettingUpLibraryProject);

2. Alterar as variáveis CONSUMER_KEY e CONSUMER_SECRET no *package* android.oauth, ficheiro OAuthConstants.java para as chaves obtidas na plataforma;


##Instruções para o projecto demonstrativo


1. No Eclipse, criar um novo projecto a partir de código existente (New->Project->Android->Android Project from Existing code), utilizando a directoria *sample*;

2. Nas propriedades do projecto, assegurar que o projecto/biblioteca apresentado anteriormente está correctamente configurado com biblioteca.
