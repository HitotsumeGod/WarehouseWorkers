package main.java;

class Scribe implements Runnable {

	private Warehouse warehouse;
	private int lastSizeBox;
	private int lastSizeBundle;
	private int currentSizeBox;
	private int currentSizeBundle;
	private final String COLOR_RESET = "\u001B[0m";
	private final String GREEN = "\u001B[42m";
	private final String RED = "\u001B[41m";
	
	public Scribe() {
	
		warehouse = Warehouse.getInstance();
		lastSizeBox = 0;
		lastSizeBundle = 0;
	
	}

	public void run() {
	
		while (true) {
		
			currentSizeBox = warehouse.getSize("Box");
			if (currentSizeBox > lastSizeBox) {
				System.out.println(GREEN + (currentSizeBox - lastSizeBox) + " boxes have been added." + COLOR_RESET);
				System.out.println(GREEN + "Warehouse contains " + currentSizeBox + " boxes." + COLOR_RESET);
			} else if (currentSizeBox < lastSizeBox) {
				System.out.println(GREEN + (lastSizeBox - currentSizeBox) + " boxes have been removed." + COLOR_RESET);
				System.out.println(GREEN + "Warehouse contains " + currentSizeBox + " boxes." + COLOR_RESET);
			}
			lastSizeBox = currentSizeBox;
			currentSizeBundle = warehouse.getSize("Bundle");
			if (currentSizeBundle > lastSizeBundle) {
				System.out.println(RED + (currentSizeBundle - lastSizeBundle) + " bundles have been added." + COLOR_RESET);
				System.out.println(RED + "Warehouse contains " + currentSizeBundle + " bundles." + COLOR_RESET);
			} else if (currentSizeBundle < lastSizeBundle) {
				System.out.println(RED + (lastSizeBundle - currentSizeBundle) + " bundles have been removed." + COLOR_RESET);
				System.out.println(RED + "Warehouse contains " + currentSizeBundle + " bundles." + COLOR_RESET);
			}
			lastSizeBundle = currentSizeBundle;
			
			/*try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		
	}
	
}
