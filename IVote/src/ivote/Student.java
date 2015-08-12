package ivote;

public class Student {

    String id;
    Answer studentAnswer;

//    since the student answer is a attribute of a student, a student can have only one answer
    public Student(String id, Answer studentAnswer) {
        this.id = id;
        this.studentAnswer = studentAnswer;
    }
}
