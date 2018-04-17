package Demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		File file = new File("C:\\Users\\kl\\Desktop\\fce1ab3aeda121bde2e00c270c323832_5902fde9e5cb41493368297.jpeg");
//		
//		System.out.println(file.getPath());
//		System.out.println(file.exists());
//		System.out.println(file.toURI());
			
		URL url = new URL("https://shq-pic.b0.upaiyun.com/certificate/5902fde9e5cb41493368297.jpeg");
		System.out.println(url.getFile());
		System.out.println(url.getPath());
		System.out.println(url.getPort());
		System.out.println(url.openStream().toString());
	}

}
