public class ContCurent extends Cont{
    public ContCurent(String iban, String valuta) {
        super(iban, valuta, 0);
    }

    public void adaugaBani(double amount) {
        super.setSold(super.getSold() + amount);
    }

    public void retrageBani(double amount) throws SoldException {
        if (super.getSold() < amount) {
            throw new SoldException("Fonduri insuficiente!");
        } else {
            super.setSold(super.getSold() - amount);
        }
    }

    public void transferBani(double amount, ContCurent contCurent) throws SoldException {
        if (getSold() < amount) {
            throw new SoldException("Fonduri insuficiente!");
        } else {
            super.setSold(super.getSold() - amount);
            contCurent.adaugaBani(amount);
        }
    }

    private void transferDinContCurent(double amount, ClientBanca clientBanca) throws SoldException, ContException {
        // transfer din cont curent in cont economii propriu
        if (super.getSold() < amount) {
            throw new SoldException("Fonduri insuficiente!");
        } else {
            for (Cont cont : clientBanca.getListaConturi()) {
                if (cont instanceof ContEconomii) {
                    super.setSold(super.getSold() - amount);
                    cont.setSold(cont.getSold() + amount);
                    System.out.println("A fost realizat transferul " +
                            "din contul curent in contul de economii!");
                } else {
                    throw new ContException("Nu exista nici un cont de economii!");
                }
            }
        }
    }
}
