import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Email {
    private String remetente;
    private LocalDate dataEnvio;
    private LocalDate dateRecebimento;
    private String assunto;
    private String corpo;
    private final String PATTERN_DATE_BR = "dd/MM/yyyy";

    public Email(String remetente, String assunto, String corpo, LocalDate dataEnvio, LocalDate dateRecebimento) {
        this.remetente = remetente;
        this.assunto = assunto;
        this.corpo = corpo;
        this.dataEnvio = dataEnvio;
        this.dateRecebimento = dateRecebimento;
    }

    public String getRemetente() {
        return remetente;
    }

    public String dataFormatada(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.PATTERN_DATE_BR);
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
                "Email {" + "\n" +
                "   remetente=" + remetente + ",\n" +
                "   dataEnvio=" + dataEnvio + ",\n" +
                "   dateRecebimento=" + dateRecebimento + ",\n" +
                "   assunto=" + assunto + ",\n" +
                "   texto=" + corpo + ",\n" +
                '}' + "\n";
    }
}
