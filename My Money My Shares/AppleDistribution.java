import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppleDistribution
{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> appleWeights = new ArrayList<>();
            System.out.println("Enter apple weight in grams (-1 to stop):");
            while (true) {
                int weight = scanner.nextInt();
                if (weight == -1)
                {
                    break;
                }
                appleWeights.add(weight);
            }

            // Define the amount paid by each person
            int totalAmount = 100;
            int ramShare = 50;
            int shamShare = 30;
            int rahimShare = 20;

            // Calculate the expected share for each person
            double ramExpectedShare = (ramShare / (double) totalAmount) * appleWeights.stream().mapToInt(Integer::intValue).sum();
            double shamExpectedShare = (shamShare / (double) totalAmount) * appleWeights.stream().mapToInt(Integer::intValue).sum();
            double rahimExpectedShare = (rahimShare / (double) totalAmount) * appleWeights.stream().mapToInt(Integer::intValue).sum();

            List<Integer> ramApples = new ArrayList<>();
            List<Integer> shamApples = new ArrayList<>();
            List<Integer> rahimApples = new ArrayList<>();

            // Distribute the apples
            for (int weight : appleWeights)
            {
                if (ramExpectedShare > 0)
                {
                    ramApples.add(weight);
                    ramExpectedShare -= weight;
                } else if (shamExpectedShare > 0)
                {
                    shamApples.add(weight);
                    shamExpectedShare -= weight;
                }
                else
                {
                    rahimApples.add(weight);
                    rahimExpectedShare -= weight;
                }
            }

            // distribution result
            System.out.println("Distribution Result:");
            System.out.println("Ram: " + ramApples);
            System.out.println("Sham: " + shamApples);
            System.out.println("Rahim: " + rahimApples);


        }
}


