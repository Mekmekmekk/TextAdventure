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
               System.out.println("The available commands are: go, grab, drop, inspect, move");
                break;
        }
    }
    
    
    public void move(Command command){
        String printString = "Moving ";
        String thingToMove = null;
        
        countUno = (countUno + 1) % 9;
        countDos = (countDos + 1) % 9;
        countTres = (countTres + 1) % 9;
        
        
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
            System.out.println("The Table opens wide, and a item rises from the center. The Combat Sigil. Key 1/3");
        }
        
        if(command.getSecondWord().equals("counterOne")){
            countUno = (countUno + 1) % 9;
            System.out.println("You move the first counter. The stone shows: " + countUno);
        }
        else if(command.getSecondWord().equals("counterTwo")){
            countDos = (countDos + 1) % 9;
            System.out.println("You move the second counter. The stone shows" + countDos);
        }
        else if(command.getSecondWord().equals("counterThree")){
            countTres = (countTres + 1) % 9;
            System.out.println("You move the third counter. The stone shows" + countTres);
            
        if (countUno == 8 && countDos == 0 && countTres == 8) {
        	System.out.println("The wall opens, a small pillar holding a Sigil stands. You grab the sigil");
        	player.setItem("SorcerySigil", sorcerySigil);
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

