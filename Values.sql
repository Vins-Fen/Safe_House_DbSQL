Use Piattaforma_Prenotazione_Camere;

INSERT INTO Stanze (Codice, Stato, Tipo, Capienza, Giorno_Pre, Check_in, Check_out, Servizi_Offerti, Fascia_Oraria)
VALUES
    -- Stanze di tipo Meeting
    ('M100', 'Disponibile', 'Meeting', 20,'2025-01-15', NULL, NULL, NULL, '08:00-18:00'),
    ('M002', 'Occupata', 'Meeting', 15, '2025-01-16', NULL, NULL, NULL, '09:00-17:00'),
    ('M003', 'Disponibile', 'Meeting', 50, '2025-01-25', NULL, NULL, NULL, '9:00-12:00'),
    ('M004', 'Disponibile', 'Meeting', 30, '2025-01-25', NULL, NULL, NULL, '10:00-12:00'),
    ('M005', 'Occupata', 'Meeting', 20, '2025-01-26', NULL, NULL, NULL, '14:00-18:00'),
    ('M006', 'Disponibile', 'Meeting', 50, '2025-01-27', NULL, NULL, NULL, '10:00-13:00'),
    ('M007', 'Occupata', 'Meeting', 15, '2025-01-28', NULL, NULL, NULL, '8:00-10:00'),
    ('M008', 'Disponibile', 'Meeting', 25, '2025-01-29', NULL, NULL, NULL, '11:00-14:00'),
    ('M009', 'Disponibile', 'Meeting', 40, '2025-01-30', NULL, NULL, NULL, '13:00-16:00'),
    ('M010', 'Occupata', 'Meeting', 60, '2025-01-31', NULL, NULL, NULL, '9:00-12:00'),
    ('M011', 'Disponibile', 'Meeting', 35, '2025-02-01', NULL, NULL, NULL, '14:00-18:00'),
    ('M012', 'Disponibile', 'Meeting', 40, '2025-01-30', NULL, NULL, NULL, '13:00-16:00'),
    ('M013', 'Occupata', 'Meeting', 60, '2025-01-31', NULL, NULL, NULL, '9:00-12:00'),
    ('M014', 'Disponibile', 'Meeting', 40, '2025-01-30', NULL, NULL, NULL, '13:00-16:00'),





-- Stanze di tipo B&B
    ('B001', 'Occupata', 'B&B', NULL,NULL, '2025-01-22 14:00:00', '2025-01-23 10:00:00', 'Colazione Inclusa', NULL),
    ('B002', 'Disponibile', 'B&B', NULL, NULL, '2025-01-22 14:00:00', '2025-01-28 14:00:00', 'Parcheggio Gratuito', NULL),
    ('B003', 'Occupata', 'B&B', NULL, NULL, '2025-01-24 14:00', '2025-01-25 10:00', 'WiFi, Colazione inclusa', NULL),
    ('B004', 'Occupata', 'B&B', NULL, NULL, '2025-01-24 14:00', '2025-01-25 10:00', 'WiFi, Colazione inclusa', NULL),
    ('B005', 'Disponibile', 'B&B', NULL, NULL, '2025-01-25 16:00', '2025-01-26 10:00', 'WiFi, TV', NULL),
    ('B006', 'Occupata', 'B&B', NULL, NULL, '2025-01-26 14:00', '2025-01-27 10:00', 'WiFi, Parcheggio gratuito', NULL),
    ('B007', 'Occupata', 'B&B', NULL, NULL, '2025-01-28 13:00', '2025-01-29 10:00', 'WiFi, Animali ammessi', NULL),
    ('B008', 'Occupata', 'B&B', NULL, NULL, '2025-02-02 16:00', '2025-02-03 11:00', 'WiFi, Vista montagna', NULL),
    ('B009', 'Disponibile', 'B&B', NULL, NULL, '2025-02-01 14:00', '2025-02-02 10:00', 'WiFi, Colazione inclusa', NULL),
    ('B010', 'Occupata', 'B&B', NULL, NULL, '2025-02-02 16:00', '2025-02-03 11:00', 'WiFi, Vista montagna', NULL),
    ('B011', 'Disponibile', 'B&B', NULL, NULL, '2025-02-03 15:00', '2025-02-04 10:00', 'Colazione inclusa, Piscina' 'WiFi', NULL)