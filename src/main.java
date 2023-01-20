import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        MailMap caixaEmail = new MailMap();
        LocalDate hoje = LocalDate.of(2023, 01, 19);

        Email email1 = new Email("rodolfo.araujo@email.com.br", "GRÁTIS rodolfo", "Email teste de Rodolfo", LocalDate.of(2023, 01, 19), LocalDate.of(2023, 01, 19));
        Email email2 = new Email("wagner.cruz@email.com.br", "wagner Urgente", "Email de Wagner", LocalDate.of(2023, 01, 19), LocalDate.of(2023, 01, 19));
        Email email3 = new Email("bruno.leiva@email.com.br", "bruno", "Email de Bruno", LocalDate.of(2023, 01, 19), LocalDate.of(2023, 01, 19));
        Email email4 = new Email("davi.lima@email.com.pt", "davi", "Email teste de Davi", LocalDate.of(2023, 01, 18), LocalDate.of(2023, 01, 18));
        Email email5 = new Email("thiago.santos@email.com.pt", "thiago Urgente", "Email teste de Thiago", LocalDate.of(2023, 01, 17), LocalDate.of(2023, 01, 17));
        Email email6 = new Email("teste@email.com.br", "teste", "Email teste de teste", LocalDate.of(2023, 01, 17), LocalDate.of(2023, 01, 17));
        Email email7 = new Email("teste.first@email.com.br", "first", "Email teste de first", LocalDate.of(2023, 01, 16), LocalDate.of(2023, 01, 16));
        Email email8 = new Email("rodolfo.araujo@email.com.br", "rodolfo", "Email teste de Rodolfo", LocalDate.of(2023, 01, 16), LocalDate.of(2023, 01, 16));

        // Guardar um novo mail recebido
        caixaEmail.guardarEmail(email1);
        caixaEmail.guardarEmail(email2);
        caixaEmail.guardarEmail(email3);
        caixaEmail.guardarEmail(email4);
        caixaEmail.guardarEmail(email5);
        caixaEmail.guardarEmail(email6);
        caixaEmail.guardarEmail(email7);
        caixaEmail.guardarEmail(email8);

        caixaEmail.imprimirEmails();

        System.out.println("\nTotal de e-mails: " + caixaEmail.totalEnderecosEmails());

        // Determinar o total de endereços a partir dos quais se recebeu mail
        System.out.println("Total de endereços remetentes: " + caixaEmail.totalEnderecosEmails());

        // Determinar quantos mails têm por origem um dado endereço
        System.out.println("Total de emails de Rodolfo: " + caixaEmail.contarEmailPorEndereco("rodolfo.araujo@email.com.br"));

        // Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro;
        System.out.println("Lista de Emails que contem as palavras teste: " + caixaEmail.listaEmailsPorParametro(List.of("teste", "BRUNO")));

        // O mesmo que a questão anterior, mas criando um conjunto contendo os mails
        System.out.println("E-mails que contem as palavras teste e f1rst: " + caixaEmail.buscarEnderecosPorAssuntoSet(Set.of("first")));

        // Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro
        caixaEmail.removeEmailsDataCorte(LocalDate.of(2023, 01, 18));
        System.out.println("\nRemover emails recebidos antes de 18-01-2023: ");
        caixaEmail.imprimirEmails();

        // Eliminar todos os mails de um dado endereço anteriores a uma data dada
        System.out.println();
        caixaEmail.removeEmailsDataPorEndereco(LocalDate.of(2023, 01, 20), "rodolfo.araujo@email.com.br");
        System.out.println("Remover emails recebidos antes de 20-01-2023 e com o remetente rodolfo.araujo@email.com.br");

        // Criar uma lista dos endereços que hoje enviaram mails
        caixaEmail.imprimirEmails();
        System.out.println();
        System.out.println("Lista com os endereços que enviaram email em 19-01-2023: " + caixaEmail.BuscarEmailsDeHoje(hoje));

        // Criar uma listagem com todos os endereços de e-mail oriundos um país dado como parâmetro
        System.out.println("Lista com os endereços de email vindo de BT: " + caixaEmail.listaEmailPais("br"));
        System.out.println("Lista com os endereços de email vindo de PT: " + caixaEmail.emailsDePortugal());

        // Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam);
        System.out.println("Busca e-mails de hoje: " + caixaEmail.BuscarEmailsDeHoje(hoje));
        caixaEmail.removeEmailsSpam();
        System.out.println("Busca e-mails de hoje após deletar algum e-mail com spam: " + caixaEmail.BuscarEmailsDeHoje(hoje));
    }
}
