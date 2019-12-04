package cpu_v4;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		InetAddress localHost;
		String[] ip;
		int Prefix;
		
		try {
			localHost = Inet4Address.getLocalHost();
			NetworkInterface networkInterface;
			
			networkInterface = NetworkInterface.getByInetAddress(localHost);
			
			System.out.println(
			networkInterface.getInterfaceAddresses().get(0).getAddress()+ "/"+
			networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength());
			
			System.out.println(networkInterface.getInterfaceAddresses().get(0).getAddress());
			ip=networkInterface.getInterfaceAddresses().get(0).getAddress().toString().split("\\.");
			Prefix = networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
			
			int N ;
			N = Prefix/8;
			System.out.println(N);
			
			switch(N) {
				case(0):
					
//					ip[0] = ;
					ip[1] = "0";
					ip[2] = "0";
					ip[3] = "0";
					break;
				case(1):
//					ip[1] = "0";
					ip[2] = "0";
					ip[3] = "0";
					break;
				case(2):
//					ip[2] = "0";
					ip[3] = "0";
					break;
				case(3):
//					ip[3] = "0";
					break;
				default:
					System.out.println("NetworkPrefix Error");
				
			}
			
			System.out.println(ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3]);
			

//			
//			System.out.println();
//			
//			for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
//			    System.out.println(address.getAddress()+ "/"+ address.getNetworkPrefixLength());
//			    
//			}
//			
			
			
//			 localHost = Inet4Address.getLocalHost();
//			 NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
//
//			 for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
//			     System.out.println(address.getAddress() + "/" + address.getNetworkPrefixLength());
//			 }

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		
	}

}
