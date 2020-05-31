import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Crawler 
{

	public URLPool urlPool;



	static final String CONST1 = "(href=\").*?\"";

	static final String CONST2 = "(<a).*?>";

	private static final Pattern TAG_A_PATTEN_COMPILE = Pattern.compile(CONST2);

	private static final Pattern CONST1_COMPILE = Pattern.compile(CONST1);

	private int maxDepth;

	public Crawler(String url, int maxDepth) throws UnknownHostException, IOException, ClassNotFoundException, SQLException
	{
		URLDepthPair urlpair = new URLDepthPair(url,0);
		urlPool = new URLPool();
		urlPool.addURL(urlpair);
		this.maxDepth = maxDepth;

	}

	public class CrawlerTask implements Runnable {


	    public void run()
	    {
	    	while(true)
	    	{
	    		try {
					startCrawl();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }

	}

	public void met8(int n) throws ClassNotFoundException
	{

		for(int i = 0;i<n;i++)
		{
			CrawlerTask run = new CrawlerTask();
			Thread myThread = new Thread(run,"Thread" + i);
			myThread.start();
		}
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (urlPool.PEREM1 == n)
			{
				System.exit(0);
			}
		}
	}

	private void startCrawl() throws IOException, InterruptedException
	{
		
		URLDepthPair urlpair = urlPool.getURL();
		if (urlpair.depth<=maxDepth) 
		{
			if(readURL(urlpair)) urlPool.addCheckedURL(urlpair);
			System.out.println(urlpair.url);
		}
		else urlPool.addNoneCheckedURL(urlpair);
	}

	@SuppressWarnings("finally")
	private boolean readURL(URLDepthPair urlpair) throws IOException
	{
		SocketConnection conn = new SocketConnection(urlpair);
		if (!conn.connect()) return false;
		conn.sendGET();
		if (conn.checkConnection())
		{
			try
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
			finally
			{
				conn.close();
				return false;
			}
			
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
			urlPool.addURL(newURL);
			return true;
			
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

}
