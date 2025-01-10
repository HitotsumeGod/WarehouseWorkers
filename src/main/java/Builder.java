package main.java;

class Builder implements Runnable {

	private final Warehouse warehouse;
	private final Exports exports;

	public Builder(Exports e) {
	
		this.warehouse = Warehouse.getInstance();
		this.exports = e;
	
	}

	public void run() {
	
		switch (exports) {
		
		case BOXES:
			while (true) {
			
				warehouse.addBox(new Box());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
		case BUNDLES:
			while (true) {
			
				warehouse.addBundle(new Bundle());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
		
		}
	
	}

}
