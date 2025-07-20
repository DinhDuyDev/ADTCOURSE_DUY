To use the proram: 
+ First, run the java program using the command line.
+ Then, add the      .tsv file for article names as your first argument.   
                    + .tsv file for links as your second argument (this will be the file denoting the direct connections between each + + Wikipedia articles).
                    + Name of the article you start from.
                    + Name of the article you want to arrive at.
+ Example: java PathFinder.java {--article-file--} {--links-file--} {--staring-article--} {--destination-article--}
+ Press enter to see an array of articles you have to go through to get to the article you want.

Example:
+ javac PathFinder.java -> compile the program.
+ java PathFinder.java articles.tsv links.tsv Terrorism Bruce_Springsteen
+ Results: [Terrorism, 19th_century, 21st_century, U2, Bruce_Springsteen]

Note: *If there is not a path, the result would be: "There isn't a path"*