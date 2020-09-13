import java.util.ArrayList;
import java.util.Scanner;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
public class League {
    private Team[] myTeam;
    private String name;
    private int total=20;

    public League(String myName) {
       setName(myName);
        myTeam=new Team[total];
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ add team to league▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
  public String addMyTeam(Team t) {
      String adds = "";

      if (getTotal() == total) { //checks if its already full
          adds = "myStack is already full";
      } else {
          if (myTeam[getTotal()] == null) { //adds it to the position if its null
              myTeam[getTotal()] = t;
              t.setLeague(this);
              int num = getTotal();
              adds = "added to object list at position " + (num - 1);
          }
      }
      return adds;
    }
    
    public void removeMyTeam(Team t){
        if(t.getLeague()!=null) {
            for (int i = 0; i <= getTotal() - 1; i++) {
                myTeam[i] = myTeam[i + 1];
            }
            myTeam[myTeam.length - 1] = null;
        }else{
            System.out.println(" ");
        }
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ setter▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
  public void setName(String name) {this.name = name;}

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ getters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public String getName() {
        return name;
    }

    public int getTotal() {
        int numItems = 0;
        for (int i = 0; i < myTeam.length; i++) {
            if (myTeam[i] != null) {
                numItems += 1;
            }
        }

        return numItems;
    }

    public String getTeamColor(int o) {
        return myTeam[o].getColor();
    }

    public Team getTeam(int i){
        return (Team)getObject(i);
    }

    public Object getObject(int index){
        return myTeam[index];
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ check uniqueness ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public Boolean checkUnique(String color){
        Boolean notFound=true;

        for(int i=0;i<getTotal();i++){
            //System.out.println(myTeam.length);
            if(getTeamColor(i)==null){
                notFound=true;
                break;
            }
            else if(getTeamColor(i).contains(color)){
                System.out.println("color already exists.");
                notFound=false;
                break;
            }
        }
        return notFound;
    }


    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ print ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public void printColors(){
        for(int i=0;i<getTotal();i++){
            if(getTeam(i)==null){
                break;
            }
            System.out.println(i+" "+getTeam(i).getColor());
        }
    }

    public String toString(){
        String teams="";
        for (int i = 0; i < myTeam.length; i++) {
            if(myTeam[i]==null){
                break;
            }else{
                teams+=i+" " + myTeam[i];
            }
        }
        return "In this league: \n"+teams;
    }
}
