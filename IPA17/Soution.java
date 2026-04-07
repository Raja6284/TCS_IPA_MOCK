import java.util.*;

class Antenna{
    int antennaid;
    String antennaName;
    String projectLead;
    double antennaVSWR;

    public Antenna(int antennaid, String antennaName, String projectLead, double antennaVSWR){
        this.antennaid = antennaid;
        this.antennaName = antennaName;
        this.projectLead = projectLead;
        this.antennaVSWR = antennaVSWR;
    }

    public int getAntennaId(){
        return antennaid;
    }

    public String getAntennaName(){
        return antennaName;
    }

    public String getProjectLead(){
        return projectLead;
    }

    public double getAntennaVSWR(){
        return antennaVSWR;
    }

}

public class Soution{

    public static int searchAntennaByName(Antenna[] ant, String name){

        int id = 0;
        for(Antenna a: ant){
            if(a.getAntennaName().equalsIgnoreCase(name)){
                id = a.getAntennaId();
            }
        }

        return id;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna[] ant,double vswr){

        List<Antenna> list = new ArrayList<>();
        for(Antenna a: ant){
            if(a.getAntennaVSWR() < vswr){
                list.add(a);
            }
        }

        if(list.isEmpty()) return null;
        
        Collections.sort(list,(a,b) -> Double.compare(a.getAntennaVSWR() , b.getAntennaVSWR()));

        return list.toArray(new Antenna[0]);
    }

    public static void main(String args[]){

        Antenna[] ant = new Antenna[4];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String lead = sc.nextLine();
            double vswr = sc.nextDouble();
            sc.nextLine();

            ant[i] = new Antenna(id,name,lead,vswr);
        }

        String iname= sc.nextLine();
        double ivswr = sc.nextDouble();
        sc.nextLine();
        sc.close();

        int ansid = searchAntennaByName(ant, iname);
        if(ansid == 0){
            System.out.println("There is no antenna with the given parameter");
        }else{
            System.out.println(ansid);
        }

        Antenna[] ans = sortAntennaByVSWR(ant, ivswr);

        if(ans == null){
            System.out.println("No Antenna found");
        }else{
            for(Antenna a: ans){
                System.out.println(a.getProjectLead());
            }
        }
    } 
}