import java.util.*;

class Phone{
    int phoneId;
    String os;
    String brand;
    int price;

    public Phone(int phoneId,String os,String brand,int price){
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public String getBrand(){
        return brand;
    }

    public String getOs(){
        return os;
    }

    public int getPhoneId(){
        return phoneId;
    }
}


public class Solution{

    public static int findPriceForGivenBrnad(Phone[] phones, String brand){
        int sum = 0;

        for(Phone p:phones){
            if(p.getBrand().equalsIgnoreCase(brand)){
                sum+= p.getPrice();
            }
        }

        return sum;
    }

    public static Phone getPhoneIdBasedOnOs(Phone[] phones, String os){

        Phone ans = null;
        for(Phone p: phones){
            if(p.getOs().equalsIgnoreCase(os) && p.getPrice() >= 50000){
                ans = p;
            }
        }

        return ans;
    }

    public static void main(String args[]){
        
        Phone phones[] = new Phone[4];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            int id = sc.nextInt();
            sc.nextLine();

            String os = sc.nextLine();
            String brand = sc.nextLine();

            int price = sc.nextInt();
            sc.nextLine();

            phones[i] = new Phone(id,os,brand,price);
        }

        String ibrand = sc.nextLine();
        String ios = sc.nextLine();
        sc.close();

        int price = findPriceForGivenBrnad(phones,ibrand);
        if(price > 0){
            System.out.println(price);
        }else{
            System.out.println("The given Brand is not available");
        }

        Phone ans = getPhoneIdBasedOnOs(phones, ios);

        if(ans != null){
            System.out.println(ans.getPhoneId());
        }else{
            System.out.println("No phones are available with specified os and price range");
        }
    }
}