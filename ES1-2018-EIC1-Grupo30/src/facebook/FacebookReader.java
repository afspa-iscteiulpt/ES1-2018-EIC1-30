package facebook;

import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;

/**
 * This class allows one to see their own (with the provided token, the author's) posts on their facebook page's Timeline
 * 
 * @author Grupo 30 ES1 2018/19 ISCTE
 *
 */

@SuppressWarnings("deprecation")
public class FacebookReader {
	
	 /**
	  * Access token for the author's facebook page
	  * Necessary to get from https://developers.facebook.com/tools/explorer/ for a different user
	  */
	//Access Token expires on Fri Jan 25 22:00:28 GMT 2019
	String accessToken = "EAAfZAZCAZBIvq8BAJwOIC0ZAJxMXQJoJ06ESDcykp1bsb7kZBuHAwWq8rRITjNZBKxHUCquxmrPrrbwAjsH2FKoCHu2RLqNO7oQ8ReZAKqVFvdeyRlRlmXnhh1zy8FlZA6My2ZB4VxD9GGC9Dr79hnZCwS7ZBCIUEvwpUslFoxKBS5jFJyfVeZAtHE7e";
	
	/**
	 * FacebookClient object	
	 */
	FacebookClient fbClient;
	
	/**
	 * User object
	 */
	User me;
	
	/**
	 * Basic constructor that initializes the FacebookClient and User objects through use of the provided Access Token
	 */
	public FacebookReader() {
		
		fbClient = new DefaultFacebookClient(accessToken);
		me = fbClient.fetchObject("me" , User.class);
		
	}
	
	/**
	 * Used to get all the user's posts in the timeline, though it's mostly a test to make sure the timeline isn't empty
	 * @return res The user's timeline posts
	 */
	public Connection<Post> getMyPosts() {
		
		Connection<Post> res = fbClient.fetchConnection("me/feed",Post.class);
		return res;
	
	}
	
	/**
	 * Method that prints out the user's Timeline posts (more specifically, it shows the message, id and date of creation)
	 * It does not show images or other attachments that aren't text
	 * And there is a faioled attempt at showing the likes and comments as well (there are always 2 null lines in each post due to this)
	 */
	public void printMyPosts() {
		
		System.out.println("My Posts:\n");
		Connection<Post> res = fbClient.fetchConnection("me/feed", Post.class);
		int aux = 1;
		
		for(List<Post> page : res) {
			
			for(Post aPost : page) {
				
				System.out.println("Post " + aux + ":");
				System.out.println("ID: fb.com/" + aPost.getId());
				System.out.println(aPost.getMessage());
				System.out.println(aPost.getCreatedTime());
				System.out.println(aPost.getLikes());
				System.out.println(aPost.getComments());
				System.out.println("\n");
				aux++;
				
			}
			
		}
		
	}
	
	
	/**
	 * The main method initializes a FacebookReader object and runs printMyPosts()
	 * @param args
	 */
	public static void main(String[] args) {	
		
		FacebookReader fb = new FacebookReader();
		fb.printMyPosts();
		System.out.println(fb.getMyPosts());
			
	}

}
