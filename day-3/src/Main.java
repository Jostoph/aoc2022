public class Main {
    public static void main(String[] args) {
        part2();
    }

    public static void testPart1() {
        Inventory testInventoryPart1 = new Inventory("test_input.txt");
        System.out.println(testInventoryPart1);
        int sumTestPart1 = testInventoryPart1.getCommonItemsPrioritiesSum();
        System.out.println(sumTestPart1);
    }

    public static void part1() {
        Inventory inventoryPart1 = new Inventory("input.txt");
        System.out.println(inventoryPart1);
        int sumPart1 = inventoryPart1.getCommonItemsPrioritiesSum();
        System.out.println(sumPart1);
    }

    public static void testPart2() {
        Inventory testInventoryPart2 = new Inventory("test_input.txt");
        System.out.println(testInventoryPart2);
        int sumTestPart2 = testInventoryPart2.getBadgesPrioritySum();
        System.out.println(sumTestPart2);
    }

    public static void part2() {
        Inventory inventoryPart2 = new Inventory("input.txt");
        System.out.println(inventoryPart2);
        int sumPart2 = inventoryPart2.getBadgesPrioritySum();
        System.out.println(sumPart2);
    }
}