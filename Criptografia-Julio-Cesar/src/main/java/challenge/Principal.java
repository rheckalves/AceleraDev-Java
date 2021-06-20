package challenge;

public class Principal {
    public static void main(String[] args) {
       Criptografia criptografia = new CriptografiaCesariana();
       System.out.println(criptografia.criptografar("a ligeira raposa marrom saltou sobre o cachorro cansado"));
        System.out.println(criptografia.descriptografar("d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr"));
    }
}
