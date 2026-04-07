import java.util.*;

class Student{
    private int rollNo;
    private String name;
    private String subject;
    private char grade;
    private String date;

    public Student(int rollNo,String name,String subject, char grade, String date){
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }

    public char getGrade(){
        return grade;
    }

    public String getDate(){
        return date;
    }

    public int getRollNo(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

}


public class Solution{

    public static Student[] findStudentByGradeAndMonth(Student students[],char grade, int month){

        List<Student> list = new ArrayList<>();
        for(Student s:students){
            String amonth = s.getDate().substring(3,5);
            String imonth = String.format("%02d",month);

            if(amonth.equalsIgnoreCase(imonth) && s.getGrade() == grade ){
                list.add(s);
            }
        }

        if(list.isEmpty()) return null;

        Collections.sort(list,(a,b)->a.getRollNo() - b.getRollNo());

        return list.toArray(new Student[0]);
    }

    public static void main(String args[]){

        Student[] students = new Student[4];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            int roll = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String subject = sc.nextLine();
            char grade = sc.nextLine().charAt(0);
            String date = sc.nextLine();

            students[i] = new Student(roll,name,subject,grade,date);
        }

        char igrade = sc.nextLine().charAt(0);
        int iroll = sc.nextInt();
        sc.close();


        Student[] ans = findStudentByGradeAndMonth(students, igrade, iroll);

        if(ans == null){
            System.out.println("No student found");
        }else{
            for(Student s:ans){
                System.out.println(s.getName());
                System.out.println(s.getSubject());
            }
            System.out.println(ans.length);
        }
    }
}