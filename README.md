# MowerSimulator

A simple Mower modelisation system written in java.

It use maven as software project management, Junit5 for the testing path and log4j2 for the loggin part.


## usage

A file must be provided as an argument, this file must contains the initial configuration of the system.

5 5<br/>
1 2 N<br/>
GAGAGAGAA<br/>
3 3 E<br/>
AADAADADDA<br/>

The first line represent the height and the width of the garden<br/>
  As an example, the garden got a width and a height of 5.<br/>

The second line is the initial position of the first mower.<br/>
  In this case the mower is initially on this position (X = 1 Y = 2 and it got a north direction).<br/>

The third line represents the instruction the mower must follow.<br/>
  G => turn left<br/>
  D => turn right<br/>
  A => move forward<br/>

## How to launch it ?

  you need to install all the depencies by typing "mvn install" in your terminal.<br/>
  Then, you have to package the project by typing "mvn package" still in your terminal.<br/>
  Finally to run it :<br/>
    mvn exec:java -D exec.mainClass=Sys.Main -D exec.args=path_to_file

