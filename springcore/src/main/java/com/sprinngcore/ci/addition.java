package com.sprinngcore.ci;

public class addition {

	
	private int a;
	private int b;
	
	
	public addition(int a,int b) {
		this.a=a;
		this.b=b;
		System.out.println("constructor : int ,int");
	}
	public addition(String a,String b) {
		this.a=Integer.parseInt(a);
		this.b=Integer.parseInt(b);
		System.out.println("constructor : string ,string");
	}
	public addition(double a,double b) {
		this.a=(int)a;
		this.b=(int)b;
		System.out.println("constructor : double,double");
	}
	
	public void dosum() {
		System.out.println("value of a ="+this.a);
		System.out.println("value of b ="+this.b);
		
		System.out.println("sum is " + (this.a +this.b));
	}
}
