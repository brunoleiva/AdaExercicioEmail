import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws ParseException {

        MailMap caixa = new MailMap();
        Date dataHoraAtual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


        caixa.caixaEntrada.put(1, new Email("bruno.leiva@teste.com", "bruno.leiva@teste.com",
                dataHoraAtual, formatter.parse("06/01/2023 16:00:00"), "Assunto importante bruno teste", "Leia esse email "));

        caixa.caixaEntrada.put(2, new Email("ada@teste.com", "bruno.leiva@teste.com",
                dataHoraAtual, formatter.parse("05/01/2023 16:00:00"), "Assunto 2 email teste", "Leia esse emaillll "));

        caixa.caixaEntrada.put(3, new Email("ada@teste.com", "bruno.leiva@teste.com",
                dataHoraAtual, formatter.parse("17/01/2023 16:00:00"), "Assunto 3 palavraChave email teste", "Leia esse emaillll aaaa "));

        //System.out.println(caixa.totalEmailsdeUmEndereço("ada@teste.com"));

       // System.out.println(caixa.filtroPalavraChaveEmails("palavraChave;email"));

        caixa.apagarEmailsPorData("08/01/2023 16:00:00", "dd/MM/yyyy HH:mm:ss");

        System.out.println(caixa.filtroPalavraChaveEndereços("teste"));
    }
}
