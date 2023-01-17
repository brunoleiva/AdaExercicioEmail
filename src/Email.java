import java.util.Date;

public class Email {
    private String remetente;
    private String destinatario;
    private Date dataEnvio;
    private Date dataRecebimento;
    private String assunto;
    private String corpo;

    public Email() {
    }

    public Email(String remetente, String destinatario, Date dataEnvio, Date dataRecebimento, String assunto, String corpo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.dataEnvio = dataEnvio;
        this.dataRecebimento = dataRecebimento;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    @Override
    public String toString() {
        return "Email{" +
                "remetente='" + remetente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", dataEnvio=" + dataEnvio +
                ", dataRecebimento=" + dataRecebimento +
                ", assunto='" + assunto + '\'' +
                ", corpo='" + corpo + '\'' +
                '}' + "\n";
    }
}
