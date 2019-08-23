package in.conceptarchitect.testing;

import static org.junit.Assert.fail;

public class JunitAsserts {
	
	public static <T extends Throwable> T assertThrows(Class<T> exception, Runnable task) {
		
		try {
			task.run();
			throw new AssertionError("Excpected exception was not thrown :"+exception);
		}catch(Exception ex) {
			if(ex.getClass().equals(exception))
				return (T)ex;
			else
				throw ex;
		}
		
	}
}
