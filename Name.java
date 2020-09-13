import java.util.Scanner;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String myFirstName,String myMidName,String myLastName){
        setFirstName(myFirstName);
        setMiddleName(myMidName);
        setLastName(myLastName);
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ getters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ setters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ print ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public String toString(){
        if(getFirstName()==null){
            return "noname";
        }
        return "First name: "+getFirstName()+" middle name: "+getMiddleName()+" last name: "+getLastName();
    }
}
