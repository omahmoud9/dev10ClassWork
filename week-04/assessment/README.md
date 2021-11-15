## Sustainable Foraging

##Technical Requirements

* [ ] Spring Dependency
* [ ] Kilo/item report w/streams 
* [ ] value/categorey report w/loops
* [ ] fin math uses BigDec
* [ ] dates use LocalDate
* [ ] only test exsitng features if bugs
* [ ] test all new features


## Requierments

* [ ] Item
    * [ ] name requiered
        * [ ] name cant be duplicated
    * [ ] categorey required
    * [ ] dollar/kg required
        * [ ] between 0 and 7500
    * [ ]  item id is sstem generated

* [ ]  Foragers
    * [ ] first and last name required
    * [ ] State required...Location ie, ohio cali texas washignton
        * [ ] firstname last name and state combs cant be duplicated
    * [ ] ID is system generated

* [ ] Forages
    * [ ] item reuired and must exist
    * [ ] forager required
    * [ ] date is required and not in future
    * [ ] kilo 1-250
    * [ ] date,item,forager combos not duplacated
    * [ ] id is system genereated


## intial steps             2 hours
* [ ] look through each layer and tests and see what is complted
    * [ ] models
        * [ ] Category
        * [ ] forage
        * [ ] foraer
        * [ ] ite,
    * [ ] date
        * [ ] data exception
        * [ ] forageFileReposiroty
        * [ ] forageRepository
        * [ ] ForagerFileRepositor
        * [ ] ForagerRepository
        * [ ] ItelFileRepository
        * [ ] ItemRepository
    * [ ] domain
        * [ ] ForagerService
        * [ ] ForageService
        * [ ] ItemService
        * [ ] Response
        * [ ] Result
    * [ ] UI
        * [ ] ConsoleIO
        * [ ] Controller
        * [ ] GenerateRequest
        * [ ] MainMenuOption
        * [ ] View


## Known incomplete features        2 hours
* [ ] Add a Forager          
* [ ] add a forage       
    * [ ] success message needs updating
* [ ]  report displaying kilo of items collected on one day         30 min
* [ ]  report displaying value of reach cat collected               30 min


## code repair
* [ ] models            30 min
* [ ]  Data
    * [ ] foragerepository 