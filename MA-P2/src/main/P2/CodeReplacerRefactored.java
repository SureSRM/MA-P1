package P2;

import java.io.*;

public class CodeReplacerRefactored {
	public final String TEMPLATE_DIR = "user.dir";
	public final String NAME_MARK = "%NAME%";
	public final String INITIALS_MARK = "%INITIALS%";
	public final String TEMPLATE_NAME = "template.html";

	public void substitute(String code, PrintWriter out) throws IOException	{
		try {
			String template = readTemplate(TEMPLATE_NAME);

			template = replaceMarkWithInput(code, NAME_MARK, template);
			template = replaceMarkWithInput(getInitials(code), INITIALS_MARK, template);
			out.print(template);
		} catch (Exception e) {
			System.out.println("Error in substitute()");
		}
		out.flush();
		out.close();
	}

	private String replaceMarkWithInput(String input, String mark, String template){
		int templateSplitBegin = template.indexOf(mark);
		int templateSplitEnd = templateSplitBegin + mark.length();
		String head = template.substring(0, templateSplitBegin);
		String tail = template.substring(templateSplitEnd, template.length());
		return head + input + tail;
	}

	private String readTemplate(String templateName){
		String templateDir = System.getProperty(TEMPLATE_DIR, "");
		StringBuilder template = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(templateDir , templateName)));
			String line=br.readLine();

			while(!line.equals("")){
				template.append(line);
				template.append('\n'); //Safer than template.append(line+'\n');
				line=br.readLine();
			}
			br.close();
		} catch (Exception e) {
		}
		return template.toString();
	}

	private String getInitials(String code){
		String[] str = code.split(" ");
		StringBuilder initials = new StringBuilder();
		for (String s: str) {
			if (s.length() > 0) {
				initials.append(s.charAt(0));
			}
		}
		return initials.toString();
	}
}
