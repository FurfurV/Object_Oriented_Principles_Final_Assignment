/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
import java.io.IOException;
import java.util.Scanner;
public class Application {
    private static int allLeagues = 10;
    private Team myTeam;

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        League[] league=new League[allLeagues];
        league[0]=new League("League");
        Team myTeam;
        int pick=-1;

       //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Main menu ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
       do{
            System.out.println("1.    Create a new Team, Player or Manager and add Player/Manager to a Team.");
            System.out.println("2.    Remove a Player.");
            System.out.println("3.    Search for a Player by supplying the Player name. Display goals and Manager details.");
            System.out.println("4.    Display all players in a particular Team.");
            System.out.println("5.    Display all Teams in the League.");
            System.out.println("6.    Save all information to a text file.");
            System.out.println("7.    Load information from a text file.");
            System.out.println("8.    Quit");

            pick = ErrorMess.getInt();
            switch (pick) {
                //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ sub menu -adding  ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                case 1:
                        System.out.println("1. Create a new Team.");
                        System.out.println("2. Create a new Player and add to a Team.");
                        System.out.println("3. Create a new Manager and add to a Team.");

                    int pickSub = ErrorMess.getInt();
                    switch (pickSub){
                        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Create a new team▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                        case 1: // Create a new Team
                            String color=checkColor(league); //call function to check team uniqueness
                            myTeam=new Team(color);
                            league[0].addMyTeam(myTeam);
                            break;
                        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Create a new Player▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                        case 2:
                            if(league[0].getTotal()==0){
                                System.out.println("You must create a team first.");
                                break;
                            }
                            createMember(league,2);
                            break;
                        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ create a new manager ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                        case 3:
                            if(league[0].getTotal()==0){
                                System.out.println("You must create a team first.");
                                break;
                            }
                            createMember(league,3);
                            break;
                    }
                    break;
                    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Remove a player.▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                case 2:
                    removePlayer(league);
                    break;
                //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Search for a player.▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                case 3:
                    search(league);
                    break;
            //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Display all players in a particular Team.▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                case 4:
                    System.out.println("Which team?: ");
                    league[0].printColors();
                     int team=ErrorMess.getInt();
                    System.out.println(league[0].getTeam(team));
                    break;
            //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Display all Teams in the League.▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                case 5:
                    for(int i=0;i<allLeagues;i++){
                        if(league[0].getTeam(i)==null){
                            break;
                        }
                        System.out.println(league[0].getTeam(i)+"\n ---------\n");
                    }
                    break;
                //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Save to a text file ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                case 6:
                    String lines="";
                    String report="";
                    for(int i=0;i<league[0].getTotal();i++){
                        if(league[0].getTeam(i).getAllPlayersAndManager(report).length()==0){
                            lines+=i+","+league[0].getTeam(i).getColor()+"\n";
                        }else{
                            lines+=i+","+league[0].getTeam(i).getColor()+"\n";
                            lines+=i+","+league[0].getTeam(i).getAllPlayersAndManager(report);
                        }
                    }
                    System.out.println(lines);
                    String file_name="myLeague.txt";
                    try{
                        WriteFile data = new WriteFile( file_name , false );
                        data.writeToFile(lines);

                        System.out.println("written to file");
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Read from text file ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
                case 7:
                    file_name="myLeague.txt";
                    if(league[0].getTotal()==0){
                        try {
                            ReadFile file = new ReadFile(file_name);
                            String[] myText = file.OpenFile();

                            int i;
                            for (i = 0; i < myText.length; i++) {
                                //System.out.println(myText[i]);
                                ProcessText text = new ProcessText();
                                league[0] = text.processLine(league[0], myText[i]);
                            }
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println("File loaded in.\n");
                    }else{
                        System.out.println("Already loaded the file.\n");
                    }
                    break;
            }
        }while (pick!=8);
        System.out.println("Thank you for using my program, bye! ⚽");
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ functions used here ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ create a new name▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static Name getName(){
        Scanner input= new Scanner(System.in);
        System.out.print("First name:");
        String fName=input.next();
        System.out.print("Middle name:");
        String mName=input.next();
        System.out.print("Last name:");
        String lName=input.next();
        Name n2=new Name(fName,mName,lName);
        return n2;
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ create team member▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static void createMember(League[] league,int c){
        Scanner input=new Scanner(System.in);
        Team myTeam;
        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ create person ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        Name n1=getName();

        System.out.print("Phone: ");
        int phone=ErrorMess.getInt();
        System.out.print("Email:");
        String email=input.next();

        if(c==2){
            //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ create player ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
            System.out.print("Goals:");
            int goals=ErrorMess.getInt();
            //System.out.print("Are you a goalie?:");
            Boolean goalie=checkBool();

            Player p1=new Player(goals,goalie,phone,email,n1);
            p1.setMyName(n1);

            //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ add player to team▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
            league[0].printColors();
            System.out.print("Which team?: ");

            int team=ErrorMess.getInt();
            System.out.println(league[0].getTeamColor(team));
            myTeam=league[0].getTeam(team);
            myTeam.addMyPlayer(p1);
        }else if(c==3){
            //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ create manager ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
            System.out.print("Date of birth:");
            String date=input.next();
            Boolean inRange=false;
            int star=0;

            while(!inRange) {
                System.out.print("Star rating");
                star = ErrorMess.getInt();
                if(star>0 && star<11){
                    inRange=true;
                }else{
                    System.out.println("star rating between 1 and 10 only");
                }
            }
            Manager m1=new Manager(date,star,phone,email,n1);
            m1.setMyName(n1);

            //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ add manager to a team▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
            league[0].printColors();
            System.out.print("Which team?: ");
            int team=ErrorMess.getInt();
            System.out.println(league[0].getTeamColor(team));
            myTeam=league[0].getTeam(team);
            myTeam.addMyManager(m1);
            m1.setTeam(myTeam);
        }
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ check color uniqueness▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static String checkColor(League[] league){
        Scanner input=new Scanner(System.in);
        Boolean myColor=false;
        String color="";
        while(!myColor){
            System.out.print("Enter color for the Team: ");
            color=input.next().toLowerCase();
            myColor=league[0].checkUnique(color);
        }
        return color;
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ remove player from team▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static void removePlayer(League[] league){
        System.out.println("In which team?: ");
        league[0].printColors();
        int team=ErrorMess.getInt();

        if(league[0].getTeam(team)==null){
            System.out.println("no player found");
        }else{
            Name n1=getName();

            int index=league[0].getTeam(team).indexOf(n1);
            if(index==-1){
                System.out.println("not found :(");
            }else{
                Player foundPlayer = league[0].getTeam(team).search(index);
                league[0].getTeam(team).removeMyPlayer(foundPlayer);
                System.out.println(foundPlayer+" removed");
            }
        }
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ check if yes/no typed ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static Boolean checkBool(){
        Boolean choice=true;
        Boolean boolGoalie=false;
        Scanner input=new Scanner(System.in);

        while(!boolGoalie){
            System.out.print("Are you a goalie? ");
            String isItBool=input.next().toLowerCase();
            if(isItBool.equals("yes") ){
                choice=true;
                boolGoalie=true;
            }else if(isItBool.equals("no")){
                choice=false;
                boolGoalie=true;
            }else{
                System.out.println("yes or no answer only please");
                boolGoalie=false;
            }
        }
        return choice;
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ search function▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static void search(League[] league){
        System.out.print("In which team?: ");
        league[0].printColors();
        int team=ErrorMess.getInt();
        int teamLength=league[0].getTeam(team).getTotal();

        if (teamLength == 0) {
            System.out.println("no player found");
        } else {
            Name n2=getName();
            int index=league[0].getTeam(team).indexOf(n2);

            if (index == -1) {
                System.out.println("not found :( ");
                //break;
            } else {
                Player foundPlayer = league[0].getTeam(team).search(index);
                //System.out.println(foundPlayer.getMyNameString());
                System.out.println("My manager: "
                        +league[0].getTeam(team).getMyManager()
                        + " my goals:" + foundPlayer.getGoals());
            }
        }
    }
}
