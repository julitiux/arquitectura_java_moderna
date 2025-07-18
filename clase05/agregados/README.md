
### Explicación:

- **Order**: Es la raíz del agregado, controla los **OrderItems** y se asegura de que no se pueda confirmar un pedido vacío.
- **OrderItem**: Parte del agregado, sólo puede ser gestionado a través de **Order**.
- **Product**: Un **Value Object**, es inmutable y no tiene identidad propia dentro del pedido.
- **Customer**: Una entidad referenciada por el **Order**, pero no forma parte del agregado de **Order**.
- **OrderRepository**: Permite la persistencia del agregado.

Este ejemplo ilustra cómo un **Aggregate** ayuda a mantener la consistencia y a encapsular reglas de negocio dentro del contexto de un pedido.
