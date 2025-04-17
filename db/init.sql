BEGIN;

INSERT INTO public.cliente (estado, edad, direccion, genero, identificacion, nombre, password, telefono, codigo_cliente) 
VALUES (0, 25, 'Otavalo sn y principal', 'Masculino', 'ID123456', 'Jose Lema', '1234', '098254785',1);

INSERT INTO public.cliente (estado, edad, direccion, genero, identificacion, nombre, password, telefono, codigo_cliente) 
VALUES (0, 32, 'Amazonas y NNUU', 'Femenino', 'ID654321', 'Marianela Montalvo', '5678', '097548965',2);

INSERT INTO public.cliente (estado, edad, direccion, genero, identificacion, nombre, password, telefono, codigo_cliente) 
VALUES (0, 40, '13 junio y Equinoccial', 'Masculino', 'ID987654', 'Juan Osorio', '1245', '098874587',3);



INSERT INTO public.cuenta (estado, saldo_actual, saldo_inicial, tipo_cuenta, cliente, numero_cuenta, codigo_cuenta) 
VALUES (0, 2000.00, 2000.00, 0, 1, '478758', 1 );

INSERT INTO public.cuenta (estado, saldo_actual, saldo_inicial, tipo_cuenta, cliente, numero_cuenta, codigo_cuenta) 
VALUES (0, 100.00, 100.00, 1, 2, '225487', 2 );

INSERT INTO public.cuenta (estado, saldo_actual, saldo_inicial, tipo_cuenta, cliente, numero_cuenta, codigo_cuenta) 
VALUES (0, 0.00, 0.00, 0, 3, '495878', 3 );

INSERT INTO public.cuenta (estado, saldo_actual, saldo_inicial, tipo_cuenta, cliente, numero_cuenta, codigo_cuenta) 
VALUES (0, 540.00, 540.00, 0, 2, '496825', 4 );




INSERT INTO public.movimiento (saldo, tipo_movimiento, valor, codigo_cuenta, fecha) 
VALUES (1425.00, 1, 2000.00, 1, '2025-04-01 10:30:00');

INSERT INTO public.movimiento (saldo, tipo_movimiento, valor, codigo_cuenta, fecha) 
VALUES (700.00, 0, 100.00, 2, '2025-04-02 10:30:00');

INSERT INTO public.movimiento (saldo, tipo_movimiento, valor, codigo_cuenta, fecha) 
VALUES (150.00, 0, 150.00, 3, '2025-04-03 10:30:00');

INSERT INTO public.movimiento (saldo, tipo_movimiento, valor, codigo_cuenta, fecha) 
VALUES (0.00, 1, 540.00, 4, '2025-04-04 10:30:00');

SELECT setval('cliente_codigo_cliente_seq', (SELECT MAX(codigo_cliente) FROM cliente));

SELECT setval('movimiento_codigo_movimiento_seq', (SELECT MAX(codigo_movimiento) FROM movimiento));

SELECT setval('cuenta_codigo_cuenta_seq', (SELECT MAX(codigo_cuenta) FROM cuenta));

COMMIT;