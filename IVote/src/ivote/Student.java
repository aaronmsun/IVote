package ivote;

public class Student {

    String id;
    Answer studentAnswer;

//    since the student answer is a attribute of a student, a student can have only one answer
    public Student(String id, Answer studentAnswer) {
        this.id = id;
        this.studentAnswer = studentAnswer;
    }

    /**
     * can use this method to re answer to the question
     *
     * @param answer
     */
    public void answer(Answer answer) {
        if (!answer.toString().equals(studentAnswer.toString())) {
            System.out.println(id + "\'s answer has changed from : " + studentAnswer.toString() + " to : " + answer.toString());
            studentAnswer.count--;
            studentAnswer = answer;
            answer.count++;

        } else {
        }
    }
}
