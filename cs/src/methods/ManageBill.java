package methods;

import entity.Sell;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManageBill {

     ArrayList<Sell> sellArrayList = new ArrayList<>();

   public void add(Sell s){
       sellArrayList.add(s);
   }

    public void read() {
        for (Sell s : sellArrayList) {
            System.out.println(s.toString() + " Tổng tiền " + s.pay());
        }
    }

    public double totalPayDay() {
        LocalDate date = LocalDate.now();
        double sum = 0;
        for (Sell s : sellArrayList) {
            if (s.date.equals(date)) {
                sum += s.pay();
            }
        }
        return sum;
    }


}
