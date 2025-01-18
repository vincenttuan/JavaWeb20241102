package proxy;

public class Test2 {

	public static void main(String[] args) {
		// 利用靜態代理來實現
		System.out.println("沒代理:");
		System.out.println("----------------");
		Person man1 = new Man(); // 原本方式
		man1.work();
		Person woman1 = new Woman(); // 原本方式
		woman1.work();
		
		System.out.println();
		
		System.out.println("有代理:");
		System.out.println("----------------");
		Person man2 = new PersonProxy(new Man()); // 使用代理方式
		man2.work();
		Person woman2 = new PersonProxy(new Woman()); // 使用代理方式
		woman2.work();
		
		

	}

}
