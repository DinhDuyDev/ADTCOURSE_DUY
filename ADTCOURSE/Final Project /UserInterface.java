public class UserInterface {
    public boolean lost;
    public int actionPoint;
    public Organization organization;
    public String command;
    public Person bossSelected;
    public boolean settled;
    public String errorMessage;
    public boolean actionSuccess;
    public boolean isTurn;


    public UserInterface(Organization org) {
        organization = org;
        actionPoint = 0;
        command = "";
        bossSelected = null;
        settled = false;
        lost = false;
        isTurn = true;
    }

    public String[] getCommand(String command) {
        return command.split(" ");
    }

    public void startTurn() {
        actionPoint = 0;
        command = "";
        bossSelected = null;
        settled = false;
        errorMessage = null;
        if (organization.returnType() == "MAP") {
            actionPoint = organization.getAllPersons().length;
        }
    }

    public void matchCommand(String[] command) {
        String action = command[0];
        if (action.compareTo("PRINT-ORGANIZATION") == 0) {
            organization.printOrganization();
            actionSuccess = true;
            errorMessage = null;
            return;
        } else if (action.compareTo("SELECT-BOSS") == 0) {
            if (command.length != 2) {
                errorMessage = "Haven't included the exact number of arguments: <boss-id>";
                return;
            }
            if (!settled) {
                int bossID = Integer.parseInt(command[1]);
                Person boss = organization.getPerson(bossID);
                if (boss == null) {
                    errorMessage = "No boss with said ID is found";
                    return;
                }
                bossSelected = boss;
                System.out.println("#------------------------------#");
                System.out.println("        You have selected the boss: " + bossSelected);
                System.out.println(".       Here is the boss' children: " + organization.getChildren(bossSelected));
                System.out.println("#------------------------------#");
                actionSuccess = true;
                errorMessage = null;
            } else {
                errorMessage = "You have already settled on a boss!";
            }
        } else if (action.compareTo("SETTLE") == 0) {
            if (bossSelected == null) {
                errorMessage = "You have not selected a boss yet!";
                return;
            }
            settled = true;
            actionPoint = bossSelected.children.size() + 1;
            errorMessage = null;
            System.out.println("#------------------------------#");
            System.out.println("        You have settled the boss: " + bossSelected);
            System.out.println("        You now have AP: " + actionPoint);
            System.out.println("#------------------------------#");
            actionSuccess = true;
            isTurn = true;

        } else if (action.compareTo("RECRUIT-SUBORDINATE-AT") == 0) {
            if (command.length != 3) {
                errorMessage = "Haven't given exact arguments: <x>, <y>";
                return;
            }
            if (settled) {
                int x = Integer.parseInt(command[1]);
                int y = Integer.parseInt(command[2]);

                if (!WorldMap.isInBound(x, y)) {
                    errorMessage = "Coordinates are out of bounds!";
                    return;
                }
                if (!WorldMap.isEmpty(x, y)) {
                    errorMessage = "There is something obstructing movement at: (" + x + ", " + y + ")";
                    return; 
                }
                if (Utilities.pointDistance(bossSelected.xCoordinate, bossSelected.yCoordinate, x, y) > 4) {
                    errorMessage = "Distance from the boss is too high! Can only spawn at maximum 4 units.";
                    return;
                }
                Person newPerson = new Person(x, y);
                organization.addPerson(bossSelected, newPerson);
                System.out.println("#--------------------------------------#");
                System.out.println(" You have added a person: " + newPerson);
                organization.printOrganization();
                System.out.println("#--------------------------------------#");
                organization.updateOnMap();
                actionPoint --;
                actionSuccess = true;
                errorMessage = null;
            } else {
                errorMessage = "You have not settled on a boss to recruit a new person with!";
                return;
            }
        } else if (action.compareTo("ATTACK-AT") == 0) {
            if (command.length != 4) {
                errorMessage = "Haven't specified the exact arguments: <subordinate to attack with>, <attack-x> <attack-y>";
                return;
            }
            if (settled) {
                int id = Integer.parseInt(command[1]);
                Person selectedChild = null;
                boolean found = false;
                for (Person child : organization.getChildren(bossSelected)) {
                    if (child.personId == id) {
                        selectedChild = child; 
                        found = true;
                    }
                }
                if (!found) {
                    errorMessage = "A subordinate with id " + id + " cannot be found";
                    return;
                }

                int x = Integer.parseInt(command[2]);
                int y = Integer.parseInt(command[3]);
                if (!WorldMap.isInBound(x, y)) {
                    errorMessage = "Coordinates are out of bounds!";
                    return;
                }
                if (Utilities.pointDistance(selectedChild.xCoordinate, selectedChild.yCoordinate, x, y) > 4) {
                    errorMessage = "Distance of attack should be lower than 4 units";
                }
                Person attackedPerson = WorldMap.personMap[y][x];
                if (attackedPerson != null) {
                    Organization attackedOrg = attackedPerson.myOrganization;
                    attackedOrg.removePerson(attackedPerson);
                    WorldMap.deadPeople.add(attackedPerson);
                    System.out.println("#-----------------------------------------------------------#");
                    System.out.println("    Killed enemy syndicate member! Attacked person's ID: " + attackedPerson.personId);
                    System.out.println("    Attacked syndicate: " + attackedOrg.name);
                    if (attackedOrg == organization) {
                        System.out.println("Why the hell did you attack yourself?");
                    }
                    System.out.println("#-----------------------------------------------------------#");
                    attackedOrg.updateOnMap();
                    errorMessage = null;
                } else {
                    System.out.println("No one has been killed! You missed!");
                }
                actionPoint --;
            } else {
                errorMessage = "You have not settled on a boss!";
            }
        } else if (action.compareTo("RECRUIT-MEMBER-AT") == 0) {
            if (command.length != 3) {
                errorMessage = "Have to include parameters: <x> <y>";
                return;
            }
            int x = Integer.parseInt(command[1]);
            int y = Integer.parseInt(command[2]);
            Person headMember = organization.head;
            if (!WorldMap.isInBound(x, y)) {
                errorMessage = "The coordinates are not in bound";
                return;
            }
            if (Utilities.pointDistance(headMember.xCoordinate, headMember.yCoordinate, x, y) > 4) {
                errorMessage = "Too far away from the society's head to be created";
                return;
            }
            Person newMember = new Person(x, y);
            organization.addPerson(newMember);
            System.out.println("#--------------------------------------#");
            System.out.println(" You have added a person: " + newMember);
            organization.printOrganization();
            System.out.println("#--------------------------------------#");
            organization.updateOnMap();
            actionPoint --;
            errorMessage = null;
        } else if (action.compareTo("SOCIETY-ATTACK-AT") == 0) {
            if (command.length != 3) {
                errorMessage = "Has to have 2 arguments: <x> and <y>";
                return;
            }
            int x = Integer.parseInt(command[1]);
            int y = Integer.parseInt(command[2]);

            Person headMember = organization.head;

            if (!WorldMap.isInBound(x, y)) {
                errorMessage = "Coordinates are out of bound!";
                return;
            }

            if (Utilities.pointDistance(headMember.xCoordinate, headMember.yCoordinate, x, y) > 4) {
                errorMessage = "Coordinates are too far from the boss to attack!";
                return;
            }
            Person attackedPerson = WorldMap.personMap[y][x];
            if (attackedPerson != null) {
                Organization attackedOrg = attackedPerson.myOrganization;
                attackedOrg.removePerson(attackedPerson);
                WorldMap.deadPeople.add(attackedPerson);
                errorMessage = null;
                System.out.println("#-----------------------------------------------------------#");
                System.out.println("    Killed syndicate member! ID: " + attackedPerson.personId);
                System.out.println("    Attacked syndicate: ID: " + attackedOrg.name);
                if (attackedOrg == organization) {
                    System.out.println("Why the hell did you attack yourself?");
                }
                System.out.println("#-----------------------------------------------------------#");
                attackedOrg.updateOnMap();
                errorMessage = null;
            } else {
                System.out.println("No one was killed! You missed!");
                errorMessage = null;
            }
            actionPoint --;
        } else if (action.compareTo("KILL-BOSS") == 0) {
            organization.removePerson(organization.getHead());
            errorMessage = null;
            return;
        } /* else if (action.compareTo("ROLL-ITEM") == 0) {
            int dice = Utilities.random(100);
            if (dice <= 5) {
                System.out.println("You rolled an airstrike!");
                int x;
                int y;
                int bombed_times = 0;
                for (int i = 0; i < 180; i ++) {
                    x = Utilities.random(WorldMap.side - 1);
                    y = Utilities.random(WorldMap.side - 1);
                    Person attackedPerson = WorldMap.personMap[y][x];
                    if (attackedPerson != null) {
                        Organization attackedOrg = attackedPerson.myOrganization;
                        if (attackedOrg != organization) {
                            attackedOrg.removePerson(attackedPerson);
                            WorldMap.deadPeople.add(attackedPerson);
                            bombed_times ++;
                        }
                    }
                }
                System.out.println("Bombed " + bombed_times + " enemies!");
            } else if (dice > 5 && dice <= 30) {
                System.out.println("You rolled a telescope");
                System.out.println("All enemies are visible");
                WorldMap.show_enemies = true;
            } else {
                System.out.println("You rolled no items!");
            }
        }*/ 
        else if (action.compareTo("END-TURN") == 0) {
            errorMessage = null;
            actionPoint = 0;
            return;
        }
    }
}
