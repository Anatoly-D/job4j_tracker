package hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0;
        double qtyScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                qtyScore++;
            }
        }
        return sumScore / qtyScore;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double sumScore = 0;
        double qtyScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                qtyScore++;
            }
            labels.add(new Label(pupil.name(), sumScore / qtyScore));
            sumScore = 0;
            qtyScore = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> scoreMap = createMap(pupils);

        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            labelList.add(new Label(entry.getKey(), (double) entry.getValue() / (double) pupils.size()));
        }

        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sumScore = 0;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            labels.add(new Label(pupil.name(), sumScore));
            sumScore = 0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> scoreMap = createMap(pupils);

        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue()));
        }

        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Map<String, Integer> createMap(List<Pupil> pupils) {
        Map<String, Integer> scoreMap = new HashMap<>();
        String subjectName;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectName = subject.name();
                scoreMap.putIfAbsent(subjectName, 0);
                scoreMap.replace(subjectName, scoreMap.get(subjectName) + subject.score());
            }
        }
        return scoreMap;
    }
}
