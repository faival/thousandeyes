package thousandeyes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TweeterController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("tweets")
	@ResponseBody
	public String tweets(@RequestParam(value="name", defaultValue="") String name, Model model) {
		
		model.addAttribute("tweets", this.getTweetListForName(name));
		return model.toString();
	}
	
	private List<TweetEntity> getTweetListForName(String name) {
		TweetEntity oneTweet = new TweetEntity(counter.incrementAndGet(), String.format(template, name));
		List<TweetEntity> listOfTweets = new ArrayList<TweetEntity>();
		listOfTweets.add(oneTweet);
		return listOfTweets;
	}
}
