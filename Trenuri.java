import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Trenuri {
	static Map<String, List<String>> graph = new HashMap<>();
	static Map<String, Integer> distances = new HashMap<>();
	static Set<String> visited = new HashSet<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("trenuri.in"));
			PrintWriter writer = new PrintWriter(new File("trenuri.out"))) {

			// reading the starting city, destination city and routes
			String startCity = sc.next();
			String destinationCity = sc.next();
			int m = sc.nextInt();

			// reading all routes and building the graph
			for (int i = 0; i < m; i++) {
				String city1 = sc.next();
				String city2 = sc.next();
				graph.computeIfAbsent(city1, k -> new ArrayList<>()).add(city2);
			}

			// calculating the maximum number of distinct cities that can be visited using a
			// helper function
			int maxDistinctCities = dfsHelper(startCity, destinationCity);
			writer.println(maxDistinctCities);

			// writing the result to the output file
			writer.println(distances);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int dfsHelper(String currentRoad, String finishRoad) {

		// if the current road is the same as the finish road, add 1 to the counter of distances
		if (currentRoad.equals(finishRoad)) {
			return 1;
		}

		// if already calculated, return the stored value
		if (distances.containsKey(currentRoad)) {
			return distances.get(currentRoad);
		}

		// if not, calculate the maximum number of distinct cities that can be visited
		int distinctCities = 0;
		// get the neighbors of the current road
		List<String> neighbors = graph.getOrDefault(currentRoad, new ArrayList<>());

		// for each neighbor check it's not visited, visit it and calculate the maximum distabce
		for (String neighbor : neighbors) {
			if (!visited.contains(neighbor)) {
				visited.add(neighbor);
				// call the helper function
				distinctCities = Math.max(distinctCities, dfsHelper(neighbor, finishRoad));
				visited.remove(neighbor);
			}
		}

		// increment the counter if a path exists
		if (distinctCities > 0) {
			distinctCities++;
		}
		// store the result in the distances map
		distances.put(currentRoad, distinctCities);
		return distinctCities;
	}
}
