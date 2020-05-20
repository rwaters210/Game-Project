import java.util.Scanner;

class Game {
  static String beginGame = "accept";
  static String followMission = "keep";
  static String rejectMission = "give";
  static int score = 0;
  static Scanner gameScanner = new Scanner(System.in);
  public static void main(String[] args) {

    printStartGameInfo();
    
    String startAnswer = gameScanner.nextLine();
    
    while (!startAnswer.equalsIgnoreCase(beginGame)) {
      showExplosion();
      startAnswer = gameScanner.nextLine();
    }
    
    System.out.println(startGame(beginGame, startAnswer));
    
    getBrief();
        
    printFirstEncounter();
    
    System.out.println(getAnswer(followMission, rejectMission));
  
    String[] actionResults = accessArrayOutputs();
    
    printSecondEncounter();
    
    String solution = getAnswer2(actionResults, followMission, rejectMission);
    System.out.println(solution);
    
    getSituationResult(actionResults);
    
    String ride = getRide(solution, actionResults);
    System.out.println(ride);
    
    solution = getSituationResult2(ride, actionResults);
    System.out.println(solution);
    
    String escape = protectLife(solution, actionResults);
    System.out.println(escape);
    
    System.out.println(goForRide(solution, actionResults));
    
    enterPasswordInfo();
    
    getFinalShowdown();
    
    
    
    
    
    
  }
  /**
   * print introduction to game
   */
  static void printStartGameInfo() {
    //introduction to game
    System.out.printf("Welcome user, there is a special mission that we need completed.\n"
        + "Pay close attention to the directions. To find out more about this mission you must\n"
        + "enter \"accept\" correctly the first time, or this message will self destruct!!!.\n");
  }
  /**
   * shows self destruct of message with emojis.
   */
  public static void showExplosion() {
     String bomb = "💥💥💥";
     System.out.println(bomb);
     System.out.println(bomb);
     System.out.println(bomb);
     System.out.printf("It seems you have enter the wrong input. Will give you another chance.\n"
         +"Enter another answer:\n");
    score -= 1;
  }
  /**
   * start or end the game based of user's input
   * 
   * @param beginGame answer required to start game
   * @param startAnswer what the user's input
   * @return result of their input
   */
  static String startGame(String beginGame, String startAnswer) {
    if (startAnswer.equalsIgnoreCase(beginGame)) {
      startAnswer = ("Mission Accepted.");
      score += 10;
    } else {
      startAnswer = ("");
    }
    return startAnswer;
  }
  /**
   * brief you on mission
   */
  static void getBrief() {
    // brief by your boss
    System.out.printf("Your mission is to deliver this information.\n"
        +"\n"
        + "Folder is given to you to read as they brief you\n"
        +"\n"
        +"To an important person in England. You will possibly encounter\n"
        +"those who will do whatever it takes to get it but\n"
        +"you must prevent it. We depend on you to carry out this mission.\n"
        +"Now Go and complete your mission.\n"
        +"\n");
  }
  /**
   * print the first interaction with a person
   */
  static void printFirstEncounter() {
    // description of first encounter with person wanting secret info
    System.out.printf("You arrive at the airpot to travel to England.\n"
        +"You get out the cab with your luggage and walk through the doors.\n"
        +"As your in line to check in, a man dressed in a black suit apporaches you.\n"
        +"He introduces himself as Agent Smith who works for a secret defense organization\n"
        +"As expected, he inquires you about the information you hold and says he can help you.\n"
        +"Enter \"give\"to give up information or \"keep\" to keep it.\n");
    
  }
  
  
  /** provide action result based off their answer 
   * 
   * @param followMission compare to user's input to follow mission
   * @param rejectMission compare to user's input to reject mission
   * @return action in game resulted bu user's input
   */
  static String getAnswer(String followMission, String rejectMission) {
    Scanner Scanner = new Scanner(System.in);
    String answer = "";
    int value = 1;
    while (value < 2) {
      String missionAnswer = Scanner.nextLine();
      if(missionAnswer.equalsIgnoreCase(followMission)) {
        answer = ("Though you follow the mission,he warns you of danger coming\n"
            + "your way. You ignore him and proceed to catch your flight."
            + "\n");
        value++;
        score += 10;
      } else if (missionAnswer.equalsIgnoreCase(rejectMission)) {
        answer = ("You give knowledge of the information to him and he advises you to\n"
            + "board the plane. He tells you he will do his best to help with the situation.\n"
            + "You proceed to your flight.\n"
            + "\n");
        value++;
        score -= 5;
      } else {
        System.out.println("Enter \"give\" or \"keep\".");
        score -= 1;
      }
    }
    return answer;
  }
  /**
   * allows access to array for output results 
   * 
   * @return array to be used in other methods
   */
  static String[] accessArrayOutputs() {
    //use array to access and output specfic message matched to user's input  
    String[] outputs = new String[9];
    outputs[0]="Good job, you chose to be loyal to your mission but now\n"
         + "angered by your rejection, she threatens blowing up the plane\n"
         + "with the press of a button with the device she discloses.\n"
         + "What do you do? Enter \"nothing\" or \"action\".";
    outputs[1]="You gave up the secret info and now she plans to blow up\n"
        +"the plane now. she discloses to you that she recorded everything\n"
        +"and sent it to her boss. That was her mission. Now, your in big trouble\n"
        +"What do you do? Enter \"nothing\" or \"action\".";
    outputs[2]="With your skill in handling situations similar to this\n"
        +"you successfully disarm the deadly remote from her, get assistance\n"
        +"from the plane crew to put her in a closed place and you proceed to\n"
        +"interrogate her. You learn she works for a secret organization that\n"
        +"believes in terrorism and they plan to use that secret info to hurt people.\n";
    outputs[3]="Though you may think she is bluffing, the bomb goes off and kills everyone\n"
        +"including you. Your journey has ended.";
    outputs[4]="Great Job! You managed to survive and supress the enemy. Your plane\n"
        +"arrives safely in England. You proceed your mission to meet this important\n"
        +"man at a certain location. How do you want to travel \"bus\" or \"cab\"?";
    outputs[5]="You go to the bus stop and the bus arrives. You ask the driver will\n"
        +"his route take you near your rendezvous point, he replies yes, and you take\n"
        +"your seat. You get off at your stop and proceed to enter the bulding.";
    outputs[6]="You call a cab, get in, and give the person the address. As your\n"
        +"riding, you notice the person is taking you awy from the city and you were\n"
        +"briefed that the rendezvous point with the person was in the city.\n"
        +"What do you do: \"take action\" or \"ride along\".";
    outputs[7]="You asked the driver where he is going but he doesn't respond. Being\n"
        +"suspicous of his weird behaviour, you take matters into your hands. Using the\n"
        +"gadgets you contain, you use them to break open the door and jump out the car.\n"
        +"The car stops. The man gets out the car and starts to approach you\n" 
        +"How do you handle this: kill or knock out.";
    outputs[8]="You ride along until you arrive at an old warehouse. You get out and to\n"
        +"your suprise, you see Agent Smith. You proceed to talk to him to see what's going\n"
        +"on. He tells you that your mission is a set up and the rendezvous point is a trap.\n"
        +"Though, you have to see for yourself and he is offering aid for you.\n"
        +"Will you accept it: \"Yes\" or \"No\".";
    return outputs;
  }
  /**
   * print second interaction with second person
   */
  static void printSecondEncounter() {
    // description of second encounter with person wanting secret info
    System.out.printf("You board the plane and find your seat next to the window.\n"
        +"A lady comes sits next to you and you all begin to conversate.\n"
        +"She seems a little too friendly and you suspect her to want the secret info.\n"
        +"To no suprise, she brings up the thought of someone containing secret info\n"
        +"that could save her colleague's life.\n"
        +"What do you do?\n"
        +"Enter \"give\"to give up information or \"keep\" to keep it.\n");
  }
  
  /**
   * used to match user's input with specified output
   * 
   * @param outputs array that contains specified outputs
   * @param followMission the keyword to pass mission
   * @param rejectMission keywod to fail mission
   * @return the specified output from the arrays
   */
  static String getAnswer2(String[] outputs, String followMission, String rejectMission) {
    Scanner Scanner = new Scanner(System.in);
    String answer = "";
    int value = 1;
    while (value < 2) {
      String missionAnswer = Scanner.nextLine();
      if(missionAnswer.equalsIgnoreCase(followMission)) {
        answer = (outputs[0]); 
        value++;
        score += 10;
      } else if (missionAnswer.equalsIgnoreCase(rejectMission)) {
        answer = (outputs[1]);
        value++;
        score += 10;
      } else {
       System.out.println("Enter \"give\" or \"keep\".");
       score -= 1;
      }
    }
    return answer;
  }
  
  /**
   * determines specified output and ask user to input
   * 
   * @param solution answer from previos method 
   * @param outputs array used to get specified outputs
   */
  static void getSituationResult(String[] outputs) {
    int value = 0;
    while (value < 1) {
        String act = gameScanner.nextLine();
        if (act.equalsIgnoreCase("action")) {
          System.out.println(outputs[2]);
          value++;
          score += 10;
        } else if (act.equalsIgnoreCase("nothing")) {
            System.out.println(outputs[3]);
            score -= 5;
            showExplosion();
        } else {
          System.out.println("Enter \"action\" or \"nothing\".");
          score -= 1;
        }
    }
  }
  /**
   * take input from previous response and return specified answer
   * 
   * @param solution answer from previous response 
   * @param outputs used to pick specified answer from "solution" param
   * @return specified output from the array
   */
  static String getRide(String solution, String[] outputs) {
    int value = 0;
    String ride = "";
    System.out.println(outputs[4]);
    while (value < 1) {
      String action = gameScanner.nextLine();
      if (action.equalsIgnoreCase("bus")) {
        ride = (outputs[5]);
        value++;
        score += 20;
      } else if (action.equalsIgnoreCase("cab")) {
        ride = (outputs[6]);
        value++;
        score += 10;
      } else {
        System.out.println("Enter \"bus\" or \"cab\".");
        score -= 1;
      }
    }
    return ride;
  }
  /**
   * take input from previous response and return specified answer
   * 
   * @param ride answer from previous response 
   * @param outputs used to pick specified answer from "solution" param
   * @return specified output from the array
   */
  static String getSituationResult2(String ride, String[] outputs) {
    int value = 0;
    String result = "";
    if (ride.equals(outputs[6])) {
      while (value < 1) {
      String act = gameScanner.nextLine();
        if (act.equalsIgnoreCase("take action")) {
          result = (outputs[7]);
          value++;
          score += 15;
        } else if (act.equalsIgnoreCase("ride along")) {
          result = (outputs[8]);
          value++;
          score += 10;
        } else {
          System.out.println("Enter \"take action\" or \"ride along\".");
          score -= 1;
        }
      }
    }
    return result;
  }
  /**
   * take input from previous response and return specified answer
   * 
   * @param solution answer from previous response 
   * @param outputs used to pick specified answer from "solution" param
   * @return specified String output from the array
   */
  static String protectLife(String ride, String[] outputs) {
    int value = 0;
    String result = "";
    if (ride.equals(outputs[7])) {
      while (value < 1) {
      String act = gameScanner.nextLine();
        if (act.equalsIgnoreCase("kill")) {
          result = ("Quickly acting, you shoot him with your gun, take his car\n"
              +"and proceed to the rendezvous point.\n");
          value++;
          score += 5;
        } else if (act.equalsIgnoreCase("knock out")) {
          result =("You engage in hand to hand combat in which you knocked him\n"
              +"out unconscious. You take his car and go to the rendezvous point.\n");
          value++;
          score += 10;
        } else {
          System.out.println("Enter \"kill\" or \"knock out\".");
          score -= 1;
        }
      }
    }
    return result;
  }
  /**
   * take input from previous response and return specified answer
   * 
   * @param solution answer from previous response 
   * @param outputs used to pick specified answer from "solution" param
   * @return specified output from the array
   */
  static String goForRide(String ride, String[] outputs) {
    int value = 0;
    String result = "";
    if (ride.equals(outputs[8])) {
      while (value < 1) {
      String act = gameScanner.nextLine();
        if (act.equalsIgnoreCase("Yes")) {
          result = ("You accept it, and they escort you to the rendezvous point."
              +"You arrive at the bulding.\n");
          value++;
          score += 20;
        } else if (act.equalsIgnoreCase("No")) {
          result = ("Though you refuse, he gets you a ride to the rendezvous point"
              +" and he wishes you the best. You arrive at the bulding.\n");
          value++;
          score += 15;
        } else {
          System.out.println("Enter \"Yes\" or \"No\".");
          score -= 1;
        }
      }
    }
    return result;
  }
  /**
   * prompt user to computer math problem correctly to move on in mission
   */
  static void enterPasswordInfo() {
    System.out.printf("To enter the building you must input the correct answer on a device:\n"
        +"What is the number answer to  10 + 9 * 5 / 15 + 7?\n");
    float answer = 10 + 9 * 5 / 15 + 7;
    int value = 0;
    while (value < 1) {
      float inputResponse = gameScanner.nextFloat();
      if (inputResponse == answer ) {
        System.out.println("Correct!!! You may enter.");
        score += 20;
        value++;
      } else {
        System.out.println("Incorrect, Input another number!!!");
        score -= 2;
      }
    }
  }  
  /**
   * prompt user to input their final decision for the mission
   */
  static void getFinalShowdown() {
    System.out.printf("You enter the building and see the man your to meet up with\n"
        +"As you approach him, suddenly a group of soldiers surround you and it seems\n"
        +"that you were set up. The leader appears and explains that their a terrorist group\n"
        +"in which they want use the info you hold to reform the world through violent acts.\n"
        +"He wants you to be apart of it. What do you with the information?\n");
    int value = 0;
    while (value < 1) {
    String answer = gameScanner.nextLine();
      if (answer.equalsIgnoreCase("give")) {
          System.out.printf("You failed your mission and now sided with the enemy.\n"
              +"Your convinced violence will change the world. Unfortuntately, these plans\n"
              +"can't be completed. Agent Smith has been watching your actions secretly\n"
              +"and dosen't agree with your decision. Being that his job is to protect the\n"
              +"people, he sent destruction drones to the buidling your in to kill everyone.\n"
              +"Your journey has ended.\n"
              +"Final Score is: %d\n", score);
          System.exit(0);
        } else if (answer.equalsIgnoreCase("keep")) {
          System.out.printf("Good Job, prevented the enemy from gaining valuable information\n"
              +"to continue their plans. Though, how do you escape from them now? Well, Luckliy\n"
              +"Agent Smith has been watching your actions and agress with you decison. With the\n"
              +"advanced technolgy his organzation has, he saves you by elimating the enemies\n"
              +"with their deadly weapons. You learn Agent Smith was in charge of your misson\n"
              +"and was evaluating your abilties. He was impressed by your final decision\n"
              +"%s\n",showReward());
          value++;
          score += 100;
          System.out.printf("Final score is: %d\n", score);
        } else {
          System.out.println("Enter \"give\" or \"keep\".");
          score -= 1;
        }
    }
  }
  /**
   * shows the user a welcoming message with all caps
   * 
   * @return String that is fully capitalized 
   */
  static String showReward() {
    StringBuilder build = new StringBuilder();
    String reward = "Welcome to the CIA 🕴 🗂 ️👏 ✅ !!!";
    for (int i = 0; i < reward.length(); ) {
      int c = reward.codePointAt(i);
      build.appendCodePoint(c);
      int charCount = Character.charCount(c);
      i += charCount;
    }
    return build.toString();
  }
}