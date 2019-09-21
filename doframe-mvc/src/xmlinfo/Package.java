package xmlinfo;

/**
 *
 *@author Gxy
 *@Since 2019-08-23 02:27:12
 */
public class Package {
	
	private String packagename;
	private String namespace;
	private String extendsfile;
	
	public String getPackagename() {
		return packagename;
	}
	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getExtendsfile() {
		return extendsfile;
	}
	public void setExtendsfile(String extendsfile) {
		this.extendsfile = extendsfile;
	}
}
