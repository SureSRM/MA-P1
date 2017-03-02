import java.io.*;
import java.util.*;

public class CodeReplacer {
	public final String TEMPLATE_DIR = "user.dir";
	String sourceTemplate;
	String code;
	String initcode;
	
	public void substitute(String reqId, PrintWriter out) throws IOException	{
		// Read in the template file
		String templateDir = System.getProperty(TEMPLATE_DIR, "");
		StringBuffer sb = new StringBuffer("");
		try {
			FileReader fr = new FileReader(new File(templateDir , "template.html"));
			BufferedReader br = new BufferedReader(fr);
			String line;
			// Until template is finished
			while(((line=br.readLine())!="") && line!=null)
				sb = new StringBuffer(sb + line + "\n");
			br.close();
			fr.close();
		} catch (Exception e) {
		}
		sourceTemplate = new String(sb);
		try {
			String template = new String(sourceTemplate);
			// Substitute for %CODE%
			int templateSplitBegin = template.indexOf("%NAME%");
			int templateSplitEnd = templateSplitBegin + 6;
			String templatePartOne = new String(template.substring(0, templateSplitBegin));
			String templatePartTwo = new String(template.substring(templateSplitEnd, template.length()));
			code = new String(reqId);
			template = new String(templatePartOne+code+templatePartTwo);
			// Substitute for %ALTCODE%
			templateSplitBegin = template.indexOf("%INITIALS%");
			templateSplitEnd = templateSplitBegin + 10;
			templatePartOne = new String(template.substring(0, templateSplitBegin));
			templatePartTwo = new String(template.substring(templateSplitEnd, template.length()));
			String[] str = code.split(" ");
			initcode = "";
			for (String s: str) 
				if (s.length() > 0)
					initcode += s.charAt(0);
			out.print(templatePartOne+initcode+templatePartTwo);
		} catch (Exception e) {
			System.out.println("Error in substitute()");
		}
		out.flush();
		out.close();
	}
}
