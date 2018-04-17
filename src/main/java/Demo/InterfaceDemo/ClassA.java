/**
 * 
 */
package Demo.InterfaceDemo;

/**
 * @author kl
 *
 */
public class ClassA extends ClassB{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassA classA = new ClassA();
		
		try {
			ClassA classA1 = (ClassA) classA.clone();
			
			System.out.println(classA == classA1);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
