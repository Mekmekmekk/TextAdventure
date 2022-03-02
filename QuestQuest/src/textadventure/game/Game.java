package textadventure.game;

public class Game{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private CLS cls_var;
    
    int countUno;
    int countDos;
    int countTres;
    int code;
    
    public Game(){
        parser = new Parser();
        player = new Player();
    }
    
    public static void main(String[] args){
        Game game = new Game();
        game.setupGame();
        game.play();
    }
    
    
    public void printInformation() {
        System.out.println(currentRoom.getExitString());
        System.out.println(currentRoom.getShortDescription());
        System.out.println(currentRoom.getInventoryString());
        System.out.println(player.getInventoryString());
    }
    
    public void printInformationLong() {
        System.out.println(currentRoom.getLongDescription());
    }
    
    
    public void setupGame(){
        Room entrance = new Room("entrance", "You are in the entrance.", "The entrance of the libray, There are cobwebs and dust everywhere.");
        Room crossRoads = new Room("crossroads","You enter the Cross Roads.", "The Crossroads, There is a crystal fountain in the center. The fountain has still water, and the crystal is dull and not illuminating.");
        Room combatBranch = new Room("combatbranch","You enter the Combat Branch.", "A room full of weapons. It has every weapon you could think of, and each made of a variety of materials. At the center stands a round table with text and statues of knights holding swords.");
        Room sorceryBranch = new Room("sorcerybranch","You enter the Sorcery Branch.", "A room lined with bookshelves, shelves with potions and materials");
        Room historyBranch = new Room("historybranch","You enter the History Branch.", "Long");
        Room secretTreasury = new Room("treasury","You enter the a Secret Treasury.", "Long");
        
        Item fountain = new Item("fountain", "A crystal fountain, water still, the crystal lays illuminated. There are slots on the fountain");
        
        Item swordOne = new Item("swordOne", "A grand longsword");
        Item swordTwo = new Item("swordTwo", "A grand longsword");
        Item swordThree = new Item("swordThree", "A grand longsword");
        Item swordFour = new Item("swordFour", "A grand longsword");
        Item swordFive = new Item("swordFive", "A grand longsword");
        Item swordSix = new Item("swordSix", "A grand longsword");
        Item tableText = new Item("tabletext", "'The tables of old, the Knights of Clover. The luckiest knights of all.'");
        
        Item counterOne = new Item("counterOne", "A old tablet that rolls to numbers between 1 to 9");
        Item counterTwo = new Item("counterTwo", "A old tablet that rolls to numbers between 1 to 9");
        Item counterThree = new Item("counterThree", "A old tablet that rolls to numbers between 1 to 9");
        
        Item booka = new Item("combatTactics" ,"Upon further inspection, nothing is off about the book.");
        Item bookb = new Item("loveAndLoss", "Just a normal Romance novel... Nope wait.. Its a key.. (Use 'move' on this)");
        Item bookc = new Item("arcaneAndYou","Just a beginners guide to magic.");
        Item bookd = new Item("howT----", "You look at the book closer, it says how to be the best bard.");
        Item booke = new Item("ho------", "The books name is scratched out, you read the book. Its just says horses over and over.");
        Item bookf = new Item("iAmASecretKey", "Its a hollowed out book, inside is a spider family. They wave to you, and you return them back to their spot in the bookshelf.");
        Item bookg = new Item("killerGreens", "A book on what plants can and will kill you.");
        
        Room paintingOne = new Room("paintingOne", "A painting... I think", "A painting of a war, a war of dragons vs the combined power of Humans, Orcs, Elves, all you can imagine. The year is stamped 472 Common Era.");
        Room paintingTwo = new Room("paintingTwo", "A painting... I think", "A painting of a an abstract, but important point in time for Emon. The birth of magic, the first spell caster to introduce the lands to magic. Was this a good thing? The year is stamped 23 Common Era.");
        Room paintingThree = new Room("paintingThree", "A painting... I think", "A painting of a diplomat, a very large and stoic looking man. Seems to be a General, considered a hero. The year is stamped 531 Common Era.");
        
        
        
        entrance.setExit("crossroads", crossRoads);
        crossRoads.setExit("entrance", entrance);
        crossRoads.setExit("combatbranch", combatBranch);
        crossRoads.setExit("sorcerybranch", sorceryBranch);
        crossRoads.setExit("historybranch", historyBranch);
        combatBranch.setExit("crossroads", crossRoads);
        sorceryBranch.setExit("crossroads", crossRoads);
        historyBranch.setExit("crossroads", crossRoads);
        secretTreasury.setExit("historybranch", historyBranch);
        
        combatBranch.setItem("swordOne", swordOne);
        combatBranch.setItem("swordTwo", swordTwo);
        combatBranch.setItem("swordThree", swordThree);
        combatBranch.setItem("swordFour", swordFour);
        combatBranch.setItem("swordFive", swordFive);
        combatBranch.setItem("swordSix", swordSix);
        combatBranch.setItem("tabletext", tableText);
        
        sorceryBranch.setItem("counterOne", counterOne);
        sorceryBranch.setItem("counterTwo", counterTwo);
        sorceryBranch.setItem("counterThree", counterThree);
        
        historyBranch.setItem("combatTactics", booka);
        historyBranch.setItem("loveAndLoss", bookb);
        historyBranch.setItem("arcaneAndYou", bookc);
        historyBranch.setItem("howT----", bookd);
        historyBranch.setItem("ho----", booke);
        historyBranch.setItem("iAmASecretKey", bookf);
        historyBranch.setItem("killerGreens", bookg);

        
        crossRoads.setItem("fountain", fountain);
        try{
            cls_var.main();
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        currentRoom = entrance;        
        System.out.println("████████▄   ███    █▄     ▄████████    ▄████████     ███      ████████▄   ███    █▄     ▄████████    ▄████████     ███     ");
        System.out.println("███    ███  ███    ███   ███    ███   ███    ███ ▀█████████▄  ███    ███  ███    ███   ███    ███   ███    ███  ▀█████████▄ ");
        System.out.println("███    ███  ███    ███   ███    █▀    ███    █▀     ▀███▀▀██   ███    ███  ███    ███   ███    █▀    ███    █▀      ▀███▀▀██ ");
        System.out.println("███    ███  ███    ███  ▄███▄▄▄       ███            ███   ▀   ███    ███  ███    ███  ▄███▄▄▄       ███             ███   ▀ ");
        System.out.println("███    ███  ███    ███ ▀▀███▀▀▀     ▀███████████   ███       ███    ███  ███    ███ ▀▀███▀▀▀     ▀██████████      ███     ");
        System.out.println("███    ███  ███    ███   ███    █▄             ███   ███       ███    ███  ███    ███   ███    █▄           ███       ███     ");
        System.out.println("███  ▀ ███  ███    ███   ███    ███    ▄█     ███   ███       ███  ▀ ███  ███    ███   ███    ███    ▄█    ███       ███     ");
        System.out.println(" ▀██████▀▄█ ████████▀    ██████████  ▄████████▀▄████▀      ▀██████▀▄█ ████████▀   ██████████ ▄████████▀     ▄████▀   ");
        System.out.println("type 'play'  to start");
        
        play();
        printInformation();
        }
    
        public void play() {
        while(true) {            
        Command command = parser.getCommand(); 
        try {
            cls_var.main(); 
        }catch(Exception e) {
            System.out.println(e); 
        }
        processCommand(command);
        printInformation();   
        }
    }
    
    public void processCommand(Command command){
        String commandWord = command.getCommandWord().toLowerCase();
        
        switch(commandWord) {
            case"speak":
                System.out.println("you wanted me to speak " + command.getSecondWord());
                break;
            case"go":
                goRoom(command);
                break;
            case"grab":
                grab(command);
                break;
            case"drop":
                drop(command);
                break;
            case"inspect":
                inspect(command);
                break;
            case"move":
                move(command);
                break;
            case"help":
               System.out.println("The available commands are: go, grab, drop, inspect, move. Type 'help' and a command for more info");
                break;
            case"help go":
            	System.out.println("You go to a room. This room must be listed as an exit in your current room.");
            	break;
            case"help grab":
            	System.out.println("You grab an item, and the item will go into your inventory. This item must be in your current room.");
            	break;
            case"help drop":
            	System.out.println("You drop an item that is currently in your inventory. This will put said item in your current room and leave it there.");
            	break;
            case"help inspect":
            	System.out.println("You inspect an object, getting a more detailed description on the item. These are most likely hints to the puzzle.");
            	break;
            case"help move":
            	System.out.println("Moving is different from go. To move is to move an object, changing it in a way. This is your main action to solving puzzles.");
            	break;
            	
        }
    }
    
    
    public void move(Command command){
        String printString = "Moving ";
        String thingToMove = null;
        
        
        Item combatSigil = new Item("CombatSigil", "A golden cylinder with white marble like stone, and a red gem at one end. It looks like it can be inserted somewhere familiar.");
        Item sorcerySigil = new Item("SorcerySigil", "A golden cylinder with white marble like stone, and a red gem at one end. It looks like it can be inserted somewhere familiar.");
        Item historySigil = new Item("HistorySigil", "A golden cylinder with white marble like stone, and a red gem at one end. It looks like it can be inserted somewhere familiar.");
        Item treasurySigil = new Item("TreasurySigil", "A golden cylinder with white marble like stone, and a red gem at one end. It looks like it can be inserted somewhere familiar.");
        
        if(!command.hasSecondWord()){
            System.out.println("Move what?");
            return;
        }
        
        if(!command.hasLine()){
            thingToMove = command.getSecondWord();
        }
        else if(command.hasLine()){
            thingToMove = command.getSecondWord()+command.getLine();
        }
        
        
        
        if(command.getSecondWord().equals("swordFour")){
            player.setItem("CombatSigil", combatSigil);
            System.out.println("The Table opens wide, and a item rises from the center. The Combat Sigil. Key 1/4");
        }
        
        if(command.getSecondWord().equals("counterOne")){
            countUno = (countUno + 1) % 9;
            System.out.println("You move the first counter. The stone shows: " + countUno);
            System.out.println("CounterOne: " + countUno);
            System.out.println("CounterOne: " + countDos);
            System.out.println("CounterOne: " + countTres);
        }
        else if(command.getSecondWord().equals("counterTwo")){
            countDos = (countDos + 1) % 9;
            System.out.println("You move the second counter. The stone shows" + countDos);
            System.out.println("CounterOne: " + countUno);
            System.out.println("CounterOne: " + countDos);
            System.out.println("CounterOne: " + countTres);
        }
        else if(command.getSecondWord().equals("counterThree")){
            countTres = (countTres + 1) % 9;
            System.out.println("You move the third counter. The stone shows" + countTres);
            System.out.println("CounterOne: " + countUno);
            System.out.println("CounterOne: " + countDos);
            System.out.println("CounterOne: " + countTres);
            
        if (countUno == 8 && countDos == 0 && countTres == 8) {
        	System.out.println("The wall opens, a small pillar holding a Sigil stands. You grab the sigil. Sorcery Sigil. Key 2/4");
        	player.setItem("SorcerySigil", sorcerySigil);
        }
        	
        if(thingToMove.equals("loveAndLoss")) {
        	player.setItem("HistorySigil", historySigil);
        	System.out.println("You mess with the book, the next sigil appears out of the book with a spell, and a riddle comes out with it. The History Sigil. Key 3/4");
        }    
        }
        
        
    }
    
    
    public void inspect(Command command){
        String printString = "Looking at ";
        String thingToInspect = null;
        if(!command.hasSecondWord()){
            System.out.println("Inspect what?");
            return;
        }
        if(!command.hasLine()){
            thingToInspect = command.getSecondWord();
        }
        else if(command.hasLine()){
            thingToInspect = command.getSecondWord()+command.getLine();
        }

        
        if(thingToInspect.equals(currentRoom.getName())) {
            printString += "the room: " + currentRoom.getName() + "\n" + currentRoom.getLongDescription();
        }
        else if(currentRoom.getItem(thingToInspect) != null) {
            printString += "the item:" + currentRoom.getItem(thingToInspect).getName() + "\n" + currentRoom.getItem(thingToInspect).getDescription();
        }
        else if(player.getItem(thingToInspect) != null) {
            printString += "the item " + player.getItem(thingToInspect).getName() + "\n" + player.getItem(thingToInspect).getDescription();
        }
        else {
            printString += "\nYou can't inspect that";
        }
        System.out.println (printString);
    }
    
    public void grab(Command command){
        String item = null;
        if(!command.hasSecondWord()){
            System.out.println("Grab what");
        }
        
        if(!command.hasLine()){
            item = command.getSecondWord();
        }
        else if(command.hasLine()){
            item = command.getSecondWord()+command.getLine();
        }
        
        if(command.getSecondWord().equals("fountain")){
            System.out.println("You can't pick up the fountain");
            return;
        }
        
        Item itemToGrab = currentRoom.removeItem(item);
        if(itemToGrab == null){
            System.out.println("You can't grab that");
        }
        else{
            player.setItem(item, itemToGrab);
        }
    }
    
    public void drop(Command command){
        String item = null;
        if(!command.hasSecondWord()){
            System.out.println("Drop what");
        }
        if(!command.hasLine()){
            item = command.getSecondWord();
        }
        else if(command.hasLine()){
            item = command.getSecondWord()+command.getLine();
        }
        
        Item itemToGrab = player.removeItem(item);
        if(itemToGrab == null){
            System.out.println("You can't drop that");
            return;
        }
        else{
            player.setItem(item, itemToGrab);
        }
        
        printInformation();
    }
    
    public void goRoom(Command command) {
        String direction = "";
        if(!command.hasSecondWord()){
            System.out.println("Go where?");
        }
        if(!command.hasLine()){
            direction = command.getSecondWord();
        }
        else if(command.hasLine()){
            direction = command.getSecondWord()+command.getLine();
        }
        
        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom == null){
            System.out.println("You can't go there");
        }
        else{
            currentRoom = nextRoom;
        }
        
        printInformation();
        System.out.println("Don't forget to inspect for clues");
    }

}

