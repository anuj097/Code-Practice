package com.java.lld.design.pattern;

interface Button {
	public void render();
}

interface TextBox {
	public void display();
}

class DarkButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering the button in dark mode");
	}
}

class LightButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering the button in light mode");
	}
}

class DarkTextBox implements TextBox {
	@Override
	public void display() {
		System.out.println("Display the Text Box in Dark mode");	
	}
}

class LightTextBox implements TextBox {
	@Override
	public void display() {
		System.out.println("Display the Text Box in Light mode");	
	}
}

interface UIFactory {
	Button creatButton();
	TextBox createTextBox();
}

class DarkThemeFactory implements UIFactory {

	@Override
	public Button creatButton() {
		return new DarkButton();
	}

	@Override
	public TextBox createTextBox() {
		return new DarkTextBox();
	}
}

class LightThemeFactory implements UIFactory {

	@Override
	public Button creatButton() {
		return new LightButton();
	}

	@Override
	public TextBox createTextBox() {
		return new LightTextBox();
	}
}


public class AbstractFactoryDpExample {

	public static void main(String[] args) {
		UIFactory factory = new DarkThemeFactory();
		Button button = factory.creatButton();
		TextBox box = factory.createTextBox();
		button.render();
		box.display();
		
		factory = new LightThemeFactory();
		Button button1 = factory.creatButton();
		TextBox box1 = factory.createTextBox();
		button1.render();
		box1.display();

	}

}
