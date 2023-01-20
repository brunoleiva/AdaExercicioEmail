import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MailMap {
    private final HashMap<String, List<Email>> mailBox = new HashMap<>();
    private final List<String> DICIONARIO_DE_SPAM = List.of("GRÁTIS", "Atenção", "Oi", "Urgente", "Imediato");

    // Total de endereços de emails que recebeu
    public int totalEnderecosEmails() {
        return mailBox.size();
    }

    public void guardarEmail(Email email) throws IllegalArgumentException {
        if (email == null) throw new IllegalArgumentException("E-mail não pode ser nulo");

        if (mailBox.containsKey(email.getRemetente())) {
            mailBox.get(email.getRemetente()).add(email);
        } else {
            List<Email> mailList = new ArrayList<>();
            mailList.add(email);
            mailBox.put(email.getRemetente(), mailList);
        }

        System.out.println("Salvando: " + email);
    }

    public Integer contarEmailPorEndereco(String endereco) throws IllegalArgumentException {
        if (validaEmail(endereco)) throw new IllegalArgumentException("E-mail inválido");

        if (mailBox.containsKey(endereco)) return mailBox.get(endereco).size();
        else return 0;
    }

    public List<String> listaEmailsPorParametro(List<String> palavras) {
        verificaCaixaVazia();

        return filtrarEmailsPorAssunto(palavras);
    }

    public List<String> buscarEnderecosPorAssuntoSet(Set<String> palavras) {
        verificaCaixaVazia();

        return filtrarEmailsPorAssunto(palavras);
    }

    public void removeEmailsDataCorte(final LocalDate date) {
        mailBox.keySet().removeIf(key -> removeEmailsDataCorte(date, key).isEmpty());
    }

    public void removeEmailsDataPorEndereco(final LocalDate date, String endereco) {
        mailBox.keySet().removeIf(key -> removeEmailsDataCorteEndereco(date, endereco, key).isEmpty());
    }

    public List<String> listaEmailPais(String pais) {
        verificaCaixaVazia();
        validaPais(pais);

        return mailBox.keySet().stream()
                .filter(key -> key.endsWith(pais))
                .collect(Collectors.toList());
    }

    public List<String> BuscarEmailsDeHoje(LocalDate date) {
        List<String> emails = new ArrayList<>();

        for (String key : mailBox.keySet()) {
            mailBox.get(key).stream()
                    .filter(email -> email.getDataEnvio().equals(date))
                    .forEach(email -> emails.add(email.getRemetente()));
        }

        return emails;
    }

    public List<String> emailsDePortugal() {
        final String CODIGO_PAIS_PORTUGAL = "pt";
        return listaEmailPais(CODIGO_PAIS_PORTUGAL);
    }

    public void imprimirEmails() {
        if (mailBox.isEmpty()) {
            System.out.println("Não há emails");
            return;
        }

        System.out.println("Emails: ");
        for (String key : mailBox.keySet()) {
            System.out.println(key);
        }
    }

    public void removeEmailsSpam() {
        List<String> palavrasSpam = new ArrayList<>(DICIONARIO_DE_SPAM);

        for (String key : mailBox.keySet()) {
            List<Email> listaEmail = mailBox.get(key);

            List<Email> listaEmailComSpam = listaEmail.stream()
                    .filter(email -> palavrasSpam.stream().anyMatch(palavra -> email.getAssunto().contains(palavra)))
                    .collect(Collectors.toList());

            listaEmail.removeAll(listaEmailComSpam);
        }
    }

    private List<Email> removeEmailsDataCorte(LocalDate date, String key) {
        List<Email> listEmail = mailBox.get(key);

        listEmail.removeIf(mail -> mail.getDateRecebimento().isBefore(date));

        return listEmail;
    }

    private List<Email> removeEmailsDataCorteEndereco(LocalDate date, String endereco, String key) {
        List<Email> listEmail = mailBox.get(key);

        mailBox.get(key).removeIf(mail -> mail.getRemetente().equals(endereco) && mail.getDateRecebimento().isBefore(date));

        return listEmail;
    }

    private List<String> filtrarEmailsPorAssunto(Collection<String> palavras) {
        List<String> listaEmailComPalavras = new ArrayList<>();

        for (String key : mailBox.keySet()) {
            List<Email> listaEmail = mailBox.get(key);

            listaEmail.stream()
                    .filter(email -> palavras.stream().anyMatch(palavra -> email.getAssunto().toLowerCase().contains(palavra)))
                    .forEach(email -> listaEmailComPalavras.add(email.getRemetente()));
        }

        return listaEmailComPalavras;
    }

    private boolean verificaCaixaVazia() {
        if (mailBox.isEmpty()) {
            System.out.println("Caixa de e-mails vazia");
            return false;
        }

        return true;
    }

    private boolean validaEmail(String address) {
        return address.isEmpty() || address.isBlank();
    }

    private void validaPais(String pais) throws IllegalArgumentException {
        if (pais == null) throw new IllegalArgumentException("É necessário informar um país!");
    }
}
