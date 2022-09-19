public class Main {

    public static void main(String[] args) {


        String svar;


        while (true) {

            svar = TerminalIO.getString("hvad ønsker du? marks eller malenes");

            switch (svar){

                case "mark":
                    System.out.println(DBConnector.getMarkConnection());
                    break;
                case "malene":
                    System.out.println(DBConnector.getMaleneConnection());
                    break;
            }
        }


    }


}
