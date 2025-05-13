public class Vehicle extends Asset {

    private String makeModel;
    private int year, odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue(){

        year = getYear();
        odometer = getOdometer();
        makeModel = getMakeModel();

        double cost = getOriginalCost();
        int age = 2025-year;

        if (age <= 3)
            cost -= (cost)*(.03*age);
        if (age>=4 && age <= 6)
            cost -= (cost)*(.06*age);
        if (age>=7 && age <= 10)
            cost -= (cost)*(.08*age);
        if (age > 10)
            cost = 1000;
        if (odometer > 100000 && (!makeModel.contains("Honda") && !makeModel.contains("Toyota")))
            cost *= .75;

        return cost;
    }

}
