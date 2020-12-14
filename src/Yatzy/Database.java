package Yatzy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final Database SINGLE_INSTANCE = new Database();
    private static final String FILEPATH = "scores.ser";
    private List<Score> listOfScores;

    private Database() {
        this.listOfScores = new ArrayList<>();
        this.createFile();
        this.loadData();
        System.out.println("Database object created.");
    }

    public static Database getInstance() {
        return SINGLE_INSTANCE;
    }

    public void addScore(Score score) {
        if(listOfScores.isEmpty()) {
            listOfScores.add(score);
        }
        else {
            for (int i = 0; i < this.listOfScores.size(); i++) {
                if (score.getScore() > this.listOfScores.get(i).getScore()) {
                    this.listOfScores.add(i, score);
                    break;
                }
                else if(i == this.listOfScores.size()-1){
                    this.listOfScores.add(score);
                    break;
                }
            }
        }
    }

    public void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILEPATH))) {
            this.listOfScores = (List<Score>) in.readObject();
        } catch (EOFException e) {
            System.out.println("End of file reached.");
        } catch (Exception e) {
            System.out.println("Could not load from file.");
            e.printStackTrace();
        }
    }

    public void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILEPATH))) {
            out.writeObject(this.listOfScores);
            System.out.println("Saved scores to file.");
        } catch (Exception e) {
            System.out.println("Could not write to file.");
            e.printStackTrace();
        }
    }

    private void createFile() {
        if (!Files.exists(Path.of(FILEPATH))) {
            try {
                Files.createFile(Path.of(FILEPATH));
                System.out.println("New file created.");
            } catch (IOException e) {
                System.out.println("Could not create file.");
                e.printStackTrace();
            }
        }
    }

    public void exportToWord(){
        String today = LocalDate.now().toString();
        try(PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("Yatzyscores " + today + ".doc")))){

            for (int i = 0; i < listOfScores.size(); i++){
                String nr = String.format("%-4d",(i+1));
                String line = nr + listOfScores.get(i).toString();
                printer.println(line);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Getter
    public List<Score> getListOfScores() {
        return listOfScores;
    }
}