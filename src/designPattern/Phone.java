package designPattern;

public class Phone {
	String OS;
	int ram;
	String processor;
	int screenSize;
	int battery;

//	public Phone(String oS, int ram, String processor, int screenSize, int battery) {
//		OS = oS;
//		this.ram = ram;
//		this.processor = processor;
//		this.screenSize = screenSize;
//		this.battery = battery;
//	}

	Phone(PhoneBuilder phonebuilder) {
		OS = phonebuilder.OS;
		this.ram = phonebuilder.ram;
		this.processor = phonebuilder.processor;
		this.screenSize = phonebuilder.screenSize;
		this.battery = phonebuilder.battery;
	}

	@Override
	public String toString() {
		return "Phone [OS=" + OS + ", ram=" + ram + ", processor=" + processor + ", screenSize=" + screenSize
				+ ", battery=" + battery + "]";
	}

	public static class PhoneBuilder {
		String OS;
		int ram;
		String processor;
		int screenSize;
		int battery;

		public PhoneBuilder(String OS) {
			this.OS = OS;
		}

		public PhoneBuilder setRam(int ram) {
			this.ram = ram;
			return this;
		}

		public PhoneBuilder setProcessor(String processor) {
			this.processor = processor;
			return this;
		}

		public PhoneBuilder setScreenSize(int screenSize) {
			this.screenSize = screenSize;
			return this;
		}

		public PhoneBuilder setBattery(int battery) {
			this.battery = battery;
			return this;
		}

		public Phone getPhone() {
			return new Phone(this);
		}
	}
}
