/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
public class Manager extends Person{
    //private Name myName;
    private String dateOfBirth;
    private int star;
    private Team myTeam;

    public Manager(String myDateOfBirth,int myStar,int myPhone,String myEmail,Name myName){
        super(myPhone,myEmail,myName);
        setDateOfBirth(myDateOfBirth);
        setStar(myStar);
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ setters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setTeam(Team t) {
        if (getMyTeam() == null) {
            this.myTeam = t;
        } else if (getMyTeam() != null) {
            if(myTeam.getMyManager()==null){
                this.myTeam = t;
            }else{
                System.out.println("cant add");
            }
        }
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ getters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getStar() {
        return star;
    }

    public Team getMyTeam() {
        return myTeam;
    }

    public String getTeam() {
        if (myTeam.getMyManager() != null) {
            return myTeam.getColor();
        } else {
            return null;
        }
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ print ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public String toString() {
        return "Manager: " + super.toString()+" date of birth "+getDateOfBirth()+" stars: "+getStar();
    }
}
