import java.util.Scanner;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Nov 2019
 */
public class Person {
    private Name myName;
    private int phone;
    private String email;

    public Person(){

    }

    public Person(int myPhone,String myEmail,Name myName){
        setPhone(myPhone);
        setEmail(myEmail);
        setMyName(myName);
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ getters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Name getMyName(){
        return myName;
    }

    public Name getMyNameString() {
        System.out.println(myName);
        return myName;
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ setters ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public void setMyName(Name myName) {
        this.myName = myName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ print ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

    public String toString(){
        if(myName==null){
            return "no name found";
        }
        return "Your email address:"+getEmail()+" Your phone number: "+getPhone()+" \n"+myName.toString();
    }

}
