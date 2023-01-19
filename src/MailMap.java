import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MailMap {

    HashMap<String, List<Email>> mailBox = new HashMap<>();



    //total de endereços de emails que recebeu
    public int totalEnderecosEmails() {
        Integer total = mailBox.size();
        System.out.println("TOTAL DE EMAILS: " + total);
        return total;
    }

    public void guardarEmail(Email email) {
        if (email != null) {
            if (mailBox.containsKey(email.getRemetente())) {
                mailBox.get(email.getRemetente()).add(email);
            } else {
                List<Email> mailList = new ArrayList<>();
                mailList.add(email);
                mailBox.put(email.getRemetente(), mailList);
            }
            System.out.println("Salvando: " + email);
        } else {
            System.out.println("Erro ao salvar email");
        }
    }
    public int contarEmailPorEndereco(String endereco) {
        int total = 0;
        if (validaEmail(endereco))
            throw new IllegalArgumentException("Email inválido");

        for (String key : mailBox.keySet()) {
            if (Objects.equals(key, endereco)) {
                total = mailBox.get(key).size();
            }
        }

        return total;
    }
    public List<String> listaEmailsPorParametro(List<String> palavras) {
        verificaCaixaVazia();
        List<String> listaEmails = new ArrayList<>();
        filtrarEmailsPorAssunto(palavras, listaEmails);
        return listaEmails;
    }

    public Set<String> buscarEnderecosPorAssuntoSet(Set<String> palavras) {
        verificaCaixaVazia();
        Set<String> remetente = new HashSet<>();
        filtrarEmailsPorAssunto(palavras, remetente);
        return remetente;
    }


    public void removeEmailsDataCorte(final LocalDate date) {
        for (String key : mailBox.keySet()) {
            removeEmailsDataCorte(date, key);
        }
    }

    public void removeEmailsDataPorEndereco(final LocalDate date, String endereco) {
        for (String key : mailBox.keySet()) {
            removeEmailsDataCorteEndereco(date, endereco ,key);
        }
    }

    public List<String> listaEmailPais(String pais) {
        List<String> emailPais = new ArrayList<>();
        verificaCaixaVazia();
        if (validaPais(pais)) {
            for (String endereco : mailBox.keySet()) {
                if (endereco.endsWith(pais)) {
                    emailPais.add(endereco);
                }
            }
        }
        return emailPais;
    }


    public List<String> BuscarEmailsDeHoje(LocalDate date) {
        final List<String> sentMails = new ArrayList<>();
        for (String key : mailBox.keySet()) {
            for (Email mail : mailBox.get(key)) {
                if (mail.getDataEnvio().equals(date)) {
                    sentMails.add(key);
                    break;
                }
            }
        }
        return sentMails;
    }




    public List<String> emailsDePortugal() {
        return listaEmailPais("pt");

    }

    public void imprimirEmails() {
        if (mailBox.isEmpty()) {
            System.out.println("Não há emails");
        } else {
            System.out.println("Emails: ");
            for (String key : mailBox.keySet()) {
                System.out.println(key);
            }
        }
    }

    public void removeEmailsSpan(String endereco) {

        List<String> palavrasSpan = new ArrayList<>(List.of("GRÁTIS","Atenção","Oi", "Urgente", "Imediato"));

        List<Email> emailsRemover = new ArrayList<>();

        for (String key : mailBox.keySet()) {
             for (Email email:mailBox.get(key)){
                 for (String palavra:palavrasSpan) {
                     if(email.getAssunto().contains(palavra)){
                         emailsRemover.add(email);
                     }
                 }
             }
            mailBox.get(key).removeAll(emailsRemover);
            emailsRemover = new ArrayList<>();
        }


    }

    private void removeEmailsDataCorte(LocalDate date, String key) {
        mailBox.get(key).removeIf(mail -> mail.getDateRecebimento().isBefore(date));
    }
    private void removeEmailsDataCorteEndereco(LocalDate date,String endereco, String key) {
        for (Email email:mailBox.get(key)){
            if(email.getRemetente().equals(endereco)){
                mailBox.get(key).removeIf(mail -> mail.getDateRecebimento().isBefore(date));

            }
        }
    }
    private void filtrarEmailsPorAssunto(Collection<String> words, Collection<String> mailAddresses) {
        for (String key : mailBox.keySet()) {
            for (Email email : mailBox.get(key)) {
                String subject = email.getAssunto().toLowerCase();
                for (String word : words) {
                    if (subject.contains(word)) {
                        if (mailAddresses.contains(email.getRemetente())) {
                            break;
                        } else {
                            mailAddresses.add(email.getRemetente());
                        }
                    }
                }
            }
        }
    }
    private void verificaCaixaVazia() {
        if (mailBox.isEmpty()) {
            System.out.println("Caixa de emails vazia");
        }
    }

    private boolean validaEmail(String address) {
        return address.isEmpty() || address.isBlank();
    }

    private static boolean validaPais(String pais) {
        if (pais == null) {
            System.out.println("É necessário informar um país!");
            return false;
        } else
            return true;
    }


}
