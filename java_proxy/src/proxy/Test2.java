package proxy;

public class Test2 {

	public static void main(String[] args) {
		// 利用靜態代理來實現
		//Person man = new Man(); // 原本方式
		Person man = new PersonProxy(new Man()); // 使用代理方式
		
		

	}

}
