/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Dec 2019
 */
import  java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ProcessText {
    //League[] league=new League[allLeagues];
    Team t;

    public League processLine(League league,String line) {
        //league[0]=new League("League");
        try {
            String parts [] = line.split(",");
            //System.out.println(parts);
            //System.out.println(line+"-----------------");
            //d,f,g,34567,rty,5,true
            //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ recreate the team ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

            if(parts.length==2){
                t=new Team(parts[1]);
                league.addMyTeam(t);
                //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ recreate the player ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

            }else if(parts.length==9){

                Name name = new Name(parts[2],parts[3],parts[4]);
                String phone = parts[5];
                String email = parts[6];
                String goals=parts[7];
                String goalie=parts[8];

                int phoneNum=Integer.parseInt(phone);
                int goalsNum=Integer.parseInt(goals);
                Boolean amIGoalie=Boolean.parseBoolean(goalie);

                //create Person object and add to the list
                Player p1=new Player(goalsNum,amIGoalie,phoneNum,email,name);
                //System.out.println(p1.toString());

                p1.setMyName(name);
                String p=parts[0];
                int position=Integer.parseInt(p);
                t=league.getTeam(position);
                t.addMyPlayer(p1);
                //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ reconstruct the manager ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

            }else if(parts.length==10){
                Name name = new Name(parts[3],parts[4],parts[5]);
                String phone = parts[6];
                String email = parts[7];
                String dob=parts[8];
                String stars=parts[9];

                int phoneNum=Integer.parseInt(phone);
                //int date=Integer.parseInt(dob);
                int myStars=Integer.parseInt(stars);
                Manager m1=new Manager(dob,myStars,phoneNum,email,name);
                m1.setMyName(name);
                String p=parts[0];
                int position=Integer.parseInt(p);
                t=league.getTeam(position);
                t.addMyManager(m1);
                m1.setTeam(t);
            }
        }
        //for these two formatting errors, ignore lines in error and try and carry on

        //this catches trying to convert a String to an integer
        // if used  ………………….
        catch (NumberFormatException nfe) {
            String error = "Number conversion error in '" + line + "'  - "
                    + nfe.getMessage();
            System.out.println(error);
        }
        //this catches missing items if only one or two items
        //other omissions will result in other errors
        catch (ArrayIndexOutOfBoundsException air) {
            String error = "Not enough items in  : '" + line
                    + "' index position : " + air.getMessage();
            System.out.println(error);
        }
        return league;

    }


}
