/**
 * Created by airshaos on 17/8/17.
 */

import java.io.*;
import java.util.*;

public class SerializationDemo {
    public static void main(String args[]){
        try{
            Vector list;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println ("Checking for previous serialized list");
            try{
                FileInputStream fin = new FileInputStream("list.out");
                ObjectInputStream oin = new ObjectInputStream(fin);
                try{
                    Object obj = oin.readObject();
                    list = (Vector) obj;
                }catch (ClassCastException cce){
                    list = new Vector();
                }catch (ClassNotFoundException cnfe)
                {
                    list = new Vector();
                }
                fin.close();
            }catch (FileNotFoundException fnfe){
                list = new Vector();
            }

            for(;;){
                System.out.println ("Menu :-");
                System.out.println ("1.. Add item");
                System.out.println ("2.. Delete item");
                System.out.println ("3.. List items");
                System.out.println ("4.. Save and quit");
                System.out.print   ("Choice : ");

                String response = reader.readLine();
                int choice = Integer.parseInt (response);

                switch (choice){
                    case 1 :
                        // Add the item to list
                        System.out.print
                                ("Enter item : ");
                        String item = reader.readLine();
                        list.addElement(item);
                        break;
                    case 2 :
                        // Delete the item from list
                        System.out.print
                                ("Enter item : ");
                        String deadItem =
                                reader.readLine();
                        list.removeElement(deadItem);
                        break;
                    case 3 :
                        // List the elements of the list
                        for (Enumeration e =
                             list.elements();
                             e.hasMoreElements();)
                        {
                            System.out.println
                                    (e.nextElement());
                        }
                        break;
                    case 4 :
                        // Save list and terminate
                        System.out.println
                                ("Saving list");
                        FileOutputStream fout =
                                new FileOutputStream( "list.out" );
                        ObjectOutputStream oout = new
                                ObjectOutputStream ( fout );
                        // Write the object to the stream
                        oout.writeObject (list);
                        fout.close();
                        System.exit(0);
                }
            }
        }catch (IOException ioe){
            System.err.println ("I/O error");
        }
    }
}
