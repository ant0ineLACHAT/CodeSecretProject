package verouillage;

import monnaie.TransactionRejeteeException;
import org.mockito.Mockito;

public class Purse {
    Purse fakePurse;
    private double solde;
    CodeSecret codeSecret;
    public Purse(CodeSecret codeSecret) {
        this.codeSecret = codeSecret;
        fakePurse = Mockito.mock(Purse.class);
        Mockito.when(fakePurse.getSolde()).thenReturn(solde);
    }

    public void credite(double solde) {
        this.solde = solde;
    }

    public void debite(double montantDebit, String goodCode) throws TransactionRejeteeException{
        if(!codeSecret.verifierCode(goodCode)) throw  new TransactionRejeteeException();
        this.solde -= montantDebit;
    }

    public double getSolde() {
        return solde;
    }
}
