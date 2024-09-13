public class Main {
    public static void main(String[] Assimetrica) throws Exception {

        Assimetrica assimetrica = new Assimetrica();
        Simetrica simetrica = new Simetrica();

        System.out.println("Criptografia Simetrica: ");
        simetrica.executarSimetrica("Wallace", "Chegando atrasado de novo Arthur?");
        simetrica.executarSimetrica("Arthur", "Sabe como é que é");

        System.out.println("-------------------//---------------------");

        System.out.println("Criptografia Assimetrica: ");

        assimetrica.executarAssimetrica("Arthur", "Fala Wallace!");
        assimetrica.executarAssimetrica("Wallace", "Bom dia Arthur!");
    }
}