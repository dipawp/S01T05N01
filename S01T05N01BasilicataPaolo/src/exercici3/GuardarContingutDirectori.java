package exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exercici2.LlistarDirectoriRecursivament;

public class GuardarContingutDirectori {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File txtContingut = new File("src/contingut.txt");
		if(!txtContingut.exists()) {
			try {
				txtContingut.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No es pot crear el fitxer classificacio.txt");
			}
		}
		GuardarContingutDirectori.llistaContingutTotsElsDirectori("/home/xback31/Documents/",0);
	}
	
	
	public static void llistaContingutTotsElsDirectori(String path, int depth) {
		try {
			File folder = new File(path.toString());
			File[] files = folder.listFiles();
			List<File> llistaFitxers = new ArrayList<File>();
			Comparator<File> comparaAlpha = new Comparator<File>() {

				@Override
				public int compare(File o1, File o2) {
					// TODO Auto-generated method stub
					return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
				}
			};
			
			for(File xxfile:files) {
				llistaFitxers.add(xxfile);
			}
			
			Collections.sort(llistaFitxers,comparaAlpha);
			for(File fitxer : llistaFitxers) {
				if(fitxer.isDirectory()) {
					System.out.println(spacesForDepth(depth) + "| D " + fitxer.getName() + "      " + formatData(fitxer.lastModified()));
					GuardarContingutDirectori.guardarContingut(spacesForDepth(depth) + "| D " + fitxer.getName() + "      " + formatData(fitxer.lastModified()));
					GuardarContingutDirectori.llistaContingutTotsElsDirectori(fitxer.getPath(),depth + 1);
				}
			    else {
			    	System.out.println(spacesForDepth(depth) + "| F " + fitxer.getName() + "      " + formatData(fitxer.lastModified()));
			    	GuardarContingutDirectori.guardarContingut(spacesForDepth(depth) + "| F " + fitxer.getName() + "      " + formatData(fitxer.lastModified()));
			    }
			}
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
        
		
	}
	
	
	
	public static String spacesForDepth(int depth) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i < depth; i++) {
			builder.append("  ");
		}
		return builder.toString();
	}
	
	public static String formatData(Long lastModified) {
		SimpleDateFormat smpDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return smpDate.format(lastModified);
	}
	
	
	
	
	
	public static void guardarContingut(String linia) {
		try {
			FileWriter writer = new FileWriter("src/contingut.txt",true);
			writer.write(linia + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No es possible guardar el resultat");
		}
	}

}
