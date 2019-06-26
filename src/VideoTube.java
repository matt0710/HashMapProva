import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class VideoTube {
    private HashMap<Canale, LinkedList<Video>> mappa = new HashMap<>();
    private VideoPlayer videoPlayer;

    public VideoTube(){}
    public VideoTube(HashMap<Canale, LinkedList<Video>> mappa, VideoPlayer videoPlayer){
        this.mappa = mappa;
        this.videoPlayer = videoPlayer;
    }

    public void aggiungiCanale (Canale canale, LinkedList<Video> listaVideo){
        if (mappa.containsKey(canale)) {
            System.out.println("Il canele è gia presente nella mappa, impossibile riaggiungerlo!");
            return;
        }
        mappa.put(canale, listaVideo);
    }

    public void rimuoviCanale (Canale canale) throws CanaleNonPresenteException{
        if (!mappa.containsKey(canale))
            throw new CanaleNonPresenteException();
        mappa.remove(canale);

    }

    public void aggiungiVideo (Canale canale, Video video){
        if(mappa.containsKey(canale))
            mappa.get(canale).add(video);
        else{
            LinkedList<Video> nuovaLista = new LinkedList<>();
            nuovaLista.add(video);
            mappa.put(canale, nuovaLista);
        }
    }

    public void rimuoviVideo (Canale canale, Video video) throws VideoNonPresenteException, CanaleNonPresenteException{
        if(mappa.containsKey(canale)){
            if (!mappa.get(canale).remove(video))
                throw new VideoNonPresenteException();
        }
        else
            throw new CanaleNonPresenteException();
    }

    public void playVideo (VideoPlayer videoDaRiprodurre){
        for (int i=0; i<mappa.values().size(); i++){
            if (mappa.containsValue(videoDaRiprodurre))
                videoDaRiprodurre.play();
        }
    }

    public HashMap<Canale, LinkedList<Video>> getMappa() {
        return mappa;
    }

    public VideoPlayer getVideoPlayer() {
        return videoPlayer;
    }

    public void setMappa(HashMap<Canale, LinkedList<Video>> mappa) {
        this.mappa = mappa;
    }

    public void setVideoPlayer(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    public String toString() {

        Set<Canale> setCanale = this.mappa.keySet();
        Iterator<Canale> iter = setCanale.iterator();
        String s = "";

        while (iter.hasNext()){
            Canale c = iter.next();
            s += c.toString() + "\n";
            for (Video v : mappa.get(c))
                s += v.toString() + "\n";
            /*
            mappa.get(c).get(i);
            */
        }
    return s;
    }
}
