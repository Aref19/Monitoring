CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Eindeutiger Identifikator (Primärschlüssel)
    name VARCHAR(255) NOT NULL,        -- Name des Benutzers (max. 255 Zeichen)
    email VARCHAR(255) UNIQUE NOT NULL, -- Eindeutige E-Mail-Adresse
    password_hash VARCHAR(255) NOT NULL, -- Verschlüsseltes Passwort
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Erstellungsdatum
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Aktualisierungsdatum
);