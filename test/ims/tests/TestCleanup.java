package ims.tests;

public class TestCleanup {

	public static void cleanUp() {
		TestRepository  tr = new TestRepository();
		tr.cleanUp();
	}

}
