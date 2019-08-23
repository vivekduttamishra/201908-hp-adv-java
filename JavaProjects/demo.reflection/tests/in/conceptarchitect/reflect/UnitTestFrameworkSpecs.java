package in.conceptarchitect.reflect;

import org.junit.Test;

public class UnitTestFrameworkSpecs {

	
	@Test
	public void testRunnerReturnsTestResult() {
		
		class TigerTests{
			
		};
		
		UnitTestRunner runner=new UnitTestRunner();
		UnitTestResult result=runner.runTests(new TigerTests());
		
		boolean success= result.isSucess(); //should work if all tests were success
		
		HashMap<String,String> errors=result.getErrors();
		HashMap<String,String> failures=result.getFailures();
		List<String> skippedTests=result.getSkipped();
		
		
	}
}
