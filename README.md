# the_selvage_shredder - ap csa final project

you shouldn't have to install any dependencies... only uses awt and swing.

hopefully i will add a standalone executable anyways

make sure to fullscreen—the screen doesn't scale, so you won't see the whole thing if you don't

controls are space and arrow keys/wasd







# initial pseudo code (probably out of date)
//window class — esseintially just a frame and a board
// constructor — sets everything up
// run — most of the game is called here



// main class — begining of thread
// game loop 
// main menu
// game runs
// game over
// input highscore
// all of the game logic is called here



// highscore class — represents an individual run with name, date, score



// save score class — saves scores in hard memory
// save score — saves list of hiscore objects, if file does not exist, create one; if file does not, read and insert score, then clear and resave. 
// clears score — deletes file
// read score — reads score if file exists



menu class — all menus are panels; takes key detection and traverses arrays of buttons for input. Everything breaks rules for palette here
draw entity — basically handles buttons
button class - an entity that breaks palette rules for size
(un)/hilight — button changes sprite to be selected
run — a special run that returns an String corresponding to method in main based on exit conditions (ie based on button selections in menu, forks can be made in main). 



// board class — subclasses panel, implements key listener; essentially handles everything inside the window... most of the game is here, it's like the "real" main. the board is has quantised locations, like an ascii art game except it's not ascii... made this descision b/c otherwise the scale to speed up development. 
//constructor - sets everything up, initialises entities etc. (time also starts here);
//override paint component — everything gets drawn here
// get time — time is kept track here – timer begins when board constructer is called
// run — meat of what is called in the loop in main. entity behaviours, key detection, etc.
// get x/y — figureing out where to draw things on the screen relative to the quantised positions on the board
// draw entity — everything on the board can be drawn with this thanks to entity interface

// get key — player behaviour is influenced by input, hence reference is needed
// key pressed/released etc. — updates get key
// spawn obstacle — initiallises obsticles at specific but also to an extent randomized intervals
// calculate score — score based on current time
// draw score - draws scoreboard


// runnable interface — this is sort of superfluous given the scale of the program, but it is still a good idea/practice
// returns string for the purpose of relaying information to whatever calls it (ie "running", "wants to be done running", "game over" etc.)



// pallette interface — palatte is perhaps not the best name... it is the colours and "rules" for handling drawing...



//sprite class — essentially a glorified array of colours
// constructor — initialises with correct dimensions
// get + set pixel — i like these getters and setters b/c get.get/set bothers me
// fill — random tool



// player class - an ordinary entity, the only departure from the location, sprite, behaviour pattern is that it has acess to the key-detection in board
// constructor — essentially just location and sprite
// run — behaviour, key detection and physics essentially, also checks for game over
// get x/y — for telling board where to draw things
// get pixel — for telling board when and what colour to draw
// add board — get a reference to the board for key detection



// entity class — interface for everything on the screen. essentially has a location, sprite, and behaviour



// obstacle class — an entity
// run — essentially rushes forward toward player until it goes off the screen then deletes itself



// physics class — handles gravity, especially the annoyance of acceleration
// jump — gravity momentarily reversed
// fall — gravity enacted