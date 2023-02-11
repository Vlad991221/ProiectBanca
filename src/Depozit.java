public class Depozit extends Cont{
    public static final double comisionDepozit = 0.05;
    public Depozit(String iban, String valuta, double sold) {
        super(iban, valuta, sold);
        double sumaComision = sold * comisionDepozit;
        super.setSold(sumaComision);
    }

    // La depozit, ii oferim in plus un comision de 0.05

}
