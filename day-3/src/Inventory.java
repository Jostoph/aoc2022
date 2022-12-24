import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Inventory {

    private final List<Rucksack> rucksacks;
    public Inventory(String inputName) {
        rucksacks = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputName));
            String line = reader.readLine();

            while (line != null && !line.isEmpty()) {
                rucksacks.add(new Rucksack(line));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCommonItemsPrioritiesSum() {
        return rucksacks.stream().map(Rucksack::getCommonItemPriority).reduce(0, Integer::sum);
    }

    public int getBadgesPrioritySum() {
        Set<Character> inter = new HashSet<>();
        int groupIndex = 0;
        int sum = 0;
        for (Rucksack rucksack : rucksacks) {
            if (inter.isEmpty()) {
                inter.addAll(rucksack.getAllItems());
            } else {
                inter.retainAll(rucksack.getAllItems());
            }
            groupIndex++;

            if (groupIndex > 2) {
                sum += Rucksack.getItemPriority(inter.toArray(Character[]::new)[0]);
                inter.clear();
                groupIndex = 0;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "rucksacks=" + rucksacks +
                '}';
    }
}
