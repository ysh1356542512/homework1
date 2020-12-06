package watch;

public class Wh1data {
    private int head,picture;
    private String name,context,number1,number2;
    public Wh1data(int head,int picture,String name,String context,String number1,String number2){
        this.head = head;
        this.picture = picture;
        this.name = name;
        this.context = context;
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getHead() {
        return head;
    }

    public int getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }
}
