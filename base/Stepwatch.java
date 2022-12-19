package base;

public class Stepwatch {
	protected double mCurrentTime;
	protected double mLastTime;
	protected double mElapsedTime;

	public double tick() {
		if (this.mCurrentTime == 0.0D) {
			this.mLastTime = this.mCurrentTime = (double) System.currentTimeMillis();
		} else {
			this.mCurrentTime = (double) System.currentTimeMillis();
		}

		this.mElapsedTime = (this.mCurrentTime - this.mLastTime) / 1000.0D;
		this.mLastTime = this.mCurrentTime;
		return this.mElapsedTime;
	}
}
