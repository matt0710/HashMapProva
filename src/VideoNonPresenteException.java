public class VideoNonPresenteException extends Exception{
    public VideoNonPresenteException(){
        System.err.println("Il video che si vuole rimuovere non è presente! ");
    }
}
