# Robotics Assigment 1

## Specs

### Car's design

- [Building Instructions](https://le-www-live-s.legocdn.com/sc/media/lessons/mindstorms-ev3/building-instructions/ev3-rem-driving-base-79bebfc16bd491186ea9c9069842155e.pdf)
- 3 wheeled
  - 2 in the front, not connected (seperate motors)
- caster wheel in the back (custom made)
- Car's width: 150mm (From wheel to wheel)

### Wheel

- Type: 43.2 x 22 ZR (Standard)
- Wheel diameter: 43.2mm
- Wheel width: 22mm
- Wheel distance: 63mm (From wheel's center to car's center)
- Motor A is weaker by about 1 degree/sec

### Route

- Distance: 2585mm
- [Planned Route](https://www.draw.io/#G1TtzG6nARdbF-WI7Pv5NPwUEFM1Ta0G-3)

Helpful Links:

- [Wheel Converter](http://ev3lessons.com/resources/wheelconverter/)

## Implementation

### LeJos (Java API)

- Motor
  - [Docs](http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/Motor.html)
- MovePilot
  - [Docs](http://www.lejos.org/ev3/docs/lejos/robotics/navigation/MovePilot.html)
  - `DifferentialChassis` was renamed to `WheeledChassis`
  - `setRobotSpeed()` was renamed to `setLinearSpeed()` (`setLinearSpeed()`, `setAngularSpeed()`)
- Navigator
  - [Docs](http://www.lejos.org/ev3/docs/lejos/robotics/navigation/Navigator.html)
  - Buggy, not working well!
    - Idea: [PoseProvider](http://www.lejos.org/ev3/docs/lejos/robotics/localization/PoseProvider.html)
