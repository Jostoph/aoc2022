import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rucksack {
    private final Set<Character> compartment1;
    private final Set<Character> compartment2;

    private final char commonItem;

    public Rucksack(String rawContent) {
        List<Character> items = Arrays.stream(rawContent.chars().mapToObj(c -> (char)c).toArray(Character[]::new)).toList();

        this.compartment1 = new HashSet<>(items.subList(0, items.size() / 2));
        this.compartment2 = new HashSet<>(items.subList(items.size() / 2, items.size()));

        Set<Character> inter = new HashSet<>(this.compartment1);
        inter.retainAll(this.compartment2);
        this.commonItem = inter.toArray(Character[]::new)[0];
    }

    public static int getItemPriority(Character item) {
        if (Character.isUpperCase(item)) {
            return item - 38; // - 64 + 26
        }
        return item - 96;
    }

    public int getCommonItemPriority() {
        return getItemPriority(this.commonItem);
    }

    public Set<Character> getAllItems() {
        Set<Character> sum = new HashSet<>(this.compartment1);
        sum.addAll(compartment2);
        return sum;
    }

    @Override
    public String toString() {
        return "\nCompartment 1: " +
                compartment1 +
                "\nCompartment 2: " + compartment2 +
                "\nCommon Item: " + commonItem + " (" + this.getCommonItemPriority() + ")\n";
    }
}
