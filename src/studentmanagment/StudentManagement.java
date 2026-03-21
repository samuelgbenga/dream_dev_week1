package studentmanagment;

public class StudentManagement {


    public static void main(String[] args) {

        String[] students = {"student1", "student2", "student3"};
        int[][] scores = {
                {1, 2, 4},
                {3, 2, 1},
                {5, 2, 4}
        };

        // These are PRE-CALCULATED (just dummy for now)
        int[] totals = {7, 6, 11};
        double[] averages = {2.33, 2.00, 3.67};
        int[] positions = {2, 3, 1};

        String result = buildResultTable(
                students,
                scores,
                totals,
                averages,
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
}
