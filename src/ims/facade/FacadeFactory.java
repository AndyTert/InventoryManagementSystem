package ims.facade;

public class FacadeFactory {

	private static Facade facade = new Facade();

	public static Facade getFacade() {
		return facade;
	}

}
