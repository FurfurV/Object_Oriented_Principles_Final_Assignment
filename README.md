# Object_Oriented_Principles_Final_Assignment
A command-line driven application that manages a sports team for the module SOFT7004.

## You are to create a Soccer League application as outlined below. 

A soccer league requires a player, team, manager management system. The league has several teams. Teams have several players. Teams are managed by Managers.Write an application to manage the Player, Team and Managers in such a League. We are not recording the score in matches played.

You are to write the following java classes:
1. A Name class. This stores details of a name. Both Players and Managers have names.
* firstName;                     
* middleName;                     
* lastName;

2. A Person class. This is a super class for all people in the League system. 
Its attributes are:
* Name   name;                    
* String phone;                    
* String email;

3. A Player class. This class is a subclass of person and contains Player details. It also holds the number of goals scored in the current year.
Players also have a Boolean attribute called Goalie, to indicate whether or not the player is a goalie.
If the player is a goalie, then the goals attribute indicates the number of goals scored while this goalie was defending the goal.

Operations:  
* Allow get and set goals. 
* Player may become a goalie
 
 4. A Manager class. Manager: This is a subclass of Person.  Managers have in addition to name date of birth and a star rating (1 to 10). 
 The manager knows which Team he manages.
 
 Operations:  Allow get and set rating. 
 
 5. A Team class.  This has a Manager and a collection of Players objects and the jersey colour (unique to team).
 Operations: Add, Remove Players and Manager.                     
 Only allow one Manager.
 
 6. A League class. This is your collection of Teams.
 Operations: Add remove, Teams
 
 7. Write a test class which creates a League, some Team objects, some Player/Manager objects and some Manager objects. Then adds some of the Player objects to the Teams, then give the Players some goals.
 Add Managers to Teams.  Then display all Teams, Players and Managers. Display the Team managed by a particular Manager.
 
 ## PART 2
 You are to create a UML class diagram which details all the java classes used in your application.
 
 ## PART 3
 Provide a menu (command line driven) in your Test class which has the following options:
 1.    Create a new Team, Player or Manager and add Player/Manager to a Team. 
 2.    Remove a Player.
 3.    Search for a Player by supplying the Player name. Display goals and Manager details.       
 4.    Display all players in a particular Team.
 5.    Display all Teams in the League.      
 6.    Save all information to a text file.       
 7.    Load information from a text file.       
 8.    Quit
