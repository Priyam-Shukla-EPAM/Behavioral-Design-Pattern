import java.util.*;
public class Mediator_Design_Pattern {
    public static void main(String[] args) {
        Scanner S=new Scanner((System.in));
        String name1=S.nextLine();
        String name2=S.nextLine();
        String name3=S.nextLine();

        User user1=new User(name1);
        User user2=new User(name2);
        User user3=new User(name3);

        user1.sendMessage("Hi to all");
        user2.sendMessage("Welcome to EPAM Portal Meeting");
        user3.sendMessage("We'll discuss about the process of onboarding");
    }
}

class chat_app{
    public static void display_message_details(String msg,User user){
        System.out.println("User name is : "+user.getname()+" "+ " Message is : " +msg);
    }
}

class User{
    private String name;

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        chat_app.display_message_details(message,this);
    }
}

