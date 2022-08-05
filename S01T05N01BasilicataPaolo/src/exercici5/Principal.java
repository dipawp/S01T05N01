package exercici5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Persona p = new Persona("Jordi", "Puig", 34);
		
		Principal.serialize("src/file.ser", p);
		Principal.deserialize("src/file.ser");
		
	}
	
	
	public static void serialize(String nomFitxer, Persona obj) {
		
		try {
			FileOutputStream f = new FileOutputStream(nomFitxer);
			ObjectOutputStream o = new ObjectOutputStream(f);
		    o.writeObject(obj);
		    //System.out.println(o);
		    o.close();
		    f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	public static void deserialize(String nomFitxer) {
		try {
			FileInputStream f = new FileInputStream(nomFitxer);
			ObjectInputStream o = new ObjectInputStream(f);
			Persona p = (Persona)o.readObject();
			o.close();
			f.close();
			System.out.println(p.getNom());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
