//爬取一个URL中包含的其他URL，并打印出来，最多一百个
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class WebCrawler {
    public static void main(String[] args) {
        java.util.Scanner input=new java.util.Scanner(System.in);
        System.out.println("Enter a url: ");
        String url=input.nextLine();
        crawler(url);
    }

    public static void crawler (String startingURL){
        ArrayList<String> listOfPendingURLs=new ArrayList<>();
        ArrayList<String> listOfTraversedURLs=new ArrayList<>();
        listOfPendingURLs.add(startingURL);

        while(!listOfPendingURLs.isEmpty()&&
                listOfTraversedURLs.size()<=100){
            String urlString=listOfPendingURLs.remove(0);
            if(!listOfTraversedURLs.contains(urlString)){
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawl "+urlString);
                for(String s:getSubURls(urlString)){
                    if(!listOfTraversedURLs.contains(s))
                        listOfPendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURls(String urlString){
        ArrayList<String> list=new ArrayList<>();

        try{
            java.net.URL url=new java.net.URL(urlString);
            Scanner input=new Scanner(url.openStream());
            int current=0;
            while(input.hasNext()){
                String line=input.nextLine();
                current=line.indexOf("http:",current);
                while(current>0){
                    int endIndex=line.indexOf("\"",current);
                    if(endIndex>0 ){
                        list.add(line.substring(current,endIndex));
                        current=line.indexOf("http:",endIndex);
                    }
                    else
                        current=-1;
                }
            }
        }
        catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return list;
    }
}
