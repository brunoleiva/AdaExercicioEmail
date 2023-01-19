import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Email {
    private String remetente;
    private LocalDate dataEnvio;
    private LocalDate dateRecebimento;
    private String assunto;
    private String corpo;

    public Email(String remetente, String assunto, String corpo) {
        this.remetente = remetente;
        this.dataEnvio = LocalDate.now();
        this.dateRecebimento = LocalDate.now();
        this.assunto = assunto;
        this.corpo = corpo;
    }


    public String getRemetente() {
        return remetente;
    }

    public String dataFormatada(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);

    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public LocalDate getDateRecebimento() {
        return dateRecebimento;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getTexto() {
        return corpo;
    }

    @Override
    public String toString() {
        return "--------------------------------" + "\n" +
                "Email{" + "\n" +
                "remetente='" + remetente + "\n" +
                ", dataEnvio=" + dataEnvio +
                ", dateRecebimento=" + dateRecebimento +
                ", assunto='" + assunto + "\n" +
                ", texto='" + corpo + "\n" +
                '}' + "\n" +
                "-------------------------------";
    }
}
