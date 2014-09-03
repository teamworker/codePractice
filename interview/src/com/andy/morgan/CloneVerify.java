package com.andy.morgan;

import java.util.Date;
import java.util.HashMap;

/**
 * 验证Clone的用法
 * 
 * @date May 8, 2014--9:42:32 AM
 * @author Andy
 */
public class CloneVerify {

	public static void main(String[] args) throws CloneNotSupportedException {
		/*
		 * 对于只包含基本字段和对不变对象引用的类，直接调用super.clone()即可
		 */
		Paper paper = new Paper("white", 0.07, 7);
		Paper secondPaper = paper.clone();
		secondPaper.setColor("black");
		System.out.println("original paper color : "+paper.getColor());
		System.out.println("copy paper color : "+secondPaper.getColor());
		
		System.out.println("\n__________________________________________");
		
		/*
		 * 当类对其他对象有引用时(或者这里对其他对象的引用理解有错误)
		 */
		Engine engine = new Engine();
		engine.setCompany("Benz");
		Light light = new Light();
		light.setModel("127");
		Tyre tyre = new Tyre();
		tyre.setCount(4);
		
		Car car = new Car(engine, light, tyre);
		Car secondCar = car.clone();
		Light newLight = new Light();
		newLight.setModel("277");
		secondCar.setLight(newLight);
		
		System.out.println("original car :\n 1. Engine : "+
		car.getEngine().getCompany()+"\n 2. Tyre : "+car.getTyre().getCount()+ 
		"\n 3. Light : "+ car.getLight().getModel());
		
		System.out.println("copy car :\n 1. Engine : "+
				secondCar.getEngine().getCompany()+"\n 2. Tyre : "+secondCar.getTyre().getCount()+ 
				"\n 3. Light : "+ secondCar.getLight().getModel());
		
		/*
		 * 数组、hashMap等其他情况
		 */
		HashMap<String, Car> map = new HashMap<String, Car>();
		HashMap<String, Car> secondMap = new HashMap<String, Car>();
		map.put("original", car);
		secondMap = (HashMap<String, Car>) map.clone();
		System.out.println(secondMap.get("original").getEngine().getCompany());
		secondMap.put("original", secondCar);
		System.out.println(secondMap.get("original").getEngine().getCompany());
	}

}

/*
 * 只包含基本字段和对不变对象的引用的类（Paper没有对不变对象的引用）
 */
class Paper implements Cloneable {
	private String color;
	private double weight;
	private int pages;

	@Override
	public Paper clone() throws CloneNotSupportedException {
		return (Paper) super.clone();
	}

	public Paper() {
	}

	public Paper(String color, double weight, int pages) {
		this.color = color;
		this.weight = weight;
		this.pages = pages;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}

/*
 * 对其他对象有引用
 */
class Car implements Cloneable{
	private Engine engine;
	private Light light;
	private Tyre tyre;
	
	@Override
	protected Car clone() throws CloneNotSupportedException {
		return (Car) super.clone();
	}

	public Car() {}

	public Car(Engine engine, Light light, Tyre tyre) {
		this.engine = engine;
		this.light = light;
		this.tyre = tyre;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

}

class Engine {
	private String company;
	private Date madeDate;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getMadeDate() {
		return madeDate;
	}

	public void setMadeDate(Date madeDate) {
		this.madeDate = madeDate;
	}
}

class Light {

	private String brand;
	private String model;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}

class Tyre {
	private float weight;
	private int count;

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}