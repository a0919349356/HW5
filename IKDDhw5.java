import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class IKDDhw5
{
	public static void main(String[] args) throws IOException
	{
		String csvFile = "data\\test.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		br = new BufferedReader(new FileReader(csvFile));
		FileWriter fw = new FileWriter("data\\predict1.csv",false);
		fw.write("PassengerId,Survived\r\n");
		line = br.readLine();
		while ((line = br.readLine()) != null) {
			String[] data = line.split(cvsSplitBy);
			fw.write(data[0]+",");
			double age;
			int parch = Integer.parseInt(data[7]);
			double pclass = Double.parseDouble(data[1]);
			double SIBSP = Double.parseDouble(data[6]);
			double s;
			if(data[4].equals("female")) s = 0;
			else s = 1;
			if(data[5].equals("")) age = 30.0;
			else age = Double.parseDouble(data[5]);
			if( age <= 10) age = 0;
			else if( age > 10 && age <= 30) age = 1;
			else if( age > 30) age = 2;
			double M = 4.7905 + pclass*(-1.101) + age*(-0.7365) + SIBSP*(-0.3584) + s*(-2.6210);
			double P = Math.exp(M) / (1+Math.exp(M));
			System.out.println(P);
			if(P > 0.65)
				fw.write("1\r\n");
			else
				fw.write("0\r\n");
				
		}
		fw.close();
	}

}
