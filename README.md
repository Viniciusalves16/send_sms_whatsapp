# Send_SMS_Twilio
Aplicação de envio SMS e Whatsapp utilizando a LIB Twilio.

"A Twilio é uma empresa americana de comunicação em nuvem com sede em São Francisco, Califórnia, que fornece ferramentas de comunicação programáveis para fazer e receber chamadas telefônicas, enviar e receber mensagens de texto e executar outras funções de comunicação usando suas APIs de serviços da web" [https://en.wikipedia.org/wiki/Twilio].

Você pode saber mais sobre o seu uso em: https://www.twilio.com/pt-br

O projeto está separado em dois pacotes, o primeiro é referente ao envio de SMS e segundo com todas as classes para envio de mensagem através do WhatsApp.
 
![image](https://github.com/user-attachments/assets/15ec1638-86a6-48e9-861e-0e88dc573bd1)

1 - Envio de SMS
- O primeiro passo é a criação de uma conta na plataforma Twilio:
- Após a criação da conta, será criado automaticamente algumas credencias que você vai ter que configurar em sua aplicação para disparo das mensagens.

![image](https://github.com/user-attachments/assets/baca2bc5-bbc4-414f-b93c-491b09a7db6e)

- Adicionar a dependencia abaixo no POM da sua aplicação.
  
![image](https://github.com/user-attachments/assets/b7df48ba-a0ad-4077-8331-2dce0cb233eb)

- A forma mais segura de configuração é através das variaveis de ambiente, seguindo modelo abaixo.
  
![image](https://github.com/user-attachments/assets/b1192915-70ca-4991-9bc6-5e9f751f9999)

Nesse projeto eu optei por receber o número de telefone através de um parametro via Path, deixando a forma de recebimento do número mais flexível.

- Criei a classe "SmsController" para envio do SMS.
- Nessa classe eu optei por receber os valores de credenciais através de variaveis utilizando as anotações @Value : @Value("${Twilio.account_sid}").
- Criado um chamada HTTP do tipo Post: @PostMapping("/sms/{number}").
- É necessário inicializar o método init dentro da LIB Twilio:  Twilio.init(account_sid, auth).
- Por se tratar de uma requisição sendo feita a outra API, utilizei um Try Catch para tratarmos exceptions que possam ser retornadas.
- Inicializamos um Objeto Message, acionando o método creator e passamos os dados de parametros que são necessários:
     - Telefone;
     - Mensagem personalizada.
       
![image](https://github.com/user-attachments/assets/5267a165-4842-42ee-8083-1ed3e06598e7)


- SMS Recebido

![image](https://github.com/user-attachments/assets/604d048d-b611-4195-aeb7-6d1831a736cd)



2 - Envio de notificações pelo WhatsApp

- Criação de uma classe Properties configurando suas credenciais.

  ![image](https://github.com/user-attachments/assets/898fa844-d66d-46b8-aec4-61e02fd3cadd)

- Necessário a criação de uma classe "TwilioInitializer", onde você realiza a configuração e implementa uma interface do tipo ApplicationRunner que inicializa automaticamente.

  ![image](https://github.com/user-attachments/assets/f0b113df-41cf-4de9-a53f-1b701d78ebdd)

- Seguindo a mesma dinamica do disparo de SMS, foi criado uma controller para disparo da notificação, onde após receber esse estimulo, temos um Try Catch que aciona o método: this.sendWhatsappMessageNotification.dispatchNewArticleNotification();

 ![image](https://github.com/user-attachments/assets/acef14fc-fcca-4135-8cd0-4d1ecf7fc052)


- Foi criado uma classe com a anotação @Service, onde esta configurado a inicialização do Método Twilio.init.
- Além da configuração de disparo da mensagem através do objeto Message e do método creator.
- Após preencher todos os parametros necessários é necessário colocar o .create() para que o disparo seja criado.
- Necessário resgatar o seu phoneNumber que é criado na plataforma Twilio, pois o parametro pede tanto o seu telefone, como também o criado por eles durante seu cadastro.

![image](https://github.com/user-attachments/assets/c335f355-eafb-4ea7-a783-e2dd8999b0fc)

- Notificação enviada!

  ![image](https://github.com/user-attachments/assets/652d75f6-c708-450f-9e33-d025f6243b79)


Dúvidas e sugestões são bem vindas!
