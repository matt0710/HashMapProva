public class CanaleNonPresenteException extends Exception{
    public CanaleNonPresenteException(){
        System.err.println("Impossibile rimuovere il canale perchè non è presente nel videoPlayer! ");
    }
}
