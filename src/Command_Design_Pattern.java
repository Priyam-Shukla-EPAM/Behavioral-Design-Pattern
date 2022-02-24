import java.util.ArrayList;
import java.util.List;

public class Command_Design_Pattern {
    public static void main(String[] args) {
        //Creating Request Object
        Stock st=new Stock();

        //Now we will pass the request object to command object
        buy_stocks buy_stock=new buy_stocks(st);
        sell_stocks sell_stock=new sell_stocks(st);

        stock_dealer st_dealer=new stock_dealer();
        st_dealer.place_order(buy_stock);
        st_dealer.place_order(sell_stock);
        st_dealer.display_orders();

    }
}

interface order{
    void display();
}

class buy_stocks implements order{
    //Implementation of Command Object
    private Stock stock;
    public buy_stocks(Stock stock){
        this.stock=stock;
    }
    public void display(){
        stock.buy_stock();
    }
}

class sell_stocks implements order{
    //Implementation of Command Object
    private Stock stock;
    public sell_stocks(Stock stock){
        this.stock=stock;
    }
    public void display(){
        stock.sell_stock();
    }
}

class Stock{
    //This is the request object class
    private String Stock_name="Meta Stocks";
    private int Stock_value=2000000;
    public void sell_stock(){
        System.out.println(Stock_name+" sold by Company A having value as "+Stock_value);
    }

    public void buy_stock(){
        System.out.println(Stock_name+" Purchased by Company A having market value as "+Stock_value);
    }
}

class stock_dealer{
    //This is the implementation of the Invoker Object
    private List<order> ord=new ArrayList<order>();

    public void place_order(order od){
        ord.add(od);
    }

    public void display_orders(){
        for(int i=0;i<ord.size();i++){
            ord.get(i).display();
        }
        ord.clear();
    }
}