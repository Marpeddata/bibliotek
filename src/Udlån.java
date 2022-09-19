import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Udlån {

    TerminalIO terminal = new TerminalIO();

    void opretLåner(){
        String lånerNavn;
        String Adresse;
        int postNr;


        lånerNavn = terminal.getString("Skriv navn");
        Adresse = terminal.getString("Skriv adresse");
        postNr = terminal.getInt("Skriv postnummer");

        String sql = "INSERT INTO lånertabel (navn, adresse, postnr) VALUES (?,?,?)";


        // se lige try-with-resources f.eks. her  https://www.baeldung.com/java-try-with-resources
        try (Connection con = DBConnector.getMarkConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            // her klargøres mit prepared statement ved at min parametre indsættes.
            ps.setString(1, lånerNavn);
            ps.setString(2, Adresse);
            ps.setInt(3, postNr);


            ps.executeUpdate();    //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

//            ResultSet ids = ps.getGeneratedKeys();
//            ids.next();
//            int id = ids.getInt(1);
//
//
//            System.out.println("Vi er nået til række : " + id);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void opretBog(){
        String forfatterNavn;
        String titel;
        int udgivelsesÅr;


        forfatterNavn = terminal.getString("Skriv forfatterens navn");
        titel = terminal.getString("Skriv bogens titel");
        udgivelsesÅr = terminal.getInt("Skriv udgivelsesår");

        String sql = "INSERT INTO bogtabel (forfatternavn, titel, udgivelsesår) VALUES (?,?,?)";


        // se lige try-with-resources f.eks. her  https://www.baeldung.com/java-try-with-resources
        try (Connection con = DBConnector.getMarkConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            // her klargøres mit prepared statement ved at min parametre indsættes.
            ps.setString(1, forfatterNavn);
            ps.setString(2, titel);
            ps.setInt(3, udgivelsesÅr);


            ps.executeUpdate();    //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

//            ResultSet ids = ps.getGeneratedKeys();
//            ids.next();
//            int id = ids.getInt(1);
//
//
//            System.out.println("Vi er nået til række : " + id);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    }



