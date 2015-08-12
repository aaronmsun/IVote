package ivote;

import java.util.Random;

public class SimulationDriver {

    /**
     * @param args the command line arguments main method
     */
    public static void main(String[] args) {
        /*
         * 1) create a question type and configure the answers;  
         * 2) configure the question for iVote Service; 
         * 3) randomly generate a number students and the answers; 
         * 4) submit all the students’ answers to iVote Service; 
         * 5) call the iVote Service output function to display the result
         */
        IVoteService iVoteService = new IVoteService();
        iVoteService.configureAnsweeType();//multy choce or single choice
        iVoteService.configureAnswers();//set the answers
        iVoteService.submitAnswer();//create random number of students and answer to teh question

        iVoteService.viewStatstics();//view statics before the re answer

        //re answer some sutdents
        Random r = new Random();
        int num = r.nextInt(iVoteService.students.size());
        for (int i = 0; i < num; i++) {
            iVoteService.students.get(i).answer(iVoteService.question.answers.get(r.nextInt(iVoteService.question.answers.size())));
        }

        iVoteService.viewStatstics();
    }

}
