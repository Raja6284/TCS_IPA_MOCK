import java.util.*;

class AutonomousCar{
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;

    public AutonomousCar(int carId, String brand, int noOfTestsConducted,int noOfTestsPassed, String environment){
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }


    public int getCarId(){
        return carId;
    }

    public String getEnvironMent(){
        return environment;
    }

    public int getNoOfTestPassed(){
        return noOfTestsPassed;
    }

    public int getNoOfTestsConducted(){
        return noOfTestsConducted;
    }

    public String getBrand(){
        return brand;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getGreade(){
        return grade;
    }
}


public class Solution{


    public static int findTestPassedByEnv(AutonomousCar[] cars, String env){

        int sum = 0;

        for(AutonomousCar c: cars){
            if(c.getEnvironMent().equalsIgnoreCase(env)){
                sum = sum + c.getNoOfTestPassed();
            }
        }

        return sum;
    }


    public static AutonomousCar updateCarGrade(AutonomousCar[] cars, String brand){

        AutonomousCar ans = null;

        for(AutonomousCar c : cars){
            if(c.getBrand().equalsIgnoreCase(brand)){
                ans = c;
            }
        }

        int rating = 0;

        if(ans != null){
          rating = (ans.getNoOfTestPassed() * 100) / (ans.getNoOfTestsConducted());
        }


        if(rating >= 80){
            ans.setGrade("A1");
        }
        else{
            ans.setGrade("B2");
        }


        return ans;
    }

    public static void main(String args[]){
        
        AutonomousCar[] cars = new AutonomousCar[4];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            int conducted = sc.nextInt();
            sc.nextLine();
            int passed = sc.nextInt();
            sc.nextLine();
            String env = sc.nextLine();

            cars[i] = new AutonomousCar(id,brand,conducted,passed,env);
        }

        String env = sc.nextLine();
        String brand = sc.nextLine();

        int ans1 = findTestPassedByEnv(cars, env);
        if(ans1 > 0){
            System.out.println(ans1);
        }else{
            System.out.println("There are no tests passed in this particualr environment");
        }


        AutonomousCar ans2 = updateCarGrade(cars, brand);

        if(ans2 == null){
            System.out.println("No car is available with the specified brand");
        }else{
            System.out.println(ans2.getBrand() + "::" + ans2.getGreade());
        }
    }
}