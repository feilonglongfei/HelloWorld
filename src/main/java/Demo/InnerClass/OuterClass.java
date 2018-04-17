package Demo.InnerClass;

public class OuterClass {
	
	private String str;
	
	private InnerClass innerClass;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public InnerClass getInnerClass() {
		return innerClass;
	}

	public void setInnerClass(InnerClass innerClass) {
		this.innerClass = innerClass;
	}

	public class InnerClass {
		private String str;

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}
	}

	public static void main(String[] args) {

		OuterClass outerClass = new OuterClass();
		InnerClass innerClass = outerClass.new InnerClass();
		innerClass.setStr("inner str");
		outerClass.setInnerClass(innerClass);
		
		System.out.println(outerClass);
	}

}
