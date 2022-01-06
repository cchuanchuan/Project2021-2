public class Store{
    private Computer[]computers;

    // parameterized constructor that accepts a size and create an array of computers with that size
    public Store(int num){
        computers = new Computer[num];

    }

    // createComputers() method that create each computer.... 2 desktops and 2 laptops
    public void createComputers(){
        // Create Desktop - company: HP, price: 1499, OS: Windows 10, headphone company: Beats
        Desktop desktop1 = new Desktop("thomasa","HP","Windows 10",1499,(1693.87/1499)-1,"Beats");
        //  Create Laptop - company: Asus, price: 1200, OS: Windows 10,  color: Blue
        Laptop laptop1 = new Laptop("thomasa","Asus","Windows 10",1200,1.0-(960.0/1200),"Blue");
        // Create Desktop - company: Acer, price: 950, OS: Windows 8, headphone company: Jabra
        Desktop desktop2 = new Desktop("thomasa","Acer","Windows 8",950,(1073.5/950)-1,"Jabra");
        // Create Laptop - company: Apple, price: 1350, OS: MacOS, color: Silver
        Laptop laptop2 = new Laptop("thomasa","Apple","MacOS",1350,1.0-(1080.0/1350),"Silver");


        computers[0] = desktop1;
        computers[1] = laptop1;
        computers[2] = desktop2;
        computers[3] = laptop2;
    }

    //  processDetails() uses a for loop to iterate through each computer, calculate and prints the details with the final price.
    public void processDetails(){

        for (Computer c :
                computers) {
            c.printDetailsOfComputer();
        }
    }
}