public class LongestCommonPrefix {

    public static void main(String[] args) {
        // Example arrays of strings
        String[] strings = {"flower", "flow", "flight"};
        String[] strings1 = {"dog", "flow", "kite"};

        // Create an instance of the LongestCommonPrefix class
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        // Find the longest common prefix for the first set of strings
        String result = longestCommonPrefix.longestCommonPrefix(strings);

        // Find the longest common prefix for the second set of strings
        String result1 = longestCommonPrefix.longestCommonPrefix(strings1);

        // Print the results
        System.out.println(result);
        System.out.println(result1);
    }


    public String longestCommonPrefix(String[] str) {
        // If the array is empty, return ""
        if (str.length == 0) return "";

        // Initialize the prefix with the first string element
        String prefix = str[0];

        // Iterate through the array of strings
        for (int i = 1; i < str.length; i++) {
            // While the current string does not start with the prefix, reduce the prefix
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        // Return the longest common prefix
        return prefix;
    }
}
