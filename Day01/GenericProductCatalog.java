import java.util.ArrayList;
import java.util.List;
abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }
}

class Gadget extends Product {
    public Gadget(String name, double price) {
        super(name, price);
    }
}
// Generic class
class ProductCatalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void displayCatalog() {
        System.out.println("Product Catalog:");
        for (T product : products) {
            System.out.println(product);
        }
    }
    // Generic method for discount
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * (percentage / 100));
        product.setPrice(discountedPrice);
        System.out.println("Discount applied! New price of " + product.getName() + ": $" + discountedPrice);
    }
}
// Main class to test functionality
public class GenericProductCatalog {
    public static void main(String[] args) {
        // Creating catalogs for different product types
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        // Adding products
        Book book1 = new Book("Java Programming", 50);
        Clothing cloth1 = new Clothing("T-Shirt", 20);
        Gadget gadget1 = new Gadget("Smart Watch", 150);

        bookCatalog.addProduct(book1);
        clothingCatalog.addProduct(cloth1);
        gadgetCatalog.addProduct(gadget1);

        // Displaying catalogs
        bookCatalog.displayCatalog();
        clothingCatalog.displayCatalog();
        gadgetCatalog.displayCatalog();

        // Applying discount
        ProductCatalog.applyDiscount(book1, 10);
        ProductCatalog.applyDiscount(cloth1, 20);
        ProductCatalog.applyDiscount(gadget1, 15);

        // Display catalogs after discount
        System.out.println("\nCatalogs after applying discounts:");
        bookCatalog.displayCatalog();
        clothingCatalog.displayCatalog();
        gadgetCatalog.displayCatalog();
    }
}
