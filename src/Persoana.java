public abstract class Persoana {
    private String nume;
    private String prenume;
    private String cnp;
    private String adresaEmail;

    public Persoana(String nume, String prenume, String cnp, String adresaEmail) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.adresaEmail = adresaEmail;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresaEmail() {
        return adresaEmail;
    }

    public void setAdresaEmail(String adresaEmail) {
        this.adresaEmail = adresaEmail;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cnp='" + cnp + '\'' +
                ", adresaEmail='" + adresaEmail + '\'' +
                '}';
    }
}
