package studentmanagment;

import java.util.Arrays;

public class StudentManagement {


    static int numberOfStudents = 4;
    static int numberOfSubjects = 3;
    static final int PASS_MARK = 50;
    static int hardestSubject = 0;
    static int easiestSubject = 0;
    static int numberOfSuccess = Integer.MIN_VALUE;
    static int numberOfFailures = Integer.MIN_VALUE;

    public static void main(String[] args) {

      
        int[][] scores = {
                {51, 2, 4},
                {53, 2, 1},
                {43, 2, 4},
                {55, 2, 4}
        };


        int[][] subjectScoreArr = new int[numberOfStudents][numberOfSubjects];
        String[] studentArr = new String[numberOfStudents];
        double[] studentAverageScore = calculateAverages(scores);
        int[] totalStudentScore = calculateTotals(scores);
        int[] studentsPosition = calculatePositions(totalStudentScore);
        fillStudentNames(studentArr);
        int[][] transposeScore = transpose(scores);


        System.out.println(Arrays.toString(studentArr));


        int[] totals = {7, 6, 11};
        double[] averages = {2.33, 2.00, 3.67};
        int[] positions = {2, 3, 1};

        String result = buildResultTable(
                studentArr,
                scores,
                totalStudentScore,
                studentAverageScore,
                studentsPosition
        );

        System.out.println(result);

        loopThroughTheScore(transposeScore);

        System.out.println(overAllSummary());

    }


    private static String buildResultTable(
            String[] students,
            int[][] scores,
            int[] totals,
            double[] averages,
            int[] positions
    ) {

        int studentCount = students.length;
        int subjectCount = scores[0].length;

        StringBuilder output = new StringBuilder();

        output.append("============================================================\n");

        // Header
        output.append(String.format("%-12s", "Name"));

        for (int i = 0; i < subjectCount; i++) {
            output.append(String.format(" %-6s", "SUB" + (i + 1)));
        }

        output.append(String.format(" %-6s %-8s %-6s%n", "TOT", "AVE", "POS"));

        output.append("------------------------------------------------------------\n");

        // Rows (pure mapping by index)
        for (int i = 0; i < studentCount; i++) {
            output.append(String.format("%-12s", students[i]));

            for (int j = 0; j < subjectCount; j++) {
                output.append(String.format(" %-6d", scores[i][j]));
            }

            output.append(String.format(
                    " %-6d %-8.2f %-6d%n",
                    totals[i],
                    averages[i],
                    positions[i]
            ));
        }

        output.append("============================================================");

        return output.toString();
    }

    private static void fillStudentNames(String[] students) {
        for (int i = 0; i < students.length; i++) {
            students[i] = "Student" + (i + 1);
        }
    }

    private static int[] calculateTotals(int[][] scores) {
        int[] totals = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int sum = 0;

            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
            }

            totals[i] = sum;
        }

        return totals;
    }

    private static double[] calculateAverages(int[][] scores) {
        double[] averages = new double[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int sum = 0;

            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
            }

            averages[i] = (double) sum / scores[i].length;
        }

        return averages;
    }


    private static int[] calculatePositions(int[] averages) {
        int n = averages.length;
        int[] positions = new int[n];

        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {
                if (averages[j] > averages[i]) {
                    rank++;
                }
            }

            positions[i] = rank;
        }

        return positions;
    }

    private static int[][] transpose(int[][] original) {
        int rows = original.length;
        int cols = original[0].length;

        int[][] flipped = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flipped[j][i] = original[i][j];
            }
        }

        return flipped;
    }

    private static String buildSubjectReport(
            int subjectNumber,
            String highestStudent,
            int highestScore,
            String lowestStudent,
            int lowestScore,
            int totalScore,
            double averageScore,
            int numberOfPass,
            int numberOfFail
    ) {
        return String.format("""
            Subject %d
            Highest Scoring Student is: %s scoring %d
            Lowest Scoring Student is: %s scoring %d
            Total Score is: %d
            Average Score is: %.2f
            Number of Passes: %d
            Number of Fails: %d
            """,
                subjectNumber,
                highestStudent,
                highestScore,
                lowestStudent,
                lowestScore,
                totalScore,
                averageScore,
                numberOfPass,
                numberOfFail
        );
    }

    private static void loopThroughTheScore(int[][] array) {

        System.out.println("SUBJECT SUMMARY");
        for (int i = 0; i < array.length; i++) {

            int subjectNumber = i + 1;
            int[] scores = array[i];

            String report = buildSubjectReport(
                    subjectNumber,
                    getHighestStudent(scores),
                    getHighestScore(scores),
                    getLowestStudent(scores),
                    getLowestScore(scores),
                    getTotalScore(scores),
                    getAverageScore(scores),
                    getNumberOfPasses(scores, subjectNumber),
                    getNumberOfFails(scores, subjectNumber)
            );

            System.out.println(report);
        }
    }

    private static int getHighestScore(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) max = score;
        }
        return max;
    }

    private static String getHighestStudent(int[] scores) {
        int max = getHighestScore(scores);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                return "Student" + (i + 1);
            }
        }
        return "N/A";
    }

    private static int getLowestScore(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) min = score;
        }
        return min;
    }

    private static String getLowestStudent(int[] scores) {
        int min = getLowestScore(scores);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == min) {
                return "Student" + (i + 1);
            }
        }
        return "N/A";
    }

    private static int getTotalScore(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    private static double getAverageScore(int[] scores) {
        int total = getTotalScore(scores);
        return (double) total / scores.length;
    }

    private static int getNumberOfPasses(int[] scores, int subjectNumber) {
        int count = 0;
        for (int score : scores) {
            if (score >= PASS_MARK) count++;
        }
        if(numberOfSuccess < count ){
            numberOfSuccess = count;
            easiestSubject = subjectNumber;
        }
        return count;
    }

    private static int getNumberOfFails(int[] scores, int subjectNumber) {
        int count = 0;
        for (int score : scores) {
            if (score < PASS_MARK) count++;
        }
        if(numberOfFailures < count ){
            numberOfFailures = count;
            hardestSubject = subjectNumber;
        }
        return count;
    }

    private static String overAllSummary() {
        return String.format("""
            The hardest subject is subject%d with %d failures
            The easiest subject is subject%d with %d success
            """,
                hardestSubject,
                numberOfFailures,
                easiestSubject,
                numberOfSuccess

        );
    }
}
