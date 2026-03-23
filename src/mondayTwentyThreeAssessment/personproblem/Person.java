package mondayTwentyThreeAssessment.personproblem;

import java.util.List;

public class Person {

    private String fullName;

    private List<Problem> problemList;


    public Person(String fullName){
        this.fullName = fullName;
    }


    public void addProblem(Problem problem){
        problemList.add(problem);
    }

    public List<Problem> getProblemList(){
        return problemList;
    }

    public void resolveProblem(Problem problem){
        problem.solveProblem();
    }
}
