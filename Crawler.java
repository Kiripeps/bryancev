import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler 
{


	static final String CONST1 = "(href=\").*?\"";

	static final String CONST2 = "(<a).*?>";

	private static final Pattern TAG_A_PATTEN_COMPILE = Pattern.compile(CONST2);

	private static final Pattern CONST1_COMPILE = Pattern.compile(CONST1);

	private HashSet<String> perem2 = new HashSet<String>();

	private HashSet<String> allDomain = new HashSet<String>();

	private LinkedBlockingDeque <URLDepthPair> unCheckedList = new LinkedBlockingDeque <URLDepthPair>();

	private LinkedList <URLDepthPair> perem1 = new LinkedList <URLDepthPair>();

	private LinkedList <URLDepthPair> noneCheckedList = new LinkedList <URLDepthPair>();

	private int maxDepth;

	public Crawler(String url, int maxDepth) throws UnknownHostException, IOException, ClassNotFoundException, SQLException
	{
		URLDepthPair urlpair = new URLDepthPair(url,0);
		unCheckedList.add(urlpair);
		perem2.add(urlpair.url);
		allDomain.add(urlpair.domain);
		this.maxDepth = maxDepth;


	}



	public void startCrawl() throws IOException, InterruptedException
	{
		while(!unCheckedList.isEmpty())
		{
			URLDepthPair urlpair = unCheckedList.pollFirst();
			if (urlpair.depth<=maxDepth) 
			{
				if(readURL(urlpair)) perem1.addLast(urlpair);
			}
			else noneCheckedList.add(urlpair);
		}
	}

	private boolean readURL(URLDepthPair urlpair) throws IOException
	{
		System.out.println(urlpair.url);
		SocketConnection conn = new SocketConnection(urlpair);
		if (!conn.connect()) return false;
		conn.sendGET();
		if (conn.code.equals("200"))
		{
			String line;
			BufferedReader br = conn.br;
			while (!(line = br.readLine()).equals("0")) 
			{
				ParseNewURL(line,urlpair);
		    }
			conn.close();
			return true;
			
		}
		else return false;
	}

	private boolean ParseNewURL(String line, URLDepthPair url)
	{
		try
		{
			Matcher m = TAG_A_PATTEN_COMPILE.matcher(line);
			m.find();
			String tagA = line.substring(m.start(),m.end());
			Matcher m2 = CONST1_COMPILE.matcher(tagA);
			m2.find();
			String href = tagA.substring(m2.start(),m2.end());
			URLDepthPair newURL = new URLDepthPair(href,url.depth+1,url.domain);

			if (!perem2.contains(newURL.url))
			{
				perem2.add(newURL.url);
				if (allDomain.contains(newURL.domain)) unCheckedList.addLast(newURL);
				else 
				{
					unCheckedList.addFirst(newURL);
					allDomain.add(newURL.domain);
				}
					
				return true;
			}
			return false;
		}
		catch (IllegalStateException e)
		{
			return false;
		} 
		catch (MalformedURLException e) 
		{
			return false;
		}
	}

	public LinkedList <URLDepthPair> get—heckedSites()
	{
		return perem1;
	}

	public LinkedList <URLDepthPair> getUn—heckedSites()
	{
		return noneCheckedList;
	}

}
