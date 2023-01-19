import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        MailMap caixaEmail = new MailMap();
        LocalDate hoje = LocalDate.now();
        Email email1 = new Email("rodolfo.araujo@email.com.br", "GRÁTIS rodolfo", "Email teste de Rodolfo");
        Email email2 = new Email("wagner.cruz@email.com.br","wagner Urgente", "Email  de Wagner");
        Email email3 = new Email("bruno.leiva@email.com.br","bruno", "Email  de Bruno");
        Email email4 = new Email("davi.lima@email.com.pt","davi", "Email teste de Davi");
        Email email5 = new Email("thiago.santos@email.com.pt","thiago Urgente", "Email teste de Thiago");
        Email email6 = new Email("teste@email.com.br","teste", "Email teste de teste");
        Email email7 = new Email("teste.first@email.com.br","first", "Email teste de first");
        Email email8 = new Email("rodolfo.araujo@email.com.br", "rodolfo", "Email teste de Rodolfo");

        //Guardar um novo mail recebido
       caixaEmail.guardarEmail(email1);
        caixaEmail.guardarEmail(email2);
        caixaEmail.guardarEmail(email3);
        caixaEmail.guardarEmail(email4);
        caixaEmail.guardarEmail(email5);
        caixaEmail.guardarEmail(email6);
        caixaEmail.guardarEmail(email7);
        caixaEmail.guardarEmail(email8);



        System.out.println();
        caixaEmail.imprimirEmails();
        System.out.println();
        caixaEmail.totalEnderecosEmails();

        //Determinar o total de endereços a partir dos quais se recebeu mail
        System.out.println();
        System.out.println("Total de endereços remetentes: " + caixaEmail.totalEnderecosEmails());

        //Determinar quantos mails têm por origem um dado endereço
        System.out.println();
        System.out.println("Total de emails de Rodolfo é " + caixaEmail.contarEmailPorEndereco("rodolfo.araujo@email.com.br"));

        //Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro;
        System.out.println();
        System.out.println("Lista de Emails que contem as palavras teste: " + caixaEmail.listaEmailsPorParametro(List.of("teste","BRUNO")));

        //O mesmo que a questão anterior, mas criando um conjunto contendo os mails
        System.out.println();
        System.out.println("Set de Emails que contem as palavras teste e f1rst: " + caixaEmail.buscarEnderecosPorAssuntoSet(Set.of("first")));
        System.out.println();
        caixaEmail.imprimirEmails();

        //Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro
        System.out.println();
        caixaEmail.removeEmailsDataCorte(LocalDate.of(2023, 01, 18));
        System.out.println("Remover emails recebidos antes de 18-01-2023: ");

        //Eliminar todos os mails de um dado endereço anteriores a uma data dada
        System.out.println();
        caixaEmail.removeEmailsDataPorEndereco(LocalDate.of(2023, 01, 18), "rodolfo.araujo@email.com.br");
        System.out.println("Remover emails recebidos antes de 18-01-2023 e com o remetente rodolfo.araujo@email.com.br");

        //Criar uma lista dos endereços que hoje enviaram mails
        caixaEmail.imprimirEmails();
        System.out.println();
        System.out.println("Lista com os endereços que enviaram email em 18-01-2023: " + caixaEmail.BuscarEmailsDeHoje(hoje));

        //Criar uma listagem com todos os endereços de e-mail oriundos um país dado como parâmetro
        System.out.println("Lista com os endereços de email vindo de br: " + caixaEmail.listaEmailPais("br"));
        System.out.println("Lista com os endereços de email vindo de pt: " + caixaEmail.emailsDePortugal());

        //Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam);
        System.out.println(caixaEmail.BuscarEmailsDeHoje(hoje));
        caixaEmail.removeEmailsSpan("rodolfo.araujo@email.com.br");
        System.out.println(caixaEmail.BuscarEmailsDeHoje(hoje));


    }


    /*Enunciado
    Cada e-mail recebido numa dada conta de e-mail é guardado contendo o endereço de quem o enviou,
    a data de envio, a data de recebimento, o assunto e o texto do e-mail (não se consideram anexos, etc.).
    Crie uma classe MailMap que associe a cada endereço de envio todos os mails recebidos (classe EMail) e implemente as seguintes operações:

    a) Determinar o total de endereços a partir dos quais se recebeu mail; OK
    b) Guardar um novo mail recebido; OK
    c) Determinar quantos mails têm por origem um dado endereço; OK
    d) Criar uma lista com todos os endereços que enviaram mails OK
    contendo no seu assunto uma lista de palavras dada como parâmetro;
    e) O mesmo que a questão anterior, mas criando um conjunto contendo os mails; ---SET  OK
    f) Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro; OK
    g) Criar uma lista dos endereços que hoje enviaram mails; OK

    h) Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no
    seu assunto contenham uma qualquer destas (anti-spam);

    i) Eliminar todos os mails de um dado endereço anteriores a uma data dada; OK

    j) Criar uma listagem com todos os endereços de e-mail oriundos um país dado como parâmetro; OK*/
}
