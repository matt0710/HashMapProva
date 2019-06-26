public class Video {
    protected String nome;
    protected String durata;
    protected String visualizzazioni;
    protected String risoluzione;
    protected String sottotitoli;

    public Video(){}
    public Video(String nome, String durata, String visualizzazioni, String risoluzione, String sottotitoli){
        this.nome = nome;
        this.durata = durata;
        this.visualizzazioni = visualizzazioni;
        this.risoluzione = risoluzione;
        this.sottotitoli = sottotitoli;
    }

    public String getDurata() {
        return durata;
    }

    public String getVisualizzazioni() {
        return visualizzazioni;
    }

    public String getRisoluzione() {
        return risoluzione;
    }

    public String getSottotitoli() {
        return sottotitoli;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public void setVisualizzazioni(String visualizzazioni) {
        this.visualizzazioni = visualizzazioni;
    }

    public void setRisoluzione(String risoluzione) {
        this.risoluzione = risoluzione;
    }

    public void setSottotitoli(String sottotitoli) {
        this.sottotitoli = sottotitoli;
    }

    @Override
    public String toString() {
        return "nome: " + nome + "\ndurata: " + durata + "\nvisualizzazioni: " + visualizzazioni + "\nrisoluzione: " + risoluzione + "\nsottotitoli: " + sottotitoli;
    }
}
