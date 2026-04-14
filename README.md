# WhatsApp Business API Webhook

Esse repositório fornece um Webhook simples feito com Spring Boot para o WhatsApp Business API, e foi criado com o objetivo de servir de apoio para o documento em disponível em:

[Documentação Envio de Mensagens usando WhatsApp Business API](https://docs.google.com/document/d/1DOv0iXL17lK9_dhhf95fZODStsolWFrtgMxo45DtloY/edit?usp=sharing)

___

## Requisitos
- Java
- Node.js

---

## Rodar o Webhook Spring

Para rodar o servidor, simplesmente digite os seguintes comandos no terminal, enquanto estiver na raíz do projeto

| Sistema | Comando                    |
|---------|----------------------------|
| Linux   | `./mvnw spring-boot:run`   |
| Windows | `mvnw.cmd spring-boot:run` |

Esse comando irá iniciar o servidor no `http://localhost:8080`

Os endpoints disponíveis são:

- GET /webhook – usado pelo Meta para verificar o webhook
- POST /webhook – recebe as notificações (mensagens, status, etc.)

---

## Expor o servidor

Para utilizar o webhook com a API do WhatsApp Business, é necessário que a URL do webhook seja pública.
Dessa forma, tem-se que fazer um tunneling para expor o servidor Spring.

Para expor o webhook, digite o seguinte comando em um terminal limpo:

```npx localtunnel --port 8080```

- Se requisitado, aperte **y** para instalar o localtunnel.

Esse comando irá criar um "tunel" e conectar o servidor à internet.

Após isso, copie o endereço mostrado e acesse-o na internet. Quando entrar no site, copie o endereço ip mostrado no topo e cole no local requisitado para ativar o tunel.

Tendo feito isso, insira o endereço na API acompanhado de /webhook, como `https://exemplo.loca.lt/webhook`, como instrui o documento, e adicione o token "MyTestToken".
