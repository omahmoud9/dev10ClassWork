## Dont Wreck My House

## High level requierments
* [ ] View exisitng reservations for a host
* [ ] create a reservation for a guest w/ a host
* [ ] edit existing reservations
* [ ] cancel furture reservatons 

## Requierments

* [ ] view reservation
    * [ ] • The user may enter a value that uniquely identifies a host or they cansearch for a host and pick one out of a list .
    * [ ] if host is not found, display message
    * [ ] if host has no reservations display message
    * [ ] show all reservations for that host
        * [ ] guest, dates, totals ets
    * [ ] Sort reservatios in a meaningful way, chronological? upcoming first, past at the end?


* [ ] Make a Reservation
    * [ ] The user may enter a value that uniquely identifies a guest or they can search for a guest and pick one out of a list .
    * [ ] enter a value that uniquely identifies a host or they can search for a host and pick one out of a list .
    * [ ] Show all future reservations for that host so the administrator can choose available dates
    * [ ] Enter a start and end date for the reservation
* [ ] Calculate total, display summary, user confirmation. save on confirmation
* [ ] guest, host start and end date reuired
* [ ] existing host and guest
* [ ]  start date before end date
* [ ]  reservatons not overlaping
* [ ] start date in the future


* [ ] edit a reservation
    * [ ] find a reservation
    * [ ] edit start and end date only
    * [ ] recalc total, display summary and confirm
* [ ]  Guest host and dates reuiered
* [ ] guest and hosts already exist
* [ ] start date before end date
* [ ] no overlapping


* [ ] canel a reservation
    * [ ] find a reservation
    * [ ] shows futre reservations
    * [ ] displays success message
    * [ ] cannot canel past reservation


## Tech requierments
* [ ] Maven Project
* [ ] spring dependency
* [ ] fin math using BigDeciaml
* [ ] dates using LocalDate
* [ ] files represented in models
* [ ] reservation idents unique per host, ot across entire app



## code

* [ ] Models
    * [ ] guest
        * [ ] email
    * [ ] Host/Location
        * [ ] email
        * [ ] rental location
    * [ ] reservation
        * [ ] guest
        * [ ] host
        * [ ] Start date
        * [ ] end date


* [ ] Data Acess    2 hours
    * [ ] Reservations
        * [ ] no overlapping reservations
    * [ ] guest
        * [ ] unqiue email
    * [ ] host 
        * [ ] unique email

* [ ] Domain
    * [ ] Make reservation 
        * [ ] guest host start end date requiered
        * [ ] validate dates not overlapping
        * [ ] start date before end date
        * [ ] validate guest and host
        * [ ] get total
        * [ ] validate confirmation

    * [ ] Edit reservation
        * [ ] guest host start end date requiered
        * [ ]  validate new dates are not overlapping
        * [ ] only edit dates, not host or guest

    * [ ] Cancel reservation
        * [ ] validate start date is in the past

* [ ] UI
    * [ ] Main Menu
    * [ ] 0. Exit
    * [ ] 1. View Reservations for Host
        * [ ] Display reservations for a host, find by email
    * [ ] 2. Make a Reservation
        * [ ] ensure host/guest exist
        * [ ] dates are avaliable 
        * [ ] pricing
        * [ ] get user confirmation
    * [ ] 3. Edit a Reservation
        * [ ] search  host + guest
        * [ ] edit start or end date
        * [ ] display new total
        * [ ] confim with admin
    * [ ] 4. Cancel a Reservation
        * [ ] search host + guest email
        * [ ] start date in future
        * [ ] confium with admin
    