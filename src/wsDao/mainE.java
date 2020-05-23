package wsDao;




import javax.xml.ws.Endpoint;

public class mainE {

	public static void main(String[] args) {
		
	
	Endpoint.publish("http://localhost:1212/ws",new functions());		
	System.out.println("bene");
				
		
	}
	
}
