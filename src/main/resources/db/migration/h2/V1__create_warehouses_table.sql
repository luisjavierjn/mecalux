-- Crea la tabla de almacenes
CREATE TABLE IF NOT EXISTS WAREHOUSES (
    ID      INT             NOT NULL,
    UUID    CHAR(36)        NOT NULL,
    CLIENT  CHAR(50)        NOT NULL,
    FAMILY  CHAR(3)         NOT NULL,
    SIZE    INT             NOT NULL,
    PRIMARY KEY (ID)
);