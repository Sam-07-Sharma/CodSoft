import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter From Currency (USD, EUR): ");
            String from = sc.next().toUpperCase();

            System.out.print("Enter To Currency (INR, GBP): ");
            String to = sc.next().toUpperCase();

            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();

            String strUrl = "https://api.exchangerate-api.com/v4/latest/" + from;
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                System.out.println("Error: connection failed");
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();

                int index = inline.indexOf("\"" + to + "\":");
                
                if (index != -1) {
                    int start = index + to.length() + 3; // skip "TO":
                    int end = inline.indexOf(",", start);
                    
                    if (end == -1) {
                        end = inline.indexOf("}", start);
                    }

                    String rateStr = inline.substring(start, end);
                    double rate = Double.parseDouble(rateStr);
                    double result = amt * rate;

                    System.out.println("Exchange Rate: " + rate);
                    System.out.println("Converted Amount: " + result);
                } else {
                    System.out.println("Currency not found");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}