package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private final List<Production> productions = new ArrayList<>();
    private final List<Vote> votes = new ArrayList<>();

    public void readTalents(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String content;
            while ((content = reader.readLine()) != null) {
                String[] line = content.split(" ");
                productions.add(new Production(Integer.parseInt(line[0]), line[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public void calculateVotes(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String content;
            while ((content = reader.readLine()) != null) {
                voteAdder(Integer.parseInt(content));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public void writeResultToFile(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (Vote vote : votes) {
                Production production = findProdId(vote.getId());
                writer.println(vote.getId() + " " + production.getName() + " " + vote.getNumber());
            }
            writer.print("Winner: " + findWinner().getName());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not open file", ioe);
        }
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    private void voteAdder(int vote) {
        boolean exist = false;
        for (Vote v : votes) {
            if (v.getId() == vote) {
                v.incNum();
                exist = true;
            }
        }
        if (!exist) {
            votes.add(new Vote(vote, 1));
        }
    }

    private Production findProdId(int id) {
        for (Production production : productions) {
            if (production.getId() == id) {
                return production;
            }
        }
        return null;
    }

    private Production findWinner() {
        int maxVote = votes.get(0).getNumber();
        int winnerId = votes.get(0).getId();
        for (Vote vote : votes) {
            if (vote.getNumber() > maxVote) {
                maxVote = vote.getNumber();
                winnerId = vote.getId();
            }
        }
        return findProdId(winnerId);
    }

}
