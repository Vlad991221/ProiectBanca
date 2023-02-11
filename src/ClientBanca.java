import java.util.ArrayList;
import java.util.List;

public class ClientBanca extends Persoana{
    private String username;
    private String password;
    private String idClient;
    private List<Cont> listaConturi = new ArrayList<>();

    public ClientBanca(String username, String password, String idClient,
                       String nume, String prenume, String cnp,
                       String adresaEmail
    ) {
        super(nume, prenume, cnp, adresaEmail);
        this.username = username;
        this.password = password;
        this.idClient = idClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String toString() {
        return "ClientBanca(" + "username = " + username + "\'" +
                ", password = " + password + "\'" +
                ", idClient = " + idClient + "\'" +
                "}";
    }

    public void adaugaCont(Cont cont) {
        listaConturi.add(cont);
    }

    public List<Cont> getListaConturi() {
        return listaConturi;
    }
}
