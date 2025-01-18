package proxy;

// 靜態代理
// 代理執行任務
public class PersonProxy implements Person {
	// 指定特定的代理對象
	private Person person;
	
	// 透過建構子可以將  Man 或 Woman 物件傳入
	public PersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public void work() {
		// 代理執行任務(公用邏輯)
		System.out.println("快篩");
		System.out.println("戴口罩");
		// 代理執行任務(業務邏輯)
		person.work();
		// 代理執行任務(公用邏輯)
		System.out.println("脫口罩");
	}
	
}
