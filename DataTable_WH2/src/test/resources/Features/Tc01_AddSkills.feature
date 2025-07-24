
Feature:  I am automating orangeHrm application

Background: common reusable steps

Given user launch the browser
Then user enters URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"


Scenario Outline: TC01AddSkills record - creating skills record

And user enters login credentials

|Username|Password|
|Admin|admin123|

Then user go to skills page 
When user enters skill details as 

|SkillName|SkillDescription|
|java23|java23 description|
|java24|java24 description|
|java25|java25 description|
|java26|java26 description|

Then logout 
Then Close browser 



