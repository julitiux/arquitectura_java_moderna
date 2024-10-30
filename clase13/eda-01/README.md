# Herramientas

## Cliente de HTTP

Sugerencia: httpie

https://httpie.io/

## RabbitMQ container

Es necesario contar con Docker engine instalado en el sistema

### Ejecutar RabbitMQ

```
docker run --rm -d -p 5672:5672 -p 15672:15672 rabbitmq:3.7.25-management-alpine
```


## Pruebas de la API

Asegurarse de primero levantar RabbitMQ, luego levantar la aplicación con:

```
mvn spring-boot:run
```

### Usar el API con HTTPie

Crear un pedido

```
http :8080/pedidos/ pedidoId=1 clienteId=22 -v
```

Salida

```
POST /pedidos/ HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 36
Content-Type: application/json
Host: localhost:8080
User-Agent: HTTPie/3.2.3

{
    "clienteId": "22",
    "pedidoId": "1"
}


HTTP/1.1 200
Connection: keep-alive
Content-Length: 4
Content-Type: application/json
Date: Wed, 30 Oct 2024 01:06:43 GMT
Keep-Alive: timeout=60

true
```

Consultar el estado de un pedido

```
http :8080/pedidos/1
```

Salida

```
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Wed, 30 Oct 2024 01:09:02 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "clienteId": "22",
    "esConfirmado": false,
    "pedidoId": "1"
}
```
