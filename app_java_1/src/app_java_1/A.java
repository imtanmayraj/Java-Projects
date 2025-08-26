package app_java_1;

import java.io.BufferedReader;
import java.io.FileReader;
public class A {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("D://upsc//t1.txt");
			BufferedReader br = new BufferedReader(fr);
			for(int i=0;i<6;i++) {
				System.out.println(br.readLine());
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	}

