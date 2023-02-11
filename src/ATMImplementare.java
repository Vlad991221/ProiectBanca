import java.util.List;
import java.util.Scanner;

public class ATMImplementare implements ATM{
    @Override
    public void login(String username, String password, List<ClientBanca> clientBancaList) throws ClientException {
        for (ClientBanca clientBanca: clientBancaList) {
            if (clientBanca.getUsername().equals(username) && clientBanca.getPassword().equals(password)) {
                System.out.println("Succesful authentication");
            } else {
                throw new ClientException("Incorrect username/password");
            }
        }
    }

    @Override
    public void afisareSold(ClientBanca clientBanca) {
        int i = 0;
        for (Cont cont: clientBanca.getListaConturi()) {
            System.out.println(i + " " + cont.getIban() + " " + cont.getValuta());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu cifra pentru contul ales...");
        int alegere = scanner.nextInt();
        System.out.println(clientBanca.getListaConturi().get(alegere));
    }

    @Override
    public void retragere(double amount, Cont cont) throws SoldException, OperatiuniExceptie {
        System.out.println("Alege contul din care doriti sa retrageti bani: " +
                "1 - cont curent, 2 - cont economii");
        Scanner scanner = new Scanner(System.in);
        int alegere = scanner.nextInt();
        if (alegere == 1) {
            ((ContCurent) cont).retrageBani(amount);
        } else {
            throw new OperatiuniExceptie("Varianta aleasa nu exista");
        }
    }

    @Override
    public void depunere(double amount, Cont cont) {
        ((ContCurent) cont).adaugaBani(amount);
    }
}
