package ivote;

import java.util.ArrayList;
import java.util.Random;

public class IVoteService {

    boolean isMultipleChoce = false;
    Question question = new Question();
    ArrayList<Student> students = new ArrayList<>();

    /**
     * Set the answers type
     */
    public void configureAnsweeType() {

        //create a new question
        question = new Question();

//radom way to set the question type
        Random r = new Random();
        int num = r.nextInt(100);
        if (num / 2 == 0) {
            isMultipleChoce = false;
            System.out.println("Set Question Type as Single Choice!");
        } else {
            isMultipleChoce = true;
            System.out.println("Set Question Type as Multiple Choice!");
        }

    }

    /**
     * set the answers as the type
     */
    public void configureAnswers() {
        if (!isMultipleChoce) {
            Answer r = new Answer();
            r.answer = "1. Right";
            Answer w = new Answer();
            w.answer = "2. Wrong";

            question.answers.add(r);
            System.out.println("Answer addded to the question:" + r);

            question.answers.add(w);
            System.out.println("Answer addded to the question:" + w);

        } else {
            Answer a = new Answer();
            a.answer = "A";
            question.answers.add(a);
            System.out.println("Answer addded to the question:" + a);

            Answer b = new Answer();
            b.answer = "B";
            question.answers.add(b);
            System.out.println("Answer addded to the question:" + b);

            Answer c = new Answer();
            c.answer = "C";
            question.answers.add(c);
            System.out.println("Answer addded to the question:" + c);

            Answer d = new Answer();
            d.answer = "D";
            question.answers.add(d);
            System.out.println("Answer addded to the question:" + d);

        }
    }

    /**
     * Submit an answer enter ID and answer
     */
    public void submitAnswer() {

        Random r = new Random();
        int num = r.nextInt(100);

        //if single choce
        if (!isMultipleChoce) {
            for (int i = 0; i < num; i++) {
                Answer a = question.answers.get(r.nextInt(2) % 2);//right or wrong
                //create unique student name and give the answer
                Student s = new Student("student" + Integer.toString(i), a);
                System.out.println("Student :" + s.id + "Answered as :" + s.studentAnswer);

                //increment the count of the answers
                a.count++;
                students.add(s);

            }
        } else {
            //if miltiple choice
            for (int i = 0; i < num; i++) {
                Answer a = question.answers.get(r.nextInt(4) % 4);//pick a random ansewr
                //create unique student name and give the answer
                Student s = new Student("student" + Integer.toString(i), a);
                System.out.println("Student :" + s.id + "Answered as: " + s.studentAnswer);
                //increment the count of the answers
                a.count++;
                students.add(s);
            }
        }

    }

    /**
     * View Statistics of the vote
     */
    public void viewStatstics() {

        System.out.println("\n\n***Stastistics***");

        for (Answer answer : question.answers) {
            System.out.print(answer.answer + " : " + answer.count + ", ");
        }
        System.out.println("\n\n");
    }

}
