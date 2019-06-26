public class VideoPlayer {
    private int volume;
    private boolean sottotitoli;
    private Video videoProva;

    public VideoPlayer(){}
    public VideoPlayer(int volume){
        this.volume = volume;
    }
    public VideoPlayer(int volume, boolean sottotitoli, Video videoProva){
        this.volume = volume;
        this.sottotitoli = sottotitoli;
        this.videoProva = videoProva;
    }

    public void play(){
        System.out.println("Play");
    }
    public void pausa(){
        System.out.println("Pausa");
    }
    public void stop(){
        System.out.println("Stop");
    }

    public void attivaSottotitoli() throws NoSottotitoliException{
        if (videoProva.getSottotitoli().equals("si"))
            this.sottotitoli = true;
        else
            throw new NoSottotitoliException();
    }

    public void disattivaSottotitoli() throws NoSottotitoliException{
        if (videoProva.getSottotitoli() != null)
            this.sottotitoli = false;
        else
            throw new NoSottotitoliException();
    }

    public void aumentaVolume(int aumento){
        this.volume += aumento;
    }

    public void diminuisciVolumer(int decremento){
        this.volume -= decremento;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isSottotitoli() {
        return sottotitoli;
    }

    public Video getVideoProva() {
        return videoProva;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSottotitoli(boolean sottotitoli) {
        this.sottotitoli = sottotitoli;
    }

    public void setVideoProva(Video videoProva) {
        this.videoProva = videoProva;
    }


    public String toString() {
        return "volume: " + volume + "\nsottotitoli: " + sottotitoli + "\nvideo: \n" + videoProva;
    }
}
