/*
代理模式
*/
public class TestProxy{
	public static void main(String[] args){
		ISubject isubject = Factory.getInstance();
		isubject.buyComputer();
	}
}
interface ISubject{
	void buyComputer();//核心功能是买电脑
}
class RealSubject implements ISubject{
	public void buyComputer(){
		System.out.println("买一台外星人电脑");
	}
}
class ProxySubject implements ISubject{
	private ISubject isubject;
	public  ProxySubject(ISubject isubject){
		this.isubject = isubject;
	}
	public void createComputer(){
		System.out.println("生产外星人电脑");
	}
	public void afterSale(){
		System.out.println("外星人售后服务");
	}
	public void buyComputer(){
		this.createComputer();
		this.isubject.buyComputer();//调用真实的业务
		this.afterSale();
	}
}
class Factory{
	public static ISubject getInstance(){
		return new ProxySubject(new RealSubject());
	}		
}
