package exercici4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

public class LlegirFitxerTXT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LlegirFitxerTXT.LlegirTXT("/home/xback31/Music/progetti_eclipse/S01T05N01BasilicataPaolo/src/contingut.txt");
	}
	
	
	
	public static void LlegirTXT(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			Stream lines = br.lines();
			Iterator<String> it = lines.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			br.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
