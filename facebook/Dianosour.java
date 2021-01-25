import java.util.*;
import java.io.*;

/**

You will be supplied with two data files in CSV format .
The first file contains statistics about various dinosaurs. The second file contains additional data.
Given the following formula, speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
Where g = 9.8 m/s^2 (gravitational constant)

Write a program to read in the data files from disk, it must then print the names of only the bipedal dinosaurs from fastest to slowest.
Do not print any other information.

$ cat dataset1.csv
NAME,LEG_LENGTH,DIET
Hadrosaurus,1.4,herbivore
Struthiomimus,0.72,omnivore
Velociraptor,1.8,carnivore
Triceratops,0.47,herbivore
Euoplocephalus,2.6,herbivore
Stegosaurus,1.50,herbivore
Tyrannosaurus Rex,6.5,carnivore

$ cat dataset2.csv 
NAME,STRIDE_LENGTH,STANCE
Euoplocephalus,1.97,quadrupedal
Stegosaurus,1.70,quadrupedal
Tyrannosaurus Rex,4.76,bipedal
Hadrosaurus,1.3,bipedal
Deinonychus,1.11,bipedal
Struthiomimus,1.24,bipedal
Velociraptorr,2.62,bipedal

**/


public class Dianosour {
	public static void main(String args[]) throws IOException {
		BufferedReader f1 = new BufferedReader(new FileReader("f1.csv"));
		BufferedReader f2 = new BufferedReader(new FileReader("f2.csv"));

		Map<String, Float> strideLengths = new HashMap<>();
		String line = f2.readLine(); // skip the header row in the csv
		line = f2.readLine();
		while( line !=null){
			String tokens[] = line.split(",");
			if("bipedal".equals(tokens[2])){
				strideLengths.put(tokens[0], Float.parseFloat(tokens[1]));
			}
			line = f2.readLine();
		}

		Map<Float, String> output = new TreeMap<Float, String>(Comparator.reverseOrder());
		line = f1.readLine(); // skip the header row in the csv
		line = f1.readLine();

		while( line !=null){
			String[] tokens = line.split(",");
			String name = tokens[0];
			if (strideLengths.containsKey(name)) {
				float stride = strideLengths.get(name);
				float leg = Float.parseFloat(tokens[1]);
				float speed = (float) (((stride / leg) - 1) * Math.sqrt(leg * 9.8));
				output.put(speed, name);
			}
			line = f1.readLine();
		}
		for (Float f : output.keySet()) {
			System.out.println(output.get(f));
		}

	}
}
