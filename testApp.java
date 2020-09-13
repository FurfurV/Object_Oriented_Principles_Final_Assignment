/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
import java.util.Scanner;
import java.util.ArrayList;

public class testApp {
    static int allLeagues = 10;
    //ArrayList<League> league=new ArrayList<League>();
    //private ArrayList<Team> team;
    //private static ArrayList<Name> myName = new ArrayList<>();
    private static ArrayList<Player> myPlayer = new ArrayList<>();
    private static ArrayList<Manager> manager = new ArrayList<>();

    public static void main(String[] args) {
        //League myLeagues=new League[allLeagues];
        League[] league=new League[10];

        league[0]=new League("myLeague");

        Name n1=new Name("first","mid","last");
        Name n2=new Name("f","m","l");
        Name n3=new Name("f1","m1","l1");

        Player p1 =new Player(6,true,234545,"mail",n1);
        Player p2=new Player(3,false,3456,"email",n2);

        Manager m1 =new Manager("feb/1993",5,23456,"mail2",n3);
        Manager m2 =new Manager("feb/1996",4,2545,"mail7",n1);
        Team t1=new Team("red");
        Team t2=new Team("purple");

        //ArrayList<Team> t1= new ArrayList<Team>();

        league[0].addMyTeam(t1);
        league[0].addMyTeam(t2);

        p1.setMyName(n1);
        p2.setMyName(n3);
        m1.setMyName(n2);
        m2.setMyName(n1);

        System.out.println("---------------------------------------");
        t1.addMyPlayer(p1);
        t1.addMyPlayer(p2);
        t1.addMyManager(m1);
        t1.addMyManager(m2);

        //Player p1 =new Player(7,true,3456,"mail");

        //System.out.println(p1);
        //System.out.println(m1);
        //System.out.println(m2);
        System.out.println(t1.toString());
        System.out.println("---------------------------------------1");
        System.out.println(t2.toString());
        System.out.println("---------------------------------------2");

        //t1.removeMyPlayer(p2);
        t1.removeMyManager(m1);
        //l1.addMyTeam(t1);

        System.out.println(t1.toString());
        System.out.println("---------------------------------------3");
        //System.out.println(t1.toString());
        System.out.println("---------------------------------------4");
        //System.out.println(l1.toString());

        System.out.println(league[0].toString());

    }
}
