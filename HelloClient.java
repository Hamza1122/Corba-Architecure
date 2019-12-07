import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.*;

public class HelloClient
{
	static Hello helloImpl;

	public static void main(String args[]){
		try{
			// create and initialize the ORB
        ORB orb = ORB.init(args, null);

        // get the root naming context
        org.omg.CORBA.Object objRef =
            orb.resolve_initial_references("NameService");

            // Use NamingContextExt instead of NamingContext. This is
        // part of the Interoperable naming Service.
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        // resolve the Object Reference in Naming
        String name = "Hello";
        helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

        System.out.println("Obtained a handle on server object: " + helloImpl);
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a string to see if it is an integer:");
				System.out.println("Enter a size of fibonacci series size ?");
				 String temp = sc.nextLine();
    System.out.println("Fibonaaci Series Sum:-"+helloImpl.judgeInt(temp));   //printing the fibanacci function result
//	System.out.println("Total Sum"+helloImpl.sum_func(temp));
System.out.println(helloImpl.func_cal());        //print sparse matirx result


        helloImpl.shutdown();

		}catch(Exception e){
			System.out.println("ERROR : " + e) ;
          e.printStackTrace(System.out);
		}
	}
}
