# Safe_House_DbSQL

Progetto didattico di gestione database relazionale per una **piattaforma di prenotazione camere** (Safe House), realizzato in Java con connessione JDBC a MySQL. Permette di gestire l'anagrafica clienti tramite operazioni CRUD da riga di comando e l'importazione automatica di dati da file CSV.

## ✨ Funzionalità

Il programma espone un menu interattivo da console con le seguenti operazioni sulla tabella `Clienti`:

1. **Inserimento** — aggiunge un nuovo cliente (Nome, Cognome, Codice Fiscale, Numero Civico, Via, CAP)
2. **Modifica** — aggiorna i dati di un cliente esistente identificato tramite Codice Fiscale
3. **Cancellazione** — elimina un cliente tramite Codice Fiscale
4. **Select** — esegue una query SQL personalizzata inserita dall'utente e ne stampa il risultato tabellare
5. **Inserimento automatico** — importa in blocco i clienti da `clienti.csv`
0. **Uscita** — chiude il programma

## 🛠️ Stack tecnico

- **Java** (JDBC, `PreparedStatement`)
- **MySQL** — driver `com.mysql.cj.jdbc.Driver`
- **CSV** per l'import massivo dei dati

## 📂 Struttura del progetto

```
.
├── Main.java              # logica applicativa, menu CRUD e connessione al DB
├── console.sql            # script SQL (creazione schema/tabelle)
├── Values.sql             # script SQL di popolamento/dati di esempio
├── clienti.csv            # dataset di esempio per l'inserimento automatico
└── Presentazione bd.pdf   # presentazione del progetto/schema del database
```

## ⚙️ Configurazione del database

Il programma si connette a un database MySQL chiamato `Piattaforma_Prenotazione_Camere`:

```java
String url = "jdbc:mysql://127.0.0.1:3306/Piattaforma_Prenotazione_Camere";
```

Per eseguire il progetto:

1. Installa MySQL (o avvia un'istanza locale, es. con MAMP/XAMPP/Docker)
2. Crea il database e le tabelle eseguendo lo script `console.sql`
3. (Opzionale) Popola i dati di esempio con `Values.sql`
4. Assicurati di avere il [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) nel classpath

> ⚠️ **Nota di sicurezza:** le credenziali del database (utente e password) sono attualmente hardcoded nel file `Main.java`. Prima di pubblicare o condividere il progetto, è fortemente consigliato spostarle in un file di configurazione esterno (es. `.properties` o variabili d'ambiente) escluso dal controllo versione, e cambiare la password del database usata in locale.

## ▶️ Esecuzione

Compila ed esegui `Main.java` (assicurandoti che il driver JDBC MySQL sia disponibile nel classpath):

```bash
javac -cp .:mysql-connector-j-x.x.x.jar Main.java
java -cp .:mysql-connector-j-x.x.x.jar Main
```

Verrà mostrato un menu da cui scegliere l'operazione da eseguire sul database.

## 📄 File di dati

- **`clienti.csv`**: formato `Nome,Cognome,CF,Numero_Civico,Via,Cap` (la prima riga viene saltata come intestazione)
- **`Presentazione bd.pdf`**: contiene la presentazione/documentazione dello schema del database

## 📄 Licenza

Progetto sviluppato a scopo didattico/universitario (corso di basi di dati).
