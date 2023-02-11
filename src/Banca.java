import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banca {
    List<ClientBanca> clienti = new ArrayList<>();

    public void adaugaClient(ClientBanca clientBanca) {
        clienti.add(clientBanca);
    }

    public List<ClientBanca> getClienti() {
        return clienti;
    }

    public void alegeOptiune(Scanner scanner) throws SoldException, OperatiuniExceptie {
        System.out.println("Alege optiunea dorita!");
        System.out.println("1 - ATM");
        System.out.println("2 - App");
        System.out.println("3- Exit!");

        int optiune = scanner.nextInt();

        if (optiune == 1) {
            ATM atm = new ATMImplementare();
            System.out.println("Bine ai venit la ATM!");
            System.out.println("Introduceti user-ul");
            String username = scanner.next();
            System.out.println("Introduceti parola");
            String pass = scanner.next();
            boolean logged = false;
            ClientBanca clientBanca = null;
            try {
                atm.login(username, pass, clienti);
                logged = true;
                for (ClientBanca client: clienti) {
                    if(client.getUsername().equals(username) &&
                            client.getPassword().equals(pass)) {
                        clientBanca = client;
                    }
                }
            } catch (ClientException e) {
                System.out.println(e.getMessage());
            }
            while (logged) {
                System.out.println("Alegeti operatiunea dorita");
                System.out.println("1 - Afisare sold");
                System.out.println("2 - Retragere bani");
                System.out.println("3 - Depunere bani");
                System.out.println("4 - Exit!");

                int optiuneOperatiune = scanner.nextInt();
                switch (optiuneOperatiune) {
                    case 1: atm.afisareSold(clientBanca);
                    break;
                    case 2:
                        System.out.println("Introdu suma de retras");
                        double sumaRetragere = scanner.nextDouble();
                        atm.retragere(sumaRetragere,
                                clientBanca.getListaConturi().get(0)
                        );
                        break;
                    case 3:
                        System.out.println("Introdu sum pentru depunere");
                        double sumaDepunere = scanner.nextDouble();
                        atm.depunere(sumaDepunere, clientBanca.getListaConturi().get(0));
                        break;
                    case 4: logged = false;
                    break;
                    default:
                        System.out.println("Varianta aleasa nu exista!");
                }
            }
        }
    }
}
