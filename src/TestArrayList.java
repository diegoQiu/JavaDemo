import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {

        ArrayList<String> cityList=new ArrayList<>();
        cityList.add("Denver");
        cityList.add("London");
        cityList.add("Losangles");
        cityList.add("New York City");

        System.out.println("Lisr Size? "+cityList.size());
        System.out.println("Is Miami int the List? "+cityList.contains("Miami"));
        System.out.println("Is the list empty? "+cityList.isEmpty());

        cityList.add(2,"chengdu");
        cityList.remove("losangles");
        cityList.remove(1);

        System.out.println(cityList.toString());
        for(int i=cityList.size()-1;i>=0;i--){
            System.out.print(cityList.get(i)+" ");
        }
        System.out.println();

    }
}
