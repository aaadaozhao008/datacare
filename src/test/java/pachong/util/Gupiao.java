package pachong.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Gupiao {
	public static void main(String[] args) throws IOException {
		int page = 1;
		String path = "http://www.iwencai.com/stockpick/cache?token=533f4dd1ebb2cf9c0e8799471b1560b8&p="+page+"&perpage=70&showIndexId=%E6%9C%80%E6%96%B0%E4%BB%B7%09%E5%88%86%E7%BA%A2%E6%98%8E%E7%BB%86%09%E6%9C%80%E6%96%B0%E6%B6%A8%E8%B7%8C%E5%B9%85%09%E6%AF%8F%E8%82%A1%E8%82%A1%E5%88%A9(%E7%A8%8E%E5%89%8D)%09%E6%AF%8F%E8%82%A1%E8%82%A1%E5%88%A9(%E7%A8%8E%E5%89%8D)%E6%8E%92%E5%90%8D%09%E6%AF%8F%E8%82%A1%E8%82%A1%E5%88%A9(%E7%A8%8E%E5%89%8D)%E6%8E%92%E5%90%8D%E5%90%8D%E6%AC%A1%09%E6%AF%8F%E8%82%A1%E8%82%A1%E5%88%A9(%E7%A8%8E%E5%89%8D)%E6%8E%92%E5%90%8D%E5%9F%BA%E6%95%B0%09%E9%99%A4%E6%9D%83%E9%99%A4%E6%81%AF%E6%97%A5%09%E5%88%86%E7%BA%A2%E5%AE%9E%E6%96%BD%E5%85%AC%E5%91%8A%E6%97%A5%09%E9%A2%84%E6%A1%88%E5%85%AC%E5%91%8A%E6%97%A5%09%E8%82%A1%E4%B8%9C%E5%A4%A7%E4%BC%9A%E5%85%AC%E5%91%8A%E6%97%A5%09%E5%88%86%E7%BA%A2%E6%96%B9%E6%A1%88%E8%BF%9B%E5%BA%A6&showType=[%22%22,%22%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22]";    //雅达公司官网
		URL url2 = new URL(path);
		URLConnection openConnection = url2.openConnection();
		HttpURLConnection httpUrlConnection = (HttpURLConnection) openConnection;
	}
}
