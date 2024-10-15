CREATE TABLE productos_ingredientes (
    productos_id BIGINT NOT NULL,
    ingredientes VARCHAR(255) NOT NULL,
    PRIMARY KEY (productos_id, ingredientes),
    CONSTRAINT fk_productos FOREIGN KEY (productos_id) REFERENCES productos(id)
);
