import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Warehouse warehouse = Warehouse.getInstance();
		Track boxes = new Track(Exports.BOXES);
		Track bundles = new Track(Exports.BUNDLES);
		if (!(boxes.getTrackStatus()) || !(bundles.getTrackStatus()))
			System.exit(0);
		Thread TS = new Thread(new Scribe());
		Thread t1B = new Thread(boxes.getTrackBuilder());
		Thread t1T = new Thread(boxes.getTrackTerminator());
		Thread t2B = new Thread(bundles.getTrackBuilder());
		Thread t2T = new Thread(bundles.getTrackTerminator());
		Thread[] tArr = new Thread[] {TS, t1B, t1T, t2B, t2T};
		for (Thread t1 : tArr)
			t1.start();
		while (true) {
			
			if (scan.nextLine().charAt(0) == 'K') {
				System.exit(0);
			} else if (scan.nextLine().charAt(0) == 'D') {
				warehouse.setDelCom(true);
			}
		
		}
	
	}

}
class Track {

	private Exports exports = null;
	private Builder builder = null;
	private Terminator terminator = null;
	
	public Track(Exports e) {
	
		
		this.exports = e;
		this.builder = new Builder(exports);
		this.terminator = new Terminator(exports);
	
	}
	
	public Builder getTrackBuilder() {
	
		return builder;
	
	}
	
	public Terminator getTrackTerminator() {
	
		return terminator;
	
	}
	
	public boolean getTrackStatus() {
	
		if (!(exports.equals(null)))
			if (!(builder.equals(null)))
				if (!(terminator.equals(null)))
					return true;
		return false;
	
	}

}
enum Exports {BOXES, BUNDLES}
