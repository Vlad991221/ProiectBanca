public abstract class Cont {
    private String iban;
    private String valuta;
    private double sold;

    public Cont(String iban, String valuta, double sold) {
        this.iban = iban;
        this.valuta = valuta;
        this.sold = sold;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public void afisareSoldCont() {
        System.out.println("Contul are " + sold + " " + valuta);
    }

    @Override
    public String toString() {
        return "Cont{" +
                "iban='" + iban + '\'' +
                ", valuta='" + valuta + '\'' +
                ", sold=" + sold +
                '}';
    }
}
