package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
	
	
	//将整形数字转换成字符串
	public String changeInt(int[] arr) {
		String res="";
		for(int i=0;i<arr.length;i++) {
			
			if(i==arr.length-1) {
				res+=arr[i]+"";
			}else {
				res+=arr[i]+":";
			}
		}
		return res;
	}
	
	//转换
	public InfoUs changeToObj(String s) {
		InfoUs info=new InfoUs();
		String regex="\\[|\\]";
		String res=s.replaceAll(regex, "");
		String[] s1=res.split(", ");
		for(int i=0;i<s1.length;i++) {
			String[] s2=s1[i].split("=");
			if(s2[0].equals("HomeFloor")) {
				
				info.setHomeFloor(s2[1]);
			}
			if(s2[0].equals("HomeAd")) {
				info.setHomeAd(s2[1]);
			}
			if(s2[0].equals("Pawd")) {
				info.setPawd(s2[1]);
			}
		}
		return info;
	}
	
	//打开或者创建文本写入密码等信息
	public void openFileWrite(InfoUs info) throws IOException {
		String s=info.toString();
		
		File de=new File("C:\\Users\\Public\\HomeFloor");
		if(!de.isDirectory()) {
			de.mkdir();
			// R ： 只读文件属性。A：存档文件属性。S：系统文件属性。H：隐藏文件属性。
			String sets = "attrib +H \"" + de.getAbsolutePath() + "\"";
			System.out.println(sets);
			de.setWritable(true,false);
			// 运行命令
			Runtime.getRuntime().exec(sets);
		}
		
		File f = new File("C:\\Users\\Public\\HomeFloor\\pwd.td");
		if(!f.exists()) {
			f.createNewFile();//创建新的文件
		}
		FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter("C:\\Users\\Public\\HomeFloor\\pwd.td", true);
            fwriter.write(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

	}
	//打开读取信息
	public String openFileRead() {
		 File file = new File("C:\\Users\\Public\\HomeFloor\\pwd.td");
		  BufferedReader reader = null;
		  StringBuffer sbf = new StringBuffer();
		  try {
			  		reader = new BufferedReader(new FileReader(file));
			  		String tempStr;
			  		while ((tempStr = reader.readLine()) != null) {
			  			sbf.append(tempStr);
			  		}
			  		reader.close();
			  		return sbf.toString();
		    
		  } catch (IOException e) {
			  		e.printStackTrace();
		  } finally {
		    if (reader != null) {
		    	try {
		    		reader.close();
		    	} catch (IOException e1) {
		    		e1.printStackTrace();
		    	}
		    }
		  }
		  return sbf.toString();
	}
}
