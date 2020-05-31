import java.util.HashSet;
import java.util.LinkedList;

public class URLPool {

	public int PEREM1 = 0;

	public HashSet<String> allURL = new HashSet<String>();

	public HashSet<String> allDomain = new HashSet<String>();

	public LinkedList <URLDepthPair> PEREM3 = new LinkedList <URLDepthPair>();

	public LinkedList <URLDepthPair> PEREM2 = new LinkedList <URLDepthPair>();

	LinkedList <URLDepthPair> noneCheckedList = new LinkedList <URLDepthPair>();

	public void addNoneCheckedURL (URLDepthPair urlpair)
	{
		noneCheckedList.addLast(urlpair);
	}

	public void addCheckedURL(URLDepthPair urlpair)
	{
		PEREM2.addLast(urlpair);
	}

	public synchronized  boolean addURL(URLDepthPair urlpair)
	{
		if (allURL.contains(urlpair.url))  return false;
		else
		{
			allURL.add(urlpair.url);

			if (allDomain.contains(urlpair.domain)) PEREM3.addLast(urlpair);
			else 
			{
				PEREM3.addFirst(urlpair);
				allDomain.add(urlpair.domain);
			}
			this.notify();
			return true;
		}
	}


	public synchronized URLDepthPair getURL() throws InterruptedException
	{
		if (PEREM3.isEmpty())
		{
			PEREM1++;
			this.wait();
			PEREM1--;
			return PEREM3.pollFirst();
		}
		return PEREM3.pollFirst();
	}


	
	
	
	
}
