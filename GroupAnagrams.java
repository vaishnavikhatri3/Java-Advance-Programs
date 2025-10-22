import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] words) {
        // HashMap to group anagrams together
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            // Sort characters of the word to use as a key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            // Add to map
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of words:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] words = new String[n];
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        List<List<String>> result = groupAnagrams(words);

        System.out.println("\nGrouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }

        sc.close();
    }
}
