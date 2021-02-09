package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    private final List<Question> questions = new ArrayList<>();

    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String question;
            while ((question = br.readLine()) != null) {
                String answer = br.readLine();
                String[] splittedLine = answer.split(" ");
                questions.add(new Question(question, splittedLine[0], Integer.parseInt(splittedLine[1]), splittedLine[2]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file.", ioe);
        }
    }

    public List<String> getQuestionsByTheme(String theme) {
        List<String> result = new ArrayList<>();
        for (Question q : questions) {
            if (q.getTheme().equals(theme)) {
                result.add(q.getQuestion());
            }
        }
        return result;
    }

    public Question getRandomQuestion(int seed) {
        Random random = new Random(seed);
        return questions.get(random.nextInt(questions.size()));
    }

    public Map<String, List<Question>> getAllQuestionByTheme() {
        Map<String, List<Question>> result = new HashMap<>();
        for (Question q : questions) {
            if (!result.containsKey(q.getTheme())) {
                result.put(q.getTheme(), new ArrayList<>());
            }
            result.get(q.getTheme()).add(q);
        }
        return result;
    }

    public String getMaxPointsByTheme() {
        Map<String, List<Question>> themeMap = getAllQuestionByTheme();
        String result = "";
        int max = 0;
        for (Map.Entry<String, List<Question>> map : themeMap.entrySet()) {
            int sum = 0;
            for (Question q : map.getValue()) {
                sum += q.getPoint();
            }
            if (sum > max) {
                max = sum;
                result = map.getKey();
            }
        }
        return result;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "" + questions;
    }

}
