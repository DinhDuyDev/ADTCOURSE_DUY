import java.util.Scanner;
public class Main {
    public static String playerOrgName;
    public static String enemyOrgName;
    public static void main(String args[]) {

        /*
         *  Creating the game
         */
        /*
         *  Creating an input system
         */

        String[] namesList = {
            "Hexacorp",
            "The Lombardo's",
            "Luxocorp",
            "Syn. Co",
            "Mark&Stetson's",
            "Quadrocorp"
        };

        // Setup input system
        Scanner scanner = null;
        scanner = new Scanner(System.in);
    

        WorldMap world = new WorldMap();
        boolean RUNNING = true;
        String unused_title = " ________       ___    ___ ________   ________  ___  ________  ________  _________  _______      \n" + //
                        "|\\   ____\\     |\\  \\  /  /|\\   ___  \\|\\   ___ \\|\\  \\|\\   ____\\|\\   __  \\|\\___   ___\\\\  ___ \\     \n" + //
                        "\\ \\  \\___|_    \\ \\  \\/  / | \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\ \\  \\___|\\ \\  \\|\\  \\|___ \\  \\_\\ \\   __/|    \n" + //
                        " \\ \\_____  \\    \\ \\    / / \\ \\  \\\\ \\  \\ \\  \\ \\\\ \\ \\  \\ \\  \\    \\ \\   __  \\   \\ \\  \\ \\ \\  \\_|/__  \n" + //
                        "  \\|____|\\  \\    \\/  /  /   \\ \\  \\\\ \\  \\ \\  \\_\\\\ \\ \\  \\ \\  \\____\\ \\  \\ \\  \\   \\ \\  \\ \\ \\  \\_|\\ \\ \n" + //
                        "    ____\\_\\  \\ __/  / /      \\ \\__\\\\ \\__\\ \\_______\\ \\__\\ \\_______\\ \\__\\ \\__\\   \\ \\__\\ \\ \\_______\\\n" + //
                        "   |\\_________\\\\___/ /        \\|__| \\|__|\\|_______|\\|__|\\|_______|\\|__|\\|__|    \\|__|  \\|_______|\n" + //
                        "   \\|_________\\|___|/                                                                            ";
        String used_title = " _____ ______   ________  ________          _____ ______   _______   ________   _________  ________  ___       ___  _________    ___    ___ \n" + //
                        "|\\   _ \\  _   \\|\\   __  \\|\\   __  \\        |\\   _ \\  _   \\|\\  ___ \\ |\\   ___  \\|\\___   ___\\\\   __  \\|\\  \\     |\\  \\|\\___   ___\\ |\\  \\  /  /|\n" + //
                        "\\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\|\\ /_       \\ \\  \\\\\\__\\ \\  \\ \\   __/|\\ \\  \\\\ \\  \\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\    \\ \\  \\|___ \\  \\_| \\ \\  \\/  / /\n" + //
                        " \\ \\  \\\\|__| \\  \\ \\  \\\\\\  \\ \\   __  \\       \\ \\  \\\\|__| \\  \\ \\  \\_|/_\\ \\  \\\\ \\  \\   \\ \\  \\ \\ \\   __  \\ \\  \\    \\ \\  \\   \\ \\  \\   \\ \\    / / \n" + //
                        "  \\ \\  \\    \\ \\  \\ \\  \\\\\\  \\ \\  \\|\\  \\       \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\ \\  \\\\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\____\\ \\  \\   \\ \\  \\   \\/  /  /  \n" + //
                        "   \\ \\__\\    \\ \\__\\ \\_______\\ \\_______\\       \\ \\__\\    \\ \\__\\ \\_______\\ \\__\\\\ \\__\\   \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\ \\__\\   \\ \\__\\__/  / /    \n" + //
                        "    \\|__|     \\|__|\\|_______|\\|_______|        \\|__|     \\|__|\\|_______|\\|__| \\|__|    \\|__|  \\|__|\\|__|\\|_______|\\|__|    \\|__|\\___/ /     \n" + //
                        "                                                                                                                               \\|___|/     ";

        System.out.println(unused_title);
        System.out.println("\n\nPress ENTER to proceed!");
        scanner.nextLine();
        System.out.print("Name of your organization: ");
        playerOrgName = scanner.nextLine();
        while (playerOrgName == "") {
            System.out.print("Please enter a valid name: ");
            playerOrgName = scanner.nextLine();
        }
        System.out.print("Choose the type of organization (1) - Syndicate, (2) - Society (3) - Crew: ");

        // Syndicate
        Person playerBoss = new Boss (Utilities.random(WorldMap.side - 1), Utilities.random(WorldMap.side - 1));//(8, 8);
        Organization playerSyndicate = new Syndicate(playerBoss, playerOrgName);

        int orgType = scanner.nextInt();
        while (orgType > 3 || orgType < 1) {
            System.out.print("Choose again: ");
            orgType = scanner.nextInt();
        }
        if (orgType == 1) {
            playerSyndicate = new Syndicate(playerBoss, playerOrgName);
        } else if (orgType == 2) {
            playerSyndicate = new Society(playerBoss, playerOrgName);
        } else if (orgType == 3) {
            playerSyndicate = new Crew(playerBoss, playerOrgName);
        }
        enemyOrgName = namesList[Utilities.random(namesList.length - 1)];
        
        /*
         *  Creating the player 
         */
        UserInterface player = new UserInterface(playerSyndicate);
        String[] syndicateCommands = playerSyndicate.functions;

        /*
         * AI
         */
        Person enemyBoss = new Boss (Utilities.random(WorldMap.side - 1), Utilities.random(WorldMap.side - 1));
        Organization enemySyndicate = new Syndicate(enemyBoss, enemyOrgName);
        
        int dice = Utilities.random(3);
        while (dice < 1 || dice > 3) {
            dice = Utilities.random(3);
        }
        if (orgType == 1) {
            enemySyndicate = new Syndicate(enemyBoss, enemyOrgName);
        } else if (orgType == 2) {
            enemySyndicate = new Society(enemyBoss, enemyOrgName);
        } else if (orgType == 3) {
            enemySyndicate = new Crew(enemyBoss, enemyOrgName);
        }

        AI enemyAI = new AI(enemySyndicate);

        playerSyndicate.updateOnMap();
        enemySyndicate.updateOnMap();

        WorldMap.updateWorldMap();
        
        String[] command;
        String input;
        while (RUNNING) {
            // Available commands 

            /*
             * PLAYER BLOCK
             */
            if (playerSyndicate.returnType() == "MAP")  
            {
                player.actionPoint = playerSyndicate.getAllPersons().length + 1;
                player.settled = true;
            }
            player.isTurn = true;
            while (player.isTurn) {
                WorldMap.updateWorldMap();
                WorldMap.printWorld();
                WorldMap.show_enemies = true;
                System.out.println(" ");
                System.out.println("AVAILABLE COMMANDS:  -------------");
                for (String function : playerSyndicate.functions) {
                    System.out.println("      " + function);
                }
                System.out.println("-------------------------");
                
                System.out.print("INPUT > ");
                input = scanner.nextLine();
                command = player.getCommand(input);
                if (Utilities.array_contains(syndicateCommands, command[0])) {
                    System.out.println("Output: ----------------------------");
                    System.out.println("");
                    System.out.println("");
                    player.matchCommand(command);

                    if (playerSyndicate.returnType() == "MAP") {
                        playerSyndicate.checkDefunct();
                        if (playerSyndicate.getDefunct()) {
                            player.lost = true;
                            player.isTurn = false;
                        }
                    }
                    if (player.settled) {
                        System.out.println("");
                        System.out.println("AP: " + player.actionPoint);
                    }
                    System.out.println("");
                    if (player.errorMessage != null) {
                        System.out.println(">>> " + player.errorMessage);
                    }
                    scanner.nextLine();
                } else {
                    System.out.println(">>> The command is not applicable for this particlular organization.");
                    scanner.nextLine();
                }
                playerSyndicate.updateOnMap();
                if (player.actionPoint <= 0 && player.settled) {
                    player.isTurn = false;
                    System.out.println(">>> You have run out of action points!\nYour turn has ended.");
                    player.startTurn();
                }
            }

            enemySyndicate.checkDefunct();
            if (enemySyndicate.getDefunct()) {
                enemyAI.lost = true;
            }

            if (enemyAI.lost) {
                WorldMap.printWorld();
                System.out.println("----------------------------------------------------");
                System.out.println("You won!");
                System.out.println("You have wiped out " + enemyOrgName);
                RUNNING = false;
                break;
            }

            /*
             * ENEMY AI BLOCK
             */
            System.out.println(enemyOrgName + " is doing something...");
            scanner.nextLine();
            enemyAI.act();
            enemySyndicate.updateOnMap();
            scanner.nextLine();

            playerSyndicate.checkDefunct();
            if (playerSyndicate.getDefunct()) {
                player.lost = true;
            }

            if (player.lost) {
                WorldMap.printWorld();
                System.out.println("----------------------------------------------------");
                System.out.println("You have lost! Your organization has been wiped out.");
                RUNNING = false;
                break;
            }
            Utilities.space_out(50);
        }

        /*
         *  Closing the game and the scanner
         */
        scanner.close();
        
    } 
}