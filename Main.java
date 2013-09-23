import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import opennlp.*;
//Cause raisins
//FORGET RAISINS, TACOS!
//ughstillAND MORE


/** 
 * Natural Language Processor
 * Takes a string and parses key words out of it, until it can 
 * query a database for information.
 * @author Jason
 */
 //need another
public class Main {
	static String[] keywords;
	static String[] questionWords;
	static String[] uselessWords;
//adding a comment
	//Take regex before splitting
	public static void main(String[] args) {
		String in = "";
//		Scanner input = new Scanner(System.in);
//		String in = input.nextLine();
		generateKeywords();
		String junkless = in.toLowerCase(); 
		junkless = parseJunk(in);
		
	}
//		String[] inParsed = in.toLowerCase().split(" ");
	
//		for (String q : questionWords) {
//			System.out.println(q + " " + in.contains(q));			
//		}
	
	public static void generateKeywords() {
		String[] qWords = {"how many", "what", "who", "when", "where"};
		String[] uWords = {"a", "an", "the"};
		//These will all need to be regexed to include plurals
		String[] kWords = {"rbi", "runs batted in", "stolen base", "sb", "batting average",
				"strike out", "strike-out", "walk", "era", "earned run average", 
				"home run", "double", "2b", "triple", "3b", "single", "1b"};
		questionWords = qWords;
		uselessWords = uWords;
		keywords = kWords;
	}
	
	/** 
	 * Replaces the trailing space and worthless articles from sentence.
	 * @param sentence
	 * @return
	 */
	public static String parseJunk(String sentence) {
		System.out.println(sentence);
		for (String word: uselessWords) {
			if (sentence.contains(word)) {
				sentence = sentence.replaceAll("\\b"+ word + " \\b", "");
			}
		}
		return sentence;
	}
	
	public static void whichQuestion(String sentence) {
		int opCode = 0;
		for (int i = 0; i < questionWords.length; i++) {
			if (sentence.contains(questionWords[i+1])) {
				opCode = i+1;
			}
		}
		
		if (opCode == 0) {
//			throw new IllegalArgumentException();
//			System.out.println("Invalid question asked!");
		}
	}
	
	public void nextStep(int opCode) {
		
	}
}
