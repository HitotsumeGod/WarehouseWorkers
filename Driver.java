public class Driver {

	public static void main(String[] args) {
	
		Track boxes = new Track(Exports.BOXES);
		Track bundles = new Track(Exports.BUNDLES);
		if (!(boxes.getTrackStatus()) || !(bundles.getTrackStatus()))
			System.exit(0);
		new Thread(new Scribe()).start();
		new Thread(boxes.getTrackBuilder()).start();
		new Thread(boxes.getTrackTerminator()).start();
		new Thread(bundles.getTrackBuilder()).start();
		new Thread(bundles.getTrackTerminator()).start();
	
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
