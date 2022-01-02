package tc836;
import tc836.StockItemConsumption;

public class Main {
    public static void main(String[] args) throws InterruptedException {

         String usernameS = "PCYIPD01";
         String passwordS = "egy123";
         String encounterId ="DEFAULT";

         StockItemConsumption SIC = new StockItemConsumption();
         SIC.openURL();
         SIC.Stock_Item_Consumption(usernameS, passwordS, encounterId);
}}