package labs.lab10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A class for performing various analyses on a set of airport data
 *
 */
public class AirportsStats {

	/**
	 * Given a Stream of Airports, return the number of airports in the Stream
	 */
	public static long problem1_countAirports(Stream<Airport> airports) {

		return airports.count(); // FIX ME
	}
	
	
	/**
	 * Given a Stream of Airports, return the number of different countries represented in the stream
	 */
	public static long problem2_countCountries(Stream<Airport> airports) {
		Map<String,List<Airport>> map = airports.collect(Collectors.toMap(Airport::getCountry,
				(airport) -> {
					List<Airport> list = new ArrayList<>();
					list.add(airport);
					return list;
				},
				(List<Airport> list,List<Airport> list2) -> {
					list.addAll(list2);
					return list;
				}));

		return map.keySet().size(); // FIX ME
	}
	
	
	/**
	 * Given a Stream of airports, return the airport at the lowest altitude
	 * (use min method of Stream class)
	 */
	public static Optional<Airport> problem3_getAirportAtLowestAltitude(Stream<Airport> airports) {
		Optional<Airport> optionalAirport = airports.min((airport1,airport2) ->{
			if (airport1.getAltitude() == airport2.getAltitude()){
				return 0;
			}else {
				return airport1.getAltitude()-airport2.getAltitude()>0?1:-1;
			}
		});

		return optionalAirport; // FIX ME
	}
	
	
	/**
	 * Given a Stream of Airports and the name of a city, return a list of airports in that 
	 * city, sorted in ascending lexicographic order by airport name
	 */
	public static List<Airport> problem4_getAirportsInCity(Stream<Airport> airports, String city) {
		List<Airport> airportList = airports.filter(airport -> airport.getCity().equals(city)).sorted().collect(Collectors.toList());
		return airportList; // FIX ME
	}
	
	
	/**
	 * Given a Stream of airports, a set of coordinates, and an int numMiles, return a String that 
	 * contains the names of all airports within numMiles from those coordinates, ordered lexicographically,
	 * each name separated by ", "
	 * 
	 * Use the Coordinates.distance method to calculate distance, but remember to convert between miles and meters
	 */
	public static String problem5_getAllAirportsWithinNumMiles(Stream<Airport> airports, Coordinates coordinates, int numMiles) {

		List<Airport> list = airports.filter(airport -> (Coordinates.distance(airport.getCoordinates().latitude,airport.getCoordinates().longitude,
				coordinates.latitude,coordinates.longitude)) < numMiles*1609.344
		).sorted().collect(Collectors.toList());

		String res = "";
		for (Airport a :
				list) {
			res += a.getName()+", ";
		}
		return res.substring(0,res.length()>2?res.length()-2:0); // FIX ME
	}
	
	
	/**
	 * Given a Stream of airports and an integer n, return a list of the names of the top n countries with the most airports,
	 * sorted in descending order by number of airports.
	 * 
	 * If there are < n countries represented in the stream, return them all, sorted in descending order
	 * by number of airports.
	 */
	public static List<String> problem6_getTopNcountriesWithMostAirports(Stream<Airport> airports, int n) {
		Map<String,Long> map = airports.collect(Collectors.groupingBy(Airport::getCountry,Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();

		//Sort a map and add to finalMap
		map.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.limit(n)
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
//
//
//		System.out.println(map);
//		System.out.println(finalMap);

		return new ArrayList<>(finalMap.keySet()); // FIX ME
	}
	
	
	/**
	 * Given a Stream of airports and an airport ID, return the airport closest to the airport
	 * with that ID.
	 * 
	 * Use the Coordinates.distance method to calculate distance between airports, and the Stream.min
	 * method to find the airport with the minimum distance away.
	 * 
	 * If the airport with the given ID is not found, or the stream is empty, return an empty Optional<Airport>
	 * 
	 */
	public static Optional<Airport> problem7_getClosestAirport(Stream<Airport> airports, int airportID) {
		List<Airport> list = airports.collect(Collectors.toList());
		Optional<Airport> airportOptional = list.stream().filter(a -> a.getAirportID() == airportID).findAny();
		if (!airportOptional.isPresent()){
			return Optional.empty();
		}
//		System.out.println(airportOptional.get());
		list.remove(airportOptional.get());

		Optional<Airport> result = list.stream().min(new Comparator<Airport>() {
			@Override
			public int compare(Airport o1, Airport o2) {
				return (int) (Coordinates.distance(o1.getCoordinates().latitude,o1.getCoordinates().longitude,
										airportOptional.get().getCoordinates().latitude,airportOptional.get().getCoordinates().longitude)
										- Coordinates.distance(o2.getCoordinates().latitude,o2.getCoordinates().longitude,
										airportOptional.get().getCoordinates().latitude,airportOptional.get().getCoordinates().longitude));
			}});

		return result; // FIX ME
	}
	
	
	/**
	 * Given a Stream of airports, return a Map<Double, Long> that maps altitudes to the number
	 * of airports at that altitude, but only include in the map altitudes that have at least 2 
	 * airports at that altitude.
	 * 
	 * If the stream is empty, return an empty map.
	 */
	public static Map<Double, Long> problem8_countAirportsByAltitude(Stream<Airport> airports) {
		Map<Double, Long> map = airports.collect(Collectors.groupingBy(Airport::getAltitude,Collectors.counting()));
		Map<Double, Long> finalMap = new LinkedHashMap<>();

		//Sort a map and add to finalMap
		map.entrySet().stream()
				.filter(doubleLongEntry -> doubleLongEntry.getValue()>=2)
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		return finalMap; // FIX ME
	}
	
	
	/**
	 * Given a Stream of airports, return the average number of airports in each country,
	 * or 0 if the stream is empty
	 */
	public static double problem9_averageNumAirportsPerCountry(Stream<Airport> airports) {
		double res = airports.collect(Collectors.groupingBy(Airport::getCountry,Collectors.counting()))
				.values().stream().collect(Collectors.averagingDouble(Long::doubleValue));

		return res; // FIX ME
	}
	
	
	/**
	 * Given a Stream of airports, return the percentage of airport names that contain the name
	 * of the city they are in (case-insensitive). If a city name is blank, consider the airport name 
	 * to NOT contain it. 
	 * 
	 * If the stream is empty, return 0.
	 */
	public static double problem10_percentAirportsWithCityName(Stream<Airport> airports) {
		List<Airport> list = airports.filter(airport ->
				!airport.getName().equals("")).collect(Collectors.toList());
		if (list.size() == 0){
			return 0;
		}
		double has = list.stream().
				filter(airport ->
						!airport.getName().equals("")
								&& (airport.getName().toLowerCase()).contains(airport.getCity().toLowerCase()))
//				&& (" "+airport.getName().toLowerCase()+" ").contains(" "+airport.getCity().toLowerCase()+" "))
				.count();
		return has/list.size()*100; // FIX ME
	}
}