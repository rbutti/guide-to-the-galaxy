# Merchant's Guide to the Galaxy

galactic-unit-converter is an java based application for converting galatic units to credits and values

### Tools and Technologies

galactic-unit-converter uses the following tools and technologies:

| Technology | Version |
| ------ | ------ |
| JDK | 1.9 |
| Junit | 4.12 |
| Maven | 4.0.0 |
| Eclipse | Oxygen |


### Setup

* Ensure Jdk 1.9 or above is installed on your system. If not, you can download the latest version from the below link. 
Please follow the instructions in the link for the setup
[JDK Installation](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* unzip the application to the folder of your choice.
* After you unzip the application, inside the [PATH TO APPLICATION]/guide-to-the-galaxy-master/deliverables folder you will find application executable with the name "galactic-unit-converter.jar"
* A sample input file for the application is also provided in the [PATH TO APPLICATION]/guide-to-the-galaxy-master/deliverables/input.txt

Sample Input file content
```
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
```
### Execution

* Open a terminal and navigate to the "[PATH TO APPLICATION]\guide-to-the-galaxy-master\deliverables" folder
```sh
$ cd [PATH TO APPLICATION FOLDER]\deliverables
```

* run the following command to execute the jar in the folder 
```sh
$ java -jar galactic-unit-converter.jar [OPTIONAL INPUT FILE PATH]
```

* The output will be printed on the termial 

##### Example

```
C:\>cd C:\Users\rbutti\guide-to-the-galaxy-master\deliverables

C:\Users\rbutti\guide-to-the-galaxy-master\deliverables>java -jar galactic-unit-converter.jar
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about

C:\Users\rbutti\guide-to-the-galaxy-master\deliverables>
```

### Problem Statement
[Problem Statement](/Problem Statement.docx)
