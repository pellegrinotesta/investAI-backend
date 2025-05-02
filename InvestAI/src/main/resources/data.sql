INSERT INTO `user` (`id`, `name`, `surname`, `email`, `password`, `status`) VALUES
(1, 'Mario', 'Rossi', 'mario.rossi@example.com', 'hashedpassword1', 'ATTIVO'),
(2, 'Luigi', 'Bianchi', 'luigi.bianchi@example.com', 'hashedpassword2', 'ATTIVO');

INSERT INTO `roles` (`user_id`, `role`) VALUES
(1, 'CLIENTE'),
(2, 'ADMIN');

INSERT INTO `cliente` (`cliente_id`, `user_id`, `codice_fiscale`, `email`, `password_hash`, `nome`, `cognome`, `data_nascita`, `telefono`, `indirizzo`, `profilo_rischio`, `data_registrazione`, `ultimo_accesso`, `stato`) VALUES
('CL001', 1, 'RSSMRA80A01H501Z', 'mario.rossi@example.com', 'hashedpassword1', 'Mario', 'Rossi', '1980-01-01', '3331234567', 'Via Roma 1, Milano', 'MEDIO', NOW(), NOW(), 'ATTIVO');

INSERT INTO `password_reset_token` (`id`, `token`, `user_id`, `expiry_date`) VALUES
(1, 'reset-token-123', 1, DATE_ADD(NOW(), INTERVAL 1 DAY));

 INSERT INTO `conto_corrente` (`conto_id`, `cliente_id`, `numero_conto`, `iban`, `saldo`, `valuta`, `data_apertura`, `stato`, `filiale`) VALUES
 ('CC001', 'CL001', 'IT1234567890', 'IT60X0542811101000000123456', 10000.50, 'EUR', '2022-01-01', 'ATTIVO', 'Milano Centro');

INSERT INTO `portafoglio` (`portafoglio_id`, `cliente_id`, `nome`, `descrizione`, `data_creazione`, `ultimo_aggiornamento`, `valore_totale`, `rendimento_ytd`, `livello_rischio`) VALUES
('PF001', 'CL001', 'Portafoglio Principale', 'Investimenti a medio rischio', NOW(), NOW(), 15000.00, 5.3, 3);

INSERT INTO `strumento` (`strumento_id`, `codice_isin`, `nome`, `tipo_strumento`, `settore`, `area_geografica`, `valuta`, `prezzo_corrente`, `ultimo_aggiornamento_prezzo`) VALUES
('ST001', 'IT0001234567', 'Azioni ENI', 'Azione', 'Energia', 'Italia', 'EUR', 14.50, NOW());

INSERT INTO `posizione` (`posizione_id`, `portafoglio_id`, `strumento_id`, `quantita`, `prezzo_acquisto`, `data_acquisto`, `valore_corrente`, `plusminusvalenza`, `plusminusvalenza_percentuale`) VALUES
('PZ001', 'PF001', 'ST001', 100, 13.00, '2023-05-01', 1450.00, 150.00, 11.5);

INSERT INTO `transazione` (`transazione_id`, `cliente_id`, `portafoglio_id`, `strumento_id`, `tipo_transazione`, `quantita`, `prezzo`, `importo_totale`, `data_transazione`, `stato`, `commissioni`) VALUES
('TR001', 'CL001', 'PF001', 'ST001', 'ACQUISTO', 100, 13.00, 1300.00, '2023-05-01', 'ESEGUITA', 5.00);

INSERT INTO `simulazione` (`simulazione_id`, `cliente_id`, `nome`, `descrizione`, `data_creazione`, `tipo_simulazione`, `data_inizio`, `data_fine`, `investimento_iniziale`, `versamento_mensile`, `livello_rischio`, `stato`) VALUES
('SIM001', 'CL001', 'Simulazione pensione', 'Proiezione a 20 anni', NOW(), 'LUNGO_TERMINE', '2025-01-01', '2045-01-01', 10000.00, 200.00, 3, 'ATTIVA');

INSERT INTO `risultato_simulazione` (`risultato_id`, `simulazione_id`, `timestamp`, `valore_proiettato`, `rendimento_annualizzato`, `volatilita`, `livello_confidenza`, `scenario_ottimistico`, `scenario_pessimistico`) VALUES
('RS001', 'SIM001', NOW(), 80000.00, 6.5, 10.2, 95, 90000.00, 60000.00);

INSERT INTO `dati_mercato` (`dato_id`, `strumento_id`, `data`, `prezzo_apertura`, `prezzo_massimo`, `prezzo_minimo`, `prezzo_chiusura`, `volume`, `prezzo_chiusura_aggiustato`) VALUES
('DM001', 'ST001', '2025-05-02', 14.20, 14.80, 14.00, 14.50, 1200000, 14.50);

INSERT INTO `avviso` (`avviso_id`, `cliente_id`, `strumento_id`, `portafoglio_id`, `tipo_avviso`, `soglia`, `messaggio`, `data_creazione`, `data_attivazione`, `stato`) VALUES
('AV001', 'CL001', 'ST001', 'PF001', 'PREZZO_SUPERA', 15.00, 'Il prezzo ha superato 15€', NOW(), NULL, 'INATTIVO');
