package util;

public class InfoUs {
	private String HomeFloor;
	private String HomeAd;
	private String Pawd;
	public String getHomeFloor() {
		return HomeFloor;
	}
	public void setHomeFloor(String homeFloor) {
		HomeFloor = homeFloor;
	}
	public String getHomeAd() {
		return HomeAd;
	}
	public void setHomeAd(String homeAd) {
		HomeAd = homeAd;
	}
	public String getPawd() {
		return Pawd;
	}
	public void setPawd(String pawd) {
		Pawd = pawd;
	}
	@Override
	public String toString() {
		return "InfoUs [HomeFloor=" + HomeFloor + ", HomeAd=" + HomeAd + ", Pawd=" + Pawd + "]";
	}
	
	
}
