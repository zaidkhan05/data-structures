import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.net.*;

class PersonNotFound extends Exception{
    PersonNotFound(){}
    PersonNotFound(String message){
        super(message);
    }
}


public class Assignment6 {

    static ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<String>();
        try{
            Socket s = new Socket("api.coindesk.com", 80);
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("GET http://api.coindesk.com/v1/bpi/currentprice.json HTTP/1.0\n\n");
            pw.flush();
            // BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // String line;
            // while((line = br.readLine()) != null){
            //     lines.add(line);
            // }
            // s.close();
            Scanner sc = new Scanner(s.getInputStream());
            while(sc.hasNextLine()){
                data.add(sc.nextLine());
            }
            s.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return data;
    }

    static float getDollarPrice(ArrayList<String> lines) {
        boolean header=true;
        String json="";
        for(String line : lines) {
            if(line.equals("")) {
                header=false;
                continue;
            } 
            if(header==false) {
                json=line;
                break;
            }
        }
        //System.out.println("Json: "+json);
        String[] jsonParts=json.split(":");
        String priceLine=jsonParts[19];
        String justPrice=priceLine.replace("},\"GBP\"","");
        float price=Float.parseFloat(justPrice);
        return price;
    }

    //buybitcoin
    static void buyBitcoin(float price) {

        try {
            String dataline = "";
            File investments = new File("initialInvestmentUSD.txt");
            Scanner scan = new Scanner(investments);  // Note the layering
            ArrayList<Float> btcgot = new ArrayList<Float>();
            while (scan.hasNextLine()) {
                dataline = scan.nextLine();
                String[] tokens = dataline.split(":");
                btcgot.add(Float.parseFloat(tokens[1])/price);
                System.out.println(tokens[0]+": "+Float.parseFloat(tokens[1])/price);
            }
            scan.close();
        }
        catch (IOException ioex) {
            System.out.println ("Error: " + ioex.getMessage());
        }
        
    }
    static void getCurrentValue(float price) {

        try {
            String dataline = "";
            File investments = new File("clientBC.txt");
            Scanner scan = new Scanner(investments);
            while (scan.hasNextLine()) {
                dataline = scan.nextLine();
                String[] tokens = dataline.split(":");
                System.out.println(tokens[0]+": "+Float.parseFloat(tokens[1]));
                System.out.println(tokens[0]+": "+price);
                System.out.println(tokens[0]+": "+Float.parseFloat(tokens[1])*price);
            }
            scan.close();
        }
        catch (IOException ioex) {
            System.out.println ("Error: " + ioex.getMessage());
        }
    }


    
    public static void main(String[] Args){
        int choice = 0;
        while(choice != 4){
            System.out.println("Current Bitcoin Price: "+getDollarPrice(getData()));
            System.out.println("1. Buy Bitcoin\n2. See everyones current value in USD\n3. See one persons gain/loss\n4. Quit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    buyBitcoin(getDollarPrice(getData()));
                    break;
                case 2:
                    getCurrentValue(getDollarPrice(getData()));
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
}
