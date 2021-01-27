package pachong.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlAndChild implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7164075602676340976L;
	private String urlPath;
	private List<String> childPaths = new ArrayList<>();//不包括自己
	public String getUrlPath() {
		return urlPath;
	}
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	public List<String> getChildPaths() {
		return childPaths;
	}
	public void setChildPaths(List<String> childPaths) {
		this.childPaths = childPaths;
	}
	@Override
	public String toString() {
		return "HttpUrlAndChild [urlPath=" + urlPath + ", childPaths=" + childPaths + "]";
	}
}