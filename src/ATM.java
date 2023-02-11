import java.util.List;

public interface ATM {
    public void login(String username, String password, List<ClientBanca> clientBancaList) throws ClientException;
    public void afisareSold(ClientBanca clientBanca);
    public void retragere(double amount, Cont cont) throws SoldException, OperatiuniExceptie;
    public void depunere(double amount, Cont cont);
}
