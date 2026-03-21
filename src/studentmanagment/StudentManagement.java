package studentmanagment;

import java.util.Arrays;

public class StudentManagement {


    static int numberOfStudents = 3;
    static int numberOfSubjects = 3;

    public static void main(String[] args) {

      
        int[][] scores = {
                {1, 2, 4},
                {3, 2, 1},
                {5, 2, 4}
        };


        int[][] subjectScoreArr = new int[numberOfStudents][numberOfSubjects];
        String[] studentArr = new String[numberOfStudents];
        double[] studentAverageScore = calculateAverages(scores);
        int[] totalStudentScore = calculateTotals(scores);


        fillStudentNames(studentArr);

        System.out.println(Arrays.toString(studentArr));

        // These are PRE-CALCULATED (just dummy for now)
        int[] totals = {7, 6, 11};
        double[] averages = {2.33, 2.00, 3.67};
        int[] positions = {2, 3, 1};

        String result = buildResultTable(
                studentArr,
                scores,
                totalStudentScore,
                studentAverageScore,
                positions
        );

        System.out.println(result);
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


    private static int[] calculatePositions(double[] averages) {
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
}
