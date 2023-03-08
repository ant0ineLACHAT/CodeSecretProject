package integrationPurseCodeSecret;

import monnaie.TransactionRejeteeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import verouillage.CodeSecret;
import verouillage.Purse;

public class PurseIntegTest {

    private CodeSecret codeSecret;
    private Purse purse;
    private double solde=100;
    private double montantDebit=20;
    private String goodCode;
    private String badCode;

    @BeforeEach
    public void setUp(){
        codeSecret = new CodeSecret();
        goodCode = codeSecret.revelerCode();
        badCode = goodCode+"1";
        purse = new Purse(codeSecret);
        purse.credite(solde);
    }
    @Test
    public void testDebitCodeValide() throws Exception{
        purse.debite(montantDebit, goodCode);
        Assertions.assertEquals(solde-montantDebit, purse.getSolde());
    }

    @Test
    public void testDebitCodeInvalide() throws Exception{
        Assertions.assertThrows(TransactionRejeteeException.class,()->{
            purse.debite(montantDebit, badCode);
        });
    }
}
