package finaltest;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class main {
  
	 public static String fourLengthName(String inputFile, int wordLength) throws Exception {
		  String name = Files.lines(Paths.get(inputFile)).filter(s -> s.length() == wordLength).findFirst().orElse(null);
	  
    return name;
  }
  
  public static String vName(String inputFile) throws Exception {
	  String name = Files.lines(Paths.get(inputFile)).filter(s -> s.contains("v")).findFirst().orElse(null);
	  
    return name;
  }
  
  public static String allUpperCase(String inputFile) throws Exception {
	  String name = Files.lines(Paths.get(inputFile)).map(s -> s.toUpperCase()).findFirst().orElse(null);
	 
    return name;
  }
  
  public static String longestName(String inputFile) throws Exception {
	  String name = Files.lines(Paths.get(inputFile)).max(Comparator.comparingInt(String::length)).orElse(null);
	 
    return name;
  }
  
  public static String shortestNameWithoutY(String inputFile, String letter) throws Exception {
	  String name = Files.lines(Paths.get(inputFile)).filter(s -> !s.contains("y")).min(Comparator.comparingInt(String::length)).orElse(null);
	  
    return name;
  }
  
  public static void storeNewAscendingly(String inputFile, String outputFile) throws Exception {
	  List<String> list = Files.lines(Paths.get(inputFile)).sorted().collect(Collectors.toList());
	  Files.write(Paths.get(outputFile), list);
  }
  
  public static void storeNewAscendingUppercase(String inputFile, String outputFile) throws Exception {
	  List<String> list = Files.lines(Paths.get(inputFile)).map(s -> s.toUpperCase()).sorted().collect(Collectors.toList());
	  Files.write(Paths.get(outputFile), list);
  }
 
  private main() {}
}
