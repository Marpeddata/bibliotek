import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        String svar;


        while (true) {

            svar = TerminalIO.getString("hvad ønsker du? marks eller malenes");

            switch (svar){

                case "mark":
                    System.out.println(DBConnector.getMarkConnection());
                    printNames();
                    break;
                case "malene":
                    System.out.println(DBConnector.getMaleneConnection());
                    break;
            }
        }


    }

    static void printNames() {
        List<String> kundeList = new ArrayList<>();

        String sql = "select * from lånertabel";

        try (Connection con = DBConnector.getMarkConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {           // https://en.wikipedia.org/wiki/Prepared_statement


            ResultSet resultSet = ps.executeQuery();   //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            while (resultSet.next()) {
                int id = resultSet.getInt("postnr");
                String navn = resultSet.getString("navn");

                kundeList.add(id + " : " + navn);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        for (String s : kundeList) {

            System.out.println(s);

        }
    }


}
