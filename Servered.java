import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;


public class Servered {

    private String filed = "Leaderboard.txt";
    private ArrayList<String> scores = new ArrayList<>();

    /**
 * getter for filed
 * @return String
 */
public String getFiled() {
    return filed;
}

/**
 * setter for filed
 * @param filed
 */
public void setFiled(String filed) {
    this.filed = filed;
}

/**
 * getter for scores
 * @return ArrayList<String>
 */
public ArrayList<String> getScores() {
    return scores;
}

/**
 * setter for scores
 * @param scores
 */
public void setScores(ArrayList<String> scores) {
    this.scores = scores;
}


    /**
         * Reads scores from a file and returns them as a list of strings   
         * @return scoreList
         * @throws IOException
         */
     private ArrayList<String> readingFromFile() throws IOException {
        ArrayList<String> scoresList = new ArrayList<>();
        File file = new File(filed);
        if (!file.exists()){
            return scoresList;
        }

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null) {
                scoresList.add(line );
            }
            br.close();
        } catch(Exception e){
            System.out.println("error");
        }
        return scoresList;
    }
   /**
         * writes the lists of scores to a file.
         * 
         * @param scoresList
         * @throws IOException
         */
     private void writeToFile(ArrayList<String> scoresList) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filed))) {
                    for (String score : scoresList) {
                pw.println(score);
            }
        }
    }

    /**
     * uses the previous 2 method to format the users name, score, time, places it into a comparator and 
     * @param name
     * @param score
     * @param timeNow
     * @throws IOException
     */
    public synchronized void combo(String name, int score, int timeNow) throws IOException{
                scores = readingFromFile();
                String newScore = ("Name - " + name + " -> Score: "+ score + ": " + "Time: " + timeNow);
                scores.add(newScore);
                LeadComparator leader = new LeadComparator();
                Collections.sort(scores, leader);

                writeToFile(scores);
    }

    /**
     * method that will run a thread that starts a server, while running it will take user, score, time, and send it back to displayed on leaderboard.
     * @param server
     */
    public void serverThread(ServerSocket server){
        Runnable run = new Runnable() {
            public void run(){
                while(true){
                    try {
                    System.out.println("server is currently waiting for connection");
                    Socket clientSocket = server.accept();
                    System.out.println("Server has connected");
                    BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String[] data =  br.readLine().split(":");
                    String name = data[0];
                    int score = Integer.parseInt(data[1]);
                    int time = Integer.parseInt(data[2]);
                    combo(name, score, time);
                    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
                    for(String scored: scores){
                        pw.println(scored);
                    }
                    clientSocket.close();
                
                    
                
                } catch (IOException e) {
                    e.printStackTrace();
                }  }
            }
        };
        Thread served = new Thread(run);
        served.start();
    }

    public static void main(String[] args) {
        try {
            ServerSocket server;
            server = new ServerSocket(12345);
            Servered sev = new Servered();
            sev.serverThread(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
