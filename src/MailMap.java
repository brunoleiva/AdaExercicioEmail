import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MailMap {

    Integer proximoId = 4;
    Map<Integer,Email> caixaEntrada = new HashMap<Integer,Email>();
    /*
    List<Email> caixaEntrada = new ArrayList<>(
            new Email("bruno.leiva@teste.com","bruno.leiva@teste.com", dataHoraAtual,dataHoraAtual,"Assunto importante", "Leia esse email"),
            new Email("ada@teste.com","bruno.leiva@teste.com", dataHoraAtual,dataHoraAtual,"Assunto 2", "Leia esse emaillll"),
            new Email("adao@teste.com","bruno.leiva@teste.com", dataHoraAtual,dataHoraAtual,"Assunto 3", "Leia esse emaillll aaaa")
    );*/

    public MailMap() {
    }

    public void receberEmail(Email email){
        //SPAN
        boolean isSpan= false;
        if (isSpan){

        }else{
           caixaEntrada.put(proximoId,email);
           proximoId++;
        }
    }
    public int totalEmailsdeUmEndereço(String endereco){
        int contagem = 0;
        for (Email email:caixaEntrada.values()) {
            if(email.getRemetente().equals(endereco)){
                contagem++;
            }
        }
        return contagem;
    }

    public List<Email> filtroPalavraChaveEmails(String palavras){
        //Palavras separadas por ;
        List<Email> emailsFiltrados = new ArrayList<>();
        String[] palavrasSeparadas = palavras.split(";");

        boolean isAdicionado = false;
        for (Email email: caixaEntrada.values()) {
            isAdicionado = false;
            for (String palavra:palavrasSeparadas) {
                if (email.getAssunto().contains(palavra) && !isAdicionado){
                    isAdicionado = true;
                    emailsFiltrados.add(email);
                }
            }
        }

        return emailsFiltrados;
    }
    public List<String> filtroPalavraChaveEndereços(String palavras){
        //Palavras separadas por ;
        List<String> endereços = new ArrayList<>();
        String[] palavrasSeparadas = palavras.split(";");

        boolean isAdicionado = false;
        for (Email email: caixaEntrada.values()) {
            isAdicionado = false;
            for (String palavra:palavrasSeparadas) {
                if (email.getAssunto().contains(palavra) && !isAdicionado){
                    isAdicionado = true;
                    endereços.add(email.getRemetente());
                }
            }
        }

        return endereços;
    }

    public void apagarEmailsPorData(String data, String formatacao){
        SimpleDateFormat formatter = new SimpleDateFormat(formatacao);
        try {
            Date dataApagar = formatter.parse(data);
            ArrayList<Email> emailsApagados = new ArrayList<Email>();

            for (Email email: caixaEntrada.values()) {
                if(dataApagar.after(email.getDataRecebimento())){
                    emailsApagados.add(email);
                }
            }
            for (Email email:emailsApagados) {
                caixaEntrada.values().remove(email);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
