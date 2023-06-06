package HemanthAcademy;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int i=0;
	int maxcount=2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(i<maxcount)
		{
			i++;
			return true;
		}
		return false;
	}

}
