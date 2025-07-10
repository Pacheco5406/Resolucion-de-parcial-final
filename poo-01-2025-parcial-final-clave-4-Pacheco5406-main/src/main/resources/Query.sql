CREATE DATABASE RegalosFDB;
GO

USE RegalosFDB;
GO

CREATE TABLE RegaloFisico
(
    RegaloID INT IDENTITY(1,1) PRIMARY KEY,
    Destinatario NVARCHAR(100) NOT NULL,
    Remitente NVARCHAR(100) NOT NULL,
    Mensaje NVARCHAR(MAX) NOT NULL,
    TipoRegalo NVARCHAR(50) NOT NULL,
    FechaEnvio DATE NOT NULL,
    TipoEnvio NVARCHAR(50) NOT NULL
);
GO

INSERT INTO RegaloFisico
    (Destinatario, Remitente, Mensaje, TipoRegalo, FechaEnvio, TipoEnvio)
VALUES
    ('Ana G�mez', 'Luis P�rez', '�Feliz aniversario!', 'Caja de chocolates', '2025-07-01', 'Mensajer�a'),
    ('Carlos M�ndez', 'Mar�a Ruiz', 'Celebra tu d�a especial', 'Pastel', '2025-07-02', 'Env�o postal'),
    ('Elena S�nchez', 'Jorge L�pez', 'Para tu cumplea�os', 'Zapatos', '2025-07-03', 'Recogida en tienda'),
    ('Ricardo Torres', 'Carla Herrera', 'Un detalle para ti', 'Caja de chocolates', '2025-07-04', 'Mensajer�a'),
    ('M�nica D�az', 'Andr�s Soto', 'Disfruta tu regalo', 'Pastel', '2025-07-05', 'Env�o postal');
GO

SELECT *
FROM RegaloFisico;
GO
