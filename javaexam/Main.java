import java.util.Date;
import java.util.ArrayList;
import java.util.List;

// Enum representing the state of a user
enum UserState {
    NEW, ACTIVE, BLOCKED, BANNED
}

// Represents a web user
class WebUser {
    private String id;
    private String password;
    private UserState state;

    public WebUser(String id, String password, UserState state) {
        this.id = id;
        this.password = password;
        this.state = state;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserState getState() {
        return state;
    }
}

// Represents a customer
class Customer {
    private String id;
    private Address address;
    private String phone;
    private String email;

    public Customer(String id, Address address, String phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

// Represents an address
class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}

// Represents a phone number
class Phone {
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    // Getter
    public String getNumber() {
        return number;
    }
}

// Represents an account
class Account {
    private String id;
    private Address billingAddress;
    private boolean isClosed;
    private Date open;
    private Date closed;

    public Account(String id, Address billingAddress, boolean isClosed, Date open, Date closed) {
        this.id = id;
        this.billingAddress = billingAddress;
        this.isClosed = isClosed;
        this.open = open;
        this.closed = closed;
    }

    // Getters
    public String getId() {
        return id;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public Date getOpen() {
        return open;
    }

    public Date getClosed() {
        return closed;
    }
}

// Represents a payment
class Payment {
    private String id;
    private String paid;
    private double total;
    private String details;

    public Payment(String id, String paid, double total, String details) {
        this.id = id;
        this.paid=paid;
        this.total = total;
        this.details = details;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPaid() {
        return paid;
    }

    public double getTotal() {
        return total;
    }

    public String getDetails() {
        return details;
    }
}

// Represents a shopping cart
class ShoppingCart {
    private Date created;
    private List<LineItem> items;

    public ShoppingCart(Date created) {
        this.created = created;
        this.items = new ArrayList<>();
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    public void removeItem(LineItem item) {
        items.remove(item);
    }

    // Other methods such as viewCart(), calculateTotal(), etc.
}

// Represents an order
class Order {
    private String id;
    private Date ordered;
    private Date shipped;
    private Address shipTo;
    private OrderStatus status;
    private double total;
    private List<LineItem> items;

    public Order(String id, Date ordered, Address shipTo, OrderStatus status, double total) {
        this.id = id;
        this.ordered = ordered;
        this.shipTo = shipTo;
        this.status = status;
        this.total = total;
        this.items = new ArrayList<>();
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    public void removeItem(LineItem item) {
        items.remove(item);
    }

    // Other methods such as updateStatus(), viewOrderDetails(), etc.
}

// Represents a line item in an order or shopping cart
class LineItem {
    private int quantity;
    private double price;
    private Product product;

    public LineItem(int quantity, double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    // Getters
    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }
}

// Represents a product
class Product {
    private String id;
    private String name;
    private Supplier supplier;

    public Product(String id, String name, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}

// Represents a supplier
class Supplier {
    private String name;
    // Other supplier details can be added as needed

    public Supplier(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }
}

// Enum representing the status of an order
enum OrderStatus {
    NEW, HOLD, SHIPPED, DELIVERED, CLOSED
}
public class Main {

    public static void main(String[] args) {
              
        Address billingAddress = new Address("123 Main St", "Anytown", "State", "12345");
        Address shipTo = new Address("456 Elm St", "Othertown", "State", "67890");
        Product product = new Product("1", "Product Name", new Supplier("Supplier Name"));

        ShoppingCart cart = new ShoppingCart(new Date());
        cart.addItem(new LineItem(2, 29.99, product));

        Order order = new Order("123", new Date(), shipTo, OrderStatus.NEW, 59.98);
        order.addItem(new LineItem(2, 29.99, product));
        Payment payment;
        payment = new Payment("1","05-06-2024" ,59.98,"payment complete");

        System.out.println("Order ID: " + product.getId());
        System.out.println("Total: $" + payment.getTotal());

    }
}

