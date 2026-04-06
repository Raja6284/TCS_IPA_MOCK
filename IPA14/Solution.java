import java.util.*;

class Movie{
    
    private String movieName;
    private String company;
    private String genre;
    private int budget;


    public Movie(String movieName,String company,String genre, int budget){
        this.movieName = movieName;
        this.company = company;
        this.genre  = genre;
        this.budget = budget;
    }

    public String getGenre(){
        return genre;
    }

    public int getBudget(){
        return budget;
    }
}

public class Solution{

    public static Movie[] getMovieByGenre(Movie[] movies, String searchGenre){

        List<Movie> list = new ArrayList<>();

        for(Movie m:movies){
            if(m.getGenre().equalsIgnoreCase(searchGenre)){
                list.add(m);
            }
        }

        return list.toArray(new Movie[0]);

    }

    public static void main(String args[]){
        
        Movie movies[] = new Movie[4];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            String name = sc.nextLine();
            String company = sc.nextLine();
            String genre = sc.nextLine();
            int budget = sc.nextInt();
            sc.nextLine();

            movies[i] = new Movie(name,company,genre,budget);
        }

        String igenre = sc.nextLine();
        sc.close();

        Movie ans[] = getMovieByGenre(movies, igenre);

        for(Movie m: ans){
            if(m.getBudget() > 80000000){
                System.out.println("High Budget Movie");
            }else{
                System.out.println("Low Budget Movie");
            }
        }
    }
}