package mondayTwentyThreeAssessment.personproblem;

public class Problem {

    private String name;

    private String type;

    private boolean isSolved;


    public Problem(String name, String type){
        this.name = name;
        this.type = type;
        this.isSolved = false;
    }

    public void solveProblem(){
        isSolved = true;
    }


}
