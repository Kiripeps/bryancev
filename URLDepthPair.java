import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class URLDepthPair 
{

	public static final int START_HREF = 6;

	public static final int HREF_TOEND = 1;

	public static final String HTML_EXTENSION = ".html";

	public static final String URL_PREFIX_HTTP = "http://";
	public static final String PREFIX_PATTERN = "(http://)";

	public static final String CONST1 = "([\\da-zà-ÿ\\.-]+)\\.([a-zà-ÿ\\.]{2,6})";

	public static final String CONST2 = "([/\\wà-ÿ\\.-]*)*\\/?";

	public static final String CONST3 = "\\.[\\wà-ÿ\\-]+$";

	public static final String URL_PATTERN = PREFIX_PATTERN+CONST1+CONST2;

	public String url;

	public String prefix;

	public String domain;

	public String path;

	public int depth;

	public URLDepthPair(String url, int depth) throws MalformedURLException
	{
		if (testURL(url)) this.url= url;
		else this.url = searchPattern(url,URL_PATTERN); 
		Pattern p = Pattern.compile(CONST1);
		Matcher m = p.matcher(this.url);
		m.find();
		this.domain = this.url.substring(m.start(),m.end());
		this.path = this.url.substring(m.end());
		if (this.path.isEmpty()) this.path = "/";
		this.depth = depth;
		checkExtension();
	}

	public URLDepthPair(String href, int depth, String domain) throws MalformedURLException
	{
		String hrefContent = href.substring(START_HREF,href.length()-HREF_TOEND);
		try
		{
			this.url = searchPattern(hrefContent,URL_PATTERN);
			Pattern p = Pattern.compile(CONST1);
			Matcher m = p.matcher(this.url);
			m.find();
			this.domain = this.url.substring(m.start(),m.end());
			this.path = this.url.substring(m.end());
			if (this.path.isEmpty()) this.path = "/";
			this.depth = depth;
			checkExtension();
		}
		catch (MalformedURLException e)
		{
			if (!Pattern.matches(CONST1,domain)) throw new MalformedURLException("Wrong URL");
			hrefContent = searchPattern(hrefContent,CONST2);
			if (hrefContent.isEmpty()) throw new MalformedURLException("Wrong URL");
			if (hrefContent.charAt(0) != '/') hrefContent = "/"+hrefContent;
			this.url = URL_PREFIX_HTTP+domain+hrefContent;
			this.domain = domain;
			this.path = hrefContent;
			this.depth = depth;
			checkExtension();
		}
	}

	public boolean testURL(String url)
	{
		return Pattern.matches(URL_PATTERN, url);
	}

	public String searchPattern(String url,String pattern) throws MalformedURLException
	{
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(url);
		try
		{
			m.find();
			return url.substring(m.start(),m.end());
		}
		catch (IllegalStateException e)
		{
			throw new MalformedURLException("Wrong URL");
		}
	}

	private void checkExtension() throws MalformedURLException
	{
		String extension = null;
		try {
			 extension = searchPattern(path,CONST3);
		} 
		catch (MalformedURLException e) 
		{
			 extension = HTML_EXTENSION;
		}
		finally
		{
			if (!extension.equals(HTML_EXTENSION)) throw new MalformedURLException("Wrong extension");
		}
		
	}
	@Override
	public int hashCode()
	{
		return url.hashCode();
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		URLDepthPair other = (URLDepthPair) obj;
		if (url.equals(other.url)) return true;
		else return false;
	}
}
