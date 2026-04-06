import java.util.Scanner;

class Player{
    private int playerId;
    private String skill;
    private String level;
    private int points;

    public Player(int playerId,String skill, String level,int points){
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    public int getPlayerId(){
        return playerId;
    }

    public String getSkill(){
        return skill;
    }

    public String getLevel(){
        return level;
    }

    public int getPoints(){
        return points;
    }

}


public class MyClass{

    public static int findPointsForGivenSkill(Player[] players, String value){

        int sum = 0;
        boolean found = false;

        for(Player p:players){
            if(p.getSkill().equalsIgnoreCase(value)){
                found = true;
                sum = sum + p.getPoints();
            }
        }

        if(!found) return 0;

        return sum;
    }


    public static Player getPlayerBasedOnLevel(Player[] players,String level, String skill){

        for(Player p:players){
            if(p.getSkill().equalsIgnoreCase(skill) && p.getLevel().equalsIgnoreCase(level) && p.getPoints() >= 20){
                return p;
            }
        }

        return null;
    }

    public static void main(String[] args){

        Player[] players = new Player[4];
        
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String skill = sc.nextLine();
            String level = sc.nextLine();
            int points = sc.nextInt();
            sc.nextLine();

            players[i] = new Player(id,skill,level,points);

            
        }

        String iskill = sc.nextLine();
        String ilevel = sc.nextLine();

        int ansPoints = findPointsForGivenSkill(players, iskill);
        if(ansPoints > 0){
            System.out.println(ansPoints);
        }else{
            System.out.println("The given skill is not available");
        }


        Player ansPlayer = getPlayerBasedOnLevel(players, ilevel, iskill);

        if(ansPlayer == null){
            System.out.println("No player is available with specified level, skill and eleigibility poitns");

        }else{
            System.out.println(ansPlayer.getPlayerId());
        }


    }
}