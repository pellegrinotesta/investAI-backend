CREATE TABLE `user` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `surname` varchar(255),
  `email` varchar(255) UNIQUE,
  `password` varchar(255),
  `status` varchar(255)
);

CREATE TABLE `roles` (
  `user_id` bigint PRIMARY KEY,
  `role` varchar(255)
);

CREATE TABLE `cliente` (
  `id` varchar(255) PRIMARY KEY,
  `user_id` bigint UNIQUE,
  `codice_fiscale` varchar(255) UNIQUE,
  `data_nascita` date,
  `telefono` varchar(255),
  `indirizzo` varchar(255),
  `profilo_rischio` varchar(255),
  `data_registrazione` datetime,
  `ultimo_accesso` datetime
);

CREATE TABLE `password_reset_token` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `token` varchar(255),
  `user_id` bigint,
  `expiry_date` datetime
);

CREATE TABLE `conto_corrente` (
  `id` varchar(255) PRIMARY KEY,
  `cliente_id` varchar(255),
  `numero_conto` varchar(255) UNIQUE,
  `iban` varchar(255) UNIQUE,
  `saldo` decimal,
  `valuta` varchar(255) DEFAULT 'EUR',
  `data_apertura` date,
  `stato` varchar(255),
  `filiale` varchar(255)
);

CREATE TABLE `portafoglio` (
  `id` varchar(255) PRIMARY KEY,
  `cliente_id` varchar(255),
  `nome` varchar(255),
  `descrizione` varchar(255),
  `data_creazione` datetime,
  `ultimo_aggiornamento` datetime,
  `valore_totale` decimal,
  `rendimento_ytd` double,
  `livello_rischio` int
);

CREATE TABLE `strumento` (
  `id` varchar(255) PRIMARY KEY,
  `codice_isin` varchar(255) UNIQUE,
  `nome` varchar(255),
  `tipo_strumento` varchar(255),
  `settore` varchar(255),
  `area_geografica` varchar(255),
  `valuta` varchar(255),
  `prezzo_corrente` decimal,
  `ultimo_aggiornamento_prezzo` datetime
);

CREATE TABLE `posizione` (
  `id` varchar(255) PRIMARY KEY,
  `portafoglio_id` varchar(255),
  `strumento_id` varchar(255),
  `quantita` double,
  `prezzo_acquisto` decimal,
  `data_acquisto` datetime,
  `valore_corrente` decimal,
  `plusminusvalenza` decimal,
  `plusminusvalenza_percentuale` double
);

CREATE TABLE `transazione` (
  `id` varchar(255) PRIMARY KEY,
  `cliente_id` varchar(255),
  `portafoglio_id` varchar(255),
  `strumento_id` varchar(255),
  `tipo_transazione` varchar(255),
  `quantita` double,
  `prezzo` decimal,
  `importo_totale` decimal,
  `data_transazione` datetime,
  `stato` varchar(255),
  `commissioni` decimal
);

CREATE TABLE `simulazione` (
  `id` varchar(255) PRIMARY KEY,
  `cliente_id` varchar(255),
  `nome` varchar(255),
  `descrizione` varchar(255),
  `data_creazione` datetime,
  `tipo_simulazione` varchar(255),
  `data_inizio` date,
  `data_fine` date,
  `investimento_iniziale` decimal,
  `versamento_mensile` decimal,
  `livello_rischio` int,
  `stato` varchar(255)
);

CREATE TABLE `risultato_simulazione` (
  `id` varchar(255) PRIMARY KEY,
  `simulazione_id` varchar(255),
  `timestamp` datetime,
  `valore_proiettato` decimal,
  `rendimento_annualizzato` double,
  `volatilita` double,
  `livello_confidenza` double,
  `scenario_ottimistico` decimal,
  `scenario_pessimistico` decimal
);

CREATE TABLE `dati_mercato` (
  `id` varchar(255) PRIMARY KEY,
  `strumento_id` varchar(255),
  `data` date,
  `prezzo_apertura` decimal,
  `prezzo_massimo` decimal,
  `prezzo_minimo` decimal,
  `prezzo_chiusura` decimal,
  `volume` bigint,
  `prezzo_chiusura_aggiustato` decimal
);

CREATE TABLE `avviso` (
  `id` varchar(255) PRIMARY KEY,
  `cliente_id` varchar(255),
  `strumento_id` varchar(255),
  `portafoglio_id` varchar(255),
  `tipo_avviso` varchar(255),
  `soglia` decimal,
  `messaggio` varchar(255),
  `data_creazione` datetime,
  `data_attivazione` datetime,
  `stato` varchar(255)
);

ALTER TABLE `cliente` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `roles` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `password_reset_token` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `simulazione` ADD FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

ALTER TABLE `conto_corrente` ADD FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

ALTER TABLE `portafoglio` ADD FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

ALTER TABLE `posizione` ADD FOREIGN KEY (`portafoglio_id`) REFERENCES `portafoglio` (`id`);

ALTER TABLE `posizione` ADD FOREIGN KEY (`strumento_id`) REFERENCES `strumento` (`id`);

ALTER TABLE `transazione` ADD FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

ALTER TABLE `transazione` ADD FOREIGN KEY (`portafoglio_id`) REFERENCES `portafoglio` (`id`);

ALTER TABLE `transazione` ADD FOREIGN KEY (`strumento_id`) REFERENCES `strumento` (`id`);

ALTER TABLE `risultato_simulazione` ADD FOREIGN KEY (`simulazione_id`) REFERENCES `simulazione` (`id`);

ALTER TABLE `dati_mercato` ADD FOREIGN KEY (`strumento_id`) REFERENCES `strumento` (`id`);

ALTER TABLE `avviso` ADD FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

ALTER TABLE `avviso` ADD FOREIGN KEY (`strumento_id`) REFERENCES `strumento` (`id`);

ALTER TABLE `avviso` ADD FOREIGN KEY (`portafoglio_id`) REFERENCES `portafoglio` (`id`);
