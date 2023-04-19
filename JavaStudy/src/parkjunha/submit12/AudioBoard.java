package parkjunha.submit12;

public class AudioBoard extends Board {

	private String audio;
	
	public AudioBoard() {
		
	}
	
	public AudioBoard(int num, String name, String day, String nayong, String audio) {
		super(num, name, day, nayong);
		this.audio = audio;
	}
	@Override
	public String toString() {
		return "AudioBoard [num=" + super.getNum() + ", name=" + super.getName() + ", day=" + super.getDay() + ", nayong=" + super.getNayong() + ", audio=" + audio
				+ "]";
	}

	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
}
