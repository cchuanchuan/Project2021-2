public class Desktop extends Computer{

    private double taxRate;
    private String headPhoneCompany;

    public Desktop(String userName,String companyName, String os, double price, double taxRate, String headPhoneCompany) {
        super(userName);
        this.taxRate = taxRate;
        this.headPhoneCompany = headPhoneCompany;
        this.companyName = companyName;
        this.os = os;
        this.price = price;
    }

    @Override
    public double findFinalPrice() {
        return getPrice()*(1+taxRate);
    }

    @Override
    public void printDetailsOfComputer() {
        System.out.println(userName + " has one "+ companyName + " " +this.getClass().getSimpleName()+
                " with " + os + "OS, uses" + headPhoneCompany + " headphone. Price: " + findFinalPrice());
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getHeadPhoneCompany() {
        return headPhoneCompany;
    }

    public void setHeadPhoneCompany(String headPhoneCompany) {
        this.headPhoneCompany = headPhoneCompany;
    }
}
