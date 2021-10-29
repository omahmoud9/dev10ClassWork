# GomoKu Plan

## tech requierments
* [ ] Can set up two players.
* [ ] For a human player, collect their name. (A random player's name is randomly generated.)
* [ ] For each stone placement, use the player's name to ask questions.
* [ ] Since the random player doesn't require input, the UI should display stone placement and the results of placement. (Random player placement may fail since they don't know what they're doing.)
* [ ] Re-prompt on failed placement. The game must not proceed until a player has made a valid move.
* [ ] Display the final result of the game.
* [ ] Give the option to play again.

## requierments

* [ ] All rules are modeled inside the Gomoku class. You may not modify Gomoku, Player, HumanPlayer, RandomPlayer, Stone, or Result.
* [ ] Add your code to the project provided. Be sure to use sensible class names, method names, and packages.
* [ ] At least one class beyond the App class is required.
* [ ] Stones use 0-based rows and columns.

## tasks
* [ ] Plan User experience
* [ ] Review project code
* [ ] Go over tests
* [ ] create needed classes 
* [ ] determine tracked state
* [ ] create ui package


## User experience

## set up
* [ ] print welcome to gomoku message
* [ ] prompt user for 2 players
   * [ ] player name
* [ ] Start game
  * [ ] print randomizing
  * [ ] randomizes  player color, black/white

## Game Play
* [ ] prints players name turn
* [ ] prompts for row and column
    * [ ] ensures valid move    /// IC -- check if these validations already available
        * [ ] no overlap
        * [ ] on board
* [ ] places stone              /// IC --- ...and re-draw the board here?
* [ ] checks to see if game is won/tie
* [ ] swithces player and repeats till game over

## End game
* [ ] checks to see if game wow/tie
    * [ ]  if win, prints player won
    * [ ]  if tie, print game tie, no more moves
* [ ] prompt play again
    * [ ] play again
        * [ ] empties char[][]  /// IC -- where this char[][] has been instatiated?
    * [ ] exit

## print board                
* [ ] print board
    * [ ] iterate through char[][] placing B/W  prinitng B/W at placed location

## Play turn
* [ ] display users turn
* [ ]  determine if player is human
    * [ ] if human prompt for move
    * [ ]  if random no prompt
* [ ]  if move is invlad display error and reprompt


## Stretch goales
* [ ] create a smart player
* [ ] implement opening rules
    * [ ] swap2?
