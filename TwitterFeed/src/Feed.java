import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class Feed {
	private final int max = 5;

	public static void main(String[] args) {

		try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("xrtg2BLMfV2PqYQ09xkyi71PO")
        	  .setOAuthConsumerSecret("xhOoFH4ylqhzIN7eYxDOcy7jtdxSDeAOqmIrL88pafBPkbikAB")
        	  .setOAuthAccessToken("1054735667387944961-VbzzgJw2jo9aqZArnpukvcrjEomhed")
        	  .setOAuthAccessTokenSecret("gvAYN5vTVe46melv6THlI5Yc0GRDxIeaqrH7c0oX3IDcU");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	Twitter twitter = tf.getInstance();        		
            List<Status> statuses = twitter.getHomeTimeline();
            Post(twitter);
            System.out.println("------------------------\n Showing home timeline \n------------------------");
    		int counter=0;
    		int counterTotal = 0;
            for (Status status : statuses) {
				// Filters only tweets from user "catarina"
            	//&& status.getUser().getName().contains("catarina"
				if (status.getUser().getName() != null ) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
            }
    		System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
        } catch (Exception e) { System.out.println(e.getMessage()); }
			
		

		
	}

//	private static void Post(String newStatus) {
//		// The factory instance is re-useable and thread safe.
//		Twitter twitter = TwitterFactory.getSingleton();
//		Status status = null;
//		try {
//			status = twitter.updateStatus(newStatus);
//		} catch (TwitterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Successfully updated the status to [" + status.getText() + "].");
//
//	}

	
	private static void Post(Twitter twitter){
        
		try {
			
			Status	status = twitter.updateStatus("11wer23t");
			 System.out.println("Successfully updated the status to [" + status.getText() + "].");
//		        System.exit(0);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		
	}
	private static void ReadTimeline() {
		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = null;
		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Showing home timeline.");
		for (Status status : statuses) {
			for (int i = 0; i < 5; i++) {
				System.out.println(status.getUser().getName() + ":" + status.getText());

			}

		}
	}

}
