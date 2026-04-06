import java.util.*;

class Medicine{
    private String medicineName;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String medicineName,String batch, String disease, int price){
        this.medicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getMedicineName(){
        return medicineName;
    }

    public String getBatch(){
        return batch;
    }

    public String getDisease(){
        return disease;
    }

    public int getPrice(){
        return price;
    }
}

public class MyClass{

    public static Integer[] getPriceByDisease(Medicine[] medicines, String disease){

        List<Integer> list = new ArrayList<>();

        for(Medicine m:medicines){
            if(m.getDisease().equalsIgnoreCase(disease)){
                list.add(m.getPrice());
            }
        }

        if(list.isEmpty()) return new Integer[0];

        Collections.sort(list);

        return list.toArray(new Integer[0]);

    }

    public static void main(String args[]){

        Medicine[] medicines = new Medicine[4];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<4; i++){
            String name = sc.nextLine();
            String batch = sc.nextLine();
            String disease = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();

            medicines[i] = new Medicine(name, batch, disease, price);
        }

        String idisease = sc.nextLine();

        Integer[] ans = getPriceByDisease(medicines, idisease);

        for(Integer i: ans){
            if(i != null)
                System.out.println(i);
        }

    }
}