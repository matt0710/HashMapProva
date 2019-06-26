import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static LinkedList<Video> getVideoFormFile(String path) throws FileNotFoundException, IOException
    {
        File file = new File(path);
        if (file.exists() && file.isFile()){
            BufferedReader reader = new BufferedReader(new FileReader(path));
            LinkedList<Video> listaVideo = new LinkedList<>();
            Video v;
            String s = reader.readLine();
            String[] str;

            for (int i=0; i<3; i++){
                str = s.split(",");
                v = new Video(str[0], str[1], str[2], str[3], str[4]);
                listaVideo.add(v);
                s = reader.readLine();
            }
            reader.close();
            return listaVideo;
        }else if (file.exists() && file.isDirectory()){
            BufferedWriter writer;
            File fileDaSCrivere = new File(path + "out.txt");
            writer = new BufferedWriter(new FileWriter(fileDaSCrivere));
            String[] directory = file.list();

            for (String s : directory){
                writer.write(s + "\n");
            }
            writer.close();
            return null;
        }
        else
            throw new FileNotFoundException("fnf");
    }

    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        VideoTube youtube;
        Canale channel1 = new Canale("CanaleDiMatteo", "matteo", "26/06/2019");
        String path = "";

        System.out.println("Inserisci la path: ");
        path = sc.nextLine();

        try{

            HashMap<Canale, LinkedList<Video>> mappa = new HashMap<>();
            youtube = new VideoTube(mappa, null);
            if (getVideoFormFile(path) != null)
                youtube.aggiungiCanale(channel1, getVideoFormFile(path));
            System.out.println(youtube);

        }catch(IOException io){
            System.err.println("io");
        }/*catch(FileNotFoundException fnf){
            System.err.println("fnf");
        }*/

    }
}
