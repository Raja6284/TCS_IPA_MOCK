import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;

    public Course(int courseId,String courseName,String courseAdmin,int quiz, int handson){
        this.courseId = courseId;
        this.courseName=courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }


    public int getCourseId(){
        return courseId;
    }

    public String getCourseAdmin(){
        return courseAdmin;
    }

    public int getQuiz(){
        return quiz;
    }

    public int getHandson(){
        return handson;
    }

    public String getCouseName(){
        return courseName;
    }
}

public class CourseProgram{


    public static int findAvgOfQuizByAdmin(Course[] courses, String value){

        int count = 0;
        int sum = 0;

        for(Course c : courses){
            if(c.getCourseAdmin().equalsIgnoreCase(value)){
                sum += c.getQuiz();
                count++;
            }
        }

        if(count == 0){
            return 0;
        }

        int average = sum/count;

        return average;
    }


    public static Course[] sortCourseByHandsOn(Course[] courses, int value){

        List<Course> list = new ArrayList<>();

        for(Course c: courses){
            if(c.getHandson() < value){
                list.add(c);
            }
        }

        if(list.isEmpty()) return null;

        Collections.sort(list,(a,b)->a.getHandson() - b.getHandson());

        return list.toArray(new Course[0]);


    }

    public static void main(String args[]){
        
        

    }
}