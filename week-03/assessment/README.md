# Solar Farm Plan


## High Level Requierments
* [ ] Add a solar panel to the farm.
* [ ] Update a solar panel.
* [ ] Remove a solar panel.
* [ ] Display all solar panels in a section.

## Tech Requierments

* [ ] 3 layer architecture
* [ ] store data in a delimited file
* [ ] repos throw custom exceptions
* [ ] test repos and service with negative and postive cases
* [ ] enum for solar panel materials


## User Interface           1.5 hour
* [ ] main menu
    * [ ] Exit
    * [ ] Find Panels by Section menu
        * [ ] display all panles in section
    * [ ] Add Panel 
    * [ ] Update Panel 
        * [ ] fail if no panel is in desired location?
    * [ ] Remove Panel 
        * [ ] fail if no panel is in desired location



## Domain               1.5 hour
* [ ] Add panel
    * [ ] ensure feilds are correct
        * [ ] row 1 -250                        
        * [ ] Column 1- 250                      
        * [ ] year installed 1954 - 2021
        * [ ] Materials
            * [ ] enum, 5 types
* [ ] find by section 
    * [ ] validates section given
* [ ] update panel
    * [ ] validate section, row col given
    * [ ] validate new input given
* [ ] remove panel
    * [ ] validates panel selection



## Data Access    1.5 hour
* [ ] id, unique    
* [ ] Sections, required 

* [ ] boolean istracking 
* [ ] scans file to ensure each panel is unique
    * [ ] saves if unique, throws custom exception if not 



## Model   10 min ?
* [ ] id,section,row,coloum,material,year
* [ ] delimter : ~
* [ ] empty constructor
* [ ] constructor for existing panel
* [ ] getter and setter for all feilds 