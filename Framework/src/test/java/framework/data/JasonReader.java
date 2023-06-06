package framework.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JasonReader {
	
	public List<HashMap<String,String>> convertJasonToString() throws IOException
	{
		String JasonContent =FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\purchase.jason"),StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(JasonContent, new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
	}

}
