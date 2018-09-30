CREATE TABLE cooperativa.areas (
    id_area       NUMBER(2) NOT NULL,
    nombre        VARCHAR2(100 BYTE),
    descripcion   VARCHAR2(100 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cooperativa.areas_pk ON
    cooperativa.areas ( id_area ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE cooperativa.areas
    ADD CONSTRAINT areas_pk PRIMARY KEY ( id_area )
        USING INDEX cooperativa.areas_pk;

CREATE TABLE cooperativa.bancos (
    id_banco        NUMBER(*,0) NOT NULL,
    nombre          VARCHAR2(100 BYTE),
    codigo          VARCHAR2(20 BYTE),
    nit             VARCHAR2(20 BYTE),
    numero_cuenta   VARCHAR2(20 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cooperativa.bancos_pk ON
    cooperativa.bancos ( id_banco ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE cooperativa.bancos
    ADD CONSTRAINT bancos_pk PRIMARY KEY ( id_banco )
        USING INDEX cooperativa.bancos_pk;

CREATE TABLE cooperativa.cargos (
    id_cargo      NUMBER(2) NOT NULL,
    titulo        VARCHAR2(25 BYTE),
    descripcion   VARCHAR2(100 BYTE),
    sueldo_base   NUMBER(7,2),
    area_id       NUMBER(2)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cooperativa.cargos_pk ON
    cooperativa.cargos ( id_cargo ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE cooperativa.cargos
    ADD CONSTRAINT cargos_pk PRIMARY KEY ( id_cargo )
        USING INDEX cooperativa.cargos_pk;

CREATE TABLE cooperativa.clientes (
    dui_cliente           VARCHAR2(10 BYTE) NOT NULL,
    nombres               VARCHAR2(50 BYTE),
    apellidos             VARCHAR2(50 BYTE),
    nit                   VARCHAR2(17 BYTE),
    fecha_nacimiento      DATE,
    telefono              VARCHAR2(9 BYTE),
    celular               VARCHAR2(9 BYTE),
    correo                VARCHAR2(100 BYTE),
    estado                VARCHAR2(1 BYTE),
    referente             VARCHAR2(100 BYTE),
    telefono_referente    VARCHAR2(9 BYTE),
    direccion_referente   VARCHAR2(100 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

ALTER TABLE cooperativa.clientes
    ADD CONSTRAINT clientes_pk PRIMARY KEY ( dui_cliente )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE users LOGGING
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT );

ALTER TABLE cooperativa.clientes
    ADD CONSTRAINT clientes_nit_un UNIQUE ( nit )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE users LOGGING
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT );

CREATE TABLE cooperativa.cuotas (
    id_cuota       NUMBER(*,0) NOT NULL,
    prestamo_id    NUMBER(*,0),
    numero_cuota   NUMBER(*,0),
    fecha_limite   DATE,
    estado         VARCHAR2(1 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

ALTER TABLE cooperativa.cuotas
    ADD CONSTRAINT cuotas_pk PRIMARY KEY ( id_cuota )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE users LOGGING
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT );

CREATE TABLE cooperativa.empleados (
    dui_empleado       VARCHAR2(10 BYTE) NOT NULL,
    nombres            VARCHAR2(50 BYTE),
    apellidos          VARCHAR2(50 BYTE),
    direccion          VARCHAR2(100 BYTE),
    nit                VARCHAR2(17 BYTE),
    fecha_nacimiento   DATE,
    fecha_ingreso      DATE,
    telefono           VARCHAR2(9 BYTE),
    celular            VARCHAR2(9 BYTE),
    correo             VARCHAR2(100 BYTE),
    estado             VARCHAR2(1 BYTE),
    cargo_id           NUMBER(2)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

ALTER TABLE cooperativa.empleados
    ADD CONSTRAINT empleados_pk PRIMARY KEY ( dui_empleado )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE users LOGGING
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT );

ALTER TABLE cooperativa.empleados
    ADD CONSTRAINT empleados_nit_un UNIQUE ( nit )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE users LOGGING
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT );

CREATE TABLE cooperativa.pagos (
    id_pago        NUMBER(10),
    prestamo_id    NUMBER(5),
    monto          NUMBER(5,2),
    fecha_pago     DATE,
    empleado_dui   VARCHAR2(10 BYTE),
    estado         VARCHAR2(1 BYTE),
    cuota_id       NUMBER(*,0)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE TABLE cooperativa.prestamos (
    id_prestamo             NUMBER(10) NOT NULL,
    empleado_autoriza_dui   VARCHAR2(15 BYTE),
    solicitud_id            NUMBER(5),
    cliente_dui             VARCHAR2(10 BYTE),
    monto                   NUMBER(7,2),
    tasa_interes_id         NUMBER(2),
    fecha_limite            DATE,
    estado                  VARCHAR2(1 BYTE),
    saldo                   NUMBER(7,2)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cooperativa.prestamos_pk ON
    cooperativa.prestamos ( id_prestamo ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE cooperativa.prestamos
    ADD CONSTRAINT prestamos_pk PRIMARY KEY ( id_prestamo )
        USING INDEX cooperativa.prestamos_pk;

CREATE TABLE cooperativa.remesas (
    id_remesa        NUMBER(*,0) NOT NULL,
    cliente_dui      VARCHAR2(10 BYTE),
    prestamo_id      NUMBER(*,0),
    banco_id         NUMBER(*,0),
    fecha_deposito   DATE,
    monto            NUMBER(7,2),
    estado           VARCHAR2(1 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cooperativa.remesas_pk ON
    cooperativa.remesas ( id_remesa ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE cooperativa.remesas
    ADD CONSTRAINT remesas_pk PRIMARY KEY ( id_remesa )
        USING INDEX cooperativa.remesas_pk;

CREATE TABLE cooperativa.solicitudes (
    id_solicitud   NUMBER(10) NOT NULL,
    cliente_dui    VARCHAR2(10 BYTE),
    empleado_dui   VARCHAR2(10 BYTE),
    fecha          DATE,
    monto          NUMBER(7,2),
    estado         VARCHAR2(1 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

ALTER TABLE cooperativa.solicitudes
    ADD CONSTRAINT solicitudes_pk PRIMARY KEY ( id_solicitud )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE users LOGGING
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT );

CREATE TABLE cooperativa.tasa_interes (
    id_tasa_interes   NUMBER(2) NOT NULL,
    tasa              FLOAT(126),
    estado            VARCHAR2(1 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cooperativa.tasa_interes_pk ON
    cooperativa.tasa_interes ( id_tasa_interes ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE cooperativa.tasa_interes
    ADD CONSTRAINT tasa_interes_pk PRIMARY KEY ( id_tasa_interes )
        USING INDEX cooperativa.tasa_interes_pk;

ALTER TABLE cooperativa.solicitudes
    ADD FOREIGN KEY ( cliente_dui )
        REFERENCES cooperativa.clientes ( dui_cliente )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.solicitudes
    ADD FOREIGN KEY ( empleado_dui )
        REFERENCES cooperativa.empleados ( dui_empleado )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.prestamos
    ADD FOREIGN KEY ( empleado_autoriza_dui )
        REFERENCES cooperativa.empleados ( dui_empleado )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.prestamos
    ADD FOREIGN KEY ( solicitud_id )
        REFERENCES cooperativa.solicitudes ( id_solicitud )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.prestamos
    ADD FOREIGN KEY ( cliente_dui )
        REFERENCES cooperativa.clientes ( dui_cliente )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.cargos
    ADD FOREIGN KEY ( area_id )
        REFERENCES cooperativa.areas ( id_area )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.prestamos
    ADD FOREIGN KEY ( tasa_interes_id )
        REFERENCES cooperativa.tasa_interes ( id_tasa_interes )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.empleados
    ADD FOREIGN KEY ( cargo_id )
        REFERENCES cooperativa.cargos ( id_cargo )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.pagos
    ADD FOREIGN KEY ( prestamo_id )
        REFERENCES cooperativa.prestamos ( id_prestamo )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.pagos
    ADD FOREIGN KEY ( empleado_dui )
        REFERENCES cooperativa.empleados ( dui_empleado )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.remesas
    ADD FOREIGN KEY ( cliente_dui )
        REFERENCES cooperativa.clientes ( dui_cliente )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.remesas
    ADD FOREIGN KEY ( prestamo_id )
        REFERENCES cooperativa.prestamos ( id_prestamo )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.remesas
    ADD FOREIGN KEY ( banco_id )
        REFERENCES cooperativa.bancos ( id_banco )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.cuotas
    ADD FOREIGN KEY ( prestamo_id )
        REFERENCES cooperativa.prestamos ( id_prestamo )
    NOT DEFERRABLE;

ALTER TABLE cooperativa.pagos
    ADD FOREIGN KEY ( cuota_id )
        REFERENCES cooperativa.cuotas ( id_cuota )
    NOT DEFERRABLE;