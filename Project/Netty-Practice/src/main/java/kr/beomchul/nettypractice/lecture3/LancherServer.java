package kr.beomchul.nettypractice.lecture3;

public class LancherServer {

	
	public static void main(String[] args) throws Exception {
		
		
		if(args.length != 1){
			System.out.println(CommandServer.class.getSimpleName());
		}
		
//		int port = Integer.parseInt(args[0]);
		new CommandServer(12345).start();
	}
}
