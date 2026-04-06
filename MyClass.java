import java.util.*;

class Employee{
    int employeeId;
    String name;
    String branch;
    double rating;
    boolean companyTransport;

    public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport){
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }

    public String getBranch(){
        return branch;
    }

    public boolean getCompanyTransport(){
        return companyTransport;
    }

    public double getRating(){
        return rating;
    }

    public String getName(){
        return name;
    }

    public int getEmployeeId(){
        return employeeId;
    }
}


public class MyClass{
    
    public static int findCountOfEmployeesUsingCompTransport(Employee[] employee, String value){

        int count = 0;
        for(Employee e: employee){
            if(e.getBranch().equals(value)){
                if(e.getCompanyTransport() == true){
                    count++;
                }
            }
        }

        return count;
    }


    public static Employee findEmployeeWithSecondHighestRating(Employee[] employee){
        
        List<Employee> list = new ArrayList<>();

        for(Employee e: employee){
            if(!e.getCompanyTransport()){
                list.add(e);
            }
        }

        if(list.isEmpty()) return null;

        Collections.sort(list, (a,b) -> Double.compare(b.getRating(), a.getRating()));
        
        return list.size() > 1 ? list.get(1) : null;
    }
    
    public static void main(String args[]){

        Employee[] employees = new Employee[4];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String branch = sc.nextLine();
            double rating = sc.nextDouble();
            sc.nextLine();
            boolean isCom = sc.nextBoolean();
            sc.nextLine();

            employees[i] = new Employee(id,name,branch,rating,isCom);
        }


            String pbranch = sc.nextLine();

            int comTans = findCountOfEmployeesUsingCompTransport(employees,pbranch);

            Employee ratingAns = findEmployeeWithSecondHighestRating(employees);

            if(comTans > 0){
                System.out.println(comTans);
            }else{
                System.out.println("No such Employees");
            }

            if(ratingAns != null){
                System.out.println(ratingAns.getEmployeeId());
                System.out.println(ratingAns.getName());
            }else{
                System.out.println("All Employees using company transport");
            }
        
    }
}