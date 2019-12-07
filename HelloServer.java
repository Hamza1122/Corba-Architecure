import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

public class WorkerThread extends Thread{
    private int row;
    private int col;
    private int [][] A;
    private int [][] B;
    private int [][] C;

    public WorkerThread(int row, int col, int[][] A,
      int[][] B, int[][] C) {
        this.row = row;
        this.col = col;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public void run() {
        C[row][col] = (A[row][0] * B[0][col])+ (A[row][1]*B[1][col]) ;
    }
}


class HelloImpl extends HelloPOA{
	private ORB orb;

  public int sum=0;
	int t1=0,t2=1,i,temp=0;
	String strvalue;

	public void setORB(ORB orb_val){
		orb=orb_val;
	}
	//implement methods
	public String sum_func (String inStr){
		//int result;
			int x = Integer.parseInt(inStr);
//System.out.println(m1.hello_world());
return "Hello";


}


public String func_cal()    //Sparse MAtrxi Function
{

	public static int M = 3;
     public static int K = 2;
     public static int N = 3;


		 for (int i = 0; i<M; i++){
					for (int j=0; j<N; j++){
							Threads[i][j] = new WorkerThread(i,j,A,B,C);
							Threads[i][j].start();
					}
			}


			System.out.println("Elements of Matrix C:");
		         for (int i = 0; i<M; i++){
		             for (int j=0; j<N; j++){
		                 System.out.println("["+i+","+j+"] = "+C[i][j]);
		             }
		         }  



return "Multi-Threading ";
}







		//implement methods
		public String judgeInt (String inStr){
			//int result;
				int x = Integer.parseInt(inStr);
        int n=x;

				for(i=1; i<=n; ++i)
				{	//	System.out.print(t1 + "+");
						 sum = t1 + t2;
				     t1 = t2;
				     t2 = sum;
             temp=t2;
						 strvalue=String.valueOf(temp);
						 System.out.print(t1 + "+");

}
return strvalue;
}




  	public void shutdown (){
		orb.shutdown(false);
  	}

  }






  public class HelloServer{
  	public static void main(String args[]){
  	try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa & activate the POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // create servant and register it with the ORB
      HelloImpl helloImpl = new HelloImpl();
      helloImpl.setORB(orb);
      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
      Hello href = HelloHelper.narrow(ref);

      // get the root naming context
      // NameService invokes the name service
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "Hello";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("HelloServer ready and waiting ...");

      // wait for invocations from clients
      orb.run();

      }

      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }

      System.out.println("HelloServer Exiting ...");



  	}
  }
