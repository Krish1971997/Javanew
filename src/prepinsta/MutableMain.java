package prepinsta;


public class MutableMain {
	public static void main(String[] args) {
        Address address = new Address("123 Main St", "New York");
        ImmutablePerson person = new ImmutablePerson("John", 30, address);

        System.out.println(person.getName());  // Output: John
        System.out.println(person.getAge());   // Output: 30
        System.out.println(person.getAddress().getStreet()); // Output: 123 Main St

        // Trying to modify the address
        person.getAddress().setStreet("456 Park Ave");
        System.out.println(person.getAddress().getStreet()); // Still "123 Main St"
    }
}

final class ImmutablePerson {
    // Step 2: Declare fields as private and final
    private final String name;
    private final int age;
    private final Address address; // A mutable object (special handling required)

    // Step 3: Initialize fields through constructor
    public ImmutablePerson(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        // Step 5: Store a deep copy to prevent external modification
        this.address = new Address(address.getStreet(), address.getCity());
    }

    // Step 4: Provide only getters, no setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Step 5: Return a deep copy of mutable objects
    public Address getAddress() {
        return new Address(address.getStreet(), address.getCity());
    }
}

// Supporting class for Address (Mutable)
class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {  // Mutable method
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {  // Mutable method
        this.city = city;
    }
}