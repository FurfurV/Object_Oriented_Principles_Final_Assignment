import java.util.Scanner;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
public class Player extends Person{
    private int goals;
    private Boolean goalie;
    private Team myTeam;

    public Player(int goals,Boolean goalie,int myPhone,String myEmail,Name myName){
        super(myPhone,myEmail,myName);
        setGoals(goals);
        setGoalie(goalie);
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ getters▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public int getGoals() {
        return goals;
    }

    public Boolean getGoalie() {
        return goalie;
    }

    public String getTeam() {
        if (myTeam != null) {
            return myTeam.getColor();
        } else {
            return null;
        }
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ setters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setGoalie(Boolean goalie) {
        this.goalie = goalie;
    }

    public void setTeam(Team t) {
        if (getTeam() == null) {
            this.myTeam = t;
        } else if (getTeam() != null) {
            //System.out.println("cant add");
        }
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ print method ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public String toString() {
        String sentence="";
        if(goalie==true){
            sentence="was defending the goals:";
        }else{
            sentence="number of goals scored:";
        }
        return "Player: "+super.toString()+" "+sentence+goals+"\n";
    }

}
