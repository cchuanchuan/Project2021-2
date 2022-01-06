public class Laptop extends Computer{

    private double offerRate;
    private String color;

    public Laptop(String userName, String companyName, String os, double price, double offerRate, String color) {
        super(userName);
        this.offerRate = offerRate;
        this.color = color;
        this.companyName = companyName;
        this.os = os;
        this.price = price;
    }

    @Override
    public double findFinalPrice() {
        return getPrice()*(1-offerRate);
    }

    @Override
    public void printDetailsOfComputer() {

        System.out.println(userName + " has a "+ color+" colored "+companyName + " " +this.getClass().getSimpleName()+
                " with " + os + ". Price: " + findFinalPrice());

    }

    public double getOfferRate() {
        return offerRate;
    }

    public void setOfferRate(double offerRate) {
        this.offerRate = offerRate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
