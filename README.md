# API-java-spring-boot

CRUD completo de productos
a. Métodos HTTP: GET, POST, DELETE, PUT
b. Endpoints:
Creación: localhost:8181/productos/crear
Lista completa de productos: localhost:8181/productos
Traer un producto en particular: localhost:8181/productos/{codigo_producto}
Eliminación: localhost:8181/productos/eliminar/{codigo_producto}
Edición: localhost:8181/productos/editar/{codigo_producto}

CRUD completo de clientes
a. Métodos HTTP: GET, POST, DELETE, PUT
b. Endpoints:
Creación: localhost:8181/clientes/crear
Lista completa de clientes: localhost:8181/clientes
Traer un cliente en particular: localhost:8181/clientes/{id_cliente}
Eliminación: localhost:8181/clientes/eliminar/{id_cliente}
Edición: localhost:8080/clientes/editar/{id_cliente}

CRUD completo de ventas
a. Métodos HTTP: GET, POST, DELETE, PUT
b. Endpoints:
Creación: localhost:8181/ventas/crear
Lista completa de ventas realizadas: localhost:8181/ventas
Traer una venta en particular: localhost:8181/ventas/{codigo_venta}
Eliminación: localhost:8181/clientes/eliminar/{codigo_venta}
Edición: localhost:8080/clientes/editar/{codigo_venta}

Obtener todos los productos cuya cantidad_disponible sea menor a 5
a. Métodos HTTP: GET
b. Endpoint:
localhost:8181/productos/falta_stock

Obtener la lista de productos de una determinada venta
a. Métodos HTTP: GET
b. Endpoint:
localhost:8181/ventas/productos/{codigo_venta}

Obtener la sumatoria del monto y también cantidad total de ventas de un determinado
día
a. Métodos HTTP: GET
b. Endpoint:
localhost:8181/ventas/{fecha_venta}
