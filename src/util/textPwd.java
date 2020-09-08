package util;
import util.Common;
public class textPwd {
	
	private byte y=(byte)'Y';
	private byte A=(byte)'A';
	private byte L=(byte)'l';
	private Common cm=new Common();
	
	
	///文本加密
	public String textSetPwd(String pwd) {
		
		char[] pass=pwd.toCharArray();
		int[] pass2=new int[pass.length];
		for(int i=0;i<pass.length;i++) {
			int byteAscii = (byte)pass[i];
			byteAscii+=(y-A+L);
			
			pass2[i]=byteAscii;
		}
		int s=pass2.length/2;
		int len=pass2.length-1;
		for(int i=0;i<s;i++) {
			int temp=pass2[i];
			pass2[i]=pass2[len-i];
			pass2[len-i]=temp;
			
		}
		return cm.changeInt(pass2);
	}
	
	//文本解密
	public String textGetPwd(String pwd) {
		String[] floors=pwd.split(":");
		int len=floors.length;
		int[] pass0=new int[len];
		int two=len/2;
		for(int i=0;i<two;i++) {
			if(len%2==1) {
				pass0[two]=Integer.parseInt(floors[two]);
			}
			pass0[i]=Integer.parseInt(floors[len-i-1]);
			pass0[len-i-1]=Integer.parseInt(floors[i]);
		}
		String res="";
		//pass0为变换位置后的数据 byteAscii+=(y-A+L);
		
		for(int i=0;i<len;i++) {
			char c=(char)(pass0[i]-(y-A+L));
			res+=c;
		}
		return res;
	}
	
	
}
