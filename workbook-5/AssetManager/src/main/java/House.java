public class House extends Asset {
   private String address;
   private int condition, squareFoot, lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue(){
        lotSize = getLotSize();
        condition = getCondition();
        squareFoot = getSquareFoot();
        double cost = lotSize * .25;

        switch(condition){
            case 1:
                return cost + 180*squareFoot;
            case 2:
                return cost + 130*squareFoot;
            case 3:
                return cost + 90*squareFoot;
            case 4:
                return cost + 80*squareFoot;
        }




        return cost;
    }
}
