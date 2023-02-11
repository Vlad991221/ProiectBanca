import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Banca banca = new Banca();

        Cont cont = new ContCurent("RO43293204939", "RON");

        ClientBanca clientBanca1 = new ClientBanca("vl.23",
                "23v.l", "3l2", "Deaconescu", "Vlad",
                "1234532323", "vlad.d21@gmail.com");
        clientBanca1.adaugaCont(cont);

        banca.adaugaClient(clientBanca1);
        System.out.println("Clientii bancii sunt " + banca.getClienti());

        System.out.println("Bine ati venit!");

        try {
            banca.alegeOptiune(scanner);
        } catch (SoldException e) {
            System.out.println(e.getMessage());
        } catch (OperatiuniExceptie e) {
            System.out.println(e.getMessage());
        }
    }
}