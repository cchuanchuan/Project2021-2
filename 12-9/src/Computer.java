public abstract class Computer {
    protected String userName;
    protected String companyName;
    protected String os;
    protected double price;

    public abstract double findFinalPrice();
    public abstract void printDetailsOfComputer();

    public Computer(String userName) {
        this.userName = userName;
    }

//    public Computer(String companyName, String os, double price) {
//        this.companyName = companyName;
//        this.os = os;
//        this.price = price;
//    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
