import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class Feed {
	private final int max = 5;
	private static int counter = 0;
	private static int counterTotal = 0;

	public static void main(String[] args) {

		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
					/**
					 * as seguintes linhas servem para colocar manualmente os
					 * access tokens
					 */
					.setOAuthConsumerKey("gpw74LoOI8RqKMAUmTepP73x4")
					.setOAuthConsumerSecret("h5jHurKOcUcxu3a2uWxXznCnf0b4Hwvps4DS3xVOEJsiQI2m4X")
					.setOAuthAccessToken("1054735667387944961-BR0ryCvwvrBh8XTJYIDQYKDs4gpwNB")
					.setOAuthAccessTokenSecret("nbQoXokjdaIZyQIt4kA0jzg9SGLvzGV3ODLwvZylqCIo3");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			Post(twitter, "wtf");

			/**
			 * mostra os tweets na timeline do utlizador caso os autores nao
			 * sejam null
			 */
			ReadTimeline(twitter);
			/**
			 * mostra o numero de tweets que a app le
			 * 
			 */
			System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
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
	private static void Post(Twitter twitter, String newStatus) {

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
	private static void ReadTimeline(Twitter twitter) {
		List<Status> statuses = null;

		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Showing home timeline.");

		for (Status status : statuses) {

			if (status.getUser().getName() != null) {
				System.out.println(status.getUser().getName() + ":" + status.getText());
				counter++;

			}
			counterTotal++;

		}
	}

	private static void Retweet(Twitter twitter, Long tweetId) {
		try {
			twitter.retweetStatus(tweetId);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Fav(Twitter twitter, Long tweetId) {
		try {
			Status status = twitter.createFavorite(tweetId);

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String reply(Twitter twitter, Long tweetId, String message ) throws TwitterException {
        Status status = twitter.showStatus(tweetId);
        Status reply = twitter.updateStatus(new StatusUpdate(" @" + status.getUser().getScreenName() + " "+ message).inReplyToStatusId(status.getId()));
    return Long.toString(reply.getId());
}
	
	
//	private static void Reply(Twitter twitter, Long tweetId, String reply) {
//		try {
//		  StatusUpdate statusUpdate = new StatusUpdate(reply);
//			  statusUpdate.tweetId = tweetId;
//					    Status status = twitter.updateStatus(statusUpdate);
//
//		} catch (TwitterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
