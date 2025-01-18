package proxy;

public class Man implements Person {

	@Override
	public void work() {
		// 公用邏輯
		System.out.println("戴口罩");
		// 業務邏輯
		System.out.println("上班工作");
		// 公用邏輯
		System.out.println("脫口罩");
	}

}
