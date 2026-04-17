public class FootballTeamStats {

    public static void main(String[] args) {
        int[] heights = new int[11];
        System.out.println("Generated Player Heights (cms):");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * (250 - 150 + 1)) + 150;
            System.out.print(heights[i] + " ");
        }
        System.out.println("\n---------------------------------");
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        double mean = calculateMean(heights);

        System.out.println("Shortest Player: " + shortest + " cms");
        System.out.println("Tallest Player: " + tallest + " cms");
        System.out.printf("Mean Height of Team: %.2f cms%n", mean);
    }
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int h : arr) {
            sum += h;
        }
        return sum;
    }
    public static double calculateMean(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) findSum(arr) / arr.length;
    }
    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int h : arr) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }
    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int h : arr) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }
}