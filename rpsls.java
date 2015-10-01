import java.util.Scanner;
import java.util.Random;

public class rpsls{

	public static int userScore=0;
	public static int computerScore=0;
	public static Scanner userInput = new Scanner(System.in);
	public static String userChoice;
	public static String computerChoice;
	public static int round=1;


	public static void main(String[] args){
		//print welcome message
		System.out.println("Welcome to RPSLS!");		
		//Start a new game 
		game();
	}

	//play gamephases
	public static void game(){
		System.out.println("Round "+round);
		promptUser();
		pcChoice();
		System.out.println("You chose "+userChoice);
		System.out.println("Computer chose "+computerChoice);
	    //call the compare function
		compare(userChoice,computerChoice);
		round++;
		retry();
	    
	}

	//prompt User
	public static void promptUser(){
		System.out.println("Do you choose Rock(r), Paper(p), Scissors(s), Lizard(l) or Spock(sp)? ");		
		userChoice = userInput.next();
		userChoice = userChoice.toUpperCase();

		switch(userChoice){
	        case "R":
	    	    userChoice="ROCK";
	    	    break;
	        case "P":
	    	    userChoice="PAPER";
	    	    break;
	        case "S":
	    	    userChoice="SCISSORS";
	    	    break;
	    	case "L":
	    		userChoice="LIZARD";
	    		break;
	    	case "SP":
	    		userChoice="SPOCK";
	    		break;
	        default:
	     	   break;
    	}
	}

	//computer makes a random choice
	public static void pcChoice(){
		Random rand = new Random();
		int  computerRand = rand.nextInt(5);
		
		switch(computerRand){
			case 0:
			computerChoice = "ROCK";
			break;
			case 1:
			computerChoice = "PAPER";
			break;
			case 2:
			computerChoice= "SCISSORS";
			break;
			case 3:
			computerChoice= "LIZARD";
			break;
			case 4:
			computerChoice= "SPOCK";
			break;
		}
	}

	//define retry method
	public static void retry(){
		System.out.println("");
		System.out.println("Do you want to play again? ");	
		String answer = userInput.next();
		answer = answer.toUpperCase();

        if(answer.equals("NO")|| answer.equals("N")){
            System.out.println("You scored: "+userScore);
		    System.out.println("Computer scored: "+computerScore);
		    System.out.println("Game Over.");
		    System.exit(0);

        }else if(answer.equals("YES") || answer.equals("Y")){
        	//keep playing
        	System.out.println("--------------------------------------------------");
        	game();
        }else{
        	System.out.println("Choose YES or NO:");
        	retry();
        }
	} 

	//define comparing method
	public static void compare(String choice1, String choice2){
	    if(choice1.equals(choice2)){
	    	System.out.println("The result is a tie!");
	    }
	    if (choice1.equals("ROCK")){
	    	switch(choice2){
	    		case "SCISSORS":
	    			System.out.println( "Rock crushes Scissors!");
	            	userScore++;
	            	break;
	            case "PAPER":
	            	System.out.println( "Paper covers Rock!");
	            	computerScore++;
	            	break;
	            case "LIZARD":
	            	System.out.println( "Rock crushes Lizard!");
	            	userScore++;
	            	break;
	            case "SPOCK":
	            	System.out.println( "Spock vaporizes Rock!");
	            	computerScore++;
	            	break;
	    	}
	    }else if(choice1.equals("PAPER")){
	    	switch(choice2){
	    		case "SCISSORS":
	    			System.out.println( "Scissors cuts Paper!");
	            	computerScore++;
	            	break;
	            case "ROCK":
	            	System.out.println( "Paper covers Rock!");
	            	userScore++;
	            	break;
	            case "LIZARD":
	            	System.out.println( "Lizard eats Paper!");
	            	computerScore++;
	            	break;
	            case "SPOCK":
	            	System.out.println( "Paper disproves Spock!");
	            	userScore++;
	            	break;
	    	}
	    }else if(choice1.equals("SCISSORS")){
	    	switch(choice2){
	    		case "Paper":
	    			System.out.println( "Scissors cuts Paper!");
	            	userScore++;
	            	break;
	            case "ROCK":
	            	System.out.println( "Rock crushes Scissors!");
	            	computerScore++;
	            	break;
	            case "LIZARD":
	            	System.out.println( "Scissors decapitates Lizard!");
	            	userScore++;
	            	break;
	            case "SPOCK":
	            	System.out.println( "Spock smashes Scissors!");
	            	computerScore++;
	            	break;
	    	}
	    }else if(choice1.equals("LIZARD")){
	    	switch(choice2){
	    		case "SCISSORS":
	    			System.out.println( "Scissors decapitates Lizard!");
	            	computerScore++;
	            	break;
	            case "ROCK":
	            	System.out.println( "Rock crushes Lizard!");
	            	computerScore++;
	            	break;
	            case "PAPER":
	            	System.out.println( "Lizard eats Paper!");
	            	userScore++;
	            	break;
	            case "SPOCK":
	            	System.out.println( "Lizard poisons Spock!");
	            	userScore++;
	            	break;
	    	}
	    }else if(choice1.equals("SPOCK")){
	    	switch(choice2){
	    		case "SCISSORS":
	    			System.out.println( "Spock smashes Scissors!");
	            	userScore++;
	            	break;
	            case "ROCK":
	            	System.out.println( "Spock vaporizes Rock!");
	            	userScore++;
	            	break;
	            case "LIZARD":
	            	System.out.println( "Lizard poisons Spock!");
	            	computerScore++;
	            	break;
	            case "PAPER":
	            	System.out.println( "Paper disproves Spock!");
	            	computerScore++;
	            	break;
	    	}
	    }else{
	    	System.out.println("Invalid Choice! You cannot choose "+choice1+". Retry.");
	        game();
	    }
	}
}