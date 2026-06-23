import java.nio.file.Path;
import java.sql.*;
import java.io.File;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class Main {

    private static Connection connection;
    private static Statement statement;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        File file=(Path.of("src/").resolve("clienti.csv").toFile());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/Piattaforma_Prenotazione_Camere";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, "root", "Xbox360xp!");
                System.out.println("Inserire la scelta che si vuole effettuare\n" +
                        "1) Inserimento\n" +
                        "2) Modifica\n" +
                        "3) Cancellazione\n" +
                        "4) Select\n" +
                        "5) Inserimento automatico\n" +
                        "0) Uscita\n"
                );
                int scelta;
                do {
                    scelta = scanner.nextInt();
                    switch (scelta) {
                        case 1 -> inserimento(connection);
                        case 2 -> modifica(connection);
                        case 3 -> cancellazione(connection);
                        case 4 -> query(connection);
                        case 5 -> inserimento_automatico(file, connection);
                        case 0 -> System.exit(0);
                        default -> System.out.println("\nScelta sbagliata, inserisci una nuova opzione.");
                    }
                } while (scelta != 0);
                connection.close();

            } catch (Exception e) {
                System.out.println("Connessione Fallita \n");
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println("Connessione Fallita \n");
        }
    }


    public static void inserimento(Connection connection) {

        System.out.println("Inserire il nome del cliente");
        String nome = scanner.next();
        System.out.println("Inserire il cognome del cliente");
        String cognome = scanner.next();
        System.out.println("Inserire il codice fiscale del cliente");
        String cf = scanner.next();
        System.out.println("Inserire il Numero Civico del cliente");
        int numeroCivico = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserire la via del cliente");
        String via = scanner.next();
        scanner.nextLine();
        System.out.println("Inserire il cap del cliente");
        int cap = scanner.nextInt();


        String sql = "INSERT INTO Clienti (Nome, Cognome, CF, Numero_Civico, Via, Cap) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, cf);
            stmt.setInt(4, numeroCivico);
            stmt.setString(5, via);
            stmt.setInt(6, cap);

            stmt.executeUpdate();
            System.out.println("Cliente inserito con successo!");

        } catch (SQLException e) {
            System.out.println("Errore durante l'inserimento del cliente!");
            e.printStackTrace();
        }
    }

    public static void modifica(Connection connection) {
        System.out.println("Inserire il codice fiscale del cliente da modificare:");
        String cf = scanner.next();

        System.out.println("Inserire il nuovo nome del cliente:");
        String nome = scanner.next();

        System.out.println("Inserire il nuovo cognome del cliente:");
        String cognome = scanner.next();

        System.out.println("Inserire il nuovo Numero Civico del cliente:");
        int numeroCivico = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline rimasto

        System.out.println("Inserire la nuova via del cliente:");
        String via = scanner.nextLine();

        System.out.println("Inserire il nuovo CAP del cliente:");
        int cap = scanner.nextInt();

        String update = "UPDATE Clienti SET Nome = ?, Cognome = ?, Numero_Civico = ?, Via = ?, Cap = ? WHERE CF = ?";

        try (PreparedStatement stmt = connection.prepareStatement(update)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setInt(3, numeroCivico);
            stmt.setString(4, via);
            stmt.setInt(5, cap);
            stmt.setString(6, cf);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Modifica effettuata con successo.");
            } else {
                System.out.println("Nessun cliente trovato con il codice fiscale specificato.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void cancellazione(Connection connection) {
            System.out.println("Inserire il codice fiscale del cliente da eliminare:");
            String cf = scanner.next();

            String deleteSQL = "DELETE FROM Clienti WHERE CF = ?";

            try (PreparedStatement stmt = connection.prepareStatement(deleteSQL)) {
                stmt.setString(1, cf);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cliente eliminato con successo.");
                } else {
                    System.out.println("Nessun cliente trovato con il codice fiscale specificato.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void query(Connection connection) {
        System.out.println("Inserire la query SQL da eseguire (es. SELECT * FROM Clienti):");
        scanner.nextLine(); // Pulisce il buffer dello scanner
        String sql = scanner.nextLine();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            // Ottiene il numero di colonne nella tabella
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Stampa le intestazioni delle colonne
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Stampa i dati delle righe
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Errore nell'esecuzione della query!");
            e.printStackTrace();
        }
    }

    public static void inserimento_automatico(File file,Connection connection) {

        String sql = "INSERT INTO Clienti (Nome, Cognome, CF, Numero_Civico, Via, Cap) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            Scanner in = new Scanner(file);
            String line;
            in.nextLine();
            while (in.hasNextLine()) {
                 line = in.nextLine();
                String[] parts;
                parts=line.split(",");
                if(parts.length != 6) {
                    System.out.println("Riga incompleta." + line);
                    continue;
                }
                parts = line.split(",");

                String nome = parts[0].trim();
                String cognome = parts[1].trim();
                String cf = parts[2].trim();
                int numeroCivico = Integer.parseInt(parts[3].trim());
                String via = parts[4].trim();
                int cap = Integer.parseInt(parts[5].trim());

                statement.setString(1, nome);
                statement.setString(2, cognome);
                statement.setString(3, cf);
                statement.setInt(4, (numeroCivico));
                statement.setString(5, via);
                statement.setInt(6, cap);

                statement.executeUpdate();
            }
            System.out.println("Dati importati con successo!");
        }
            catch( Exception e){
                System.out.println("ERRORE, Dati non importati");
                e.printStackTrace();

            }

    }


}



