package twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class Feed {
	private static TwitterFactory tf;
	private static Twitter twitter;

	public static void main(String[] args) {

		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
					/**
					 * as seguintes linhas servem para colocar manualmente os
					 * access tokens
					 */
					.setOAuthConsumerKey("il6jvwc2vms3WL7HO4UgU7jS6")
					.setOAuthConsumerSecret("xBkc4nD1da7QaQ1ewYP3dpTLSxiebNTZT6vwauZfXJQxnUyRqP")
					.setOAuthAccessToken("1054735667387944961-iTiBwVRaWeg5UjZZOzMXLiY1nNv9bX")
					.setOAuthAccessTokenSecret("VWsGwG071SLENhDOOxH0yFH5NcVuWlH3KFCeGmxQZuJf6");
			tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();
			// long id= 1067477199232614405L;
			// Fav( id);

			ReadTimeline();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @param twitter
	 *            serve para ir buscar a API
	 * @param newStatus
	 *            o string com o novo estado a funcao envia um novo tweet com a
	 *            mensagem em status
	 * 
	 */
	public static void Post(String newStatus) {

		try {

			Status status = twitter.updateStatus(newStatus);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");
			// System.exit(0);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * mostra os tweets na timeline do utlizador caso os autores nao sejam null
	 */
	public static Map ReadTimeline() {
		List<Status> statuses = new ArrayList<Status>();
		Map<String, String> map = new HashMap<String, String>();
		

		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Showing home timeline.");
	
	for (Status status : statuses) {

			if (status.getUser().getName() != null) {
				String name=status.getUser().getName();
				String text=status.getText();
				map.put(name,text);

							System.out.println(name + ":" + text);
							System.out.println(map);

			}}
	
	return map;

	}

	private static void Retweet(Long tweetId) {
		try {
			twitter.retweetStatus(tweetId);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Fav(long tweetId) {
		try {
			Status status = twitter.createFavorite(tweetId);

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String reply(Long tweetId, String message) throws TwitterException {
		Status status = twitter.showStatus(tweetId);
		Status reply = twitter.updateStatus(new StatusUpdate(" @" + status.getUser().getScreenName() + " " + message)
				.inReplyToStatusId(status.getId()));
		return Long.toString(reply.getId());
	}

	// private static void Reply(Twitter twitter, Long tweetId, String reply) {
	// try {
	// StatusUpdate statusUpdate = new StatusUpdate(reply);
	// statusUpdate.tweetId = tweetId;
	// Status status = twitter.updateStatus(statusUpdate);
	//
	// } catch (TwitterException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}