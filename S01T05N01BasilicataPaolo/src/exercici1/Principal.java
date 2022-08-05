package exercici1;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.xml.stream.events.Characters;

public class Principal {
	
	public static void main(String args[]) throws Exception {
		//Principal.llistarContingutCarpeta("/home/xback31/Documents/primo_livello/");
		leggiCartella("/home/xback31/Documents/primo_livello/");
	}
	
	
	public static void leggiCartella(String path) {
		File cartella = new File(path);
		
		File[] listFile = cartella.listFiles();
		
		
		HashMap<String,File> lista = null;
		
		System.out.println(cartella.getName());
		for(File fil: listFile) {
			if(cartella.isDirectory()) {
				lista = leggi(cartella);
				
			}
		}
		System.out.println(lista);
		
		
		
		
		HashMap<String, String> codenames = new HashMap<String, String>(); 
		codenames.put("JDK 1.1.4", "Sparkler");
		codenames.put("J2SE 1.2", "Playground");
		codenames.put("J2SE 1.3", "Kestrel");
		codenames.put("J2SE 1.4", "Merlin");
		codenames.put("J2SE 5.0", "Tiger");
		codenames.put("Java SE 6", "Mustang");
		codenames.put("Java SE 7", "Dolphin");
		System.out.println("HashMap before sorting, random order ");
		Set<Entry<String, String>> entries = codenames.entrySet();
		for(Entry<String, String> entry : entries){ System.out.println(entry.getKey() + " ==> " + entry.getValue()); }
		TreeMap<String, String> sorted = new TreeMap<>(codenames); 
		Set<Entry<String, String>> mappings = sorted.entrySet(); 
		System.out.println("HashMap after sorting by keys in ascending order "); 
		for(Entry<String, String> mapping : mappings){ System.out.println(mapping.getKey() + " ==> " + mapping.getValue());}
		List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, String>>(entries); // sorting HashMap by values using comparator 
		Comparator<Entry<String, String>> valueComparator = new Comparator<Entry<String,String>>() { 
			@Override public int compare(Entry<String, String> e1, Entry<String, String> e2) { 
			String v1 = e1.getValue(); 
			String v2 = e2.getValue(); 
			
			int vv = v1.compareTo(v2);
			return v1.compareTo(v2); } 
			};
		Collections.sort(listOfEntries, valueComparator);

		
				
		}
	
	public static HashMap<String,File> leggi(File folder){
		HashMap<String,File> lista = new HashMap<String,File>();
		
		File[] listFile = folder.listFiles();
		
		for(File fil:listFile) {
			if(fil.isDirectory()) {
				lista.put("D", fil);
			}else {
				lista.put("F", fil);
			}
		}
		
		
		String hh = "";
		
		return lista;
	}
	
	
	
	
	public static HashMap<String,String> leggiFile(File folder){
		HashMap<String,String> lista = new HashMap<String,String>();
		
		File[] listFile = folder.listFiles();
		
		for(File fil:listFile) {
			if(fil.isDirectory()) {
				lista.put("D", fil.getName());
			}else {
				lista.put("F", fil.getName());
			}
		}
		
		
		String hh = "";
		
		return lista;
	}
	
	
	

	
	
	
	
	
	
	public static void llistarContingutCarpeta(String directori) throws Exception {
		
		File folder = new File(directori);
		
		for(File fitxer: folder.listFiles()) {
			if(fitxer.isDirectory()) {
				
				System.out.println(folder.getName());
				
				File[] listFile =  folder.listFiles();
				
				
				
				listaIFile(fitxer);
				
				
				//print(fitxer.getAbsolutePath());
				
			}else {
				//System.out.println(fitxer.getName());
			}
		}
	}
	
	static List<String> llistaFile = new ArrayList<String>();
	
	public static void listaIFile(File folder) throws Exception {
		
		
		File[] fil = folder.listFiles();
		
		
		
		for(File file:fil) {
			if(file.isDirectory()) {
				listaIFile(file);
			}else {
				llistaFile.add(file.getName());
			}
				
			
		}
		
		Collections.sort(llistaFile);
		System.out.println(llistaFile);
		
	}
	
	public static void print(String fold) {
		
		
		
		
		
		
		
		
		
		
//		TreeMap<String,String> treemap = new TreeMap<String,String>();
//		List<String> names = new ArrayList<String>();
//		File folder = new File(fold);
//           for(File fitxer: folder.listFiles()) {
//			if(fitxer.isFile()) {
//					names.add(fitxer.getName() + "\n");
//			}else {
//				Principal.llistarContingutCarpeta(fitxer.getAbsolutePath());
//			}
//		   }
//           Collections.sort(names);
//           for(String str: names) {
//        	   System.out.println(" " + str);
//           }
           
           
          // Collections.sort(names);
           //System.out.println(names);
	}

}
