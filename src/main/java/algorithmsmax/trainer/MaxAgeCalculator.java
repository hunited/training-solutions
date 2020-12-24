package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers) {
        Trainer oldertrainer = trainers.get(0);
        for (Trainer trainer : trainers) {
            if (trainer.getAge() > oldertrainer.getAge()) {
                oldertrainer = trainer;
            }
        }
        return oldertrainer;
    }

}
