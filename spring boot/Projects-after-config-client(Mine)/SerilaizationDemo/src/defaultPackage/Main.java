package defaultPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args)throws IOException, ClassNotFoundException {
		
		PurchaseOrder po=new PurchaseOrder("1234","Dell",100,900);
		FileOutputStream foo=new FileOutputStream("pofile.dat");
		ObjectOutputStream oos=new ObjectOutputStream(foo);
		oos.writeObject(po);
		
		FileInputStream fis=new FileInputStream("pofile.dat");
		ObjectInputStream iis=new ObjectInputStream(fis);
		Object obj=iis.readObject();
		PurchaseOrder ref=(PurchaseOrder) obj;
		System.out.println(ref);
		
		//By default the ObjectOutputStream can only do the serilization for the files only
	}

}
