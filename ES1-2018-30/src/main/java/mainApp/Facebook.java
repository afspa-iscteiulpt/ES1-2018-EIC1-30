package mainApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;

import ES1_30_2018.models.FacebookPostModel;

/**
 * This class allows one to see their own (with the provided token, the author's) posts on their facebook page's Timeline
 * 
 * @author Grupo 30 ES1 2018/19 ISCTE
 *
 */

@SuppressWarnings("deprecation")
public class Facebook {
	
	 /**
	  * Access token for the author's facebook page
	  * Necessary to get from https://developers.facebook.com/tools/explorer/ for a different user
	  */
	//Access Token expires on Fri Jan 25 22:00:28 GMT 2019
	private static final String accessToken = "EAAfZAZCAZBIvq8BAJQDLmlw0wCQvpxZBg7ikDFWgA3ITcFtSGMoWy50rI8a15JzKzNDY18tsGHVTocIllbdTvNIF08v7HmDpGQjpNZAvnWCj8kPyG9KwNWcweZBnOxsfnNw3sxZCFLTd41m3ieCkCP192M6ZAzcQcZC4ZD\r\n";
	
	
	ArrayList<FacebookPostModel> facebookPosts = new ArrayList<FacebookPostModel>();
	
	/**
	 * FacebookClient object	
	 */
	private FacebookClient fbClient;
	
	/**
	 * User object
	 */
	private User me;
	
	/**
	 * Basic constructor that initializes the FacebookClient and User objects through use of the provided Access Token
	 */
	public Facebook() {
		
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
	 */
	public void printTimelinePosts() {
		
		System.out.println("My Posts:\n");
		Connection<Post> res = fbClient.fetchConnection("me/feed", Post.class);
		int aux = 1;
		
		for(List<Post> page : res) {
			
			for(Post aPost : page) {
				
				facebookPosts.add(new FacebookPostModel("fb.com/" + aPost.getId(), aPost.getMessage()));
				//contador
				aux++;
				
			}
			
		}
		
	}
	
	/**
	 * Method that allows the user to post a message in the timeline of one of his/her groups.
	 */
	public void postTimeline() {
		
		Connection<Group> res = fbClient.fetchConnection("me/groups", Group.class);
		Scanner input = new Scanner(System.in);
		
		for(List<Group> groupPage : res) { //grupos em que estamos inseridos (o user)
			
			for(Group aGroup : groupPage) {
				
				System.out.println("Do you want to post in "+ aGroup.getName() +"? Yes/No");
				String ans = input.nextLine();
				
				if(ans.equalsIgnoreCase("Yes")) { //acao botao publish no facebook
					
					System.out.println("What do you want to post?");
					String msg = input.nextLine();
					FacebookType post = fbClient.publish(aGroup.getId() +"/feed", FacebookType.class, Parameter.with("message", msg));//"message" é o tipo; msg é a mensagem a ser publicada
					System.out.println("fb.com/"+ post.getId());
					
				}
				
			}
			
		}
		
	}
	
	/**
	 * The main method initializes a FacebookReader object and runs printMyPosts()
	 * @param args
	 */
	public static void main(String[] args) {	
		
		Facebook fb = new Facebook();
		fb.printTimelinePosts();
		fb.postTimeline();
			
	}

}

