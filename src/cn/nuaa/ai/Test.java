package cn.nuaa.ai;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test {
	
	private static final char[] hexCode = "0123456789ABCDEF".toCharArray();  
	
	public static void main(String[] args) throws Exception {
		byte[] data1 = showData("C:\\Users\\ai\\Desktop\\test.class");
		byte[] data2 = showData("C:\\Users\\ai\\Desktop\\test1.class");
		byte[] data3 = showData("C:\\Users\\ai\\Desktop\\test3.class");
		compareData(data1,data2);
		compareData(data1,data3);
		System.out.println("data1 length: "+data1.length+"  data2 length: "+data2.length+"  data3 length: "+data3.length);
	}

	private static void compareData(byte[] data1,byte[] data2){
		int num=0;
		for(int i=0;i<data1.length&&i<data2.length;i++){
			if(data1[i]!=data2[i]){
				num++;
			}
		}
		System.out.println("different num: "+num);
	}
	
	private static byte[] showData(String filePath) throws Exception{
		// 指定文件,获取输入流;
		File file = new File(filePath);
		FileInputStream fin = new FileInputStream(file);
		byte[] bdata = readStream(fin);
		printHexBinary(bdata);
		System.out.println("end");
		return bdata;
	}
	
	private static byte[] readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];

		inStream.read(buffer);
		outSteam.write(buffer);

		outSteam.close();
		// inStream.close();
		return outSteam.toByteArray();
	}

    private static String printHexBinary(byte[] data) {  
        StringBuilder r = new StringBuilder(data.length * 2);  
        for (byte b : data) {  
            r.append(hexCode[(b >> 4) & 0xF]);  
            r.append(hexCode[(b & 0xF)]);  
        }  
        System.out.println(r.toString());
        return r.toString();  
    }
}
