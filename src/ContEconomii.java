public class ContEconomii extends Cont{
    private static final double comision = 0.05;

    public ContEconomii(String iban, String valuta, double sold) {
        super(iban, valuta, sold);
    }

    public void transferDinContEconomii(double amount, ClientBanca clientBanca) throws SoldException, ContException {
        // transfer din cont economii in cont curent propriu
        if (super.getSold() < amount) {
            throw new SoldException("Fonduri insuficiente!");
        } else {
            for (Cont cont : clientBanca.getListaConturi()) {
                if (cont instanceof ContCurent) {
                    super.setSold(super.getSold() - amount);
                    ((ContCurent) cont).adaugaBani(amount);
                    System.out.println("A fost realizat transferul din contul de economii in contul curent!");
                } else {
                    throw new ContException("Nu exista nici un cont curent!");
                }
            }
        }
    }

    public void retragereSumaDinEconomii(double suma) throws SoldException {
        double sumaRetragere = suma + suma * comision;
        if (getSold() < sumaRetragere) {
            throw new SoldException("Fonduri insuficiente");
        } else {
            super.setSold(super.getSold() - sumaRetragere);
        }
    }
}
