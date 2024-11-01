
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

### Ejecutar RabbitMQ

```
docker run --rm -d -p 6379:6379 redis
```

# Construccion

Para poder construir el proyecto se necesita ejecutar los contenedores de Redis y RabbitMQ

Una vez ejecutados, en raiz del multimodulo ejecutar:

```
mvn package
```

Esto creara 2 contenedores:

1. c7_command
2. c7_query

## Levantar el projecto completo con Docker Compose

En la raiz del projecto:

```
docker compose up
```

Lo anterior levantará todos los contenedores necesarios, ahora ya podremos usar el API.

## Pruebas de la API


### Usar el API con HTTPie

Crear un pedido

```
http :8180/pedidos/ pedidoId=1 clienteId=22 -v
```

Salida

```
POST /pedidos/ HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 36
Content-Type: application/json
Host: localhost:8180
User-Agent: HTTPie/3.2.3

{
    "clienteId": "22",
    "pedidoId": "1"
}


HTTP/1.1 200
Connection: keep-alive
Content-Length: 4
Content-Type: application/json
Date: Fri, 01 Nov 2024 00:51:06 GMT
Server: nginx/1.25.1

true
```

Consultar el estado de un pedido

```
http :8180/pedidos/1
```

Salida

```
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Fri, 01 Nov 2024 00:52:06 GMT
Server: nginx/1.25.1
Transfer-Encoding: chunked

{
    "clienteId": "22",
    "esConfirmado": false,
    "pedidoId": "1"
}
```
