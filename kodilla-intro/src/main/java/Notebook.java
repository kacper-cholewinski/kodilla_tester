public class Notebook {
    int weight;
    int price;
    int year;
    public Notebook(int weight, int price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

    public void checkPrice() {
        if (price < 600) {
            System.out.println("This notebook is cheap");
        } else if (price <= 1000){
            System.out.println("The price is good");
        } else {
            System.out.println("This notebook is expensive");
        }
    }

    public void checkWeight() {
        if (weight < 700) {
            System.out.println("This notebook is light");
        } else if (weight < 1400){
            System.out.println("This notebook is not very heavy");
        } else {
            System.out.println("This notebook is very heavy");
        }
    }

    public void checkPriceAndYear() {
        if (price < 600) {
            System.out.println("This notebook is cheap");
        } else if (price <= 1000){
            System.out.println("The price is good");
        } else if (price < 1600 && year < 2010) {
            System.out.println("This notebook is expensive");
        } else if (price < 1600) {
            System.out.println("This notebook is quite expensive");
        } else {
            System.out.println("This notebook is very expensive");
        }
    }
}
