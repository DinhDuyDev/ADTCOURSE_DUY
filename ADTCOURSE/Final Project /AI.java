public class AI {
    public int actionPoints;
    public Person boss;
    public Organization organization;
    public boolean lost;

    public AI(Organization org) {
        actionPoints = 0;
        organization = org;
        lost = false;
    }

    
    public void act() {
        int randomIndex = Utilities.random(100);
        if (randomIndex < 50) { // spawning or creating members
            int randomPersonnelID = Utilities.random(100);
            while (organization.getPerson(randomPersonnelID) == null) {
                randomPersonnelID = Utilities.random(100);
            }
            boss = organization.getPerson(randomPersonnelID);
            int spawnX = Utilities.random(WorldMap.side - 1);
            int spawnY = Utilities.random(WorldMap.side - 1);
            if (organization.returnType().compareTo("TREE") == 0) {
                actionPoints = boss.children.size() + 1;
                for (int i = 0; i < actionPoints; i ++) {
                    while (Utilities.pointDistance(boss.xCoordinate, boss.yCoordinate, spawnX, spawnY) > 4 || WorldMap.personMap[spawnY][spawnX] != null) {
                        spawnX = Utilities.random(WorldMap.side - 1);
                        spawnY = Utilities.random(WorldMap.side - 1);
                    }
                    organization.addPerson(boss, new Person(spawnX, spawnY));
                    organization.updateOnMap();
                }
            } else {
                actionPoints = organization.getAllPersons().length;
                for (int i = 0; i < actionPoints; i ++) {
                    while (Utilities.pointDistance(boss.xCoordinate, boss.yCoordinate, spawnX, spawnY) > 4 || WorldMap.personMap[spawnY][spawnX] != null) {
                        spawnX = Utilities.random(WorldMap.side - 1);
                        spawnY = Utilities.random(WorldMap.side - 1);
                    }
                    organization.addPerson(new Person(spawnX, spawnY));
                    organization.updateOnMap();;
                }
            }
         } else { // attacking 
            int randomPersonnelID = Utilities.random(100);
            
            while (organization.getPerson(randomPersonnelID) == null) {
                randomPersonnelID = Utilities.random(100);
            }
            boss = organization.getPerson(randomPersonnelID);
            actionPoints = boss.children.size() + 1;

            int attackX = Utilities.random(WorldMap.side - 1);
            int attackY = Utilities.random(WorldMap.side - 1);
            for (int i = 0; i < actionPoints; i ++) {
                while (Utilities.pointDistance(boss.xCoordinate, boss.yCoordinate, attackX, attackY) > 4) {
                    attackX = Utilities.random(WorldMap.side - 1);
                    attackY = Utilities.random(WorldMap.side - 1);
                }
                Person attackedPerson = WorldMap.personMap[attackY][attackX];
                if (attackedPerson != null) {
                    if (attackedPerson.myOrganization != organization) {
                        Organization attackedOrg = attackedPerson.myOrganization;
                        attackedOrg.removePerson(attackedPerson);
                        WorldMap.deadPeople.add(attackedPerson);
                        System.out.println("-------------------------------------------");
                        System.out.println("Trioptinum attacked! A member of yours is dead!\nDead member's ID: " + attackedPerson.personId);
                        System.out.println("-------------------------------------------");
                        return;
                    }
                } 
            }
            System.out.println(organization.name + " attacked " + actionPoints + " times. " + "None of your personnel was harmed.");
            System.out.println("");
        }
    }

    /*public static void main(String[] args) {
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
        System.out.println(AI.random(100));
    }*/
}