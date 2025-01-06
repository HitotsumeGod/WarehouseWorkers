import java.util.ArrayList;

class Warehouse {

	private boolean security;
	private boolean delCommand;
	private ArrayList<Box> boxArr;
	private ArrayList<Bundle> bundleArr;
	private static final Warehouse instance = new Warehouse();
	
	private Warehouse() {
	
		security = false;
		boxArr = new ArrayList<>();
		bundleArr = new ArrayList<>();
	
	}
	
	public synchronized void addBox(Box box) {
	
		boxArr.add(box);
	
	}
	
	public synchronized void addBundle(Bundle bundle) {
	
		bundleArr.add(bundle);
	
	}
	
	public synchronized Object getObj(String type, int index) {
	
		switch (type) {
		
		case "Box":
			return boxArr.get(index);
		case "Bundle":
			return bundleArr.get(index);
		
		}
		return null;
	
	}
	
	public synchronized ArrayList<?> getList(String type) {
	
		switch (type) {
		
		case "Box":
			return boxArr;
		case "Bundle":
			return bundleArr;
		
		}
		return null;
	
	}
	
	public int getSize(String type) {
	
		switch (type) {
		
		case "Box":
			return boxArr.size();
		case "Bundle":
			return bundleArr.size();
	
		}
		return 0;
	}
	
	public boolean getSecurity() {
	
		return security;
	
	}

	public void setDelCom(boolean delCom) {

		this.delCommand = delCom;

	}

	public boolean getComStatus() {

		return delCommand;

	}
	
	public static Warehouse getInstance() {
	
		return instance;
	
	}

}
class Box {}
class Bundle {}
