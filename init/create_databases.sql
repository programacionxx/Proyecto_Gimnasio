CREATE DATABASE IF NOT EXISTS db_gimnasio_auth CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE IF NOT EXISTS db_gimnasio_socios CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE IF NOT EXISTS db_gimnasio_membresias CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE IF NOT EXISTS db_gimnasio_pagos CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE IF NOT EXISTS db_gimnasio_clases CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE IF NOT EXISTS db_gimnasio_reservas CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE IF NOT EXISTS db_gimnasio_entrenadores CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

CREATE USER IF NOT EXISTS 'gimnasio'@'%' IDENTIFIED BY 'gimnasio123';
GRANT ALL PRIVILEGES ON db_gimnasio_%.* TO 'gimnasio'@'%';
FLUSH PRIVILEGES;
