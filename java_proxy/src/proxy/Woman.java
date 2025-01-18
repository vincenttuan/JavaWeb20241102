package proxy;

public class Woman implements Person {

	@Override
	public void work() {
		// 公用邏輯
		//System.out.println("戴口罩");
		// 業務邏輯
		System.out.println("市場買菜");
		// 公用邏輯
		//System.out.println("脫口罩");
	}

}
