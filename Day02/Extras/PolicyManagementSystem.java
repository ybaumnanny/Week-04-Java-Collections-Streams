import java.time.LocalDate;
import java.util.*; 
import java.util.stream.Collectors;
class Policy {
    private final String policyNumber;
    private final String policyholderName;
    private final LocalDate expiryDate;
    private final double premium;
    private final String type;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                  double premium, String type) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.premium = premium;
        this.type = type;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public double getPremium() { return premium; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("Policy[%s, Holder: %s, Expires: %s, Premium: %.2f, Type: %s]",
                policyNumber, policyholderName, expiryDate.toString(), premium, type);
    }
}

class PolicyManagementSystem {
    // Store policies with policy number as key
    private final Map<String, Policy> policyMap;
    
    // Store policies in insertion order
    private final LinkedHashMap<String, Policy> policyLinkedMap;
    
    // Store policies sorted by expiry date
    private final TreeMap<LocalDate, List<Policy>> policyExpiryMap;

    public PolicyManagementSystem() {
        this.policyMap = new HashMap<>();
        this.policyLinkedMap = new LinkedHashMap<>();
        this.policyExpiryMap = new TreeMap<>();
    }

    // Add a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        policyLinkedMap.put(policy.getPolicyNumber(), policy);
        
        policyExpiryMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>())
                       .add(policy);
    }

    // Retrieve policy by number
    public Optional<Policy> getPolicyByNumber(String policyNumber) {
        return Optional.ofNullable(policyMap.get(policyNumber));
    }

    // List policies expiring within next 30 days
    public List<Policy> getPoliciesExpiringInNext30Days() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        return policyExpiryMap.subMap(today, true, thirtyDaysLater, true)
                             .values()
                             .stream()
                             .flatMap(List::stream)
                             .collect(Collectors.toList());
    }

    // List policies by policyholder
    public List<Policy> getPoliciesByHolder(String policyholderName) {
        return policyMap.values()
                       .stream()
                       .filter(p -> p.getPolicyholderName().equalsIgnoreCase(policyholderName))
                       .collect(Collectors.toList());
    }

    // Remove expired policies safely
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        
        // Get expired policies
        List<LocalDate> expiredDates = new ArrayList<>(policyExpiryMap.headMap(today, false).keySet());

        for (LocalDate date : expiredDates) {
            List<Policy> expiredPolicies = policyExpiryMap.remove(date);
            if (expiredPolicies != null) {
                for (Policy policy : expiredPolicies) {
                    policyMap.remove(policy.getPolicyNumber());
                    policyLinkedMap.remove(policy.getPolicyNumber());
                }
            }
        }
    }

    // Get all policies in insertion order
    public List<Policy> getAllPoliciesInInsertionOrder() {
        return new ArrayList<>(policyLinkedMap.values());
    }

    // Get all policies sorted by expiry date
    public List<Policy> getAllPoliciesSortedByExpiryDate() {
        return policyExpiryMap.values()
                             .stream()
                             .flatMap(List::stream)
                             .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();

        // Add sample policies
        system.addPolicy(new Policy("P001", "Yaman Mahtha", 
            LocalDate.now().plusDays(15), 1000.0, "Health"));
        system.addPolicy(new Policy("P002", "Pollard", 
            LocalDate.now().plusDays(45), 2000.0, "Auto"));
        system.addPolicy(new Policy("P003", "Yaman Mahtha", 
            LocalDate.now().plusDays(25), 1500.0, "Life"));

        // Retrieve policy by number
        System.out.println("Policy P001: " +  
            system.getPolicyByNumber("P001").orElse(null));

        // Get policies expiring in next 30 days
        System.out.println("\nPolicies expiring in next 30 days:");
        system.getPoliciesExpiringInNext30Days()
              .forEach(System.out::println);

        // Get policies by holder
        System.out.println("\nPolicies for Yaman Mahtha:");
        system.getPoliciesByHolder("Yaman Mahtha")
              .forEach(System.out::println);

        // Remove expired policies
        system.removeExpiredPolicies();

        // Get all policies in insertion order
        System.out.println("\nAll policies in insertion order:");
        system.getAllPoliciesInInsertionOrder()
              .forEach(System.out::println);
    }
}
