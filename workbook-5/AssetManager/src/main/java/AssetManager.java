import java.util.ArrayList;

public class AssetManager {

    public static void main(String[] args) {

        ArrayList <Asset> assetList = new ArrayList<>();

        House cottageHouse = new House("Cottage", "1999", 100000, "1234 Address St", 3, 3000, 5000);
        House beachHouse = new House("Beach House", "2023", 150000, "4321 Address Blvd", 1, 5000, 8000);

        Vehicle dailyDriver = new Vehicle("Daily Driver", "2020", 50000, "Toyota", 2010, 100001);
        Vehicle secondDriver = new Vehicle("Daily Driver", "2020", 50000, "Ferrari", 2010, 100001);


        assetList.add(cottageHouse);
        assetList.add(beachHouse);
        assetList.add(dailyDriver);
        assetList.add(secondDriver);

        for (Asset asset : assetList) {

            System.out.println("Description: "+ asset.getDescription());
            System.out.println("Original Cost: "+ asset.getOriginalCost());
            System.out.println("Estimated Value: "+ asset.getValue());
            System.out.println("=".repeat(40));

        }
    }

}
