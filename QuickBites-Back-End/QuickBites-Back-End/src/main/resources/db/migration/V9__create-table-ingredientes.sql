CREATE TABLE ingredientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    producto_id BIGINT,
    nombre VARCHAR(255),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);
