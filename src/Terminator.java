class Terminator implements Runnable {

	private final Warehouse warehouse;
	private final Exports exports;
	private int lastSizeBox;
	private int lastSizeBundle;

	public Terminator(Exports e) {
	
		warehouse = Warehouse.getInstance();
		exports = e;
		lastSizeBox = 0;
		lastSizeBundle = 0;
	
	} 

	private boolean checkDelCom() {

		if (warehouse.getComStatus())
			return true;
		return false;

	}
	
	private boolean boxScanner() {
	
		if (warehouse.getSize("Box") > lastSizeBox + 1) {
			lastSizeBox = warehouse.getSize("Box");
			return true;
		}
		return false;
	
	}
	
	private boolean bundleScanner() {
	
		if (warehouse.getSize("Bundle") > lastSizeBundle + 2) {
			lastSizeBundle = warehouse.getSize("Bundle");
			return true;
		}
		return false;
	
	}

	public void run() {
	
		switch (exports) {
		
		case BOXES:
			while (true) {
				

				if (boxScanner() || checkDelCom()) {
					warehouse.getList("Box").remove(warehouse.getSize("Box") - 1);
					//System.out.println("GYATT!!");
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		case BUNDLES:
			while (true) {
		
				if (bundleScanner() || checkDelCom()) {
					warehouse.getList("Bundle").remove(warehouse.getSize("Bundle") - 1);
					lastSizeBundle = warehouse.getSize("Bundle");
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		
	}
	
}
}
