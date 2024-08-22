# Send_SMS_Twilio
Aplicação de envio SMS e Whatsapp utilizando a LIB Twilio


 Projeto esta separado em dois pacotes, um referente ao envio de sms e outro com todas as classes para envio de mensagem através do whatsapp.
 
![image](https://github.com/user-attachments/assets/15ec1638-86a6-48e9-861e-0e88dc573bd1)

1 - Envio de sms
- Primeiro passo é a criação de uma conta na plataforma Twilio:
- Após a criação da conta, será criado automaticamente algumas credencias que você vai ter que configurar em sua aplicação para disparo das mensagens.

![1](https://github.com/user-attachments/assets/83928516-d351-4f10-b8ec-0a3ddc3399d3)

- Adicionar dependencia no pom da sua aplicação.
  
![image](https://github.com/user-attachments/assets/b7df48ba-a0ad-4077-8331-2dce0cb233eb)

  
- Forma mais segura de configurar são através das variaveis de ambiente.
  
![image](https://github.com/user-attachments/assets/b1192915-70ca-4991-9bc6-5e9f751f9999)

Nesse projeto eu optei por receber o numero do telefone através de um parametro Path, assim não há a necessidade de deixar o número fixo no código.
- Foi necessário apenas a criação de uma classe para envio do sms.

- Nessa classe eu optei por receber os valores de credenciais através de variaveis utilizando as anotações @Value : @Value("${Twilio.account_sid}")
- Criado um chamada http do tipo Post: @PostMapping("/sms/{number}")
- Necessário inicializar o método init dentro da lib Twilio:  Twilio.init(account_sid, auth);
- Por se tratar de uma requisição sendo feita a outra API, utilizei um try catch para tratarmos exceptions que possam ser retornadas.
- Inicializamos um Objeto Message, acionando o método creator e passamos os dados de parametros que são necessários.
     - Telefone
     - Mensagem personalizada
![image](https://github.com/user-attachments/assets/9086f20e-1475-4b03-b0de-5c18522859fc)

SMS Recebido
![image](https://github.com/user-attachments/assets/ee862552-3ffb-498e-b9de-44cf792c0d81)

