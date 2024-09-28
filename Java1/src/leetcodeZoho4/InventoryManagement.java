package leetcodeZoho4;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InventoryManagement {
    public static void main(String[] args) {

        sy
        Helper04 helper = new Helper04();
        Solution solution = new Solution();
        solution.init(helper);

        // Create products
        solution.createProduct("product-0", "product-name-0", 260.0);

        // Create sellers
        solution.createSeller("seller-0", Arrays.asList("110001", "560092", "452001", "700001"),
                Arrays.asList("netbanking", "cash", "upi"));
        solution.createSeller("seller-1", Arrays.asList("400050", "110001", "600032", "560092"),
                Arrays.asList("netbanking", "cash", "upi"));

        // Add inventory
        System.out.println(solution.addInventory("product-0", "seller-1", 52)); // Should return "inventory added"
        System.out.println(solution.addInventory("product-0", "seller-0", 32)); // Should return "inventory added"

        // Create orders
        System.out.println(solution.createOrder("order-1", "400050", "seller-1", "product-0", 5, "upi")); // Should return "order placed"
        System.out.println(solution.getInventory("product-0", "seller-1")); // Should return 47
        System.out.println(solution.createOrder("order-2", "560092", "seller-0", "product-0", 1, "upi")); // Should return "order placed"
        System.out.println(solution.getInventory("product-0", "seller-0")); // Should return 31

        // Get sellers
        System.out.println(solution.getSellers("product-0", 26, "110001", "upi")); // Should return [seller-0, seller-1]
        System.out.println(solution.getSellers("product-0", 26, "600032", "upi")); // Should return [seller-1]
        System.out.println(solution.getSellers("product-0", 42, "452001", "upi")); // Should return []
        System.out.println(solution.getSellers("product-0", 26, "560092", "upi")); // Should return [seller-0, seller-1]
        System.out.println(solution.getSellers("product-0", 42, "110001", "upi")); // Should return [seller-1]
    }
}



class Solution implements Q04EcommerceOrdersInterface {
     private Helper04 helper;
     private SellerManager sellerManager = new SellerManager();
     private ProductManager productManager = new ProductManager();
     private InventoryManager inventoryManager = new InventoryManager();
     
    public Solution(){}

    public void init(Helper04 helper){
        this.helper=helper;
        // helper.println("Ecommerce orders module initialized");
    }

    // paymentModes:  cash, upi, netbanking, debit card and credit card
    public void createSeller(String sellerId,
        List<String> serviceablePincodes, List<String> paymentModes) {
        sellerManager.createSeller(sellerId, serviceablePincodes, paymentModes);
    }

    public void createProduct(String productId, String name, double price) {
        productManager.createProduct(productId, name, price);
    }

    // returns "inventory added", "product doesn't exist", "seller doesn't exist"
    public String addInventory(String productId, String sellerId, int delta) {
        if(sellerManager.getSeller(sellerId)==null) return "seller doesn't exist";
        if(productManager.getProduct(productId)==null) return "product doesn't exist";
        return inventoryManager.addInventory(productId, sellerId, delta);
    }

    public int getInventory(String productId, String sellerId) {
        return inventoryManager.getInventory(productId, sellerId);
    }

    // returns list of sellers sorted in ascending order of sellerId
    public List<String> getSellers(String productId, int itemCount,
                                   String destinationPincode,  String paymentType) {
        ArrayList<String> sellers = inventoryManager.getSellers(
                productId, itemCount, destinationPincode, paymentType, sellerManager);
        sellers.sort(Comparator.naturalOrder());
        return sellers;
    }

    // creates order and reduces inventory by productCount
    public String createOrder(String orderId, String destinationPincode,
       String sellerId, String productId, int productCount, String paymentMode) {
        Product product = productManager.getProduct(productId);
        if(product==null) return "product doesn't exist";
        Seller seller = sellerManager.getSeller(sellerId);
        if(seller==null) return "seller doesn't exist";
        if(!seller.servesPincode(destinationPincode))
            return "pincode unserviceable";
        if(!seller.supportsPaymentType(paymentMode))
            return "payment mode not supported";
        boolean reduced = inventoryManager.reduceInventory(
                productId, sellerId, productCount);
        return reduced ? "order placed": "insufficient product inventory";
    }

}

class Seller {
    private HashSet<String> serviceablePincodes = new HashSet<>();
    private HashSet<String> sellerPaymentModes = new HashSet<>();

    Seller(List<String> serviceablePincodes, List<String> sellerPaymentModes){
        this.serviceablePincodes.addAll(serviceablePincodes);
        this.sellerPaymentModes.addAll(sellerPaymentModes);
    }

    boolean servesPincode(String pincode){
        return pincode!=null && serviceablePincodes.contains(pincode);

    }

    boolean supportsPaymentType(String paymentType){
        return paymentType!=null && sellerPaymentModes.contains(paymentType);
    }
}

class SellerManager{
    // sellerId vs serviceable pincodes
    ConcurrentHashMap<String, Seller> sellers = new ConcurrentHashMap<>();

    public void createSeller(String sellerId,
                             List<String> serviceablePincodes, List<String> paymentModes) {
        sellers.put(sellerId, new Seller(serviceablePincodes, paymentModes));
    }

    public Seller getSeller(String sellerId){
        return sellers.get(sellerId);
    }
}

class Product {
    private String productId, name;
    private double price;

    Product(String productId, String name, double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }
}

class ProductManager {
    ConcurrentHashMap<String, Product> products = new ConcurrentHashMap<>();

    public void createProduct(String productId, String name, double price) {
        products.put(productId, new Product(productId, name, price));
    }

    public Product getProduct(String productId){
        if(productId==null) return null;
        return products.get(productId);
    }

}

class InventoryManager{

    // productId vs sellerId vs productCount
    ConcurrentHashMap<String,
            ConcurrentHashMap<String, AtomicInteger>> productInventory
            = new ConcurrentHashMap<>();


    // returns "inventory added", "product doesn't exist"
    public String addInventory(String productId, String sellerId, int delta) {
       AtomicInteger inventory = getInventoryInternal(
               productId, sellerId, true);
       inventory.addAndGet(delta);
        return "inventory added";
    }


    public Boolean reduceInventory(String productId, String sellerId, int delta) {
        AtomicInteger existingInventory = getInventoryInternal(
                productId, sellerId, false);
        if(existingInventory==null) return false;
        while (true) {
            int currentValue = existingInventory.get();
            if (currentValue <delta) break;
            if(existingInventory.compareAndSet(
                    currentValue, currentValue - delta))
                return true;
        }
        return false;
    }


    public int getInventory(String productId, String sellerId){
        AtomicInteger inventory = getInventoryInternal(
                productId, sellerId, false);
        return inventory==null?0:inventory.get();
    }


    private AtomicInteger getInventoryInternal(String productId,
                   String sellerId, boolean initialize){
        if(initialize) productInventory.putIfAbsent(
                productId, new ConcurrentHashMap<>());
        ConcurrentHashMap<String, AtomicInteger> allSellersInventory =
                productInventory.get(productId);
        if(allSellersInventory==null) return null;
        if(initialize) allSellersInventory.putIfAbsent(
                sellerId, new AtomicInteger(0));
        return allSellersInventory.get(sellerId);
    }


    // return all sellers who have product with enough inventory to satisfy the order
    ArrayList<String> getSellers(String productId, int itemCount,
                                 String destinationPincode, String paymentType,
                                 SellerManager sellerManager){

        ArrayList<String> sellers = new ArrayList<>();
        ConcurrentHashMap<String, AtomicInteger> map = productInventory.get(productId);
        if(map==null) return sellers;

        for(String sellerId: map.keySet()){
            Seller seller = sellerManager.getSeller(sellerId);
            if(seller==null || !seller.servesPincode(destinationPincode)
                    || !seller.supportsPaymentType(paymentType)) continue;
            if(map.getOrDefault(sellerId,
                    new AtomicInteger(-1)).get()>=itemCount)
                sellers.add(sellerId);
        }

        return sellers;
    }

}

interface Q04EcommerceOrdersInterface {
    public void init(Helper04 helper);

    // payment modes : cash, upi, netbanking, debit card, credit card
    void createSeller(String sellerId, List<String> serviceablePincodes, List<String> paymentModes);

    void createProduct(String productId, String name, double price);

    // "inventory added", "product doesn't exists", "seller doesn't exists"
    String addInventory(String productId, String sellerId, int delta);

    int getInventory(String productId, String sellerId);

    // "order placed", "pincode unserviceable", "insufficient product inventory", "payment mode not supported"
    String createOrder(String orderId, String destinationPincode, String sellerId, String productId,
                    int productCount, String paymentMode);

  List<String> getSellers(String productId, int itemCount, String destinationPincode, String paymentMode);
}

class Helper04 {
    void print(String s){System.out.print(s);}
    void println(String s){System.out.println(s);}
}