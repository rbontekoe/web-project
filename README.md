# Web-project Scala/Play


The surveillance project has been copied to this website build with Play according the book Modern Web Development in Scala by Denis Kalanin.

MacWire is used for dependency injection, and Akka for counting hits.

## Surveillance System
I am studying Scala Functional Programming and my goal now is to create let say a system to monitor elderly in a nursing home.
The system consists of Raspberry Pi Zero W hardware equipped with a camera and a central monitoring system. Currently, I vision the system as publisher/subscriber system, where Zero W devices post images. The system should raise the alarm where an elderly has not seen for a particular time after entering a room.
The Zero W will have Python/Flask software and periodically send images to the central monitoring system.
The central observing system will be built with Scala and process the images using an object recognition module to identify people.

## Use Case
<img src="https://github.com/rbontekoe/surveillance/blob/master/Surveillance%20System.png" />

## Output so far
Hello Play

Sunrise time: 07:45:44
Sunset time: 16:58:30
Temperature: 26.9
Atmospheric pressure: 1024.7
Humidity: 37.4
Requests: 3

==== Room info ===

Detected person: Mrs Neeltje
Apartment: 101
Owner: Mrs Neetje
Room: 16 - Bathroom
Room status: Warning

## Version
v0.1