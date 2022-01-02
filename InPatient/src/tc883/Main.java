package tc883;

public class Main {
    public static void main(String[] args) throws InterruptedException {

         String usernameS = "NURIPD01";
         String passwordS = "egy123";

         ViewWardOccupancy VWO = new ViewWardOccupancy();
         VWO.openURL();
         VWO.View_Ward_occupancy(usernameS, passwordS);
}
}