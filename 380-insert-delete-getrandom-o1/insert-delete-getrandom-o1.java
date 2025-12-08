/**Fastest with  */

class RandomizedSet {

    private HashMap<Integer, Integer> map;      // Maps each value to its index in the list
    private ArrayList<Integer> list;            // Stores all elements for O(1) random access
    private Random rand;                        // Random object for generating random indices

    public RandomizedSet() {
        map = new HashMap<>();                  // Initialize the HashMap
        list = new ArrayList<>();               // Initialize the ArrayList
        rand = new Random();                    // Initialize the Random generator
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false; // If val already exists, return false

        map.put(val, list.size());              // Record index of val in the list
        list.add(val);                          // Add val to end of list
        return true;                            // Successfully inserted
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; // If val doesn't exist, return false

        int index = map.get(val);               // Get the index of val in list
        int lastElement = list.get(list.size() - 1); // Get last element of list

        list.set(index, lastElement);           // Move last element into the removed element's index
        map.put(lastElement, index);            // Update map for the moved element

        list.remove(list.size() - 1);           // Remove last element safely
        map.remove(val);                        // Remove val from the map

        return true;                            // Successfully removed
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size()); // Generate random index within list bounds
        return list.get(randomIndex);                // Return element at that index
    }
}

/** Regular first solution using HashSet only */
// class RandomizedSet {

//     private HashSet<Integer> RandomizedSet;

//     public RandomizedSet() {
//         RandomizedSet = new HashSet<>();
//     }

//     public boolean insert(int val) {
//         return RandomizedSet.add(val);
//     }

//     public boolean remove(int val) {
//         return RandomizedSet.remove(val);

//     }

//     public int getRandom() {

//         int index = new Random().nextInt(RandomizedSet.size());
//         return (int) RandomizedSet.toArray()[index];

//     }
// }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */