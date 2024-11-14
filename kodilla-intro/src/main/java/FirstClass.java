public class FirstClass {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(600, 1000, 2012);
        System.out.println(notebook.weight + " " + notebook.price + " " + notebook.year);
        notebook.checkPrice();
        notebook.checkWeight();
        notebook.checkPriceAndYear();
        Notebook heavyNotebook = new Notebook(2000, 1500, 2008);
        System.out.println(heavyNotebook.weight + " " + heavyNotebook.price + " " + notebook.year);
        heavyNotebook.checkPrice();
        heavyNotebook.checkWeight();
        heavyNotebook.checkPriceAndYear();
        Notebook oldNotebook = new Notebook(1600, 500, 2002);
        System.out.println(oldNotebook.weight + " " + oldNotebook.price + " " + notebook.year);
        oldNotebook.checkPrice();
        oldNotebook.checkWeight();
        oldNotebook.checkPriceAndYear();
        Notebook newNotebook = new Notebook(1200, 1500, 2020);
        System.out.println(oldNotebook.weight + " " + oldNotebook.price + " " + notebook.year);
        newNotebook.checkPrice();
        newNotebook.checkWeight();
        newNotebook.checkPriceAndYear();
    }
}
