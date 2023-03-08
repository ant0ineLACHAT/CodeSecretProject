package verouillage;

import org.mockito.Mockito;

public class CodeSecret {
    CodeSecret fakeCode;
    public CodeSecret() {
        fakeCode = Mockito.mock(CodeSecret.class);
        Mockito.when(fakeCode.revelerCode()).thenReturn("1234");
        Mockito.when(fakeCode.verifierCode("1234")).thenReturn(true);
    }

    public String revelerCode() {
        return fakeCode.revelerCode();
    }

    public boolean verifierCode(String code) {
        return fakeCode.verifierCode(code);
    }
}
