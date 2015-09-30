package thousandeyes;

public class TweetEntity {
	
	private final long tweetId;
	private final String tweetContent;
	
	public TweetEntity(long id, String content) {
		this.tweetId = id;
		this.tweetContent = content;
	}
	
	public long getTweetId() {
		return tweetId;
	}
	
	public String getTweetContent() {
		return tweetContent;
	}
}
