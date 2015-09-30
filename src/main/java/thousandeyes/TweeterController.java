package thousandeyes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TweeterController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("userTweets")
	public String userTweets(@RequestParam(value="nick", defaultValue="") String nick, Model model) {
		
		model.addAttribute("userTweets", this.getTweetListForNick(nick));
		return "userTeets";
	}
	
	private List<TweetEntity> getTweetListForNick(String nick) {
		TweetEntity oneTweet = new TweetEntity(counter.incrementAndGet(), String.format(template, nick));
		List<TweetEntity> listOfTweets = new ArrayList<TweetEntity>();
		listOfTweets.add(oneTweet);
		return listOfTweets;
	}
}
