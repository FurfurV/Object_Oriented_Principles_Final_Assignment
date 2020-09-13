import java.util.Scanner;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
public class Team {
    private Manager myManager;
    private Player[] myPlayer;
    private League myLeague;
    private String color;
    private int total=11;

    public Team(String myColor){
        setColor(myColor);
        myPlayer=new Player[total];
        for (int i = 0; i < total; i++)
            myPlayer[i] = null;
    }

//▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Setters▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public void setColor(String color) {
        this.color = color;
    }


    public void setLeague(League l) {
        if (getLeague() == null) {
            this.myLeague = l;
        } else if (getLeague() != null) {
            //System.out.println("cant add");
        }
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Getters▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public int getTotal() {
        int numItems = 0;
        for (int i = 0; i < myPlayer.length; i++) {
            if (myPlayer[i] != null) {
                numItems += 1;
            }
        }
        return numItems;
    }

    public Manager getMyManager() {
        return myManager;
    }

    public Player[] getMyPlayerName() {
        return myPlayer;
    }

    public String getLeague() {
        if (myLeague != null) {
            return myLeague.getName();
        } else {
            return null;
        }
    }

    public String getColor() { return color; }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ add manager and player ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public void addMyManager(Manager myManager) {
        if(getMyManager()==null) {
            this.myManager = myManager;
        }else {
            System.out.println("already have a manager");
        }
    }

    public String addMyPlayer(Player p){
        String adds = "";
        if (getTotal() == total) {
            adds ="myStack is already full";
        } else {
            if (myPlayer[getTotal()] == null) {
                myPlayer[getTotal()] = p;
                p.setTeam(this);
                int num=getTotal();
                adds ="added to object list at position "+(num-1);
            }
        }
        return adds;

    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ remove ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public void removeMyManager(Manager myManager) {
        if(getMyManager()==null) {
            System.out.println("no manager found");
        }else {
           this.myManager = null;
        }
    }

    public void removeMyPlayer(Player p){
        if(p.getTeam()!=null) {
            for (int i = 0; i <= getTotal() - 1; i++) {
                myPlayer[i] = myPlayer[i + 1];
            }
            myPlayer[myPlayer.length - 1] = null;
        }else{
            System.out.println(" ");
        }

    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ search for specific name ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public Player search(int position) {
        return myPlayer[position];
    }

    public int indexOf(Name name){
        int index=-1;
        if (name == null) {
            for (int i = 0; i <myPlayer.length-1; i++){
                if (myPlayer[i]==null)
                    return i;
            }
        } else {
            for (int i = 0; i < myPlayer.length-1; i++){

                String fN=myPlayer[i].getMyName().getFirstName(); //check first,second and last name
                fN+=myPlayer[i].getMyName().getMiddleName();
                fN+=myPlayer[i].getMyName().getLastName();

                String fN2=name.getFirstName();
                fN2+=name.getMiddleName();
                fN2+=name.getLastName();

                if (fN.equals(fN2))
                    index= i;
                    break;
            }
        }
        return index;
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ information for the file ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public String getAllPlayersAndManager(String report){

        for(int k=0;k<myLeague.getTotal();k++){
            int teamSize=myLeague.getTeam(k).getTotal();
            if(myLeague.getTeam(k).myPlayer==null){
            }else{
                for(int j=0;j<teamSize;j++){
                        if(myPlayer[j]==null){
                        }else {
                            report+=j+","+myPlayer[j].getMyName().getFirstName();
                            report+=","+myPlayer[j].getMyName().getMiddleName();
                            report+=","+myPlayer[j].getMyName().getLastName();
                            report+=","+myPlayer[j].getPhone();
                            report+=","+myPlayer[j].getEmail();
                            report+=","+myPlayer[j].getGoals();
                            report+=","+myPlayer[j].getGoalie();
                            report += "\n";
                        }
                }
                if(myManager==null) {
                }else if(myLeague.getTeam(k).myManager!=null){
                    report+=k+",0,1,"+myManager.getMyName().getFirstName();
                    report+=","+myManager.getMyName().getMiddleName();
                    report+=","+myManager.getMyName().getLastName();
                    report+=","+myManager.getPhone();
                    report+=","+myManager.getEmail();
                    report+=","+myManager.getDateOfBirth();
                    report+=","+myManager.getStar()+"\n";
                }
            }
        }
        return report;
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ ToString▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public String toString(){
        String players="";
        for(int i=0;i<getTotal();i++){
            if(myPlayer[i]!=null ){
                players+=myPlayer[i]+" \n";
            } else{
                break;
            }
        }if(myManager!=null){
            players+=myManager;
        }
        return "Team color: "+color +" \n"+ players;
    }
}
