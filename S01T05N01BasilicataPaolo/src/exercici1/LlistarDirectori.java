package exercici1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LlistarDirectori {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LlistarDirectori.llistaContingutDirectori("/home/xback31/Documents",0);
		
	}
	
	
	
	public static void llistaContingutDirectori(String path, int depth) {
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
			
			for(File fitxer:files) {
				llistaFitxers.add(fitxer);
			}
			
			Collections.sort(llistaFitxers,comparaAlpha);
			for(File xfile : llistaFitxers) {
				if(xfile.isDirectory()) {
					System.out.println(xfile.getName());
				}
			    else {
			    	System.out.println(xfile.getName());
			    }
			}
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
        
		
	}

}
