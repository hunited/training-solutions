package week15.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    private final Quiz quiz = new Quiz();

    @BeforeEach
    void setUp() {
        quiz.readFile(Path.of("src/main/resources/week15/d02/kerdesek.txt"));
    }

    @Test
    void readFile() {
        assertEquals(57, quiz.getQuestions().size());
    }

    @Test
    void getQuestionsByTheme() {
        assertEquals(21, quiz.getQuestionsByTheme("matematika").size());
        assertEquals(2, quiz.getQuestionsByTheme("kemia").size());
        assertEquals(18, quiz.getQuestionsByTheme("foldrajz").size());
        assertEquals(15, quiz.getQuestionsByTheme("tortenelem").size());
        assertEquals(1, quiz.getQuestionsByTheme("magyar").size());
    }

    @Test
    void getRandomQuestion() {
        assertEquals("Mikor kotottek meg a zsitvatoroki beket?", quiz.getRandomQuestion(50).getQuestion());
    }

    @Test
    void getAllQuestionByTheme() {
        assertEquals(5, quiz.getAllQuestionByTheme().size());
        assertEquals(21, quiz.getAllQuestionByTheme().get("matematika").size());
    }

    @Test
    void getMaxPointsByTheme() {
        assertEquals("matematika", quiz.getMaxPointsByTheme());
    }

}
